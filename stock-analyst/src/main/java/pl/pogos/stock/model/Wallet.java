package pl.pogos.stock.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "WALLET")
public class Wallet {

    @Id
    @GeneratedValue(generator = "WALLET_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "WALLET_SEQ", sequenceName = "WALLET_SEQ")
    private Long id;

    @NotNull
    private User user;

    @NotBlank
    private String name;

    @ManyToMany
    @JoinTable(name = "WALLET_SHARE")
    private Set<Share> shares;

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
