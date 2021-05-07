package md.weatherAdventure.repository;

import md.weatherAdventure.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DictionaryRepository extends JpaRepository<DictionaryEntity,Long> {
}
