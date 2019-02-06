package com.mhp.boot.camp.hateoasdemo.security;

import lombok.Data;

@Data
public class CredentialsRequest {
    private String userName;
    private String passWord;

}
