package com.tobilko.tobsport.controller;

import com.tobilko.tobsport.entity.Employee;
import org.springframework.data.rest.core.annotation.*;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Andrew Tobilko on 11/30/17.
 */
@RepositoryEventHandler
public class EmployeeHandler {

    public static final AtomicReference<Boolean> STATE = new AtomicReference<>(false);

    @HandleAfterCreate
    @HandleAfterDelete
    @HandleAfterLinkDelete
    @HandleAfterLinkSave
    @HandleAfterSave
    @HandleBeforeCreate
    @HandleBeforeDelete
    @HandleBeforeLinkDelete
    @HandleBeforeLinkSave
    @HandleBeforeSave
    public void handleEmployee(Employee employee) {
        STATE.set(true);
    }

}