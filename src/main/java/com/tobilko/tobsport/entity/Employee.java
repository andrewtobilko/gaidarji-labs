package com.tobilko.tobsport.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Andrew Tobilko on 11/29/17.
 */
@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String positionTitle;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate birthDate;

}
