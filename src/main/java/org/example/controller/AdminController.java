package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.services.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("db")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @GetMapping("/admin")
    public String userList(Model model){
        model.addAttribute("allUsers",userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true,defaultValue = "")Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model){
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String gtUser(@PathVariable("userId") Long userId, Model model){
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }

}
