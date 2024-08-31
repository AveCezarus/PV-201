package denis.step.oop;
@Warranty(2)
public class Lamp extends Product implements Testable {
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

    @Override
    public void test() {
        System.out.println("Testing lamp" + getCard());
    }
    @Works( "as lamp")
    public  void shine(){
        System.out.println("Working on " + getCard());
    }
}
