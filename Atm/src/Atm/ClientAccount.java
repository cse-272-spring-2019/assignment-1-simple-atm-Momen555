package Atm;
public class ClientAccount {
 private   String currentBalance;
public void deposit(String amount){
    int x=Integer.parseInt(amount)+Integer.parseInt(currentBalance);
    currentBalance=Integer.toString(x);
   
}
public void withDraw(String amount){ 
     int x=Integer.parseInt(currentBalance)-Integer.parseInt(amount);
    currentBalance=Integer.toString(x);
   
}

    public ClientAccount(String balance) {
        this.currentBalance=balance;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }

    
}

