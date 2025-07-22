package itens;

import personagens.Personagem;

public class PocaoPequena extends Item {
    public PocaoPequena() {
        super("Poção Pequena");
    }

    @Override
    public void usar(Personagem personagem) {
        int cura = 20;
        personagem.recuperarHp(cura);
        System.out.println(personagem.getNome() + " recuperou " + cura + " de HP!");
    }
}