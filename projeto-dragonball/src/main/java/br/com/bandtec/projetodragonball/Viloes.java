package br.com.bandtec.projetodragonball;

public class Viloes extends Personagens{

    public Viloes(String nome, String raca, Double ki) {
        super(nome, raca, ki);
    }

    @Override
    public Double valorDano() {
        return getKi() * 0.10;
    }

}
