package com.letto.www.service;

import com.letto.www.domain.entity.JungsanEntity;
import com.letto.www.dto.JungsanDto;
import com.letto.www.domain.repository.JungsanRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class JungsanService {
    private JungsanRepository jungsanRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 5;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<JungsanDto> getJungsanlist(Integer pageNum) {
        Page<JungsanEntity> page = jungsanRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));

        List<JungsanEntity> jungsanEntities = page.getContent();
        List<JungsanDto> jungsanDtoList = new ArrayList<>();

        for (JungsanEntity jungsanEntity : jungsanEntities) {
            jungsanDtoList.add(this.convertEntityToDto(jungsanEntity));
        }

        return jungsanDtoList;
    }

    @Transactional
    public Long getJungsanCount() {
        return jungsanRepository.count();
    }

    @Transactional
    public JungsanDto getPost(Long id) {
        Optional<JungsanEntity> jungsanEntityWrapper = jungsanRepository.findById(id);
        JungsanEntity jungsanEntity = jungsanEntityWrapper.get();

        return this.convertEntityToDto(jungsanEntity);
    }

    @Transactional
    public Long savePost(JungsanDto jungsanDto) {
        return jungsanRepository.save(jungsanDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        jungsanRepository.deleteById(id);
    }

    @Transactional
    public List<JungsanDto> searchPosts(String keyword) {
        List<JungsanEntity> jungsanEntities = jungsanRepository.findByCreatemonthContaining(keyword);
        List<JungsanDto> jungsanDtoList = new ArrayList<>();

        if (jungsanEntities.isEmpty()) return jungsanDtoList;

        for (JungsanEntity jungsanEntity : jungsanEntities) {
            jungsanDtoList.add(this.convertEntityToDto(jungsanEntity));
        }

        return jungsanDtoList;
    }

    public Integer[] getPageList(Integer curPageNum) {
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        // 총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getJungsanCount());

        // 총 게시글 기준으로 계산한 마지막 페이지 번호 계산
        Integer totalLastPageNum = (int)(Math.ceil((postsTotalCount/PAGE_POST_COUNT)));

        // 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
                ? curPageNum + BLOCK_PAGE_NUM_COUNT
                : totalLastPageNum;

        // 페이지 시작 번호 조정
        curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        // 페이지 번호 할당
        for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
            pageList[idx] = val;
        }

        return pageList;
    }

    private JungsanDto convertEntityToDto(JungsanEntity jungsanEntity) {
        return JungsanDto.builder()
                .id(jungsanEntity.getId())
                .lable(jungsanEntity.getLable())
                .title(jungsanEntity.getTitle())
                .writer(jungsanEntity.getWriter())
                .writerid(jungsanEntity.getWriterid())
                .chulgan(jungsanEntity.getChulgan())
                .suninsae(jungsanEntity.getSuninsae())
                .gaeyak(jungsanEntity.getGaeyak())
                .dockjum(jungsanEntity.getDockjum())
                .platform(jungsanEntity.getPlatform())
                .dateselectorst(jungsanEntity.getDateselectorst())
                .dateselectorfn(jungsanEntity.getDateselectorfn())
                .platfee(jungsanEntity.getPlatfee())
                .platmachul(jungsanEntity.getPlatmachul())
                .platsoon(jungsanEntity.getPlatsoon())
                .rs(jungsanEntity.getRs())
                .createdDate(jungsanEntity.getCreatedDate())
                .createmonth(jungsanEntity.getCreatemonth())
                .build();
    }
}
