package com.letto.www.domain.repository;

import com.letto.www.domain.entity.JigupEntity;
import com.letto.www.domain.entity.JungsanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JigupRepository extends JpaRepository<JigupEntity, Long> {
    @Query("SELECT js.createmonth, " +
            "js.writer, " +
            "js.suninsae, " +
            "js.gaeyak, " +
            "sum(js.platsoon) as platsoon " +
            "FROM JungsanEntity js " +
            "GROUP BY js.createmonth, js.writer, js.suninsae, js.gaeyak")
    List<JigupEntity> findJungsanSum();
}
