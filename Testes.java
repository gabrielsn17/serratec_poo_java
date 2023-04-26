package br.com.residencia.poo.exemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Testes {
    public static void main(String[] args) {
        int tempo = 30; 

        JFrame frame = new JFrame("Contagem Regressiva");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel();
        frame.add(label);

        Timer timer = new Timer(1000, new ActionListener() {
            int contador = tempo;

            @Override
            public void actionPerformed(ActionEvent e) {
                contador--;

                if (contador >= 0) {
                    label.setText("Você tentou muitas vezes, aguarde: " + contador + " segundos");
                } else {
                    ((Timer) e.getSource()).stop();
                    JOptionPane.showMessageDialog(frame, "Tentar novamente", "Contagem regressiva", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        });

        timer.start();

        frame.setVisible(true);
    }
}