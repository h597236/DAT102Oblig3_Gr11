package no.dat102.hvl.veke10.oppg4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TabellMengdeTest {
    private TabellMengde<Integer> mengde1;
    private TabellMengde<Integer> mengde2;

    @BeforeEach
    void setUp() {
        mengde1 = new TabellMengde<>();
        mengde2 = new TabellMengde<>();

        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde1.leggTil(3);

        mengde2.leggTil(3);
        mengde2.leggTil(4);
        mengde2.leggTil(5);
    }

    @Test
    void testErTom() {
        TabellMengde<Integer> tomMengde = new TabellMengde<>();
        assertTrue(tomMengde.erTom());
        assertFalse(mengde1.erTom());
    }

    @Test
    void testInneholder() {
        assertTrue(mengde1.inneholder(1));
        assertTrue(mengde1.inneholder(2));
        assertFalse(mengde1.inneholder(4));
    }

    @Test
    void testLeggTil() {
        mengde1.leggTil(4);
        assertTrue(mengde1.inneholder(4));
    }

    @Test
    void testFjern() {
        assertTrue(mengde1.inneholder(2));
        mengde1.fjern(2);
        assertFalse(mengde1.inneholder(2));
    }

    @Test
    void testUnion() {
        MengdeADT<Integer> unionMengde = mengde1.union(mengde2);
        assertTrue(unionMengde.inneholder(1));
        assertTrue(unionMengde.inneholder(2));
        assertTrue(unionMengde.inneholder(3));
        assertTrue(unionMengde.inneholder(4));
        assertTrue(unionMengde.inneholder(5));
        assertEquals(5, unionMengde.antallElementer());
    }

    @Test
    void testSnitt() {
        MengdeADT<Integer> snittMengde = mengde1.snitt(mengde2);
        assertTrue(snittMengde.inneholder(3));
        assertFalse(snittMengde.inneholder(1));
        assertFalse(snittMengde.inneholder(4));
        assertEquals(1, snittMengde.antallElementer());
    }

    @Test
    void testMinus() {
        MengdeADT<Integer> diffMengde = mengde1.minus(mengde2);
        assertTrue(diffMengde.inneholder(1));
        assertTrue(diffMengde.inneholder(2));
        assertFalse(diffMengde.inneholder(3));
        assertFalse(diffMengde.inneholder(4));
        assertEquals(2, diffMengde.antallElementer());
    }

    @Test
    void testErDelmengdeAv() {
        TabellMengde<Integer> subset = new TabellMengde<>();
        subset.leggTil(1);
        subset.leggTil(2);

        assertTrue(subset.erDelmengdeAv(mengde1));
        assertFalse(mengde1.erDelmengdeAv(subset));
    }

    @Test
    void testErLik() {
        TabellMengde<Integer> kopi = new TabellMengde<>();
        kopi.leggTil(1);
        kopi.leggTil(2);
        kopi.leggTil(3);

        assertTrue(mengde1.erLik(kopi));
        assertFalse(mengde1.erLik(mengde2));
    }

    @Test
    void testErDisjunkt() {
        TabellMengde<Integer> disjunktMengde = new TabellMengde<>();
        disjunktMengde.leggTil(6);
        disjunktMengde.leggTil(7);

        assertTrue(mengde1.erDisjunkt(disjunktMengde));
        assertFalse(mengde1.erDisjunkt(mengde2));
    }
}
