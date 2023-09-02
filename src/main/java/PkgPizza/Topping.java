package PkgPizza;

public class Topping {

            private String nombre;
            private double price;

            public Topping(String nombre, double price) {
                this.nombre = nombre;
                this.price = price;
            }

        public String getNombre() {
            return nombre;
        }



        public double getPrice() {
            return price;
        }

        @Override
        public String toString()
        { return "Topping{" + "nombre='" + nombre + '\'' + ", price=" + price + '}';
        }
}
