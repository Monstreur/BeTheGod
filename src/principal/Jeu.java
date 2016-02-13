package principal;

import configuration.Config;
import entities.Map;

public class Jeu {
	private Config config;
	private Map m;
	
	public Jeu(){
		this.config = new Config();
		this.m = new Map("res/map/map1.map");
	}
	
	public Config getConfig(){
		return this.config;
	}
	
	public Map getMap(){
		return this.m;
	}
	
	
}
