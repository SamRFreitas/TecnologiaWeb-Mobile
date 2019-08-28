package com.example.demo.security;

import com.example.demo.service.UsuarioDetailsService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class MyWebSecurity extends WebSecurityConfigurerAdapter{
    @Autowired
    private UsuarioDetailsService usuarioDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
            .csrf().disable().httpBasic().and()
            .authorizeRequests().antMatchers("/**").permitAll();
        
         http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/").hasAnyRole("ADMIN", "VIEWR", "VIEWW")
                .antMatchers(HttpMethod.GET, "/").hasAnyRole("ADMIN", "VIEWR", "VIEWW")
      
                .antMatchers(HttpMethod.POST, "/meses").hasAnyRole("ADMIN", "VIEWW")
                .antMatchers(HttpMethod.DELETE, "/meses").hasAnyRole("ADMIN", "VIEWW")
                .antMatchers(HttpMethod.GET, "/meses").hasAnyRole("ADMIN", "VIEWR", "VIEWW")
                 
                .antMatchers(HttpMethod.POST, "/despesas").hasAnyRole("ADMIN", "VIEWW")
                .antMatchers(HttpMethod.DELETE, "/despesas").hasAnyRole("ADMIN", "VIEWW")
                .antMatchers(HttpMethod.GET, "/despesas").hasAnyRole("ADMIN", "VIEWR", "VIEWW")
                 
                .antMatchers(HttpMethod.POST, "/receitas").hasAnyRole("ADMIN", "VIEWW")
                .antMatchers(HttpMethod.DELETE, "/receitas").hasAnyRole("ADMIN", "VIEWW")
                .antMatchers(HttpMethod.GET, "/receitas").hasAnyRole("ADMIN", "VIEWR", "VIEWW")
                
                //API
                .antMatchers(HttpMethod.POST, "api/meses").hasAnyRole("ADMIN", "RESTW")
                .antMatchers(HttpMethod.DELETE, "api/meses").hasAnyRole("ADMIN", "RESTW")
                .antMatchers(HttpMethod.GET, "api/meses").hasAnyRole("ADMIN", "RESTR", "RESTW")
                 
                .antMatchers(HttpMethod.POST, "api/despesas").hasAnyRole("ADMIN", "RESTW")
                .antMatchers(HttpMethod.DELETE, "api/despesas").hasAnyRole("ADMIN", "RESTW")
                .antMatchers(HttpMethod.GET, "api/despesas").hasAnyRole("ADMIN", "RESTR", "RESTW")
                 
                .antMatchers(HttpMethod.POST, "api/receitas").hasAnyRole("ADMIN", "RESTW")
                .antMatchers(HttpMethod.DELETE, "api/receitas").hasAnyRole("ADMIN", "RESTW")
                .antMatchers(HttpMethod.GET, "api/receitas").hasAnyRole("ADMIN", "RESTR", "RESTW")
                .and()
                .formLogin().successForwardUrl("/");
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioDetailsService)
               .passwordEncoder(new BCryptPasswordEncoder());

           //auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN");
        }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
        configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept","Authorization"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    
}
