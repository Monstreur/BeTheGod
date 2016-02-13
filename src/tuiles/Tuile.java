package tuiles;

import org.newdawn.slick.Image;

public abstract class Tuile implements Cloneable{
	
	protected Image img;

	public abstract Tuile cloneme();
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public void draw(int x,int y){
		this.img.draw(x, y);
	}
}
