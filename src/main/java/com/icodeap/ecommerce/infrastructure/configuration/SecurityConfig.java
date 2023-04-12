/*package com.icodeap.ecommerce.infrastructure.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.icodeap.ecommerce.infrastructure.service.UserDetailServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailServiceImpl userDetailService;

    public SecurityConfig(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }
    
  
    @Bean
    public UserDetailsManager usersCustom(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select username,password,estatus from Usuarios u where username=?");
        users.setAuthoritiesByUsernameQuery(
            "select u.username,p.perfil from UsuarioPerfil up " +
            "inner join Usuarios u on u.id = up.idUsuario " +
            "inner join Perfiles p on p.id = up.idPerfil " +
            "where u.username=?");

        return users;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf().disable()
            .authorizeHttpRequests()
                // Los recursos estáticos no requieren autenticación
                .requestMatchers(
                    "/bootstrap/**",
                    "/images/**",
                    "/css/**",
                    "/vendor/**",
                    "/tinymce/**",
                    "/logos/**"
                ).permitAll()
                // Asignar permisos a URLs por ROLES
                .requestMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR", "ADMINISTRADOR")
                .requestMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR", "ADMINISTRADOR")
                .requestMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
                .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                // Las vistas públicas no requieren autenticación
                .requestMatchers(
                    "/",
                    "/signup",
                    "/search",
                    "/login",
                   "/register",
                    "/bcrypt/**",
                    "/vacantes/view/**"
                ).permitAll()
                
                
                // Todas las demás URLs de la Aplicación requieren autenticación
                .anyRequest().authenticated()
            // El formulario de Login no requiere autenticacion
            .and().formLogin().loginPage("/login").permitAll()
            .and().logout().permitAll();
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}*/

///ruiz123 Encriptado en Bcrypt: $2a$10$3BDwL1MIGIEgjDoK5itNlOXrLi7ep3LoxPiQHKdRfAzpwqrckUviK

package com.icodeap.ecommerce.infrastructure.configuration;

import com.icodeap.ecommerce.infrastructure.service.LoginHandler;
import com.icodeap.ecommerce.infrastructure.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailServiceImpl userDetailService;

    @Autowired
    private LoginHandler loginHandler;

    public SecurityConfig(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER").anyRequest().permitAll()
                .and().formLogin().loginPage("/login").successHandler(loginHandler) .and().logout().logoutSuccessUrl("/close");
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
