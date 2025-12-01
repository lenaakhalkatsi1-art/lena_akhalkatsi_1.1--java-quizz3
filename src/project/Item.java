package project;

import java.io.Serializable;
import java.util.List;
//BATONO NIKA GITVIRTAVT BOLOMDE DASRULEBUL QUIZZS, GTXOVT GAITVALISWINOT ROM AUDITORIASHI UBRALOD VER MOVASWARI DROSHI CHATEVA UCEB GAMEPARA DRO
//PLSSSSS IYAVIT LMOBIERI :)
public class Item implements Comparable<Item>, Serializable {

    private Integer itemId;
    private String name;
    private String category;
    private Integer price;
    private Integer quantity;

    private List<Integer> listOfComments;

    public Item(String name, String category, Integer price, Integer quantity, List<Integer> listOfComments) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.listOfComments = listOfComments;
    }

    public Integer getId() {
        return itemId;
    }
    public Integer getQuantity() { return quantity;}
    public String getCategory() {return category;}
    public String getName() {return name;}

    public void setItemId(Integer itemId) {this.itemId = itemId;}

    public double getAverage() {
        if (listOfComments.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (int g : listOfComments) {
            sum += g;
        }
        return (double) sum / listOfComments.size();
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", listOfComments=" + listOfComments +
                '}';
    }

    @Override
    public int compareTo(Item other) {
        return Integer.compare(this.getQuantity(), other.getQuantity());
    }

}

