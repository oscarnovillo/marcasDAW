/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daw
 */
@XmlRootElement ( name="zanalcar")
public class ZanalCar {

    private Scanner sc;
    
    @XmlElementWrapper(name = "stock")
    @XmlElements({
            @XmlElement(name = "coche", type = Coche.class),
            @XmlElement(name = "moto", type = Moto.class),
            @XmlElement(name = "bici", type = Bici.class),
            @XmlElement(name = "quad", type = Quad.class)
    })
    private ArrayList<Vehiculo> stock;
     @XmlElementWrapper(name = "vendido")
    @XmlElements({
            @XmlElement(name = "coche", type = Coche.class),
            @XmlElement(name = "moto", type = Moto.class),
            @XmlElement(name = "bici", type = Bici.class),
            @XmlElement(name = "quad", type = Quad.class)
    })
    private ArrayList<Vehiculo> vendidos;

    public ZanalCar() {
        this.sc = new Scanner(System.in);
        this.stock = new ArrayList<>();
        this.vendidos = new ArrayList<>();
             Moto moto34 = new Moto("Verde", "Harlley", 13250, "X1234P", 5145);
        Coche coche1 = new Coche("Rojo", "Renault", 3400, "A1234B", 110);
        Coche coche2 = new Coche("Azul", "Mercedez", 5400, "B1234A", 1110);
        Moto moto1 = new Moto("Gris", "BMW", 3250, "C1234B", 2145);
        Moto moto2 = new Moto("Verde", "Harlley", 13250, "X1234P", 5145);
        Quad quad1 = new Quad("Rojo", "Yakusa", 2551, "O1234Z", 12312);
        Quad quad2 = new Quad("Negro", "Motorola", 1651, "R1452T", 312);
        Bici bici1 = new Bici(20, 2, "Automatico", "Amarillo", "Pegasus", 2144);
        Bici bici2 = new Bici(15, 4, "Manual", "Rojo", "BMX", 4220);
         stock.add(moto34);
        stock.add(coche1);
        stock.add(coche2);
        stock.add(moto1);
        stock.add(moto2);
       
        stock.add(quad1);
        stock.add(quad2);
        stock.add(bici1);
        stock.add(bici2);
        Coche coche3 = new Coche("Blanco", "Renault", 111, "A1234B", 143);
        Moto moto3 = new Moto("Gris", "BMW", 111, "C1234B", 546);
        Quad quad3 = new Quad("Rosa", "Yakusa", 123, "O1234Z", 11);
        Bici bici3 = new Bici(20, 2, "Automatico", "Morado", "Pegasus", 41);
        vendidos.add(coche3);
        vendidos.add(bici3);
        vendidos.add(moto3);
        vendidos.add(quad3);
    }

