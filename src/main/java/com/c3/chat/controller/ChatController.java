package com.c3.chat.controller;

import com.c3.chat.json.ChatRequest;
import com.c3.chat.model.Chat;
import com.c3.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/{chatId}")
    public ResponseEntity<Chat> getChatById(@PathVariable("chatId") Long chatId) {

        Optional<Chat> chat = chatService.findbyId(chatId);

        return chat
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Chat>> getChatByUserId(@PathVariable("userId") Long userId) {

        List<Chat> chats = chatService.getChatByUserId(userId);

        return chats != null ?
                ResponseEntity.ok(chats) :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/register-chat")
    public ResponseEntity<Chat> postChat(@RequestBody ChatRequest chatRequest) {

        try {
            Chat chat = new Chat(chatRequest.getUserId(), chatRequest.getFriendId());
            Chat db = chatService.saveChat(chat);
           return db != null ?
                   ResponseEntity.ok(db) :
                   ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
