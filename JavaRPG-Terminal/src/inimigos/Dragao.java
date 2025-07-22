package inimigos;

import itens.Item;
import itens.PocaoGrande;
import itens.Armadura;
import itens.Arma;

public class Dragao extends Inimigo {
    public Dragao() {
        super("Dragão", 150, 100);
    }

    @Override
    public int calcularDano() {
        return 20 + (int)(Math.random() * 15); // 20-34 de dano
    }

    @Override
    protected Item gerarDrop() {
        double chance = Math.random();
        if (chance < 0.4) {
            return new Armadura("Escama de Dragão", 10);
        } else if (chance < 0.8) {
            return new PocaoGrande();
        } else {
            return new Arma("Garra de Dragão", 15);
        }
    }
}
