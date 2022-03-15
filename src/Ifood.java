import java.util.ArrayList;
import java.util.Scanner;

public class Ifood {
  ArrayList<Servico> pedidos = new ArrayList<Servico>();
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    int escolha;


    System.out.println("Bem-Vindo ao Comidas Ocasionais");
    System.out.println("""
    =========================================
    1-Login
    2-Cadastro de Usuario
    3-Cadastro de Restaurante
    =========================================
    """);
    System.out.println("escolha as opçoes:");
    escolha = scan.nextInt();

    
	
  }
}
