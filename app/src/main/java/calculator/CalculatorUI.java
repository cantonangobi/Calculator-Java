package calculator;

import java.util.Scanner;

public class CalculatorUI {
    private Calculator calc;

    public CalculatorUI(){
        calc = new Calculator();
    }

    public void displayExpression(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();     
        System.out.println(" _______________________________________________________________________");
        System.out.println("|                                                                       |");
        System.out.println("|                             Calculator                                |");
        System.out.println("|_______________________________________________________________________|");
        System.out.println("|                                                                       |");
        System.out.println("| " + calc.getExpression());
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
        calc.setOperator(new Scanner(System.in).next());
    }
   
    
    public void runAppUI(){
        displayExpression();

        calc.setNum1(getNumInput());
        calc.setExpression(calc.getExpression() + calc.formatDouble(calc.getNum1()));
        displayExpression();

        getOperatorInput();
        calc.setExpression(calc.getExpression() + " " + calc.operator + " ");
        displayExpression();

        try{
            calc.setNum2(getNumInput());
            calc.calculate();
            calc.setExpression(calc.getExpression() + calc.formatDouble(calc.getNum2()) + " = " + calc.formatDouble(calc.getAnswer()));
            
        }
        catch (Exception e){
            calc.setExpression("Invalid Expression!");
        }
        
        
        displayExpression();


    }
}
