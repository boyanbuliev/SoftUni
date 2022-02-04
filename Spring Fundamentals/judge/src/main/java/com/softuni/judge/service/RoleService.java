package com.softuni.judge.service;

import com.softuni.judge.model.entity.Role;
import com.softuni.judge.model.entity.RoleNameEnum;

public interface RoleService {
    void initRoles();

    Role findRole(RoleNameEnum roleNameEnum);
}
