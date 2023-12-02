
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class VehicleDataEntry
{
    public static void main(String[] args)
    {
        List<Vehicle> vehicleList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int numVehicles = 0;
        System.out.print("Enter the number of vehicles: ");
        if (scanner.hasNextInt())
        {
            numVehicles = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        }
        else
        {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        for (int i = 1; i <= numVehicles; i++)
        {
            System.out.println("Enter Vehicle " + i + " details:");
            System.out.print("Make: ");
            String make = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();

            double milesPerGallon = 0.0;
            boolean validInput = false;
            while (!validInput)
            {
                System.out.print("Miles per Gallon: ");
                if (scanner.hasNextDouble())
                {
                    milesPerGallon = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    validInput = true;
                }
                else
                {
                    System.out.println("Invalid input. Please enter a valid number for miles per gallon.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }

            Vehicle vehicle = new Vehicle(make, model, milesPerGallon);
            vehicleList.add(vehicle);
        }

        // Sort the vehicles by miles per gallon in ascending order
        Collections.sort(vehicleList, (v1, v2) -> Double.compare(v1.getMilesPerGallon(), v2.getMilesPerGallon()));

        // Write the sorted vehicle data to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vehicle_data.txt")))
        {
            for (Vehicle vehicle : vehicleList)
            {
                writer.write(vehicle.toString());
                writer.newLine();
            }
            System.out.println("Data has been written to vehicle_data.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        scanner.close();
    }
}