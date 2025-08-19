package com.emazon.microservice_usuario;

import com.emazon.microservice_usuario.adapter.out.persistance.jpa.entities.PermissionEntity;
import com.emazon.microservice_usuario.adapter.out.persistance.jpa.entities.RoleEntity;
import com.emazon.microservice_usuario.adapter.out.persistance.jpa.entities.RoleEnum;

import com.emazon.microservice_usuario.adapter.out.persistance.jpa.repositories.RoleRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class MicroserviceUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUsuarioApplication.class, args);
	}

	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {
		return args -> {
			/* Create PERMISSIONS */
			List<PermissionEntity> savedPermissions = List.of(
					PermissionEntity.builder().name("CREATE").build(),
					PermissionEntity.builder().name("READ").build(),
					PermissionEntity.builder().name("UPDATE").build(),
					PermissionEntity.builder().name("DELETE").build(),
					PermissionEntity.builder().name("REFACTOR").build()
			);
			PermissionEntity createPermission = savedPermissions.get(0);
			PermissionEntity readPermission = savedPermissions.get(1);
			PermissionEntity updatePermission = savedPermissions.get(2);
			PermissionEntity deletePermission = savedPermissions.get(3);
			PermissionEntity refactorPermission = savedPermissions.get(4);
			/* Create ROLES */

			RoleEntity CELLAR_ASSISTANT = RoleEntity.builder()
					.roleEnum(RoleEnum.CELLAR_ASSISTANT)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission, readPermission))
					.build();

			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			RoleEntity roleDeveloper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();

			roleRepository.saveAll(List.of(roleAdmin,roleUser,roleInvited,roleDeveloper,CELLAR_ASSISTANT));

		};
	}
}