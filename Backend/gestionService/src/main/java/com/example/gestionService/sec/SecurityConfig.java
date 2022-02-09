package com.example.gestionService.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers(HttpMethod.GET,"/immobilier/allImmobilier").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/immobilier/listImmobilier/**").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.GET,"/immobilier/getImmobilier/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/immobilier/listVisibleImmobilier/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/immobilier/trans/actions/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/immobilier/immobilierDetails/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/immobilier/saveImmobilier/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/immobilier/modifyImombilier/**").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.GET,"/transaction/allTransactions/**").permitAll();

        http.authorizeRequests().antMatchers("/immobilier/changeAnnouncement/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/immobilier/changeAnnouncement/**").hasAuthority("USER");

//     //   http.authorizeRequests().antMatchers("/transactions/**").hasAuthority("ADMIN");
//      //  http.authorizeRequests().antMatchers("/transactions/**").hasAuthority("USER");
//       /* http.authorizeRequests().antMatchers("/categories/**").hasAuthority("ADMIN");
//        http.authorizeRequests().antMatchers("/categories/**").hasAuthority("ADMIN");
//        http.authorizeRequests().antMatchers("/products/**").hasAuthority("USER"); */
//        http.authorizeRequests().anyRequest().authenticated();
//        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}

@Configuration
class DevCorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
    }
}