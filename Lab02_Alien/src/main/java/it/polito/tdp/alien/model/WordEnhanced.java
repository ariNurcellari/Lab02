package it.polito.tdp.alien.model;
import java.util.LinkedList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord;
	private String translation;
	private List<String> translations = new LinkedList<String>() ;
	
	public WordEnhanced(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation ;
		this.translations.add(translation) ;
	}
	
	public void aggiungiTraduzione(String traduzione) {
		translations.add(traduzione) ;
	}
	
	public WordEnhanced(String alienWord) {
		super();
		this.alienWord = alienWord;
	}
	
	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public List<String> getTranslations() {
		return translations;
	}
	
	public boolean cercaTraduzione(String traduzione) {
		for(String string : this.translations) {
			if(string.equals(traduzione))
				return true ;
		}
		return false ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
}
