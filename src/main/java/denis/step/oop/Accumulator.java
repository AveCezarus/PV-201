package denis.step.oop;

public class Accumulator extends Product {
    private double capacity;

    public Accumulator(String manufacturer, double capacity) {
        super.setManufacturer(manufacturer);
        this.setCapacity(capacity);
    }
    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        if (capacity < 0) {
            throw new RuntimeException("Negative capacity");
        }
        this.capacity = capacity;
    }

    @Override
    public String getCard() {
        return String.format("Accumulator: Manufacturer: %s, Capacity: %.1f Ah",
                this.getManufacturer(),
                this.getCapacity());
    }
    @Works
    public  void charge(){
        System.out.println("Working on " + getCard());
    }
}
