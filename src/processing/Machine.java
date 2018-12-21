package processing;

import display.Calculator;

import javax.swing.*;

public class Machine {
	private Calculator cal;
	
	private estados[][] mTrans={{estados.inicial,			estados.operacao,		null},
								{estados.novadigitacao,		null,					null},
								{estados.novadigitacao,		estados.novaoperacao,	estados.fim},
								{estados.novadigitacao,		null,					null}};

	public estados estadoIni=estados.inicial;
	public estados estadoAtual=estadoIni;
    public String charDigitado;
	public double acumulador;
	
	private operacoes operacaoAtual;
	private int command=0;
	private boolean checkDisplay;
	
	public Machine(Calculator cal){
		this.cal=cal;
	}
	public enum estados{
		inicial(0),
		operacao(1),
		novadigitacao(2),
		novaoperacao(3),
		fim(4);
		private final int mask;
        estados(int mask){
            this.mask=mask;
        }
        private int getMask(){
        	return mask;
        }
	}
	private enum operacoes{
		soma(0),
		sub(1),
		mul(2),
		div(3);
		private final int mask;
        operacoes(int mask){
            this.mask=mask;
        }
        private int getMask(){
        	return mask;
        }
	}
	private int transicao(int go){
		estadoAtual=mTrans[estadoAtual.getMask()][go];
		System.out.printf("esse estado (%s).\n",estadoAtual.toString());
		return estadoAtual.getMask();
	}
	public void CalculatorMachine(){
		escolherIndice();
		try{
			transicao(command);	
			switch(estadoAtual){
				case inicial:
					if(checkDisplay){
						cal.textField.setText(null);
						checkDisplay=false;
					}
					cal.textField.setText(cal.textField.getText()+charDigitado);
				break;
				case operacao:
					escolherOperacao();
					cal.textField.setText(null);
				break;
				case novadigitacao:
					if(checkDisplay){
						cal.textField.setText(null);
						checkDisplay=false;
					}
					cal.textField.setText(cal.textField.getText()+charDigitado);
				break;
				case novaoperacao:
					checkDisplay=true;
					realizarOperacao();
					escolherOperacao();
				break;
				case fim:
					realizarOperacao();
					estadoAtual=estados.inicial;
					checkDisplay=true;
				break;
				default:
					estadoAtual=estados.inicial;
					cal.textField.setText("Error");
			}
		}catch(Exception er){
			JOptionPane.showMessageDialog(null,"Error");
			estadoAtual=estados.inicial;
			checkDisplay=true;
		}
	}
	private int escolherOperacao(){
		switch(charDigitado){
			case "+":
				operacaoAtual=operacoes.soma;
			break;
			case "-":
				operacaoAtual=operacoes.sub;
			break;
			case "*":
				operacaoAtual=operacoes.mul;
			break;
			case "/":
				operacaoAtual=operacoes.div;
			break;
		}
		acumulador=Double.parseDouble(cal.textField.getText());
		return operacaoAtual.getMask();
	}
	private void realizarOperacao(){
		Process op=new Process();
		switch(operacaoAtual){
			case soma:
				op.soma(acumulador,Double.parseDouble(cal.textField.getText()));
			break;
			case sub:
				op.sub(acumulador,Double.parseDouble(cal.textField.getText()));
			break;
			case mul:
				op.mul(acumulador,Double.parseDouble(cal.textField.getText()));
			break;
			case div:
				op.div(acumulador,Double.parseDouble(cal.textField.getText()));
			break;	
		}
		acumulador=op.resultado;
		cal.textField.setText(Double.toString(op.resultado));
	}
	private int escolherIndice(){
		try{
			int test=Integer.parseInt(charDigitado);
			switch(test){
				case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
					command=0;
				break;
			}
		}catch(Exception er){
			switch(charDigitado){
				case "+":
					command=1;
				break;
				case "-":
					command=1;
				break;
				case "*":
					command=1;
				break;
				case "/":
					command=1;
				break;
				case "=":
					command=2;
				break;
			}
		}
		return command;
	}
}
