package com.accolie.lib.lib.controller;

import com.accolie.lib.lib.entity.Member;
import com.accolie.lib.lib.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @PostMapping
    public ResponseEntity<Member> create(@Valid @RequestBody Member member) {
        return ResponseEntity.ok(memberRepository.save(member));
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAll() {
        return ResponseEntity.ok(memberRepository.findAll());
    }
}
