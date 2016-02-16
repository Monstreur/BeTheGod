package menus;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import autres.ButtonArea;

public class BatimentConstruction {
	private Image img;
	private Image background;
	private Image backgroundHover;
	private String name;
	private ButtonArea button;
	
	public BatimentConstruction(String name, String ref){
		try {
			this.img = new Image(ref);
			this.background = new Image("res/img/fondButtonBuildMenu.png");
			this.backgroundHover = new Image("res/img/fondButtonBuildMenuHover.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.name=name;
	}
	
	public void setButton(int x, int y, int w, int h){
		this.button = new ButtonArea(x, y, w, h);
	}
	
	public void draw(int x, int y){
		if(this.button.isHover())
			this.backgroundHover.draw(x, y, 100, 100);
		else
			this.background.draw(x, y, 100, 100);
		this.img.draw(x+20, y+5, 60, 60);
	}
	
}
