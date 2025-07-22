package inimigos;

import itens.Item;
import itens.PocaoPequena;
import itens.PocaoGrande;

public class Goblin extends Inimigo {
    public Goblin() {
        super("Goblin", 40, 45);
    }

    @Override
    public int calcularDano() {
        return 5 + (int)(Math.random() * 5); // 5-9 de dano
    }

    @Override
    protected Item gerarDrop() {
        double chance = Math.random();
        if (chance < 0.7) {
            return new PocaoPequena();
        } else {
            return new PocaoGrande();
        }
    }
}
