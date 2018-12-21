package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Fase;
import View.Iventario;
import View.Tela;
import View.TelaMenu;
import model.Audio;


public class ControleBotao implements ActionListener {
	private TelaMenu menu;
	private ControleFase fase;
	private Tela tela;
	private Iventario iventario;
	private Audio audio;

	public ControleBotao(ControleFase fase, Tela tela, Iventario iventario) {
		super();
		this.menu = tela.getTelaMenu();
		this.fase = fase;
		this.tela= tela;
		this.iventario = iventario;
		audio = new Audio();
		menu.getBtJoga().addActionListener(this);
		menu.getBtSair().addActionListener(this);
		iventario.getVoltar().addActionListener(this);
		
		
		
		
		audio.getMenu().loop();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu.getBtJoga()) {
			tela.getCardlayout().show(tela.getContentPane(), "f");
			fase.start();
			audio.getMenu().stop();
			audio.getFase1().loop();
			iventario.setVisible(true);
			menu.setVisible(false);
		} 
		if(e.getSource() == iventario.getVoltar()) {
			tela.getCardlayout().show(tela.getContentPane(), "m");	
			audio.getFase1().stop();
			audio.getMenu().loop();
			JogoPintura.stop();
		}
		if(e.getSource() == menu.getBtSair()) {
			JogoPintura.stop();
			System.exit(0);
		}
	}
	
	
	
	
	

}
