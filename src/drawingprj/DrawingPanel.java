package drawingprj;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class DrawingPanel extends JPanel implements KeyListener, MouseListener,
		MouseMotionListener {
	public static final int DM_RECT = 0;
	public static final int DM_OVAL = 1;
	public static final int DM_TEXT = 2;
	public static final int Drag_Draw = 0;
	public static final int Drag_Move = 1;
	public static final int Drag_Resize = 2;
	private static int moveStep = 10;
	private static int ignorableShapeArea = 20;
	private Vector<Shape> shapes = new Vector<Shape>();
	private Color drawingColor = Color.RED;
	private static Color[] colors = { Color.MAGENTA, Color.BLUE, Color.CYAN,
			Color.LIGHT_GRAY, Color.GREEN, Color.PINK, Color.ORANGE,
			Color.YELLOW };
	private boolean randomColor = false;
	private boolean selectingMode;
	private int drawingMode;
	private int draggingMode;
	private Point pointMouseDown;
	private Shape selectedShape;
	private Shape currentDrawingShape;
	private Shape shapeTemp = null;
	private Shape shapeTempCopy = null;
	// ======== popupMenu ========
	private JPopupMenu popupMenu = new JPopupMenu();
	private JMenuItem pmiCut = new JMenuItem();
	private JMenuItem pmiCopy = new JMenuItem();
	private JMenuItem pmiPaste = new JMenuItem();
	private JMenuItem pmiDelete = new JMenuItem();
	private JMenuItem pmiClearAll = new JMenuItem();
	private JMenuItem pmiUp = new JMenuItem();
	private JMenuItem pmiDown = new JMenuItem();
	private JMenu pmiChangeColor = new JMenu();
	private JRadioButtonMenuItem prdmiDCRed = new JRadioButtonMenuItem();
	private JRadioButtonMenuItem prdmiDCBlue = new JRadioButtonMenuItem();
	private JRadioButtonMenuItem prdmiDCYellow = new JRadioButtonMenuItem();
	private JRadioButtonMenuItem prdmiDCGreen = new JRadioButtonMenuItem();
	private JRadioButtonMenuItem prdmiDCCyan = new JRadioButtonMenuItem();
	private JRadioButtonMenuItem prdmiDCOrange = new JRadioButtonMenuItem();
	private JRadioButtonMenuItem prdmiDCMagenta = new JRadioButtonMenuItem();

	// // ======== popupMenu ========
	private void initListeners() {
		popupMenu.setAutoscrolls(true);
		popupMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		popupMenu.setFocusCycleRoot(true);
		popupMenu.setEnabled(true);
		// ---- pmiCut ----
		pmiCut.setText("Cut");
		pmiCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				KeyEvent.CTRL_MASK));
		// pmiCut.setIcon(new ImageIcon(getClass().getResource(
		// "/drawingprj/images/cut.jpg")));
		pmiCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pmiCutActionPerformed(e);
			}

			private void pmiCutActionPerformed(ActionEvent e) {
				cutSelectedShape();
			}
		});
		popupMenu.add(pmiCut);
		// ---- pmiCopy ----
		pmiCopy.setText("Copy");
		pmiCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				KeyEvent.CTRL_MASK));
		pmiCopy.setIcon(new ImageIcon(getClass().getResource(
				"/drawingprj/images/copy.jpg")));
		pmiCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pmiCopyActionPerformed(e);
			}

			private void pmiCopyActionPerformed(ActionEvent e) {
				copySelectedShape();
			}
		});
		popupMenu.add(pmiCopy);
		// ---- pmiPaste ----
		pmiPaste.setText("Paste");
		pmiPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				KeyEvent.CTRL_MASK));
		pmiPaste.setIcon(new ImageIcon(getClass().getResource(
				"/drawingprj/images/paste.jpg")));
		pmiPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pmiPasteActionPerformed(e);
			}

			private void pmiPasteActionPerformed(ActionEvent e) {
				pasteSelectedShape();
			}
		});
		popupMenu.add(pmiPaste);
		popupMenu.addSeparator();
		// ---- pmiDelete ----
		pmiDelete.setText("Delete");
		pmiDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0));
		pmiDelete.setIcon(new ImageIcon(getClass().getResource(
				"/drawingprj/images/delete3.jpg")));
		pmiDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pmiDeleteActionPerformed(e);
			}

			private void pmiDeleteActionPerformed(ActionEvent e) {
				deleteSelectedShape();
			}
		});
		popupMenu.add(pmiDelete);
		// ---- pmiClearAll ----
		pmiClearAll.setText("Clear All");
		pmiClearAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				KeyEvent.CTRL_MASK | KeyEvent.SHIFT_MASK));
		pmiClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pmiClearAllActionPerformed(e);
			}

			private void pmiClearAllActionPerformed(ActionEvent e) {
				clearAllShapes();
			}
		});
		popupMenu.add(pmiClearAll);
		popupMenu.addSeparator();
		// ---- pmiUp ----
		pmiUp.setText("Up");
		pmiUp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, 0));
		pmiUp.setIcon(new ImageIcon(getClass().getResource(
				"/drawingprj/images/upg.gif")));
		pmiUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pmiUpActionPerformed(e);
			}

			private void pmiUpActionPerformed(ActionEvent e) {
				increaseIndexOfSelectedShape();
			}
		});
		popupMenu.add(pmiUp);
		// ---- pmiDown ----
		pmiDown.setText("Down");
		pmiDown.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0));
		pmiDown.setIcon(new ImageIcon(getClass().getResource(
				"/drawingprj/images/downg.gif")));
		pmiDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pmiDownActionPerformed(e);
			}

			private void pmiDownActionPerformed(ActionEvent e) {
				decreaseIndexOfSelectedShape();
			}
		});
		popupMenu.add(pmiDown);
		popupMenu.addSeparator();
		// ======== pmiChangeColor ========
		{
			pmiChangeColor.setText("Change Color");
			// ---- prdmiDCRed ----
			prdmiDCRed.setText("Red");
			prdmiDCRed.setBackground(Color.RED);
			pmiChangeColor.add(prdmiDCRed);
			// ---- prdmiDCBlue ----
			prdmiDCBlue.setText("Blue");
			prdmiDCBlue.setBackground(new Color(51, 51, 255));
			pmiChangeColor.add(prdmiDCBlue);
			// ---- prdmiDCYellow ----
			prdmiDCYellow.setText("Yellow");
			prdmiDCYellow.setBackground(new Color(255, 255, 51));
			pmiChangeColor.add(prdmiDCYellow);
			// ---- prdmiDCGreen ----
			prdmiDCGreen.setText("Green");
			prdmiDCGreen.setBackground(new Color(0, 255, 51));
			pmiChangeColor.add(prdmiDCGreen);
			// ---- prdmiDCCyan ----
			prdmiDCCyan.setText("Cyan");
			prdmiDCCyan.setBackground(Color.cyan);
			pmiChangeColor.add(prdmiDCCyan);
			// ---- prdmiDCOrange ----
			prdmiDCOrange.setText("Orange");
			prdmiDCOrange.setBackground(new Color(255, 204, 0));
			pmiChangeColor.add(prdmiDCOrange);
			// ---- prdmiDCMagenta ----
			prdmiDCMagenta.setText("Magenta");
			prdmiDCMagenta.setBackground(new Color(102, 0, 102));
			pmiChangeColor.add(prdmiDCMagenta);
		}
		popupMenu.add(pmiChangeColor);
	}

	private class ChangeColorRdButtonsActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButtonMenuItem button = (JRadioButtonMenuItem) e.getSource();
			selectedShape.setColor(button.getBackground());
			repaint();
		}
	}

	public DrawingPanel() {
		initListeners();
		// ---- buttonGroupPMiDC ----
		ButtonGroup buttonGroupPMiDC = new ButtonGroup();
		buttonGroupPMiDC.add(prdmiDCRed);
		buttonGroupPMiDC.add(prdmiDCBlue);
		buttonGroupPMiDC.add(prdmiDCYellow);
		buttonGroupPMiDC.add(prdmiDCGreen);
		buttonGroupPMiDC.add(prdmiDCCyan);
		buttonGroupPMiDC.add(prdmiDCOrange);
		buttonGroupPMiDC.add(prdmiDCMagenta);
		ChangeColorRdButtonsActionListener dcrdbtal = new ChangeColorRdButtonsActionListener();
		prdmiDCCyan.addActionListener(dcrdbtal);
		prdmiDCMagenta.addActionListener(dcrdbtal);
		prdmiDCBlue.addActionListener(dcrdbtal);
		prdmiDCGreen.addActionListener(dcrdbtal);
		prdmiDCOrange.addActionListener(dcrdbtal);
		prdmiDCRed.addActionListener(dcrdbtal);
		prdmiDCYellow.addActionListener(dcrdbtal);
		add(popupMenu);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setPreferredSize(new Dimension(700, 400));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Shape shape : shapes) {
			shape.draw(g);
		}
	}

	/**
	 * 
	 * @param p
	 * @return The top most shape in shapes vector
	 */
	private Shape findTopMostShape(Point p) {
		// TODO
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).containsPoint(p))
				return shapes.get(i);
		}
		return null;
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_CONTROL) {
			setSelectingMode(true);
		}

		int moveKey = 0;

		switch (ke.getKeyChar()) {
		case KeyEvent.VK_W:
			moveKey = 8;

			break;
		case KeyEvent.VK_S:
			moveKey = 9;

			break;
		case KeyEvent.VK_A:
			moveKey = 10;

			break;
		case KeyEvent.VK_F:
			moveKey = 11;

			break;

		default:
			break;

		}
		selectedShape.move(moveStep, moveKey);
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_CONTROL) {
			setSelectingMode(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}

	@Override
	public void mouseClicked(MouseEvent me) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		requestFocus();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent me) {
		pointMouseDown = me.getPoint();
		Shape shape = findTopMostShape(pointMouseDown);
		if (shape != null) {
			shape.setSelected(true);
			selectedShape = shape;
			repaint();
			System.out.println("shape selected!");
			for (int i = 0; i < shapes.size(); i++) {
				if (selectedShape == shapes.get(i)) {
					continue;
				} else
					shapes.get(i).setSelected(false);
			}
		} else {
			for (int i = 0; i < shapes.size(); i++) {
				shapes.get(i).setSelected(false);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO
		if (currentDrawingShape != null) {
			currentDrawingShape.setFilled(true);
			currentDrawingShape = null;
			repaint();
		}
		if (me.isMetaDown()) {
			Shape shape = findTopMostShape(pointMouseDown);
			if (shape != null || shapeTemp != null) {
				popupMenu.setVisible(true);
				popupMenu.show(this, me.getX(), me.getY());
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO
		System.out.println("drawingMode: " + drawingMode);
		if (isRandomColor())
			selectRandomColor();
		shapes.remove(currentDrawingShape);
		Point mr = me.getPoint();

		switch (draggingMode) {
		case Drag_Draw:
			switch (drawingMode) {
			case DM_RECT:
				Rectangle rectangle = new Rectangle(pointMouseDown, mr);
				rectangle.setColor(drawingColor);
				currentDrawingShape = rectangle;
				if (rectangle.getArea() >= ignorableShapeArea)
					shapes.add(rectangle);
				break;
			case DM_OVAL:
				Oval oval = new Oval(pointMouseDown, mr);
				oval.setColor(drawingColor);
				currentDrawingShape = oval;
				if (oval.getArea() >= ignorableShapeArea)
					shapes.add(oval);
				break;
			default:
				break;
			}

			break;
		case Drag_Move:
			selectedShape.move(pointMouseDown, mr);
			pointMouseDown = mr;
			break;

		case Drag_Resize:
			selectedShape.resize(pointMouseDown, mr, getCursor().getType());
			pointMouseDown = mr;

			break;

		default:
			break;
		}

		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent me) {//
		// TODO

		Shape shape = findTopMostShape(me.getPoint());
		if (shape != null) {
			Cursor c = shape.getResizingCursor(me.getPoint());
			if (c.equals(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR))) {
				draggingMode = Drag_Move;
			} else
				draggingMode = Drag_Resize;
			setCursor(c);
		} else {
			setCursor(Cursor.getDefaultCursor());
			draggingMode = Drag_Draw;
		}
	}

	public void deleteSelectedShape() {// bunu yapacaðýz...popmenu keyler
										// yapýlca
		shapes.remove(selectedShape);
		selectedShape = null;
		repaint();
	}

	public void moveSelectedShape(int direction) {
		// TODO
		if (selectedShape != null && selectedShape.isSelected()) {
			selectedShape.move(moveStep, direction);
			repaint();
		}
	}

	public void cutSelectedShape() {
		// TODO

		shapeTemp = selectedShape;
		shapes.remove(selectedShape);
		shapeTemp.setSelected(false);
		repaint();

	}

	public void copySelectedShape() {
		// TODO
		shapeTemp = selectedShape.copy();
		// shapes.addElement(shapeTemp);
		repaint();

	}

	public void pasteSelectedShape() {
		// TODO

		shapeTemp = selectedShape.copy();
		shapes.addElement(shapeTemp);
		shapeTemp.paste(pointMouseDown);

		repaint();

	}

	public void increaseIndexOfSelectedShape() {
		// TODO
		int index = shapes.indexOf(selectedShape);
		if (index < shapes.size() - 1) {
			index++;
			shapes.remove(selectedShape);
			shapes.add(index, selectedShape);
			repaint();
		}
	}

	public void decreaseIndexOfSelectedShape() {
		// TODO
		int index = shapes.indexOf(selectedShape);
		if (index >= 1) {
			index--;
			shapes.remove(selectedShape);
			shapes.add(index, selectedShape);
			repaint();
		}
	}

	public void selectRandomColor() {
		// TODO
		int r = new Random().nextInt(256);
		int g = new Random().nextInt(256);
		int b = new Random().nextInt(256);
		Color color = new Color(r, g, b);
		setDrawingColor(color);
	}

	public void clearAllShapes() {
		// TODO
		shapes.removeAllElements();
		repaint();
	}

	public void setDrawingMode(int drawingMode) {
		this.drawingMode = drawingMode;
		if (drawingMode == DM_TEXT) {
			setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			System.out.println("dra");
		} else if (drawingMode == DM_OVAL) {
			System.out.println("DM_OVAL");
		} else if (drawingMode == DM_RECT) {
			System.out.println("DM_RECTANGLE");
		} else {
			setCursor(Cursor.getDefaultCursor());
		}
	}

	public Color getDrawingColor() {
		return drawingColor;
	}

	public void setDrawingColor(Color drawingColor) {
		this.drawingColor = drawingColor;
	}

	public int getDrawingMode() {
		return drawingMode;
	}

	public int getDraggingMode() {
		return draggingMode;
	}

	public void setDraggingMode(int draggingMode) {
		this.draggingMode = draggingMode;
	}

	public Vector<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(Vector<Shape> shapes) {
		this.shapes = shapes;
		repaint();
	}

	public boolean isRandomColor() {
		return randomColor;

	}

	public void setRandomColor(boolean randomColor) {
		this.randomColor = randomColor;
	}

	public Shape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}

	public boolean isSelectingMode() {
		return selectingMode;
	}

	public void setSelectingMode(boolean selectingMode) {
		this.selectingMode = selectingMode;
	}

	public void undoSelectedShape() {
		// TODO Auto-generated method stub
		if (shapes.size() >= 1) {
			shapes.remove(shapes.lastElement());
			repaint();
		}
	}
}