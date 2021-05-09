package md.weatherAdventure.dto;

import md.weatherAdventure.entity.CountryEntity;

public class CountryDto {
    private Long id;
    private String nameEn;
    private String nameRu;
    private String code;

    public CountryDto() {
    }
    public CountryDto(CountryEntity  entity) {
        this.id=entity.getId();
        this.nameEn=entity.getName_en();
        this.nameRu=entity.getName_ru();
        this.code=entity.getCode();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
