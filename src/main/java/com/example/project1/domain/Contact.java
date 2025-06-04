package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private int contactId;
    private String subject;
    private String message;
    private String email;
    private LocalDateTime time;
}