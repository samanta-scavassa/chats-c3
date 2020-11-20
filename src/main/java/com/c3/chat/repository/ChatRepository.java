package com.c3.chat.repository;

import com.c3.chat.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query( "select c from Chat c where c.userId = :userId")
    List<Chat> findByUserId(@Param("userId") Long userId);

}
