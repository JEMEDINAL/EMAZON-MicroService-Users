package com.emazon.microservice_usuario.config;


import com.emazon.microservice_usuario.adapter.out.security.UserDetailServiceImpl;
import com.emazon.microservice_usuario.adapter.out.util.JwtUtils;
import com.emazon.microservice_usuario.config.filter.JwtTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtUtils jwtUtils;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationProvider authenticationProvider) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    http.requestMatchers(HttpMethod.POST, "/sing-up").permitAll();
                    http.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();
                    // EndPoints Privados
                    http.requestMatchers(HttpMethod.GET, "/method/get").hasAuthority("READ");
                    http.requestMatchers(HttpMethod.POST, "/method/post").hasAuthority("CREATE");
                    http.requestMatchers(HttpMethod.DELETE, "/method/delete").hasAuthority("DELETE");
                    http.requestMatchers(HttpMethod.PUT, "/method/put").hasAuthority("UPDATE");
                    http.requestMatchers(HttpMethod.GET, "/method/gestis").hasAuthority("ROLE_ADMIN");
                    http.requestMatchers(HttpMethod.GET, "/method/asissts").hasAuthority("ROLE_CELLAR_ASSISTANT");

                    http.anyRequest().denyAll();
                })
                .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return  authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetails){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetails);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();
    }
}
