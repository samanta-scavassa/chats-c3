package com.c3.chat.model;

import com.c3.chat.json.ChatMessageRequestJson;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name="chatId", nullable=false)
    @JsonIgnore
    private Chat chatId;

    @Column(name="message")
    private String message;

    @Column(name="file")
    private File file;

    @Column(name="created_at", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;


    public ChatMessage(Chat chatId, Long userId, String message){
        this.chatId = chatId;
        this.userId = userId;
        this.message = message;
        this.createdAt = LocalDate.now();
    }

    public ChatMessage(ChatMessageRequestJson request){
        this.chatId = new Chat(request.getChatId());
        this.userId = request.getUserId();
        this.message = request.getMessage();
        this.file = request.getFile();
        this.createdAt = LocalDate.now();
    }
}
