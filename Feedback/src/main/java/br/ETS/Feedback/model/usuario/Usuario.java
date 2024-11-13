package br.ETS.Feedback.model.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Usuario")
@Table(name = "tbUsuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String senha;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    // Retorna true se a conta do usuário não estiver expirada; você pode implementar uma lógica baseada em uma condição específica.
    // Suponha que você tenha um campo booleano 'accountExpired' no seu objeto de usuário.
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    // Retorna true se a conta não estiver bloqueada; por exemplo, você pode ter uma propriedade 'accountLocked' no usuário.
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    // Retorna true se as credenciais do usuário (senha) não tiverem expirado. Um campo 'credentialsExpired' poderia ser usado aqui.
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    // Retorna true se a conta do usuário estiver habilitada. Exemplo de um campo 'enabled' para controlar esse estado.
    public boolean isEnabled() {
        return true;
    }
}
