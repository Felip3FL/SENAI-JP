package br.exemplo.exceptionMensagem;

public class SenhaTeste {

	static void autenticar(String senha) throws SenhaInvalidaException{
		if("122".equals(senha)){
			//Autenticado
			System.out.println("Autenticado");
		}else{
			//Senha errada!
			throw new SenhaInvalidaException("Senha Incorreta");
		}
	}

	public static void main(String[] args) {

		try{
			
			autenticar("123");
			
		}catch(SenhaInvalidaException erroSenha1){
			erroSenha1.printStackTrace();
			System.out.println(erroSenha1.getMessage());
		}

	}

}
