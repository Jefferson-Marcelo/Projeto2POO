package modelo;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

public class Lancamento {
	private LocalDateTime dataHora;
    private double valor;
    private String numeroConta;

    public Lancamento(LocalDateTime dataHora, double valor, String numeroConta) {
        this.dataHora = dataHora;
        this.valor = valor;
        this.numeroConta = numeroConta;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
    
    @Override
	public String toString() {
		return "Lancamento dataHora= " + dataHora + 
				" Valor= " + valor + 
				" numero= " + numero +;
	}
	
}
