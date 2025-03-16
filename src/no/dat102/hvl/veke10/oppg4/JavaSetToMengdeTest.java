package no.dat102.hvl.veke10.oppg4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaSetToMengdeTest {

    private JavaSetToMengde mengde1;
    private JavaSetToMengde mengde2;

    @BeforeEach
    void setUp() {
        mengde1 = new JavaSetToMengde();
        mengde2 = new JavaSetToMengde();
    }

    @Test
    void testLeggTil() {
        mengde1.leggTil("element1");
        assertTrue(mengde1.inneholder("element1"));
    }

    @Test
    void testErTom() {
        assertTrue(mengde1.erTom());
        mengde1.leggTil("element1");
        assertFalse(mengde1.erTom());
    }

    @Test
    void testFjern() {
        mengde1.leggTil("element1");
        mengde1.fjern("element1");
        assertFalse(mengde1.inneholder("element1"));
    }

    @Test
    void testErDelmengdeAv() {
        JavaSetToMengde set1 = new JavaSetToMengde();
        JavaSetToMengde set2 = new JavaSetToMengde();

        set1.leggTil("element1");
        set2.leggTil("element1");
        set2.leggTil("element2");

        System.out.println("Set 1: " + set1.set);
        System.out.println("Set 2: " + set2.set);
        assertTrue(set1.erDelmengdeAv(set2));
    }




    @Test
    void testErLik() {
        mengde1.leggTil("element1");
        mengde2.leggTil("element1");
        assertTrue(mengde1.erLik(mengde2));
    }

    @Test
    void testErIkkeLik() {
        mengde1.leggTil("element1");
        mengde2.leggTil("element2");
        assertFalse(mengde1.erLik(mengde2));
    }

    @Test
    void testErDisjunkt() {
        mengde1.leggTil("element1");
        mengde2.leggTil("element2");
        assertTrue(mengde1.erDisjunkt(mengde2));

        mengde2.leggTil("element1");
        assertFalse(mengde1.erDisjunkt(mengde2));
    }

    @Test
    void testSnitt() {
        mengde1.leggTil("element1");
        mengde1.leggTil("element2");
        mengde2.leggTil("element2");
        mengde2.leggTil("element3");

        MengdeADT<Object> snittMengde = mengde1.snitt(mengde2);
        assertTrue(snittMengde.inneholder("element2"));
        assertFalse(snittMengde.inneholder("element1"));
        assertFalse(snittMengde.inneholder("element3"));
    }

    @Test
    void testUnion() {
        mengde1.leggTil("element1");
        mengde1.leggTil("element2");
        mengde2.leggTil("element2");
        mengde2.leggTil("element3");

        MengdeADT<Object> unionMengde = mengde1.union(mengde2);
        assertTrue(unionMengde.inneholder("element1"));
        assertTrue(unionMengde.inneholder("element2"));
        assertTrue(unionMengde.inneholder("element3"));
    }

    @Test
    void testDifferanse() {
        mengde1.leggTil("element1");
        mengde1.leggTil("element2");
        mengde2.leggTil("element2");
        mengde2.leggTil("element3");

        MengdeADT<Object> differanseMengde = mengde1.differanse(mengde2);
        assertTrue(differanseMengde.inneholder("element1"));
        assertFalse(differanseMengde.inneholder("element2"));
        assertFalse(differanseMengde.inneholder("element3"));
    }
}
