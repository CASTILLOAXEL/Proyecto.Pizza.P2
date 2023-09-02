package P2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Thread.sleep;
import PkgPizza.Pizza;
import PkgPizza.Topping;
public class Main {


    public static void main(String[] args)throws InterruptedException {
        Topping[] ToppingsArray = {
                new Topping("Tomate", 5.5),
                new Topping("Cebolla", 5.0),
                 new  Topping("Pimiento", 5.0),
                new Topping("Piña", 5.5),
                new Topping("Aceitunas", 5.0),
                new Topping("Chile Jalapeño", 5.5),
                new Topping("Champiñones", 5.5),
                new Topping("Queso Extra", 10.0),
                new Topping("Orilla  de Queso", 15),
                new Topping("Peperoni", 10.5),
                new Topping("Pollo", 11.5),
                new Topping("Jamon", 9),
                new Topping("Salchicha", 7.5),
                new Topping("Tocino", 12),
                new Topping("Chorizo", 8),
                new Topping("Carne", 16),
        };

        Pizza pizza = new Pizza("Margarita", 30, ToppingsArray);
        System.out.println("   Bienvenido a Pizza el mejor sabor   ");
        System.out.println("Crea tu pizza a tu gusto:");

        System.out.println("El precio de la pizza Tradicional es: " + pizza.getPrecioBase());

         //Creaos el objeto scanner para leer los datos
        Scanner scanner = new Scanner(System.in);
        int intentosMaximos = 3;

        //Creamos el ciclo for para validar los intentos
        for (int intento = 1; intento <= intentosMaximos; intento++) {
            //Llamamos al metodo calcularPrecioPizza
            double precioTotal = calcularPrecioPizza(pizza);

            System.out.println("Tu pedido:");
            System.out.println("Tu Pizza Especial: " + pizza.getName() + " El Precio es: " + precioTotal);
            //Llamamos al metodo solicitarPago
            double cantidadPago = solicitarPago(precioTotal, scanner);

            //Validamos si el pago es mayor o igual al precio total
            if (cantidadPago >= precioTotal) {
                //Llamamos al metodo realizarPago
                double cambio = realizarPago(precioTotal, cantidadPago);
                prepararPizza();
                break;
                //Si el pago es menor al precio total
            } else {
                System.out.println("Lo Sentimos tu pago es insuficiente: Puedes intentarlo Nuevamente " + (intentosMaximos - intento));
                if (intento == intentosMaximos) {
                    System.out.println("Pago fallido. Tu pizza no será preparada.");
                }
            }
        }
    }

   //Metodo para calcular el precio de la pizza
    private static double calcularPrecioPizza(Pizza pizza) {

        double precioTotal = pizza.getPrecioBase();
        //Creamos un ArrayList para guardar los ingredientes seleccionados
        List<Topping> ingredientesSeleccionados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige Los ingredientes que Gustes:");
      //Creamos un ciclo for para mostrar los ingredientes
        for (int i = 0; i < pizza.getToppings().length; i++) {
            Topping ingrediente = pizza.getToppings()[i];
            System.out.println((i + 1) + ". " + ingrediente.getNombre() + " - Q" + ingrediente.getPrice());
        }
        System.out.println("0. Listo");

        while (true) {
            int eleccion = scanner.nextInt();
            if (eleccion == 0) {
                break;
                //Validamos si la eleccion es mayor o igual a 1 y menor o igual a la longitud del arreglo
            } else if (eleccion >= 1 && eleccion <= pizza.getToppings().length) {
                Topping ingredienteSeleccionado = pizza.getToppings()[eleccion - 1];
                //Validamos si el ingrediente seleccionado no esta en la lista de ingredientes seleccionados
                if (!ingredientesSeleccionados.contains(ingredienteSeleccionado)) {
                    ingredientesSeleccionados.add(ingredienteSeleccionado);
                    precioTotal += ingredienteSeleccionado.getPrice();
                    System.out.println(ingredienteSeleccionado.getNombre() + "  A sido agregado con Exito.");
                } else {
                    System.out.println("Ingrediente ya seleccionado Intenta con otro.");
                }
            } else {
                System.out.println("Selección inválida Intenta Nuevamente.");
            }
        }

        return precioTotal;
    }

    private static double solicitarPago(double precioTotal, Scanner scanner) {
        System.out.print("Ingrese la cantidad a pagar: ");
        return scanner.nextDouble();
    }

    private static double realizarPago(double precioTotal, double cantidadPago) throws InterruptedException {
        double cambio = cantidadPago - precioTotal;
        System.out.println("Pago exitoso. Cambio: Q" + cambio);
        System.out.println("En un momento tu pizza estará lista.");


            sleep(4000);

        System.out.println("¡Tu pizza está lista que la Disfrutes!");
        return cambio;
    }

    private static void prepararPizza() {
        // Lógica de preparación de la pizza
    }
}
