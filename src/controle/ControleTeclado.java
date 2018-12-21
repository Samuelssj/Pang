package controle;

import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import View.Fase;
import model.Audio;
import model.Personagem;
import model.Sprite;

public class ControleTeclado implements KeyListener{
	private Personagem sprite;
	private Fase fase;
	private int esquerda, direita;
	
	public ControleTeclado(Personagem sprite, Fase fase) {
		this.sprite = sprite;
		this.fase = fase;
		//fase.requestFocus();
		fase.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() != sprite.getDirecao())
			sprite.setDirecaoAnterior(sprite.getDirecao());

		sprite.setDirecao(e.getKeyCode());
		
		if (KeyEvent.VK_A == sprite.getDirecao()) { // index 1 referente a telca para direita
			sprite.setX(sprite.getX() - 5);
			switch (esquerda) {
			case 0:
				sprite.setAparencia(4);
				break;
			case 1:
				sprite.setAparencia(6);
				break;
			case 2:
				sprite.setAparencia(8);
				break;
			
		
			}
			if (esquerda == 2)
				esquerda = 0;
			else
				esquerda++;
			sprite.setOlhandoE(1);
			sprite.setOlhandoD(0);

		} else if (KeyEvent.VK_D == sprite.getDirecao()) { // index 3 referente a telca para esquerda
			sprite.setX(sprite.getX() + 5);
			switch (direita) {
			case 0: 
				sprite.setAparencia(1);
				break;
			case 1:
				sprite.setAparencia(3);
				break;
			case 2:
				sprite.setAparencia(5);
				break;
		
			}
			if (direita == 2)
				direita = 0;
			else
				direita++;
			sprite.setOlhandoE(0);
			sprite.setOlhandoD(1);
		}
		if (sprite.getX() < 20) {
			sprite.setX(20);
			sprite.setAparencia(0);
		} else if (sprite.getX() > 694) {
			sprite.setX(694);
		}
		//System.out.println(sprite.getX() + "," + sprite.getY()); // 694
		if (KeyEvent.VK_SPACE == sprite.getDirecao()) { // index 1 referente a telca para direita
			sprite.atirar();
			if (sprite.getOlhandoE() == 1) {
				
				
				sprite.setAparencia(11);

			} else
				sprite.setAparencia(9);

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(sprite.getDirecao() == KeyEvent.VK_SPACE) {
			if(sprite.getOlhandoE() == 1) {
			sprite.setAparencia(0);
			sprite.setDirecao(-1);
			}
			else
				sprite.setAparencia(7);
				sprite.setDirecao(-1);
		}
		if(sprite.getDirecao() == KeyEvent.VK_D) {
			sprite.setDirecao(-1);
		}else
			sprite.setDirecao(-1);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
