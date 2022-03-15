import java.util.ArrayList;
import java.util.Scanner;

public class Ifood {
  ArrayList<Servico> pedidos = new ArrayList<Servico>();
  static Scanner scan = new Scanner(System.in);
  public static void main (String[] args) {
    int escolha;


    while (true) {
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
  
      switch (escolha) {
        case 1:
          
          break;
        case 2:
          Endereco endereco = getEndereco();
          break;
        case 3:
          
          break;
      
        default:
          System.out.println("Erro: Seleção inválida.");
          break;

      }

    }
	
  }
  private static Endereco getEndereco() {
    System.out.println("Digite as inforações");
    System.out.print("Rua: ");
    String Rua = scan.next();
    
    System.out.print("Número da Casa: ");
    String numCasa = scan.next();
    
    System.out.print("Bairro: ");
    String Bairro = scan.next();
    
    System.out.print("Cidade: ");
    String Cidade = scan.next();
  
    return new Endereco(Rua, numCasa, Bairro, Cidade);
  }
}
