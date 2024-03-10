package com.example.lab5porjecttracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectTracker {
    private String ID;
    private String title;
    private String description;
    private String status;
    private String companyName;
}
