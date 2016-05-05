package pl.pogos.tododays.dto;


public class CategoryDTO extends ResponseDTO {

    private Long id;

    private String name;

    private String description;

    private Boolean readOnly;

    public CategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
