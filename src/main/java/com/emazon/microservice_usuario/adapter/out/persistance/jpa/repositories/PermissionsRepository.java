package com.emazon.microservice_usuario.adapter.out.persistance.jpa.repositories;

import com.emazon.microservice_usuario.adapter.out.persistance.jpa.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsRepository extends JpaRepository<PermissionEntity,Long> {
}
