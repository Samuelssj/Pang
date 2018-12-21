package controle;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;

import javax.swing.BoundedRangeModel;

import org.omg.CORBA.Request;

import model.Audio;
import model.Bolas;
import model.FaseModel;
import model.Personagem;
import model.Sprite;
import model.Tiro;

public class ControleMovimento extends Thread {
	private Personagem sprite;
	private ArrayList<Bolas> bolas;
	private boolean direcao = true;
	private Audio audio;

	public ControleMovimento(Personagem sprite, ArrayList<Bolas> bolas) {
		this.bolas = bolas;
		this.sprite = sprite;
		audio = new Audio();
		start();
		
	}

	@Override
	public void run() {
		while (true) {

			try {
				sleep(25);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			for (Bolas bola : bolas) {

				if (sprite.getBounds().intersects(bola.getBounds())) {
					sprite.setAparencia(10);
				}
				for (Rectangle colisao : FaseModel.colisao) {
					if (bola.getBounds().intersects(colisao)) {
						if (direcao)
							direcao = false;
						else
							direcao = true;
						bola.mover("Baixo");

					}
				}
				if (bola.getX() < 20 || bola.getX() > 694)
					bola.setDirecao(bola.getDirecao() * -1);
				bola.mover();

				for (Tiro tiro : sprite.getTiros()) {
					if (tiro.isAtivo()) {
						
						tiro.mover("Atirar");
						
						tiro.animar("Atirar");
						
						if (tiro.getY() <= 0) {
							tiro.setAtivo(false);
							
						}

						if (bola.isAtivo()) {// ver se a bola esta ativa

							if (tiro.getBounds().intersects(bola.getBounds())) {// colisao
								if (bola.isAtivo()) {
									tiro.setAtivo(false);
									bola.setAparencia(3);
								}
								try {
									if (bola.isAtivo()) {
										audio.getEstouro().play();
									}
									sleep(100);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								bola.setAtivo(false);

							}
						}

					}
				}
			}

		}

	}

}
