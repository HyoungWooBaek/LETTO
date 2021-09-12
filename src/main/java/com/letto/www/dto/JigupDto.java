package com.letto.www.dto;

import com.letto.www.domain.entity.JigupEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JigupDto {
    private Long id;
    private String writer;
    private String realname;
    private Double suninsae;
    private Double gaeyak;
    private Double platsoon;
    private String contactdate;
    private String chongjunsan;
    private String soduk;
    private String jigup;
    private String bankname;
    private String bankcode;
    private String bigo;
    private String createmonth;

    public JigupEntity toEntity(){
        JigupEntity jigupEntity = JigupEntity.builder()
                .id(id)
                .writer(writer)
                .realname(realname)
                .suninsae(suninsae)
                .gaeyak(gaeyak)
                .platsoon(platsoon)
                .contactdate(contactdate)
                .chongjungsan(chongjunsan)
                .soduk(soduk)
                .jigup(jigup)
                .bankname(bankname)
                .bankcode(bankcode)
                .bigo(bigo)
                .createmonth(createmonth)
                .build();
        return jigupEntity;
    }

    @Builder
    public JigupDto(Long id, String writer, String realname, String contactdate,
                    String chongjunsan, String soduk, String jigup, String bankname,
                    String bankcode, String bigo, String createmonth,
                    Double suninsae, Double gaeyak, Double platsoon) {
        this.id = id;
        this.writer = writer;
        this.suninsae = suninsae;
        this.gaeyak = gaeyak;
        this.platsoon = platsoon;
        this.realname = realname;
        this.contactdate = contactdate;
        this.chongjunsan = chongjunsan;
        this.soduk = soduk;
        this.jigup = jigup;
        this.bankname = bankname;
        this.bankcode = bankcode;
        this.bigo = bigo;
        this.createmonth = createmonth;
    }
}
