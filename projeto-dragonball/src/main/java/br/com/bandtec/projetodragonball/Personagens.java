package br.com.bandtec.projetodragonball;

public abstract class Personagens {

    private String nome;
    private String raca;
    private Double ki;

    public Personagens(String nome, String raca, Double ki) {
        this.nome = nome;
        this.raca = raca;
        this.ki = ki;
    }

    public abstract Double valorDano();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Double getKi() {
        return ki;
    }

    public void setKi(Double ki) {
        this.ki = ki;
    }

    @Override
    public String toString() {
        return "Personagens{" +
                "Nome :" + nome + '\'' +
                ",Raça :" + raca + '\'' +
                ",Ki :" + ki +
                '}';
    }
}
