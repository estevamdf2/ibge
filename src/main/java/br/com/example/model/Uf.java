package br.com.example.model;

public class Uf{


	private String sigla;
	private String codigo;


	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
/*	@Override
	public int compareTo(Uf uf2) {

		if(Integer.parseInt(this.codigo) < Integer.parseInt(uf2.getCodigo())) {
			return -1;
		}
		
		if(Integer.parseInt(this.codigo) > Integer.parseInt(uf2.getCodigo())) {
			return 1;
		}
		return 0;
	} */
}
