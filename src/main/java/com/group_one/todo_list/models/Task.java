package com.group_one.todo_list.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "due_date")
    private LocalDate dueDate;

    // many tasks to one household
    @ManyToOne
    @JoinColumn(name = "household_id")
    @JsonIgnoreProperties({"tasks", "users"})
    private Household household;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"tasks", "household"})
    private User user;

    public Task(String description, Category category, LocalDate dueDate, Household household) {
        this.description = description;
        this.category = category;
        this.status = Status.NOT_STARTED;
        this.dueDate = dueDate;
        this.household = household;
        this.user = null;
    }

    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
