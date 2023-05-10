package br.com.poo.sistema;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.poo.interfac.Interface;

public class Splash {

    public static void Start() {
        JFrame frame = new JFrame("Easy Bank ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 800);
        JLayeredPane layeredPane = new JLayeredPane();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 800));  
    	frame.setLocationRelativeTo(null);
        JButton button = new JButton("Login");
        JButton button1 = new JButton("Sobre");
        JButton button2= new JButton("Sair");
        button.setBounds(95, 650, 200, 30); // Define as coordenadas e o tamanho do botão
        button1.setBounds(115,700,80,30);
        button2.setBounds(200,700,80,30);
        layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER); // Adiciona o painel à camada padrão
        layeredPane.add(button, JLayeredPane.PALETTE_LAYER); // Adiciona o botão a uma camada acima do painel
        layeredPane.add(button1, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(button2, JLayeredPane.PALETTE_LAYER);
        ImageIcon imageIcon = new ImageIcon("res\\background.jpg");
        JButton imageButton = new JButton(imageIcon);
        
        imageButton.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight()); // Define as coordenadas e o tamanho da imagem
        layeredPane.add(imageButton, JLayeredPane.DEFAULT_LAYER); // Adiciona a imagem à camada padrão

        frame.setContentPane(layeredPane);
        frame.setVisible(true);
        
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				button.setVisible(false);
				button1.setVisible(false);
				button2.setVisible(false);
				// botao1.setVisible(false);
				// p.setVisible(false);
				Interface.MenuLogin();
			}
		});

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"*------------------------------------------------------Banco Serratec------------------------------------------------------*\n"
								+ "Bem-vindo ao nosso programa de finanças pessoais. Estamos muito felizes em ter você\n"
								+ "a bordo para ajudá-lo a gerenciar suas finanças de forma mais eficaz e alcançar seus\n"
								+ "objetivos financeiros."
								+ "O programa é projetado para ajudá-lo a entender seus gastos, identificar\n áreas onde"
								+ "você pode economizar dinheiro e criar um plano financeiro realista para atingir seus\n"
								+ "objetivos financeiros de longo prazo. Nós acreditamos que todos podem ter controle\n"
								+ "financeiro, independentemente de sua renda ou situação atual.\n"
								+ "*-------------------------------------------------------------------------------------------------------------------------------------*",
						"About", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/about.jpg"));
			}
		});
		 button2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					JOptionPane.showMessageDialog(null,"Obrigado por usar nosso programa");
					System.exit(0);
				}
			});
    }
}
