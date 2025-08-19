package com.emazon.microservice_usuario.adapter.out.persistance.jpa.repositories;

import com.emazon.microservice_usuario.adapter.out.persistance.jpa.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    List<RoleEntity> findRoleEntitiesByRoleEnumIn(List<String> roleNames);
}
