package entities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import tuiles.TilesProperty;
import tuiles.Tuile;

public class Map {
	private Tuile[][] tuiles;
	private TilesProperty tileset;
	private float xCamera;
	private float yCamera;
	private String name;
	private int nbTuileX;
	private int nbTuileY;
	private int tuileWidth;
	private int tuileHeight;
	private int startx;
	private int starty;
	private float scale;
	
	public Map(String ref){
		try{
			InputStream ips=new FileInputStream(ref); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				if(ligne.startsWith("tileset=")){
					this.tileset=new TilesProperty("res/map/tilesets/"+ligne.substring(8));
				}
				if(ligne.startsWith("name=")){
					this.name=ligne.substring(5);
				}
				if(ligne.startsWith("res=")){
					String[] res = ligne.substring(4).split("x");
					this.nbTuileX=Integer.parseInt(res[0]);
					this.nbTuileY=Integer.parseInt(res[1]);
				}
				if(ligne.startsWith("tileres=")){
					String[] tileres = ligne.substring(8).split("x");
					this.tuileWidth=Integer.parseInt(tileres[0]);
					this.tuileHeight=Integer.parseInt(tileres[1]);
				}
				if(ligne.contains("[tiles]")){
					this.tuiles = new Tuile[this.nbTuileY][this.nbTuileX];
					this.parseDataUntilTheEnd(br);
				}
			}
			br.close();
		}		
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		this.scale=1;
	}
	
	private void parseDataUntilTheEnd(BufferedReader br) throws IOException {
		String ligne;
		int y = 0;
		while ((ligne=br.readLine())!=null){
			int x = 0;
			for(String numtile : ligne.split(" ")){
				this.tuiles[y][x]= this.tileset.getTuile(Integer.parseInt(numtile)).cloneme();
				x++;
			}
			y++;
		}
	}
	
	public void moveCamera(int dir, int ecranWidth, int ecranHeight){
		float incr=4*scale;
		
		if(dir == 0 && (this.yCamera+incr)<=(-16*scale)){
			this.yCamera+=incr;
		}else if(dir == 1 && (this.xCamera-incr)>=((this.nbTuileX*this.tuileWidth*scale*(-1)+ecranWidth))){
			this.xCamera-=incr;
		}else if(dir == 2 && (this.yCamera-incr)>=((this.nbTuileY*this.tuileHeight*scale*(-1)/2+ecranHeight))){
			this.yCamera-=incr;
		}else if(dir == 3 && (this.xCamera+incr)<=(-32*scale)){
			this.xCamera+=incr;
		}
	}
	
	public void render(int x, int y){
		this.startx=x;
		this.starty=y;
		int tmpy=y;
		int decallage = 0;
		for (Tuile[] tuile : tuiles) {
			int tmpx=x;
			if(tmpy%2==1)
				decallage=32;
			else
				decallage=0;
			for (Tuile t : tuile) {
				t.draw(tmpx*this.tuileWidth+decallage,tmpy*(this.tuileHeight/2));
				tmpx++;
			}
			tmpy++;
		}
	}

	public float getXCamera(){
		return xCamera;
	}
	public float getYCamera(){
		return yCamera;
	}

	public void moveCameraTo(float x, float y){
		this.xCamera=x;
		this.yCamera=y;
	}

	public void moveCameraToMiddle(int ecranWidth,int ecranHeight){
		int milieuEcranX = ecranWidth/2;
		int milieuEcranY = ecranHeight/2;
		this.xCamera=(float) (milieuEcranX-((this.nbTuileX+0.5)*this.tuileWidth*scale/2));
		this.yCamera=(float) (milieuEcranY-((this.nbTuileY+0.5)*this.tuileHeight*scale/4));
	}
	
	public float getScale(){
		return this.scale;
	}

	public void zoomIn(int ecranWidth,int ecranHeight,int mouseX,int mouseY){
		this.scale *= 1.01;
		moveCameraTo((float)((this.xCamera)*1.01),(float)((this.yCamera)*1.01));
		//moveCameraTo((float)(this.xCamera-((float)mouseX/ecranWidth*4*scale)),(float)(this.yCamera-((float)mouseY/ecranHeight*4*scale)));
	}
	public void zoomOut(int ecranWidth,int ecranHeight,int mouseX,int mouseY){
		if(ecranWidth<(((this.nbTuileX+0.5)*this.tuileWidth*scale)-32)
			&& ecranHeight<(((this.nbTuileY+0.5)*this.tuileHeight*scale/2)-16))
		{
			float oldCarteWidth=(float) (this.nbTuileX*this.tuileWidth*scale);
			float oldCarteHeight=(float) (this.nbTuileY*this.tuileHeight*0.5*scale);
			float newCarteWidth=(float) (oldCarteWidth*0.99);
			float newCarteHeight=(float) (oldCarteHeight*0.99);
			float difCarteWidth=oldCarteWidth-newCarteWidth;
			float difCarteHeight=oldCarteHeight-newCarteHeight;
			
			if((this.yCamera+difCarteHeight)>(-16*scale)){
				this.yCamera-=difCarteHeight;
			}else if((this.xCamera-difCarteWidth)<((this.nbTuileX*this.tuileWidth*scale*(-1)+ecranWidth))){
				this.xCamera+=difCarteWidth;
			}else if((this.yCamera-difCarteHeight)<((this.nbTuileY*this.tuileHeight*scale*(-1)/2+ecranHeight))){
				this.yCamera+=difCarteHeight;
			}else if((this.xCamera+difCarteWidth)>(-32*scale)){
				this.xCamera-=difCarteWidth;
			}
			this.scale *= 0.99;
			moveCameraTo((float)((this.xCamera)*0.99),(float)((this.yCamera)*0.99));
		}
	}
	
	public String getName(){
		return this.name;
	}
}
