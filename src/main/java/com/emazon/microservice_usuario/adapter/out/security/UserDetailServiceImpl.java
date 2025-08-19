package com.emazon.microservice_usuario.adapter.out.security;

import com.emazon.microservice_usuario.adapter.in.dto.AuthCreateUserRequest;
import com.emazon.microservice_usuario.adapter.in.dto.AuthResponse;
import com.emazon.microservice_usuario.adapter.out.persistance.jpa.entities.RoleEntity;
import com.emazon.microservice_usuario.adapter.out.persistance.jpa.entities.UserEntity;
import com.emazon.microservice_usuario.adapter.out.persistance.jpa.repositories.RoleRepository;
import com.emazon.microservice_usuario.adapter.out.persistance.jpa.repositories.UserRepository;
import com.emazon.microservice_usuario.adapter.out.util.JwtUtils;
import com.emazon.microservice_usuario.domain.port.out.UsersRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService,UsersRepository {

    private final JwtUtils jwtUtils;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserDetailServiceImpl(JwtUtils jwtUtils, PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserEntityByEmail(username).orElseThrow(RuntimeException::new);
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        userEntity.getRoles().forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));
        userEntity.getRoles().stream().flatMap(role -> role.getPermissionList().stream()).forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(userEntity.getEmail(), userEntity.getPassword(), userEntity.isEnabled(), userEntity.isAccountNoExpired(), userEntity.isCredentialNoExpired(), userEntity.isAccountNoLocked(), authorityList);
    }


    @Override
    public AuthResponse saveUser(AuthCreateUserRequest authCreateUserRequest) {
        List<String> roleRequest = authCreateUserRequest.roleRequest().roleListName();
        Set<RoleEntity> roleEntityList = roleRepository.findRoleEntitiesByRoleEnumIn(roleRequest).stream().collect(Collectors.toSet());
        if(roleEntityList.isEmpty()){
            throw new IllegalArgumentException(" ");
        }
        UserEntity userEntity = UserEntity.builder()
                .name(authCreateUserRequest.name())
                .password(passwordEncoder.encode(authCreateUserRequest.password()))
                .lastName(authCreateUserRequest.lastName())
                .idNumber(authCreateUserRequest.idNumber())
                .phoneNumber(authCreateUserRequest.phoneNumber())
                .dateBirth(authCreateUserRequest.dateBirth())
                .email(authCreateUserRequest.email())
                .age(authCreateUserRequest.age())
                .roles(roleEntityList)
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();

        UserEntity userSaved = userRepository.save(userEntity);

        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userSaved.getRoles().forEach(role->authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));
        userSaved.getRoles().stream().flatMap(role -> role.getPermissionList().stream()).forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getName())));
        Authentication authentication = new UsernamePasswordAuthenticationToken(userSaved.getEmail(), null, authorities);
        String accessToken = jwtUtils.createToken(authentication);
        AuthResponse authResponse = new AuthResponse(userSaved.getEmail(),"user created Successfully",accessToken,true );
        return authResponse;
    }
}
