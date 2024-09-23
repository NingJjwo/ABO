/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JFrame;

/**
 *
 * @author Ningning
 */
public class ArbolBinario {

    Nodo raiz;

    // Constructor
    public ArbolBinario() {
        this.raiz = null;
    }

    /**
     * Insertar nueva raiz
     *
     * @param valor
     */
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    /**
     * Metodo recursivo para hacer el recorrido del arbol
     *
     * @param nodo
     * @param valor
     * @return
     */
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        // Nodo padre o raiz
        if (nodo == null) {
            return new Nodo(valor);
        }

        //Hijos
        if (valor < nodo.valor) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor);
        } else {
            nodo.derecha = insertarRecursivo(nodo.derecha, valor);
        }
        return nodo;
    }

    // Imprimir
    public void imprimirInOrder() {
        imprimirOrdenRecursivo(raiz);
    }

    // Imprimir Orden Recursivo
    private void imprimirOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            imprimirOrdenRecursivo(nodo.izquierda);
            System.out.println(nodo.valor + " ");
            imprimirOrdenRecursivo(nodo.derecha);
        }
    }

    // Numero Duplicado
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return false;
        }
        if (valor == nodo.valor) {
            return true;
        }
        return valor < nodo.valor
                ? buscarRecursivo(nodo.izquierda, valor)
                : buscarRecursivo(nodo.derecha, valor);
    }
    public void visualizar() {
        JFrame frame = new JFrame("Visualización del Árbol Binario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ArbolPanel(raiz));
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
