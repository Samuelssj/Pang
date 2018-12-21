package controle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import View.Fase;
import model.Bolas;
import model.FaseModel;
import model.Personagem;
import model.TileMap;
import model.Tiro;

public class ControleFase extends JogoPintura {

	private BufferedImage imagemMapa;
	private Graphics2D graficosMapa;
	private List<TileMap> listaCamada;
	private Personagem boneco;
	private ArrayList<Bolas> bolas;

	private static int x, y;

	public ControleFase(Fase fase, List<TileMap> listaCamada, Personagem boneco, ArrayList<Bolas> bolas) {
		super(fase);
		this.listaCamada = listaCamada;
		this.boneco = boneco;
		this.bolas = bolas;

//		start(); removido para controlemenu

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		g.drawImage(imagemMapa, x, y, null);
		g.setFont(new Font("serif",Font.BOLD,24));
		g.setColor(Color.GREEN);
		g.drawString("GREEN",45,320);

	}

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		imagemMapa = new BufferedImage(listaCamada.get(0).getLarguraTela(),listaCamada.get(0).getAlturaTela() ,BufferedImage.TYPE_4BYTE_ABGR);
		
		graficosMapa = (Graphics2D) imagemMapa.getGraphics();
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub

		for (TileMap valore : listaCamada) {
			valore.montarMapa();

			graficosMapa.drawImage(valore.getMapa(), 0, 0, null);

		}

		boneco.draw(graficosMapa);
		for (Bolas bola : bolas) {
			bola.draw(graficosMapa);

		}
		for (Tiro tiros : boneco.getTiros()) {
			tiros.draw(graficosMapa);
		}
	}


}
