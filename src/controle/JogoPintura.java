package controle;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import View.Fase;


public abstract class JogoPintura implements Runnable {

	private Fase fase;


	protected Graphics2D graficos;
	protected Thread thread;
	private final int FPS = 30;
	private Double averageFPS;
	protected static boolean loop;

	public JogoPintura(Fase fase) {
		super();
		this.fase = fase;
		stop();
	}


	public abstract void draw(Graphics g);
	public abstract void inicializar();
	public abstract void atualizar();

	@Override
	public void run() {

		inicializar();

		graficos = (Graphics2D) fase.getGraficosTela();
		fase.requestFocus();


		//			long startTime;
		//			long URDTimeMillis;
		//			long waitTime;
		//			long totalTime = 0;
		//
		//			int frameCount = 0;
		//			int maxFrameCount = 30;
		//
		//			long tragetTime = 1000 / FPS;

		while(true)
		{		
			//				startTime = System.nanoTime();

			if(loop)
			{
				fase.repaint();	//Dedesenha o plano de fundo 				
				atualizar();//Desenha as camadas 
				draw(graficos);//Desenha a imagem do mapa
				
			}

			//				URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
			//				waitTime = tragetTime - URDTimeMillis;

			try {
				Thread.sleep(50);
			} catch (Exception e) {
			}

			//				totalTime += System.nanoTime() - startTime;
			//				frameCount++;
			//
			//				if (frameCount == maxFrameCount) {
			//					averageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
			//					frameCount = 0;
			//					totalTime = 0;
			//				}
			//				gameDraw();
		}


	}
	public void start() {
		if(thread== null) {
			thread = new Thread(this);
			thread.start();
		}
		loop = true;
		fase.requestFocus();

	}

	public static void stop()
	{
		loop = false;
	}
	
}