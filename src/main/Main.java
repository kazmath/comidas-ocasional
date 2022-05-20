package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import entidades.Cadastro;
import entidades.Cliente;
import entidades.Endereco;
import entidades.Estabelecimento;
import servicos.Servico;

public class Main {
    ArrayList<Servico> pedidos = new ArrayList<Servico>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int escolha;
        ArrayList<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        boolean controlador = true;

        System.out.println("Bem-Vindo ao Comidas Ocasionais");
        while (controlador) {
            System.out.println("""
                    =========================================
                    1-Login
                    2-Cadastro de Usuário
                    3-Cadastro de Restaurante
                    =========================================
                    """);
            System.out.println("Escolha as opções:");
            escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite seu Login: ");
                    String entradaLogin = scan.next();
                    System.out.print("Digite sua Senha: ");
                    String entradaSenha = scan.next();

                    for (Cliente cliente : clientes) {
                        Cadastro cadastro = cliente.getCadastro();
                        if (cadastro.getLogin().equals(entradaLogin)
                                &&
                                cadastro.getSenha().equals(entradaSenha)) {
                            controlador = false;
                            System.out.println();
                            break;
                        } else {
                            continue;
                        }
                    }
                    System.out.println(
                            controlador == false
                                    ? "Login realizado com sucesso!\n"
                                    : "ERRO: Credenciais não registradas. Cadastre-se primeiro.\n");

                    break;
                case 2:
                
                    Cliente cliente = cadCliente();
                    clientes.add(cliente);

                    break;
                case 3:

                    Estabelecimento estabelecimento = cadRestaurante();
                    estabelecimentos.add(estabelecimento);

                    break;

                default:
                    System.out.println("Erro: Seleção inválida.");
                    break;

            }

        }

    }

    private static Cliente cadCliente() {
        Cadastro cadastro = getCadastro();
        Endereco enderecoUser = getEndereco();
        Cliente cliente = new Cliente(cadastro);
        cliente.addEndereco(enderecoUser);
        System.out.println("Cadastro realizado com sucesso!\n\n");

        return cliente;
    }
    
    private static Estabelecimento cadRestaurante() {
        Scanner scanCadRest = new Scanner(System.in);
        System.out.println("Insira o nome do restaurante: ");
        scanCadRest.nextLine(); // Gambiarra
        String nome = scanCadRest.nextLine();

        System.out.println("Insira o cnpj: ");
        String cnpj = scanCadRest.nextLine();
        // System.out.println("Insira os horários de funcionamento: ");

        int abertura = getTempoAbertura();
        int fechamento = getTempoFechamento();

        System.out.println("Insira seu endereço: ");
        Endereco enderecoComp = getEndereco();
        HashMap<String, Integer> menu = getMenu();

        Estabelecimento estabelecimento = new Estabelecimento(
                nome,
                cnpj,
                abertura,
                fechamento,
                menu);
        estabelecimento.addEndereco(enderecoComp);
        return estabelecimento;
    }

    private static Cadastro getCadastro() {
        Scanner scanCadastro = new Scanner(System.in);

        System.out.println("Digite as informações");
        System.out.print("Login: ");
        String login = scanCadastro.next();

        System.out.print("CPF: ");
        String cpf = scanCadastro.next();

        System.out.print("Email: ");
        String email = scanCadastro.next();

        System.out.print("Senha: ");
        String senha = scanCadastro.next();

        return new Cadastro(login, cpf, email, senha);
    }

    private static Endereco getEndereco() {
        Scanner scanEndereco = new Scanner(System.in);
        System.out.println("Digite as informações");
        System.out.print("Rua: ");
        String Rua = scanEndereco.nextLine();

        System.out.print("Número da Casa: ");
        String numCasa = scanEndereco.nextLine();

        System.out.print("Bairro: ");
        String Bairro = scanEndereco.nextLine();

        System.out.print("Cidade: ");
        String Cidade = scanEndereco.nextLine();

        // scanEndereco.close();
        return new Endereco(Rua, numCasa, Bairro, Cidade);
    }

    private static int getTempoAbertura() {
        Scanner scanTempoAb = new Scanner(System.in);
        int horaAbertura;
        int minAbertura;
        int abertura;

        do {
            System.out.print(
                    "\u001B[32mDigite a HORA de Abertura do seu estabelecimento\n(horários válidos são das 0 as 23)\n<NÃO DIGITE OS MINUTOS>\n> \u001B[0m");
            horaAbertura = scanTempoAb.nextInt();
        } while (horaAbertura < 0 || horaAbertura > 23);

        do {
            System.out.print(
                    "\u001B[32mDigite os MINUTOS de Abertura do seu estabelecimento\n(horários válidos são de 0 a 59)\n<NÃO DIGITE AS HORAS>\n> \u001B[0m");
            minAbertura = scanTempoAb.nextInt();
        } while (minAbertura < 0 || minAbertura > 59);

        abertura = minAbertura + (horaAbertura * 60);

        return abertura;
    }

    private static int getTempoFechamento() {
        Scanner scanTempoFec = new Scanner(System.in);
        int horaFechamento;
        int minFechamento;
        int fechamento;

        do {
            System.out.print(
                    "\u001B[31mDigite a HORA de Fechamento do seu estabelecimento\n(horários válidos são das 0 as 23)\n<NÃO DIGITE OS MINUTOS>\n> \u001B[0m");
            horaFechamento = scanTempoFec.nextInt();
        } while (horaFechamento < 0 || horaFechamento > 23);

        do {
            System.out.print(
                    "\u001B[31mDigite os MINUTOS de Fechamento do seu estabelecimento\n(horários válidos são de 0 a 59)\n<NÃO DIGITE AS HORAS>\n> \u001B[0m");
            minFechamento = scanTempoFec.nextInt();
        } while (minFechamento < 0 || minFechamento > 59);

        fechamento = minFechamento + (horaFechamento * 60);

        return fechamento;
    }

    private static HashMap<String, Integer> getMenu() {

        Scanner scanMenu = new Scanner(System.in);
        HashMap<String, Integer> menu = new HashMap<String, Integer>();
        System.out.println("Central do Menu");
        boolean controlador = true;
        int escolha;
        while (controlador) {
            System.out.println("""
                    _________________________________________________

                    1- Adicionar prato
                    2- Remover prato
                    3- Confirmar seleção
                    _________________________________________________

                    """);
            System.out.println("Escolha as opções:");
            escolha = scanMenu.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do prato adicioná-lo.");
                    scanMenu.nextLine(); // Gambiarras
                    String prato = scanMenu.nextLine();
                    System.out.println("Digite o valor do prato adicioná-lo.");
                    int valor = (int) (scanMenu.nextFloat() * 100);
                    valor = valor * 100;
                    menu.put(prato, valor);
                    break;

                case 2:
                    if (menu.size() > 0) {
                        System.out.println("Digite o prato para removê-lo.");
                        scanMenu.nextLine(); // Gambiarras
                        String nome = scanMenu.nextLine();
                        menu.remove(nome);
                    } else {
                        System.out.println("Não há nenhum item registrado no menu.");
                    }
                    break;
                case 3:
                    controlador = false;
                    break;
            }

        }
        return menu;
    }

    private static boolean checkTempo(int abertura, int fechamento) {
        Calendar hoje = Calendar.getInstance();
        int horaAtual = hoje.get(Calendar.HOUR_OF_DAY);
        int minAtual = hoje.get(Calendar.MINUTE);
        int tempAtual = minAtual + (horaAtual * 60);

        if (tempAtual > abertura && tempAtual < fechamento) {
            return true;
        } else {
            return false;
        }
    }
}
