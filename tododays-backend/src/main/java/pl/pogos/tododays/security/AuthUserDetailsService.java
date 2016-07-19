package pl.pogos.tododays.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    private Map<String, AuthUser> users = new HashMap<>();

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthUserDetailsService() {
        users.put("admin", new AuthUser("admin", encoder.encode("koala"), true, expirationDate(), "ADMIN"));
        users.put("admin2", new AuthUser("admin2", encoder.encode("koala"), true, expirationDate(), "ADMIN"));
        users.put("user", new AuthUser("user", encoder.encode("koala"), true, expirationDate(), "USER"));
        users.put("user2", new AuthUser("user2", encoder.encode("koala"), true, expirationDate(), "USER"));
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        if (users.containsKey(name)) {
            return users.get(name);
        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }

    private Date expirationDate() {
        return java.sql.Date.from(
                LocalDate
                        .now()
                        .plusDays(30)
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );
    }

    static class AuthUser implements UserDetails {

        private String username;
        private String password;
        private boolean enabled;
        private Date expirationDate;

        private List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        public AuthUser() {
        }

        public AuthUser(String username, String password, boolean enabled, Date expirationDate, String role) {
            this.username = username;
            this.password = password;
            this.enabled = enabled;
            this.expirationDate = expirationDate;
            this.authorities.add(new SimpleGrantedAuthority(role));
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
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
            return enabled;
        }
    }
}
