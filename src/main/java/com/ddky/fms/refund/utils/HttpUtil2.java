/**
 * 
 */
package com.ddky.fms.refund.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ddky.fms.refund.exception.BusinessException;
import com.ddky.fms.refund.model.param.SysParam;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhumingzhou
 * @date 2015年1月27日
 */
public class HttpUtil2 {

	
	private static final CloseableHttpClient httpClient;
    public static final String CHARSET = "UTF-8";
	private static final Logger logger = LoggerFactory.getLogger(HttpUtil2.class);
	private static final String APPLICATION_JSON = "application/json";
	private static final String CONTENT_TYPE_JSON = "text/json";
	private static final String APPLICATION_FORM = "application/x-www-form-urlencoded";
	private static ExecutorService executor = Executors.newFixedThreadPool(5);
//	private static final String MULTIPART_FORM_DATA = "multipart/form-data";
 
    static {
    	RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(60000).setConnectTimeout(60000).setSocketTimeout(60000).build(); 
        PoolingHttpClientConnectionManager pcm = new PoolingHttpClientConnectionManager();  
        //MaxTotal 值不应该太大  
        pcm.setMaxTotal(200);
        //DefaultMaxPerRoute 是路由的默认最大连接（该值默认为2），限制数量实际使用DefaultMaxPerRoute并非MaxTotal。  
        //设置过小无法支持大并发(ConnectionPoolTimeoutException: Timeout waiting for connection from pool)，路由是对maxTotal的细分。  
        pcm.setDefaultMaxPerRoute(pcm.getMaxTotal());//（目前只有一个路由，因此让他等于最大值）  
        ConnectionKeepAliveStrategy myStrategy = new ConnectionKeepAliveStrategy() {
			@Override
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				return 180 * 1000;
			}
			
		};
        httpClient = HttpClientBuilder.create().setConnectionManager(pcm).setDefaultRequestConfig(config).setKeepAliveStrategy(myStrategy).build();
    }
    
    public static String doDelete(String url, Map<String, String> params){
        return doDelete(url, params,CHARSET, false);
    }
    public static String doPut(String url, Map<String,String> params){
    	return doPut(url, params,CHARSET, false);
    }
    public static String doGet(String url, Map<String, String> params){
        return doGet(url, params,CHARSET, false);
    }
    public static String doPost(String url, Map<String, String> params){
        return doPost(url, params,CHARSET, false);
    }
    
    public static String doGetObj(String url, Map<String, Object> params){
    	return doGetObj(url, params,CHARSET, false);
    }
    public static String doPostObj(String url, Map<String, Object> params){
    	return doPostObj(url, params,CHARSET, false);
    }
    public static String doPostObj(String url, Map<String, Object> params,int timeout){
    	return doPostObj(url, params,CHARSET, false,timeout);
    }
    public static String doPostJSON(String url,String josnStr){
    	return doPostJSON(url, josnStr, false);
    }
    
    public static String doGet(String url, Map<String, String> params, boolean isExceptionThrow){
    	return doGet(url, params,CHARSET, isExceptionThrow);
    }
    public static String doPost(String url, Map<String, String> params, boolean isExceptionThrow){
    	return doPost(url, params,CHARSET, isExceptionThrow);
    }
    
    public static String doGetObj(String url, Map<String, Object> params, boolean isExceptionThrow){
    	return doGetObj(url, params,CHARSET, isExceptionThrow);
    }
    public static String doPostObj(String url, Map<String, Object> params, boolean isExceptionThrow){
    	return doPostObj(url, params,CHARSET, isExceptionThrow);
    }
    
    /**
     * 异步Get请求
     * @author zhumingzhou
     * @date 2018年10月29日
     * @param url
     * @param params
     */
    public static void doGetAsync(final String url, final Map<String, String> params) {
    	executor.execute(new Runnable() {
			
			@Override
			public void run() {
				doGet(url, params);
				
			}
		});
    }
    
    /**
     * 异步Post请求
     * @author zhumingzhou
     * @date 2018年10月29日
     * @param url
     * @param params
     */
    public static void doPostAsync(final String url, final Map<String, String> params) {
    	executor.execute(new Runnable() {
			
			@Override
			public void run() {
				doPost(url, params);
				
			}
		});
    }
    
    
    /**
     * HTTP Get 获取内容
     * @param url  请求的url地址 ?之前的地址
     * @param params 请求的参数
     * @param charset    编码格式
     * @return    页面内容
     */
    public static String doGet(String url,Map<String,String> params,String charset, boolean isExceptionThrow){
        if(StringUtils.isEmpty(url)){
            return null;
        }
        try {
            if(params != null && !params.isEmpty()){
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for(Map.Entry<String,String> entry : params.entrySet()){
                    String value = entry.getValue();
                    if(value != null){
                        pairs.add(new BasicNameValuePair(entry.getKey(),value));
                    }
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
            }
            HttpGet httpGet = new HttpGet(url);
            System.out.println(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
	            int statusCode = response.getStatusLine().getStatusCode();
	            if (statusCode != 200) {
	                httpGet.abort();
	                logger.error("HTTP连接异常    HttpClient,error status code :" + statusCode);
	            }
	            HttpEntity entity = response.getEntity();
	            String result = null;
	            if (entity != null){
	                result = EntityUtils.toString(entity, "utf-8");
	            }
	            EntityUtils.consume(entity);
	            return result;
            }
            finally {
            	response.close();
            }
        } catch (Exception e) {
        	logger.error("HTTP连接异常  " + e.getMessage());
        	if(isExceptionThrow) {
        		throw new BusinessException("HTTP连接异常  " + e.getMessage(), e);
        	}
        }
        return null;
    }
    

    /**
     * HTTP Delete 删除内容
     * @param url  请求的url地址 ?之前的地址
     * @param params 请求的参数
     * @param charset    编码格式
     * @return    页面内容
     */
    public static String doDelete(String url,Map<String,String> params,String charset, boolean isExceptionThrow){
        if(StringUtils.isEmpty(url)){
            return null;
        }
        try {
            if(params != null && !params.isEmpty()){
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for(Map.Entry<String,String> entry : params.entrySet()){
                    String value = entry.getValue();
                    if(value != null){
                        pairs.add(new BasicNameValuePair(entry.getKey(),value));
                    }
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
            }
            HttpDelete httpDelete = new HttpDelete(url);
            CloseableHttpResponse response = httpClient.execute(httpDelete);
            try {
	            int statusCode = response.getStatusLine().getStatusCode();
	            if (statusCode != 200) {
	            	httpDelete.abort();
	                logger.error("HTTP连接异常    HttpClient,error status code :" + statusCode);
	            }
	            HttpEntity entity = response.getEntity();
	            String result = null;
	            if (entity != null){
	                result = EntityUtils.toString(entity, "utf-8");
	            }
	            EntityUtils.consume(entity);
	            return result;
            }
            finally {
            	response.close();
            }
        } catch (Exception e) {
        	logger.error("HTTP连接异常  " + e.getMessage());
        	if(isExceptionThrow) {
        		throw new BusinessException("HTTP连接异常  " + e.getMessage(), e);
        	}
        }
        return null;
    }
     
    /**
     * HTTP Post 获取内容
     * @param url  请求的url地址 ?之前的地址
     * @param params 请求的参数
     * @param charset    编码格式
     * @return    页面内容
     */
    public static String doPost(String url,Map<String,String> params,String charset, boolean isExceptionThrow){
        if(StringUtils.isEmpty(url)){
            return null;
        }
        try {
        	logger.info("------begin------请求地址：" + url);
            List<NameValuePair> pairs = null;
            if(params != null && !params.isEmpty()){
                pairs = new ArrayList<NameValuePair>(params.size());
                for(Map.Entry<String,String> entry : params.entrySet()){
                	logger.info(entry.getKey() + "=" + entry.getValue());
                    String value = entry.getValue();
                    if(value != null){
                        pairs.add(new BasicNameValuePair(entry.getKey(),value));
                    }
                }
            }
            logger.info("------end------");
            HttpPost httpPost = new HttpPost(url);
            if(pairs != null && pairs.size() > 0){
                httpPost.setEntity(new UrlEncodedFormEntity(pairs,CHARSET));
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            try {
	            int statusCode = response.getStatusLine().getStatusCode();
	            if (statusCode != 200) {
	                httpPost.abort();
	                logger.error("HTTP连接异常    HttpClient,error status code :" + statusCode);
	            }
	            HttpEntity entity = response.getEntity();
	            String result = null;
	            if (entity != null){
	                result = EntityUtils.toString(entity, "utf-8");
	            }
	            EntityUtils.consume(entity);
	            return result;
            } finally {
            	response.close();
            }
        } catch (Exception e) {
        	logger.error("HTTP连接异常  " + e.getMessage());
        	if(isExceptionThrow) {
        		throw new BusinessException("HTTP连接异常  " + e.getMessage(), e);
        	}
        }
        return null;
    }
    
    /**
     * HTTP Post 获取内容
     * @param url  请求的url地址 ?之前的地址
     * @return    页面内容
     */
    public static String doPostJSON(String url,String josnStr, boolean isExceptionThrow){
        if(StringUtils.isEmpty(url) || StringUtils.isEmpty(josnStr)){
            return null;
        }
        try {            
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
            StringEntity se = new StringEntity(josnStr, "utf-8");
            se.setContentType(CONTENT_TYPE_JSON);
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            httpPost.setEntity(se);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            try {
	            int statusCode = response.getStatusLine().getStatusCode();
	            if (statusCode != 200) {
	                httpPost.abort();
	                logger.error("HTTP连接异常    HttpClient,error status code :" + statusCode);
	            }
	            HttpEntity entity = response.getEntity();
	            String result = null;
	            if (entity != null){
	                result = EntityUtils.toString(entity, "utf-8");
	            }
	            EntityUtils.consume(entity);
	            return result;
            } finally {
            	response.close();
            }
        } catch (Exception e) {
        	logger.error("HTTP连接异常  " + e.getMessage());
        	if(isExceptionThrow) {
        		throw new BusinessException("HTTP连接异常  " + e.getMessage(), e);
        	}
        }
        return null;
    }
    
    /***
     * POST提交文件
     * @return
     * @throws IOException 
     * @throws ClientProtocolException 
     */
	public static String postFile(String url,Map<String,Object> params,String fileName, boolean isExceptionThrow){
		
		HttpPost post = new HttpPost(url);
		
		// 
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		
		Set<String> pNames = params.keySet();
		
		//构建参数信息
		for (String key : pNames) {
			
			Object obj = params.get(key);
			if (obj instanceof String) {//普通文本
				builder.addTextBody(key, obj.toString(), ContentType.TEXT_PLAIN);
			}
			
			if (obj instanceof Integer) {//普通文本
				builder.addTextBody(key, obj.toString(), ContentType.TEXT_PLAIN);
			}
			
			if (obj instanceof Long) {//普通文本
				builder.addTextBody(key, obj.toString(), ContentType.TEXT_PLAIN);
			}
			
			if (obj instanceof byte[]) {//byte数组的处理
				builder.addBinaryBody(key, (byte[])obj, ContentType.DEFAULT_BINARY, fileName);
			}
		}
		
		
		// 
		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			
			try {
	            int statusCode = response.getStatusLine().getStatusCode();
	            if (statusCode != 200) {
	            	post.abort();
	                logger.error("HTTP连接异常    HttpClient,error status code :" + statusCode);
	            }
	            HttpEntity entity2 = response.getEntity();
	            String result = null;
	            if (entity2 != null){
	                result = EntityUtils.toString(entity2, "utf-8");
	            }
	            EntityUtils.consume(entity2);
	            return result;
	        } finally {
	        	response.close();
	        }
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			if(isExceptionThrow) {
        		throw new BusinessException( e.getMessage(), e);
        	}
		} catch (IOException e) {
			e.printStackTrace();
			if(isExceptionThrow) {
        		throw new BusinessException( e.getMessage(), e);
        	}
		}
		
		
		
		return null;
          
    }
	
	/***
     * POST提交文件
     * @return
     * @throws IOException 
     * @throws ClientProtocolException 
     */
	public static String doPostFile(String url,byte[] content, boolean isExceptionThrow){
		HttpPost post = new HttpPost(url);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addBinaryBody("file", content,ContentType.create("image/png"),"1.png");
		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			CloseableHttpResponse response = httpClient.execute(post);			
			try {
	            int statusCode = response.getStatusLine().getStatusCode();
	            if (statusCode != 200) {
	            	post.abort();
	                logger.error("HTTP连接异常    HttpClient,error status code :" + statusCode);
	            }
	            HttpEntity entity2 = response.getEntity();
	            String result = null;
	            if (entity2 != null){
	                result = EntityUtils.toString(entity2, "utf-8");
	            }
	            EntityUtils.consume(entity2);
	            return result;
	        } finally {
	        	response.close();
	        }
			
		} catch (ClientProtocolException e) {
			logger.error("上传文件异常: ",e);
			if(isExceptionThrow) {
        		throw new BusinessException( e.getMessage(), e);
        	}
		} catch (IOException e) {
			logger.error("上传文件异常: ",e);
			if(isExceptionThrow) {
        		throw new BusinessException( e.getMessage(), e);
        	}
		}
		return null;
    }
	/**
	 * HTTP Get 获取内容
	 * @param url  请求的url地址 ?之前的地址
	 * @param params 请求的参数
	 * @param charset    编码格式
	 * @return    页面内容
	 */
	public static String doGetObj(String url,Map<String,Object> params,String charset, boolean isExceptionThrow){
		if(StringUtils.isEmpty(url)){
			return null;
		}
		try {
			if(params != null && !params.isEmpty()){
				List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
				for(Map.Entry<String,Object> entry : params.entrySet()){
					Object value = entry.getValue();
					if(value != null){
						pairs.add(new BasicNameValuePair(entry.getKey(),String.valueOf(value)));
					}
				}
				url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
			}
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(httpGet);
			try {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode != 200) {
					httpGet.abort();
					logger.error("HTTP连接异常    HttpClient,error status code :" + statusCode);
				}
				HttpEntity entity = response.getEntity();
				String result = null;
				if (entity != null){
					result = EntityUtils.toString(entity, "utf-8");
				}
				EntityUtils.consume(entity);
				return result;
			}
			finally {
				response.close();
			}
		} catch (Exception e) {
			logger.error("HTTP连接异常  " + e.getMessage());
			if(isExceptionThrow) {
        		throw new BusinessException("HTTP连接异常  " + e.getMessage(), e);
        	}
		}
		return null;
	}
	
	/**
	 * HTTP Post 获取内容
	 * @param url  请求的url地址 ?之前的地址
	 * @param params 请求的参数
	 * @param charset    编码格式
	 * @return    页面内容
	 */
	public static String doPostObj(String url,Map<String,Object> params,String charset, boolean isExceptionThrow){
		if(StringUtils.isEmpty(url)){
			return null;
		}
		try {
			List<NameValuePair> pairs = null;
			if(params != null && !params.isEmpty()){
				pairs = new ArrayList<NameValuePair>(params.size());
				for(Map.Entry<String,Object> entry : params.entrySet()){
					Object value = entry.getValue();
					if(value != null){
						pairs.add(new BasicNameValuePair(entry.getKey(),String.valueOf(value)));
					}
				}
			}
			HttpPost httpPost = new HttpPost(url);
			if(pairs != null && pairs.size() > 0){
				httpPost.setEntity(new UrlEncodedFormEntity(pairs,CHARSET));
			}
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode != 200) {
					httpPost.abort();
					logger.error("HTTP连接异常    HttpClient,error status code :" + statusCode);
				}
				HttpEntity entity = response.getEntity();
				String result = null;
				if (entity != null){
					result = EntityUtils.toString(entity, "utf-8");
				}
				EntityUtils.consume(entity);
				return result;
			} finally {
				response.close();
			}
		} catch (Exception e) {
			logger.error("HTTP连接异常  " + e.getMessage());
			if(isExceptionThrow) {
        		throw new BusinessException("HTTP连接异常  " + e.getMessage(), e);
        	}
		}
		return null;
	}
	/**
	 * HTTP Post 获取内容
	 * @param url  请求的url地址 ?之前的地址
	 * @param params 请求的参数
	 * @param charset    编码格式
	 * @return    页面内容
	 */
	public static String doPostObj(String url,Map<String,Object> params,String charset, boolean isExceptionThrow,int timeout){
		if(StringUtils.isEmpty(url)){
			return null;
		}
		try {
			List<NameValuePair> pairs = null;
			if(params != null && !params.isEmpty()){
				pairs = new ArrayList<NameValuePair>(params.size());
				for(Map.Entry<String,Object> entry : params.entrySet()){
					Object value = entry.getValue();
					if(value != null){
						pairs.add(new BasicNameValuePair(entry.getKey(),String.valueOf(value)));
					}
				}
			}
			HttpPost httpPost = new HttpPost(url);
			if(pairs != null && pairs.size() > 0){
				httpPost.setEntity(new UrlEncodedFormEntity(pairs,CHARSET));
			}
			RequestConfig requestConfig = RequestConfig.custom()    
			        .setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)    
			        .setSocketTimeout(timeout).build();    
			httpPost.setConfig(requestConfig); 
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode != 200) {
					httpPost.abort();
					logger.error("HTTP连接异常    HttpClient,error status code :" + statusCode);
				}
				HttpEntity entity = response.getEntity();
				String result = null;
				if (entity != null){
					result = EntityUtils.toString(entity, "utf-8");
				}
				EntityUtils.consume(entity);
				return result;
			} finally {
				response.close();
			}
		} catch (Exception e) {
			logger.error("HTTP连接异常:" + url + "\n" + e.getMessage());
			if(isExceptionThrow) {
        		throw new BusinessException("HTTP连接异常  " + e.getMessage(), e);
        	}
		}
		return null;
	}
	public static String doPut(String url,Map<String,String> params,String charset, boolean isExceptionThrow){
        if(StringUtils.isEmpty(url)){
            return null;
        }
        try {
            List<NameValuePair> pairs = null;
            if(params != null && !params.isEmpty()){
                pairs = new ArrayList<NameValuePair>(params.size());
                for(Map.Entry<String,String> entry : params.entrySet()){
                    String value = entry.getValue();
                    if(value != null){
                        pairs.add(new BasicNameValuePair(entry.getKey(),value));
                    }
                }
            }
            HttpPut httpPut = new HttpPut(url);
            httpPut.addHeader("Content-Type", APPLICATION_FORM);
            if(pairs != null && pairs.size() > 0){
            	httpPut.setEntity(new UrlEncodedFormEntity(pairs,CHARSET));
            }
            CloseableHttpResponse response = httpClient.execute(httpPut);
            try {
	            int statusCode = response.getStatusLine().getStatusCode();
	            if (statusCode != 200) {
	            	httpPut.abort();
	                logger.error("HTTP连接异常    HttpClient,error status code :" + statusCode);
	            }
	            HttpEntity entity = response.getEntity();
	            String result = null;
	            if (entity != null){
	                result = EntityUtils.toString(entity, "utf-8");
	            }
	            EntityUtils.consume(entity);
	            return result;
            } finally {
            	response.close();
            }
        } catch (Exception e) {
        	logger.error("HTTP连接异常  " + e.getMessage());
        	if(isExceptionThrow) {
        		throw new BusinessException("HTTP连接异常  " + e.getMessage(), e);
        	}
        }
        return null;
    }
}
