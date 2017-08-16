package br.com.example.rest.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.example.model.Uf;


public class UfRestService {

	private int HTTP_COD_SUCESSO = 200;
	private HttpURLConnection con;
	private URL url;
	private String URL_WS = "http://ibge.herokuapp.com/estado/UF";

	
	
	public  HttpURLConnection conectaWS() throws Exception{
		url = null;
		con = null;
		try {
			url = new URL(URL_WS);
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
	
	public List<Uf> listarUfs() throws Exception{
		
		conectaWS();
		
		Gson gson = new Gson();
		Uf uf = null;
		List<Uf> ufList = new ArrayList<Uf>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

		//recebe a string com os valores Json
		String line = br.readLine();
		
		Map<String, String> retMap = new Gson().fromJson(line, new TypeToken<HashMap<String, String>>() {}.getType());
		
		for (String sigla_key : retMap.keySet()) {
			String codigo_value = retMap.get(sigla_key);
            uf = new Uf();
            uf.setCodigo(codigo_value);
            uf.setSigla(sigla_key);
            
            //Adiciona a uf a um list
            ufList.add(uf);
		}
		
		Collections.sort(ufList, new Comparator<Uf>() {

			@Override
			public int compare(Uf uf1, Uf uf2) {
				// TODO Auto-generated method stub
				return uf1.getSigla().compareTo(uf2.getSigla());
			}
		
		});
		
		return ufList;

	}

}
