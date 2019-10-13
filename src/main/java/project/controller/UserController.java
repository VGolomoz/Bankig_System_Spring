package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.User;
import project.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
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
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping("/add")
    public String add(Model model) {
        User u = new User();
        u.setEmail("myEmail");
        u.setPassword("myPassword");
        System.out.println(u);
        userRepository.save(u);
        model.addAttribute("user", u);
        return "greeting";
    }
}