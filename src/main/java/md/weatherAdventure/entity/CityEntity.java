package md.weatherAdventure.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CITY")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CODE")
    private  String code;
    @Column(name = "NAME_EN")
    private  String name_en;
    @Column(name = "NAME_RU")
    private  String name_ru;
    @Column(name = "STATE_EN")
    private  String state_en;
    @Column(name = "STATE_RU")
    private  String state_ru;
    @Column(name = "CITY_GATE_ID")
    private Long cityId;
    @Column(name = "LON")
    private BigDecimal lon;
    @Column(name = "LAT")
    private BigDecimal lat;
    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private CountryEntity countryEntity;

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

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long countryId) {
        this.cityId = countryId;
    }
    public void setCityId(String countryId) {
        this.cityId = Long.parseLong(countryId);
        System.out.println();
    }
    public void setCityId(Double countryId) {
        this.cityId = countryId.longValue();
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }
    public void setLon(Double lon) {
        this.lon = new BigDecimal(lon);
    }
    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
    public void setLat(Double lat) {
        this.lat = new BigDecimal(lat);
    }
    public String getState_en() {
        return state_en;
    }

    public void setState_en(String state_en) {
        this.state_en = state_en;
    }

    public String getState_ru() {
        return state_ru;
    }

    public void setState_ru(String state_ru) {
        this.state_ru = state_ru;
    }
}
