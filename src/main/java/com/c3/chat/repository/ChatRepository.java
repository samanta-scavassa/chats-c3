package com.c3.chat.repository;

import com.c3.chat.model.Chat;
import com.c3.chat.model.ChatID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, ChatID> {

    @Query( "select c from Chat c where c.chatID.userId = :userId")
    Optional<Chat> findByUserId(@Param("userId") Long userId);

}
