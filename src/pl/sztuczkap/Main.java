package pl.sztuczkap;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        // interfejs Function przyjmuje jakas wartosc i zwraca inna

        Function<String, Integer> function = String::length;  // String na Integer
        System.out.println(function.apply("Hello"));

        // tworzymy Function który dla podanego imienia stworzy nam Usera
        Function<String, User> nameUserMapper = User::new;

        List<String> names = List.of("Marta", "Jan", "Marek");

        Function<String, String> prefixMapper = name -> "Pan/Pani " + name;

        names.forEach(name -> System.out.println(
                nameUserMapper
                        .compose(prefixMapper) // łączymy warunek czyli dla imienia dopisze pan/pani
                        .apply(name)));


        // tworzymy tym biFunction który przyjmie 2 argumenty typu generycznego
        BiFunction<String, Integer, User> biFunction = User::new;

        Map<String, Integer> nameAgeMap = Map.of("Marta", 28, "Jan", 21, "Marek", 32);

        nameAgeMap.forEach((name, age) ->
                System.out.println( biFunction.apply(name, age)));


    }
}
