package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List<Word> dizionarioAlien ;
	List<WordEnhanced> dizionarioAlien2 ;
	
	
	public AlienDictionary() {
		dizionarioAlien= new ArrayList<Word>() ;
		dizionarioAlien2= new ArrayList<WordEnhanced>() ;
	}
	
	public void addWord(String alienWord, String translation) {
		Word w = new Word(alienWord, translation) ;
		this.dizionarioAlien.add(w) ;
	}
	public String translateWord(String alienWord) {
		 Word w = new Word(alienWord) ;
			if(dizionarioAlien.contains(w))
				return dizionarioAlien.get(dizionarioAlien.indexOf(w)).getTranslation() ;
		
		return null ;
	}
	
	public boolean cercaWord(Word w) {
		for(Word word: this.dizionarioAlien) {
			if(word.getAlienWord().equals(w.getAlienWord()))
				return true ;
		}
		return false ;
	}
	
	public void resetDictionary() {
		this.dizionarioAlien.clear();
	}

}
