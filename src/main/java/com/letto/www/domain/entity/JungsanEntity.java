package com.letto.www.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "jungsan")

public class JungsanEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = true)
    private String lable;

    @Column(length = 100, nullable = true)
    private String title;

    @Column(length = 100, nullable = true)
    private String writerid;

    @Column(length = 100, nullable = true)
    private String writer;

    @Column(length = 100, nullable = true)
    private String chulgan;

    @Column(length = 100, nullable = true)
    private Double suninsae;

    @Column(length = 100, nullable = true)
    private Double gaeyak;

    @Column(length = 100, nullable = true)
    private String dockjum;

    @Column(length = 100, nullable = true)
    private String platform;

    @Column(length = 100, nullable = true)
    private String dateselectorst;

    @Column(length = 100, nullable = true)
    private String dateselectorfn;

    @Column(length = 100, nullable = true)
    private Double platfee;

    @Column(length = 100, nullable = true)
    private Double platmachul;

    @Column(length = 100, nullable = true)
    private Double platsoon;

    @Column(length = 100, nullable = true)
    private String rs;

    @Column(length = 100, nullable = true)
    private String createmonth;

    @Builder
    public JungsanEntity(Long id, String lable, String title, String writerid, String writer,
                         String chulgan, Double suninsae, Double gaeyak, String dockjum,
                         String platform, String dateselectorst, String dateselectorfn, Double platfee,
                         Double platmachul, Double platsoon, String rs,
                         String createmonth
                         ) {
        this.id = id;
        this.lable = lable;
        this.title = title;
        this.writerid = writerid;
        this.writer = writer;
        this.chulgan = chulgan;
        this.suninsae = suninsae;
        this.gaeyak = gaeyak;
        this.dockjum = dockjum;
        this.platform = platform;
        this.dateselectorst = dateselectorst;
        this.dateselectorfn = dateselectorfn;
        this.platfee = 1-platfee;
        this.rs = rs;
        this.platmachul = platmachul;
        this.platsoon = platmachul*(1-platfee);
        this.createmonth = createmonth;
    }
}
