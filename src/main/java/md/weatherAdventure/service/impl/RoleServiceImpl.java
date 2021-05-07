package md.weatherAdventure.service.impl;

import md.weatherAdventure.entity.RoleEntity;
import md.weatherAdventure.entity.RoleEnum;
import md.weatherAdventure.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl {
    RoleRepository roleRepository;
@Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public RoleEntity findByCode(RoleEnum roleEnum)
    {
        return roleRepository.findByCode(roleEnum);
    }
}
