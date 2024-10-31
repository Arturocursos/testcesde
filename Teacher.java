package models;

public class Teacher {
    private String name;
    private String document;
    private String email;

    // Constructor
    public Teacher(String name, String document, String email) {
        this.name = name;
        this.document = document;
        this.email = email;
    }

    // Getters
    public String getName() { return name; }
    public String getDocument() { return document; }
    public String getEmail() { return email; }
}
