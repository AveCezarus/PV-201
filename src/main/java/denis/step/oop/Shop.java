package denis.step.oop;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Shop {
    private List<Product> products;
    public Shop() {
        products = new ArrayList<Product>();
        products.add(new Lamp("Philips",60.0));
        products.add(new Pump("Pumper",100));
        products.add(new Accumulator("Bosch", 75.0));
    }
    public  void  Run(){
        printProducts();
        System.out.println("---------------MANUAL----------------");
        printManualProducts();
        System.out.println("---------------NON-MANUAL----------------");
        printNonManualProducts();
        System.out.println("---------------WORKS----------------");
        showWorks();
    }
    private void printManualProducts(){
        for(Product product : products){
            if (product instanceof Manual){
                System.out.println(product.getCard());
            }
        }
    }
    private void printNonManualProducts(){
        for(Product product : products){
            if (!(product instanceof Manual)){
                System.out.println(product.getCard());
            }
        }
    }
    public  void printProducts() {
        for (Product product : products) {
            if (product instanceof Testable) {
                ((Testable) product).test();

            }
            else{
                System.out.println(product.getCard());
            }
            System.out.println(product.getWarrantyInfo());
        }
    }
    private void showWorks() {
        for (Product product : products) {

            for( Method method : product.getClass().getDeclaredMethods() ) {
                if( method.isAnnotationPresent( Works.class ) ) {

                    System.out.print( method.getAnnotation(Works.class).value() + " ");

                    method.setAccessible(true);
                    try {
                        method.invoke( product );
                    }
                    catch (IllegalAccessException | InvocationTargetException ex) {
                        System.err.println( ex.getMessage() );
                    }
                }
            }
        }
    }
}
