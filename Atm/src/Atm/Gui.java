package Atm;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Gui extends Application {
    LoginValidation loginValidation=new LoginValidation();;
    Scene scene1,scene2,scene3 ;
    ClientAccount clientAccount=new ClientAccount("0");
    TransactionHistory transactionHistory=new TransactionHistory();
    boolean result;
    int index =-1;
 public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
//First scene start
        primaryStage.setTitle("Log in");
        Label cardNoLabel =new Label("Card Number");
        cardNoLabel.setFont(new Font(15));
        Button enterButton =new Button("Enter");
        enterButton.setFont(new  Font(15));
        PasswordField cardNoField =new PasswordField();
        Label topLabel = new Label("ATM");
        topLabel.setFont(new Font(30));
        StackPane labelLayout =new StackPane();
        labelLayout.getChildren().add(cardNoLabel);
        StackPane buttonLayout =new StackPane();
        buttonLayout.getChildren().add(enterButton);
        StackPane textFieldLayout =new StackPane();
        textFieldLayout.getChildren().add(cardNoField);
        StackPane topLabelLayout =new StackPane();
        topLabelLayout.getChildren().add(topLabel);
        BorderPane layout1 =new BorderPane();
        layout1.setLeft(labelLayout);
        layout1.setBottom(buttonLayout);
        layout1.setCenter(cardNoField);
        layout1.setTop(topLabelLayout);
//first scene end
        
//second scene start
        Button depositButton =new Button("Deposit");
        depositButton.setFont(new Font(15));
        Button withdrawButton=new Button("Withdrawal");
        withdrawButton.setFont(new Font(15));
        Button balanceInquiryButton=new Button("Balance Inquiry");
        balanceInquiryButton.setFont(new Font(15));
        Button prevButton=new Button("Previous Transaction");
        prevButton.setFont(new Font(15));
        Button nextButton=new Button("Next Transaction");
        nextButton.setFont(new Font(15));
        Label showLabel=new Label("");
        showLabel.setFont(new Font(20));
        Button closeWindow2=new Button("Exit");
        closeWindow2.setFont(new Font(15));
        Button logOut=new Button("Log Out");
        logOut.setFont(new Font(15));
        HBox closeHBox=new HBox();
        closeHBox.getChildren().addAll(logOut,closeWindow2);
        closeHBox.setAlignment(Pos.CENTER);
        VBox actionButtons=new VBox(10);
        actionButtons.setAlignment(Pos.CENTER);
        HBox historyButtons =new HBox();
        historyButtons.getChildren().addAll(prevButton,nextButton);
        historyButtons.setAlignment(Pos.CENTER);
        actionButtons.getChildren().addAll(depositButton,withdrawButton,balanceInquiryButton,historyButtons);
        StackPane showlabelPane=new StackPane();
        showlabelPane.getChildren().add(showLabel);
        BorderPane layout2=new BorderPane();
        layout2.setTop(showlabelPane);
        layout2.setCenter(actionButtons);
        layout2.setBottom(closeHBox);
//second scene end
        
//third scene start
        Button noOne=new Button("1");
        noOne.setFont(new Font(20));
        Button noTwo=new Button("2");
        noTwo.setFont(new Font(20));
        Button noThree=new Button("3");
        noThree.setFont(new Font(20));
        Button noFour=new Button("4");
        noFour.setFont(new Font(20));
        Button noFive=new Button("5");
        noFive.setFont(new Font(20));
        Button noSix=new Button("6");
        noSix.setFont(new Font(20));
        Button noSeven=new Button("7");
        noSeven.setFont(new Font(20));
        Button noEight=new Button("8");
        noEight.setFont(new Font(20));
        Button noNine=new Button("9");
        noNine.setFont(new Font(20));
        Button noZero=new Button("0");
        noZero.setFont(new Font(20));
        Button clearAll=new Button("c");
        clearAll.setFont(new Font(20));
        Button backSpace=new Button("←");
        backSpace.setFont(new Font(20));
        HBox firstRowNumbers=new HBox();
        firstRowNumbers.getChildren().addAll(noOne,noTwo,noThree);
        firstRowNumbers.setAlignment(Pos.CENTER);
        HBox secondRowNumbers=new HBox();
        secondRowNumbers.getChildren().addAll(noFour,noFive,noSix);
        secondRowNumbers.setAlignment(Pos.CENTER);
        HBox thirdRowNumbers=new HBox();
        thirdRowNumbers.getChildren().addAll(noSeven,noEight,noNine);
        thirdRowNumbers.setAlignment(Pos.CENTER);
        HBox fourthRowNumbers=new HBox();
        fourthRowNumbers.getChildren().addAll(clearAll,noZero,backSpace);
        fourthRowNumbers.setAlignment(Pos.CENTER);
        VBox numbers=new VBox();
        numbers.getChildren().addAll(thirdRowNumbers,secondRowNumbers,firstRowNumbers,fourthRowNumbers);
        Label label=new Label();
        label.setFont(new Font(20));
        StackPane labelPane=new StackPane();
        labelPane.getChildren().add(label);
        Button enter=new Button("Enter");
        enter.setFont(new Font(18));
        Button returnButton =new Button("Return");
        returnButton.setFont(new Font(18));
        HBox hBox=new HBox();
        hBox.getChildren().addAll(enter,returnButton);
        hBox.setAlignment(Pos.CENTER);
        BorderPane layout3=new BorderPane();
        layout3.setTop(labelPane);
        layout3.setCenter(numbers);
        layout3.setBottom(hBox);
 //third scene end
        
            
 //Actions Start
 
          enterButton.setOnAction(e ->{
            String cN =cardNoField.getText();
            boolean valid=loginValidation.validate(cN);
            if (valid){
                primaryStage.setScene(scene2);
                primaryStage.setTitle("Transactions");
                showLabel.setText("");
            }
            else if (cardNoField.getText().equals(""))
                errorAlertbox.display("Error", "No Number Entered");
            else
                errorAlertbox.display("Error", "Invalid Card Number");
        });
           logOut.setOnAction(e->{primaryStage.setScene(scene1);
                primaryStage.setTitle("Log in");
                cardNoField.setText("");
                });
        closeWindow2.setOnAction(e->primaryStage.close());
        depositButton.setOnAction(e->{primaryStage.setScene(scene3);
                result=true;
                label.setText("");
                primaryStage.setTitle("Deposit");
                });
        withdrawButton.setOnAction(e->{primaryStage.setScene(scene3);
                result=false;
                label.setText("");
                primaryStage.setTitle("Withdraw");
                });
        balanceInquiryButton.setOnAction(e->{
                showLabel.setText(clientAccount.getCurrentBalance());
                transactionHistory.getHistory().add("Balance Inquiry:"+clientAccount.getCurrentBalance());
                index++;
                });
        noOne.setOnAction(e->label.setText(label.getText()+"1"));
        noTwo.setOnAction(e->label.setText(label.getText()+"2"));
        noThree.setOnAction(e->label.setText(label.getText()+"3"));
        noFour.setOnAction(e->label.setText(label.getText()+"4"));
        noFive.setOnAction(e->label.setText(label.getText()+"5"));
        noSix.setOnAction(e->label.setText(label.getText()+"6"));
        noSeven.setOnAction(e->label.setText(label.getText()+"7"));
        noEight.setOnAction(e->label.setText(label.getText()+"8"));
        noNine.setOnAction(e->label.setText(label.getText()+"9"));
        noZero.setOnAction(e->label.setText(label.getText()+"0"));
        clearAll.setOnAction(e->label.setText(""));
        
        backSpace.setOnAction(e -> {
            String currentText = label.getText();
            label.setText(currentText.substring(0, currentText.length()-1 ));
        });
        
        returnButton.setOnAction(e->{
             primaryStage.setScene(scene2);
             primaryStage.setTitle("Transactions");
             showLabel.setText("");
                });
        enter.setOnAction(e->{
            if (label.getText().equals("")  || label.getText().charAt(0) == '0')
                errorAlertbox.display("Error", "Invalid amount entered");
            String money =label.getText();
            if (result){
                index = transactionHistory.getHistory().size() - 1;
                String y=label.getText(); 
                clientAccount.deposit(money);
                transactionHistory.getHistory().add("Deposit:"+y);
                index++;
            }
            if (!label.getText().equals(""))
            {if (!result){
                if (Integer.parseInt(clientAccount.getCurrentBalance())==0)
                    errorAlertbox.display("Error", "There is no balance to withdraw");
                else if (Integer.parseInt(money)>Integer.parseInt(clientAccount.getCurrentBalance()))
                    errorAlertbox.display("Error", "There is not enough balance");
                
                else{
                    index = transactionHistory.getHistory().size() - 1;
                    String z=label.getText();
                    clientAccount.withDraw(money);
                    transactionHistory.getHistory().add("Withdraw:"+z);
                    index++;
                }
            }}
        });
        
        
        prevButton.setOnAction(e->{
            if(index >= 5){
                String s=label.getText();
                index = 4;
                transactionHistory.getHistory().remove(0); 
            }
            if(index > 0)
                showLabel.setText(transactionHistory.getHistory().get(--index));
            else 
                errorAlertbox.display("Error", "No previous history");
            });    
            
   
        
        nextButton.setOnAction(e->{
            if(index < transactionHistory.getHistory().size() - 1)
                showLabel.setText(transactionHistory.getHistory().get(++index));
            else 
                errorAlertbox.display("Error" , "No further history");
        });
//Actions End
        scene1=new Scene(layout1,300,300);
        scene2 =new Scene(layout2,300,300);
        scene3=new Scene(layout3,250,250);
        primaryStage.setScene(scene1);
        primaryStage.show();
      
    }


 }
    

    