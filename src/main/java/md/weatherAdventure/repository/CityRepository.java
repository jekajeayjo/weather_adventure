package md.weatherAdventure.repository;

import md.weatherAdventure.entity.CityEntity;
import md.weatherAdventure.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
    CityEntity findByCityId(Long cityId);
    Set<CityEntity> findByCountryEntity(CountryEntity entity);
}
