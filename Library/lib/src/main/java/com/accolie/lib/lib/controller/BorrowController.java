package com.accolie.lib.lib.controller;

import com.accolie.lib.lib.entity.BorrowRecord;
import com.accolie.lib.lib.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrow")
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowService borrowService;

    @PostMapping
    public ResponseEntity<BorrowRecord> borrow(
            @RequestParam Long bookId,
            @RequestParam Long memberId) {
        return ResponseEntity.ok(borrowService.borrow(bookId, memberId));
    }

    @PutMapping("/return/{id}")
    public ResponseEntity<BorrowRecord> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(borrowService.returnBook(id));
    }
}
