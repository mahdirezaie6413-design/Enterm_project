package com.mahdirezaie.enterm_project.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class PrintedBook extends Book {
    private int numberOfPages;
    private double weight;
}