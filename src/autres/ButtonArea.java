package autres;

public class ButtonArea {
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean hover;
	
	public ButtonArea(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public boolean isHover(){
		return hover;
	}
	public void setHover(boolean hover){
		this.hover=hover;
	}

	public boolean contain(int x2, int y2) {
		return (x2>=x && x2<=(x+width) && y2>=y && y2<=(y+height));
	}
	
	
	
}
