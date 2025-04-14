package com.yas.Banking_user_service.service;


import com.yas.Banking_user_service.model.response.userResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "core-banking-service")
public interface bankingCoreClient {

    @RequestMapping(
            method = RequestMethod.GET, value =
            "/api/v1/user/{identification}"
    )
    userResponse readUser(@PathVariable("identification") String identification);

}
