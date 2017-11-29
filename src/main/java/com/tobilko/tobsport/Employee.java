package com.tobilko.tobsport;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Andrew Tobilko on 11/29/17.
 */
@Entity
@Getter
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String positionTitle;
    private LocalDate birthDate;

}
