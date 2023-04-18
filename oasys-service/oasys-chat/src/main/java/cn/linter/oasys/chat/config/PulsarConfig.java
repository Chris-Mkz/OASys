package cn.linter.oasys.chat.config;

import cn.linter.oasys.chat.handler.ChatMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author ChrisMo
 * @since 2022/11/20
 */
@Slf4j
@Component
public class PulsarConfig {

    @Value("${pulsar.host}")
    private String pulsarHost;
    @Value("${pulsar.topic}")
    private String pulsarTopic;
    @Value("${pulsar.subscription}")
    private String pulsarSubscription;

    @Bean
    public PulsarClient pulsarClient() {
        try {
            return PulsarClient.builder()
                    .serviceUrl(pulsarHost)
                    .build();
        } catch (PulsarClientException e) {
            log.error("Pulsar连接失败", e);
            return null;
        }
    }


    @Bean
    public Producer<String> producer(PulsarClient pulsarClient) {
        try {
            return pulsarClient.newProducer(Schema.STRING)
                    .topic(pulsarTopic)
                    .create();
        } catch (PulsarClientException e) {
            log.error("Pulsar生产者创建失败", e);
            return null;
        }
    }

    @Bean
    public Consumer<String> consumer(PulsarClient pulsarClient, ChatMessageListener messageListener) {
        try {
            return pulsarClient.newConsumer(Schema.STRING)
                    .topic(pulsarTopic)
                    .subscriptionName(pulsarSubscription)
                    .messageListener(messageListener)
                    .subscribe();
        } catch (PulsarClientException e) {
            log.error("Pulsar生产者创建失败", e);
            return null;
        }
    }

}
