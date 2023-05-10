package br.com.poo.interfac;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Wait {
public static void Aguarde() {
        
        int countdown = 5; 
        String message = "Este JOptionPane será fechado em " + countdown + " segundos.";

        JOptionPane pane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        final Thread thread = new Thread() {
            public void run() {
                for (int i = countdown; i >= 0; i--) {
                	pane.setMessage("Usuario ou senha incorretos!\n    Tente Novamente em:\n           " + i + " segundos.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pane.setValue(JOptionPane.CLOSED_OPTION);
            }
        };
        thread.start();
        JDialog dialog = pane.createDialog("Erro Login!");
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);
        thread.interrupt();
    }

}
