import java.util.*;
import java.util.stream.Stream;

public class Catalogue<T extends Document> implements Iterable <T> {

    private final List<T> elements = new ArrayList<>();

    public void ajouter(T element) {
        elements.add(element);
    }

    public Optional<T> rechercherParTitre(String titre) {
        return elements.stream()
                .filter(d -> d.getTitre().equalsIgnoreCase(titre))
                .findFirst();
    }

    @Override
    public  Iterator<T> iterator (){
        return Collections.unmodifiableList(elements).iterator();
    }

    public static <T extends Comparable<? super T>> T max(List<T> liste) {
        T m = liste.get(0);

        for (T e : liste) {
            if (e.compareTo(m) > 0) {
                m = e;
            }
        }

        return m;
    }

    public Stream<T> stream() {
        return elements.stream();
    }
}