package com.ddky.fms.refund.utils;

import com.ddky.fms.refund.exception.BusinessException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author a
 */
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static final String DEFAULT_CHARSET = "utf-8";
    public static final String CONTENT_TYPE_XML = "application/xml";

    /**
     * 信任所有证书
     */
    private static final X509TrustManager trustAllManager = new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

    /**
     * 发送https请求
     * @param uri
     * @param stringEntity
     * @return
     */
    public static String postXmlRequest(String uri, String stringEntity) {
        CloseableHttpClient httpClient = createHttpsClient();
        HttpPost post = new HttpPost(uri);
        post.addHeader("Accept", DEFAULT_CHARSET);
        post.addHeader("Content-Type", CONTENT_TYPE_XML);
        post.addHeader("charset", DEFAULT_CHARSET);
        HttpEntity requestEntity = new StringEntity(stringEntity,DEFAULT_CHARSET);
        post.setEntity(requestEntity);
        try (CloseableHttpResponse httpResponse = httpClient.execute(post)){
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            logger.info("statusCode = {} for {}", statusCode, uri);
            HttpEntity entity = httpResponse.getEntity();
            return EntityUtils.toString(entity, DEFAULT_CHARSET);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return "";
    }

    private static HttpPost createHttpPost(String uri, String contentType) {
        HttpPost post = new HttpPost(uri);
        post.addHeader("Accept", contentType);
        post.addHeader("Content-Type", contentType);
        post.addHeader("charset", DEFAULT_CHARSET);
        return post;
    }

    private static CloseableHttpClient createHttpsClient() {
        try {
            HttpClientBuilder clientBuilder = HttpClientBuilder.create();
            clientBuilder.setSSLContext(createSSLContext("TLS", new TrustManager[] { trustAllManager }));
            clientBuilder.setSchemePortResolver(new DefaultSchemePortResolver());
            return clientBuilder.build();
        } catch (Exception e) {
            throw new BusinessException("自定义HttpClientUtil创建http客户端出现异常！", e);
        }
    }

    private static SSLContext createSSLContext(String protocol, TrustManager[] trustMgrs) throws KeyManagementException, NoSuchAlgorithmException {
        // 创建TLS安全上下文.
        SSLContext sslCtx = SSLContext.getInstance(protocol);
        sslCtx.init(null, trustMgrs, null);
        return sslCtx;
    }

}
