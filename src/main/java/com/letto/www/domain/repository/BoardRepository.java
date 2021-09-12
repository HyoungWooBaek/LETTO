package com.letto.www.domain.repository;

import com.letto.www.domain.entity.BoardEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
    List<BoardEntity> findByTitleContaining(String keyword);
}
