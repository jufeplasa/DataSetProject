package model;

class Nodo<T> {

    /**
     * Dato contenido en el nodo.
     */
    private T dato;
    
    /**
     * Dato con el que se va a organizar.
     */
    private String comparador;

    /**
     * Nodo hijo izquierda.
     */
    private Nodo<T> izquierda;

    /**
     * Nodo hijo derecha.
     */
    private Nodo<T> derecha;

    /**
     * Factor de equilibrio del nodo.
     */
    @SuppressWarnings("unused")
	private int factorE;

    /**
     * constructor por defecto.
     */
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

    /**
     * Constructor con un parametro.
     *
     * @param dato que contendra el nodo.
     */
    public Nodo(T dato,String comparador) {
        this.dato = dato;
        this.comparador=comparador;
        izquierda = null;
        derecha = null;
        factorE = 0;
    }

    /**
     * Devuelve el nodo a la izquierda del actual.
     *
     * @return nodo hijo izquierdo.
     */
    public Nodo<T> getIzquierda() {
        return izquierda;
    }

    /**
     * Devuelve el nodo a la derecha del actual.
     *
     * @return nodo hijo derecho.
     */
    public Nodo<T> getDerecha() {
        return derecha;
    }

    /**
     * Devuelve el dato contenido en el nodo.
     *
     * @return dato contenido en el nodo.
     */
    public T getDato() {
        return dato;
    }

    /**
     * Asigna un nodo al hijo derecho del nodo.
     *
     * @param derecha dato a insertar.
     */
    public void setDerecha(Nodo<T> derecha) {
        this.derecha = derecha;
    }

    /**
     * Asigna un nodo al hijo izquierdo del nodo.
     *
     * @param izquierda dato a insertar.
     */
    public void setIzquierda(Nodo<T> izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * Asigna un dato al nodo.
     *
     * @param dato dato a insertar en el nodo.
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el factor de equilibrio del nodo.
     *
     * @return factor de equilibrio del nodo.
     */
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

    /**
     * Asigna un valor al factor de equilibrio.
     *
     * @param fe factor de equilibro para asignar al nodo.
     */
    public void setFactorE(int fe) {
        this.factorE = fe;
    }

    /**
     * Devuelve la altura del nodo.
     *
     * @return altura del nodo.
     */
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
