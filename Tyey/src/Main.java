import api.Name;
import api.Response;
import api.Result;
import api.TestInfo;
import com.google.gson.Gson;
import example.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Supplier<Response> supplier = Main::getUser;
        Response response0 = supplier.get();
        var results = response0.getResults();

       Predicate<Name> test = (Name x)-> x.getFirst().startsWith("A");

        Stream<Result> stream = results.stream();/////// чзх
       List<Result> list = stream.filter(result -> test.test(result.getName()))
               .filter((Result x)-> x.getGender().startsWith("f"))
               .toList();
       list.forEach((Result s)-> System.out.println(s.getName().getFirst()+ "  " + s.getGender()));
        System.out.println(list.size());

      // stream.forEach(System.out::println);

        LocalDate now = LocalDate.now();
        LocalDate me1 = LocalDate.of(2003,9,23);
        System.out.println(me1.getDayOfWeek());

        LocalDate me = LocalDate.parse("23.09.2003", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(me.getDayOfWeek().toString());

        System.out.println(now.toString());

        LocalDate parse = LocalDate.parse("11-11-2000", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(parse.getDayOfWeek().toString());

        DayOfWeek dayOfWeek = now.getDayOfWeek();

        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;



Supplier<Integer> integerSupplier = ()-> new Random().nextInt(10,20);
int i = integerSupplier.get();
        System.out.println(i + "      SUKA");

        ///Ахуенная штука для генерации рандомычей



Test1<Integer> t = (x, y) -> {
    System.out.println(x);
    System.out.println(y);
    System.out.println(x-y);
    return x-y;
};
int a = t.minus(10,20);
        System.out.println(a);


        Function<Integer,String> function = (x) -> {
            return  x.toString()+ "!Q10";
        };
        String apply = function.apply(10);
        System.out.println(apply);
    }


    public static Response getUser() {
        String uri = "https://randomuser.me/api/";
        //TODO make different methods
        uri += "?results=200";
        //String uri = "?gender=female";

        //String uri = "?format=csv";
        //JSON (default), PrettyJSON or pretty, CSV, YAML, XML
        //String uri = "?nat=gb(,fi)"
        //v1.3: AU, BR, CA, CH, DE, DK, ES, FI, FR, GB, IE, IR, NO, NL, NZ, TR, US
        //String uri = "?results=5&inc=name,gender,nat& noinfo";
        //String uri = "?inc=gender(,name)";
        //String uri = "?exc=login";
        String get = "GET";
        URL url;
        HttpURLConnection con;
        BufferedReader in;
        StringBuilder content = new StringBuilder();
        Gson gson = new Gson();
        Response response;
        try {
            url = new URL(uri);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(get);
            con.getResponseCode();
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            response = gson.fromJson(content.toString(), Response.class);
            in.close();
            con.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @FunctionalInterface
    interface Test<T1>{
        void test(T1 a);
    }

    private static String revers (String s) {

        StringBuilder stringBuilder = new StringBuilder(s);

        return stringBuilder.reverse().toString();
    }
    @FunctionalInterface
    interface Test1<T1>{
        int minus(T1 a, T1 b);
    }
//        Stream<Integer> integerStream = Stream.of(1, 23, 5, 4, 5, 6, 7, 8);
//        Predicate<Result> predicate = x -> x.getGender().equals("female");
//        Function<Result, User> function = (x) -> new User(x.getName().getTitle()+x.getName().getFirst()+x.getName().getLast(), x.getDob().getAge(),x.getGender());
////        Function<Result, User> function = (x) -> {
////            User user = new User();
////            user.setAge(x.getDob().getAge());
////            user.setName(x.getName().getTitle()+x.getName().getFirst()+x.getName().getLast());
////            user.setGender(x.getGender());
////            return user;
////        };
//
//
//        Consumer<User> consumer = System.out::println;
//
//        List<User> collect = stream.filter(predicate).map(function).collect(Collectors.toList());
////        userStream.forEach(consumer);
////
//        String value = null;
////        value.substring(1);
//
//
//
////        long count = stream.filter(predicate).count();
////        System.out.println(count);
//
//
////        for (Result r: results) {
////            System.out.println(r);
////        }
////
////        Test<String> test = x-> {
////            Scanner sc = new Scanner(System.in);
////            if(x.equals("1")){
////                String s = sc.nextLine();
////                String revers = revers(s);
////                System.out.println(revers);
////            } else {
////                int i = sc.nextInt();
////                System.out.println(i+ "factorial");
////
////            }
////        };
////
////
////        String s = new Scanner(System.in).nextLine();
////        test.test(s);
////
}
