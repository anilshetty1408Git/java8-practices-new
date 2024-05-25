package functionalInterface;

import javax.xml.namespace.QName;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionInterfaceDemo {
    public static void main(String[] args) {
//      Predicate
        Predicate<String> stringPredicate = string -> string.length() > 5;
        boolean str = stringPredicate.test("krish");
        System.out.println(str);

//       Function

        Function<Integer, String> function = input -> input * 5 + " is answer";
        System.out.println(function.apply(25));

//      Consumer

        Consumer<Bank> bankConsumer = name -> name.setBankName("Karnataka bank");
        Bank bank = new Bank();
        bankConsumer.accept(bank);
        bankConsumer.andThen(bank1 -> bank1.setBankName("SBI"));
        System.out.println(bank.getBankName());


    }
}

class Bank {
    private String bankName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
