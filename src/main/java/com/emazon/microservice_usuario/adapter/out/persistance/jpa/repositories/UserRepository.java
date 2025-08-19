package com.emazon.microservice_usuario.adapter.out.persistance.jpa.repositories;

import com.emazon.microservice_usuario.adapter.out.persistance.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findUserEntityByEmail(String email);
}
