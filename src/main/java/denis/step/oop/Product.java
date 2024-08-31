package denis.step.oop;

public abstract class Product {
    private String manufacturer;
    public abstract String getCard();
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getWarrantyInfo() {
        if (this.getClass().isAnnotationPresent(Warranty.class)) {
            Warranty warranty = this.getClass().getAnnotation(Warranty.class);
            return "Warranty: " + warranty.value() + " years";
        } else {
            return "No Warranty";
        }
    }
}
