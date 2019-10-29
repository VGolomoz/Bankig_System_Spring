package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.Client;
import project.model.Credit;
import project.service.ClientService;
import project.service.CreditService;

@Controller
@RequestMapping("credit")
public class CreditController {

    @Autowired
    CreditService creditService;

    @Autowired
    ClientService clientService;

    private Client dbClient;

    @GetMapping
    public String openCreditAccount(Authentication authentication, Model model) {

        dbClient = clientService.findByEmail(authentication.getName());
        Credit credit = dbClient.getClientAccount().getCredit();
        if (credit != null) {
            model.addAttribute("credit", credit);
            model.addAttribute("client", dbClient);
            return "credit";
        }
        else return "open_credit";
    }

    @PostMapping
    public String createCreditAccount(@RequestParam String currency,
                                      @RequestParam String limit,
                                      @RequestParam String rate,
                                      Credit credit, Model model) {
        creditService.addCredit(currency, limit, rate, dbClient.getClientAccount(), credit);
        clientService.updateClient(dbClient);
        return "redirect:/credit";

    }
}
