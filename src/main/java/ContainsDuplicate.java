import java.util.*;

public class ContainsDuplicate {

    public boolean hasDuplicates(List<Integer> numbers){

        if(numbers == null)
            throw new IllegalArgumentException("The list can't be null");

        Set<Integer> set = new HashSet<>();
        for(Integer number : numbers){
            if (!set.add(number)) {
                return true;
            }
        }
        return false;

    }
}
