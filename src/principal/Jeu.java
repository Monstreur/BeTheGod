package principal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import batiments.BatimentsManager;
import configuration.Config;
import configuration.Touche;
import entities.Map;

public class Jeu {
	private Config config;
	private Map m;
	private Hud hud;
	private BatimentsManager batMan;
	
	public Jeu(){
		this.config = new Config();
		this.m = new Map("res/map/map1.map");
		this.hud = new Hud();
		this.batMan = new BatimentsManager();
	}
	
	public Config getConfig(){
		return this.config;
	}
	public Map getMap(){
		return this.m;
	}
	public Hud getHud(){
		return this.hud;
	}

	public void update(GameContainer container, int delta) throws SlickException {
		if(this.hud.getDoConstruction()){
			this.batMan.add(this.hud.getBatimentAcuel());
			this.hud.resetBatimentAcuel();
			this.hud.resetDoConstruction();
		}
		
		this.hud.update(container,delta);
		this.batMan.update(container, delta);
	}
	
	public void render(Graphics g, int mouseX, int mouseY){
		g.translate(this.m.getXCamera(),this.m.getYCamera());
    	g.scale(this.m.getScale(),this.m.getScale());
    	this.m.render(0, 0);
    	
		this.batMan.render();

    	g.scale(1/this.m.getScale(),1/this.m.getScale());
    	g.translate(this.m.getXCamera()*(-1),this.m.getYCamera()*(-1));
		
		this.hud.render(g, mouseX, mouseY, this.m.getScale(),this.m.getXCamera()*(-1),this.m.getYCamera()*(-1));
	}
	
	
}
