package com.expensetracker.expensebackend.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@NotBlank(message = "Title is mandatory")
    private String title;
     @Positive(message = "Amount must be greater than 0")
    private double amount;
     @NotNull(message = "Date is required")
      @JsonFormat(pattern = "yyyy-MM-dd") 
    private LocalDate date;

    // Constructors
    public Expense() {}

    public Expense(String title, double amount, LocalDate date) {
        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}

