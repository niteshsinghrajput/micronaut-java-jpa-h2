package com.nitesh.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;

@Entity
@Serdeable
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Contact is required.")
    private String contact;

    @NotBlank(message = "Email is required.")
    @Email
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
