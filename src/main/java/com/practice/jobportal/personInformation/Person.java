package com.practice.jobportal.personInformation;

import java.time.LocalDate;
import java.util.Date;

public class Person {
    private int idCounter = 0; // keeping track of ids.
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String gender;
    private enum genderEnum {
        MALE("Male"), FEMALE("Female");

        private final String gender;
        
        genderEnum(String gender) {
            this.gender = gender;
        }
        public String getValueForGender(){
            return this.gender;
        }
    }
    private String email;
    private String password;
    private String number;
    private LocalDate localTime;
    private Date job_start_date;
    private Date job_end_date;
    private enum Role_enum {
        // Getting names from AI  , OBVIOUSLY LOL . 
        INTERN("Intern"),
        TRAINEE_ENGINEER("Trainee Engineer"),
        JUNIOR_ENGINEER("Junior Engineer"),
        SOFTWARE_ENGINEER("Software Engineer"),
        ASSOCIATE_ENGINEER("Associate Engineer"),
        SENIOR_ENGINEER("Senior Engineer"),
        LEAD_ENGINEER("Lead Engineer"),
        STAFF_ENGINEER("Staff Engineer"),
        SENIOR_STAFF_ENGINEER("Senior Staff Engineer"),
        PRINCIPAL_ENGINEER("Principal Engineer"),
        DISTINGUISHED_ENGINEER("Distinguished Engineer"),
        FELLOW_ENGINEER("Fellow Engineer"),
        ENGINEERING_MANAGER("Engineering Manager"),
        SENIOR_ENGINEERING_MANAGER("Senior Engineering Manager"),
        DIRECTOR_OF_ENGINEERING("Director of Engineering"),
        SENIOR_DIRECTOR("Senior Director of Engineering"),
        VP_ENGINEERING("VP of Engineering"),
        CTO("Chief Technology Officer");

        private String role;

        Role_enum(String role) {
            this.role = role;
        }
    }
    private Role_enum role;
    public Person(){
        try{
            this.id=idCounter++;
        } catch (Exception e) {
            throw new RuntimeException("Creating Person with Same ID Failed",e);
        }
    }
    Person(int id){
        try {
            if (id < 0) {
                throw new IllegalArgumentException("ID cannot be negative");
            }
            if(this.id<=this.idCounter){
                throw new IllegalArgumentException("ID must be greater than the last assigned ID which is " + this.idCounter);
            }
            this.id = idCounter++;
            this.idCounter++;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    Person(int id, String firstname, String lastname){
        try {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void setId(int id) { //no access at user end
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setFirstname(String firstname) {
        try {
            this.firstname = firstname;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void setLastname(String lastname) {
        try {
            this.lastname = lastname;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getFirstname(){
        return this.firstname;
    }
    public String getLastname(){
        return this.lastname;
    }
    public int  getAge(){
        return this.age;
    }
    public void setAge(int age){
        try {
            if (this.age < 0) {
                throw new IllegalArgumentException("Age cannot be less than Zero");
            }
            this.age = age;
        }catch ( Exception e) {
        throw new RuntimeException(e);
        }    
    }
    public void setGender(String gender){
//        this.gender = gender.getValueForGender(gender.);
    }    
//    public genderEnum getGender(){
//        return this.gender;
//    }
}
    
