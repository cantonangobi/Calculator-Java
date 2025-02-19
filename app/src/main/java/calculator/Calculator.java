package main.java.calculator;

import java.util.Scanner;

public class Calculator {
    private double num1, num2, answer;
    public String operator, expression;

    public Calculator(){
        num1 = 0;
        num2 = 0;
        answer = 0;
        expression = "Expression:\t";
    }
    public void displayExpression(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();     
        System.out.println(" _______________________________________________________________________");
        System.out.println("|                                                                       |");
        System.out.println("|                             Calculator                                |");
        System.out.println("|_______________________________________________________________________|");
        System.out.println("|                                                                       |");
        System.out.println("| " + expression);
        System.out.println("|_______________________________________________________________________|");
    }
    public double getNumInput(){
        double num = 0;
        while (true){
            try{
                System.out.print("Enter a number: ");
                num = new Scanner(System.in).nextDouble();
            }
            catch (Exception e){
                displayExpression();
                System.out.println("Invalid Input! Please try again");
                continue;
            }
            break;
        }
        
        return num;
        
    }
    public void getOperatorInput(){
        System.out.print("The operations are as follows: +, -, x, /\n" + //
                        "Please choose an operation: ");
        operator = new Scanner(System.in).next();
    }
    public boolean calculate(){
        if (operator.equals("+")) {
            answer = num1 + num2;
        }
        else if (operator.equals("-")) {
            answer = num1 - num2;
        }
        else if (operator.equals("x")) {
            answer = num1 * num2;
        }
        else if (operator.equals("/")) {
            answer = num1 / num2;
        }
        else {
            //System.out.println("Invalid Operator!");
            return false;
        }
        return true;
    }
    public String formatDouble(double num){
        if ((num*10) % 10 == 0){
            return String.format("%.0f",num);
        } 
        return String.valueOf(num);
    }

    public void runAppUI(){
        displayExpression();

        num1 = getNumInput();
        expression = expression + formatDouble(num1);
        displayExpression();

        getOperatorInput();
        expression = expression + " " + operator + " ";
        displayExpression();

        num2 = getNumInput();
        if(calculate()){
            expression = expression + formatDouble(num2) + " = " + formatDouble(answer);
        }
        else{
            expression = "Invalid Expression!";
        }
        
        displayExpression();


    }
}
