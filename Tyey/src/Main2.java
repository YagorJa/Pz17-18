import jdk.jshell.execution.StreamingExecutionControl;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 32, 43, 6, 4, 7, 56, 34, 2, 7, 8);
        List<Integer> list = integers.stream().filter(i -> i == 0).toList();

        Stream<Integer> stream = integers.stream();

        List<Integer> list1 = stream.filter(i -> i == 1).toList();
        System.out.println("<<<");
        list1.stream().forEach(System.out::println);
        //stream.filter(integer -> integer == 1).forEach(System.out::println);
        System.out.println(">>>>");



        Stream<Integer> test = Stream.of(1, 435, 65, 4, 65, 3, 7, 9, 56, 2, 4, 0, 433, 24, 765, 5);

        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});

       Stream<Object> build = Stream.builder().add(1).add(2).add(3).add(4).build();

       User.builder().
               setAge(20).
               setLastName("Ankudovich").
               setName("Egor").
               setHasAnimal(false);
       test1();
       test2();
    }
    private static long test(){
        Stream<Integer> stream = List.of(32,35,567,45893473,76,34,5,2).stream();
       // long c =
        Optional<String> reduce =
                stream
                .skip(1)
                .limit(10)
                .distinct()
                .map(x-> x + "")
              //  .sorted((o1, o2) -> o2.length() - o1.length())
               // .peek(System.out::println)
                .filter(i-> !i.equals("0"))
                        .reduce((s,s2)->s +s2);
                      //  .forEach(System.out::println);
                //.count();
                //.findAny()
                //.findFirst()
                //.collect(Collectors.toSet())
                //.allMatch(x-> x.equals("0"))
                //.anyMatch(x-> x.equals("0"))
                //.noneMatch(x->x.equals("0"))
        System.out.println(reduce);
        return 0;
    }
    private static void test1(){
        System.out.println(test() + "<<<");
    }
    private static void test2(){
        String s = test3();

        Optional<String> optional = Optional.ofNullable(test3());

        optional.ifPresent(x -> {
            System.out.println("<<");
            boolean equals = x.equals("СОСетка");
            System.out.println(equals);
        });
optional.orElse("freg");
optional.orElseGet(()-> {return "fgvbs";});
optional.orElse("rgeg");
//        if (s == null) {
//            System.out.println("s is not null");
//        }else {
//            System.out.println(s.equals("1"));
//        }
    }
    private static String test3(){
        return null;
    }
//    private static void test4(){
//List<Integer> integers =List.of(234,34,5,5,67,2,0,52,13);
//
//    }
public static void main111() {
  User user = new User();
    Optional<User> user1 = Optional.of(user);
    user1.ifPresentOrElse(user2 -> System.out.println(user2.getName()), ()-> System.out.println("DEFAULT"));
}
}
