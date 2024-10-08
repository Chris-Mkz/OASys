package cn.linter.oasys.chat.service.impl;

import cn.linter.oasys.chat.entity.Message;
import cn.linter.oasys.chat.repository.MessageRepository;
import cn.linter.oasys.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 聊天消息服务实现类
 * @author ChrisMo
 * @since 2023/1/5
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository repository;

    @Override
    public Page<Message> listMessage(LocalDateTime start, LocalDateTime end, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        if (start == null && end == null) {
            return repository.findAll(pageable);
        }
        if (start == null) {
            return repository.findAllByCreateTimeBefore(end, pageable);
        }
        if (end == null) {
            return repository.findAllByCreateTimeAfter(start, pageable);
        }
        return repository.findAllByCreateTimeBetween(start, end, pageable);
    }

}
