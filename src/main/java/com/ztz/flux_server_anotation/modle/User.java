package com.ztz.flux_server_anotation.modle;

/**
 * @Date 2019/3/4 16:24.
 */
public class User {
    private String id;
    private String name;
    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "id_" + id + " " + "name_" + name + " " + "email_" + email;
    }
}
