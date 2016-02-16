package principal;

import configuration.Config;
import entities.Map;

public class Jeu {
	private Config config;
	private Map m;
	private Hud hud;
	
	public Jeu(){
		this.config = new Config();
		this.m = new Map("res/map/map1.map");
		this.hud = new Hud();
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
	
	
}
