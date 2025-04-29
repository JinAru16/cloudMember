package com.msa.member.search.controller;
import com.msa.member.search.domain.response.AddressResponse;
import com.msa.member.search.domain.response.MemberResponse;
import com.msa.member.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/member")
    public ResponseEntity<?> memberList(){
        List<MemberResponse> allMember = searchService.findAllMember();
        return ResponseEntity.ok(allMember);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<?> findMemberById(@PathVariable Long id){
        MemberResponse member = searchService.findById(id);
        return ResponseEntity.ok(member);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<?> getAddress(@PathVariable Long id){
        AddressResponse address = searchService.findAddressByMemberId(id);
        return ResponseEntity.ok(address);
    }
}
