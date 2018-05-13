package edu.fontys.kwetter.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.io.IOException
import java.util.concurrent.CopyOnWriteArrayList

@Component
class SocketHandler : TextWebSocketHandler() {
    var sessions = CopyOnWriteArrayList<WebSocketSession>()

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val mapper = ObjectMapper()

        for (webSocketSession in sessions) {
            val value = mapper.readValue<Map<*, *>>(message.payload)
            webSocketSession.sendMessage(TextMessage("Hello " + value.get("name") + " !"))
        }
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.add(session)
    }
}
