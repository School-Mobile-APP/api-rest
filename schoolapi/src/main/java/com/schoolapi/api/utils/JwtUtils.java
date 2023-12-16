package com.schoolapi.api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtils {
	//Puede ser cambiada esta clave secreta
    private static String secret = "This_is_secret";
    private static long expiryDuration = 60 * 120;
    //Verifica la validez del codigo que genera la app
    public Boolean checkCode(String code) {
    	try{
    	    UUID uuid = UUID.fromString(code);
    	} catch (IllegalArgumentException exception){
    	   return false;
    	}
    	return true;
    }
    //Genera el jwtToken
    public String generateJwt(String code){

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        // claims
        Claims claims = Jwts.claims()
                .setIssuer(code)
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        // optional claims
        claims.put("type", code);

        // generate jwt using claims
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    //Verifica el jwt
    public Claims verify(String authorization,String code) throws Exception {

        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
            return claims;
        } catch(Exception e) {
            throw new Exception();
        }

    }
    //Verifica la validez del jwt
    public Boolean checkToken(String token,String code) {
    	Claims oClaims;
		try {
			oClaims = verify(token, code);
			if(oClaims.getIssuer().toString().equals(code) && oClaims.getExpiration().after(new Date())) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
    }
}