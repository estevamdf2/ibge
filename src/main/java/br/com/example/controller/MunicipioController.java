package br.com.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.example.model.Municipio;
import br.com.example.model.Uf;
import br.com.example.rest.service.MunicipioRestService;
import br.com.example.rest.service.UfRestService;

@ManagedBean
public class MunicipioController implements Serializable {

	
	private static final long serialVersionUID = -6294383961526274574L;
	
	@Inject
	private UfRestService ufRestService;
	
	@Inject
	private MunicipioRestService municipioRestService;
	
	private Uf uf;
	
	@Inject
	private Municipio municipio; 
	
	private List<Uf> ufList;
	private List<Municipio> municipioList;
	private String nome = "Ola JSF";
	

	@PostConstruct
	private void init() throws Exception{
		
		if(uf == null){
			uf = new Uf();
		}
		ufList = new ArrayList<Uf>();
		municipioList = new ArrayList<Municipio>();
		System.out.println("Uf "+uf.getSigla());
	}

	public List<Uf> listarUfs() throws Exception {
		return	ufList = ufRestService.listarUfs();
	}
	
	public List<Municipio> listarMunicipios(String uf) throws Exception {
		return	municipioList = municipioRestService.listarMunicipios(uf);
	}
	
	public List<Uf> getUfList() {
		return ufList;
	}

	public void setUfList(List<Uf> ufList) {
		this.ufList = ufList;
	}

	public List<Municipio> getMunicipioList() {
		return municipioList;
	}

	public void setMunicipioList(List<Municipio> municipioList) {
		this.municipioList = municipioList;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Uf getUf() {
		return uf;
	}



	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
}
