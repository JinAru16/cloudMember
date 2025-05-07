package com.msa.member.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.msa.common.entity.Users;

import java.util.Optional;

@Repository
public interface SearchRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);
}
