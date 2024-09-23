/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.abo;

import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author Ningning
 */
public class ABO {

    public static void main(String[] args) throws IOException {
        ArbolBinario tree = new ArbolBinario();
        Scanner object = new Scanner(System.in);
        int valor = 0;
        String respuesta = "y";
        
        while (respuesta.equalsIgnoreCase("y")) {
            boolean error = true;
            while (error) {
                try {
                    System.out.print("Introduzca un numero entero: ");
                    valor = object.nextInt();
                    if (tree.buscar(valor)) {
                        System.out.println("El valor " + valor + " ya existe en el arbol");
                    } else {
                        tree.insertar(valor);
                        error = false;
                    }
                } catch (Exception e) {
                    System.err.println("Entrada no valida. Por favor ingrese un numero entero.");
                    object.next();
                }
            }
            boolean validResponse = false;
            while (!validResponse) {
                System.out.print("¿Desea agregar otro numero? (y/n): ");
                respuesta = object.next();
                if (respuesta.equalsIgnoreCase("y") || respuesta.equalsIgnoreCase("n")) {
                    validResponse = true;
                } else {
                    System.err.println("Respuesta no valida. Por favor ingrese 'y' o 'n'.");
                }
            }
        }
        System.out.println("Valores del arbol binario");
        tree.visualizar();

    }
}
