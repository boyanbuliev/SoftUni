package com.softuni.judge.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private RoleNameEnum name;

    public Role() {
    }

    public Role(RoleNameEnum name) {
        this.name=name;
    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnum getName() {
        return name;
    }

    public Role setName(RoleNameEnum name) {
        this.name = name;
        return this;
    }
}
