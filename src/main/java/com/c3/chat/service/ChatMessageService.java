package com.c3.chat.service;

import com.c3.chat.model.ChatID;
import com.c3.chat.model.ChatMessage;
import com.c3.chat.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public Optional<ChatMessage> getMessageByChatId(ChatID chatID) {
        return chatMessageRepository.findByChatId(chatID);
    }

    public void saveChatMessage(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
    }

}
