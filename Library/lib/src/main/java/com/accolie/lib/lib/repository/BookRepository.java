package com.accolie.lib.lib.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.accolie.lib.lib.entity.*;

public interface BookRepository extends JpaRepository<Book, Long> {}
