package inimigos;

import personagens.Personagem;
import itens.Item;

public abstract class Inimigo {
    private String nome;
    private int hp;
    private final int hpMaximo;
    private int xpRecompensa;

    public Inimigo(String nome, int hp, int xpRecompensa) {
        this.nome = nome;
        this.hp = hp;
        this.hpMaximo = hp;
        this.xpRecompensa = xpRecompensa;
    }

    public void receberDano(int dano) {
        hp -= dano;
        if (hp < 0) hp = 0;
        System.out.println(nome + " recebeu " + dano + " de dano. HP restante: " + hp + "/" + hpMaximo);
    }

    public void atacar(Personagem personagem) {
        int dano = calcularDano();
        System.out.println(nome + " ataca " + personagem.getNome() + "!");
        personagem.receberDano(dano);
    }

    public void verStatus() {
        System.out.println("[" + nome + " HP: " + hp + "/" + hpMaximo + "]");
    }

    public boolean estaVivo() {
        return hp > 0;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getXpRecompensa() {
        return xpRecompensa;
    }

    public abstract int calcularDano();

    // --- Método de drop de item ---
    public Item dropItem() {
        double chance = Math.random();
        if (chance < 0.6) {  // 60% de chance de dropar item
            return gerarDrop();
        }
        return null;
    }

    protected abstract Item gerarDrop();
}
