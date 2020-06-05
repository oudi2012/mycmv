/**
 * 
 */
package com.ddky.fms.refund.utils;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * JSON转换工具类
 * 
 * @author guotianchi
 * 
 */
public class JSONUtil {
	static Logger logger = Logger.getLogger(JSONUtil.class);

	
	public Object json2Object(String jsonStr, String cls) {
		try {
			return json2Object(jsonStr, Class.forName(cls));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object json2Object(String jsonStr, Class<?> cls) {
		ObjectMapper om = new ObjectMapper();
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);  
		try {
			return om.readValue(jsonStr, cls);
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public <T> T json2Object(String jsonStr, TypeReference<T> ref){
		ObjectMapper om = new ObjectMapper();
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);  
		try {
			return om.readValue(jsonStr, ref);
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将对象转换成json串
	 * @param obj 对象
	 * @return json格式字符串
	 */
	public String Object2JSONStr(Object obj) {
		ObjectMapper om = new ObjectMapper();
		try {
			return om.writeValueAsString(obj);
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public static String object2JsonAsString(Object obj){
		ObjectMapper om = new ObjectMapper();
		try{
			return om.writeValueAsString(obj);
		}catch(Exception e){
			logger.error(e);
		}
		return null;
	}
}
