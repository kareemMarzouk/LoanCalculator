import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class LoanCalculator extends Application 
{
	private TextField interestRate = new TextField();
	private TextField numberOfYears = new TextField();
	private TextField loanAmount = new TextField();
	private TextField monthlyPayment = new TextField();
	private TextField totalPayment = new TextField();
	private Button computePayment = new Button("Compute Payment");

	@Override
	public void start(Stage primaryStage)
	{
		//GUI
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label ("Annual Interest Rate"), 0, 0);
		gridPane.add(interestRate, 1, 0);
		gridPane.add(new Label ("Number of Years"), 0, 1);
		gridPane.add(numberOfYears, 1, 1);
		gridPane.add(new Label ("Loan Amount"), 0, 2);
		gridPane.add(loanAmount, 1, 2);
		gridPane.add(new Label("Monthly Payment"), 0, 3);
		gridPane.add(monthlyPayment, 1, 3);
		gridPane.add(new Label("Total Payment"), 0, 4);
		gridPane.add(totalPayment, 1, 4);
		gridPane.add(computePayment, 1, 5);
		
		//GUI properties
		gridPane.setAlignment(Pos.CENTER);
		interestRate.setAlignment(Pos.BOTTOM_LEFT);
		numberOfYears.setAlignment(Pos.BOTTOM_LEFT);
		loanAmount.setAlignment(Pos.BOTTOM_LEFT);
		monthlyPayment.setAlignment(Pos.BOTTOM_LEFT);
		totalPayment.setAlignment(Pos.BOTTOM_LEFT);
		monthlyPayment.setEditable(false);
		totalPayment.setEditable(false);
		GridPane.setHalignment(computePayment, HPos.LEFT);
		
		//Lambda
		computePayment.setOnAction(e -> { calculatePayment();});
		
		//scenes
		Scene scene = new Scene (gridPane,400,300);
		primaryStage.setTitle("Loan Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	private void calculatePayment() 
	{
		//get the values from text fields
		double annualInterestRate = Double.parseDouble(interestRate.getText());
		int years = Integer.parseInt(numberOfYears.getText());
		double amountOfLoan = Double.parseDouble(loanAmount.getText());
		
		//create loan
		Loan loan = new Loan(annualInterestRate, years, amountOfLoan);
		
		//display monthly and total payment
		monthlyPayment.setText(String.format("$%.2f", loan.getMonthlyPayment()));
		totalPayment.setText(String.format("$%.2f", loan.getTotalPayment()));
		
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
    
}
