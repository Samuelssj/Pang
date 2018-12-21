package app;

import java.util.ArrayList;
import java.util.List;

import View.Fase;
import View.Iventario;
import View.Tela;
import controle.ControleBotao;
import controle.ControleFase;
import controle.ControleMovimento;
import controle.ControleTeclado;
import model.FaseModel;
import model.TileMap;
 
public class App {

	public static void main(String[] args) {
		
		FaseModel faseModel = new FaseModel();
		
		List<TileMap>listaCamada = new ArrayList<>();
		
		listaCamada.add(faseModel.getCamada_fundo());
		listaCamada.add(faseModel.getCamada_montanha());
		listaCamada.add(faseModel.getCamada_terra());
		listaCamada.add(faseModel.getCamada_detalhe());
		
		Tela tela = new Tela();
		Fase fase = tela.getFase();
		tela.setVisible(true);
		fase.setVisible(true);
		ControleFase controleFase = new ControleFase(fase, listaCamada,faseModel.getBoneco(),faseModel.getBolas());
		
		new ControleTeclado(faseModel.getBoneco(),fase);
		new ControleBotao(controleFase, tela, fase.getIventario());
		new ControleMovimento(faseModel.getBoneco(),faseModel.getBolas());
		
	}
	
}
