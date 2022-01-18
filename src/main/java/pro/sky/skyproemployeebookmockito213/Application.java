package pro.sky.skyproemployeebookmockito213;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
/*
http://localhost:8080/employee/add?firstName=Sergei&lastName=Petrov&department=1&salary=10000
http://localhost:8080/department/max-salary?departmentId=1
 */