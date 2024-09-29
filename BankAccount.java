import java.util.Scanner;
interface Account {
    
    void deposit(double depositbalance);
    void withdraw(double amount);
    double getBalance();   
}

public  abstract class BankAccount implements Account{
double balance;
 protected BankAccount(double balance){
this.balance=balance;
}
 public void deposit(double depositbalance){
if(depositbalance>0){
depositbalance=balance+depositbalance;
    System.out.println("After deposit now your balance is " + balance);
}
 }
 public void withdraw(double amount){ 
    if(amount>0&&amount<=balance){
    balance=balance-amount;
    System.out.println("after withraw now your balance is" + balance) ;
}else
{
    System.out.println("you are trying to withdra money above from your balance ");
}
    
}
public double getBalance(){
return balance;
}

 }
  class SavingsAccount extends BankAccount{
final double interestrate;
SavingsAccount(double balance , double interestrate) {
    super(balance);
    this.interestrate=interestrate;
}
public void deposit(){
    System.out.println("deposit ammount is " + balance);
}
public void addInterest(){
  // double currentbalance;
  double  interestrat= balance*interestrate/100;
      balance=balance+interestrat;
    System.out.println("your interesrat of a year is " + interestrat);
    System.out.println("Including your interesrat now your balace is " + balance);
}

}
 class CurrentAccount extends BankAccount{
 static final double transactionfee=1.00;
 CurrentAccount( double balance){
    super(balance);
 }
// double currentbalance=0;
  public void withdraw(double amount){
    if(amount+transactionfee<=balance){
        balance=balance-(amount+transactionfee);
        System.out.println("After withdra with transectionfee now your balance is " + balance);
    }
}
}
class Bankingsystem{
    public static void main(String[] args) {
        
        System.out.println("Hello User.....");
        System.out.println("Welcome in our bank");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first balance after opening the account ");
        double balance = sc.nextDouble();
        SavingsAccount sa = new SavingsAccount(balance,0.5);
         sa.getBalance();
         sa.addInterest();
         System.out.println("How much money you want to deposit ");
          double depositbalance = sc.nextDouble();
          sa.deposit(depositbalance);
          System.out.println("How much money you want to withdra " );
          double amount = sc.nextDouble();
          sa.withdraw(amount);
         CurrentAccount ca = new CurrentAccount(balance);
         System.out.println("How much you want to withdra with transection fee ");
         //12000double withtrnfee = sc.nextDouble();
         ca.withdraw(amount);
    }
}
 
