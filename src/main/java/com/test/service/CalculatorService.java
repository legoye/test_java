package com.test.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class CalculatorService {

    @Autowired
    private Calculator calculator;

    public double calculateAverage(int... items) {
        return calculator.average(items);
    }


    class MyBaseC extends Exception{

    }

    class MyDerived extends  MyBaseC{

    }
    public void main(String[] args) {

        try{
            throw new MyDerived();
        }catch (MyBaseC b){
            System.out.println("fasdf");
        }


        int i1= 5;
        int i2= 2;
        int i3= i1/i2;
        System.out.println(i3);

        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
        config.register(Config.class);
        config.refresh();

        CalculatorService service = config.getBean(CalculatorService.class);
        System.out.println(service.calculateAverage(10, 20));
    }
}

@Component
class CalculatorImplemenation implements Calculator {
    public double average(int... items) {
        int sum = 0;
        for(int item : items) {
            sum += item;
        }
        return sum / ((double) items.length);
    }
}

interface Calculator {
    public double average(int... items);
}

@Configuration
@Import(CalculatorService.class)
class Config {
    @Bean
    public Calculator calculator() {
        return new CalculatorImplemenation();
    }
}