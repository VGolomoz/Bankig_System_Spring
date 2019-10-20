package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.Client;
import project.model.ClientAccount;
import project.model.ClientDetails;
import project.repository.ClientRepository;
import project.util.UserRole;

import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private ClientRepository clientRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("registration")
    public String addClient(Client client, ClientDetails clientDetails, ClientAccount clientAccount, Model model) {
        Client clientFromDB = clientRepository.findByEmail(client.getEmail());
        if (clientFromDB != null) {
            model.addAttribute("message", "Client exists!");
            return "registration";
        }

        client.setRole(UserRole.CLIENT);
        clientAccount.setBalance(0.0);
        clientAccount.setValidity(new Date());
        clientAccount.setClientDetails(clientDetails);
        clientAccount.setClient(client);
        client.setClientAccount(clientAccount);
        clientRepository.save(client);
        return "redirect:/login";
    }
}
