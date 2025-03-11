package no.dat102.hvl.veke10.oppg4;

import java.util.Arrays;
import java.util.Objects;

public class TabellMengde<T> implements MengdeADT<T> {
    private T[] elementer;
    private int antall;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public TabellMengde() {
        elementer = (T[]) new Object[INITIAL_CAPACITY];
        antall = 0;
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        return finnIndeks(element) >= 0;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(elementer[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return this.erDelmengdeAv(annenMengde) && annenMengde.erDelmengdeAv(this);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(elementer[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        TabellMengde<T> snittMengde = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(elementer[i])) {
                snittMengde.leggTil(elementer[i]);
            }
        }
        return snittMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        TabellMengde<T> unionMengde = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            unionMengde.leggTil(elementer[i]);
        }
        T[] andreElementer = annenMengde.tilTabell();
        for (T e : andreElementer) {
            unionMengde.leggTil(e);
        }
        return unionMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        TabellMengde<T> differanseMengde = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(elementer[i])) {
                differanseMengde.leggTil(elementer[i]);
            }
        }
        return differanseMengde;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            if (antall == elementer.length) {
                utvidKapasitet();
            }
            elementer[antall++] = element;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        T[] andreElementer = annenMengde.tilTabell();
        for (T e : andreElementer) {
            leggTil(e);
        }
    }

    @Override
    public T fjern(T element) {
        int indeks = finnIndeks(element);
        if (indeks >= 0) {
            T fjernetElement = elementer[indeks];
            for (int i = indeks; i < antall - 1; i++) {
                elementer[i] = elementer[i + 1];
            }
            elementer[--antall] = null;
            return fjernetElement;
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        return Arrays.copyOf(elementer, antall);
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    private int finnIndeks(T element) {
        for (int i = 0; i < antall; i++) {
            if (Objects.equals(elementer[i], element)) {
                return i;
            }
        }
        return -1;
    }

    private void utvidKapasitet() {
        elementer = Arrays.copyOf(elementer, elementer.length * 2);
    }
}
