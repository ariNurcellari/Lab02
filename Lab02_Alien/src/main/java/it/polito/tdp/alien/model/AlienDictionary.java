package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List<WordEnhanced> dizionarioAlien ;
	
	public AlienDictionary() {
		dizionarioAlien= new ArrayList<WordEnhanced>() ;
	}
	
	public void addWord(String alienWord, String translation) {
		 WordEnhanced w = new WordEnhanced(alienWord) ;
			if(dizionarioAlien.contains(w)) {
				dizionarioAlien.get(dizionarioAlien.indexOf(w)).aggiungiTraduzione(translation);
			}
			else {
		 w = new WordEnhanced(alienWord, translation) ;
		this.dizionarioAlien.add(w) ;
			}
	}
	public List<String> translateWord(String alienWord) {
		 WordEnhanced w = new WordEnhanced(alienWord) ;
			if(dizionarioAlien.contains(w))
				return dizionarioAlien.get(dizionarioAlien.indexOf(w)).getTranslations() ;
		return null ;
	}
	
	public void resetDictionary() {
		this.dizionarioAlien.clear();
	}
}
