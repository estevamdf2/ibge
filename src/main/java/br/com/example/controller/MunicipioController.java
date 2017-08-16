package br.com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Inject;

import br.com.example.model.Municipio;
import br.com.example.model.Uf;
import br.com.example.rest.service.MunicipioRestService;
import br.com.example.rest.service.UfRestService;

@ManagedBean
public class MunicipioController {


	@Inject
	private UfRestService ufRestService;

	@Inject
	private MunicipioRestService municipioRestService;

	private String siglaUF;
	private String nomeMunicipio; 

	private List<Uf> ufList;
	private List<Municipio> municipioList;
	private List<SelectItem> ufItens;
	private List<SelectItem> municipioItens;



	@PostConstruct
	private void init() throws Exception{

		siglaUF = new String();
		listarUfs();
	}

	public List<SelectItem> listarUfs() throws Exception {

		ufList = ufRestService.listarUfs();
		for (Uf ufAux : ufList) {
			SelectItemGroup selectItem = new SelectItemGroup();
			selectItem.setSelectItems(new SelectItem[] {new SelectItem(ufAux.getSigla(),ufAux.getSigla())});

			if(ufItens == null) {
				ufItens = new ArrayList<SelectItem>();
			}

			ufItens.add(selectItem);
		}

		return ufItens;
	}

	public List<SelectItem> listarMunicipios() throws Exception {
		
		municipioList = municipioRestService.listarMunicipios(siglaUF);
		for (Municipio municipioAux : municipioList) {
			
			if(municipioItens == null) {
				municipioItens = new ArrayList<SelectItem>();
			}
			
			SelectItemGroup selectMunicipio = new SelectItemGroup();
			selectMunicipio.setSelectItems(new SelectItem[] {new SelectItem(municipioAux.getNome(), municipioAux.getNome())});
			
			municipioItens.add(selectMunicipio);
		}
		
		return	municipioItens;
	}

	public UfRestService getUfRestService() {
		return ufRestService;
	}

	public void setUfRestService(UfRestService ufRestService) {
		this.ufRestService = ufRestService;
	}

	public MunicipioRestService getMunicipioRestService() {
		return municipioRestService;
	}

	public void setMunicipioRestService(MunicipioRestService municipioRestService) {
		this.municipioRestService = municipioRestService;
	}

	public String getSiglaUF() {
		return siglaUF;
	}

	public void setSiglaUF(String siglaUF) {
		this.siglaUF = siglaUF;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	public List<Uf> getUfList() {
		return ufList;
	}

	public void setUfList(List<Uf> ufList) {
		this.ufList = ufList;
	}

	public List<SelectItem> getUfItens() {
		return ufItens;
	}

	public void setUfItens(List<SelectItem> ufItens) {
		this.ufItens = ufItens;
	}

	public List<Municipio> getMunicipioList() {
		return municipioList;
	}

	public void setMunicipioList(List<Municipio> municipioList) {
		this.municipioList = municipioList;
	}

	public List<SelectItem> getMunicipioItens() {
		return municipioItens;
	}

	public void setMunicipioItens(List<SelectItem> municipioItens) {
		this.municipioItens = municipioItens;
	}
	
	
}
