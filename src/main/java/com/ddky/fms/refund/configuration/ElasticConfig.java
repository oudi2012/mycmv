package com.ddky.fms.refund.configuration;

import com.ddky.fms.refund.constants.ElasticConstants;
import lombok.Data;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/***
 * @author whk
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "elastic")
public class ElasticConfig {

    private static final Logger logger = LoggerFactory.getLogger(ElasticConfig.class);

    private String host;
    private int port;
    private int pool;
    @Value("${elastic.cluster.name}")
    private String clusterName;

    @Bean(name = "transportClient")
    public TransportClient transportClient() {
        logger.info("Elasticsearch 初始化开始 ... ");
        //配置信息
        Settings esSetting = Settings.builder()
                .put(ElasticConstants.CLUSTER_NAME, clusterName)
                .put(ElasticConstants.CLUSTER_TRANSPORT_SNIFF, true)
                .put(ElasticConstants.THREAD_POOL_SEARCH_SIZE, pool)
                .build();
        //配置信息
        TransportClient transportClient = new PreBuiltTransportClient(esSetting);
        try {
            transportClient = new PreBuiltTransportClient(esSetting);
            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName(host), port);
            transportClient.addTransportAddress(transportAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transportClient;
    }
}
