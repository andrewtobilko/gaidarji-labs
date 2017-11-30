package com.tobilko.tobsport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tobilko.tobsport.controller.EmployeeHandler.STATE;

/**
 * Created by Andrew Tobilko on 11/30/17.
 */
@RestController
public class UpdateController {

    @GetMapping(path = "/state")
    public boolean getState() {
        return STATE.get() ? STATE.getAndSet(false) : STATE.get();
    }

}
