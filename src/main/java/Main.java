import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Vinh", "Vietnam", 28),
                new Person("Lan", "Vietnam", 24),
                new Person("John", "USA", 27),
                new Person("Lee", "China", 67),
                new Person("Kim", "Korea", 22),
                new Person("Long", "Vietnam", 18),
                new Person("Jungho", "Korea", 19),
                new Person("Tian", "China", 20),
                new Person("Clara", "USA", 40),
                new Person("Mikura", "Japan", 27),
                new Person("Sony", "Japan", 29),
                new Person("Xiang", "China", 78),
                new Person("Peter", "France", 18),
                new Person("Haloy", "Malaysia", 20),
                new Person("Magie", "Malaysia", 32)
                ));

        System.out.println("Đếm số người theo quốc tịch");
        System.out.println("----------------------------------------");
        countNationality(people);
        System.out.println("----------------------------------------");
        System.out.println("Sắp xếp theo tên những người trên 25 tuổi");
        System.out.println("----------------------------------------");
        sortPeopleMoreThan25(people);
        System.out.println("----------------------------------------");
        System.out.println("Tính trung bình tuổi theo quốc gia");
        System.out.println("----------------------------------------");
        averageAgeByCountry(people);
        System.out.println("----------------------------------------");
        System.out.println("Đánh giá tuổi");
        System.out.println("----------------------------------------");
        evaluateAge(people);
    }

    public static void countNationality(List<Person> people){
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i< people.size(); i++){
            if(map.containsKey(people.get(i).getNationality())){
                int count = map.get(people.get(i).getNationality());
                map.put(people.get(i).getNationality(),count + 1);
            }else{
                map.put(people.get(i).getNationality(),1);
            }
        }
        for (String key : map.keySet()){
            System.out.println(key + " - " + map.get(key));
        }
    }
    public static void sortPeopleMoreThan25(List<Person> people){
        ArrayList<Person> arr = new ArrayList<>();
        for (Person person: people) {
            if(person.getAge() > 25){
                arr.add(person);
            }
        }
        arr.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
    }
    public static void averageAgeByCountry(List<Person> people){
        Map<String,List<Integer>> map = new HashMap<>();
        for (Person person: people) {
            if (map.containsKey(person.getNationality())) {
                ArrayList<Integer> arr = (ArrayList<Integer>) map.get(person.getNationality());
                arr.add(person.getAge());
                map.put(person.getNationality(), arr);
            } else {
                map.put(person.getNationality(), new ArrayList<Integer>(Arrays.asList(person.getAge())));
            }
        }
        Map<String,Double> result = new HashMap<>();
        for (String key: map.keySet()) {
            ArrayList<Integer> arr = (ArrayList<Integer>) map.get(key);
            int sum = 0;
            for(int i = 0; i< arr.size(); i++){
                sum += arr.get(i);
            }
            double average = (double) sum/arr.size();
            DecimalFormat df = new DecimalFormat("#.#");
            double num = Double.valueOf(df.format(average));
            result.put(key,num);
        }
        for (String key: result.keySet()){
            System.out.println(key + " - " + result.get(key));
        }
    }
    public static void evaluateAge(List<Person> people){
        Map<Person,String> map = new HashMap<>();
        for (Person person: people) {
           if(person.getAge()< 20){
               map.put(person,"Thanh nien");
           } else if(person.getAge() >=20 && person.getAge() < 30){
               map.put(person,"Di lam");
           }else if(person.getAge() >=30 && person.getAge() < 40){
               map.put(person,"Trung nien");
           }else{
               map.put(person,"Ve huu");
           }
        }
        for(Person key: map.keySet()){
            System.out.println(key.toString() +  " - " + map.get(key));
        }
    }
}
