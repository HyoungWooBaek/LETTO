package com.letto.www.dto;

import com.letto.www.domain.entity.JungsanEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JungsanDto {
    private Long id;
    private String lable;
    private String title;
    private String writerid;
    private String writer;
    private String chulgan;
    private Double suninsae;
    private Double gaeyak;
    private String dockjum;
    private String platform;
    private String dateselectorst;
    private String dateselectorfn;
    private Double platfee;
    private Double platmachul;
    private Double platsoon;
    private String rs;
    private String createmonth;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public JungsanEntity toEntity(){
        JungsanEntity jungsanEntity = JungsanEntity.builder()
                .id(id)
                .lable(lable)
                .title(title)
                .writerid(writerid)
                .writer(writer)
                .chulgan(chulgan)
                .suninsae(suninsae)
                .gaeyak(gaeyak)
                .dockjum(dockjum)
                .platform(platform)
                .dateselectorst(dateselectorst)
                .dateselectorfn(dateselectorfn)
                .platfee(platfee)
                .platmachul(platmachul)
                .platsoon(platsoon)
                .rs(rs)
                .createmonth(createmonth)
                .build();
        return jungsanEntity;
    }

    @Builder
    public JungsanDto(Long id, String lable, String title, String writer, String writerid,
                      String chulgan, Double suninsae, Double gaeyak, String dockjum,
                      String platform, String dateselectorst, String dateselectorfn, Double platfee,
                      Double platmachul, Double platsoon, String rs,
                      LocalDateTime createdDate, String createmonth) {
        this.id = id;
        this.lable = lable;
        this.writer = writer;
        this.writerid = writerid;
        this.title = title;
        this.chulgan = chulgan;
        this.suninsae = suninsae;
        this.gaeyak = gaeyak;
        this.dockjum = dockjum;
        this.platform = platform;
        this.dateselectorst = dateselectorst;
        this.dateselectorfn = dateselectorfn;
        this.platmachul = platmachul;
        this.platsoon = platsoon;
        this.rs = rs;
        this.platfee = platfee;
        this.createdDate = createdDate;
        this.createmonth = createmonth;
    }
}
