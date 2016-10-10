package data;

public enum User {

    INVALID_PASSWORD_USER(
            "user",
            "valid@email.com",
            "pswd"
    ),

    INVALID_EMAIL_USER(
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
