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

    @EmbeddedId
    private ChatID chatID;

    @Column(name="created_at", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

    @OneToMany
    private List<ChatMessage> messages;

}
