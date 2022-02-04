package com.softuni.judge.service.impl;

import com.softuni.judge.model.entity.Role;
import com.softuni.judge.model.entity.RoleNameEnum;
import com.softuni.judge.repository.RoleRepository;
import com.softuni.judge.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) {
            Role admin = new Role(RoleNameEnum.ADMIN);
            Role user = new Role(RoleNameEnum.USER);
            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }

    @Override
    public Role findRole(RoleNameEnum roleNameEnum) {
        return roleRepository.findByName(roleNameEnum).orElse(null);
    }
}
