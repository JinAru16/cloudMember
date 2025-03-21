package com.msa.member.search.service;

import com.msa.common.entity.Users;
import com.msa.member.search.repository.SearchRepository;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;

    public void findAllMember() {
        List<Users> all = searchRepository.findAll();
        all.forEach(System.out::println);
    }
}
