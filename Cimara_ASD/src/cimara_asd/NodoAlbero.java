package cimara_asd;

import java.util.ArrayList;
import java.util.List;

public class NodoAlbero{
	
	 private String nome;
	 private NodoAlbero padre;
	 private List<NodoAlbero> figli;
	 
	 public NodoAlbero(String info) {
		 this.nome = info;
		 figli = new ArrayList<>();
	 }
	 
	 public void setPadre(NodoAlbero padre) {
		 this.padre = padre;
	 }
	 
	 public void aggiungiFiglio(NodoAlbero figlio) {
		 figli.add(figlio);
	 }
	 
	 public NodoAlbero getPadre() {
		 return padre;
	 }
	 
	 public String nomeNodo() {
		 return this.nome;
	 }
	 
	 public List<NodoAlbero> getFigli(){
		 return figli;
	 }
	 
	 public String infoNodo() {
		 String infoNodo = " I figli del nodo " + this.nomeNodo() + " sono: ";
		 
		 for(NodoAlbero i : figli) {
			 infoNodo += " " + i.nomeNodo();
		 }
		 
		 return infoNodo;
	 }
	
}
