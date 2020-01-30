import java.util.*;

/**
 * Attenzione: nel filter serve necessariamente il metodo statico,
 *      java.util.Objects.equals(Object a, Object b)
 * poichè posso avere dei valori "null", con i quali
 *  non posso applicare né l'operatore "==", né "equals()
 *  Ovvero, a volte si verifica il caso
 *      null == false, oppure
 *      false == null
 *  Che lanciano una NullPointerException.
 *
 *  Esempi di codice errato:
 *  1)
 *      iters.stream()
 *             .filter(x -> false == x.getFlag())
 *             .forEach(System.out::println);
 *
 *  2)
 *      boolean b1 = false == true;
 */

public class Driver {
    public static void main(String args[]){
        System.out.println("Driver class, main method");
        One.go();
    }
}

class One{
    public static void go() {
        //findMaxInCollection();
        //filterAndCount();
        filterAndPrint();
    }

    public static List<Iter> initIters() {
        List<Iter> iters = new ArrayList<>();

        Iter first = new Iter.Builder().withId(1).withFlag(true).build();
        Iter second = new Iter.Builder().withId(2).withFlag(false).build();
        Iter third = new Iter.Builder().withId(3).withFlag(null).build();
        Iter fourth = new Iter.Builder().withId(4).withFlag(false).build();

        iters.add(first);
        iters.add(second);
        iters.add(third);
        iters.add(fourth);
        return iters;
    }

    public static void findMaxInCollection(){
        List<Iter> iters = initIters();

        Comparator<Iter> iterComparatorById = Comparator.comparing(Iter::getId);

        Iter maxIter = Collections.max(iters, iterComparatorById);

        System.out.println("Max iter by id is: " + maxIter);
    }

    public static void filterAndCount(){
        List<Iter> iters = initIters();

        // anche qui, stessa precauzione
        long numElem = iters.stream()
                .filter(x -> java.util.Objects.equals(x.getFlag(), false))
                .count();
        System.out.println("Number of elements: " + numElem);


    }

    public static void filterAndPrint(){
        List<Iter> iters = initIters();

        iters.stream()
                .filter(x -> java.util.Objects.equals(x.getFlag(), false))
                .forEach(System.out::println);

    }



}