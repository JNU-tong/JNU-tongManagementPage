package hello;

import lombok.Data;

@Data
public class Manager {
    private Long num;
    private String id;
    private String role;
    private String password;

    @Override
    public String toString() {
        return "Manager{" +
                "num=" + num +
                ", id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
