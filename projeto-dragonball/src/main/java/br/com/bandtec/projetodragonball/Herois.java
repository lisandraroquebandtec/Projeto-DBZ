package br.com.bandtec.projetodragonball;


public class Herois extends Personagens{

    private Double poderProtagonismo;

    public Herois(String nome, String raca, Double ki, Double poderProtagonismo) {
        super(nome, raca, ki);
        this.poderProtagonismo = poderProtagonismo;
    }

    @Override
    public Double valorDano() {
        return (getKi() * 0.10) + poderProtagonismo;
    }

    public Double getPoderProtagonismo() {
        return poderProtagonismo;
    }

    public void setPoderProtagonismo(Double poderProtagonismo) {
        this.poderProtagonismo = poderProtagonismo;
    }

    @Override
    public String toString() {
        return "Herois{" +
                "Poder do Protagonismo :" + poderProtagonismo +
                "Valor do dano :" +valorDano()+
                "} " + super.toString();
    }

}
