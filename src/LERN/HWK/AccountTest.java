package LERN.HWK;

//import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import static java.lang.System.*;
/**
 *
 **/
class Account{
    private int id;
    private String name;
    private double balence;
    private Date dateCreated;

    public Account(int id , String name){
        SimpleDateFormat Sa = new SimpleDateFormat("HH:mm:ss");
        Date tm = new Date();
        this.dateCreated = tm;
        this.id = id;
        this.name = name;
    }
    public void withdraw(double mo){
        if(mo>this.balence){
            out.println("Désolé, le solde de votre compte est insuffisant...");
        }
        else if(mo<this.balence && mo==this.balence){
            this.balence-=mo;
            out.println("Le solde de votre compte a été mis à jour pour ..."+this.balence+"Yuan");
        }
    }


    public void transfer(Account a ,double mo){
  //      Scanner sc = new Scanner(in);
  //     double mytran = sc.nextDouble();
        if(mo>this.balence){
            out.println("Désolé, le solde de votre compte est insuffisant...");
        }
        else if(mo<this.balence && mo == this.balence){
            out.println("Le solde de votre compte a été mis à jour pour ..."+this.balence+"Yuan");
            a.balence +=mo;
            this.balence-=mo;
        }
    }

    public String toString(){
        SimpleDateFormat Sa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date tm = new Date();
        String tim = Sa.format(tm);
        String all = "帐号："+id+"\t\t实名："+name+"\t\t账户余额:"+balence+"\t\t开户时间: "+tim;
        return all;
    }

    public void deposit(double balence){
        this.balence = balence;
    }
}
public class AccountTest {
    public static void main(String[] args) throws InterruptedException{
        out.println("Veuillez saisir certaines données...");
        Thread.sleep(1000);
        Account Ra = new Account(180460132,"Ella");
        Ra.deposit(3000);
        out.println(Ra.toString());
        Ra.withdraw(2500);
        out.println(Ra.toString());
        Account El = new Account(22333,"Rail");
        Ra.transfer(El,100);
        out.println(El.toString());
        out.println(Ra.toString());







    }
}
