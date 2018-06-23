package net.bgde.jbar.controller;

import net.bgde.jbar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.stream.Collectors;

@Controller
public class DashboardController {
    @GetMapping("/")
    public String getDashboard(){
        return "dashboard";
    }
}
