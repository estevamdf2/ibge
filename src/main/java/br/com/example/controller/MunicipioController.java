package br.com.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.example.model.Municipio;
import br.com.example.model.Uf;
import br.com.example.rest.service.MunicipioRestService;
import br.com.example.rest.service.UfRestService;

@RequestScoped
@ManagedBean
public class MunicipioController implements Serializable {

	
	private static final long serialVersionUID = -6294383961526274574L;
	
	@Inject
	private UfRestService ufRestService;
	
	@Inject
	private MunicipioRestService municipioRestService;
	
	@Inject
	private Uf uf; 
		
	private List<Uf> ufList;
	private List<Municipio> municipioList;
	private String nome = "Teste string";
	

	@PostConstruct
	private void init(){
		ufList = new ArrayList<Uf>();
		municipioList = new ArrayList<Municipio>();
	}

	public void listarUfs() throws Exception {
		ufList = ufRestService.listarUfs();
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
}
