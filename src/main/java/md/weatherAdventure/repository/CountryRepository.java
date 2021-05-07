package md.weatherAdventure.repository;

import md.weatherAdventure.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CountryRepository extends JpaRepository<CountryEntity,Long> {
}
