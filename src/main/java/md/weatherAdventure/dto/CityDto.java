package md.weatherAdventure.dto;

import md.weatherAdventure.entity.CityEntity;

public class CityDto {
    private Long id;
    private String nameEn;
    private String nameRu;
    private Long countryId;
    private String countryCode;

    public CityDto() {
    }

    public CityDto(CityEntity entity) {
        this.id = entity.getId();
        this.nameEn = entity.getName_en();
        this.nameRu = entity.getName_ru();
        this.countryId = entity.getCountryEntity().getId();
        this.countryCode = entity.getCountryEntity().getCode();

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

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
