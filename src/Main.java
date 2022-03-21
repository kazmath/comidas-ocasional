import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
            System.out.println("Escolha as opçoes:");
            escolha = scan.nextInt();
    
            switch (escolha) {
                case 1: //TODO editar quando tiver com o banco de dados.
                System.out.print("digite seu login: ");
                scan.next();
                System.out.print("digite sua senha: ");
                scan.next();
                    
                    break;
                case 2:
                    Endereco enderecoUser = getEndereco();
                    Cadastro cadastro = getCadastro();
                    Cliente cliente = new Cliente(cadastro, enderecoUser);
                    System.out.println("Cadastro realizado com sucesso!\n\n");
                    break;
                case 3:
                    System.out.print("Insira seu nome: ");
                    String nome = scan.next();
                    System.out.print("Insira seu cnpj: ");
                    String cnpj = scan.next();
                    System.out.print("Insira seu horarios: ");
                    //TODO: Implementar o scan de tempo de abertura e fechamento
                    System.out.print("Insira seu endereço: ");
                    Endereco enderecoComp = getEndereco();

                    //TODO: Usar o construtor da classe Estabelecimento
                    //TODO: Transformar em um método

                    break;
            
                default:
                    System.out.println("Erro: Seleção inválida.");
                    break;

            }

        }
	
    }

    private static Cadastro getCadastro() {
        System.out.println("Digite as inforações");
        System.out.print("nome: ");
        String nome = scan.next();
        
        System.out.print("CPF: ");
        String cpf = scan.next();
        
        System.out.print("email: ");
        String email = scan.next();
        
        System.out.print("senha: ");
        String senha = scan.next();
    
        return new Cadastro(nome, cpf, email, senha);
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
