/*
 * JogoDaVelha.java
 * 
 */

import java.util.Scanner;

public class JogoDaVelha {
	
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner texto = new Scanner(System.in);
		char jogador,
		recomecar;
		boolean jogoAtivo;
		char[][] tabuleiro = new char[3][3];
		do{
			System.out.println("\nJogo Da Velha");
			jogoAtivo = true;
			iniciarTabuleiro(tabuleiro);
			jogador = 'x';
			while (jogoAtivo){
				exibirTabuleiro(tabuleiro);
				System.out.println("jogador '" + jogador + "' escolha uma posição para jogar");
				System.out.print("Linha: ");
				int linha = scanner.nextInt();
				System.out.print("Coluna: ");
				int coluna = scanner.nextInt();
				if (realizarJogada(tabuleiro, jogador, linha, coluna)){
					if (identificarVencedor(tabuleiro, jogador)){
						exibirTabuleiro(tabuleiro);
						System.out.print("Parabéns, " + jogador + "! Você é o vencedor!");
						jogoAtivo = false;
					}else if (identificarEmpate(tabuleiro)){
						exibirTabuleiro(tabuleiro);
						System.out.print("Houve um Empate!");
						jogoAtivo = false;
					}else{
						jogador = (jogador == 'x') ? 'o' :  'x';
					}
					
				}
				
				
			}
			System.out.print("\nIniciar outra partida[s/n]: ");
			recomecar = texto.next().toLowerCase().charAt(0);
			System.out.print("\n--------------------------");
		} while (recomecar == 's');
		
		
	}
	static void iniciarTabuleiro(char[][] tabuleiro){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				tabuleiro[i][j] = ' ';
			}
		}
	}
	static void exibirTabuleiro(char[][] tabuleiro){
		System.out.println();
		for (int i = 0; i < 3; i++){
			System.out.print(" ");
			for (int j = 0; j < 3; j++){
				System.out.print(tabuleiro[i][j]);
				if (j < 2){
					System.out.print(" | ");
				}
			}
			System.out.println();
			if (i < 2){
				System.out.println("-----------");
			}
		}
		System.out.println();
	}
	static boolean realizarJogada(char[][] tabuleiro, char jogador, int linha, int coluna){
		if (tabuleiro[linha - 1][coluna - 1] == ' '){
			tabuleiro[linha - 1][coluna - 1] = jogador;
			return true;
		}else{
			System.out.println("Jogada inválida! Escolha outra posição.");
			return false;
		}
	}
	static boolean identificarVencedor(char[][] tabuleiro, char jogador){
		if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador ||
			tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador ){
			return true;
		}
		for (int i = 0; i < 3; i++){
			if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador ||
				tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador ){
				return true;
			}
		}
		return false;
	}
	static boolean identificarEmpate(char[][]tabuleiro){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (tabuleiro[i][j] == ' '){
					return false;
				}
			}
		}
		return true;
	}
}

