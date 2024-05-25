package mischaklleneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class NamePhoneEmail {

    String name;
    String phonenum;
    String email;

    public NamePhoneEmail(String name, String phonenum, String email) {
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phonenum;

    public NamePhone(String name, String phonenum) {
        this.name = name;
        this.phonenum = phonenum;
    }
}

class StreamDemo5 {
    public static void main(String[] args) {
//        A list of names, phone numbers, and email addresses
        var myList = Arrays.asList(new NamePhoneEmail("Larry", "555-5555", "Larry@gmail.com"),
                new NamePhoneEmail("James", "555-4444", "James@gmail.com"),
                new NamePhoneEmail("Mary", "555-3333", "Marry@gmail.com")
        );
        System.out.println("Original values in myList: ");
        myList.stream().forEach(a -> System.out.println(a.name + " " + a.phonenum + " " + a.email));
        System.out.println();

//            Map just the names and phone numbers
        System.out.println("List of names and phone numbers");
        Stream<NamePhone> namePhoneStream = myList.stream().map(a -> new NamePhone(a.name, a.phonenum));
        namePhoneStream.forEach(a -> {
            System.out.println(a.name + " " + a.phonenum);
        });
//        Map particular name
        System.out.println();
        System.out.println("Map particular name");
        Stream<NamePhone> namePhoneStream1 = myList.stream().filter(a -> a.name.equals("James")).map(m -> new NamePhone(m.name, m.phonenum));
        namePhoneStream1.forEach(a-> System.out.println(a.name+" "+a.phonenum));
    }
}
