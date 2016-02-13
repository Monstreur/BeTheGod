package principal;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.util.ResourceLoader;

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
