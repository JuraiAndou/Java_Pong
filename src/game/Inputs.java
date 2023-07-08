package game;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Inputs{
	
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static Game frame;
	
	public Inputs (Game game) {
		frame = game;
		
	}

	public int getX() {
		mouseX = MouseInfo.getPointerInfo().getLocation().x - frame.getLocationOnScreen().x;
		return mouseX; 
	}

	public int getY() {
		mouseY= MouseInfo.getPointerInfo().getLocation().y - frame.getLocationOnScreen().y;
		return mouseY; 
	}
}
