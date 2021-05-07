package md.weatherAdventure.repository;

import md.weatherAdventure.entity.RoleEntity;
import md.weatherAdventure.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

RoleEntity findByCode(RoleEnum roleEnum);
}
