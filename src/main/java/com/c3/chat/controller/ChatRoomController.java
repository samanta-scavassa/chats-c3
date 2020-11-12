package com.c3.chat.controller;

import com.c3.chat.exceptions.ChatRoomException;
import com.c3.chat.json.ChatRoomRequest;
import com.c3.chat.json.WebSocketResponseJson;
import com.c3.chat.model.ChatMessage;
import com.c3.chat.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@CrossOrigin
@ServerEndpoint("/chat/{chatId}")
public class ChatRoomController {

    @Autowired
    private ChatMessageService chatMessageService;

    @OnMessage
    public void receiveMessage(String message, Session session,
                               @PathParam("chatId") Long chatId,
                               @RequestBody ChatRoomRequest request){

        try {

            ChatMessage chatMessage = new ChatMessage(chatId, message);

            chatMessageService.saveChatMessage(chatMessage);

            WebSocketResponseJson response = new WebSocketResponseJson(request.getFriendId(), message);

            session.getBasicRemote().sendObject(response);

        } catch(RuntimeException | IOException | EncodeException e) {
            throw new ChatRoomException("Erro ao enviar mensagem", e.getCause());
        }

    }
}
