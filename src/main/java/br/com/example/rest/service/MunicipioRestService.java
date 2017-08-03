package br.com.example.rest.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.example.model.Municipio;


public class MunicipioRestService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2527372044750891155L;
	private  int HTTP_COD_SUCESSO = 200;
	private  HttpURLConnection con;
	private  URL url;
	private  String URL_WS = "http://ibge.herokuapp.com/municipio/?val=";

	
	public  HttpURLConnection conectaWS(String uf) throws Exception{
		url = null;
		con = null;
		try {
			url = new URL(URL_WS.concat(uf));
			con = (HttpURLConnection) url.openConnection();

			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
				throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}

		} catch (MalformedURLException e) { //Exception para URL
			e.printStackTrace();

		} catch (IOException e) { // Exception para connection
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return con;

	}
	
	public  List<Municipio> listarMunicipios(String uf) throws Exception{
		
		conectaWS(uf);
		
		Gson gson = new Gson();
		Municipio municipio = null;
		List<Municipio> cidadesList = new ArrayList<Municipio>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

		//recebe a string com os valores Json
		String line = br.readLine();
		
		Map<String, String> retMap = new Gson().fromJson(line, new TypeToken<HashMap<String, String>>() {}.getType());
		
		for (String nome_key : retMap.keySet()) {
			String codigo_value = retMap.get(nome_key);
            municipio = new Municipio();
            municipio.setCodigo(codigo_value);
            municipio.setNome(nome_key);
            
            //Adiciona a uf a um list
            cidadesList.add(municipio);
		}
		
		return cidadesList;

	}

}
