package menus;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import autres.ButtonArea;

public class MenuConstruction {
	private List<CategorieConstruction> categories;
	private Image background;
	
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
	}
	
	private void setButtons(int x, int y){
		int cpt=0;
		for (CategorieConstruction cc : categories) {
			cc.setButton(x+50+(cpt*130),y+50,100,100);
			cc.setButtons(x,y);
			cpt++;
		}
	}
	
	public void render(int x, int y){
		int cpt=0;
		this.background.draw(x, y, 1024, 200);
		for (CategorieConstruction cc : categories) {
			cc.draw(x+50+(cpt*130),y+50);
			cpt++;
		}
	}
	
	public void renderCategorie(int num, int x, int y){
		this.categories.get(num).render(x, y);;
	}
	

    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
    	for (CategorieConstruction cc : categories) {
        	if(cc.getButton().contain(newx,newy))
        		cc.getButton().setHover(true);
        	else
        		cc.getButton().setHover(false);
		}
    }
	
}
