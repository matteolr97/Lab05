package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserimento;

    @FXML
    private Button btnCalcolo;

    @FXML
    private TextArea txtResultCorrect;

    @FXML
    private TextArea txtBadResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolo(ActionEvent event) {

    	String word = txtInserimento.getText();
    	
    	String corrette;
    	corrette = model.anagrammiCorretti(word).toString();
    	txtResultCorrect.appendText(corrette);
    	
    	String errate;
    	errate = model.anagrammiErrati(word).toString();
    	txtBadResult.appendText(errate);

    }

    @FXML
    void doReset(ActionEvent event) {

    	txtBadResult.clear();
    	txtInserimento.clear();
    	txtResultCorrect.clear();
    }

    @FXML
    void initialize() {
        assert txtInserimento != null : "fx:id=\"txtInserimento\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcolo != null : "fx:id=\"btnCalcolo\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultCorrect != null : "fx:id=\"txtResultCorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtBadResult != null : "fx:id=\"txtBadResult\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
}
