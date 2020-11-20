package com.c3.chat.json;

import lombok.Data;

@Data
public class ChatRequest {

    private Long userId;
    private Long friendId;
}
