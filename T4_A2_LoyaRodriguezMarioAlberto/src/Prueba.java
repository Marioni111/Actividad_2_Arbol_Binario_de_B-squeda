class NodoArbol{
	
	private NodoArbol nodoIzq;
	private int dato;
	private NodoArbol nodoDer;
	
	public NodoArbol(int dato) {
		this.dato = dato;
	}

	public NodoArbol getNodoIzq() {
		return nodoIzq;
	}

	public void setNodoIzq(NodoArbol nodoIzq) {
		this.nodoIzq = nodoIzq;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public NodoArbol getNodoDer() {
		return nodoDer;
	}

	public void setNodoDer(NodoArbol nodoDer) {
		this.nodoDer = nodoDer;
	}
}
class ArbolBinario{
	
	NodoArbol nodoRaiz;
	
	public ArbolBinario() {
		crearArbol();
	}
	
	public void crearArbol() {
		nodoRaiz = null;
	}
	public void insertarNodo(int dato) {
		
		NodoArbol nuevoNodo = new NodoArbol(dato);
		NodoArbol aux = null;
		NodoArbol padre = null;
		
		if(nodoRaiz == null) {
			nodoRaiz = nuevoNodo;
		}else {
			
			aux = nodoRaiz;
			
			while(aux == null) {
				
				padre = aux;
				
				if(dato <= aux.getDato()) {
				
					//aux se mueve a la izquierda
					aux = aux.getNodoIzq();
					
					if(aux == null) {
						padre.setNodoIzq(nuevoNodo);
					}
					
				}else {
					//aux se mueve a la derecha
					
					aux = aux.getNodoDer();
					
					if(aux == null) {
						padre.setNodoDer(nuevoNodo);
					}
				}
			}
		}
	}
	public void recorridoInOrder(NodoArbol raiz) {
		if(raiz != null) {
			System.out.print(raiz.getDato() + "-->");
			recorridoInOrder(raiz.getNodoIzq());
			recorridoInOrder(raiz.getNodoDer());
		}
	}
	public boolean eliminarNodo(int dato) {
		NodoArbol aux = nodoRaiz;
		NodoArbol padre = nodoRaiz;
		boolean subArbolIzq = true;
		
		while(aux.getDato()!=dato) {
			subArbolIzq = true;
			aux = aux.getNodoDer();
		}
		if(aux == null) {
			return false;
		}
		
		if(aux.getNodoIzq()==null&&aux.getNodoDer()==null) {
			if(aux == nodoRaiz) {
				nodoRaiz = null;
			}
			else if(subArbolIzq) {
				padre.setNodoIzq(null);
			}
			else {
				padre.setNodoDer(null);
			}
		}
	}
}
public class Prueba {

	public static void main(String[] args) {
		
		ArbolBinario ab = new ArbolBinario();
		
		ab.insertarNodo(7);
		ab.insertarNodo(3);
		ab.insertarNodo(8);
		ab.insertarNodo(2);
		ab.insertarNodo(15);
		ab.insertarNodo(1);
		ab.insertarNodo(3);
		ab.insertarNodo(10);
		ab.insertarNodo(16);
		ab.insertarNodo(8);
		ab.insertarNodo(20);

	}
}