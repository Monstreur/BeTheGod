package autres;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class ZoneTuile {
	private int nbCaseW;
	private int nbCaseH;
	private int x;
	private int y;
	private List<PolygonTuile> tuiles;
	
	public ZoneTuile(int nbCaseW, int nbCaseH){
		this.nbCaseW=nbCaseW;
		this.nbCaseH=nbCaseH;
		this.createTuiles();
	}
	
	public int getNbCaseW() {
		return nbCaseW;
	}
	public void setNbCaseW(int nbCaseW) {
		this.nbCaseW = nbCaseW;
	}
	public int getNbCaseH() {
		return nbCaseH;
	}
	public void setNbCaseH(int nbCaseH) {
		this.nbCaseH = nbCaseH;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public int getWidth(){
		return (this.nbCaseW-1+this.nbCaseH-1)*32+64;
	}

	public int getHeight(){
		return (this.nbCaseW-1+this.nbCaseW-1)*16+32;
	}
	
	public void createTuiles(){
		this.tuiles = new ArrayList<PolygonTuile>();
		for(int i = this.nbCaseH-1; i>=0; i--){
			for(int j = 0; j<this.nbCaseW; j++){
				this.tuiles.add(new PolygonTuile(32*(j+(this.nbCaseH-(i+1))),16*(j+i)));
			}
		}
	}
	
	public void render(Graphics g, int x, int y, float xCam, float yCam){
		this.x=x+(int)xCam;
		this.y=y+(int)yCam;
		for (PolygonTuile pt : tuiles) {
			pt.setLocation(x, y);
			g.setColor(new Color(0,200,0,75));
			g.fill(pt);
			g.draw(pt);
		}
	}
	/*
	public void renderCentered(Graphics g, int x, int y, float scale){
		for (PolygonTuile pt : tuiles) {
			pt.setLocation(x-((int)(this.getWidth()/2)*scale), y-((int)(this.getHeight()/2)*scale));
			g.setColor(new Color(0,200,0,75));
			g.fill(pt);
			g.draw(pt);
		}
	}
	*/
	
}
