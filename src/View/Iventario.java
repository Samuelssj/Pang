package View;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Iventario extends PanelGeral{
	
	private JLabel time;
	private JButton voltar;
 
	public Iventario() {
		super();
		this.time = new JLabel();
		this.voltar = new JButton("Sair");
		setBackground(Color.GRAY);
		voltar.setFocusable(false);
		add(time);
		add(voltar);
		setVisible(true);
		
	}
	public JLabel getTime() {
		return time;
	}
	public void setTime(JLabel time) {
		this.time = time;
	}
	public JButton getVoltar() {
		return voltar;
	}
	public void setVoltar(JButton voltar) {
		this.voltar = voltar;
	}
	

}
