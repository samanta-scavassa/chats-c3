package com.c3.chat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatID implements Serializable {

    private static final long serialVersionUID = 9034134343442137453L;

    private Long userId;

    private Long frienId;

}
