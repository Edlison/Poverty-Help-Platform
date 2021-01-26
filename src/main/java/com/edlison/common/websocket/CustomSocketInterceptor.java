package com.edlison.common.websocket;

/**
 * CustomSocketInterceptor
 *
 * @Author Edlison
 * @Date 1/22/21 17:39
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * WebSocket握手时的拦截器
 * @ClassName: CustomWebSocketInterceptor
 * @Description: TODO
 * @author OnlyMate
 * @Date 2018年8月16日 下午3:17:04
 *
 */
@Slf4j
public class CustomSocketInterceptor implements HandshakeInterceptor {
    /**
     * 关联HeepSession和WebSocketSession，
     * beforeHandShake方法中的Map参数 就是对应websocketSession里的属性
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> map) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            log.info("*****beforeHandshake******");
            HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) request).getServletRequest();
            HttpSession session = httpServletRequest.getSession(true);

            log.info("mchNo：{}", httpServletRequest.getParameter("mchNo"));
            if (session != null) {

                map.put("sessionId",session.getId());
                map.put("mchNo", httpServletRequest.getParameter("mchNo"));
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        log.info("******afterHandshake******");
    }
}
