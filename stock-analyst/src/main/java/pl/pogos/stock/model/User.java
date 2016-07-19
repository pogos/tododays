package pl.pogos.stock.model;

import ch.qos.logback.core.joran.spi.NoAutoStart;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", initialValue = 20)
    private Long id;

    @NotNull
    private String login;

    @NotNull
    private String password;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
