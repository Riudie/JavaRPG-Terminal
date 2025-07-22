package itens;

import personagens.Personagem;

public class Arma extends Item {
    private int danoExtra;

    public Arma(String nome, int danoExtra) {
        super(nome);
        this.danoExtra = danoExtra;
    }

    @Override
    public void usar(Personagem personagem) {
        personagem.setDanoExtra(danoExtra);
        System.out.println(personagem.getNome() + " equipou " + getNome() + " (+" + danoExtra + " DANO)!");
    }
}