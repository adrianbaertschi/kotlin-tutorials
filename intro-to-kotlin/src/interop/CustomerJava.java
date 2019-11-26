package interop;

import org.jetbrains.annotations.NotNull;

public class CustomerJava {
    private int id;
    private String name;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public @NotNull String neverNull() {
        return "asdf";
    }

    public String maybeNull() {
        return "asdf";
    }

    public void prettyPrint() {
        System.out.println("Id: " + this.id + ", Name: " + this.name);
    }
}
