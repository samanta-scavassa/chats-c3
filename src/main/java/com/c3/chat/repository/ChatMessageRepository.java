package com.c3.chat.repository;

import com.c3.chat.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    @Query("select c from ChatMessage c where c.chatId= :chatId")
    Optional<ChatMessage> findByChatId(@Param("chatId") Long chatId);

}
