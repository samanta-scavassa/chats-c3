package com.c3.chat.json;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ChatRoomRequest {

    private Long userId;

    private Long friendId;

    private String message;

    private File file;
}
