package com.solbeg.testtask.citiesshower.security;

import com.solbeg.testtask.citiesshower.util.UsersEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(10)
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private CitiesBasicAuthenticationEntryPoint citiesBasicAuthenticationEntryPoint;

    public SpringSecurityConfig(CitiesBasicAuthenticationEntryPoint citiesBasicAuthenticationEntryPoint) {
        this.citiesBasicAuthenticationEntryPoint = citiesBasicAuthenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(citiesBasicAuthenticationEntryPoint)
                .and()
                .csrf()
                .disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{bcrypt}$2a$12$egK8Hv.ftw47BYDcS9OWD.0BCCHH/AgdjYZYD5O3fngXLG9.Q3W8K")
                .roles(UsersEnum.ADMIN.getUser());
    }
}
