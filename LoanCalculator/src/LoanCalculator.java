import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanCalculator extends JFrame
{
	private JTextField annualInterestRate = new JTextField();
	private JTextField numberOfYears = new JTextField();
	private JTextField loanAmount = new JTextField();
	private JTextField monthlyPayment = new JTextField();
	private JTextField totalPayment = new JTextField();
	
	private JButton button = new JButton("Compute Payment");
	
	public LoanCalculator() 
	{
		JPanel panel = new JPanel(new GridLayout(5,2));
		panel.add(new JLabel("Annual Interest Rate"));
		panel.add(annualInterestRate);
		
		panel.add(new JLabel("Number of Years"));
		panel.add(numberOfYears);
		
		panel.add(new JLabel("Loan Amount"));
		panel.add(loanAmount);
		
		panel.add(new JLabel("Monthly Payment"));
		panel.add(monthlyPayment);
		
		panel.add(new JLabel("Total Payment"));
		panel.add(totalPayment);
		
		
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel2.add(button);
		
		add(panel, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		
		monthlyPayment.enable(false);
		totalPayment.enable(false);
		
		button.addActionListener(new ButtonListener());
		
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double interest = Double.parseDouble(annualInterestRate.getText());
			int year = Integer.parseInt(numberOfYears.getText());
			double loanAmounts = Double.parseDouble(loanAmount.getText());
			
			Loan loan = new Loan(interest, year, loanAmounts);
			
			
			monthlyPayment.setText(String.format("%.2f",loan.getMonthlyPayment()));
			totalPayment.setText(String.format("%.2f",loan.getTotalPayment()));
			
		}
	}

	public static void main(String[] args) 
	{
		LoanCalculator frame = new LoanCalculator();
		frame.setTitle(("Loan Calculator"));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

}
