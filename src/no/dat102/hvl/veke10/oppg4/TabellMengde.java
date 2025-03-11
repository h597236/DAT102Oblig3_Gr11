package no.dat102.hvl.veke10.oppg4;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T> {
    private T[] elementer;
    private int antall;

    @Override
    public boolean erTom() {
        if (antallElementer() == Integer.parseInt(null)){
            return true;
        }
        return false;
    }

    @Override
    public boolean inneholder(Object element) {
        if (element instanceof MengdeADT) {
            return true;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT annenMengde) {
        return false;
    }

    @Override
    public boolean erLik(MengdeADT annenMengde) {
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT annenMengde) {
        return false;
    }

    @Override
    public MengdeADT snitt(MengdeADT annenMengde) {
        return null;
    }

    @Override
    public MengdeADT union(MengdeADT annenMengde) {
        return null;
    }

    @Override
    public MengdeADT minus(MengdeADT annenMengde) {
        return null;
    }

    @Override
    public void leggTil(Object element) {

    }

    @Override
    public void leggTilAlleFra(MengdeADT annenMengde) {

    }

    @Override
    public Object fjern(Object element) {
        int indeks = finnIndeks(element);
        if (indeks >= 0) {
            for (int i = indeks; i < antall - 1; i++) {
                elementer[i] = elementer[i + 1];
            }
            elementer[antall - 1] = null;
            antall--;
            return true;
        }
        return false;
    }

    @Override
    public Object[] tilTabell() {
        return new Object[0];
    }

    @Override
    public int antallElementer() {
        int count = 0;
        for (int i = 0; i < tilTabell().length; i++) {
            count += 1;
        }
        return count;
    }
}
