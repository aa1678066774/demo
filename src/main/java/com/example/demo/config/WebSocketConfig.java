package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.demo.webSocket.WebSocketServer;

@Configuration  
@EnableWebSocket
public class WebSocketConfig  implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry arg0) {
		// TODO Auto-generated method stub
		arg0.addHandler(webSocketServer(), "/webSocketServer/*"); 
	}
	
	@Bean
    public WebSocketHandler webSocketServer() {  
        return new WebSocketServer();  
    } 
}
