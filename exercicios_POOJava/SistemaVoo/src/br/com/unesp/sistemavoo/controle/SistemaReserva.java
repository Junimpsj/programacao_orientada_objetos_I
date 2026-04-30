package br.com.unesp.sistemavoo.controle;

import br.com.unesp.sistemavoo.modelo.CartaoEmbarque;
import br.com.unesp.sistemavoo.modelo.Passageiro;
import br.com.unesp.sistemavoo.modelo.Reserva;
import br.com.unesp.sistemavoo.modelo.Voo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe controladora que gerencia o sistema completo de reservas de voos.
 * Responsável pela interação com o usuário, cadastro de passageiros, reserva de assentos,
 * emissão de cartões de embarque, gerenciamento de reservas e geração de relatórios.
 */
public class SistemaReserva {

    /** Voo gerenciado pelo sistema */
    private Voo voo;

    /** Lista de passageiros cadastrados na plataforma */
    private ArrayList<Passageiro> passageiros;

    /** Lista de reservas realizadas no voo */
    private ArrayList<Reserva> reservas;

    /** Scanner para leitura de entrada do usuário */
    private Scanner scanner;

    /**
     * Construtor que inicializa o sistema com o voo a ser gerenciado.
     *
     * @param voo Voo a ser gerenciado pelo sistema
     */
    public SistemaReserva(Voo voo) {
        this.voo = voo;
        this.passageiros = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inicia o sistema de gerenciamento, exibindo o menu principal e processando as escolhas.
     * O sistema permanece em execução até o usuário escolher sair.
     */
    public void iniciar() {
        System.out.println("=== Sistema de Reservas - Voo " + this.voo.getCodigoVoo() + " ===");

        int opcao = -1;

        while(opcao != 0) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1 - Cadastrar passageiro");
            System.out.println("2 - Listar passageiros cadastrados");
            System.out.println("3 - Realizar reserva");
            System.out.println("4 - Alterar reserva");
            System.out.println("5 - Excluir reserva");
            System.out.println("6 - Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = this.scanner.nextInt();
            this.scanner.nextLine();

            if(opcao == 1) {
                this.cadastrarPassageiro();
            } if(opcao == 2) {
                this.listarPassageiros();
            } if(opcao == 3) {
                this.realizarReserva();
            } if(opcao == 4) {
                this.alterarReserva();
            } if(opcao == 5) {
                this.excluirReserva();
            } if(opcao == 6) {
                this.menuRelatorios();
            } if(opcao == 0) {
                System.out.println("Sistema encerrado.");
            } if(opcao != 0 && opcao < 1 || opcao > 6) {
                System.out.println("Opção inválida.");
            }
        }
    }

    /**
     * Realiza o cadastro de um novo passageiro no sistema.
     * Verifica se o RG já está cadastrado para evitar duplicatas.
     */
    private void cadastrarPassageiro() {
        System.out.print("Nome do passageiro: ");
        String nome = this.scanner.nextLine();

        System.out.print("RG do passageiro: ");
        String rg = this.scanner.nextLine();

        boolean rgExistente = false;

        for(Passageiro p : this.passageiros) {
            if(p.getRg().equals(rg)) {
                rgExistente = true;
            }
        }

        if(!rgExistente) {
            Passageiro novoPassageiro = new Passageiro(nome, rg);
            this.passageiros.add(novoPassageiro);
            System.out.println("Passageiro " + nome + " cadastrado com sucesso!");
        } if(rgExistente) {
            System.out.println("Já existe um passageiro cadastrado com o RG " + rg);
        }
    }

    /**
     * Lista todos os passageiros cadastrados na plataforma.
     */
    private void listarPassageiros() {
        if(this.passageiros.size() > 0) {
            System.out.println("--- Passageiros Cadastrados ---");
            for(Passageiro p : this.passageiros) {
                p.exibir();
            }
        } if(this.passageiros.size() == 0) {
            System.out.println("Nenhum passageiro cadastrado.");
        }
    }

    /**
     * Realiza uma nova reserva para um passageiro previamente cadastrado.
     * Verifica disponibilidade e, se a classe estiver lotada, oferece a alternativa.
     * Se o passageiro não aceitar, informa que o próximo voo parte em 3 horas.
     */
    private void realizarReserva() {
        System.out.print("RG do passageiro: ");
        String rg = this.scanner.nextLine();

        Passageiro passageiro = buscarPassageiroPorRg(rg);

        if(passageiro == null) {
            System.out.println("Passageiro não encontrado. Cadastre o passageiro primeiro.");
            return;
        }

        System.out.println("Escolha a classe:");
        System.out.println("1 - Primeira Classe (poltronas 1-5)");
        System.out.println("2 - Classe Econômica (poltronas 6-10)");
        System.out.print("Opção: ");

        int opcaoClasse = this.scanner.nextInt();
        this.scanner.nextLine();

        int poltrona = -1;
        String classe = "";

        if(opcaoClasse == 1) {
            boolean temPrimeira = this.voo.temPrimeiraClasseDisponivel();
            if(temPrimeira) {
                poltrona = this.voo.reservarPrimeiraClasse();
                classe = "Primeira Classe";
            } if(!temPrimeira) {
                System.out.println("Primeira classe está lotada!");

                if(this.voo.temEconomicaDisponivel()) {
                    System.out.print("Deseja reservar na classe econômica? (1-Sim / 2-Não): ");
                    int resposta = this.scanner.nextInt();
                    this.scanner.nextLine();

                    if(resposta == 1) {
                        poltrona = this.voo.reservarEconomica();
                        classe = "Econômica";
                    } if(resposta == 2) {
                        System.out.println("O próximo voo parte em 3 horas.");
                        return;
                    }
                } if(!this.voo.temEconomicaDisponivel()) {
                    System.out.println("O voo está completamente lotado. O próximo voo parte em 3 horas.");
                    return;
                }
            }
        } if(opcaoClasse == 2) {
            boolean temEconomica = this.voo.temEconomicaDisponivel();
            if(temEconomica) {
                poltrona = this.voo.reservarEconomica();
                classe = "Econômica";
            } if(!temEconomica) {
                System.out.println("Classe econômica está lotada!");

                if(this.voo.temPrimeiraClasseDisponivel()) {
                    System.out.print("Deseja reservar na primeira classe? (1-Sim / 2-Não): ");
                    int resposta = this.scanner.nextInt();
                    this.scanner.nextLine();

                    if(resposta == 1) {
                        poltrona = this.voo.reservarPrimeiraClasse();
                        classe = "Primeira Classe";
                    } if(resposta == 2) {
                        System.out.println("O próximo voo parte em 3 horas.");
                        return;
                    }
                } if(!this.voo.temPrimeiraClasseDisponivel()) {
                    System.out.println("O voo está completamente lotado. O próximo voo parte em 3 horas.");
                    return;
                }
            }
        }

        if(poltrona == -1) {
            return;
        }

        Reserva novaReserva = new Reserva(passageiro, poltrona, classe, this.voo.getCodigoVoo());
        this.reservas.add(novaReserva);

        CartaoEmbarque cartao = new CartaoEmbarque(passageiro, poltrona, classe, this.voo.getCodigoVoo());
        cartao.exibir();
    }

    /**
     * Altera a reserva de um passageiro, permitindo mudança de assento ou classe.
     * Libera o assento anterior e ocupa o novo assento escolhido.
     */
    private void alterarReserva() {
        System.out.print("RG do passageiro cuja reserva deseja alterar: ");
        String rg = this.scanner.nextLine();

        Reserva reservaEncontrada = buscarReservaPorRg(rg);

        if(reservaEncontrada == null) {
            System.out.println("Reserva não encontrada para o RG informado.");
            return;
        }

        System.out.println("Reserva atual: ");
        reservaEncontrada.exibir();

        System.out.println("Nova classe:");
        System.out.println("1 - Primeira Classe (poltronas 1-5)");
        System.out.println("2 - Classe Econômica (poltronas 6-10)");
        System.out.print("Opção: ");

        int opcaoClasse = this.scanner.nextInt();
        this.scanner.nextLine();

        int novaPoltrona = -1;
        String novaClasse = "";

        if(opcaoClasse == 1) {
            if(!this.voo.temPrimeiraClasseDisponivel()) {
                System.out.println("Primeira classe está lotada. Não é possível alterar.");
                return;
            }
            this.voo.liberarAssento(reservaEncontrada.getAssento());
            novaPoltrona = this.voo.reservarPrimeiraClasse();
            novaClasse = "Primeira Classe";
        } if(opcaoClasse == 2) {
            if(!this.voo.temEconomicaDisponivel()) {
                System.out.println("Classe econômica está lotada. Não é possível alterar.");
                return;
            }
            this.voo.liberarAssento(reservaEncontrada.getAssento());
            novaPoltrona = this.voo.reservarEconomica();
            novaClasse = "Econômica";
        }

        if(novaPoltrona != -1) {
            reservaEncontrada.setAssento(novaPoltrona);
            reservaEncontrada.setClasse(novaClasse);
            System.out.println("Reserva alterada com sucesso!");
            reservaEncontrada.exibir();
        }
    }

    /**
     * Exclui a reserva de um passageiro, liberando o assento automaticamente.
     */
    private void excluirReserva() {
        System.out.print("RG do passageiro cuja reserva deseja excluir: ");
        String rg = this.scanner.nextLine();

        Reserva reservaEncontrada = buscarReservaPorRg(rg);

        if(reservaEncontrada == null) {
            System.out.println("Reserva não encontrada para o RG informado.");
            return;
        }

        this.voo.liberarAssento(reservaEncontrada.getAssento());
        this.reservas.remove(reservaEncontrada);
        System.out.println("Reserva de " + reservaEncontrada.getPassageiro().getNome() + " excluída com sucesso!");
    }

    /**
     * Exibe o menu de relatórios e processa a escolha do usuário.
     */
    private void menuRelatorios() {
        System.out.println("\n--- Relatórios ---");
        System.out.println("1 - Listar passageiros do voo");
        System.out.println("2 - Listar todas as reservas");
        System.out.println("3 - Status de assentos por classe");
        System.out.print("Opção: ");

        int opcao = this.scanner.nextInt();
        this.scanner.nextLine();

        if(opcao == 1) {
            this.relatorioPassageirosVoo();
        } if(opcao == 2) {
            this.relatorioTodasReservas();
        } if(opcao == 3) {
            this.relatorioStatusAssentos();
        } if(opcao != 1 && opcao != 2 && opcao != 3) {
            System.out.println("Opção inválida.");
        }
    }

    /**
     * Gera relatório listando todos os passageiros com reserva no voo.
     */
    private void relatorioPassageirosVoo() {
        System.out.println("--- Passageiros do Voo " + this.voo.getCodigoVoo() + " ---");

        if(this.reservas.size() > 0) {
            for(Reserva r : this.reservas) {
                r.getPassageiro().exibir();
            }
        } if(this.reservas.size() == 0) {
            System.out.println("Nenhum passageiro com reserva neste voo.");
        }
    }

    /**
     * Gera relatório com todas as reservas realizadas.
     */
    private void relatorioTodasReservas() {
        System.out.println("--- Todas as Reservas ---");

        if(this.reservas.size() > 0) {
            for(Reserva r : this.reservas) {
                r.exibir();
            }
        } if(this.reservas.size() == 0) {
            System.out.println("Nenhuma reserva registrada.");
        }
    }

    /**
     * Gera relatório com a quantidade de assentos ocupados e disponíveis por classe.
     */
    private void relatorioStatusAssentos() {
        int[] statusPrimeira = this.voo.statusPrimeiraClasse();
        int[] statusEconomica = this.voo.statusEconomica();

        System.out.println("--- Status dos Assentos - Voo " + this.voo.getCodigoVoo() + " ---");
        System.out.println("Primeira Classe: " + statusPrimeira[0] + " ocupado(s) | " + statusPrimeira[1] + " disponível(eis)");
        System.out.println("Classe Econômica: " + statusEconomica[0] + " ocupado(s) | " + statusEconomica[1] + " disponível(eis)");
    }

    /**
     * Busca um passageiro cadastrado pelo número do RG.
     *
     * @param rg Número do RG a ser buscado
     * @return Passageiro encontrado, ou null se não existir
     */
    private Passageiro buscarPassageiroPorRg(String rg) {
        for(Passageiro p : this.passageiros) {
            if(p.getRg().equals(rg)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Busca uma reserva pelo número do RG do passageiro.
     *
     * @param rg Número do RG do passageiro
     * @return Reserva encontrada, ou null se não existir
     */
    private Reserva buscarReservaPorRg(String rg) {
        for(Reserva r : this.reservas) {
            if(r.getPassageiro().getRg().equals(rg)) {
                return r;
            }
        }
        return null;
    }

}
