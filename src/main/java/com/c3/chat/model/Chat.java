package com.c3.chat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "chat")
public class Chat implements Serializable {

    private static final long serialVersionUID = 102448660256736288L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long chatId;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="friend_id", nullable = false)
    private Long friendId;

    @Column(name="created_at", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

    @OneToMany(mappedBy = "chatId")
    private List<ChatMessage> messages;

    public Chat (Long chatId) {
        this.chatId = chatId;
    }
}
