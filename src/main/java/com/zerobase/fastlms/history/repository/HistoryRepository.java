package com.zerobase.fastlms.history.repository;

import com.zerobase.fastlms.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History,Long> {

}
