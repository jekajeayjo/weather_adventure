package md.weatherAdventure.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "WEATHER_STORY")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "MAIN")
    private String main;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "temp")
    private BigDecimal temp;
    @Column(name = "FEELS_LIKE")
    private BigDecimal feelsLike;
    @Column(name = "TEMP_MIN")
    private BigDecimal tempMin;
    @Column(name = "TEMP_MAX")
    private BigDecimal tempMax;
    @Column(name = "PRESSURE")
    private BigDecimal pressure;
    @Column(name = "HUMIDITY")
    private BigDecimal humidity;
    @Column(name = "WIND_SPEED")
    private BigDecimal widnSpeed;
    @Column(name = "WIND_DEG")
    private BigDecimal windDeg;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    CityEntity cityEntity;
    @Column(name = "DATE")
    LocalDateTime localDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public void setTemp(Double temp) {
        this.temp = new BigDecimal(temp);
    }

    public BigDecimal getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(BigDecimal feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = new BigDecimal(feelsLike);
    }

    public BigDecimal getTempMin() {
        return tempMin;
    }

    public void setTempMin(BigDecimal tempMin) {
        this.tempMin = tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = new BigDecimal(tempMin);
    }

    public BigDecimal getTempMax() {
        return tempMax;
    }

    public void setTempMax(BigDecimal tempMax) {
        this.tempMax = tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = new BigDecimal(tempMax);
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = new BigDecimal(pressure);
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = new BigDecimal(humidity);
    }

    public BigDecimal getWidnSpeed() {
        return widnSpeed;
    }

    public void setWidnSpeed(BigDecimal widnSpeed) {
        this.widnSpeed = widnSpeed;
    }

    public void setWidnSpeed(Double widnSpeed) {
        this.widnSpeed = new BigDecimal(widnSpeed);
    }

    public BigDecimal getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(BigDecimal windDeg) {
        this.windDeg = windDeg;
    }

    public void setWindDeg(Double windDeg) {
        this.windDeg = new BigDecimal(windDeg);
    }

    public CityEntity getCityEntity() {
        return cityEntity;
    }

    public void setCityEntity(CityEntity cityEntity) {
        this.cityEntity = cityEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
