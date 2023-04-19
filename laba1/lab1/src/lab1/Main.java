package lab1;

import java.util.Scanner;
import library.Car;
import library.Driver;

public class Main {
	   
    public static void main(String[] args) {
    	
    	String country = "СССР";
    	int experience = 5;
           
        System.out.println("1. Все автомобили");
        System.out.printf("2. Водители со стажем более %d лет", experience);
        System.out.println();
        System.out.println("3. Автомобили советского производства");
        System.out.print("Введите число: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.close();
        
        var data = new Data();
        
        switch (number) {
        case 1:
        	printCars(data.getAllCars());
        	break;
        case 2:
        	printDrivers(data.getDriversWithExperience(experience), experience);
        	break;
        case 3:
        	printCars(data.getCarsFromCountry(country));
        	break;
        default:
        	System.out.println("Неверные данные.");
        }
        
    }
    
    private static void printCars(Car[] cars) {
    	System.out.println("Автомобили: ");
    	for (int i = 0; i < cars.length; i++) {
    		if (cars[i] != null) {    			
    			System.out.printf("%s, %s, %d кг, %s, %d л.с., %s,стаж: %d", cars[i].brand, cars[i].model, cars[i].weight, cars[i].getEngine().country, cars[i].getEngine().power, cars[i].getDriver().name, cars[i].getDriver().experience);
    			System.out.println();
    		}
    	}
    }
    private static void printDrivers(Driver[] drivers, int experience) {
    	System.out.printf("Водители со стажем более %d лет: ", experience);
    	System.out.println();
    	int i = 0;
    	while (drivers[i] != null) {
    		System.out.printf("%s, стаж: %d", drivers[i].name, drivers[i].experience);
    		System.out.println();
    		i++;
    	}
    }
}