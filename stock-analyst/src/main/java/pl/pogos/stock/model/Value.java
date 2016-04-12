package pl.pogos.stock.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by SG0952928 on 2016-04-12.
 */
@Entity
@Table(name = "SHARE_VALUE")
public class Value {

    @Id
    private Long id;

    @NotNull
    private Share share;

    @NotNull
    private Date timestamp;

    public Value() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
