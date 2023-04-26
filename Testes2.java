package br.com.residencia.poo.exemplos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Testes2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Janela");
        JPanel panel = new JPanel();

      
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
     
                frame.dispose();
            }
        });

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}