package com.letto.www.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "jigup")

public class JigupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = true)
    private String writerid;

    @Column(length = 100, nullable = true)
    private String writer;

    @Column(length = 100, nullable = true)
    private String realname;

    @Column(length = 100, nullable = true)
    private Double suninsae;

    @Column(length = 100, nullable = true)
    private Double gaeyak;

    @Column(length = 100, nullable = true)
    private Double platsoon;

    @Column(length = 100, nullable = true)
    private String contactdate;

    @Column(length = 100, nullable = true)
    private String chongjungsan;

    @Column(length = 100, nullable = true)
    private String soduk;

    @Column(length = 100, nullable = true)
    private String joomin;

    @Column(length = 100, nullable = true)
    private String jigup;

    @Column(length = 100, nullable = true)
    private String bankname;

    @Column(length = 100, nullable = true)
    private String bankcode;

    @Column(length = 100, nullable = true)
    private String bigo;

    @Column(length = 100, nullable = true)
    private String createmonth;

    @Builder
    public JigupEntity(Long id, String writerid, String writer, String realname, String contactdate,
                       String chongjungsan, String soduk, String jigup, String bankname,
                       String bankcode, String bigo, String createmonth,
                       Double suninsae, Double gaeyak, Double platsoon) {
        this.id = id;
        this.writerid = writerid;
        this.writer = writer;
        this.suninsae = suninsae;
        this.gaeyak = gaeyak;
        this.platsoon = platsoon;
        this.realname = realname;
        this.contactdate = contactdate;
        this.chongjungsan = chongjungsan;
        this.soduk = soduk;
        this.jigup = jigup;
        this.bankname = bankname;
        this.bankcode = bankcode;
        this.bigo = bigo;
        this.createmonth = createmonth;
    }
}
