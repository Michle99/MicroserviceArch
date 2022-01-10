package com.airline.airline.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/flights","/", "/flight/search","/flight/book/verify", "/flight/book/cancel", "/img/**").permitAll()
            // .antMatchers( "/flight/book**", "/flight/book/new").hasRole("AGENT")
            .antMatchers("/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("/flights")
                .permitAll()
        .and()
        .logout().logoutSuccessUrl("/").permitAll();

        // http
        // 
        // .antMatchers().authenticated()
        // 
        // 



        // .anyRequest().permitAll()
        // .and()
        // .formLogin()
        // // .loginPage("/login")
        // .defaultSuccessUrl("/flights")
        // .failureUrl("/login?error")
        // .permitAll()
        // .and()
        // .logout()
        // .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        // .logoutSuccessUrl("/login?logout")
        // .permitAll()
        // .and()
        // .csrf().disable()
        // .exceptionHandling();
    }
    
}
