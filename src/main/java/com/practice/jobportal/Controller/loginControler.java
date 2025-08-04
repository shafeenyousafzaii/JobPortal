package com.practice.jobportal.Controller;
import com.practice.jobportal.personInformation.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
public class loginControler {
    Person person;
    public loginControler(Person person) {
        this.person = person;
    }
//    @GetMapping("/login")
//    public loginControler login() {
//        return new loginControler(person);
//    }
  
                
    
//    @GetMapping("/signup")
//    public loginControler signup(){
//        this.person = new Person();    
//    }
}
