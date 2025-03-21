package com.msa.member.search.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchService {
    public void findAllMember() {
      //  List<Users> all = searchRepository.findAll();
        //all.forEach(System.out::println);
    }
}
