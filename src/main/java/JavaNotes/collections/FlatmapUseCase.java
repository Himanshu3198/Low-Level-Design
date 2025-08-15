package JavaNotes.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlatmapUseCase {

    public static void main(String[] args) {

        List<List<Integer>> list = Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(5,6));
        List<Integer> flatList = list.stream().flatMap(Collection::stream).toList();
        flatList.forEach(System.out::println);
    }

}
