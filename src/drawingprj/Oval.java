package drawingprj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Rectangle {

	/**
	 * 
	 */

	public Oval(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	public Oval(Point pointMouseDown, Point mr) {
		super(pointMouseDown, mr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);

		if (isFilled()) {
			g.setColor(getColor());
			g.fillOval(x + 1, y + 1, width - 1, height - 1);
			if (isSelected()) {
				g.setColor(Color.BLACK);
				g.drawOval(x - 1, y - 1, width + 2, height + 2);
				g.drawOval(x + 1, y + 1, width - 2, height - 2);

				g.fillRect(x - 4, y - 4, 5, 5);
				g.fillRect(x - 4, y + height - 1, 5, 5);
				g.fillRect(x - 4, y + height / 2 - 1, 5, 5);

				g.fillRect(x + width, y - 4, 5, 5);
				g.fillRect(x + width, y + height / 2 + -1, 5, 5);
				g.fillRect(x + width, y + height - 1, 5, 5);

				g.fillRect(x + width / 2 - 1, y - 4, 5, 5);
				g.fillRect(x + width / 2 - 1, y + height + 1, 5, 5);

			}

			else if (isSelected() == false) {
				g.setColor(getColor());
				g.fillOval(x + 1, y + 1, width - 1, height - 1);

			}
		}
	}

}
