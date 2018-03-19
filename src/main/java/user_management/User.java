package user_management;

import user_management.security.Password;

public class User {

    public String email;
    public Integer id;
    public String name;
    public Password password;

    public User(Integer id, String name, String email, Password password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String email, Integer id, String name, String password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = new Password(password);
    }

    @Override
    public String toString() {
        return this.name + " - " + this.email;
    }

    @Override
    public boolean equals(Object obj) {
        User newUser = (User) obj;
        if(this.name.equals(newUser.getName())
                && this.id.equals(newUser.id)
                && this.email.equals(newUser.getEmail())) {
            return true;
        }
        return false;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = new Password(password);
    }

    public String getEmail() {
        return email;
    }

    public Object getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
