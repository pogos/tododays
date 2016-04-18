package pl.pogos.tododays.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sebastian on 14.03.2016.
 */
@Entity
@Table(name = "TAG")
public class Tag {

    @Id
    @GeneratedValue(generator = "TAG_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TAG_SEQ", initialValue = 50, sequenceName = "TAG_SEQ")
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "TAG", nullable = false, unique = true)
    private String tag;

    public Tag() {
    }

    public Tag(String tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
