package ba.posao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ba.posao.filters.JWTAuthenticationFilter;
import ba.posao.filters.JWTLoginFilter;
import ba.posao.services.KorisnikService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private KorisnikService korisnikServis;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        		.antMatchers("/izvjestaj/get/**").hasRole("ADMIN")
                .antMatchers("/kategorije/get/**").permitAll()
                .antMatchers(HttpMethod.POST, "/kategorije/add/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/kategorije/remove/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/kategorije/update/**").hasRole("ADMIN")
        		.antMatchers(HttpMethod.POST, "/korisnici/register/**").permitAll()
        		.antMatchers("/korisnici/get/all/**").hasRole("POSLODAVAC")
        		.antMatchers("/korisnici/get/exact/**").hasAnyRole("ADMIN", "POSLODAVAC", "NEZAPOSLENI")
                .antMatchers("/oglasi/all").permitAll()
                .antMatchers("/oglasi/get/**").permitAll()
                .antMatchers("/oglasi/search/**").permitAll()
                .antMatchers("/oglasi/get/poslodavac/**").hasRole("POSLODAVAC")
                .antMatchers(HttpMethod.POST, "/oglasi/postavioglas/**").hasRole("POSLODAVAC")
                .antMatchers(HttpMethod.DELETE, "/oglasi/remove/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/prijave/add/**").hasRole("NEZAPOSLENI")
                .antMatchers(HttpMethod.GET, "/poruke/get/sender/**").hasRole("POSLODAVAC")
                .antMatchers(HttpMethod.GET, "/poruke/get/**").hasAnyRole("NEZAPOSLENI", "POSLODAVAC")
                .antMatchers(HttpMethod.POST, "/poruke/send/**").hasRole("POSLODAVAC")
                .antMatchers(HttpMethod.POST, "/template/add/**").hasRole("ADMIN")
                .antMatchers("/template/get/all/**").hasAnyRole("POSLODAVAC", "ADMIN")
                .antMatchers("/template/").hasAnyRole("POSLODAVAC", "ADMIN")
                .antMatchers("/lokacije/get/**").permitAll()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers(HttpMethod.POST,"/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);


    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    auth.userDetailsService(korisnikServis); //nije testirano do kraja
    
   	/*auth.inMemoryAuthentication() // login za testnim podacima
        .withUser("admin")
        .password("password")
        .roles("ADMIN");*/

    }
}
