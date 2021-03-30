package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.alien.model.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private AlienDictionary aD = new AlienDictionary() ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    void doReset(ActionEvent event) {
    	aD.resetDictionary();
    	txtResult.clear();
    	txtWord.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String testo = txtWord.getText().toLowerCase();
    	if(testo == null || testo.length() == 0) {
     		txtResult.setText("Inserire una o due parole!");
     		return ;
    	}
    	txtWord.clear();
    	StringTokenizer st = new StringTokenizer(testo, " ") ;
    	
    	if(!st.hasMoreElements()) {
    		txtResult.setText("Inserire una o due parole!");
    		return ;
    		}
    	String word = st.nextToken() ;	
    	
    	if(st.hasMoreTokens()) {
    		String traduzione = st.nextToken() ;
    		if(!word.matches("[a-zA-Z]*") || !traduzione.matches("[a-zA-Z]*")) {
        		txtResult.setText("Inserire caratteri del tipo a-zA-Z");
        		return ;
        	}
    		
    		aD.addWord(word, traduzione);
    		txtResult.setText("Nuova parola: "+ word+" inserita nel dizionario, con traduzione: "+traduzione);
    		// TODO: CONTROLLO SUI CARATTERI AMMESSI
    	} else {
    		if(!word.matches("[a-zA-Z]*")){
        		txtResult.setText("Inserire caratteri del tipo a-zA-Z");
        		return ;
    		}
        	if(aD.translateWord(word) == null)	
        		txtResult.setText("La parola aliena: "+ word.toUpperCase()+ " non è presente nel AlineDictionary");
    		// TODO: CONTROLLO SUI CARATTERI AMMESSI
    		else 
				txtResult.setText("La traduzione della parola: " +word.toUpperCase()+ " è: " + aD.translateWord(word).toUpperCase()) ;
    	}
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}