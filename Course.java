package models;

public class Course {
    private String name;
    private String description;
    private int duration;
    private double price;
    private String startDate;
    private String teacher;

    // Constructor
    public Course(String name, String description, int duration, double price, String startDate, String teacher) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.startDate = startDate;
        this.teacher = teacher;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getDuration() { return duration; }
    public double getPrice() { return price; }
    public String getStartDate() { return startDate; }
    public String getTeacher() { return teacher; }
}
