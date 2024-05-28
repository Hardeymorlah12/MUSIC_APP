package com.Hardeymorlah.PowerUserApplication.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
@Entity
@Table(name = "power_User", uniqueConstraints = @UniqueConstraint(columnNames = {"phone_number","email"}) )
public class PowerUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
    @NotNull(message = "First Name can't be null")
    @NotBlank
//    @Length(min = 3, max = 25, message = "First Name can;t be less than 3 characters")
    @Length(min = 3)
    private String firstName;
    @NotNull(message = "Last Name can't be null")
    @NotBlank
    @Length(min = 3, message = "Last Name can't be less than 3 characters")
    private String lastName;
    private String address;
    @Email(message = "Must be a valid email address")
    private String email;
    @Pattern(regexp = "[0-9]{11}", message = "Phone Number must be numbers between 0 and 9 and must be 11 digits")
    private String phoneNumber;
    private String course;
    public PowerUsers(){}

    public PowerUsers(int id, String firstName, String lastName, String address, String email, String phoneNumber, String course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.course = course;
    }

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
