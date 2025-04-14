package com.yas.Banking_user_service.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class userResponse {
    private  String firstName;
    private String lastName;
    private List<accountResponse> bankAccounts;
    private  String identificationNumber;
    private  Integer id;
    private String email;
}
