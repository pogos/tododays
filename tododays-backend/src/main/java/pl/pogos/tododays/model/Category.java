package pl.pogos.tododays.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(generator = "CATEGORY_SG", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CATEGORY_SG", initialValue = 50)
    private Long id;

    @Size(max = 100)
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    private String description;

    private Boolean readOnly;

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
