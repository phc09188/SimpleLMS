package com.zerobase.fastlms.history.repository;

import com.zerobase.fastlms.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History,Long> {
    Optional<List<History>> findByUserId(String userId);
}
