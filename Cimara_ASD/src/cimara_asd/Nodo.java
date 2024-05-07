package cimara_asd;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	private String nome;
	private List<Nodo> archiIncidenti;
	
	public Nodo() {
		archiIncidenti = new ArrayList<>();

	}
	
	public Nodo(String name) {
		this.nome = name;
		archiIncidenti = new ArrayList<>();
	}
	
	public String getName() {
		return this.nome;
	}
	
	public int getArchiIncidenti() {
		return archiIncidenti.size();
	}
	
	public void addArco(Nodo nodo) {
		archiIncidenti.add(nodo);
	}
	
	public boolean isPresent(Nodo nodo) {
		return archiIncidenti.contains(nodo);
	}
	
	public void remouveArco(Nodo nodo) {
		archiIncidenti.remove(nodo);
	}
	
	public String listaArchiIncidenti() {
		String listaArchi = "";
		
		for(Nodo i : archiIncidenti)
			listaArchi += " " + i.getName() + ",";
		
		return listaArchi;
	}
	
	/*	Qui sotto ci sono due metodi che restituiscono la lista degli archi di un nodo.
	 * 	Sono due metodi diversi per le due visite diverse, Ampiezza e Profondità.
	 * 	Siccome la prima necessita dell'ordine alfabetico, ma la seconda dell'ordine decrescente.
	 * 
	*/
	
	public List<Nodo> listaArchi(){
		archiIncidenti.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		return archiIncidenti;
	}
	
	public List<Nodo> listaArchiDecrescente(){
		archiIncidenti.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
		return archiIncidenti;
	}
	
	public boolean isUguale(Nodo b) {
		return this.nome.equals(b.getName());
	}
}
