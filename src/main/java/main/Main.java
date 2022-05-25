package main;

import java.util.ArrayList;
// import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Cadastro;
import entidades.Cliente;
import entidades.Endereco;
import entidades.Estabelecimento;
import servicos.Servico;

public class Main {
    ArrayList<Servico> pedidos = new ArrayList<Servico>();
    static Statement stmt;

    public static void main(String[] args) throws Exception {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost", "root", "root");
        stmt = conn.createStatement();
        int[] SQLResult;
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/main/Database.sql")));) {
            String sqlFile = "";
            String line;
            while ((line = br.readLine()) != null) {
                // stmt.addBatch(line);
                sqlFile += line;
                // System.out.println(line);
            }
            for (String statement : sqlFile.split(";")) {
                stmt.addBatch(statement);
            }
        }
        SQLResult = stmt.executeBatch();

        Scanner scan = new Scanner(System.in);
        int escolha;
        // ArrayList<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        boolean controlador = true;
        String codLogin = null;
        String codLoginEst = null;

        System.out.println("Bem-Vindo ao Comidas Ocasionais");
        while (controlador) {
            System.out.println("""
                    =========================================
                    1-Login de Pessoa Física/Jurídica
                    2-Cadastro de Pessoa Física/Jurídica
                    3-Login de Estabelecimento
                    4-Cadastro de Estabelecimento
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

                    if (login(entradaLogin, entradaSenha)) {
                        codLogin = entradaLogin;
                        controlador = false;
                    }

                    System.out.println(
                            controlador == false
                                    ? "Login realizado com sucesso!\n"
                                    : "ERRO: Credenciais não registradas. Cadastre-se primeiro.\n");

                    break;
                case 2:
                    Cadastro cadastro = getCadastro();
                    System.out.print("Nome completo: ");
                    scan.next();
                    String nome = scan.nextLine();

                    Endereco enderecoUser = getEndereco();

                    stmt.execute(
                        "INSERT INTO Endereco(Bairro, NumCasa, Cidade, Rua) VALUES (" +
                            "'" + enderecoUser.getBairro() + "'" + ", " +
                            "'" + enderecoUser.getNumCasa() + "'" + ", " +
                            "'" + enderecoUser.getCidade() + "'" + ", " +
                            "'" + enderecoUser.getRua() + "'" +
                        ")"
                    );
                    ResultSet rsEndereco = stmt.executeQuery(
                        "SELECT * FROM Endereco ORDER BY CodEndereco DESC LIMIT 1"
                    );
                    rsEndereco.next();
                    int CodEnderecoCli = rsEndereco.getInt("CodEndereco");

                    stmt.execute(
                        "INSERT INTO Cadastro(Login, Email, Senha) VALUES (" +
                            "'" + cadastro.getLogin() + "'" + ", " +
                            "'" + cadastro.getEmail() + "'" + ", " +
                            "'" + cadastro.getSenha() + "'" +
                        ")"
                    );
                    ResultSet rsCadastro = stmt.executeQuery(
                        "SELECT * FROM Cadastro ORDER BY CodCadastro DESC LIMIT 1"
                    );
                    rsCadastro.next();
                    int codCadastroCli = rsCadastro.getInt("CodCadastro");
                    
                    Cliente cliente = cadCliente(nome, cadastro, enderecoUser);
                    stmt.execute(
                        "INSERT INTO Cliente_PF(Nome, CPF, CodEndereco, CodCadastro) VALUES (" +
                            "'" + cliente.getNome() + "'" + ", " +
                            "'" + cliente.getCadastro().getCpf() + "'" + ", " +
                            CodEnderecoCli + ", " +
                            codCadastroCli +
                        ")"
                    );
                    System.out.println("Cadastro realizado com sucesso!\n\n");

                    // clientes.add(cliente);

                    break;
                case 3:
                    System.out.print("Insira o CNPJ da sua empresa: ");
                    scan.next();
                    String cnpjLogin = scan.nextLine();
                    if (loginEst(cnpjLogin)) {
                        codLoginEst = cnpjLogin;
                        controlador = false;
                    }

                    System.out.println(
                        controlador == false
                                ? "Login realizado com sucesso!\n"
                                : "ERRO: Credenciais não registradas. Cadastre-se primeiro.\n"
                    );
                    break;
                case 4:
                    System.out.println("Insira o nome do estabelecimento: ");
                    scan.nextLine();
                    String nomeEst = scan.nextLine();
            
                    System.out.println("Insira o cnpj: ");
                    String cnpj = scan.nextLine();
  
                    System.out.println("Insira seu endereço: ");
                    Endereco enderecoComp = getEndereco();
                    HashMap<String, Integer> menu = getMenu();

                    Estabelecimento estabelecimento = cadEstabelecimento(
                        nomeEst,
                        cnpj,
                        false,
                        menu,
                        enderecoComp
                    );
                    
                    // estabelecimentos.add(estabelecimento);
                    stmt.execute(
                        "INSERT INTO Endereco(Bairro, NumCasa, Cidade, Rua) VALUES (" +
                            "'" + enderecoComp.getBairro() + "'" + ", " +
                            "'" + enderecoComp.getNumCasa() + "'" + ", " +
                            "'" + enderecoComp.getCidade() + "'" + ", " +
                            "'" + enderecoComp.getRua() + "'" +
                        ")"
                    );
                    ResultSet RsEnderecoEst = stmt.executeQuery(
                        "SELECT * FROM Endereco ORDER BY CodEndereco DESC LIMIT 1"
                    );
                    RsEnderecoEst.next();
                    stmt.execute(
                        "INSERT INTO Estabelecimento(Nome,CNPJ,Aberto,CodEndereco) VALUES (" +
                            "'" + estabelecimento.getNome() + "'" + ", " +
                            "'" + estabelecimento.getCnpj() + "'" + ", " +
                            (estabelecimento.getAberto() ? 1 : 0) + ", " +
                            RsEnderecoEst.getString("CodEndereco") +
                        ")"
                    );
                    ResultSet rsEstabelecimento = stmt.executeQuery(
                        "SELECT * FROM Estabelecimento ORDER BY CodEstabelecimento DESC LIMIT 1"
                    );
                    rsEstabelecimento.next();
                    int CodEstabelecimento = rsEstabelecimento.getInt("CodEstabelecimento");
                    
                    for (String nomePrato : menu.keySet()) {
                        stmt.execute(
                            "INSERT INTO Prato(Nome, Preco) VALUES (" +
                                "'" + nomePrato + "'" + ", " +
                                menu.get(nomePrato) +
                            ")"
                        );
                        ResultSet RsPrato = stmt.executeQuery(
                            "SELECT * FROM Prato ORDER BY Id DESC LIMIT 1"
                        );
                        RsPrato.next();
                        stmt.execute(
                            "INSERT INTO Cardapio(fk_Estabelecimento_Cod, Prato_Id) VALUES (" +
                                CodEstabelecimento + ", " +
                                RsPrato.getString("Id") + 
                            ")"
                        );
                    }

                    break;

                default:
                    System.out.println("Erro: Seleção inválida.");
                    break;

            }

        }

        if (codLogin != null) {
            HashMap<String,String> estHashMap = new HashMap<String,String>();

            try (
                ResultSet rs = stmt.executeQuery(
                    "SELECT CodEstabelecimento,Nome FROM Estabelecimento " +
                    "WHERE Aberto=1"
                );
            ) {
                System.out.println("Selecione o estabelecimento:");
                while (rs.next()) {
                    estHashMap.put(
                        rs.getString("CodEstabelecimento"),
                        rs.getString("Nome")
                    );
                }                    
            }
            
            

            while (true) {
                for (String est : estHashMap.keySet()) {
                    System.out.println(est + " " + estHashMap.get(est));
                }
                System.out.print("\n> ");
                String selection = scan.next();
                scan.nextLine();
                String CodEstabelecimento;

                try (
                    ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM Estabelecimento " +
                        "WHERE CodEstabelecimento=" + selection
                    );
                ) {
                    rs.next();
                    CodEstabelecimento = rs.getString("CodEstabelecimento");
                } catch (SQLException e) {
                    e.printStackTrace();
                    continue;
                }
                
                ResultSet rsCardapio = stmt.executeQuery(
                    "SELECT p.Id,p.Nome,p.Preco FROM Cardapio AS c, Prato AS p, Estabelecimento as e " +
                    "WHERE c.Prato_Id=p.Id AND " +
                    "c.fk_Estabelecimento_Cod=e.CodEstabelecimento AND " +
                    "e.CodEstabelecimento=" + CodEstabelecimento
                );    
                System.out.println("\nFaça seu pedido:");
                boolean concluido = true;
                

                HashMap<Integer,String[]> cardHashMap = new HashMap<Integer,String[]>();
                while (rsCardapio.next()) {
                    String prato[] = {
                        rsCardapio.getString("Nome"),
                        String.valueOf(rsCardapio.getInt("Preco") / 100)
                    };
                    cardHashMap.put(rsCardapio.getInt("Id"), prato);
                }
                while (concluido) {
                    for (Integer entry : cardHashMap.keySet()) {
                        System.out.println(
                            "(" + String.valueOf(entry) + ")" +
                            " " + cardHashMap.get(entry)[0] +
                            ": R$" + cardHashMap.get(entry)[1]
                        );
                    }
                    System.out.print("Digite o código do prato: ");
                    String addPedido = scan.next();
                    System.out.println();
                    // TODO: Continuar
                }

                
            }
        } else if (codLoginEst != null) {

        }

    }

    private static Cliente cadCliente(String nome, Cadastro cadastro, Endereco enderecoUser) {
        Cliente cliente = new Cliente(nome, cadastro);
        cliente.addEndereco(enderecoUser);

        return cliente;
    }
    
    private static Estabelecimento cadEstabelecimento(
        String nome,
        String cnpj,
        boolean aberto,
        HashMap<String, Integer> menu,
        Endereco enderecoComp
    ) {
        Estabelecimento estabelecimento = new Estabelecimento(
                nome,
                cnpj,
                aberto,
                menu);
        estabelecimento.addEndereco(enderecoComp);
        return estabelecimento;
    }

    private static Cadastro getCadastro() {
        Scanner scanCadastro = new Scanner(System.in);

        System.out.println("Digite as informações");
        System.out.print("Login: ");
        String login = scanCadastro.next();

        System.out.print("CPF/CNPJ: ");
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
                    scanMenu.nextLine();
                    String prato = scanMenu.nextLine();
                    System.out.println("Digite o valor do prato adicioná-lo.");
                    int valor = (int) (scanMenu.nextFloat() * 100);
                    menu.put(prato, valor);
                    break;

                case 2:
                    if (menu.size() > 0) {
                        System.out.println("Digite o prato para removê-lo.");
                        scanMenu.nextLine();
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

    // private static boolean checkTempo(int abertura, int fechamento) {
    //     Calendar hoje = Calendar.getInstance();
    //     int horaAtual = hoje.get(Calendar.HOUR_OF_DAY);
    //     int minAtual = hoje.get(Calendar.MINUTE);
    //     int tempAtual = minAtual + (horaAtual * 60);

    //     if (tempAtual > abertura && tempAtual < fechamento) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    // private static Cliente login(String login, String senha, ArrayList<Cliente> clientes) {
    //     Scanner scan = new Scanner(System.in);
    //     Cliente outCliente = null;

    //     for (Cliente cliente : clientes) {
    //         Cadastro cadastro = cliente.getCadastro();
    //         if (cadastro.getLogin().equals(login)
    //                 &&
    //                 cadastro.getSenha().equals(senha)) {
    //             System.out.println();
    //             outCliente = cliente;
    //             break;
    //         } else {
    //             continue;
    //         }
    //     }
    //     return outCliente;

    // }
    private static boolean login(String login, String senha) throws Exception {
        boolean codLogin = stmt.executeQuery(
            "SELECT cl.CodCadastro, ca.Login, ca.Senha " +
            "FROM Cliente_PF AS cl, Cadastro AS ca " +
            "WHERE ca.Login='" + login + "' AND ca.Senha='" + senha + "' AND cl.CodCadastro=ca.CodCadastro"
        ).next();
        // System.out.println(codLogin);
        return codLogin;
    }
    private static boolean loginEst(String cnpj) throws Exception {
        boolean codLogin = stmt.executeQuery(
            "SELECT cnpj " +
            "FROM Estabelecimento "
        ).next();
        // System.out.println(codLogin);
        return codLogin;
    }
}
