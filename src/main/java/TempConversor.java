import java.util.*;
public class TempConversor {
    static Scanner sc = new Scanner(System.in); // Scanner Class

    // Method to convert Celcius to Fahrenheit
    static double C_F(double C){
        double F = (C * 9/5) + 32;
        return F;
    }
    // Method to convert Celcius to Kelvin
    static double C_K(double C){
        double K = C + 273.15;
        return K;
    }

    // Method to convert Fahrenheit to Celcius
    static double F_C(double F){
        double C = (F - 32) * 5/9;
        return C;
    }
    // Method to convert Fahrenheit to Kelvin
    static double F_K(double F){
        double K = (F - 32) * 5/9 + 273.15;
        return K;
    }

    // Method to convert Kelvin to Celcius
    static double K_C(double K){
        double C = K - 273.15;
        return C;
    }
    // Method to convert Kelvin to Fahrenheit
    static double K_F(double K){
        double F = (K - 273.15) * 9/5 + 32;
        return F;
    }

    // Method to read the value of temperature given by the user
    static double input(String word){
        System.out.println("Enter "+word+" value:");
        double val = sc.nextDouble();
        return val;
    }

    // Method to print converted value of temperature
    static void output(double val, String word){
        System.out.printf("%s value: %.2f",word,val);
    }

}
