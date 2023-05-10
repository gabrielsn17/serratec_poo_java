package br.com.poo.decod;

import java.util.Random;
import java.util.Scanner;

public class Decod {
 static int ra =0;

public static void Broke() {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Digite a senha ");
	int i=0;
	int ra=0;
	int senha = sc.nextInt();
	do {
	Random random = new Random();
    ra = random.nextInt(99999);
	i++;
	System.out.println("decodificando...");
	}while(ra!=senha);
	System.out.println("Senha decodificada em "+i+" tentativas");
	sc.close();

}

}
