package com.example.springboottodo.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @Size(min=3,message = "Enter at least 3 characters")
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @FutureOrPresent(message = "date cannot be in past")
    private LocalDate targetDate;

    private boolean status;
}
