/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

package modelo;

public class Conta {	
	 	private String numero;
	    private double saldo;
	    private String chavePiks;
	    private String tipoChavePiks;
	    private ArrayList<Lancamento> lancamentos;
	    private final Correntista correntista;

	    public Conta(String numero, double saldo, String chavePiks, String tipoChavePiks, Correntista correntista) {
	        this.numero = numero;
	        this.saldo = saldo;
	        this.chavePiks = chavePiks;
	        this.tipoChavePiks = tipoChavePiks;
	        this.lancamentos = new ArrayList<>();
	        this.correntista = correntista;
	    }
	    
	    public String getNumero() {
	        return numero;
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public void setSaldo(double saldo) {
	        this.saldo = saldo;
	    }

	    public String getChavePiks() {
	        return chavePiks;
	    }

	    public void setChavePiks(String chavePiks) {
	        this.chavePiks = chavePiks;
	    }

	    public String getTipoChavePiks() {
	        return tipoChavePiks;
	    }

	    public void setTipoChavePiks(String tipoChavePiks) {
	        this.tipoChavePiks = tipoChavePiks;
	    }

	    
	    public ArrayList<Lancamento> getLancamentos() {
	        return lancamentos;
	    }

	    public Correntista getCorrentista() {
	        return correntista;
	    }

	
	    public void creditar(double dinheiro) {
			this.saldo += dinheiro;
		} 
	    
	    
	    public void debitar(double dinheiro) throws Exception {
			if ((getSaldo() - dinheiro) < 0) {
				throw new Exception("Saldo insuficiente para esse saque.");
			}
			this.saldo -= dinheiro;
		}
		public void transferir(double dinheiro, Conta destino) throws Exception {
			this.debitar(dinheiro);
			destino.creditar(dinheiro);
		}
		public void adicionarLancamento(Lancamento lancamento) {
			this.lancamentos.add(lancamento);
		}
		
		@Override
		public String toString() {
			return "Numero da conta=" + numero + 
					" Saldo= " + saldo + 
					" ChavePiks= " + chavePiks + 
					" TipoChavePiks= " + tipoChavePiks;
		}
	
	}
