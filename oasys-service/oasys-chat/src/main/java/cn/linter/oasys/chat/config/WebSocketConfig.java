package cn.linter.oasys.chat.config;

import cn.linter.oasys.chat.handler.ChatWebSocketHandler;
import cn.linter.oasys.chat.interceptor.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.Resource;

/**
 * WebSocket配置
 * @author ChrisMo
 * @since 2022/11/17
 */

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Resource
    private ChatWebSocketHandler chatWebSocketHandler;
    @Resource
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatWebSocketHandler, "/chat")
                .addInterceptors(authorizationInterceptor).setAllowedOrigins("*");
    }

}
