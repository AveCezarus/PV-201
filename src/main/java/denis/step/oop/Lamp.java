package denis.step.oop;

public class Lamp extends Product {
    private  double power;
    public Lamp(String manufacturer,double power) {
        super.setManufacturer(manufacturer);
        this.setPower(power);
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        if(power < 0){
            throw new RuntimeException("Negative power");
        }
        this.power = power;
    }

    @Override
    public String getCard() {
        return String.format("Lamp: Manufacturer: %s," +
                " Power: %.1f W",
                this.getManufacturer(),
                this.getPower());
    }
}
