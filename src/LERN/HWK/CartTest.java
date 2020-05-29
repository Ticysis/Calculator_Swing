package LERN.HWK;

import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
 * 富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
 * 富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
 **/
public class CartTest {
    public static void main(String[] args) {


    }
}
/*
富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
 */
class CartItem{
    private int id;
    private String name;
    private double price;
    private int quasntity;

    public CartItem(int id, String name, double price, int quasntity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quasntity = quasntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuasntity() {
        return quasntity;
    }

    public void setQuasntity(int quasntity) {
        this.quasntity = quasntity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "商品id=" + id +
                ", 商品名='" + name + '\'' +
                ", 商品单价=" + price +
                ", 数量=" + quasntity +
                "条目总价：= "+ price*quasntity+
                '}';
    }
}
/*
富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
 */
class ShoppingCart{
    private String userName;
    private CartItem[][] items =new CartItem[5][4];
    private int count;
    private double totalPrice;

    public ShoppingCart(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CartItem[][] getItems() {
        return items;
    }

    public void setItems(CartItem[][] items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void addItem(CartItem[][] items){
            if(this.items!=null){
                for(int i=0; i<this.items.length; i++){
                    if(items[i][1]==this.items[i][1]){
                        out.println("触发了");
                    }
                }

            }


    }
    public  void removeItem(int i){

    }
    public  void setQuantity(int  i , int quantity){

    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "userName='" + userName + '\'' +
                ", items=" + Arrays.toString(items) +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
/*
富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善.
 */













