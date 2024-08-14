package com.romario.superprod;

import org.mindrot.jbcrypt.BCrypt;

import java.security.SecureRandom;
import java.util.Scanner;


public class PasswordHasher {

	 private static final int ROUNDS = 12; // Número de rounds para o algoritmo bcrypt

	    public static String gerarSenha() {
	        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
	        StringBuilder senha = new StringBuilder();

	        for (int i = 0; i < 12; i++) {
	            int index = (int) (caracteres.length() * Math.random());
	            senha.append(caracteres.charAt(index));
	        }

	        return senha.toString();
	    }

	    public static String criptografarSenha(String senha) {
	        String salt = BCrypt.gensalt(ROUNDS);
	        return BCrypt.hashpw(senha, salt);
	    }

	    public static boolean verificarSenha(String senha, String senhaHash) {
	        return BCrypt.checkpw(senha, senhaHash);
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Digite a senha: ");
	        String senhaDigitada = scanner.nextLine();

	        String senhaHash = criptografarSenha(senhaDigitada);

	        System.out.println("Senha digitada: " + senhaDigitada);
	        System.out.println("Senha hash: " + senhaHash);
	        
	        scanner.close();
	    }
}
