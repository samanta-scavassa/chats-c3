package com.c3.chat.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ChatMessageRequestJson {

    private Long chatId;

    private String message;

    private File file;
}
