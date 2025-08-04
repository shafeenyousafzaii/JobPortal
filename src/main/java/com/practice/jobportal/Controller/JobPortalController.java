package com.practice.jobportal.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobPortalController {
    private String[][] loginData = {
            {"shafeen", "shafeen"},
            {"admin", "admin123"},
            {"user"}};

    Logger logger = LoggerFactory.getLogger(JobPortalController.class);
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        logger.info("Logging Hello info");
        return
                "<h1>hello this is just to check that everything is set</>";
    }
    @GetMapping("/")
    public String home(){
        logger.info("User viewed Home Page.");
        return "Main";
    }
    @GetMapping("/login")
    public String userLogin(){
        try {
            logger.info("Logging login info for the user.");
            return "login";
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        try {

            boolean found = false; //found is if username and pass found then ok else no 
            for (int i = 0; i < loginData.length; i++) {
                if (loginData[i][0].equals(username) && loginData[i][1].equals(password)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                logger.info("User Login found : User logged in successfully");
                model.addAttribute("Username", username);
                model.addAttribute("Message", "Login successful!");
                return "Main";
            } else {
                logger.info("Login unseccessful , user not found");
                logger.info("Redirect user back to login page.");
                return "login";
            }
        }catch (Exception e) {
            logger.error("An error occurred during login: " + e.getMessage());
            model.addAttribute("Message", "An error occurred, please try again later.");
            return "error";
        }
        
    }
    
    @GetMapping("/error")
    public String error(Model model) {
//        logger.error("An error occurred, redirecting to error page.");
        
        model.addAttribute("Message", "An error occurred, please try again later.");
        return "error";
    }
    @GetMapping("/main")
    public String main(){
        logger.info("User viewed Main Page.");
        return "Main";
    }
        
}
