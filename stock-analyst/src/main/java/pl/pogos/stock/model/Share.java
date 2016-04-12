package pl.pogos.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by SG0952928 on 2016-04-12.
 */
@Entity
@Table(name = "SHARE")
public class Share {

    @Id
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
