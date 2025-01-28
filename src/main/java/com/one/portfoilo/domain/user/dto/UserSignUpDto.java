package com.one.portfoilo.domain.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private int age;
    private String city;
}