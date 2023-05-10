package br.com.poo.sistema;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


import javax.swing.ImageIcon;

import javax.swing.JPanel;

public class Etapa extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image fundo;
	
	
	public Etapa() {
		
		ImageIcon referencia = new ImageIcon("res\\background.jpg");
		fundo = referencia.getImage();
		
		
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo,0,0,null);
		g.dispose();
		
	}
	
	
	


}
