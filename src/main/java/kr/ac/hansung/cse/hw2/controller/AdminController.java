package kr.ac.hansung.cse.hw2.controller;

import kr.ac.hansung.cse.hw2.entity.MyUser;
import kr.ac.hansung.cse.hw2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin/users")
    public String viewAllUsers(Model model) {
        List<MyUser> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "adminPage";
    }
}