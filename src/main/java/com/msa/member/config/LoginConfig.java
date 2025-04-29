package com.msa.member.config;

import com.msa.common.UserDetailsImpl;
import com.msa.common.entity.Users;
import com.msa.member.search.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class LoginConfig {
    private final UserRepository repository;

    @Bean
    public UserDetailsService userDetailsService() { // ✅ UsersRepository 주입
        return username -> {
            Users user = repository.findUsersByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("해당 사용자가 존재하지 않습니다: " + username);
            }
            return new UserDetailsImpl(user);
        };
    }
}
