package com.one.portfoilo.user;

import com.one.portfoilo.domain.user.Role;
import com.one.portfoilo.domain.user.SocialType;
import com.one.portfoilo.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private User nomalUser;
    private User socialUser;
    private PasswordEncoder passwordEncoder;

    // 테스트 전 각 메서드 실행되기 전에 User와 passwordEncoder생성
    @BeforeEach
    public void setUp() {
        // PasswordEncoder를 mock 객체로 설정
        passwordEncoder = Mockito.mock(PasswordEncoder.class);

        nomalUser = User.builder()
                .email("test@example.com")
                .password("nomalPassword")
                .nickname("testUser1")
                .age(25)
                .city("Seoul")
                .role(Role.USER)
                .build();

        socialUser = User.builder()
                .email("test@socialUser.com")
                .password("socialPassword")
                .nickname("testUser2")
                .age(25)
                .city("Busan")
                .role(Role.GUEST)
                .socialType(SocialType.KAKAO)
                .socialId("12345")
                .build();
      }

    @Test
    public void testPasswordEncode() {
        // mock 된 passwordEncoder가 암호화를 수행하도록 설정
        Mockito.when(passwordEncoder.encode("plainPassword")).thenReturn("encodedPassword");

        // 비밀번호 암호화 메소드 실행
        nomalUser.passwordEncode(passwordEncoder);

        // 암호화된 비밀번호가 예상값과 일치하는지 확인
        assertThat(nomalUser.getPassword()).isEqualTo("encodedPassword");
    }
}
