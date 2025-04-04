package com.yas.Banking_user_service.model.entity;

import com.yas.Banking_user_service.model.dto.status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@Entity
@Table(name = "user")
public class userEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authId;

    private String identification;

    @Enumerated(EnumType.STRING)
    private status status;
}
