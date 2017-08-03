package br.com.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.example.model.Municipio;
import br.com.example.model.Uf;
import br.com.example.rest.service.MunicipioRestService;
import br.com.example.rest.service.UfRestService;

@Named
@ViewScoped
public class MunicipioController implements Serializable {

	
	private static final long serialVersionUID = -6294383961526274574L;
	
	@Inject
	private UfRestService ufRestService;
	
	@Inject
	private MunicipioRestService municipioRestService;
	
		
	private List<Uf> ufList;
	private List<Municipio> municipioList;

	@PostConstruct
	private void init(){
		ufList = new ArrayList<Uf>();
		municipioList = new ArrayList<Municipio>();
	}

	
	
	public List<Uf> getUfList() {
		return ufList;
	}

	public void setUfList(List<Uf> ufList) {
		Uf uf = new Uf();
		uf.setCodigo("10");
		uf.setSigla("BR");
		ufList.add(uf);
		this.ufList = ufList;
	}

	public List<Municipio> getMunicipioList() {
		return municipioList;
	}

	public void setMunicipioList(List<Municipio> municipioList) {
		this.municipioList = municipioList;
	}
}
