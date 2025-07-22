package inimigos;

import itens.Item;
import itens.PocaoGrande;
import itens.PocaoGrande;

public class Orc extends Inimigo {
    public Orc() {
        super("Orc", 80, 60);
    }

    @Override
    public int calcularDano() {
        return 10 + (int)(Math.random() * 10); // 10-19 de dano
    }

    @Override
    protected Item gerarDrop() {
        double chance = Math.random();
        if (chance < 0.5) {
            return new PocaoGrande();
        } else {
            return new PocaoGrande();
        }
    }
}
