package tuiles;

import org.newdawn.slick.Image;

public class Sol extends Tuile{

	@Override
	public Tuile cloneme(){
		Tuile t = null;
		try {
			// On récupère l'instance à renvoyer par l'appel de la 
			// méthode super.clone()
			t = (Sol) super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implémentons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		// on renvoie le clone
		return t;
	}
	
	public Sol(Image img){
		this.img=img;
	}
}
