import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    ArrayList<Servico> pedidos = new ArrayList<Servico>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha;
        Calendar hoje = Calendar.getInstance();
        int horaAtual = hoje.get(Calendar.HOUR_OF_DAY);
        int minAtual = hoje.get(Calendar.MINUTE);
        int tempAtual = minAtual + (horaAtual * 60);
        ArrayList<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        boolean controlador = true;

        while (controlador) {
            System.out.println("Bem-Vindo ao Comidas Ocasionais");
            System.out.println("""
                    =========================================
                    1-Login
                    2-Cadastro de Usuario
                    3-Cadastro de Restaurante
                    =========================================
                    """);
            System.out.println("Escolha as opções:");
            escolha = scan.nextInt();

            switch (escolha) {
                case 1: //TODO: Matheus
                    System.out.print("digite seu login: ");
                    String entradalogin = scan.next();
                    System.out.print("digite sua senha: ");
                    String entradasenha = scan.next();
                   
                    for (Cliente cliente : clientes) {
                        
                        
                    }

                    break;
                case 2:
                    Cadastro cadastro = getCadastro();
                    Endereco enderecoUser = getEndereco();
                    Cliente cliente = new Cliente(cadastro);
                    cliente.addEndereco(enderecoUser);
                    clientes.add(cliente);
                    System.out.println("Cadastro realizado com sucesso!\n\n");
                    break;
                case 3:
                    System.out.print("Insira o nome do restaurante: ");
                    String nome = scan.next();
                    System.out.print("Insira o cnpj: ");
                    String cnpj = scan.next();
                    System.out.print("Insira os horarios de funcionamento: ");
                    /**
                     * int abertura = getTempoAbertura()
                     * int fechamento = getTempoFechamento()
                     * HashMap<String,Integer> menu = getMenu()
                     */
                    getTempo();
                    System.out.print("Insira seu endereço: ");
                    Endereco enderecoComp = getEndereco();

                    Estabelecimento estabelecimento = new Estabelecimento(
                        nome,
                        cnpj,
                        abertura, //TODO: getTempoAbertura()
                        fechamento, //TODO: getTempoFechamento()
                        menu //TODO: getMenu()
                    );
                    estabelecimento.addEndereco(enderecoComp);
                    estabelecimentos.add(estabelecimento);

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
        String login = scan.next();

        System.out.print("CPF: ");
        String cpf = scan.next();

        System.out.print("email: ");
        String email = scan.next();

        System.out.print("senha: ");
        String senha = scan.next();

        return new Cadastro(login, cpf, email, senha);
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

    private static void getTempo() {
        int horaAbertura;
        int minAbertura;
        int horaFechamento;
        int minFechamento;

        do {
            System.out.println(
                    "Digite a HORA de abertura do seu estabelecimento\nhorários válidos são das 0 as 23)\n<NÃO DIGITE OS MINUTOS>\n>");
            horaAbertura = scan.nextInt();
        } while (horaAbertura < 0 && horaAbertura > 23);

        do {
            System.out.println(
                    "Digite os MINUTOS de abertura do seu estabelecimento\nhorários válidos são de 0 a 59\n<NÃO DIGITE AS HORAS>\n>");
            minAbertura = scan.nextInt();
        } while (minAbertura < 0 && minAbertura > 59);

        do {
            System.out.println(
                    "Digite a HORA de fechamento do seu estabelecimento\nhorários válidos são das 0 as 23)\n<NÃO DIGITE OS MINUTOS>\n> ");
            horaFechamento = scan.nextInt();
        } while (horaFechamento < 0 && horaFechamento > 23);

        do {
            System.out.println(
                    "Digite os MINUTOS de abertura do seu estabelecimento\nhorários válidos são de 0 a 59\n<NÃO DIGITE AS HORAS>\n>");
            minFechamento = scan.nextInt();
        } while (minFechamento < 0 && minFechamento > 59);
    }

}
