package denis.step.oop;

import java.util.Locale;
@Warranty(3)
public class Pump extends Product implements Manual{
    int productivity;
    public Pump(String manufacturer,int productivity) {
        super.setManufacturer(manufacturer);
        this.productivity = productivity;
    }

    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    @Override
    public String getCard() {
        return  String.format(
                Locale.ROOT,
                "Pump: '%s', Productivity: %d l/h", super.getManufacturer(),
                this.getProductivity());
    }
    @Works("as pump")
    public  void pump(){
        System.out.println("Working on " + getCard());
    }
}
