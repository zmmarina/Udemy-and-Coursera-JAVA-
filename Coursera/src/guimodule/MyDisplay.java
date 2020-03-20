package guimodule;

import processing.core.PApplet;
import processing.core.PImage;

public class MyDisplay extends PApplet {
	PImage img;

	public void setup() {
		
		size (400, 400);
		background (254,127,156);
		stroke (0);
		img = loadImage("https://waballet.com.au/wp-content/uploads/2016/10/010_20170227_WA-BALLET_Autumn-Newsletter_SQUARE.jpg", "jpg");
		//IMAGE FROM GOOGLE
		img.resize(0, height);
		image (img, 0,0);
	}
		
	public void draw() {
		
		int [] color = sunColorSec(second());
		fill(color[0],color[1],color[2]);
		ellipse (60,60,60,60);
	}
	
	public int [] sunColorSec(float seconds) {
		
		int [] rgb = new int [3];
		float diffFrom30 = Math.abs(30-seconds);
		
		float ratio = diffFrom30/30;
		rgb[0] = (int)(255*ratio);
		rgb[1] = (int)(255*ratio);
		rgb[2] = 0;
		
		return rgb;
	}
}
