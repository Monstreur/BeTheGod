package menus;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import autres.ButtonArea;

public class CategorieConstruction {
	private Image img;
	private Image background;
	private Image backgroundHover;
	private String name;
	private ButtonArea button;
	private List<BatimentConstruction> batiments;
	
	public CategorieConstruction(String name, String ref){
		try {
			this.img = new Image(ref);
			this.background = new Image("res/img/fondButtonBuildMenu.png");
			this.backgroundHover = new Image("res/img/fondButtonBuildMenuHover.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.name = name;
		this.batiments = new ArrayList<BatimentConstruction>();
		this.batiments.add(new BatimentConstruction("Premier","res/img/build.png"));
		this.batiments.add(new BatimentConstruction("Deuxieme","res/img/build.png"));
		this.batiments.add(new BatimentConstruction("Troisieme","res/img/build.png"));
		this.batiments.add(new BatimentConstruction("Quatrieme","res/img/build.png"));
	}
	
	public ButtonArea getButton() {
		return button;
	}
	public void setButton(int x, int y, int w, int h){
		this.button = new ButtonArea(x, y, w, h);
	}
	public void setButtons(int x, int y){
		int cpt=0;
		for (BatimentConstruction bc : batiments) {
			bc.setButton(x+50+(cpt*130),y+50,100,100);
			cpt++;
		}
	}
	
	public void draw(int x, int y){
		if(this.button.isHover())
			this.backgroundHover.draw(x, y, 100, 100);
		else
			this.background.draw(x, y, 100, 100);
		this.img.draw(x+20, y+5, 60, 60);
	}
	
	public void render(int x, int y){
		int cpt=0;
		for (BatimentConstruction bc : batiments) {
			bc.draw(x+50+(cpt*130),y+50);
			cpt++;
		}
	}

}
