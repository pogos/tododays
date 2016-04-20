package pl.pogos.stock.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SHARE")
public class Share {

    @Id
    @GeneratedValue(generator = "SHARE_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SHARE_SEQ", sequenceName = "SHARE_SEQ")
    private Long id;

    @NotNull
    @Column(name = "SYMBOL", unique = true)
    private String symbol;

    @NotNull
    private String name;

    public Share() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
