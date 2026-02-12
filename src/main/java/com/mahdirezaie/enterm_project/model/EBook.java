package com.mahdirezaie.enterm_project.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class EBook extends Book {
    private String downloadUrl;
    private double fileSize;
}