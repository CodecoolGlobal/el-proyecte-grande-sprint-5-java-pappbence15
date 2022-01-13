package com.codecool.progresstracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ProjectDTO {
    private String name;
    private String ownerEmail;
    private String adminEmail;
}
