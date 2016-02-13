package tuiles;

import org.newdawn.slick.Image;

public class Water extends Tuile{

	@Override
	public Tuile cloneme(){
		Tuile t = null;
		try {
			t = (Water) super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implémentons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		// on renvoie le clone
		return t;
	}
	
	public Water(Image img){
		this.img=img;
	}
}
