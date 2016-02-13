package tuiles;

import java.io.*;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class TilesProperty {
	private SpriteSheet tileset;
	private Tuile[] tuiles;
	private int tuileWidth;
	private int tuileHeight;
	private int nbTuileX;
	private int nbTuileY;
	
	public TilesProperty(String ref){
		try{
			InputStream ips=new FileInputStream(ref); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				if(ligne.startsWith("tileres=")){
					String[] tileres = ligne.substring(8).split("x");
					this.tuileWidth=Integer.parseInt(tileres[0]);
					this.tuileHeight=Integer.parseInt(tileres[1]);
				}
				if(ligne.startsWith("file=")){
					this.tileset = new SpriteSheet(new Image("res/map/tilesets/"+ligne.substring(5)), this.tuileWidth, this.tuileHeight, 0, 0);
					this.nbTuileX=tileset.getHorizontalCount();
					this.nbTuileY=tileset.getVerticalCount();
				}
				if(ligne.contains("[tileset]")){
					this.tuiles = new Tuile[this.nbTuileX*this.nbTuileY];
					this.parseDataUntilTheEnd(br);
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	private void parseDataUntilTheEnd(BufferedReader br) throws IOException {
		String ligne;
		int cpt=0;
		while ((ligne=br.readLine())!=null){
			if(ligne.startsWith("tuile: ")){
				Image img = this.tileset.getSubImage(cpt%this.nbTuileX,(int) cpt/this.nbTuileX);
				if(ligne.substring(7).equalsIgnoreCase("sol")){
					this.tuiles[cpt++]=new Sol(img);
				}
				else if(ligne.substring(7).equalsIgnoreCase("water")){
					this.tuiles[cpt++]=new Water(img);
				}
			}
		}
	}
	
	public int getTuileWidth() {
		return tuileWidth;
	}
	public int getTuileHeight() {
		return tuileHeight;
	}
	public int getNbTuileX() {
		return nbTuileX;
	}
	public int getNbTuileY() {
		return nbTuileY;
	}
	
	public Tuile getTuile(int num){
		return this.tuiles[num];
	}
	
	
}
