package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.Client;
import project.model.ClientAccount;
import project.model.Deposit;
import project.service.ClientService;
import project.service.DepositService;

@Controller
public class DepositController {

    @Autowired
    DepositService depositService;

    @Autowired
    ClientService clientService;

    private Client dbClient;

    @GetMapping("/deposit")
    public String openDepositAccount(Authentication authentication, Model model) {

        dbClient = clientService.findByEmail(authentication.getName());
        if (dbClient.getClientAccount().getDeposit() != null) {
            model.addAttribute("deposit", dbClient.getClientAccount().getDeposit());
            model.addAttribute("client", dbClient);
            return "deposit";
        }
        else return "open_deposit";
    }

    @PostMapping ("/deposit")
    public String createDepositAccount(@RequestParam String currency,
                                       @RequestParam String rate,
                                       Deposit deposit, Model model) {
        depositService.addDeposit(currency, rate, dbClient.getClientAccount(), deposit);
        clientService.updateClient(dbClient);
        model.addAttribute("deposit", deposit);
        model.addAttribute("client", dbClient);
        return "deposit";

    }
}
