import java.util.*;

//## ამოცანა 1: შექმენით მასივი და განახორციელეთ შემდეგი ოპერაციები:
//        1. მასივში შეინახეთ 10 მთელი რიცხვი.
//        2. დაწერეთ მეთოდი, რომელიც დააბრუნებს მასივში არსებული რიცხვების ჯამს.
//        3. დაწერეთ მეთოდი, რომელიც დააბრუნებს მასივში არსებული რიცხვების საშუალო მნიშვნელობას.
//        4. დაწერეთ მეთოდი, რომელიც დააბრუნებს მასივში არსებული რიცხვების მაქსიმალურ მნიშვნელობას.
//        5. დაწერეთ მეთოდი, რომელიც გადაიტანს ახალ მასივში ყოველ მე-3 ელემენტს.
//        6. (Optional) დაწერეთ მეთოდი, რომელიც დააბრუნებს ახალ მასივს, სადაც ყველა ელემენტი იქნება აყვანილი კვადრატში.
//
public class ArrayOperations {
    public List<Integer> randomList() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }

    public int sum(List<Integer> list){
        int sum =0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    public int getAverage(List<Integer> list){
        return sum(list)/list.size();
    }

    public int maxValue(List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy.getLast();
    }

    public List<Integer> thirdValue(List<Integer> list){
        List <Integer> newList = new ArrayList<>();
        for (int i = 2; i < list.size(); i += 3) {
            newList.add(list.get(i));
        }
        return newList;
    }
    public List<Integer> squaredList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();

        for (Integer num : list) {
            int squared = num * num;
            newList.add(squared);
        }
        return newList;
    }
}
