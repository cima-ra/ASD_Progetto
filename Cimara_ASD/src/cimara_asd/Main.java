package cimara_asd;

public class Main {
	
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		Nodo a = new Nodo("a");
		Nodo b = new Nodo("b");
		Nodo c = new Nodo("c");
		Nodo d = new Nodo("d");
		Nodo e = new Nodo("e");
		Nodo f = new Nodo("f");
		Nodo g = new Nodo("g");
		
		a.addArco(b);
		a.addArco(e);
		
		b.addArco(f);
		b.addArco(a);
		b.addArco(g);
		
		c.addArco(d);
		c.addArco(g);
		
		d.addArco(c);
		d.addArco(e);
		d.addArco(f);
		
		e.addArco(a);
		e.addArco(d);
		
		f.addArco(b);
		f.addArco(d);
		
		g.addArco(b);
		g.addArco(c);
		
		grafo.aggiungiVertice(a);
		grafo.aggiungiVertice(b);
		grafo.aggiungiVertice(c);
		grafo.aggiungiVertice(d);
		grafo.aggiungiVertice(e);
		grafo.aggiungiVertice(f);
		grafo.aggiungiVertice(g);
		
		System.out.println("Numero archi: " + grafo.archiPresentiNelGrafo());
		
		System.out.println("Numero vertici: " + grafo.numeroVertici());
		
		/*List<Nodo> visita = new ArrayList<Nodo>();
		visita = grafo.visitaInAmpiezza(a);
		
		for(Nodo i : visita) {
			System.out.println(i.getName());
		}
		
		System.out.println();
		
		visita.clear();
		visita = grafo.visitaInProfondità(a);
		
		for(Nodo i : visita) {
			System.out.println(i.getName());
		}
		
		System.out.println();
		
		visita.clear();
		visita = grafo.visitaInAmpiezza(a);
		
		for(Nodo i : visita) {
			System.out.println(i.getName());
		}	*/
		
		Albero bfs = new Albero("");
		bfs = grafo.visitaInProfondità(a);

		System.out.println();
		
		System.out.println(bfs.infoNodo("a"));

		System.out.println();
		
		System.out.println(bfs.infoNodo("b"));

		System.out.println();
		
		System.out.println(bfs.infoNodo("c"));

		System.out.println();
		
		System.out.println(bfs.infoNodo("d"));

		System.out.println();
		
		System.out.println(bfs.infoNodo("e"));

		System.out.println();
		
		System.out.println(bfs.infoNodo("f"));

		System.out.println();
		
		System.out.println(bfs.infoNodo("g"));
	}
	
	
}
