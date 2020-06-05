package com.ddky.fms.refund.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ddky.fms.refund.utils.xml.DateConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;


/**
 * 输出xml和解析xml的工具类
 * @author huoxinpeng
 *
 */
public class XmlUtils{
	private static Log log = LogFactory.getLog(XmlUtils.class);
	
	/**
	 * java 转换成xml
	 * @Title: toXml 
	 * @Description:  
	 * @param obj 对象实例
	 * @return String xml字符串
	 */
	public static String toXml(Object obj){
		XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
		xstream.registerConverter(new DateConverter());
		xstream.processAnnotations(obj.getClass()); //通过注解方式的，一定要有这句话
		return xstream.toXML(obj);
	}
	
	/**
	 *  将传入xml文本转换成Java对象
	 * @Title: toBean 
	 * @Description:  
	 * @param xmlStr
	 * @param cls  xml对应的class类
	 * @return T   xml对应的class类的实例对象
	 * 
	 * 调用的方法实例：PersonBean person=XmlUtil.toBean(xmlStr, PersonBean.class);
	 */
	@SuppressWarnings("unchecked")
	public static <T> T  toBean(String xmlStr,Class<T> cls){
		//注意：不是new Xstream(); 否则报错：java.lang.NoClassDefFoundError: org/xmlpull/v1/XmlPullParserFactory
		XStream xstream=new XStream(new DomDriver());
		xstream.processAnnotations(cls);
		T obj=(T)xstream.fromXML(xmlStr);
		return obj;			
	} 

   /**
     * 写到xml文件中去
     * @Title: writeXMLFile 
     * @Description:  
     * @param obj 对象
     * @param absPath 绝对路径
     * @param fileName	文件名
     * @return boolean
     */
  
    public static boolean toXMLFile(Object obj, String absPath, String fileName ){
    	String strXml = toXml(obj);
    	String filePath = absPath + fileName;
    	File file = new File(filePath);
    	if(!file.exists()){
    		try {
				file.createNewFile();
			} catch (IOException e) {
				log.error("创建{"+ filePath +"}文件失败!!!" + e.getMessage());
				return false ;
			}
    	}// end if 
    	OutputStream ous = null ;
		try {
			ous = new FileOutputStream(file);
			ous.write(strXml.getBytes());
			ous.flush();
		} catch (Exception e1) {
			log.error("写{"+ filePath +"}文件失败!!!" + e1.getMessage());
			return false;
		}finally{
			if(ous != null )
				try {
					ous.close();
				} catch (IOException e) {
					log.error("写{"+ filePath +"}文件关闭输出流异常!!!" + e.getMessage());
				}
		}
		return true ;
    }
    
    /**
     * 从xml文件读取报文
     * @Title: toBeanFromFile 
     * @Description:  
     * @param absPath 绝对路径
     * @param fileName 文件名
     * @param cls
     * @throws Exception 
     * @return T
     */
    @SuppressWarnings("unchecked")
	public static <T> T  toBeanFromFile(String absPath, String fileName,Class<T> cls) throws Exception{
    	String filePath = absPath +fileName;
    	InputStream ins = null ;
    	try {
    		ins = new FileInputStream(new File(filePath ));
		} catch (Exception e) {
			throw new Exception("读{"+ filePath +"}文件失败！", e);
		}
    	
    	//String encode = "";
		XStream xstream=new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
		xstream.processAnnotations(cls);
		T obj =null;
		try {
			obj = (T)xstream.fromXML(ins);
		} catch (Exception e) {
			throw new Exception("解析{"+ filePath +"}文件失败！",e);
		}
		if(ins != null)
			ins.close();
		return obj;			
    } 
	
    /**
     * 转换成json对象
     * @param obj
     * @return
     */
    public static String toJson(Object obj){
    	XStream xstream=new XStream(new JsonHierarchicalStreamDriver());
    	xstream.registerConverter(new DateConverter());
    	//xstream.registerConverter(new NullConverter());
    	xstream.processAnnotations(obj.getClass());
    	return xstream.toXML(obj);
    }
}