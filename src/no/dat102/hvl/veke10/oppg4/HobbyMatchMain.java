package no.dat102.hvl.veke10.oppg4;
import java.util.HashSet;
import java.util.Set;

public class HobbyMatchMain {

    public static double match(Person a, Person b) {
        Set<String> fellesHobbyer = new HashSet<>(a.getHobbyer());
        fellesHobbyer.retainAll(b.getHobbyer());

        Set<String> kunHosA = new HashSet<>(a.getHobbyer());
        kunHosA.removeAll(b.getHobbyer());

        Set<String> kunHosB = new HashSet<>(b.getHobbyer());
        kunHosB.removeAll(a.getHobbyer());

        int antallFelles = fellesHobbyer.size();
        int antallKunHosDenEne = kunHosA.size();
        int antallKunHosDenAndre = kunHosB.size();
        int antallTotalt = a.getHobbyer().size() + b.getHobbyer().size();

        return antallFelles - ((double)(antallKunHosDenEne + antallKunHosDenAndre) / antallTotalt);
    }

    public static void main(String[] args) {
        // Opprette tre personer med hobbyer
        Person arne = new Person("Arne", "jakt", "sykling", "venner", "data");
        Person maria = new Person("Maria", "jakt", "yoga", "data", "venner");
        Person ole = new Person("Ole", "fisking", "sykling", "data");

        double matchArneMaria = match(arne, maria);
        double matchArneOle = match(arne, ole);
        double matchMariaOle = match(maria, ole);

        System.out.println("Match mellom Arne og Maria: " + matchArneMaria);
        System.out.println("Match mellom Arne og Ole: " + matchArneOle);
        System.out.println("Match mellom Maria og Ole: " + matchMariaOle);

        if (matchArneMaria >= matchArneOle && matchArneMaria >= matchMariaOle) {
            System.out.println("Beste match er mellom Arne og Maria.");
        } else if (matchArneOle >= matchMariaOle) {
            System.out.println("Beste match er mellom Arne og Ole.");
        } else {
            System.out.println("Beste match er mellom Maria og Ole.");
        }

        System.out.println("Match mellom Arne og Arne: " + match(arne, arne)); // Bør være høy
    }
}
