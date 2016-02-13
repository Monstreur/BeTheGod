package principal;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import configuration.Touche;

public class Main extends BasicGame {
    private GameContainer container;
    private int timepast;
    private Jeu jeu;
    private Touche[] touches;
    private int mouseX;
    private int mouseY;

	public Main() {
        super("Be the God - (Zoom sur la souris)");
    }

    @Override
    public void init(GameContainer container) throws SlickException {
    	this.container = container;
		container.setShowFPS(false);
		container.setFullscreen(true);
		this.timepast=0;
		this.jeu = new Jeu();
		this.touches=new Touche[8];
		this.touches[Touche.UP]= new Touche(Input.KEY_UP);
		this.touches[Touche.RIGHT]= new Touche(Input.KEY_RIGHT);
		this.touches[Touche.DOWN]= new Touche(Input.KEY_DOWN);
		this.touches[Touche.LEFT]= new Touche(Input.KEY_LEFT);
		this.touches[Touche.MOUSEUP]= new Touche();
		this.touches[Touche.MOUSERIGHT]= new Touche();
		this.touches[Touche.MOUSEDOWN]= new Touche();
		this.touches[Touche.MOUSELEFT]= new Touche();
		
    	this.jeu.getMap().moveCameraToMiddle(this.container.getWidth(),this.container.getHeight());
	}

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
    	g.translate(this.jeu.getMap().getXCamera(),this.jeu.getMap().getYCamera());
    	g.scale(this.jeu.getMap().getScale(),this.jeu.getMap().getScale());
    	this.jeu.getMap().render(0, 0);
    	g.scale(1, 1);
    	this.jeu.getHud().render(g, (int)(this.jeu.getMap().getXCamera()*(-1)), (int)(this.jeu.getMap().getYCamera()*(-1)));
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    	if (this.touches[Touche.UP].is_appuie() || this.touches[Touche.MOUSEUP].is_appuie())
    		this.jeu.getMap().moveCamera(0,this.container.getWidth(),this.container.getHeight());
    	if (this.touches[Touche.RIGHT].is_appuie() || this.touches[Touche.MOUSERIGHT].is_appuie())
    		this.jeu.getMap().moveCamera(1,this.container.getWidth(),this.container.getHeight());
    	if (this.touches[Touche.DOWN].is_appuie() || this.touches[Touche.MOUSEDOWN].is_appuie())
    		this.jeu.getMap().moveCamera(2,this.container.getWidth(),this.container.getHeight());
    	if (this.touches[Touche.LEFT].is_appuie() || this.touches[Touche.MOUSELEFT].is_appuie())
    		this.jeu.getMap().moveCamera(3,this.container.getWidth(),this.container.getHeight());
    	
    	
    }
    
    public void keyPressed(int key, char c){

    	if (this.touches[Touche.UP].getKey() == key)
    		this.touches[Touche.UP].appuie(this.timepast);
    	if (this.touches[Touche.RIGHT].getKey() == key)
    		this.touches[Touche.RIGHT].appuie(this.timepast);
    	if (this.touches[Touche.DOWN].getKey() == key)
    		this.touches[Touche.DOWN].appuie(this.timepast);
    	if (this.touches[Touche.LEFT].getKey() == key)
    		this.touches[Touche.LEFT].appuie(this.timepast);
	}

    @Override
    public void keyReleased(int key, char c) {
    	if (Input.KEY_F == key) {
            container.exit();
        }
    	if (Input.KEY_ESCAPE == key) {
           	try {
				this.container.setFullscreen(!this.container.isFullscreen());
			} catch (SlickException e) {
				System.out.println("SLICKEXCEPTION:"+e.getMessage());
			}
        }
    	if (this.touches[Touche.UP].getKey() == key)
    		this.touches[Touche.UP].relache();
    	if (this.touches[Touche.RIGHT].getKey() == key)
    		this.touches[Touche.RIGHT].relache();
    	if (this.touches[Touche.DOWN].getKey() == key)
    		this.touches[Touche.DOWN].relache();
    	if (this.touches[Touche.LEFT].getKey() == key)
    		this.touches[Touche.LEFT].relache();
    }
    

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
    	if(newy<2)
    		this.touches[Touche.MOUSEUP].appuie(this.timepast);
    	else
    		this.touches[Touche.MOUSEUP].relache();
    	if(newx>this.container.getWidth()-2)
    		this.touches[Touche.MOUSERIGHT].appuie(this.timepast);
    	else
    		this.touches[Touche.MOUSERIGHT].relache();
    	if(newy>this.container.getHeight()-2)
    		this.touches[Touche.MOUSEDOWN].appuie(this.timepast);
    	else
    		this.touches[Touche.MOUSEDOWN].relache();
    	if(newx<2)
    		this.touches[Touche.MOUSELEFT].appuie(this.timepast);
    	else
    		this.touches[Touche.MOUSELEFT].relache();

    	this.mouseX=newx;
    	this.mouseY=newy;
    	
    	this.jeu.getHud().mouseMoved(oldx, oldy, newx, newy);
    	
    }
    
    @Override
    public void mousePressed(int button, int x, int y) {
    	//System.out.println(button+" ("+x+";"+y+") ("+(this.jeu.getMap().getXCamera()-x)+";"+(this.jeu.getMap().getYCamera()-y)+")");
    	this.jeu.getHud().mousePressed(button, x, y);
    }
    
    @Override
    public void mouseWheelMoved(int change) {
    	if(change>0)
    		this.jeu.getMap().zoomIn(this.container.getWidth(),this.container.getHeight(),this.mouseX,this.mouseY);
    	if(change<0)
    		this.jeu.getMap().zoomOut(this.container.getWidth(),this.container.getHeight(),this.mouseX,this.mouseY);
    }
    
    public static void main(String[] args) throws SlickException {
    	new AppGameContainer(new Main(), 1024, 768, false).start();
    }
}