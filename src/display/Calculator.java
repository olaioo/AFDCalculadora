package display;

import processing.Machine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
	private Machine mac=new Machine(this);
    
	private JButton num0,num1,num2,num3,num4,num5,num6,num7,num8,num9,btSoma,btSub,btMul,btDiv,btEquals,btClear;
	private JFrame frame=new JFrame("Calculadora");
	public JTextField textField=new JTextField();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setSize(325,230);
					window.frame.setLocationRelativeTo(null);
					window.frame.setResizable(false);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Calculator() {
		initialize();
	}
	private void initialize() {		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setBounds(12, 12, 298, 45);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		num7 = new JButton("7");
		num7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=num7.getText();
				mac.CalculatorMachine();
			}
		});
		num7.setBounds(12, 69, 71, 25);
		frame.getContentPane().add(num7);
		
		num8 = new JButton("8");
		num8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=num8.getText();
				mac.CalculatorMachine();
			}
		});
		num8.setBounds(95, 69, 71, 25);
		frame.getContentPane().add(num8);
		
		num9 = new JButton("9");
		num9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=num9.getText();
				mac.CalculatorMachine();
			}
		});
		num9.setBounds(178, 69, 71, 25);
		frame.getContentPane().add(num9);
		
		num6 = new JButton("6");
		num6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=num6.getText();
				mac.CalculatorMachine();
			}
		});
		num6.setBounds(12, 101, 71, 25);
		frame.getContentPane().add(num6);
		
		num5 = new JButton("5");
		num5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=num5.getText();
				mac.CalculatorMachine();
			}
		});
		num5.setBounds(95, 101, 71, 25);
		frame.getContentPane().add(num5);
		
		num4 = new JButton("4");
		num4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=num4.getText();
				mac.CalculatorMachine();
			}
		});
		num4.setBounds(178, 101, 71, 25);
		frame.getContentPane().add(num4);
		
		num1 = new JButton("1");
		num1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=num1.getText();
				mac.CalculatorMachine();
			}
		});
		num1.setBounds(12, 134, 71, 25);
		frame.getContentPane().add(num1);
		
		num2 = new JButton("2");
		num2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=num2.getText();
				mac.CalculatorMachine();
			}
		});
		num2.setBounds(95, 134, 71, 25);
		frame.getContentPane().add(num2);
		
		num3 = new JButton("3");
		num3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=num3.getText();
				mac.CalculatorMachine();
			}
		});
		num3.setBounds(178, 134, 71, 25);
		frame.getContentPane().add(num3);
		
		num0 = new JButton("0");
		num0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=num0.getText();
				mac.CalculatorMachine();
			}
		});
		num0.setBounds(95, 167, 71, 25);
		frame.getContentPane().add(num0);
		
		btSoma = new JButton("+");
		btSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=btSoma.getText();
				mac.CalculatorMachine();
			}
		});
		btSoma.setBounds(261, 69, 49, 25);
		frame.getContentPane().add(btSoma);
		
		btSub = new JButton("-");
		btSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=btSub.getText();
				mac.CalculatorMachine();
			}
		});
		btSub.setBounds(261, 101, 49, 25);
		frame.getContentPane().add(btSub);
		
		btMul = new JButton("*");
		btMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=btMul.getText();
				mac.CalculatorMachine();
			}
		});
		btMul.setBounds(261, 134, 49, 25);
		frame.getContentPane().add(btMul);
		
		btDiv = new JButton("/");
		btDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=btDiv.getText();
				mac.CalculatorMachine();
			}
		});
		btDiv.setBounds(261, 167, 49, 25);
		frame.getContentPane().add(btDiv);
		
		btEquals = new JButton("=");
		btEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mac.charDigitado=btEquals.getText();
				mac.CalculatorMachine();
			}
		});
		btEquals.setBounds(178, 167, 71, 25);
		frame.getContentPane().add(btEquals);
		
		btClear = new JButton("Clear");
		btClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				mac.estadoAtual=mac.estadoIni;
				mac.acumulador=0;
			}
		});
		btClear.setBounds(12, 167, 71, 25);
		frame.getContentPane().add(btClear);
	}
	
}
