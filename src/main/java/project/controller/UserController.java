package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.Client;
import project.repository.UserRepository;
import project.util.UserRole;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

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

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Client> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping("/add")
    public String add(Model model) {
        Client c = new Client();
        c.setEmail("myEmail");
        c.setPassword("myPassword");
        c.setRole(UserRole.USER);
        System.out.println(c);
        userRepository.save(c);
        model.addAttribute("client", c);
        return "greeting";
    }
}