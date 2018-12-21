package model;

import java.awt.Graphics;
import java.io.IOException;

public class Tiro extends Sprite {

	private boolean ativo;

	protected Tiro(int aparencia, int largura, int altura, int colunas, int linhas, int x, int y, String endereco)
			throws IOException {
		super(aparencia, largura, altura, colunas, linhas, x, y, endereco);
		ativo = false;
		
	}

	@Override
	public void animar(String direcao) {
		
		setAparencia(getAparencia() + 1);
		switch (direcao) {
		case "Atirar":
			if (getAparencia() < 2 || getAparencia() > 5) {
				setAparencia(3);
			}

			break;

		}

	}

	@Override
	public void draw(Graphics g) {
		if (ativo == true) {
			g.drawImage(getSprites()[getAparencia()], getX(), getY(), null);
		}

	}

	@Override
	public void mover(String direcao) {
		switch (direcao) {
		case "Atirar":
			setY(getY()-3);

			break;

		}
	}

	public boolean isAtivo() {
		return ativo;
	}

	
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
