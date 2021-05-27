package fachada;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.util.ArrayList;

import modelo.Conta;
import modelo.ContaEspecial;
import modelo.Correntista;
import modelo.Lancamento;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();	//existe somente um repositorio

	public static ArrayList<Conta>	listarContas() {
		return repositorio.getContas();
	}
	public static ArrayList<Correntista> listarCorrentistas() {
		return repositorio.getCorrentistas();
	}
	public static ArrayList<Lancamento> listarLancamentos() {
		return repositorio.getLancamentos();
	}

	public static Conta criarConta(String numero, String cpf, String telefone, String email, String nome) throws Exception{
		Correntista corr = repositorio.localizarCorrentista(cpf);
		if(corr != null)
			throw new Exception("correntista ja existe:"+cpf);

		corr = new Correntista(cpf,telefone,email, nome);
		Conta c = new Conta(numero);

		c.setCorrentista(corr);		//relacionamento bidirecional
		corr.setConta(c);			//relacionamento bidirecional

		repositorio.adicionar(corr);  //adicionar o novo correntista no repositorio
		return c;
	}
	public static ContaEspecial criarConta(String numero, double limite, String cpf, String telefone, String email, String nome) throws Exception{
		Correntista corr = repositorio.localizarCorrentista(cpf);
		if(corr != null)
			throw new Exception("correntista ja existe:"+cpf);

		corr = new Correntista(cpf,telefone,email, nome);
		Conta c = new ContaEspecial(numero,limite);

		c.setCorrentista(corr);		//relacionamento bidirecional
		corr.setConta(c);			//relacionamento bidirecional

		repositorio.adicionar(corr);  //adicionar o novo correntista no repositorio
		return c;
	}
	public static void criarChave(String cpf, String tipochavePIKS) throws Exception {
		//localizar correntista pelo cpf
		Correntista corr = repositorio.localizarCorrentista(cpf);
		if(corr == null)
			throw new Exception("correntista inexistente");

		//obter a conta do correntista
		Conta conta = corr.getConta();
		//criar a chave PIKS desta conta
		chv = ??;
		conta.setChavePIKS(chv);
		//adicionar a conta ao  repositorio usando a chave PIKS
		repositorio.adicionar(conta);	
	}

	public static void creditar(String cpf, double quantia) throws Exception {
		/*
		 * localizar o correntista pelo cpf no repositorio
		 * acessar a conta deste correntista
		 * chamar o metodo creditar() desta conta
		 */
	}
	public static void transferir(String cpf, String chavePIKS, double quantia) throws Exception {
		Correntista correntista = repositorio.localizarCorrentista(cpf);
		if(correntista == null)
			throw new Exception("correntista inexistente");
		
		Conta contaorigem = correntista.getConta();
		Conta contadestino  = repositorio.localizarConta(chavePIKS);
		if(contadestino == null)
			throw new Exception("conta destino invalida");
		
		/*
		 * transferir a quantia da conta origem para a conta destino - metodo transferir() da classe Conta
		 * criar um lancamento para a conta origem da transferencia
		 * criar um lancamento para a conta destino da transferencia
		 * adicionar os dois lancamento no repositorio
		 */
	}
	public static void apagarConta(String cpf) throws Exception {
		Correntista correntista = repositorio.localizarCorrentista(cpf);
		if(correntista == null)
			throw new Exception("correntista inexistente");
		
		Conta conta = correntista.getConta();
		if(conta.getSaldo()==0) {
			/*
			 * remover a conta do repositorio (caso ela tenha chavePIKS)
			 * remover cada lancamento dela do repositorio (caso ela tenha lancamentos)
			 * remover o correntista dela do repositorio
			 */
		}
	}
	public static Conta obterContaTop() {
		/*
		 * consultar as contas do repositorio para descobrir a conta top
		 * considerando que vai ter somente uma
		 */
		return ???
	}
	public static Conta obterConta(String cpf) {
		/*
		 * localizar o correntista no repositorio pelo cpf e retornar a conta deste correntista
		 */
		return ???
	}


}
