package pl.pogos.tododays.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sebastian on 14.03.2016.
 */
@Document(collection = "TAG")
public class Tag {

    @Id
    private String id;

    @NotNull
    @Size(max = 50)
    private String tag;

    public Tag() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
