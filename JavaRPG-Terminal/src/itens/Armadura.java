package itens;

import personagens.Personagem;

public class Armadura extends Item {
    private int defesa;

    public Armadura(String nome, int defesa) {
        super(nome);
        this.defesa = defesa;
    }

    @Override
    public void usar(Personagem personagem) {
        personagem.setDefesaExtra(defesa);
        System.out.println(personagem.getNome() + " equipou " + getNome() + " (+" + defesa + " DEF)!");
    }
}