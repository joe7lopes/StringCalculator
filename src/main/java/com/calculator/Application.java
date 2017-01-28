package com.calculator;

import com.calculator.services.StringCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private StringCalculatorService stringCalculatorService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Enter the value: \n");
        String input;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            input = scanner.next();
            //Needed bcs of input from console.
            String input2=input.replaceAll("\\\\n", "\n");
            System.out.println(stringCalculatorService.add(input2));
        }
        scanner.close();
    }
}
