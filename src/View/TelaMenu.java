package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class TelaMenu  extends PanelGeral{
	
	private JButton btJoga,btContinuar, btSair,btOpcoes;
	private JLabel img;
	public TelaMenu() {
		
		setLayout(null);
		
		btJoga = new JButton(new ImageIcon(getClass().getClassLoader().getResource("balaoRed.png")));
		btJoga.setBounds(460, 220, 157, 250);
		btJoga.setBorder(null);
		btJoga.setBorderPainted(false);
		btJoga.setContentAreaFilled(false);
		btJoga.setOpaque(false);
		btJoga.setBackground(null);
		add(btJoga);

		btSair = new JButton(new ImageIcon(getClass().getClassLoader().getResource("balaoVerde.png")));
		btSair.setBounds(740, 220, 157, 250);
		btSair.setBorder(null);
		btSair.setBorderPainted(false);
		btSair.setOpaque(false);
		btSair.setContentAreaFilled(false);
		btSair.setBackground(null);
		add(btSair);
		
		btContinuar = new JButton("Creditos");
		btContinuar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btContinuar.setBounds(263, 203, 161, 49);
		//add(btContinuar);
		
		btOpcoes = new JButton("Op\u00E7oes");
		btOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btOpcoes.setBounds(263, 116, 161, 41);
		//add(btOpcoes);
		
		img = new JLabel( new ImageIcon(getClass().getClassLoader().getResource("menu.jpg")));
		img.setBounds(0, 0, TelaGeral.LARGURA, TelaGeral.ALTURA);
		add(img);
		
		
	}

	public JButton getBtJoga() {
		return btJoga;
	}

	public JButton getBtContinuar() {
		return btContinuar;
	}

	public JButton getBtSair() {
		return btSair;
	}
	 
	

}
