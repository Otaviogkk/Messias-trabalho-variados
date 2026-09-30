package br.edu.ifpi.Principal;

import br.edu.ifpi.*;
import br.edu.ifpi.Model.*;
import br.edu.ifpi.DAO.ClienteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProgramaViagens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgenciaViagens agencia = new AgenciaViagens();
        DateTimeFormatter formatter = new java.time.format.DateTimeFormatterBuilder()
            .appendPattern("[dd/MM/yyyy]")
            .appendPattern("[dd MM yyyy]")
            .toFormatter();

        // Inicializacao da JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("viagens-pu");
        EntityManager em = emf.createEntityManager();
        ClienteDAO dao = new ClienteDAO(em);

        int opcaoMenu = 0;
        try {
            while (opcaoMenu != 4) {
                System.out.println("\n=== MENU DA AGENCIA ===");
                System.out.println("1 - Nova Reserva");
                System.out.println("2 - Listar Reservas");
                System.out.println("3 - Pesquisar Cliente por CPF");
                System.out.println("4 - Sair");
                System.out.print("Escolha: ");
                opcaoMenu = scanner.nextInt();
                scanner.nextLine();

                if (opcaoMenu == 1) {
                    System.out.println("\n=== Cadastro do Cliente ===");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    
                    Cliente cliente = dao.buscarPorCpf(cpf);
                    if (cliente == null) {
                        cliente = new Cliente();
                        cliente.setCpf(cpf);
                        cliente.setNome(nome);
                        System.out.print("Email: ");
                        cliente.setEmail(scanner.nextLine());

                        System.out.println("\n=== Endereço do Cliente ===");
                        System.out.print("Rua: ");
                        String rua = scanner.nextLine();
                        System.out.print("Cidade: ");
                        String cidadeEnd = scanner.nextLine();
                        System.out.print("Estado: ");
                        String estadoEnd = scanner.nextLine();
                        System.out.print("CEP: ");
                        String cep = scanner.nextLine();

                        Endereco endereco = new Endereco();
                        endereco.setRua(rua);
                        endereco.setCidade(cidadeEnd);
                        endereco.setEstado(estadoEnd);
                        endereco.setCep(cep);
                        cliente.setEndereco(endereco);
                    } else {
                        System.out.println("Bem-vindo de volta, " + cliente.getNome() + "!");
                    }
                
                System.out.println("\n=== Destino ===");
                System.out.print("Cidade: ");
                String cidade = scanner.nextLine();
                System.out.print("Pai­s: ");
                String pais = scanner.nextLine();
                
                Destino destino = new Destino();
                destino.setNome(cidade);
                destino.setPais(pais);
                
                System.out.println("\n=== Dados do Voo ===");
                System.out.print("Companhia Area: ");
                String companhia = scanner.nextLine();
                System.out.print("Origem: ");
                String origem = scanner.nextLine();
                System.out.print("Preço da passagem: ");
                double precoPassagem = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Data de Ida (DD/MM/AAAA ou DD MM AAAA): ");
                String dataIda = scanner.nextLine();
                
                Voo voo = new Voo();
                voo.setCompanhiaAerea(companhia);
                voo.setOrigem(origem);
                voo.setDestinoVoo(destino);
                voo.setPrecoPassagem(precoPassagem);
                voo.setDataIda(LocalDate.parse(dataIda, formatter));
                
                System.out.println("\n=== Hospedagem ===");
                System.out.print("Nome do Hotel: ");
                String hotel = scanner.nextLine();
                System.out.print("Quantidade de dirias: ");
                int diarias = scanner.nextInt();
                System.out.print("Preço por diaria: ");
                double precoDiaria = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Data Check-in (DD/MM/AAAA ou DD MM AAAA): ");
                String dataCheckin = scanner.nextLine();
                
                Hospedagem hospedagem = new Hospedagem();
                hospedagem.setHotel(hotel);
                hospedagem.setDiarias(diarias);
                hospedagem.setPrecoPorNoite(precoDiaria);
                hospedagem.setDataCheckin(LocalDate.parse(dataCheckin, formatter));
                
                System.out.println("\n=== Passeio ===");
                System.out.print("Deseja incluir um passeio? (1-Sim / 2-Nao): ");
                String opPasseio = scanner.nextLine().trim().toLowerCase();
                boolean querPasseio = opPasseio.equals("1") || opPasseio.equals("s") || opPasseio.equals("sim");

                Passeio passeio = null;
                if (querPasseio) {
                    System.out.print("Nome do passeio: ");
                    String nomePasseio = scanner.nextLine();
                    System.out.print("Preço do passeio: ");
                    double precoPasseio = scanner.nextDouble();
                    scanner.nextLine();

                    passeio = new Passeio();
                    passeio.setNomePasseio(nomePasseio);
                    passeio.setPrecoPasseio(precoPasseio);
                }
                
                PacoteTuristico pacote = new PacoteTuristico();
                pacote.setNomePacote("Pacote para " + destino.getNome());
                pacote.adicionarServico(voo);
                pacote.adicionarServico(hospedagem);
                if (passeio != null) {
                    pacote.adicionarServico(passeio);
                }

                System.out.println("\n=== Seguro Viagem ===");
                System.out.print("Deseja seguro viagem? (1-Sim / 2-Nao): ");
                String opSeguro = scanner.nextLine().trim().toLowerCase();
                boolean querSeguro = opSeguro.equals("1") || opSeguro.equals("s") || opSeguro.equals("sim");
                if (querSeguro) {
                    System.out.print("Seguradora: ");
                    String seguradora = scanner.nextLine();
                    System.out.print("Cobertura: ");
                    String cobertura = scanner.nextLine();
                    System.out.print("Preço: ");
                    double precoSeguro = scanner.nextDouble();
                    scanner.nextLine();
                    
                    SeguroViagem seguro = new SeguroViagem();
                    seguro.setSeguradora(seguradora);
                    seguro.setTipoCobertura(cobertura);
                    seguro.setPreco(precoSeguro);
                    pacote.adicionarServico(seguro);
                }

                MetodoPagamento pagamento = null;
                System.out.println("\nForma de pagamento");
                System.out.println("1 - Cartão de Credito");
                System.out.println("2 - Pix");
                System.out.print("Escolha: ");
                int opcaoPagamento = scanner.nextInt();
                scanner.nextLine();

                if (opcaoPagamento == 1) {
                    System.out.print("Numero do cartão: ");
                    String numero = scanner.nextLine();
                    System.out.print("Nome do titular: ");
                    String titular = scanner.nextLine();

                    CartaoCredito cc = new CartaoCredito();
                    cc.setNumeroCartao(numero);
                    cc.setNomeTitular(titular);
                    pagamento = cc;
                } else {
                    System.out.print("Chave Pix: ");
                    String chave = scanner.nextLine();

                    TransferenciaBancaria tb = new TransferenciaBancaria();
                    tb.setChavepix(chave);
                    pagamento = tb;
                }

                Reserva reserva = new Reserva();
                reserva.setCliente(cliente);
                if (cliente.getReservas() != null) {
                    cliente.getReservas().add(reserva);
                }
                reserva.setPacote(pacote);
                reserva.setMetodoPagamento(pagamento);
                System.out.println("\n===== PROCESSANDO =====");
                reserva.confirmarReserva();
                agencia.adicionarReserva(reserva);
                
                try {
                    dao.salvarReserva(reserva);
                    System.out.println("\n[JPA] Reserva e Cliente salvos no banco de dados com sucesso! (ID da Reserva: " + reserva.getId() + ")");
                } catch (Exception e) {
                    System.out.println("\n[JPA] Erro ao salvar a reserva no banco: " + e.getMessage());
                }

            } else if (opcaoMenu == 2) {
                System.out.println("\n=== LISTA DE RESERVAS (BANCO DE DADOS) ===");
                java.util.List<Reserva> reservasDb = dao.listarTodasReservas();
                if (reservasDb.isEmpty()) {
                    System.out.println("Nenhuma reserva encontrada no banco de dados.");
                } else {
                    for (Reserva r : reservasDb) {
                        System.out.println("Reserva ID: " + r.getId() + " | Status: " + r.getStatus());
                        System.out.println("Cliente: " + r.getCliente().getNome());
                        System.out.println("Detalhes: \n" + r.getDetalhesPacote());
                        System.out.println("Valor Total: R$ " + r.getValorTotal());
                        System.out.println("--------------------------------------");
                    }
                }
            } else if (opcaoMenu == 3) {
                System.out.print("\nInforme o CPF para pesquisa: ");
                String cpfBusca = scanner.nextLine();
                
                Cliente clienteEncontrado = dao.buscarPorCpf(cpfBusca);
                if (clienteEncontrado != null) {
                    System.out.println("\n--- Cliente Encontrado ---");
                    System.out.println("ID: " + clienteEncontrado.getId());
                    System.out.println("Nome: " + clienteEncontrado.getNome());
                    System.out.println("Email: " + clienteEncontrado.getEmail());
                    System.out.println("CPF: " + clienteEncontrado.getCPF());
                    System.out.print("Mais informacoes - sim ou nao");
                    String informacoes = scanner.nextLine().trim().toLowerCase();
                    boolean infomacoes = informacoes.equals("1") || informacoes.equals("s") || informacoes.equals("sim");
                    if (infomacoes) {
                        Endereco end = clienteEncontrado.getEndereco();
                        System.out.println("Endereço: " + end.getRua() + ", " + end.getCidade() + " - " + end.getEstado() + " (CEP: " + end.getCep() + ")");
                    }
                    System.out.println("\n--- Historico de Reservas no Banco ---");
                    if (clienteEncontrado.getReservas() != null && !clienteEncontrado.getReservas().isEmpty()) {
                        for (Reserva r : clienteEncontrado.getReservas()) {
                            System.out.println("  -> Reserva ID: " + r.getId() + " | Status: " + r.getStatus());
                            System.out.println("     Detalhes do Pacote: \n" + r.getDetalhesPacote());
                            System.out.println("     Valor Total: R$ " + r.getValorTotal());
                            System.out.println("     Pagamento: " + r.getDetalhesPagamento());
                            System.out.println("  --------------------------------------");
                        }
                    } else {
                        System.out.println("Nenhuma reserva associada a este cliente no banco.");
                    }
                    System.out.println("--------------------------");
                } else {
                    System.out.println("Nenhum cliente encontrado com este CPF.");
                }
            }
        }
        } finally {
            System.out.println("Fechando conexoes...");
            scanner.close();
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
