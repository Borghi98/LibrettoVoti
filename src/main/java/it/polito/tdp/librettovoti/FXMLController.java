package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;

    @FXML
    private DatePicker datePEsame;
    //@FXML
    //private TextField txtData;

    @FXML
    private TextArea result;

    @FXML
    void handleInserisci(ActionEvent event) {
    	//leggi e controlla dati
    	String nomeEsame = txtEsame.getText();
    	if(nomeEsame.length()==0) {
    		result.setText("Errore: nome esame vuoto");
    		return;
    	}
    	
    	String votoEsame = txtVoto.getText();
    	int votoInt = 0;
    	try{
    	    votoInt = Integer.parseInt(votoEsame);
    	} catch (NumberFormatException ex) {
    		result.setText("ERRORE: il voto deve esser numerico");
    		return;
    	}
    	if (votoInt<18 || votoInt > 30) {
    		result.setText("ERRORE: il voto deve esser compreso tra 18 e 30");
    		return;
    	}
    	
    	
//    	String dataesame = txtData.getText();
//    	LocalDate data;
//    	try{
//    		data = LocalDate.parse(dataesame);
//    	}catch (DateTimeParseException ex) {
//    		result.setText("ERRORE: data in formato non corretto");
//    		return;
//    	}
    	
    	LocalDate data = datePEsame.getValue();
    	if(data == null) {
    		result.setText("ERRORE: inserire data");
		    return;	
    	}
    	//esegui azione
    	Voto voto = new Voto(nomeEsame,votoInt,data);
    	model.add(voto);
    	
    	//aggiorna i risultati
        result.setText(model.toString());
        txtEsame.clear();
        txtVoto.clear();
        //txtData.clear();
        datePEsame.setValue(null);
    }
    
    public void setModel(Libretto model) {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert datePEsame != null : "fx:id=\"datePEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        //assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

