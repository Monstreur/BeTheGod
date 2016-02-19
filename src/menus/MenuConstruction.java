package menus;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import autres.ButtonArea;
import batiments.Batiment;

public class MenuConstruction {
	private List<CategorieConstruction> categories;
	private CategorieConstruction categorieActive;
	private Image background;
	private ButtonArea menuOut;
	private Batiment batimentChoisi;
	
	public MenuConstruction(int x, int y){
		this.categories = new ArrayList<CategorieConstruction>();
		this.categories.add(new CategorieConstruction("Ressource","res/img/build.png"));
		this.categories.add(new CategorieConstruction("Distribution","res/img/build.png"));
		this.categories.add(new CategorieConstruction("Service","res/img/build.png"));
		try {
			this.background = new Image("res/img/fondBuildMenu.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.setButtons(x,y);
		this.menuOut = new ButtonArea(0, 568, 1024, 200);
	}
	
	private void setButtons(int x, int y){
		int cpt=0;
		for (CategorieConstruction cc : categories) {
			cc.setButton(x+50+(cpt*120),y+50,100,100);
			cc.setButtons(x,y);
			cpt++;
		}
	}
	
	public void render(Graphics g, int x, int y){
		if(this.categorieActive!=null){
			this.background.draw(x, y, 1024, 200);
			this.categorieActive.render(g, x, y);
		}else{
			int cpt=0;
			this.background.draw(x, y, 1024, 200);
			for (CategorieConstruction cc : categories) {
				cc.draw(g, x+50+(cpt*120),y+50);
				cpt++;
			}
		}
	}
	
	public boolean mousePressed(int button, int x, int y) {
		if(this.categorieActive!=null){
			batimentChoisi = this.categorieActive.mousePressed(button, x, y);
			if(batimentChoisi!=null){
				categorieActive=null;
			}
		}else{
			for (CategorieConstruction cc : categories) {
				if(cc.getButton().contain(x,y) && button==0){
					this.categorieActive = cc;
					cc.getButton().setHover(false);
				}
			}
    	}
		if(!this.menuOut.contain(x,y) && button==0){
			this.categorieActive=null;
			return true;
		}
		return false;
    }
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
    	if(this.categorieActive!=null){
    		this.categorieActive.mouseMoved(oldx, oldy, newx, newy);
    	}else{
	    	for (CategorieConstruction cc : categories) {
	        	if(cc.getButton().contain(newx,newy))
	        		cc.getButton().setHover(true);
	        	else
	        		cc.getButton().setHover(false);
			}
    	}
    }

	public Batiment getBatimentChoisi() {
		return this.batimentChoisi;
	}
	public void resetBatimentChoisi() {
		this.batimentChoisi=null;
	}
	
}
