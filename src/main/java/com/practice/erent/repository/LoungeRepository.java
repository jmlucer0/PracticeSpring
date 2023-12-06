package com.practice.erent.repository;

import com.practice.erent.model.Lounge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoungeRepository extends JpaRepository<Lounge, Long> {

    @Query("SELECT DISTINCT l.loungeType FROM Lounge l")
    List<String> findDistinctLoungeTypes();
}
