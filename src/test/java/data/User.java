package data;

public enum User {

    INVALID_USER(
            "user",
            "invalid.email",
            "securepassword"
    );

    public String name;
    public String email;
    public String password;

    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
