package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("usersList", userService.listUsers());
        return "users";
    }

    @PostMapping("/save/")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.remove(id);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable long id,
                           @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @GetMapping("/edit/user/{id}")
    public String editUserForm(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }
}
