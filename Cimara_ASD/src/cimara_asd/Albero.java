package cimara_asd;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Albero {
	
	private String nomeAlbero;
	private String radice;
	private List<NodoAlbero> nodiAlbero;
	
	public Albero(String nome) {
		nomeAlbero = nome;
		nodiAlbero = new ArrayList<>();
	}
	
	public void aggiungiRadice(String nome) {
		radice = nome;
	}
	
	public void aggiungiNodo(String nodo, Nodo figlioNodo) {
		NodoAlbero figlio = nodoPresente(figlioNodo.getName());
		NodoAlbero tmp = nodoPresente(nodo);		
		
		tmp.aggiungiFiglio(figlio);
		figlio.setPadre(tmp);
		nodiAlbero.add(tmp);
	}
	
	public NodoAlbero nodoPresente(String nomeNodo) {
		for(NodoAlbero i : nodiAlbero) {
			if(i.nomeNodo().equals(nomeNodo))
				return i;
		}
		
		return (new NodoAlbero(nomeNodo));
	}
	
	
	public void aggiungiFigli(Nodo nodo, List<Nodo> listaFigli) {		
		if(!listaFigli.isEmpty()) {
			for(Nodo i : listaFigli) {
				aggiungiNodo(nodo.getName(), i);
			}
		}
	}
	
	//Metodo per capire se un nodo è già presente
	private NodoAlbero nodoPresente(Nodo nodo) {
		for(NodoAlbero i : nodiAlbero) {
			if(i.nomeNodo().equals(nodo.getName()))
					return i;
		}
		
		return null;
	}
	
	public int numeroNodi() {
		return nodiAlbero.size();
	}
	
	public String infoNodo(String nome) {
		for(NodoAlbero i : nodiAlbero) {
			if(i.nomeNodo().equals(nome)) {
				return i.infoNodo();
			}
		}
		
		return "Il nodo inseriton " + nome + " non ha figli.";
	}
}
