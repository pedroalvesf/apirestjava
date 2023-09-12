package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.voll.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String gerarToken(Usuario usuario) {
        System.out.println(secret);
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Voll.med")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        } catch(JWTCreationException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    public String getSubject(String token) {
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.require(algoritimo)
                    .withIssuer("API Voll.med")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch(JWTCreationException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException("Token invalido ou expirado", exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(96).toInstant(ZoneOffset.of("-03:00"));
    }
}
