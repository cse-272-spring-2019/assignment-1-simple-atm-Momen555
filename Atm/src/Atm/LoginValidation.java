package Atm;
public class LoginValidation {
    static String cardNumber="1234";
    public boolean validate(String cD){ 
        if(cD.equals(cardNumber))
            return true;
        else
            return false;
    }
}

