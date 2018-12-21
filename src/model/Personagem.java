package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Personagem extends Sprite {

	private ArrayList<Tiro> tiros;
	private int municao = 0;

	protected Personagem(int aparencia, int largura, int altura, int colunas, int linhas, int x, int y, String endereco)
			throws IOException {
		super(aparencia, largura, altura, colunas, linhas, x, y, endereco);
		this.tiros = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			tiros.add(new Tiro(0, 251, 163, 7, 1, x, y, "FOGO.png"));
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void animar(String direcao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(getSprites()[getAparencia()], getX(), getY(), null);

	}

	@Override
	public void mover(String direcao) {

	}

	public void atirar() {

		if (municao < 5) {
		

			tiros.get(municao).setAtivo(true);
			tiros.get(municao).setX(getX());
			tiros.get(municao).setY(getY() + getLarguraPersonagem());
			municao++;
		} else if (municao >= 5) {
			municao = 0;

		}

	}

	public ArrayList<Tiro> getTiros() {
		return tiros;
	}

//	public boolean collision(List<Rectangle> tmp, int x,int y) {
//
//		Rectangle personagem = new Rectangle(getX()+x, getY()+y, 
//				getLarguraPersonagem(), getAlturaPersonagem());
//		for(Rectangle rectangle : tmp) {
//			if(rectangle.intersects(personagem)){
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@Override
//	public void setX(int x) {
//		if(!collision(FaseModel.colisao, x-getX(), 0))
//			super.setX(x);//this.x = x;
//
//	}
//
//	@Override
//	public void setY(int y) {
//		if(!collision(FaseModel.colisao, 0, y-getY()))
//			super.setY(y);//this.y = y;
//	}

}
