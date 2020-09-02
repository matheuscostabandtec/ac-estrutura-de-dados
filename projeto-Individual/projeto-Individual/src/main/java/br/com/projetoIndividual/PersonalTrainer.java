package br.com.projetoIndividual;

public class PersonalTrainer implements ItensVenda {

    private String nomePersonal;
    private String modalidadePersonal;
    private Double valorHora;
    private Integer qtdHoras;

    public PersonalTrainer(String nomePersonal, String modalidadePersonal, Double valorHora, Integer qtdHoras) {
        this.nomePersonal = nomePersonal;
        this.modalidadePersonal = modalidadePersonal;
        this.valorHora = valorHora;
        this.qtdHoras = qtdHoras;
    }

    @Override
    public Double getValorCompra() {
        return (valorHora * qtdHoras);
    }

    public String getNomePersonal() {
        return nomePersonal;
    }

    public String getModalidadePersonal() {
        return modalidadePersonal;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public Integer getQtdHoras() {
        return qtdHoras;
    }

    @Override
    public String toString() {
        return "\n PersonalTrainer: " +
                "\n Nome do personal: " + nomePersonal +
                "\n Modalidade do personal: " + modalidadePersonal +
                "\n Valor/Hora: " + valorHora +
                "\n Qtd de Horas: " + qtdHoras +
                "\n Valor total: " + String.format("R$ %.2f", getValorCompra());
    }
}
