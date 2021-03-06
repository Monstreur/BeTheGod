package principal;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import autres.ButtonArea;
import batiments.Batiment;
import menus.MenuConstruction;

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
	private TrueTypeFont textBuildButton;
	private TrueTypeFont textBuildButtonOmbre;
	private TrueTypeFont textBuildMenuButtons;
	private Image imgForegroundRessources;
	private Image imgBuildButtonIcon;
	private Image imgBuildButton;
	private Image imgBuildButtonHover;
	private ButtonArea buildButton;
	private boolean buildMenuActive;
	private MenuConstruction menuConstruction;
	private Batiment batimentAcuel;
	private boolean doConstruction;
	
	public Hud() {
		this.nbOr = 0;
		this.stockOr = 0;
		this.nbBois = 0;
		this.stockBois = 0;
		this.nbPierre = 0;
		this.stockPierre = 0;
		this.nbHabitant = 0;
		this.stockHabitant = 0;
		this.buildMenuActive = false;
		try {
			InputStream inputStream = ResourceLoader.getResourceAsStream("res/font/supercell-magic.ttf");
			Font f = Font.createFont(Font.TRUETYPE_FONT, inputStream);
	        f = f.deriveFont(14f); // set font size
	        this.textResource = new TrueTypeFont(f, true);
	        f = f.deriveFont(15f); // set font size
	        this.textResourceOmbre = new TrueTypeFont(f, true);
	        f = f.deriveFont(16f); // set font size
	        this.textBuildButton = new TrueTypeFont(f, true);
	        f = f.deriveFont(17f); // set font size
	        this.textBuildButtonOmbre = new TrueTypeFont(f, true);
	        f = f.deriveFont(10f); // set font size
	        this.textBuildMenuButtons = new TrueTypeFont(f, true);
		} catch (FontFormatException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		
		try {
			this.imgForegroundRessources = new Image("res/img/foregroundBarre.png");
			this.imgBuildButtonIcon = new Image("res/img/build.png");
			this.imgBuildButton = new Image("res/img/buildButton.png");
			this.imgBuildButtonHover = new Image("res/img/buildButtonHover.png");
			this.buildButton = new ButtonArea(910, 650, 100, 100);
		} catch (SlickException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		
		this.menuConstruction = new MenuConstruction(0, 568);
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
	public boolean getDoConstruction() {
		return doConstruction;
	}
	public Batiment getBatimentAcuel() {
		return batimentAcuel;
	}
	
	public void resetBatimentAcuel() {
		this.menuConstruction.resetBatimentChoisi();
	}
	public void resetDoConstruction() {
		this.doConstruction=false;
	}
	
	public void drawOr(Graphics g, int x, int y){
		g.setColor(new Color(246,220,18));
		g.fillRoundRect(x, y, 100, 20, 10);
		
		this.imgForegroundRessources.draw(x-1, y-1, 202, 22);
		
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
		
		this.imgForegroundRessources.draw(x-1, y-1, 202, 22);
		
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
		
		this.imgForegroundRessources.draw(x-1, y-1, 202, 22);
		
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
		
		this.imgForegroundRessources.draw(x-1, y-1, 202, 22);
		
		g.setFont(this.textResourceOmbre);
		g.setColor(new Color(0,0,0));
		g.drawString("1 753 456", x+200-(g.getFont().getWidth("1 753 456")+7), y-1);
		g.setFont(this.textResource);
		g.setColor(new Color(255,255,255));
		g.drawString("1 753 456", x+200-(g.getFont().getWidth("1 753 456")+10), y);
	}
	
	public void drawBuildButton(Graphics g, int x, int y){
		if(this.buildButton.isHover())
			this.imgBuildButtonHover.draw(x,y,100,100);
		else
			this.imgBuildButton.draw(x,y,100,100);

		g.setFont(this.textBuildButtonOmbre);
		g.setColor(new Color(0,0,0));
		g.drawString("Achat", x+(100/2)-(g.getFont().getWidth("Achat")/2),y+100-(g.getFont().getHeight("Achat")+5));
		g.setFont(this.textBuildButton);
		g.setColor(new Color(255,255,255));
		g.drawString("Achat", x+(100/2)-(g.getFont().getWidth("Achat")/2),y+100-(g.getFont().getHeight("Achat")+5));
		
		this.imgBuildButtonIcon.draw(x+20,y+5,60,60);
	}
	
	
	public void drawBuildMenu(Graphics g, int x, int y){
		g.setFont(this.textBuildMenuButtons);
		this.menuConstruction.render(g, x, y);
	}
	
	public void render(Graphics g, int mouseX, int mouseY, float scale, float xCam, float yCam){
    	if(this.batimentAcuel!=null && !this.buildButton.isHover()){
    	    /****** FINIR LE SCALE ******/
    		g.scale(scale, scale);
    		int numTuileY = mouseY/((int)(16*scale));
    		int decallageX = (numTuileY%2==0) ? 0 : (int)(32*scale);
    		int decallageCamX = ((int)xCam)%((int)(64*scale));
    		int decallageCamY = ((int)yCam)%((int)(32*scale))+8;
    		this.batimentAcuel.renderBuild(g, ((int)mouseX/((int)(64*scale)))*((int)(64*scale))+decallageX-decallageCamX, ((int)mouseY/((int)(16*scale)))*((int)(16*scale))-decallageCamY,scale,xCam,yCam);
        	g.scale(1/scale, 1/scale);
    	}
		
		this.drawOr(g,30,15);
		this.drawBois(g,260,15);
		this.drawPierre(g,490,15);
		this.drawHabitant(g,720,15);
		
		if(this.buildMenuActive)
			this.drawBuildMenu(g, 0, 568);
		else
			this.drawBuildButton(g, 910, 650);
	}
	
	public void mousePressed(int button, int x, int y) {
		if(this.buildMenuActive){
			if(this.menuConstruction.mousePressed(button, x, y))
				this.buildMenuActive=false;
		}else{
			if(this.buildButton.contain(x,y) && button==0){
				this.buildMenuActive = true;
				this.menuConstruction.resetBatimentChoisi();
				this.buildButton.setHover(false);
			}
			if(this.batimentAcuel!=null && !this.buildButton.isHover() && button==0){
				this.doConstruction=true;
			}
		}
    }
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
    	if(this.buildMenuActive){
    		this.menuConstruction.mouseMoved(oldx, oldy, newx, newy);
    	}else{
			if(this.buildButton.contain(newx,newy))
				this.buildButton.setHover(true);
			else
				this.buildButton.setHover(false);
    	}
    }

	public void update(GameContainer container, int delta) {
		this.batimentAcuel=this.menuConstruction.getBatimentChoisi();
		if(this.batimentAcuel!=null){
			this.buildMenuActive=false;
		}
	}
	
}
