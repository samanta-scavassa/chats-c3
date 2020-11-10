package com.c3.chat.controller;

import com.c3.chat.json.WebSocketResponseJson;
import com.c3.chat.model.ChatID;
import com.c3.chat.model.ChatMessage;
import com.c3.chat.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/chat/{userId}/{friendId}")
public class ChatRoomController {

    @Autowired
    private ChatMessageService chatMessageService;

    @OnMessage
    public void receiveMessage(String message, Session session, @PathParam("userId") Long userId, @PathParam("friendId") Long friendId){

        try {

            ChatID id = new ChatID(userId, friendId);
            ChatMessage chatMessage = new ChatMessage(id, message);

            chatMessageService.saveChatMessage(chatMessage);

            WebSocketResponseJson response = new WebSocketResponseJson(friendId, message);

            session.getBasicRemote().sendObject(response);

        } catch(RuntimeException | IOException | EncodeException e) {
            System.out.println("Erro ao enviar mensagem");
        }

    }
}
