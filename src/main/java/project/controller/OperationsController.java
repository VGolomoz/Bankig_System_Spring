package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.service.OperationsService;

@Controller
@RequestMapping("operations")
public class OperationsController {

    @Autowired
    private OperationsService operationsService;

    @GetMapping
    public String getOperationsPage() {
        return "operations";
    }

    @PostMapping
    public void operationReplenishment(){

    }
}
