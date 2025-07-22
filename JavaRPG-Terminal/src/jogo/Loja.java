package jogo;

import itens.*;
import personagens.Personagem;
import java.util.Scanner;

public class Loja {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarLoja(Personagem jogador) {
        System.out.println("\n=== 🏪 LOJA ===");
        System.out.println("XP disponível: " + jogador.getXp()); // Agora vai funcionar
        System.out.println("1. Poção Pequena (+20 HP) - 10 XP");
        System.out.println("2. Poção Grande (+40 HP) - 20 XP");
        System.out.println("3. Armadura de Couro (+5 DEF) - 30 XP");
        System.out.println("4. Sair");
        System.out.print("Escolha: ");

        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1 -> comprarItem(jogador, new PocaoPequena(), 10);
            case 2 -> comprarItem(jogador, new PocaoGrande(), 20);
            case 3 -> comprarItem(jogador, new Armadura("Armadura de Couro", 5), 30);
            case 4 -> System.out.println("Até a próxima!");
            default -> System.out.println("Opção inválida!");
        }
    }

    private static void comprarItem(Personagem jogador, Item item, int custo) {
        if (jogador.getXp() >= custo) { // Agora vai funcionar
            jogador.getInventario().adicionarItem(item);
            jogador.ganharXp(-custo);
            System.out.println("✅ " + item.getNome() + " comprado!");
        } else {
            System.out.println("XP insuficiente!");
        }
    }
}