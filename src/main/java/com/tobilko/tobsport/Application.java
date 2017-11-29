package com.tobilko.tobsport;

import com.tobilko.tobsport.entity.Employee;
import com.tobilko.tobsport.repository.EmployeeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;

/**
 * Created by Andrew Tobilko on 11/29/17.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner getRunner(EmployeeRepository repository) {
        return args -> {

            for (int i = 0; i < 10; i++) {
                final Employee employee = new Employee();
                fillEmployeeRandomly(employee);
                repository.save(employee);
            }

        };
    }

    private void fillEmployeeRandomly(Employee employee) {
        final String[] names = {"Andrew", "Mike", "Jack", "Sam", "Ann", "Janifer", "Faith"};
        final String[] positions = {"SEO", "COO", "CFO", "Secretary", "HR", "Janitor", "Guard"};
        final Random random = new Random();

        employee.setName(names[random.nextInt(names.length)]);
        employee.setPositionTitle(positions[random.nextInt(names.length)]);
        employee.setBirthDate(LocalDate.of(
                generateIntBetween(random, 1950, 2000),
                generateIntBetween(random, 1, 12),
                generateIntBetween(random, 1, 28)));

    }

    private int generateIntBetween(Random random, int lowerBound, int upperBound) {
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

}