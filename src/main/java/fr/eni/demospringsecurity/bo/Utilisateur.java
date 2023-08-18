package fr.eni.demospringsecurity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * methode static
 */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Utilisateur {
//
//    private Integer id;
//    private String username;
//    private String password;
//    private String email;
//    private List<String> roles;
//
//}

/**
 * etape 1
 * etape 2 on cree service
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private List<String> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthList = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            grantedAuthList.add(new SimpleGrantedAuthority(role));
        }
        return grantedAuthList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
