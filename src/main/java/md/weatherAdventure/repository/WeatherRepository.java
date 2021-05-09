package md.weatherAdventure.repository;

import md.weatherAdventure.entity.UserEntity;
import md.weatherAdventure.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity,Long> {
    Set<WeatherEntity> findByUserEntity(UserEntity userEntity);
}
