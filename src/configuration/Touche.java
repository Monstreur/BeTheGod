package configuration;

public class Touche {
	public static int UP = 0;
	public static int RIGHT = 1;
	public static int DOWN = 2;
	public static int LEFT = 3;
	public static int MOUSEUP = 4;
	public static int MOUSERIGHT = 5;
	public static int MOUSEDOWN = 6;
	public static int MOUSELEFT = 7;
	
	private float nbappuie;
	private int key;
	private int lastdelta;
	
	public Touche(int key){
		this.key=key;
		this.nbappuie=0;
		this.lastdelta=0;
	}
	/* 
	 * Only if it's a mouseMouvement OR mouseWheel
	 */
	public Touche(){
		this.nbappuie=0;
		this.lastdelta=0;
	}
	public float getNbappui() {
		return nbappuie;
	}
	
	public int getKey() {
		return key;
	}
	
	public int getLastdelta() {
		return lastdelta;
	}
	
	public void appuie(int delta){
		if(!this.is_appuie()){
			this.nbappuie+=0.5;
			this.lastdelta=delta;
		}
	}
	
	public void relache(){
		if(this.is_appuie()){
			this.nbappuie+=0.5;
			this.lastdelta=0;
		}
	}
	
	public boolean is_appuie(){
		return (this.nbappuie%1==0.5);
	}
	
}
