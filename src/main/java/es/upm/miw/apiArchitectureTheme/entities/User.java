package es.upm.miw.apiArchitectureTheme.entities;

import java.util.List;

public class User {

    private int id;

    private String nick;
    
    private String email;
    
    private List<Sport> sports;;

    public User() {
    }

    public User(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User [nick=" + nick + ", email=" + email + "]";
    }

    public List<User> getSports() {
        // TODO Auto-generated method stub
        return null;
    }

}
