package com.tobilko.tobsport.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.tobilko.tobsport.controller.EmployeeHandler;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Andrew Tobilko on 11/29/17.
 */
@Entity
@Getter
@Setter
@EntityListeners(EmployeeHandler.class)
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String positionTitle;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate birthDate;

}
