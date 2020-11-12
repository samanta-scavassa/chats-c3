package com.c3.chat.controller;

import com.c3.chat.model.ChatMessage;
import com.c3.chat.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/chat/message")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping("/{userId}/{friendId}")
    public ResponseEntity<ChatMessage> getMessageByChatId(@PathVariable("chatId") Long chatId) {

        Optional<ChatMessage> message = chatMessageService.getMessageByChatId(chatId);

        return message
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register-message")
    public ResponseEntity postMessage(@Valid @RequestBody ChatMessage chatMessage) {

        try {
            chatMessageService.saveChatMessage(chatMessage);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
