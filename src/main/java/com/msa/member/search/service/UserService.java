package com.msa.member.search.service;

import com.msa.common.entity.Role;
import com.msa.common.entity.Users;
import com.msa.common.exception.UserException;
import com.msa.member.search.domain.request.MemberRequest;
import com.msa.member.search.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Users register(MemberRequest request) {
       if(userRepository.findUsersByUsername(request.getUsername()) != null){
           throw new UserException("존재하는 사용자입니다.");
        }
       Users users = Users.builder()
               .username(request.getUsername())
               .password(passwordEncoder.encode(request.getPassword()))
               .email(request.getEmail())
               .nickname(request.getNickname())
               .role(Role.USER)
               .build();
        return userRepository.save(users);
    }
}
