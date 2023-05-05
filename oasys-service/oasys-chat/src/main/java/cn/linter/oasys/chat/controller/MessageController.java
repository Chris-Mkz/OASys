package cn.linter.oasys.chat.controller;

import cn.linter.oasys.chat.entity.Message;
import cn.linter.oasys.chat.service.MessageService;
import cn.linter.oasys.common.entity.Page;
import cn.linter.oasys.common.entity.Result;
import cn.linter.oasys.common.entity.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 聊天消息控制器
 * @author ChrisMo
 * @since 2023/1/5
 */
@RestController
@RequestMapping("messages")
public class MessageController {
    @Resource
    private  MessageService messageService;


    @GetMapping
    public Result<Page<Message>> listMessages(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,
                                              @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end,
                                              @RequestParam(defaultValue = "0") int pageNumber,
                                              @RequestParam(defaultValue = "10") int pageSize) {
        org.springframework.data.domain.Page<Message> messages = messageService.listMessage(start, end, pageNumber, pageSize);
        return Result.of(ResultStatus.SUCCESS, Page.of(messages.getContent(), messages.getTotalElements()));
    }

}
