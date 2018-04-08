/*
package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

// need to edit
@Controller
public class LoginController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String login(Model model, HttpSession session) {
        String id = session.getAttribute("id") == null ? (String) session.getAttribute("id") : "";
        model.addAttribute("id", id);
        return "login";
    }

    @RequestMapping(value = "loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(@RequestParam("user_id") String id,
                                     @RequestParam("user_password") String password,
                                     Model model, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        System.out.println(id);
        System.out.println(password);

        if ("123".equals(password)) {
            session.setAttribute("id", id);
        } else {

        }

        mv.setViewName("redirect:/login");
        return mv;
    }

    @RequestMapping("/logout")
    public ModelAndView loginProcess(Model model, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        session.invalidate();
        mv.setViewName("redirect:/login");
        return mv;
    }
}
*/
