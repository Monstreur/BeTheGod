package batiments;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import autres.ZoneTuile;

public class Batiment {
	private Image img;
	private String name;
	private ZoneTuile zone;

	public int getX() {
		return this.zone.getX();
	}
	public int getY() {
		return this.zone.getY();
	}
	
	public Batiment(){
		try {
			this.img = new Image("res/img/batiment1/EST.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.name = "Foreuse d'or";
		this.zone = new ZoneTuile(12,2);
		
	}
	public void render(){
		this.img.draw(this.zone.getX(), this.zone.getY());
	}
	
	public void renderBuild(Graphics g,int x,int y,float scale,float xCam,float yCam){
		this.zone.render(g, x, y, xCam, yCam);
		this.img.draw(x, y,new Color(0f,1f,0f,0.5f));
	}
	
	
}
