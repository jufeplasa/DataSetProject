package model;

import java.util.*;

public class ArbolAVL<T> extends java.util.AbstractSet<T> {

    private Nodo<T> raiz;
    Comparator<T> comparador;

    public ArbolAVL() {
    }

    public ArbolAVL(Comparator<T> cmp) {
        this.comparador = cmp;
    }

    public boolean add(T e) throws ClassCastException, NullPointerException, IllegalStateException {
        Nodo<T> nodo = new Nodo<T>(e);
        boolean salir = false;
        boolean der = false;
        Nodo<T> raizTmp = this.getRaiz();

        int altIzq, altDer;

        //no existía arbol
        if (raizTmp == null) {
            this.raiz = nodo;
            return true;
        } else //estaba ya en el arbol?
        if (this.contains(nodo.getDato())) {
            return false;
        } //no estaba antes en el arbol
        else {
            while (!salir) {

                //es mayor el nodo a insertar que la raiz?    				
                if (this.compararDato(nodo.getDato(), raizTmp.getDato()) > 0) {
                    if (raizTmp.getDerecha() != null) {
                        raizTmp = raizTmp.getDerecha();
                    } else {
                        salir = true;
                        der = true;
                    }

                } //el nodo es menor que la raiz
                else {
                    if (raizTmp.getIzquierda() != null) {
                        raizTmp = raizTmp.getIzquierda();
                    } else {
                        salir = true;
                    }
                }
            }

            //tengo que insertarlo a la derecha?
            if (der) {
                raizTmp.setDerecha(nodo);
            } //lo inserto a la izquierda
            else {
                raizTmp.setIzquierda(nodo);
            }

            //mientras no este equilibrado el arbol	miramos donde reestructurar
            while (equilibrado(this.getRaiz()) < 0) {
                raizTmp = padre(raizTmp);

                if (raizTmp.getDerecha() == null) {
                    altDer = 0;
                } else {
                    altDer = raizTmp.getDerecha().getAltura();
                }

                if (raizTmp.getIzquierda() == null) {
                    altIzq = 0;
                } else {
                    altIzq = raizTmp.getIzquierda().getAltura();
                }

                Nodo<T> cambiar = estructurar(raizTmp, altIzq, altDer);
                Nodo<T> superior = padre(raizTmp);

                //si los nodos modificados tenian un padre anteriormente
                if (compararDato(superior.getDato(), raizTmp.getDato()) != 0) {
                    if (superior.getIzquierda() != null && compararDato(superior.getIzquierda().getDato(), raizTmp.getDato()) == 0) {
                        superior.setIzquierda(cambiar);
                    } else if (superior.getDerecha() != null && compararDato(superior.getDerecha().getDato(), raizTmp.getDato()) == 0) {
                        superior.setDerecha(cambiar);
                    }
                } else {
                    this.raiz = cambiar;
                }
            }
            return true;
        }
    }

    private Nodo<T> estructurar(Nodo<T> nodo, int altIzq, int altDer) {
        if (extraeFactorE(nodo) == 2) {
            if (extraeFactorE(nodo.getDerecha()) == 1 || extraeFactorE(nodo.getDerecha()) == 0) {
                nodo = rotacionSimpleIzquierda(nodo);
            } else if (extraeFactorE(nodo.getDerecha()) == -1) {
                nodo = rotacionCompuestaDerecha(nodo);
            }
        } else if (extraeFactorE(nodo) == -2) {
            if (extraeFactorE(nodo.getIzquierda()) == -1 || extraeFactorE(nodo.getDerecha()) == 0) {
                nodo = rotacionSimpleDerecha(nodo);
            } else if (extraeFactorE(nodo.getIzquierda()) == 1) {
                nodo = rotacionCompuestaIzquierda(nodo);
            }
        }

        return nodo;
    }

    public int extraeFactorE(Nodo<T> nodo) {
        if (nodo != null) {
            return nodo.getFactorE();
        } else {
            return 0;
        }
    }

    public Nodo<T> rotacionSimpleIzquierda(Nodo<T> nodo) {

        return nodo;
    }

    public Nodo<T> rotacionSimpleDerecha(Nodo<T> nodo) {

        return nodo;
    }

    public Nodo<T> rotacionCompuestaIzquierda(Nodo<T> nodo) {
        Nodo<T> nodoTmp = nodo; //57

        return nodoTmp;
    }

    public Nodo<T> rotacionCompuestaDerecha(Nodo<T> nodo) {
        Nodo<T> nodoTmp = nodo;
        return nodoTmp;
    }

    public int equilibrado(Nodo<T> n) {
        
        return -1;
    }


    public void clear() {
        Iterator<T> iter = this.iterator();

        while (iter.hasNext()) {
            remove(iter.next());
        }
    }

    private int compararDato(T t1, T t2) {
        if (this.comparador == null) {
            return ((Comparable) t1).compareTo(t2);
        } else {
            return this.comparador.compare(t1, t2);
        }
    }

    private Nodo<T> getRaiz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Nodo<T> padre(Nodo<T> raizTmp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
