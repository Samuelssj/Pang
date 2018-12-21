package model;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;

public class Bolas extends Sprite {
	private boolean ativo = true;
	private int ativob = 0;
	

	protected Bolas(int aparencia, int largura, int altura, int colunas, int linhas, int x, int y, String endereco)
			throws IOException {
		super(aparencia, largura, altura, colunas, linhas, x, y, endereco);
		
		if(new Random().nextBoolean())
			setDirecao(-1);
		else
			setDirecao(1);
	}

	@Override
	public void animar(String direcao) {
		
	}

	@Override
	public void draw(Graphics g) {
		if(ativo == true) {
		g.drawImage(getSprites()[getAparencia()], getX(),getY(), null);
		}
		}
		

	public void mover() {
		setX(getX()+ super.getDirecao());
	}
	@Override
	public void mover(String direcao) {
		switch (direcao) {
		case "esquerda":
			setX(getX()-super.getDirecao());
			
			break;
		case "direita":
			setX(getX()+super.getDirecao());

		//case "Baixo":
	//		setY(getY()+1);
//		case "cima":
//			setX(getX()+0);

		default:
			break;
		}
		
		
		
		
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getAtivob() {
		return ativob;
	}

	public void setAtivob(int ativob) {
		this.ativob = ativob;
	}
	

	
	
}
