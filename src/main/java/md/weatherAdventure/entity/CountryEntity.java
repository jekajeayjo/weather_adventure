package md.weatherAdventure.entity;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRY")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CODE")
    private  String code;
    @Column(name = "NAME_EN")
    private  String name_en;
    @Column(name = "NAME_RU")
    private  String name_ru;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_ru() {
        return name_ru;
    }

    public void setName_ru(String name_ru) {
        this.name_ru = name_ru;
    }
}
