package pl.pogos.tododays.dto;

import pl.pogos.tododays.model.TaskPriority;
import pl.pogos.tododays.model.TaskStatus;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


public class TaskDTO extends ResponseDTO {

    private Long id;

    @NotNull
    @Size(min = 5, max = 255)
    private String name;

    private String description;

    private Date createDate;

    private Date lastUpdate;

    private Date closeDate;

    private Boolean removed;

    private TaskStatus status;

    private TaskPriority priority;

    public TaskDTO() {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public static class TaskDTOBuilder {

        private TaskDTO taskDTO = new TaskDTO();

        public TaskDTOBuilder withName(String name) {
            this.taskDTO.setName(name);
            return this;
        }

        public TaskDTOBuilder withStatus(TaskStatus status) {
            this.taskDTO.setStatus(status);
            return this;
        }

        public TaskDTO build() {
            return this.taskDTO;
        }

    }
}
