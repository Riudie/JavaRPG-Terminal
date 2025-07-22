package itens;

import personagens.Personagem;

public class PocaoGrande extends Item {
    public PocaoGrande() {
        super("Poção Grande");
    }

    @Override
    public void usar(Personagem personagem) {
        int cura = 40;
        personagem.recuperarHp(cura);
        System.out.println(personagem.getNome() + " recuperou " + cura + " de HP!");
    }
}