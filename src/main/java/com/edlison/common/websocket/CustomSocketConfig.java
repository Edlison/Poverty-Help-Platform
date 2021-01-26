package com.edlison.common.websocket;

/**
 * CustomSocketConfig
 *
 * @Author Edlison
 * @Date 1/22/21 17:41
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * websocket的配置类
 * @ClassName: CustomWebSocketConfig
 * @Description: TODO
 * @author OnlyMate
 * @Date 2018年8月16日 下午3:17:26
 *
 */
@Configuration
@EnableWebSocket
public class CustomSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(customWebSocketHandler(), "/webSocketBySpring/customWebSocketHandler").addInterceptors(new CustomSocketInterceptor()).setAllowedOrigins("*");
        registry.addHandler(customWebSocketHandler(), "/sockjs/webSocketBySpring/customWebSocketHandler").addInterceptors(new CustomSocketInterceptor()).setAllowedOrigins("*").withSockJS();
    }

    @Bean
    public WebSocketHandler customWebSocketHandler() {
        return new CustomSocketHandler();
    }
}
