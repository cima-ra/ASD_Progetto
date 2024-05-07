package cimara_asd;


import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private List<Nodo> vertici;
	
	public Grafo() {
		new ArrayList<Nodo>();
		vertici = new ArrayList<Nodo>();
	}
	
	//Restituire il nnumero di vertici presenti nel grafo
	public int numeroVertici() {
		return vertici.size();
	}
	
	//Restituire il numero di archi presenti nel grafo
	public int archiPresentiNelGrafo() {
		List<Nodo> verticiVisitati = new ArrayList<Nodo>();
		int totArchi = 0;
		
		for(Nodo i : vertici) {
			verticiVisitati.add(i);
			totArchi += countArchi(verticiVisitati, i);
		}
		
		return totArchi;
	}
	
	private int countArchi(List<Nodo> nodiVisitati, Nodo nodo) {
		int contaArchi = nodo.getArchiIncidenti();
		
		for(Nodo i : nodiVisitati) {
			if(i.isPresent(nodo))
				contaArchi -= 1;
		}
		
		return contaArchi;
	}
	
	
	//Restituire il numero di archi incidenti su un vertice specificato
	public int numeroArchiIncidenti(Nodo nodo) {
		return nodo.getArchiIncidenti();
	}
	
	//Stabilire se due vertici sono adiacenti o meno
	public boolean archiAdiacenti(Nodo a, Nodo b) {
		if(a.isPresent(b) && b.isPresent(a))
			return true;
		
		return false;
	}
	
	//Aggiungere un nuovo vertice v a G
	public void aggiungiVertice(Nodo nodo) {
		vertici.add(nodo);
	}
	
	//Aggiungere un nuovo arco tra due vertici x e y appartenenti a G
	public void addArco(Nodo x, Nodo y) {
		x.addArco(y);
		y.addArco(x);
	}
	
	//Rimuovere un vertice v da G e conseguentemente tutti gli archi su esso incidenti
	public void remouveVertice(Nodo nodo) {
		vertici.remove(nodo);

		for(Nodo i : nodo.listaArchi()) 
			i.remouveArco(nodo);
		
	}
	
	//Rimuovere un arco che già collega due vertici x e y di G
	public void deleteArco(Nodo x, Nodo y) {
		x.remouveArco(y);
		y.remouveArco(x);
	}
	
	/*Restituire una stringa che descriva quali sono gli archi incidenti su un certo nodo v,
	o che avverta l'utente che il nodo è stato rimosso dal grafo*/
	public String infoNodo(Nodo nodo) {
		return "Archi incidenti su " + nodo.getName() + ":" + nodo.listaArchiIncidenti();
	}
	
	//Metodo per la visita in ampiezza del Grafo
	public Albero visitaInAmpiezza(Nodo radice) {
		List<Nodo> visita = new ArrayList<>();
		List<Nodo> coda = new ArrayList<>();
		Nodo tmp;
		Albero bfs = new Albero("Tbfs");
		
		coda.add(radice);
		
		bfs.aggiungiRadice(radice.getName());
		
		while(!coda.isEmpty()){
			tmp = coda.remove(0);
			visita.add(tmp);
			bfs.aggiungiFigli(tmp, inserimentoInCodaListaAmpiezza(visita, coda, tmp));
			coda.addAll(inserimentoInCodaListaAmpiezza(visita, coda, tmp));
		}
		
		return bfs;
	}
	
	//Metoo per la gestione della cosa dei nodi della visita in ampiezza
	private List<Nodo> inserimentoInCodaListaAmpiezza(List<Nodo> visitati, List<Nodo> coda, Nodo nodo) {
		List<Nodo> tmp = new ArrayList<>();
		tmp.addAll(nodo.listaArchi());
		
		for(Nodo i: visitati) {
			if(tmp.contains(i))
				tmp.remove(i);
		}
		
		for(Nodo i : coda) {
			if(tmp.contains(i))
				tmp.remove(i);
		}
		
		return tmp;
	}
	
	//Metodo per la visita in profondità del grafo
	public Albero visitaInProfondità(Nodo radice){
		List<Nodo> visita = new ArrayList<>();
		List<List<Nodo>> coda = new ArrayList<List<Nodo>>();
		Nodo tmpPadre;
		Nodo tmpFiglio;
		Albero dfs = new Albero("Tdfs");
		
		inserimentoNodiInCoda(coda, radice, visita);
		
		dfs.aggiungiRadice(radice.getName());
		
		while(!coda.isEmpty()){
			tmpPadre = coda.get(coda.size() - 1).get(0);
			tmpFiglio = coda.remove(coda.size() - 1).get(1);
			
			if(!visita.contains(tmpPadre))
				visita.add(tmpPadre);
			
			if(!visita.contains(tmpFiglio))
				visita.add(tmpFiglio);
			
			dfs.aggiungiNodo(tmpPadre.getName(), tmpFiglio);
			inserimentoNodiInCoda(coda, tmpFiglio, visita);
		}
		
		return dfs;
	}
	
	/*	Siccome ho il padre nella prima posizione e il figlio nella seconda, e riuso lo stesso array
	 *  Qando finisco la visita azzerro la lista./ */
	private void inserimentoNodiInCoda(List<List<Nodo>> coda, Nodo padre, List<Nodo> visitati){
		for(Nodo i : padre.listaArchiDecrescente()) {
			List<Nodo> figli = new ArrayList<Nodo>();
			if(!visitati.contains(i)) {
				figli.add(padre);
				figli.add(i);
				coda.add(figli);
			}	
		}
		
		controlloDoppioniInCoda(coda);
	}
	
	/*	Questo metodo mi serve per pulire la coda,
	 * 	Siccome in alcuni un nodo viene scoperto all'inizio ma poi aggiunto come figlio alla fine
	 *	E in questo modo lo tolgo quando viene scoperto nuovamente.
	*/
	private void controlloDoppioniInCoda(List<List<Nodo>> coda) {
		for(int i = 0; i < coda.size(); i++) {
			for(int y = 0; y < coda.size(); y++) {
				if(coda.get(i).get(1).equals(coda.get(y).get(1)) && i != y)
					coda.remove(i);
			}
		}
	}
} 
