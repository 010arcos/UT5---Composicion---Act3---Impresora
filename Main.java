package Act3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int nivelToner;
        do {
            System.out.println("------------------------");
            System.out.println("Definir las características iniciales de la impresora");
            System.out.println("¿Desea imprimir a doble cara? (true/false): ");
            boolean impresionDobleCara = sc.nextBoolean();

            // Inicializar nivelToner con un valor dentro del rango
            do {
                // Solicitar al usuario la cantidad de toner inicial
                System.out.println("Introduce cantidad de toner inicial (0-100): ");
                nivelToner = sc.nextInt();

                // Mostrar mensaje de error si la cantidad está fuera del rango
                if (nivelToner < 0 || nivelToner > 100) {
                    System.out.println("Error: La cantidad inicial de toner debe estar entre 0 y 100.");
                }
            } while (nivelToner < 0 || nivelToner > 100);
            Impresora impresora = new Impresora(nivelToner, 0, impresionDobleCara);



            // Mostrar menú
            System.out.println("Menú:");
            System.out.println("1. Agregar toner");
            System.out.println("2. Imprimir páginas");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Solicitar al usuario la cantidad de toner que desea agregar
                    System.out.println("Ingrese la cantidad de toner a agregar (0-100): ");
                    int cantidadToner = sc.nextInt();
                    int tonerActual = impresora.agregarToner(cantidadToner);

                    // Verificar si la adición de toner supera el límite máximo
                    if (tonerActual != -1) {
                        System.out.println("La cantidad de toner es: " + tonerActual);
                    } else {
                        System.out.println("Error: La adición de toner supera el límite máximo (0-100).");
                    }
                    break;

                case 2:
                    // Solicitar al usuario la cantidad de páginas a imprimir
                    System.out.println("Ingrese la cantidad de páginas a imprimir: ");
                    int cantidadPaginas = sc.nextInt();

                    // Imprimir páginas y obtener el número de páginas impresas
                    int paginasImpresas = impresora.imprimirPaginas(cantidadPaginas);

                    // Mostrar el total de páginas impresas
                    System.out.println("Total de páginas impresas: " + paginasImpresas);

                    // Si se imprime un número impar a doble cara
                    if (impresora.isImpresionDobleCara() && cantidadPaginas % 2 != 0) {
                        System.out.println("En este caso: se imprimirán " + (cantidadPaginas / 2) + " páginas a doble cara y 1 página a una cara.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 3);
    }
}






/*
Otra forma de hacerlo seria con un while e inicializando el nivel de toner fuera del rango (ejemplo: -1) para entrar en el bucle

            int nivelToner=-1;

            // Verificar si la cantidad inicial de toner está en el rango correcto
            while (nivelToner < 0 || nivelToner > 100) {
                // Solicitar al usuario la cantidad de toner inicial
                System.out.println("Introduce cantidad de toner inicial (0-100): ");
                nivelToner = sc.nextInt();

                // Mostrar mensaje de error si la cantidad está fuera del rango
                if (nivelToner < 0 || nivelToner > 100) {
                    System.out.println("Error: La cantidad inicial de toner debe estar entre 0 y 100.");
                }
            }


 */