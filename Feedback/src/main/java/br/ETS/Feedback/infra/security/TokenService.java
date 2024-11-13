package br.ETS.Feedback.infra.security;

import br.ETS.Feedback.model.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario){
        try {
            var algorithm = Algorithm.HMAC256("123456789");
            return JWT.create()
                    .withSubject(usuario.getLogin())
                    .withIssuer("Feedback")
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException(exception);
        }
    }

    private Instant dataExpiracao(){
        // Pegar a hora de agora, mais 2 horas, tranformar para instante, e definir o periodo que ele está
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
