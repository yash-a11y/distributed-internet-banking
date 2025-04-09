package com.yas.Banking_user_service.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class user {
    private Long id;

    private String email;
    private String identification;
    private String password;
    private String authId;
    private String status;

}
