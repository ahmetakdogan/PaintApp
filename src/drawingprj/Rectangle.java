package drawingprj;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public Rectangle(Point pointMouseDown, Point mr) {
		// TODO
		this.x = Math.min(pointMouseDown.x, mr.x);
		this.y = Math.min(pointMouseDown.y, mr.y);
		// if (mr.x < pointMouseDown.x)
		// x = mr.x;
		// if (mr.y < pointMouseDown.y)
		// y = mr.y;
		this.width = Math.abs(mr.x - pointMouseDown.x);
		this.height = Math.abs(mr.y - pointMouseDown.y);

	}

	public Rectangle(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.height = h;
		this.width = w;
	}

	@Override
	public boolean containsPoint(Point p) {
		return p.x > x && p.x < (x + width) && p.y > y && p.y < (y + height);
	}

	@Override
	public void draw(Graphics g) {
		// TODO

		g.drawRect(x, y, width, height);
		if (isFilled()) {
			g.setColor(getColor());
			g.fillRect(x, y, width, height);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width + 1, height + 1);
		}
		if (isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width + 1, height + 1);
			// g.drawRect(x, y, width + 2, height + 2);
			g.drawRect(x, y - 1, width + 1, height + 1);
			// g.drawRect(x, y - 2, width + 2, height + 2);
			g.drawRect(x - 1, y + 1, width + 1, height + 1);
			// g.drawRect(x - 1, y + 2, width + 2, height + 2);

			g.fillRect(x - 3, y - 3, 3, 3);
			g.fillRect(width + x + 3, y - 3, 3, 3);
			g.fillRect(x + (width / 2), y - 3, 3, 3);
			g.fillRect(x - 3, y + (height / 2), 3, 3);
			g.fillRect(x - 3, height + y + 3, 3, 3);
			g.fillRect(x + width + 3, height + y + 3, 3, 3);
			g.fillRect(x + (width / 2), y + height + 3, 3, 3);
			g.fillRect(x + width + 3, y + (height / 2) + 3 + 3, 3, 3);

		}
	}

	@Override
	public int getArea() {
		return width * height;
	}

	@Override
	public Cursor getResizingCursor(Point p) {
		if ((p.x > x - 5 && p.x < x + 5 && p.y > y - 5 && p.y < y + 5)) {
			return Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
		} else if ((p.x > x + width - 5 && p.x < x + width + 5 && p.y > y - 5 && p.y < y + 5)) {
			return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
		} else if ((p.x > x - 5 && p.x < x + 5 && p.y > y + height - 5 && p.y < y
				+ height + 5)) {
			return Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
		} else if ((p.x > x + width - 5 && p.x < x + width + 5
				&& p.y > y + height - 5 && p.y < y + height + 5)) {
			return Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
		} else if ((p.x > x + width - 5 && p.x < x + width + 5 && p.y > y && p.y < y
				+ height)) {
			return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
		} else if ((p.x > x - 5 && p.x < x + 5 && p.y > y && p.y < y + height)) {
			return Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
		} else if ((p.y > y + height - 5 && p.y < y + height + 5 && p.x > x && p.x < x
				+ width)) {
			return Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
		} else if ((p.y > y - 5 && p.y < y + 5 && p.x > x && p.x < x + width)) {
			return Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
		} else if (containsPoint(p)) {
			return Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
		}

		return null;
	}

	@Override
	public void move(int px, int direction) {
		switch (direction) {
		case NORTH:
			this.y -= px;
			break;
		case SOUTH:
			this.y += px;
			break;
		case WEST:
			this.x -= px;
			break;
		case EAST:
			this.x += px;
			break;
		default:
			break;
		}
	}

	@Override
	public void move(Point ref, Point target) {
		int xd = target.x - ref.x;
		int yd = target.y - ref.y;
		this.x += xd;
		this.y += yd;

	}

	@Override
	public void resize(Point ref, Point target, int direction) {
		int xd = target.x - ref.x;
		int yd = target.y - ref.y;

		switch (direction) {
		case SOUTH_EAST:
			this.width += xd;
			this.height += yd;
			break;
		case SOUTH_WEST:
			this.x += xd;
			this.width -= xd;
			this.height += yd;
			break;
		case NORTH_EAST:
			this.width += xd;
			this.height -= yd;
			this.y += yd;
			break;
		case NORTH_WEST:
			this.x += xd;
			this.y += yd;
			this.width -= xd;
			this.height -= yd;
			break;
		case SOUTH:
			this.height += yd;
			break;
		case NORTH:
			this.y += yd;
			this.height -= yd;
			break;
		case WEST:
			this.x += xd;
			this.width -= xd;
			break;
		case EAST:
			this.width += xd;
			break;
		default:
			break;
		}
	}

	@Override
	public void paste(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public String getText() {
		return null;
	}

	@Override
	public Shape copy() {
		// TODO Auto-generated method stub
		Shape shape = null;
		Rectangle rec = new Rectangle(x, y, width, height);
		rec.setColor(getColor());
		rec.setFilled(true);
		shape = (Shape) rec;
		return shape;
	}
}
