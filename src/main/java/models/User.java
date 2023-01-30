package models;

public class User {
    private String userNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;

    public User(String userNumber, String firstName, String lastName, String email, String age, String salary, String department) {
        this.userNumber = userNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public User() {
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String[] getUserDetails() {
        String[] details = {this.firstName, this.lastName, this.email, this.age, this.salary, this.department};
        return details;
    }

}

