package batiments;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.newdawn.slick.GameContainer;

public class BatimentsManager {
	private List<Batiment> batiments;

	public BatimentsManager(){
		this.batiments = new ArrayList<Batiment>();
	}
	
	public boolean add(Batiment b){
		boolean ret=this.batiments.add(b);
		this.trierBatiments();
		return ret;
	}
	public boolean del(Batiment b){
		return this.batiments.remove(b);
	}
	public Batiment get(int index){
		return this.batiments.get(index);
	}
	
	public void update(GameContainer container, int delta) {
		
	}
	public void mousePressed(int button, int x, int y) {
		
	}
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
    	
    }
    
    public void trierBatiments(){
    	Collections.sort(this.batiments, new BatimentComparator());
    }
    
    public void render(){
    	for (Batiment b : batiments) {
			b.render();
		}
    }
}
