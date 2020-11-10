package com.c3.chat.model;

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

    @Column(name="chat_id", length = 50, nullable = false)
    private ChatID chatID;

    @Column(name="message")
    private String message;

    @Column(name="file")
    private File file;

    @Column(name="created_at", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;


    public ChatMessage(ChatID chatID, String message){
        this.chatID = chatID;
        this.message = message;
        this.createdAt = LocalDate.now();
    }
}
