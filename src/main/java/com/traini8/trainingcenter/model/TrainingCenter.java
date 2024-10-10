package com.traini8.trainingcenter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;
import jakarta.validation.Valid;
@Entity
@Table(name = "training_centers")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID is auto-generated

    @Column(length = 40, nullable = false)
    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @Column(length = 12, nullable = false, unique = true)
    @NotBlank(message = "Center code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Valid
    @Embedded
    private Address address;  // Embedded Address object that will be validated

    @Min(value = 1, message = "Student capacity must be at least 1")
    private int studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    private long createdOn;

    @Email(message = "Invalid email address")
    private String contactEmail;

    @Pattern(regexp = "^\\d{10}$", message = "Contact phone must be a valid 10-digit number")
    private String contactPhone;

    @PrePersist
    protected void onCreate() {
        this.createdOn = System.currentTimeMillis();  // Set server timestamp on creation
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public List<String> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<String> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
