package autres;

import org.newdawn.slick.geom.Polygon;

@SuppressWarnings("serial")
public class PolygonTuile extends Polygon {
	private int xCadrillage;
	private int yCadrillage;
	public PolygonTuile(int x, int y){
		super(new float[]{0f,16f,32f,0,64f,16f,32f,32f});
		this.xCadrillage=x;
		this.yCadrillage=y;
	}
	
	@Override
	public void setLocation(float x, float y) {
		super.setLocation(x+this.xCadrillage, y+this.yCadrillage);
	}
}
