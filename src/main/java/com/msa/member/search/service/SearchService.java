package com.msa.member.search.service;

import com.msa.common.entity.Users;
import com.msa.member.exception.MemberException;
import com.msa.member.search.domain.response.AddressResponse;
import com.msa.member.search.domain.response.MemberResponse;
import com.msa.member.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;

    public void findAllMember() {
        List<Users> all = searchRepository.findAll();
        all.forEach(a -> {
            System.out.println(a.getUsername());
        });
    }

    public MemberResponse findById(Long id) {
        Optional<Users> byId = searchRepository.findById(id);
        if (byId.isPresent()) {
            return new MemberResponse(byId.get());
        } else{
            throw new MemberException("해당 회원은 존재하지않습니다.");
        }
    }

    public AddressResponse findAddressByMemberId(Long id) {
        Optional<Users> byId = searchRepository.findById(id);
        if (byId.isPresent()) {
            return new AddressResponse(byId.get());
        }
        else {
            throw new MemberException("해당 회원이 존재하지않습니다.");
        }
    }
}
