package com.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password , enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().exceptionHandling(); //для чего???

        http.authorizeRequests()
                // указываем правила запросов по которым будет определятся доступ к ресурсам и остальным данным
                .antMatchers("/newUser").access("hasRole('ROLE_USER')")
                .antMatchers("/newCompany").access("hasRole('ROLE_ADMIN')")
                .and()
                // указываем страницу с формой логина, URL при неудачном логине defaultSuccessUrl -редирект при успешной авторизации
                .formLogin().loginPage("/login") .defaultSuccessUrl("/").failureUrl("/login?error")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout()
                // разрешаем делать логаут всем и  указываем URL логаута
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")  // указываем URL при удачном логауте
                .and()
                .csrf().disable();

    }

}
