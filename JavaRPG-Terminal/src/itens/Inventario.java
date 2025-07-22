package itens;

import personagens.Personagem;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private final List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        System.out.println(item.getNome() + " foi adicionado ao inventário.");
    }

    public void usarItem(int indice, Personagem personagem) {
        if (indice >= 0 && indice < itens.size()) {
            Item item = itens.get(indice);
            item.usar(personagem);
            itens.remove(indice);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Inventário vazio.");
        } else {
            System.out.println("----- ITENS -----");
            for (int i = 0; i < itens.size(); i++) {
                System.out.println((i + 1) + ". " + itens.get(i).getNome());
            }
        }
    }

    public boolean temItens() {
        return !itens.isEmpty();
    }
}