package model;

class Nodo<T> {

    private T dato;
    private String comparador;
    private Nodo<T> izquierda;
    private Nodo<T> derecha;
    
    @SuppressWarnings("unused")
	private int factorE;
    public Nodo() {
        dato = null;
        izquierda = null;
        derecha = null;
        factorE = 0;
    }
    @Override
    public String toString() {
        return "Nodo [valor=" + dato + ", Izquierda=" + izquierda + ", Derecha=" + derecha + "]";
    }

    public Nodo(T dato,String comparador) {
        this.dato = dato;
        this.comparador=comparador;
        izquierda = null;
        derecha = null;
        factorE = 0;
    }

    public Nodo<T> getIzquierda() {
        return izquierda;
    }

    public Nodo<T> getDerecha() {
        return derecha;
    }


    public T getDato() {
        return dato;
    }

    public void setDerecha(Nodo<T> derecha) {
        this.derecha = derecha;
    }

    public void setIzquierda(Nodo<T> izquierda) {
        this.izquierda = izquierda;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public int getFactorE() {
        int altDer = 0;
        int altIzq = 0;
        if (this.getDerecha() != null) {
            altDer = this.getDerecha().getAltura();
        }
        if (this.getIzquierda() != null) {
            altIzq = this.getIzquierda().getAltura();
        }
        return (altDer - altIzq);
    }

    public void setFactorE(int fe) {
        this.factorE = fe;
    }

    public int getAltura() {
        int hIzq = 0;
        int hDer = 0;

        if (this.getDato() == null) {
            return 0;
        }

        if (this.getIzquierda() != null) {
            hIzq = this.getIzquierda().getAltura();
        } else {
            hIzq = 0;
        }

        if (this.getDerecha() != null) {
            hDer = this.getDerecha().getAltura();
        } else {
            hDer = 0;
        }
        return Math.max(hIzq, hDer) + 1;
    }

	public String getComparador() {
		return comparador;
	}

	public void setComparador(String comparador) {
		this.comparador = comparador;
	}
}
