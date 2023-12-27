package com.example.BCSD.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class User {
    private String userId;
    private String userName;
    private String userPw;
}
