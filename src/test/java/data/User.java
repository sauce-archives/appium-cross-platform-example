package data;

public enum User {
    VALID_USER(
            "Chris",
            "chris+" + timestamp() + "@testobject.com",
            "securepassword"
    );

    public String name;
    public String email;
    public String password;

    private static String timestamp() {
        long timestamp = System.currentTimeMillis();
        return String.valueOf(timestamp);
    }

    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
