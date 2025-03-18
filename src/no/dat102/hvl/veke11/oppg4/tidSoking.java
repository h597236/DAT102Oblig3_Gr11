package no.dat102.hvl.veke11.oppg4;

import java.util.*;

public class tidSoking {
    public static void main(String[] args) {
        int antElement = 100_000;
        int tall = 376;
        int[] tabell = new int[antElement];
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < antElement; i++) {
            tabell[i] = tall;
            hashSet.add(tall);
            tall = (tall + 45713) % 1_000_000;
        }

        Arrays.sort(tabell);

        int[] soketall = new int[100_000];
        Random rand = new Random();
        for (int i = 0; i < soketall.length; i++) {
            soketall[i] = rand.nextInt(1_000_000);
        }

        long startHash = System.nanoTime();
        for (int tallSok : soketall) {
            hashSet.contains(tallSok);
        }
        long sluttHash = System.nanoTime();
        long tidHash = sluttHash - startHash;
        System.out.println("Tid brukt i HashSet: " + tidHash / 1_000_000.0 + " ms");

        long startBinary = System.nanoTime();
        for (int tallSok : soketall) {
            Arrays.binarySearch(tabell, tallSok);
        }
        long sluttBinary = System.nanoTime();
        long tidBinary = sluttBinary - startBinary;
        System.out.println("Tid brukt med binærsøk: " + tidBinary / 1_000_000.0 + " ms");
    }
}

