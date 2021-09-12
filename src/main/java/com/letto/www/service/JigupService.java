package com.letto.www.service;

import com.letto.www.domain.entity.JigupEntity;
import com.letto.www.domain.entity.JungsanEntity;
import com.letto.www.domain.repository.JigupRepository;
import com.letto.www.domain.repository.JungsanRepository;
import com.letto.www.dto.JigupDto;
import com.letto.www.dto.JungsanDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class JigupService {
    private JigupRepository jigupRepository;
    private JungsanRepository jungsanRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 5;  // 블럭에 존재하는 페이지 번호 수

    @Transactional
    public List<JigupDto> getJungsanSumList() {
        List<JigupEntity> jigupEntities = jigupRepository.findJungsanSum();
        List<JigupDto> jigupDtoList = new ArrayList<>();

        for (JigupEntity jigupEntity : jigupEntities) {
            jigupDtoList.add(this.convertEntityToDto(jigupEntity));
        }
        return jigupDtoList;
    }

    private JigupDto convertEntityToDto(JigupEntity jigupEntity){
        return JigupDto.builder()
                .createmonth(jigupEntity.getCreatemonth())
                .writer(jigupEntity.getWriter())
                .suninsae(jigupEntity.getSuninsae())
                .gaeyak(jigupEntity.getGaeyak())
                .platsoon(jigupEntity.getPlatsoon())
                .build();
    }
}
