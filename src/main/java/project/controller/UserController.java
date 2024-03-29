package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.Client;
import project.repository.ClientRepository;
import project.service.ClientService;
import project.util.UserRole;

@Controller
public class UserController {

    @Autowired
    private ClientService clientService;


    //    @GetMapping("/")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";
//    }


//    @PostMapping(path = "/add")
//    public @ResponseBody
//    String addNewUser(@RequestParam String email, @RequestParam String password) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        User u = new User();
//        u.setEmail(email);
//        u.setPassword(password);
//        userRepository.save(u);
//        return "Saved";
//    }


    @GetMapping("/client")
    public String getClient(Model model, Authentication authentication) {
        Client dbClient = clientService.findByEmail(authentication.getName());
        model.addAttribute("client", dbClient);
        return "client";
    }
}