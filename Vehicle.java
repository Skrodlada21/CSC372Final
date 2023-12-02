
class Vehicle
{
    private String make;
    private String model;
    private double milesPerGallon;

    public Vehicle(String make, String model, double milesPerGallon)
    {
        this.make = make;
        this.model = model;
        this.milesPerGallon = milesPerGallon;
    }

    @Override
    public String toString()
    {
        return "Make: " + make + ", Model: " + model + ", Miles per Gallon: " + milesPerGallon;
    }

    public double getMilesPerGallon()
    {
        return milesPerGallon;
    }
}

