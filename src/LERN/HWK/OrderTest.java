package LERN.HWK;

//import java.text.SimpleDateFormat;
import java.util.Date;
import static java.lang.System.*;


/**
 *
 **/
public class OrderTest {

    public static void main(String[] args) {
        ShippingAddress spa = new ShippingAddress("小白", "湖南", "永州", "BuSheCun", "A0000");

        Order or1 = new Order(1234567890,9876543);
        or1.setAddress(spa);
        out.println(or1.toString());
       // ShippingAddress spt = new ShippingAddress();
        Order or2 = new Order(21314151, 887777, spa);
        out.println(or2.toString());
        or2.setState(4);
        out.println(or2.toString());
        ShippingAddress spb = new ShippingAddress("小黑","江苏","无锡","仙林小道","665544123");
        or2.setAddress(spb);
        out.println(or2.toString());



    }
}

class ShippingAddress{
    private String name;
    private String province;
    private String city;
    private String street;
    private String tel;
        public ShippingAddress(String name, String province, String city, String street,String tel){
            this.name=name;
            this.province=province;
            this.city=city;
            this.street=street;
            this.tel=tel;
        }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getTel() {
        return tel;
    }

    public String toString(){
            String st ="姓名："+this.name+"     "+this.province+"省"+"     "+this.city+"市"+"     "+this.street+" 街道"+"   电话是  "+this.tel;
            return st;
    }
}
class Order{
    private int OrderNum;
    private Date createTime;
    private double AllPrice;
    private ShippingAddress Address;
    private int State;
    public int q = 1;
    public int w = 2;
    public int e = 3;
    public int r = 4;
    public String sd ="";

    public Order(int orderNum, double allPrice){
       // SimpleDateFormat sp = new SimpleDateFormat("HH:mm:ss");
        createTime= new Date();
        this.OrderNum = orderNum;
        this.AllPrice = allPrice;
        this.State = 1;
        if(State == 1){
            sd = "未发货";
        }
        else if(State == 2){
            sd = "已付款";
        }
        else if(State == 3){
            sd = "已发货";
        }
        else if(State == 4){
            sd = "完成";
        }
    }
    public Order(int orderNum, double allPrice, ShippingAddress Address){
        createTime=new Date();
        this.State = 1;
        this.OrderNum = orderNum;
        this.AllPrice = allPrice;
        this.Address = Address;
        if(State == 1){
            sd = "未发货";
        }
        else if(State == 2){
            sd = "已付款";
        }
        else if(State == 3){
            sd = "已发货";
        }
        else if(State == 4){
            sd = "完成";
        }
    }

    public void setAddress(ShippingAddress address) {
        Address = address;
    }

    public ShippingAddress getAddress() {
        return Address;
    }

    public void setAllPrice(double allPrice) {
        AllPrice = allPrice;
    }

    public double getAllPrice() {
        return AllPrice;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setOrderNum(int orderNum) {
        OrderNum = orderNum;
    }

    public int getOrderNum() {
        return OrderNum;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
       // String sd = "";
        if(state == 1){
            sd = "未发货";
        }
        else if(state == 2){
            sd = "已付款";
        }
        else if(state == 3){
            sd = "已发货";
        }
        else if(state == 4){
            sd = "完成";
        }

    }

    @Override
    public String toString() {
//        ShippingAddress as = this.Address;
//        String nname = as.getName();
//        String addresss = nname+as.getProvince()+as.getCity()+as.getStreet()+as.getTel();

        return "Order{" +
                "订单编号是=" + OrderNum +
                ", 创建时间是=" + createTime +
                ", 总价是=" + AllPrice +
                ", 地址是=" +  Address+
                ", 状态是=" + sd +
                '}';
    }

}





















