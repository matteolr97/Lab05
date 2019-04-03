package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.db.ParolaDAO;

public class Model {


	ParolaDAO pao = new ParolaDAO();
	//List<String> anagrammiTrovati = new LinkedList<String>();
	
	public Set<String> calcolaAnagrammi(String word){
		Set<String> anagrammiTrovati = new HashSet<String>();
		String parola = "";
		cercaAnagramma(word,0,parola,anagrammiTrovati);
		return anagrammiTrovati;
	}

	private void cercaAnagramma(String word, int level, String parola, Set<String> anagrammiTrovati) {
		
		
		//condizione uscita
		if(level == word.length()) {
			anagrammiTrovati.add(parola);
		return ;}
		
		for(int i = 0; i<word.length(); i++) {

			if(this.countsChar(parola,word.charAt(i))<this.countsChar(word,word.charAt(i))) {
				
			parola += word.charAt(i);
			this.cercaAnagramma(word, level+1, parola, anagrammiTrovati);
			parola = parola.substring(0,parola.length()-1);
		}
			}
		
		
	}
	private int countsChar(String parola2, char charAt) {

		int count = 0;
		for( int i = 0; i<parola2.length();i++) {
			if(parola2.charAt(i)== charAt)
				count++;
		}
		return count;
	}

	public List<String> anagrammiCorretti(String word){
		List<String> anagrammiCorretti = new LinkedList<String>();

		for(String s: this.calcolaAnagrammi(word)) {
			if(pao.esisteParola(s))
				anagrammiCorretti.add(s);
		}
		return anagrammiCorretti;
		
	}
	
	public List<String> anagrammiErrati(String word){
		List<String> anagrammiErrati = new LinkedList<String>();

		for(String s: this.calcolaAnagrammi(word)) {
			if(!pao.esisteParola(s))
				anagrammiErrati.add(s);
		}
		return anagrammiErrati;
		
	}
	
}
