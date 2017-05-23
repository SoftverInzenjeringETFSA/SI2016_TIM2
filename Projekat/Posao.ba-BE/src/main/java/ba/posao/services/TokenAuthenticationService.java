package ba.posao.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security
        .authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ba.posao.models.Korisnik;
import ba.posao.repositories.KorisnikRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static java.util.Collections.emptyList;

public class TokenAuthenticationService {

    private static KorisnikRepository korisnikRepository;
    private static KorisnikService korisnikServis;

    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";
    static final String ROLE = "role";
    static final String USER = "user";
    static final String USERID = "userid";

    public static void addAuthentication(HttpServletResponse res, String username, ServletContext servletContext) {
    	KorisnikService ks = WebApplicationContextUtils.getWebApplicationContext(servletContext).getBean(KorisnikService.class);
    	String role = ks.getKorisnikTypeByUserName(username);
    	String k = ks.getKorisnikByUserName(username).getIdKorisnika().toString();
    	/*Korisnici userAccount = korisnikRepository.findByUsername(username);
    	String role;
    	
    	if (userAccount.getNezaposleni() != null){
    		role = "nezaposleni";
    	}
    	else if (userAccount.getPoslodavac() != null){
    		role = "poslodavac";
    	}
    	else if (userAccount.getAdmin() != null){
    		role = "admin";
    	}else{
    		role = "";
    	}
    	*/
    	
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .claim(ROLE, role)
                .claim(USERID, k)
                //.claim(USER, user)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    public static Authentication getAuthentication(HttpServletRequest request) {

        ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        korisnikRepository = webApplicationContext.getBean(KorisnikRepository.class);
        korisnikServis = webApplicationContext.getBean(KorisnikService.class);
        
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            Korisnik userAccount = korisnikRepository.findByUsername(user);
            
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            if(userAccount != null) {
                authorities.add(new SimpleGrantedAuthority(korisnikServis.getKorisnikTypeByUserName(userAccount.getUsername())));
            }

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, authorities) :
                    null;
        }
        return null;
    }
}

