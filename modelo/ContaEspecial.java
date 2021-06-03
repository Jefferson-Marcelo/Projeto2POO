/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

package modelo;

public class ContaEspecial extends Conta{
	private double limite;

    public ContaEspecial(String numero, double saldo, String chavePiks, String tipoChavePiks, Correntista correntista, double limite) {
        super(numero, saldo, chavePiks, tipoChavePiks, correntista);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    @Override
	public void debitar(double dinheiro) throws Exception {
		if ((getSaldo() - dinheiro) < limite) {	
			throw new Exception("Valor acima do seu limite especial.");
		}
		setSaldo(getSaldo()-dinheiro);
	}
    @Override
	public String toString() {
		return "Numero da conta=" + getNumero() + 
				" Saldo= " + getSaldo() + 
				" ChavePiks= " + getChavePiks + 
				" TipoChavePiks= " + getTipoChavePiks() + 
				" Limite=" + limite;
	}
	
	
	//atributo limite
	
	/*
	 * sobrescrita de debitar()
	 */

	
}
