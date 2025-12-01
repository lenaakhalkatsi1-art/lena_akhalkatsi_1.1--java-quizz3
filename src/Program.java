//        ## ამოცანა 2: დაწერეთ java-ს პროგრამა პროდუქტის მართვის სისტემისთვის
//
//        მართვის სისტემა იყენებს `HashMap`. და საბოლოოდ საშუალებას გაძლევთ CRUD ოპერაციები
//        ჩატარებისთვის.
//
//        1. განსაზღვრეთ `Item` კლასი სადაც იქნება `itemId` , `name` , `category` , `price`,
//        `quantity`, `listOfComments`
//
//        2. შექმენით პროდუქტის მონაცემთა ბაზა:
//        - გამოიყენეთ `HashMap<Integer, Item>` სადაც გასაღებები არის `itemId`, ხოლო
//        მნიშვნელობები არის `Item` ობიექტები.
//
//        3. განახორციელეთ შემდეგი ფუნქციონალი და მოიყვანეთ გამოყენების მაგალითები:
//        - განახორციელეთ ახალი პროდუქტის დამატების შესაძლებლობა.
//        - განსაზღვრეთ მეთოდი რომელსაც გადაეცემა Item-ების ლისტი და ახდენს ამ ლისტის
//        სორტირებად Comparable-ის ინტერფეისისგამოყენებით
//        და შემდეგ ამატებს დასორტირებულ მომხმარებლებს HashMap-ში.
//        - `itemId`-ის ან `name` გამოყენებით წაშლის შესაძლებლობა.
//        - პროდუქტის მოძებნა მისი itemId-ით და სრული ინფორმაციის ბეჭდვა.
//        - (Optional) შექმენით მეთოდი, რომელოც დააბრუნებს ლისტს ტოპ 5 პროდუქტის quantity-ის
//        მიხედვით.
//        - დააჯგუფეთ პროდუქტები თავიანთი კატეგორიის მიხედვით და ამობეჭდეთ პროდუქტის რაოდენობა
//        თითოეულ კატეგორიაში.
//
//        4. შექმენით შესაძლებლობა, რომ აპლიკაციამ შეძლოს ინფორმაციის აღდგენა სერიალიზაციისა და
//        დესერიალიზაციის გამოყენებით აპლიკაციის
//        ხელახლა დასტარტვის დროს.
//
//        5. მიეცით კონსოლ აპლიკაციის სახე სადაც მოახდენთ ყველა ოპერაციის გამოყენებას.


import project.Item;
import project.ProjectDatabase;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
//        task1();
        task2();
    }
    public static void task1(){
        ArrayOperations arrayOperations  = new ArrayOperations();
        List<Integer> randomList = arrayOperations.randomList();
        System.out.println("Random List: " + randomList);
        System.out.println("sum: " + arrayOperations.sum(randomList));
        System.out.println("average: " + arrayOperations.getAverage(randomList));
        System.out.println("maxValue: " + arrayOperations.maxValue(randomList));
        System.out.println("third values: " + arrayOperations.thirdValue(randomList));
        System.out.println("squared list: " + arrayOperations.squaredList(randomList));
    }

    public static void task2(){
        ProjectDatabase db = new ProjectDatabase();

        db.addItem(new Item("Milk", "Dairy", 2, 10, new ArrayList<>()));
        db.addItem(new Item("Bread", "Bakery", 1, 20, new ArrayList<>()));
        db.addItem(new Item("Cheese", "Dairy", 5, 5, new ArrayList<>()));

        List<Item> newItems = new ArrayList<>();
        newItems.add(new Item("Black bread", "Bakery", 7, 5, new ArrayList<>()));
        newItems.add(new Item("Eggs", "Dairy", 3, 20, new ArrayList<>()));
        newItems.add(new Item("Butter", "Dairy", 4, 1, new ArrayList<>()));
        newItems.add(new Item("Apple", "Fruit", 3, 15, new ArrayList<>()));

        db.sortedCustomer(newItems);

        db.removeItemById(3);

        db.removeItemByName("Cheese");

        db.findItem(1);


        List<Item> top5 = db.top5Items();
        System.out.println("Top 5:");
        for (Item i : top5) {
            System.out.println(i);
        }

        db.groupByCategory();

        db.saveToFile("dbFile.txt");
        db.loadFromFile("dbFile.txt");
    }
}

