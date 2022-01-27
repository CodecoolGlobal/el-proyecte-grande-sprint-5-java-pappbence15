package com.codecool.progresstracker;

import com.codecool.progresstracker.data_sample.CreateMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.ParseException;

@SpringBootApplication
public class ProgressTrackerApplication {

    @Autowired
    CreateMockData createMockData;

    public static void main(String[] args) {
        SpringApplication.run(ProgressTrackerApplication.class, args);
    }

    @PostConstruct
    public void seedDatabase() {
        createMockData.spamMockData();
    }

}
