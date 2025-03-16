package no.dat102.hvl.veke10.oppg4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LenketMengdeTest {

    private LenketMengde mengde;

    @BeforeEach
    void setUp() {
        mengde = new LenketMengde();
    }

    @Test
    void testLeggTil() {
        mengde.leggTil(1);
        assertTrue(mengde.inneholder(1), "Elementet burde være lagt til.");

        mengde.leggTil(2);
        assertTrue(mengde.inneholder(2), "Elementet burde være lagt til.");

        mengde.leggTil(1);
        assertEquals(2, getSize(mengde), "Størrelsen på mengden skal være 2.");
    }

    @Test
    void testFjern() {
        mengde.leggTil(1);
        mengde.leggTil(2);
        mengde.fjern(1);

        assertFalse(mengde.inneholder(1), "Elementet burde vært fjernet.");
        assertTrue(mengde.inneholder(2), "Det andre elementet skal fortsatt være der.");

        mengde.fjern(3);
        assertTrue(mengde.inneholder(2), "Det andre elementet skal fortsatt være der.");
    }

    @Test
    void testErTom() {
        assertTrue(mengde.erTom(), "Mengden skal være tom.");

        mengde.leggTil(1);
        assertFalse(mengde.erTom(), "Mengden skal ikke være tom.");
    }

    @Test
    void testErDelmengdeAv() {
        LenketMengde annenMengde = new LenketMengde();
        annenMengde.leggTil(1);
        annenMengde.leggTil(2);

        mengde.leggTil(1);
        mengde.leggTil(2);
        assertTrue(mengde.erDelmengdeAv(annenMengde), "Mengden skal være en delmengde av den andre.");

        mengde.leggTil(3);
        assertFalse(mengde.erDelmengdeAv(annenMengde), "Mengden skal ikke være en delmengde av den andre etter å ha lagt til 3.");
    }

    @Test
    void testErLik() {
        LenketMengde annenMengde = new LenketMengde();
        annenMengde.leggTil(1);
        annenMengde.leggTil(2);

        mengde.leggTil(1);
        mengde.leggTil(2);
        assertTrue(mengde.erLik(annenMengde), "Mengdene skal være like.");

        mengde.leggTil(3);
        assertFalse(mengde.erLik(annenMengde), "Mengdene skal ikke være like etter å ha lagt til 3.");
    }

    @Test
    void testSnitt() {
        LenketMengde annenMengde = new LenketMengde();
        annenMengde.leggTil(1);
        annenMengde.leggTil(2);

        mengde.leggTil(1);
        mengde.leggTil(2);
        mengde.leggTil(3);

        LenketMengde snittMengde = mengde.snitt(annenMengde);
        assertTrue(snittMengde.inneholder(1), "Snittet skal inneholde 1.");
        assertTrue(snittMengde.inneholder(2), "Snittet skal inneholde 2.");
        assertFalse(snittMengde.inneholder(3), "Snittet skal ikke inneholde 3.");
    }

    @Test
    void testUnion() {
        LenketMengde annenMengde = new LenketMengde();
        annenMengde.leggTil(1);
        annenMengde.leggTil(2);

        mengde.leggTil(2);
        mengde.leggTil(3);

        LenketMengde unionMengde = mengde.union(annenMengde);
        assertTrue(unionMengde.inneholder(1), "Unionen skal inneholde 1.");
        assertTrue(unionMengde.inneholder(2), "Unionen skal inneholde 2.");
        assertTrue(unionMengde.inneholder(3), "Unionen skal inneholde 3.");
    }

    @Test
    void testDifferanse() {
        LenketMengde annenMengde = new LenketMengde();
        annenMengde.leggTil(2);
        annenMengde.leggTil(3);

        mengde.leggTil(1);
        mengde.leggTil(2);
        mengde.leggTil(3);

        LenketMengde differanseMengde = mengde.differanse(annenMengde);
        assertTrue(differanseMengde.inneholder(1), "Differansen skal inneholde 1.");
        assertFalse(differanseMengde.inneholder(2), "Differansen skal ikke inneholde 2.");
        assertFalse(differanseMengde.inneholder(3), "Differansen skal ikke inneholde 3.");
    }

    private int getSize(LenketMengde mengde) {
        int size = 0;
        LenketMengde.Node current = mengde.head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}
