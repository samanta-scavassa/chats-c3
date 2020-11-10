package com.c3.chat.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class WebSocketResponseJson {

    private Long friendId;

    private String message;

}
