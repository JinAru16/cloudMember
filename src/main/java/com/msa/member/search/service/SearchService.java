package com.msa.member.search.service;

import com.msa.member.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.msa.common.entity.Users;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;


    public void findAllMember() {
        List<Users> all = searchRepository.findAll();
        all.forEach(System.out::println);
    }
}
