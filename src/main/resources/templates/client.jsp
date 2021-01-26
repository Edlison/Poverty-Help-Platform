<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="ctxpath"
       value="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset=UTF-8">
    <title>登录测试</title>
</head>
<body>
<h2>Hello World! Web Socket by Spring</h2>
<div>
    <span>sessionId:</span>
    <%
        HttpSession s= request.getSession();
        out.println(s.getId());
    %>
</div>

<input id="sessionId" type="hidden" value="<%=session.getId() %>" />
<input id="text" type="text" />
<button onclick="send()">发送消息</button>
<hr />
<button onclick="closeWebSocket()">关闭WebSocket连接</button>
<hr />
<div id="message"></div>
</body>
<script type="text/javascript" src="http://localhost:8088/static/js/sockjs-0.3.min.js"></script>
<script type="text/javascript">
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    //判断当前浏览器是否支持WebSocket
    if('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8088/websocket/webSocketBySpring/customWebSocketHandler?mchNo="+ 123);
    } else if('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://localhost:8088/websocket/webSocketBySpring/customWebSocketHandler?mchNo="+ 123);
    } else {
        websocket = new SockJS("http://localhost:8088/websocket/sockjs/webSocketBySpring/customWebSocketHandler?mchNo="+ 123);
    }
    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        websocket.send(message);
    }
</script>
</html>