import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ProductoElectronico {
    private String nombre;
    private double precio;
    private int garantia;

    public ProductoElectronico(String nombre, double precio, int garantia) {
        this.nombre = nombre;
        this.precio = precio;
        this.garantia = garantia;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getGarantia() {
        return garantia;
    }

    public abstract void cargar();
}

class Celular extends ProductoElectronico {
    private String modelo;

    public Celular(String nombre, double precio, int garantia, String modelo) {
        super(nombre, precio, garantia);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void cargar() {
        System.out.println("Cargando el celular " + getModelo() + "...");
        // Lógica específica para cargar un celular
    }

    public void realizarLlamada() {
        System.out.println("Realizando una llamada desde el celular " + getModelo() + "...");
        // Lógica específica para realizar una llamada desde un celular
    }
}

class Computadora extends ProductoElectronico {
    private String marca;

    public Computadora(String nombre, double precio, int garantia, String marca) {
        super(nombre, precio, garantia);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void cargar() {
        System.out.println("Cargando la computadora " + getMarca() + "...");
        // Lógica para cargar una computadora
    }

    public void ejecutarPrograma() {
        System.out.println("Ejecutando un programa en la computadora " + getMarca() + "...");
        // Lógica para ejecutar un programa en una computadora
    }
}

public class TiendaElectronica {
    private static List<ProductoElectronico> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("---- MENÚ ----");
            System.out.println("1. Agregar producto");
            System.out.println("2. Recorrer lista de productos");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    recorrerLista();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

            System.out.println();
        } while (opcion != 3);
    }

    private static void agregarProducto() {
        System.out.println("---- AGREGAR PRODUCTO ----");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la garantía: ");
        int garantia = scanner.nextInt();

        System.out.println("---- TIPO DE PRODUCTO ----");
        System.out.println("1. Celular");
        System.out.println("2. Computadora");
        System.out.print("Ingrese el tipo de producto: ");
        int tipo = scanner.nextInt();

        ProductoElectronico producto;

        switch (tipo) {
            case 1:
                System.out.print("Ingrese el modelo del celular: ");
                String modelo = scanner.next();
                producto = new Celular(nombre, precio, garantia, modelo);
                break;
            case 2:
                System.out.print("Ingrese la marca de la computadora: ");
                String marca = scanner.next();
                producto = new Computadora(nombre, precio, garantia, marca);
                break;
            default:
                System.out.println("Opción inválida");
                return;
        }

        productos.add(producto);
        System.out.println("Producto agregado correctamente");
    }

    private static void recorrerLista() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la lista");
            return;
        }

        System.out.println("---- LISTA DE PRODUCTOS ----");
        for (ProductoElectronico producto : productos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Garantía: " + producto.getGarantia());
            producto.cargar();
            System.out.println("------------------------");
        }
    }
}
