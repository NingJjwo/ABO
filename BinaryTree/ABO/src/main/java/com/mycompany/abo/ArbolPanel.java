/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.abo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Ningning
 */
public class ArbolPanel extends JPanel {

    Nodo raiz;

    public ArbolPanel(Nodo raiz) {
        this.raiz = raiz;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        dibujarArbol(g, raiz, getWidth() / 2, 30, getWidth() / 4);
    }

    private void dibujarArbol(Graphics g, Nodo nodo, int x, int y, int xOffset) {
        if (nodo == null) {
            return;
        }
        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(nodo.valor), x - 5, y + 5);
        g.setColor(Color.BLACK);
        if (nodo.izquierda != null) {
            g.drawLine(x, y, x - xOffset, y + 50);
            dibujarArbol(g, nodo.izquierda, x - xOffset, y + 50, xOffset / 2);
        }
        if (nodo.derecha != null) {
            g.drawLine(x, y, x + xOffset, y + 50);
            dibujarArbol(g, nodo.derecha, x + xOffset, y + 50, xOffset / 2);
        }
    }
}
