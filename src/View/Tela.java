package View;

public class Tela extends TelaGeral {

	
	private TelaMenu telaMenu;
	private Fase fase;
	

	public Tela() {
		
		telaMenu = new TelaMenu();
		fase = new Fase();
		
		 add(telaMenu, "m");
		 add(fase, "f");
		 
		 getCardlayout().show(getContentPane(), "m");
		
	}
	
	
	
	public Fase getFase() {
		return fase;
	}



	public TelaMenu getTelaMenu() {
		return telaMenu;
	}

	
	
}
