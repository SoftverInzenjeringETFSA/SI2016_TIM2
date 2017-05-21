package ba.posao.filters;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ba.posao.models.Korisnici;
import ba.posao.repositories.KorisnikRepository;
import ba.posao.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
   
	//@Autowired
    private KorisnikRepository korisnikRepository;

    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {


        AccountCredentials creds;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept, X-Requested-With, remember-me, Access-Control-Allow-Headers, Origin, Access-Control-Request-Method, Access-Control-Request-Headers");
        res.setHeader("Access-Control-Expose-Headers", "Authorization");
        if(!req.getMethod().equals("POST")) {
            creds = new AccountCredentials();
            creds.setUsername("");
            creds.setPassword("");
        } else {
            creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);
        }
        

        byte[] pass = null;
        
        try {
			pass = creds.getPassword().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		StringBuffer hexString = new StringBuffer();
		
		byte[] passHash = m.digest(pass);
		
		for (int i = 0; i < passHash.length; i++) {
		    if ((0xff & passHash[i]) < 0x10) {
		        hexString.append("0"
		                + Integer.toHexString((0xFF & passHash[i])));
		    } else {
		        hexString.append(Integer.toHexString(0xFF & passHash[i]));
		    }
		}
				
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        creds.getUsername(),
                        hexString.toString(),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        TokenAuthenticationService.addAuthentication(res, auth.getName(), req.getServletContext());
        res.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

}
