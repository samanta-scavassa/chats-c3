package com.c3.chat.controller;

import com.c3.chat.config.MessageDecoder;
import com.c3.chat.config.MessageEncoder;
import com.c3.chat.exceptions.ChatRoomException;
import com.c3.chat.json.ChatRoomRequest;
import com.c3.chat.json.WebSocketResponseJson;
import com.c3.chat.model.Chat;
import com.c3.chat.model.ChatMessage;
import com.c3.chat.model.Message;
import com.c3.chat.service.ChatMessageService;
import com.c3.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@CrossOrigin
@Component
@ServerEndpoint(value="/chat/room", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class ChatRoomController {

    private Session session;
    private static final Set<ChatRoomController> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> chatMessage = new HashMap<>();

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private ChatService chatService;

    @OnOpen
    public void onOpen(Session session) throws IOException, EncodeException {

        this.session = session;
        chatEndpoints.add(this);

        Message message = new Message();
        message.setContent("Connected!");
        broadcast(message);
    }

    @OnMessage
    public void receiveMessage(Message message, Session session
//                               @PathParam("chatId") Long chatId,
//                               @RequestBody ChatRoomRequest request
                               ) throws IOException, EncodeException {
        message.setFrom(chatMessage.get(session.getId()));
        System.out.println(message);
        broadcast(message);
//        try {
//
//            Chat chat = chatService.findbyId(chatId).get();
//            ChatMessage chatMessage = new ChatMessage(chat, request.getMessage());
//            chatMessageService.saveChatMessage(chatMessage);
//
//            WebSocketResponseJson response = new WebSocketResponseJson(request.getFriendId(), request.getMessage());
//
//            session.getBasicRemote().sendObject(response);
//
//        } catch(RuntimeException | IOException | EncodeException e) {
//            throw new ChatRoomException("Erro ao enviar mensagem", e.getCause());
//        }

    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        chatEndpoints.remove(this);
        Message message = new Message();
        message.setContent("Disconnected!");
        broadcast(message);
    }

    private static void broadcast(Message message) throws IOException, EncodeException {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote()
                            .sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
