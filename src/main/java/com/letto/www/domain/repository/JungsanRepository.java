package com.letto.www.domain.repository;

import com.letto.www.domain.entity.JungsanEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface JungsanRepository extends JpaRepository<JungsanEntity, Long>{
    List<JungsanEntity> findByCreatemonthContaining(String keyword);
}
