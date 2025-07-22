package personagens;

import inimigos.Inimigo;
import itens.Inventario;

public abstract class Personagem {
    private final String nome;
    private int hp;
    private int hpMaximo;
    private int xp;
    private final Inventario inventario;
    private boolean defendendo;

    private int nivel = 1;
    private int xpParaProxNivel = 50;
    private int defesaExtra = 0;
    private int danoExtra = 0; // ➕ Novo atributo

    public Personagem(String nome, int hpMaximo) {
        this.nome = nome;
        this.hpMaximo = hpMaximo;
        this.hp = hpMaximo;
        this.xp = 0;
        this.inventario = new Inventario();
        this.defendendo = false;
    }

    public void atacar(Inimigo inimigo) {
        int dano = calcularDano();
        System.out.println(nome + " ataca " + inimigo.getNome() + " causando " + dano + " de dano!");
        inimigo.receberDano(dano);
    }

    public void defender() {
        System.out.println(nome + " está se defendendo! O próximo ataque será reduzido.");
        defendendo = true;
    }

    public void receberDano(int dano) {
        if (defendendo) {
            dano = (int) (dano * 0.5);
            System.out.println(nome + " defendeu parte do ataque! Dano reduzido para " + dano);
            defendendo = false;
        }

        dano -= defesaExtra;
        if (dano < 0) dano = 0;

        hp -= dano;
        if (hp < 0) hp = 0;
        System.out.println(nome + " recebeu " + dano + " de dano. HP: " + hp + "/" + hpMaximo);
    }

    public void recuperarHp(int quantidade) {
        hp += quantidade;
        if (hp > hpMaximo) hp = hpMaximo;
        System.out.println(nome + " recuperou " + quantidade + " HP. HP atual: " + hp + "/" + hpMaximo);
    }

    public void usarHabilidade(Inimigo inimigo) {
        System.out.println(nome + " usa habilidade especial!");
    }

    public void usarItem() {
        if (!inventario.temItens()) {
            System.out.println("Inventário vazio!");
            return;
        }

        inventario.listarItens();
        System.out.print("Escolha um item para usar (0 para cancelar): ");
        try {
            java.util.Scanner sc = new java.util.Scanner(System.in);
            int escolha = sc.nextInt() - 1;

            if (escolha == -1) {
                System.out.println("Uso de item cancelado.");
                return;
            }

            inventario.usarItem(escolha, this);
        } catch (Exception e) {
            System.out.println("Entrada inválida!");
        }
    }

    public void ganharXp(int quantidade) {
        xp += quantidade;
        System.out.println("\n+" + quantidade + " XP! (" + xp + "/" + xpParaProxNivel + ")");

        while (xp >= xpParaProxNivel) {
            subirNivel();
        }
    }

    public void subirNivel() {
        nivel++;
        xp -= xpParaProxNivel;
        xpParaProxNivel = (int)(xpParaProxNivel * 1.5);

        int aumento = 15 + (nivel * 2);
        hpMaximo += aumento;
        hp = hpMaximo;

        System.out.println("\n=================================");
        System.out.println("✨ " + nome + " subiu para o nível " + nivel + "!");
        System.out.println("HP Máximo: " + hpMaximo + " (+" + aumento + ")");
        System.out.println("Próximo nível em: " + xpParaProxNivel + " XP");
        System.out.println("=================================");
    }

    public int calcularDanoBase() {
        return 10 + (nivel * 2);
    }

    // ✅ Novo método para definir bônus de dano
    public void setDanoExtra(int dano) {
        this.danoExtra = dano;
    }

    // ✅ Novo cálculo de dano considerando o bônus
    public int calcularDano() {
        return calcularDanoBase() + danoExtra;
    }

    public void setDefesaExtra(int defesa) {
        this.defesaExtra = defesa;
    }

    public int getXp() {
        return xp;
    }

    public void verStatus() {
        System.out.println("\n=== STATUS ===");
        System.out.println("Nome: " + nome);
        System.out.println("Nível: " + nivel);
        System.out.println("HP: " + hp + "/" + hpMaximo);
        System.out.println("XP: " + xp + "/" + xpParaProxNivel);
        System.out.println("Defesa extra: " + defesaExtra);
        System.out.println("Itens no inventário:");
        inventario.listarItens();
    }

    public boolean estaVivo() {
        return hp > 0;
    }

    public String getNome() {
        return nome;
    }

    public Inventario getInventario() {
        return inventario;
    }

    // Removido o método abstrato antigo calcularDano()
    // Ele foi substituído por uma implementação concreta acima
}
