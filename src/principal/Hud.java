package principal;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.Color;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.OutlineEffect;
import org.newdawn.slick.util.ResourceLoader;

public class Hud {
	private int nbOr;
	private int stockOr;
	private int nbBois;
	private int stockBois;
	private int nbPierre;
	private int stockPierre;
	private int nbHabitant;
	private int stockHabitant;
	private TrueTypeFont textResource;
	private TrueTypeFont textResourceOmbre;
	
	public Hud() {
		this.nbOr = 0;
		this.stockOr = 0;
		this.nbBois = 0;
		this.stockBois = 0;
		this.nbPierre = 0;
		this.stockPierre = 0;
		this.nbHabitant = 0;
		this.stockHabitant = 0;
		try {
			InputStream inputStream = ResourceLoader.getResourceAsStream("res/font/supercell-magic.ttf");
			Font f = Font.createFont(Font.TRUETYPE_FONT, inputStream);
	        f = f.deriveFont(14f); // set font size
	        this.textResource = new TrueTypeFont(f, true);
	        f = f.deriveFont(15.49f); // set font size
	        this.textResourceOmbre = new TrueTypeFont(f, true);
		} catch (FontFormatException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
	}

	public int getNbOr() {
		return nbOr;
	}
	public int getStockOr() {
		return stockOr;
	}
	public int getNbBois() {
		return nbBois;
	}
	public int getStockBois() {
		return stockBois;
	}
	public int getNbPierre() {
		return nbPierre;
	}
	public int getStockPierre() {
		return stockPierre;
	}
	public int getNbHabitant() {
		return nbHabitant;
	}
	public int getStockHabitant() {
		return stockHabitant;
	}
	
	public void drawOr(Graphics g, int x, int y){
		g.setColor(new Color(246,220,18));
		g.fillRoundRect(x, y, 100, 20, 10);
		
		g.setColor(new Color(205,183,8));
		g.setLineWidth(g.getLineWidth()*2);
		g.drawRoundRect(x, y, 200, 20, 10);
		g.setLineWidth(g.getLineWidth()/2);
		
		g.setFont(this.textResourceOmbre);
		g.setColor(new Color(0,0,0));
		g.drawString("12 525", x+200-(g.getFont().getWidth("12 525")+9), y-1);
		g.setFont(this.textResource);
		g.setColor(new Color(255,255,255));
		g.drawString("12 525", x+200-(g.getFont().getWidth("12 525")+10), y);
	}
	public void drawBois(Graphics g, int x, int y){
		g.setColor(new Color(182,155,76));
		g.fillRoundRect(x, y, 150, 20, 10);
		
		g.setColor(new Color(129,109,53));
		g.setLineWidth(g.getLineWidth()*2);
		g.drawRoundRect(x, y, 200, 20, 10);
		g.setLineWidth(g.getLineWidth()/2);
		
		g.setFont(this.textResourceOmbre);
		g.setColor(new Color(0,0,0));
		g.drawString("9 656", x+200-(g.getFont().getWidth("9 656")+8), y-1);
		g.setFont(this.textResource);
		g.setColor(new Color(255,255,255));
		g.drawString("9 656", x+200-(g.getFont().getWidth("9 656")+10), y);
	}
	public void drawPierre(Graphics g, int x, int y){
		g.setColor(new Color(163,165,149));
		g.fillRoundRect(x, y, 150, 20, 10);
		
		g.setColor(new Color(139,142,121));
		g.setLineWidth(g.getLineWidth()*2);
		g.drawRoundRect(x, y, 200, 20, 10);
		g.setLineWidth(g.getLineWidth()/2);
		
		g.setFont(this.textResourceOmbre);
		g.setColor(new Color(0,0,0));
		g.drawString("233", x+200-(g.getFont().getWidth("233")+8), y-1);
		g.setFont(this.textResource);
		g.setColor(new Color(255,255,255));
		g.drawString("233", x+200-(g.getFont().getWidth("233")+10), y);
	}
	public void drawHabitant(Graphics g, int x, int y){
		g.setColor(new Color(82, 197, 76));
		g.fillRoundRect(x, y, 150, 20, 10);
		
		g.setColor(new Color(53,148,48));
		g.setLineWidth(g.getLineWidth()*2);
		g.drawRoundRect(x, y, 200, 20, 10);
		g.setLineWidth(g.getLineWidth()/2);
		
		g.setFont(this.textResourceOmbre);
		g.setColor(new Color(0,0,0));
		g.drawString("1 753 456", x+200-(g.getFont().getWidth("1 753 456")+7), y-1);
		g.setFont(this.textResource);
		g.setColor(new Color(255,255,255));
		g.drawString("1 753 456", x+200-(g.getFont().getWidth("1 753 456")+10), y);
	}
	
	public void render(Graphics g, int x, int y){
		this.drawOr(g,x+30,y+15);
		this.drawBois(g,x+260,y+15);
		this.drawPierre(g,x+490,y+15);
		this.drawHabitant(g,x+720,y+15);
	}
}
