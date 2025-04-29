package com.msa.member.search.controller;

import com.msa.member.search.domain.request.MemberRequest;
import com.msa.member.search.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class SignUpController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody MemberRequest request) {
         userService.register(request);
        return ResponseEntity.ok().body("SUCCESS");
    }
}
