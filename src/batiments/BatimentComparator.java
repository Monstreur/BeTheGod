package batiments;

import java.util.Comparator;

public class BatimentComparator implements Comparator<Batiment> {
    @Override
    public int compare(Batiment b1, Batiment b2) {
    	
    	return (b1.getY()-b2.getY()==0) ? b1.getX()-b2.getX() : b1.getY()-b2.getY();
    }

}
