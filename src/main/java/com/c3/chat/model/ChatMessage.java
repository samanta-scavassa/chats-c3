package com.c3.chat.model;

import com.c3.chat.json.ChatMessageRequestJson;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
    private Chat chatId;

    @Column(name="message")
    private String message;

    @Column(name="file")
    private File file;

    @Column(name="created_at", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;


    public ChatMessage(Chat chatId, String message){
        this.chatId = chatId;
        this.message = message;
        this.createdAt = LocalDate.now();
    }

    public ChatMessage(ChatMessageRequestJson request){
        this.chatId = new Chat(request.getChatId());
        this.message = request.getMessage();
        this.file = request.getFile();
        this.createdAt = LocalDate.now();
    }
}
