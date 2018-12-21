package model;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FaseModel {
	
	private TileMap Camada_detalhe;
	private TileMap Camada_terra;
	private TileMap Camada_montanha;
	private TileMap Camada_fundo;
	private Personagem boneco; 
	private ArrayList<Bolas> bolas;
	public static ArrayList<Rectangle> colisao;
	
	public FaseModel() {
		super();
		
		
		Camada_detalhe = new TileMap(25, 25, 30, 30, "tileset.png", "Camada_detalhe.txt");
		Camada_terra = new TileMap(25, 25, 30, 30, "tileset.png", "Camada_terra.txt");
		Camada_montanha = new TileMap(25, 25, 30, 30, "tileset.png", "Camada_montanha.txt");
		Camada_fundo = new TileMap(25, 25, 30, 30, "tileset.png", "Camada_fundo.txt");
		colisao = (ArrayList<Rectangle>) Camada_detalhe.montarColisao();


		
		try {
			bolas = new ArrayList<>(3);
			for(int i = 0; i < 3; i++)
			{
				bolas.add(new Bolas(i, 252, 90, 4, 1,  50+(50*i), i+(80*i), "bolaG.png"));
			}
			
//			Map<String, Bolas> bol = new HashMap<>();
//			
//			bol.put("GREEN", new Bolas(0, 252, 90, 4, 1,  0, 0, "bolaG.png"));
//			bol.put("RED", new Bolas(1, 252, 90, 4, 1,  0, 0, "bolaG.png"));
//			bol.put("BLUE",new Bolas(2, 252, 90, 4, 1,  0, 0, "bolaG.png"));
			
//			Map<String, Color> cor = new HashMap<>();
//			
//			cor.put("GREEN", Color.GREEN);
//			cor.put("RED", Color.RED);
//			g.setColor(cor.get("GREEN"));
			
			boneco = new Personagem(0, 328, 123, 6, 2, 400, 332, "boneco.png");
	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	public Personagem getBoneco() {
		return boneco;
	}

	


	public ArrayList<Bolas> getBolas() {
		return bolas;
	}




	public static ArrayList<Rectangle> getColisao() {
		return colisao;
	}




	public TileMap getCamada_detalhe() {
		return Camada_detalhe;
	}


	public TileMap getCamada_terra() {
		return Camada_terra;
	}


	public TileMap getCamada_montanha() {
		return Camada_montanha;
	}


	public TileMap getCamada_fundo() {
		return Camada_fundo;
	}



	

}
