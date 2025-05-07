package com.msa.member.search.service;

import com.msa.common.entity.Address;
import com.msa.member.exception.MemberException;
import com.msa.member.search.domain.response.AddressResponse;
import com.msa.member.search.domain.response.MemberResponse;
import com.msa.member.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.msa.common.entity.Users;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;

    public List<MemberResponse> findAllMember() {
        List<Users> all = searchRepository.findAll();
        return all.stream().map(MemberResponse::new).toList();
    }

    public MemberResponse findById(Long id) {
        return new MemberResponse(
                searchRepository.findById(id)
                      .orElseThrow(() ->new MemberException("해당회원이 존재하지않습니다."))
        );

    }

    public AddressResponse findAddressByMemberId(Long id) {
        return new AddressResponse(
                searchRepository.findById(id)
                    .orElseThrow(() -> new MemberException("해당회원이 존재하지않습니다."))
        );
    }

    public AddressResponse findAddressByUsername(String username) {
       //  Address address = searchRepository.findByUsername(username).get().getAddress();
        return new AddressResponse(
                searchRepository.findByUsername(username)
                    .orElseThrow(() -> new MemberException("해당회원이 존재하지않습니다."))
        );
    }
}
