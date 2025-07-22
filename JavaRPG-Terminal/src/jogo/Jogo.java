package jogo;

import personagens.*;
import inimigos.*;
import itens.PocaoPequena;
import java.util.Scanner;
import itens.Item;

public class Jogo {
    private static Scanner scanner = new Scanner(System.in);
    private static Personagem jogador;
    private static Inimigo inimigo;

    public static void main(String[] args) {
        System.out.println("===== RPG TERMINAL =====");
        iniciarJogo();
    }

    private static void iniciarJogo() {
        criarPersonagem();
        escolherInimigo();
        batalha();
    }

    private static void criarPersonagem() {
        System.out.print("\nDigite o nome do seu personagem: ");
        String nome = scanner.nextLine();

        System.out.println("\nEscolha sua classe:");
        System.out.println("1 - Guerreiro (HP: 120, Dano: 10-15)");
        System.out.println("2 - Mago (HP: 80, Dano: 8-12)");
        System.out.println("3 - Arqueiro (HP: 90, Dano: 9-14)");
        System.out.println("4 - Ladrão (HP: 85, Dano: 7-16)");
        System.out.println("5 - Curandeiro (HP: 100, Dano: 6-10)");
        System.out.println("6 - Necromante (HP: 85, Dano: 8-13)");
        System.out.println("7 - Paladino (HP: 110, Dano: 9-12)");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> jogador = new Guerreiro(nome);
            case 2 -> jogador = new Mago(nome);
            case 3 -> jogador = new Arqueiro(nome);
            case 4 -> jogador = new Ladrao(nome);
            case 5 -> jogador = new Curandeiro(nome);
            case 6 -> jogador = new Necromante(nome);
            case 7 -> jogador = new Paladino(nome);
            default -> {
                System.out.println("Opção inválida! Criando Guerreiro por padrão.");
                jogador = new Guerreiro(nome);
            }
        }

        System.out.println("\nPersonagem criado: " + jogador.getNome());
    }

    private static void escolherInimigo() {
        System.out.println("\nEscolha seu inimigo:");
        System.out.println("1 - Goblin (HP: 40, Dano: 5-9) - Fácil");
        System.out.println("2 - Orc (HP: 80, Dano: 10-19) - Médio");
        System.out.println("3 - Dragão (HP: 150, Dano: 20-34) - Difícil");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> inimigo = new Goblin();
            case 2 -> inimigo = new Orc();
            case 3 -> inimigo = new Dragao();
            default -> {
                System.out.println("Opção inválida! Criando Goblin por padrão.");
                inimigo = new Goblin();
            }
        }

        System.out.println("\nInimigo encontrado: " + inimigo.getNome() + "!");
    }

    private static void batalha() {
        System.out.println("\n===== BATALHA INICIADA =====");

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            turnoJogador();
            if (inimigo.estaVivo()) {
                turnoInimigo();
            }
        }

        if (jogador.estaVivo()) {
            vitoria();
        } else {
            derrota();
        }
    }

    private static void turnoJogador() {
        System.out.println("\n=== SEU TURNO ===");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("3 - Usar Habilidade");
        System.out.println("4 - Usar Item");
        System.out.println("5 - Ver Status");
        System.out.print("Escolha uma ação: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> jogador.atacar(inimigo);
            case 2 -> jogador.defender();
            case 3 -> jogador.usarHabilidade(inimigo);
            case 4 -> jogador.usarItem();
            case 5 -> {
                jogador.verStatus();
                inimigo.verStatus();
                turnoJogador(); // Volta ao turno após ver status
            }
            default -> System.out.println("Opção inválida! Perdeu o turno.");
        }
    }

    private static void turnoInimigo() {
        System.out.println("\n=== TURNO DO INIMIGO ===");
        inimigo.atacar(jogador);
    }

    private static void vitoria() {
        int xpGanho = inimigo.getXpRecompensa();
        jogador.ganharXp(xpGanho);

        Item drop = inimigo.dropItem();
        if (drop != null) {
            System.out.println("\n🎁 " + inimigo.getNome() + " dropou: " + drop.getNome());
            jogador.getInventario().adicionarItem(drop);
        }

        menuPosBatalha();
    }

    private static void derrota() {
        System.out.println("\n💀 " + jogador.getNome() + " foi derrotado por " + inimigo.getNome() + "... 💀");
        System.out.println("Fim de jogo.");
        menuFinal();
    }

    // ---  MENU POS BATALHA ---
    private static void menuPosBatalha() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Continuar batalhando");
        System.out.println("2. Visitar loja");
        System.out.println("3. Salvar e sair");
        System.out.print("Escolha: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> {
                escolherInimigo();
                batalha();
            }
            case 2 -> {
                Loja.mostrarLoja(jogador);
                menuPosBatalha(); // Volta ao menu após visitar loja
            }
            case 3 -> {
                System.out.println("Jogo salvo! (a funcionalidade de salvar ainda será implementada)");
                System.out.println("Até logo, " + jogador.getNome() + "!");
            }
            default -> {
                System.out.println("Opção inválida!");
                menuPosBatalha();
            }
        }
    }

    private static void menuFinal() {
        System.out.println("\n=== MENU FINAL ===");
        System.out.println("1 - Jogar novamente");
        System.out.println("2 - Ver status");
        System.out.println("3 - Sair");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> iniciarJogo();
            case 2 -> {
                jogador.verStatus();
                menuFinal();
            }
            case 3 -> System.out.println("Obrigado por jogar!");
            default -> {
                System.out.println("Opção inválida!");
                menuFinal();
            }
        }
    }
}
