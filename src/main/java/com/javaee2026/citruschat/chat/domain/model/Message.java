package com.javaee2026.citruschat.chat.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.awt.*;
import java.util.UUID;

//Nota: RECORDEMOS QUE ACA NO VA JPA
@Data
public class Message {

    private UUID id;

    public String content;

}
