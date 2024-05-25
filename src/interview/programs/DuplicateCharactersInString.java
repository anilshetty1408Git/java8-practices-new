package interview.programs;

import javax.lang.model.element.NestingKind;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharactersInString {
    public static void main(String[] args) {
        String string = "anilanl";
        findDUplicateCharacters(string);
    }

    private static void findDUplicateCharacters(String string) {
        String[] split = string.split("");
        Arrays.stream(split)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(key->key.getValue()>1).forEach((a->System.out.println(a.getKey())));


    }
}
