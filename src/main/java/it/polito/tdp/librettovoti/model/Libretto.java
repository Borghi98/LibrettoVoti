package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libretto {
	
	private List<Voto> voti;
	private Map<String,Voto> votiMap; 
	
	public Libretto() {
		this.voti = new ArrayList<>();
		this.votiMap = new HashMap<>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
		this.votiMap.put(v.getNome(), v);
	}
	
	public List<Voto> listaVotiUguali(int punteggio) {
		List<Voto> risultato = new ArrayList<>();
		for(Voto v: this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		return risultato; 
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato = new Libretto();
		for(Voto v: this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
	}
	/**
	 * Ricerca un Voto del corso specificando il nome 
	 * se non trovato null
	 * @param nomeCorso
	 * @return
	 */
	public Voto cercaCorso(String nomeCorso) {
//		Voto risultato = null;
//		for(Voto v: this.voti) {
//			if(v.getNome().equals(nomeCorso)) {
//				risultato = v;
//				break;
//			}
//		}
		return this.votiMap.get(nomeCorso) ;
	}
	/**
	 * Verifica se nel libretto esiste gia un voto con lo stesso nome e valutazione 
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
//		boolean trovato = false;
//		for (Voto voto : this.voti) {
//			if(voto.getNome().equals(v.getNome()) && voto.getVoto()==v.getVoto())
//				trovato = true;
//			break;
//		}
//		return trovato;
		Voto trovato = this.votiMap.get(v.getNome());
		if (trovato == null)
			return false;
		if (trovato.getVoto()==v.getVoto())
			return true;
		else 
			return false;
	}
	
    /**
     *  verifica se nel libretto esiste gia un voto con stesso nome ma valutazione diversa 
     * @param v
     * @return
     */
	public boolean esisteConflitto(Voto v) {
//		boolean trovato = false;
//		for (Voto voto : this.voti) {
//			if(voto.getNome().equals(v.getNome()) && voto.getVoto()!=v.getVoto())
//				trovato = true;
//			break;
//		}
//		return trovato;
		Voto trovato = this.votiMap.get(v.getNome());
		if (trovato == null)
			return false;
		if (trovato.getVoto()!=v.getVoto())
			return true;
		else 
			return false;
	}
	
    
	public String toString() {
		String s = "";
		for(Voto v: this.voti) {
			s = s + v.toString() + "\n";
		}
		return s;
	}
}
