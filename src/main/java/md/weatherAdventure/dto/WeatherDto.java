package md.weatherAdventure.dto;

import md.weatherAdventure.entity.WeatherEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherDto {
    private Long id;
    private Long countryId;
    private Long cityId;
    private String countryName;
    private String cityName;
    private String main;
    private BigDecimal windSpeed;
    private BigDecimal windGed;
    private BigDecimal temp;
    private BigDecimal feelsLike;
    private BigDecimal pressure;
    private BigDecimal humidity;
    private LocalDateTime dateTime;
    private String date;

    public WeatherDto() {
    }

    public WeatherDto(WeatherEntity entity) {
        setId(entity.getId());
        setCountryId(entity.getCityEntity().getCountryEntity().getId());
        setCountryName(entity.getCityEntity().getCountryEntity().getName_en());
        setCityId(entity.getCityEntity().getId());
        setCityName(entity.getCityEntity().getName_en());
        setMain(entity.getMain());
        setWindSpeed(entity.getWidnSpeed());
        setWindGed(entity.getWindDeg());
        setTemp(entity.getTemp());
        setFeelsLike(entity.getFeelsLike());
        setPressure(entity.getPressure());
        setHumidity(entity.getHumidity());
        setDateTime(entity.getLocalDateTime());

        if (entity.getLocalDateTime()!=null)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            setDate(entity.getLocalDateTime().format(formatter));
        }


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    public BigDecimal getWindGed() {
        return windGed;
    }

    public void setWindGed(BigDecimal windGed) {
        this.windGed = windGed;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public BigDecimal getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(BigDecimal feelsLike) {
        this.feelsLike = feelsLike;
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
