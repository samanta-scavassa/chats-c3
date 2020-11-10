package com.c3.chat.service;


import com.c3.chat.model.Chat;
import com.c3.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public Optional<Chat> getChatByUserId(Long userId) {
        return chatRepository.findByUserId(userId);
    }

    public Chat saveChat(Chat chat) {
        return chatRepository.save(chat);
    }

}
