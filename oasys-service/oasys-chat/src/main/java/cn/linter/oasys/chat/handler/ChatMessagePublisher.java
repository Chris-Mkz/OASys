package cn.linter.oasys.chat.handler;

import cn.linter.oasys.chat.entity.Message;
import cn.linter.oasys.chat.repository.MessageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Producer;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 消息发布器
 * @author ChrisMo
 * @date 2023/1/2
 */
@Slf4j
@Component
public class ChatMessagePublisher {

    @Resource
    private MessageRepository messageRepository;
    @Resource
    private Producer<String> pulsarPublisher;
    @Resource
    private ObjectMapper objectMapper;

    public void publish(Map<String, Object> attributes, Message.Type type, String content) {
        Message message = Message.builder()
                .type(type)
                .content(content)
                .username((String) attributes.get("username"))
                .fullName((String) attributes.get("fullName"))
                .profilePicture((String) attributes.get("profilePicture"))
                .createTime(LocalDateTime.now())
                .build();
        if (message.getType() != Message.Type.SYSTEM) {
            messageRepository.save(message);
        }
        try {
            String messageString = objectMapper.writeValueAsString(message);
            pulsarPublisher.sendAsync(messageString);
        } catch (JsonProcessingException e) {
            log.error("Json process error", e);
        }
    }

}
