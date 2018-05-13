package edu.fontys.kwetter.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import java.io.IOException
import java.util.concurrent.CopyOnWriteArrayList
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker


@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : AbstractWebSocketMessageBrokerConfigurer() {

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/stomp").setAllowedOrigins("*").withSockJS()
    }

    override fun configureMessageBroker(config: MessageBrokerRegistry) {
        config.enableSimpleBroker("/")
    }

}
