package com.yas.Banking_user_service.controller;

import com.yas.Banking_user_service.model.dto.user;
import com.yas.Banking_user_service.model.dto.userUpdateReq;
import com.yas.Banking_user_service.service.keycloakUserService;
import com.yas.Banking_user_service.service.userService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/bank-user")
@RequiredArgsConstructor
public class userController {

    @Autowired
    private keycloakUserService keycloakUserService;

    @Autowired
    private userService userService;



    @PostMapping(value = "/register")
    public ResponseEntity createUser(@RequestBody user request)
    {
        log.info("Create user {}", request.toString());
        return ResponseEntity.ok(
                userService.createUser(request)
        );
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long userID
            , @RequestBody userUpdateReq userUpdateRequest){
        log.info("update user : {}", userUpdateRequest.toString());
        return ResponseEntity.ok(userService.updateUser(userID, userUpdateRequest));
    }


    @GetMapping
    public ResponseEntity readUsers(Pageable pageable){
        log.info("all users");
        return ResponseEntity.ok(userService.readUsers(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity readUser(@PathVariable("id") Long id){
        log.info("fetch user by id {}", id);
        return ResponseEntity.ok(userService.readUser(id));
    }

}
