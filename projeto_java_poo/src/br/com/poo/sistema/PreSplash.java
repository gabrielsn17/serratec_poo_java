package br.com.poo.sistema;
import javax.swing.*;

public class PreSplash extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PreSplash() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        // Cria um objeto ImageIcon com o arquivo do gif
        ImageIcon icon = new ImageIcon("res\\splash.gif");

        // Cria um objeto JLabel para exibir a imagem
        JLabel label = new JLabel(icon);

        // Adiciona o JLabel ao JFrame
        add(label);

        setVisible(true);
    }

    public static void Inicio() {
        new PreSplash();
  

                try {
                    Thread.sleep(3800); // Espera de 5 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Splash.Start();
            }
        

        
    
    
}
