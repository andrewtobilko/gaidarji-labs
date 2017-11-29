package com.tobilko.tobsport;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Andrew Tobilko on 11/29/17.
 */
@Entity
@Getter
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Employee head;

}
