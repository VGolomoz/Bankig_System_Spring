package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.Client;
import project.model.ClientAccount;
import project.model.ClientDetails;
import project.service.ClientService;

@Controller
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping
    public String registration(){
        return "registration";

    }

    @PostMapping
    public String addClient(@RequestParam String email,
                            @RequestParam String password,
                            Client client, ClientDetails clientDetails, ClientAccount clientAccount, Model model) {

        String passHash = passwordEncoder.encode(password);
        if ("".equals(email) ||
                !clientService.addClient(email, passHash, client, clientDetails, clientAccount)) {
            model.addAttribute("exists", true);
            model.addAttribute("email", email);
            return "registration";
        }

        return "redirect:/login";
    }
}
