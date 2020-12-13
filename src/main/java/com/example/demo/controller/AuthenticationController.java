package com.example.demo.controller;

import com.example.demo.entity.ApplicationUser;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@Controller
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/loginForm")
    public String getLoginForm(Model model) {
        model.addAttribute("maybeUser", new ApplicationUser());
        return "loginForm";
    }

    @PostMapping("/loginForm")
    public void processLoginAttempt(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @ModelAttribute("maybeUser") ApplicationUser applicationUser) throws IOException {

        Optional<ApplicationUser> maybeUser = userService.login(applicationUser);


        if (maybeUser.isPresent()) {
            String accountType = maybeUser.get().getAccountType().getAccountType();
            HttpSession session = request.getSession(true);
            switch (accountType) {
                case "customer":

                    ApplicationUser customer = userService.findUserByLogin(maybeUser.get().getLogin());
                    session.setAttribute("customer", customer);
                    response.sendRedirect(request.getContextPath() + "/customer/galleries");
                    break;
                case "photographer":

                    ApplicationUser photographer = userService.findUserByLogin(maybeUser.get().getLogin());
                    session.setAttribute("photographer", photographer);
                    response.sendRedirect(request.getContextPath() + "/photographer/users");
                    break;
            }
        } else {

            response.sendRedirect(request.getContextPath() + "/loginForm");
        }
    }


}
