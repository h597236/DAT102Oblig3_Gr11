package no.dat102.hvl.veke10.oppg4;

import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde implements MengdeADT<Object> {
    Set<Object> set;

    public JavaSetToMengde() {
        set = new HashSet<>();
    }

    @Override
    public boolean inneholder(Object data) {
        return set.contains(data);
    }

    @Override
    public void leggTil(Object data) {
        set.add(data);
    }

    @Override
    public void leggTilAlleFra(MengdeADT<Object> annenMengde) {
        if (annenMengde instanceof JavaSetToMengde) {
            JavaSetToMengde annen = (JavaSetToMengde) annenMengde;
            set.addAll(annen.set);
        }
    }

    @Override
    public boolean erTom() {
        return set.isEmpty();
    }

    @Override
    public Object fjern(Object data) {
        set.remove(data);
        return data;
    }

    @Override
    public Object[] tilTabell() {
        return set.toArray();
    }

    @Override
    public int antallElementer() {
        return set.size();
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<Object> annenMengde) {
        if (annenMengde instanceof JavaSetToMengde) {
            JavaSetToMengde annen = (JavaSetToMengde) annenMengde;

            for (Object elem : set) {
                if (!annen.set.contains(elem)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }





    @Override
    public boolean erLik(MengdeADT<Object> annenMengde) {
        if (annenMengde instanceof JavaSetToMengde) {
            JavaSetToMengde annen = (JavaSetToMengde) annenMengde;
            return set.equals(annen.set);
        }
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<Object> annenMengde) {
        if (annenMengde instanceof JavaSetToMengde) {
            JavaSetToMengde annen = (JavaSetToMengde) annenMengde;
            Set<Object> tempSet = new HashSet<>(set);
            tempSet.retainAll(annen.set);
            return tempSet.isEmpty();
        }
        return false;
    }

    @Override
    public MengdeADT<Object> snitt(MengdeADT<Object> annenMengde) {
        JavaSetToMengde snittMengde = new JavaSetToMengde();
        if (annenMengde instanceof JavaSetToMengde) {
            JavaSetToMengde annen = (JavaSetToMengde) annenMengde;
            snittMengde.set.addAll(set);
            snittMengde.set.retainAll(annen.set);
        }
        return snittMengde;
    }

    @Override
    public MengdeADT<Object> union(MengdeADT<Object> annenMengde) {
        JavaSetToMengde unionMengde = new JavaSetToMengde();
        if (annenMengde instanceof JavaSetToMengde) {
            JavaSetToMengde annen = (JavaSetToMengde) annenMengde;
            unionMengde.set.addAll(set);
            unionMengde.set.addAll(annen.set);
        }
        return unionMengde;
    }

    @Override
    public MengdeADT<Object> minus(MengdeADT<Object> annenMengde) {
        return differanse(annenMengde);
    }

    @Override
    public MengdeADT<Object> differanse(MengdeADT<Object> annenMengde) {
        JavaSetToMengde differanseMengde = new JavaSetToMengde();
        if (annenMengde instanceof JavaSetToMengde) {
            JavaSetToMengde annen = (JavaSetToMengde) annenMengde;
            differanseMengde.set.addAll(set);
            differanseMengde.set.removeAll(annen.set);
        }
        return differanseMengde;
    }
}