    public void comprarCoche() {
        String tipoVehiculo, color, marca, matricula, tipoDeCambio;
        double precioCompra;
        int kilometros, opcion, numeroMarchas, tamanioRueda;

        System.out.print("1] Coche, Moto, Quad, \n2] Bici\nOpcion: ");
        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("Coche, Moto, Quad.");
                System.out.print("¿Que vehiculo va ha comprado? ");
                tipoVehiculo = sc.nextLine();
                System.out.print("Color: ");
                color = sc.nextLine();
                System.out.print("Marca: ");
                marca = sc.nextLine();
                System.out.print("Precio: ");
                precioCompra = sc.nextDouble();
                sc.nextLine();
                System.out.print("Matricula: ");
                matricula = sc.nextLine();
                System.out.print("Kilometros de uso: ");
                kilometros = sc.nextInt();
                sc.nextLine();
                crearVehiculoMotor(tipoVehiculo, color,
                        marca, matricula, kilometros, precioCompra);
                break;
            case 2:
                System.out.println("Bici.");
                System.out.print("Marca de la bici: ");
                marca = sc.nextLine();
                System.out.print("Tipo de cambio: ");
                tipoDeCambio = sc.nextLine();
                System.out.print("Color: ");
                color = sc.nextLine();
                System.out.print("Precio: ");
                precioCompra = sc.nextDouble();
                System.out.print("Numero de marchas: ");
                numeroMarchas = sc.nextInt();
                sc.nextLine();
                System.out.print("Tamaño de ruedas: ");
                tamanioRueda = sc.nextInt();
                sc.nextLine();

                crearBici(tamanioRueda, numeroMarchas,
                        tipoDeCambio, color, marca, precioCompra);
                break;

            default:
                System.out.println("Opcion Desconocida.");
                break;
        }
    }

    public void crearVehiculoMotor(String tipo, String color, String marca, String matricula,
            int kilometros, double precioCompra) {
        Vehiculo v = null;
        switch (tipo) {
            case "coche":
                Coche coche = new Coche(color, marca, precioCompra, matricula, kilometros);
                v = coche;
                break;
            case "moto":
                Moto moto = new Moto(color, marca, precioCompra, matricula, kilometros);
                v = moto;
                break;
            case "quad":
                Quad quad = new Quad(color, marca, precioCompra, matricula, kilometros);
                v = quad;
                break;
            default:
                System.out.println("Opcion desconocida");
        }

        if (v == null) {
            System.out.println("No se ha podido comprar el Vehiculo.");
        } else {
            stock.add(v);
        }
    }

    public void crearBici(int tamanio, int numeroMarchas, String tipoCambio,
            String color, String marca, double precioCompra) {

        Bici bici = new Bici(tamanio, numeroMarchas, tipoCambio, color, marca, precioCompra);

        stock.add(bici);
        System.out.println("Bici añadida al STOK.");
    }

    public void listadoVehiculosVender() {
        String opcion;
        int precio;
        System.out.print("¿Por que quieres filtrar?\n"
                + "Marca, Tipo, Matricula, Precio.\nOpcion: ");
        opcion = sc.nextLine().toLowerCase();

        switch (opcion) {
            case "marca":
                System.out.print("Marca del vehiculo: ");
                opcion = sc.nextLine().toLowerCase();
                Vehiculo v1 = flitradoMarca(opcion);

                System.out.print("El vehiculo vale " + v1.getPrecioCompra()
                        + " lo quieres vender por: ");
                precio = sc.nextInt();
                sc.nextLine();

                if (v1.getPrecioVenta() > precio) {
                    System.out.print("No se puede vender por"
                            + " menos de " + v1.getPrecioVenta());
                } else {
                    System.out.println("Vehiculo vendido!!");
                    v1.setPrecioVenta(precio);
                    vehiculoComprado(v1);
                }
                break;
            case "matricula":
                System.out.print("Matricula del vehiculo: ");
                opcion = sc.nextLine().toLowerCase();

                Vehiculo v2 = flitradoMatricula(opcion);
                System.out.print("El vehiculo vale " + v2.getPrecioCompra()
                        + " lo quieres vender por: ");
                precio = sc.nextInt();
                sc.nextLine();

                if (v2.getPrecioVenta() > precio) {
                    System.out.print("No se puede vender por"
                            + " menos de " + v2.getPrecioVenta());
                } else {
                    System.out.println("Vehiculo vendido!!");
                    v2.setPrecioVenta(precio);
                    vehiculoComprado(v2);
                }
                break;
            case "precio":
                System.out.print("Precio maximo a filtrar: ");
                precio = sc.nextInt();
                sc.nextLine();

                Vehiculo v3 = flitradoPrecio(precio);
                System.out.print("El vehiculo vale " + v3.getPrecioCompra()
                        + " lo quieres vender por: ");
                precio = sc.nextInt();
                sc.nextLine();

                if (v3.getPrecioVenta() > precio) {
                    System.out.print("No se puede vender por"
                            + " menos de " + v3.getPrecioVenta());
                } else {
                    System.out.println("Vehiculo vendido!!");
                    v3.setPrecioVenta(precio);
                    vehiculoComprado(v3);
                }
                break;
            case "tipo":
                System.out.print("Tipo del vehiculo: ");
                opcion = sc.nextLine().toLowerCase();

                Vehiculo v4 = filtradoTipo(opcion);

                if (v4 == null) {
                    System.out.println("No se ha realizado la operacion.");
                } else {
                    System.out.print("El vehiculo vale " + v4.getPrecioCompra()
                            + " lo quieres vender por: ");
                    precio = sc.nextInt();
                    sc.nextLine();

                    if (v4.getPrecioVenta() > precio) {
                        System.out.print("No se puede vender por"
                                + " menos de " + v4.getPrecioVenta());
                    } else {
                        System.out.println("Vehiculo vendido!!");
                        v4.setPrecioVenta(precio);
                        vehiculoComprado(v4);
                    }
                }
                break;
            default:
                System.out.println("Opcion desconocida.");
                break;
        }
    }

    public void vehiculoComprado(Vehiculo vehiculo) {
        vendidos.add(vehiculo);
        stock.remove(vehiculo);
    }

    public Vehiculo flitradoMarca(String marca) {
        int i;
        for (i = 0; i < stock.size(); i++) {
            if (stock.get(i).getMarca().toLowerCase().equals(marca)) {
                System.out.println("Vehiculo: " + (i + 1) + "] " + stock.get(i).toString());
            }
        }

        System.out.print("¿Que vehiculo elijes(numero)? ");
        i = sc.nextInt() - 1;
        sc.nextLine();
        return stock.get(i);
    }

    public Vehiculo flitradoPrecio(int precio) {
        int i;
        for (i = 0; i < stock.size(); i++) {
            if (stock.get(i).getPrecioVenta() < precio) {
                System.out.println("Vehiculo " + (i + 1) + "] " + stock.get(i));
            }
        }

        System.out.print("¿Que vehiculo elijes(numero)? ");
        i = sc.nextInt() - 1;
        sc.nextLine();
        return stock.get(i);
    }

    public Vehiculo filtradoTipo(String tipo) {
        int i = -1;
        switch (tipo.toLowerCase()) {
            case "coche":
                for (i = 0; i < stock.size(); i++) {
                    if (stock.get(i) instanceof Coche) {
                        System.out.println("Coche " + (i + 1) + "] " + stock.get(i));
                    }
                }
                System.out.print("¿Que coche elijes? ");
                i = sc.nextInt() - 1;
                sc.nextLine();
                break;
            case "moto":
                for (i = 0; i < stock.size(); i++) {
                    if (stock.get(i) instanceof Moto) {
                        System.out.println("Moto " + (i + 1) + "] " + stock.get(i));
                    }
                }
                System.out.print("¿Que moto elijes? ");
                i = sc.nextInt() - 1;
                sc.nextLine();
                break;
            case "quad":
                for (i = 0; i < stock.size(); i++) {
                    if (stock.get(i) instanceof Quad) {
                        System.out.println("Quad " + (i + 1) + "] " + stock.get(i));
                    }
                }
                System.out.print("¿Que quad elijes? ");
                i = sc.nextInt() - 1;
                sc.nextLine();
                break;
            case "bici":
                for (i = 0; i < stock.size(); i++) {
                    if (stock.get(i) instanceof Bici) {
                        System.out.println("Bici " + (i + 1) + "] " + stock.get(i));
                    }
                }
                System.out.print("¿Que bici elijes? ");
                i = sc.nextInt() - 1;
                sc.nextLine();
                break;
            default:
                System.out.print("Opción desconocida.");
                break;
        }
        return stock.get(i);
    }

    public Vehiculo flitradoMatricula(String matricula) {
        int i;
        boolean encontrado = false;
        for (i = 0; i < stock.size() && !encontrado; i++) {
            if (stock.get(i) instanceof VehiculoMotor) {
                VehiculoMotor vm = (VehiculoMotor) stock.get(i);
                if (vm.getMatricula().toLowerCase().equals(matricula)) {
                    encontrado = true;
                }
            }
        }
        return stock.get(i);
    }

    public void facturacion() {
        int total = 0;
        for (int i = 0; i < vendidos.size(); i++) {
            System.out.println("Vehiculo " + (i + 1) + "] " + vendidos.get(i).toString());
            total += vendidos.get(i).getPrecioVenta();
        }
        vendidos.clear();
        System.out.println("Total ganancias " + total + "€");
    }

    public void prueba() {
        int i, kilometros;
        for (i = 0; i < stock.size(); i++) {
            if (stock.get(i) instanceof IProbable) {
                System.out.println("Vehiculo " + (i + 1) + "] " + stock.get(i).toString());
            }
        }
        System.out.print("¿Que vehiculo quiere probar? ");
        i = sc.nextInt() - 1;
        sc.nextLine();
        IProbable ip = (IProbable) stock.get(i);
        System.out.print("¿Cuantos kilometros quiere recorrer? ");
        kilometros = sc.nextInt();
        sc.nextLine();
        ip.probarVehiculo(kilometros);
    }

    public void inventarioStock() {
        System.out.println("Stock: ");
        for (int i = 0; i < stock.size(); i++) {
            System.out.println("Vehiculo " + (i + 1) + "] " + stock.get(i).toString());
        }
    }

    public void inventarioVentas() {
        System.out.println("\nVendidos: ");
        for (int i = 0; i < vendidos.size(); i++) {
            System.out.println("Vehiculo " + (i + 1) + "] " + vendidos.get(i).toString());
        }
    }
}
