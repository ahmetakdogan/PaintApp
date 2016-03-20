package drawingprj;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public abstract class Shape implements Serializable {
	public static final int SOUTH_WEST = 4;
	public static final int SOUTH_EAST = 5;
	public static final int NORTH_WEST = 6;
	public static final int NORTH_EAST = 7;
	public static final int NORTH = 8;
	public static final int SOUTH = 9;
	public static final int WEST = 10;
	public static final int EAST = 11;

	private boolean filled = false;
	private boolean selected = false;
	private Color color;

	public abstract void draw(Graphics g);

	public abstract void move(int px, int direction);

	public abstract void move(Point ref, Point target);

	public abstract void resize(Point ref, Point target, int direction);

	public abstract void paste(Point p);

	public abstract int getArea();

	public abstract boolean containsPoint(Point p);

	public abstract Cursor getResizingCursor(Point p);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public abstract Shape copy();
}
