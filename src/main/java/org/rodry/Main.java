package org.rodry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();
        agregarProductos(listaProductos);

        //Filtrar por precio mayor a 100
        List<Producto> productosMayores =
                listaProductos.stream()
                        .filter(producto -> producto.getPrecio() > 100)
                        .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                        .collect(Collectors.toList());
        productosMayores.forEach(producto -> System.out.println(producto));

        //Agrupar por categoria y calcular stock total
        System.out.println("\n Categorias y stock");
        Map<String, Integer> categorias =
                listaProductos.stream()
                        .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.summingInt(Producto::getStock)));
        categorias.forEach((categoria, total) -> System.out.println(categoria + ": " + total));

        //Lista String productos
        System.out.println("\n Precios y stock");
        String productosString = listaProductos.stream()
                .map(producto -> producto.getNombre() + " $" + producto.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println(productosString);

        //Promedio de precio general y por categoria
        System.out.println("\nPromedio general y por categoria");
        double promedioGeneral = listaProductos.stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio));
        System.out.println("Promedio general de precio: $" +  String.format("%.2f", promedioGeneral));

        Map<String, Double> promedioCategoria = listaProductos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.averagingDouble(Producto::getPrecio)));

        promedioCategoria.forEach((categoria, total) -> System.out.println(categoria + ":$ " +  String.format("%.2f", total)));
    }
    public static void agregarProductos(List<Producto> listaProductos) {
        listaProductos.add(new Producto("Smartphone Galaxy S22", "Electrónica", 1200.00, 10));
        listaProductos.add(new Producto("Laptop Dell Inspiron", "Electrónica", 950.00, 5));
        listaProductos.add(new Producto("Auriculares Bluetooth Sony", "Electrónica", 180.00, 20));
        listaProductos.add(new Producto("Televisor LG 50\"", "Electrónica", 800.00, 7));
        listaProductos.add(new Producto("Cafetera Nespresso", "Hogar", 150.00, 15));
        listaProductos.add(new Producto("Silla de oficina ergonómica", "Hogar", 200.00, 8));
        listaProductos.add(new Producto("Mesa de comedor madera", "Hogar", 500.00, 3));
        listaProductos.add(new Producto("Lámpara de escritorio LED", "Hogar", 45.50, 25));
        listaProductos.add(new Producto("Remera básica algodón", "Ropa", 25.00, 50));
        listaProductos.add(new Producto("Jeans Levis", "Ropa", 120.00, 20));
        listaProductos.add(new Producto("Campera invierno", "Ropa", 180.00, 12));
        listaProductos.add(new Producto("Zapatillas deportivas Nike", "Ropa", 150.00, 18));
        listaProductos.add(new Producto("Pack de arroz 1kg", "Alimentos", 2.50, 200));
        listaProductos.add(new Producto("Aceite de oliva 1L", "Alimentos", 7.50, 100));
        listaProductos.add(new Producto("Cereal Kellogg's", "Alimentos", 5.00, 80));
        listaProductos.add(new Producto("Caja de galletitas", "Alimentos", 3.00, 150));
        listaProductos.add(new Producto("Pelota fútbol Adidas", "Deportes", 40.00, 30));
        listaProductos.add(new Producto("Bicicleta Mountain Bike", "Deportes", 450.00, 5));
        listaProductos.add(new Producto("Mancuernas 10kg", "Deportes", 60.00, 25));
        listaProductos.add(new Producto("Colchoneta Yoga", "Deportes", 25.00, 40));
        listaProductos.add(new Producto("Mouse Logitech", "Electrónica", 35.00, 50));
        listaProductos.add(new Producto("Teclado mecánico", "Electrónica", 80.00, 30));
        listaProductos.add(new Producto("Impresora HP DeskJet", "Electrónica", 120.00, 10));
        listaProductos.add(new Producto("Aspiradora Philips", "Hogar", 220.00, 12));
        listaProductos.add(new Producto("Heladera Samsung 300L", "Hogar", 1350.00, 3));
        listaProductos.add(new Producto("Microondas BGH", "Hogar", 180.00, 10));
        listaProductos.add(new Producto("Camisa formal", "Ropa", 70.00, 25));
        listaProductos.add(new Producto("Sweater lana merino", "Ropa", 85.00, 15));
        listaProductos.add(new Producto("Pan integral", "Alimentos", 2.00, 140));
        listaProductos.add(new Producto("Botella agua 2L", "Alimentos", 1.50, 300));


    }

}