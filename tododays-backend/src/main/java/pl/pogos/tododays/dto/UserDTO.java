package pl.pogos.tododays.dto;

public class UserDTO {

    private Long id;

    private String login;
    private String password;

    private String name;

    public UserDTO() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class UserBuilder {

        private UserDTO user = new UserDTO();

        public UserBuilder withId(Long id) {
            this.user.setId(id);
            return this;
        }

        public UserBuilder withLogin(String login) {
            this.user.setLogin(login);
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.user.setPassword(password);
            return this;
        }

        public UserBuilder withName(String name) {
            this.user.setName(name);
            return this;
        }

        public UserDTO build() {
            return user;
        }

    }
}
