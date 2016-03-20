/*
 * Created by JFormDesigner on Wed Jul 30 17:31:13 EEST 2008
 */

package drawingprj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Harun Ates
 */
public class MainFrame extends JFrame {
	private static Border selectedButtonBorder;
	private static Border defaultButtonBorder;

	private JButton btSelectedDM;
	private JButton btSelectedPC;
	private JButton btSelectedDC;
	//

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - harun ates
	private JMenuBar menuBar1;
	private JMenu mFile;
	private JMenuItem miNew;
	private JMenuItem miOpenFile;
	private JMenuItem miClose;
	private JMenuItem miSave;
	private JMenuItem miSaveAs;
	private JMenuItem miPrint;
	private JMenuItem miExit;
	private JMenu mEdit;
	private JMenuItem miUndo;
	private JMenuItem miRedo;
	private JMenuItem miCut;
	private JMenuItem miCopy;
	private JMenuItem miPaste;
	private JMenuItem miDelete;
	private JMenu mImage;
	private JMenuItem miRectangle;
	private JMenuItem miOval;
	private JMenuItem miText;
	private JMenuItem miClearAll;
	private JMenu miDrawingColor;
	private JRadioButtonMenuItem miDCRed;
	private JRadioButtonMenuItem miDCBlue;
	private JRadioButtonMenuItem miDCYellow;
	private JRadioButtonMenuItem miDCGreen;
	private JRadioButtonMenuItem miDCCyan;
	private JRadioButtonMenuItem miDCOrange;
	private JRadioButtonMenuItem miDCMagenta;
	private JMenu miPanelColor;
	private JRadioButtonMenuItem miPCCyan;
	private JRadioButtonMenuItem miPCMagenta;
	private JRadioButtonMenuItem miPCGreen;
	private JRadioButtonMenuItem miPCYellow;
	private JRadioButtonMenuItem miPCPurple;
	private JRadioButtonMenuItem miPCRed;
	private JRadioButtonMenuItem miPCBlue;
	private JMenu mWindow;
	private JMenu miScreenSize;
	private JRadioButtonMenuItem miSsSmall;
	private JRadioButtonMenuItem miSsmiddle;
	private JRadioButtonMenuItem miSsLarge;
	private JMenu mHelp;
	private JMenuItem miHelpContents;
	private JMenuItem miKeyAssist;
	private JMenuItem miLicense;
	private JMenuItem miAboutDrawingProject;
	private JPanel DrawingColorPanel;
	private JLabel label;
	private JButton btDCRed;
	private JButton btDCBlue;
	private JButton btDCYellow;
	private JButton btDCGreen;
	private JButton btDCCyan;
	private JButton btDCOrange;
	private JButton btDCMagenta;
	private JRadioButton btDCRandomColor;
	private DrawingPanel drawingPanel;
	private JPanel southPanel;
	private JButton btRect;
	private JButton btOval;
	private JButton btText;
	private JButton btDelete;
	private JPanel backgroundColorsPanel;
	private JLabel label2;
	private JButton btPCWhite;
	private JButton btPCMagenta;
	private JButton btPCGreen;
	private JButton btPCYellow;
	private JButton btPCPurple;
	private JButton btPCRed;
	private JButton btPCBlue;
	private JPanel directionsPanel;
	private JLabel label3;
	private JButton btUp;
	private JButton btdown;
	private JButton btleft;
	private JButton btright;
	private JLabel label4;
	private JButton btORUp;
	private JButton btORDown;

	public MainFrame() {
		initComponents();
		defaultButtonBorder = btRect.getBorder();
		selectedButtonBorder = BorderFactory.createCompoundBorder(
				new LineBorder(Color.BLACK, 3), defaultButtonBorder);
		initListeners();
	}

	private void initListeners() {
		DrawModeButtonActionListener dmbal = new DrawModeButtonActionListener();
		btRect.addActionListener(dmbal);
		btOval.addActionListener(dmbal);
		btText.addActionListener(dmbal);

		PanelColorButtonActionListener pcbal = new PanelColorButtonActionListener();

		btPCWhite.addActionListener(pcbal);
		btPCMagenta.addActionListener(pcbal);
		btPCBlue.addActionListener(pcbal);
		btPCGreen.addActionListener(pcbal);
		btPCPurple.addActionListener(pcbal);
		btPCRed.addActionListener(pcbal);
		btPCYellow.addActionListener(pcbal);

		PanelColorRdButtonsActionListener pcrdbal = new PanelColorRdButtonsActionListener();

		miPCCyan.addActionListener(pcrdbal);
		miPCMagenta.addActionListener(pcrdbal);
		miPCBlue.addActionListener(pcrdbal);
		miPCGreen.addActionListener(pcrdbal);
		miPCPurple.addActionListener(pcrdbal);
		miPCRed.addActionListener(pcrdbal);
		miPCYellow.addActionListener(pcrdbal);

		DrawingColorRdButtonsActionListener dcrbal = new DrawingColorRdButtonsActionListener();

		miDCCyan.addActionListener(dcrbal);
		miDCMagenta.addActionListener(dcrbal);
		miDCBlue.addActionListener(dcrbal);
		miDCGreen.addActionListener(dcrbal);
		miDCOrange.addActionListener(dcrbal);
		miDCRed.addActionListener(dcrbal);
		miDCYellow.addActionListener(dcrbal);

		DrawingColorButtonActionListener dcbal = new DrawingColorButtonActionListener();

		btDCCyan.addActionListener(dcbal);
		btDCMagenta.addActionListener(dcbal);
		btDCBlue.addActionListener(dcbal);
		btDCGreen.addActionListener(dcbal);
		btDCOrange.addActionListener(dcbal);
		btDCRed.addActionListener(dcbal);
		btDCYellow.addActionListener(dcbal);
	}

	private void btDeleteActionPerformed(ActionEvent e) {
		drawingPanel.deleteSelectedShape();
	}

	private void btUpActionPerformed(ActionEvent e) {
		drawingPanel.moveSelectedShape(Shape.NORTH);
	}

	private void btdownActionPerformed(ActionEvent e) {
		drawingPanel.moveSelectedShape(Shape.SOUTH);
	}

	private void btleftActionPerformed(ActionEvent e) {
		drawingPanel.moveSelectedShape(Shape.WEST);
	}

	private void btrightActionPerformed(ActionEvent e) {
		drawingPanel.moveSelectedShape(Shape.EAST);
	}

	private void miSaveActionPerformed(ActionEvent e) {

		BufferedImage image2 = new BufferedImage(drawingPanel.getWidth(),
				drawingPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = image2.createGraphics();
		drawingPanel.paint(graphics2D);
		try {
			ImageIO.write(image2, "png", new File(
					"C:/Users/HAKAN AYDIN/Desktop/hakana.png"));
			System.out.println("panel saved as image");
		} catch (IOException ox) {
			// TODO: handle exception
			ox.printStackTrace();

		}

	}

	@SuppressWarnings("unchecked")
	private void miOpenFileActionPerformed(ActionEvent e) {
		if (drawingPanel.isVisible() != true) {
			drawingPanel.setVisible(true);
		}
		FileFilter filter = new FileNameExtensionFilter("DrawingProjects", "dp");
		JFileChooser fc = new JFileChooser();
		fc.getCurrentDirectory();
		fc.addChoosableFileFilter(filter);
		int res = fc.showOpenDialog(this);
		if (res == JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(fc.getSelectedFile()));
				Vector<Shape> shapes = (Vector<Shape>) ois.readObject();
				drawingPanel.setShapes(shapes);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void btORUpActionPerformed(ActionEvent e) {
		drawingPanel.increaseIndexOfSelectedShape();
	}

	private void btORDownActionPerformed(ActionEvent e) {
		drawingPanel.decreaseIndexOfSelectedShape();
	}

	private void btDCRandomColorActionPerformed(ActionEvent e) { // buraya
																	// ekledim..
		if (btSelectedDC != null) {
			btSelectedDC.setBorder(defaultButtonBorder);
		}
		if (btDCRandomColor.isSelected()) {
			drawingPanel.selectRandomColor();
			System.out.println("btnDcrandomcolor");
			drawingPanel.setRandomColor(true);

		} else {
			drawingPanel.setDrawingColor(Color.RED);
			drawingPanel.setRandomColor(false);
		}
	}

	private void miDeleteActionPerformed(ActionEvent e) {
		drawingPanel.deleteSelectedShape();

	}

	private void miRectangleActionPerformed(ActionEvent e) {
		drawingPanel.setDrawingMode(DrawingPanel.DM_RECT);
	}

	private void miOvalActionPerformed(ActionEvent e) {
		drawingPanel.setDrawingMode(DrawingPanel.DM_OVAL);
	}

	private void miTextActionPerformed(ActionEvent e) {
		drawingPanel.setDrawingMode(DrawingPanel.DM_TEXT);
	}

	private void miClearAllActionPerformed(ActionEvent e) {
		drawingPanel.clearAllShapes();

	}

	private void miSsSmallActionPerformed(ActionEvent e) {
		setSize(450, 300);
	}

	private void miSsmiddleActionPerformed(ActionEvent e) {
		setSize(getPreferredSize());
	}

	private void miSsLargeActionPerformed(ActionEvent e) {
		setSize(getPreferredSize());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void miNewActionPerformed(ActionEvent e) {
		if (drawingPanel.isVisible() == true) {
			if (drawingPanel.getShapes().isEmpty() == false) {
				int answer = JOptionPane
						.showConfirmDialog(null,
								"Do you want to save the changes?",
								"DRAWING PROJECT 1.0",
								JOptionPane.YES_NO_CANCEL_OPTION);

				switch (answer) {
				case JOptionPane.YES_OPTION:
					miSaveAsActionPerformed(e);
					break;
				case JOptionPane.NO_OPTION:
					drawingPanel.clearAllShapes();
					break;
				default:
					break;
				}
			}
		}
		drawingPanel.setVisible(true);
	}

	private void thisWindowClosing(WindowEvent e) {
		if (drawingPanel.isVisible() != true) {
			System.exit(0);
		}
		if (drawingPanel.getShapes().isEmpty()) {
			System.exit(0);
		}
		int answer = JOptionPane.showConfirmDialog(null,
				"Do you want to save the changes?", "DRAWING PROJECT 1.0",
				JOptionPane.YES_NO_CANCEL_OPTION);

		switch (answer) {
		case JOptionPane.YES_OPTION:
			System.out.println("yes button clicked");
			break;
		case JOptionPane.NO_OPTION:
			System.exit(0);
			break;
		default:
			break;
		}
	}

	private void miCloseActionPerformed(ActionEvent e) {
		if (drawingPanel.getShapes().isEmpty()) {
			drawingPanel.clearAllShapes();
			drawingPanel.setVisible(false);
		}
		if (drawingPanel.isVisible() != true)
			return;
		int answer = JOptionPane.showConfirmDialog(null,
				"Do you want to save the changes?", "DRAWING PROJECT 1.0",
				JOptionPane.YES_NO_CANCEL_OPTION);
		switch (answer) {
		case JOptionPane.YES_OPTION:
			miSaveAsActionPerformed(e);
			drawingPanel.clearAllShapes();
			drawingPanel.setVisible(false);
			break;
		case JOptionPane.NO_OPTION:
			drawingPanel.clearAllShapes();
			drawingPanel.setVisible(false);
			break;
		default:
			break;
		}
	}

	private void miSaveAsActionPerformed(ActionEvent e) {
		// if (drawingPanel.isVisible() != true)
		// return;
		//
		// JFileChooser fc = new JFileChooser();
		// FileFilter filter = new FileNameExtensionFilter(
		// "DrawingProjects(*.dp)", "dp");
		// fc.setAcceptAllFileFilterUsed(false);
		// // fc.setFileFilter(filter); // <------
		// fc.addChoosableFileFilter(filter);
		// fc.setFileFilter(filter);
		// fc.getCurrentDirectory();
		// fc.getFileFilter();
		// int res = fc.showDialog(MainFrame.this, "Save As");
		// if (res == JFileChooser.APPROVE_OPTION) {
		// try {
		// ObjectOutputStream oos = new ObjectOutputStream(
		// new FileOutputStream(fc.getSelectedFile()));
		// oos.writeObject(drawingPanel.getShapes());
		// oos.flush();
		// oos.close();
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		// }

		BufferedImage image2 = new BufferedImage(drawingPanel.getWidth(),
				drawingPanel.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		JFileChooser jFile = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("png(*.png)",
				"jpeg(*.jpeg)", "bmp(*.bmp)", "gif(*.gif)");

		jFile.setFileFilter(filter); // <------
		jFile.addChoosableFileFilter(filter);
		jFile.setFileFilter(filter);
		jFile.getCurrentDirectory();
		jFile.getFileFilter();

		jFile.showSaveDialog(null);
		String pth = jFile.getSelectedFile().getPath();
		JOptionPane.showMessageDialog(null, pth.toString());
		Graphics2D graphics2D = image2.createGraphics();
		drawingPanel.paint(graphics2D);
		try {
			ImageIO.write(image2, "png", new File(pth.toString() + ".jpeg"));
			System.out.println("panel saved as image");
		} catch (IOException ox) {
			// TODO: handle exception
			ox.printStackTrace();

		}
	}

	private void miPrintActionPerformed(ActionEvent e) {
		PrinterJob job = PrinterJob.getPrinterJob();
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		// PageFormat pf = job.pageDialog( aset );
		// job.setPrintable(new PrintDialogExample(), pf);
		boolean ok = job.printDialog(aset);
		if (ok) {
			try {
				job.print(aset);
			} catch (PrinterException ex) {
				/* The job did not successfully complete */
			}
		}
	}

	private void miExitActionPerformed(ActionEvent e) {
		if (drawingPanel.isVisible() != true) {
			System.exit(0);
		}
		if (drawingPanel.getShapes().isEmpty()) {
			System.exit(0);
		}
		int answer = JOptionPane.showConfirmDialog(null,
				"Do you want to save the changes?", "DRAWING PROJECT 1.0",
				JOptionPane.YES_NO_CANCEL_OPTION);

		switch (answer) {
		case JOptionPane.YES_OPTION:
			miSaveAsActionPerformed(e);
			System.exit(0);
			break;
		case JOptionPane.NO_OPTION:
			System.exit(0);
			break;
		default:
			break;
		}

	}

	private void miUndoActionPerformed(ActionEvent e) {
		drawingPanel.undoSelectedShape();
	}

	private void miCutActionPerformed(ActionEvent e) {
		drawingPanel.cutSelectedShape();
	}

	private void miCopyActionPerformed(ActionEvent e) {
		drawingPanel.copySelectedShape();
	}

	private void miPasteActionPerformed(ActionEvent e) {
		drawingPanel.pasteSelectedShape();
	}

	private class DrawModeButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if (btSelectedDM != null) {
				btSelectedDM.setBorder(defaultButtonBorder);
			}

			button.setBorder(selectedButtonBorder);
			btSelectedDM = button;
			int dm = -1;
			if (button == btRect) {
				dm = DrawingPanel.DM_RECT;
			} else if (button == btOval) {
				dm = DrawingPanel.DM_OVAL;
			} else if (button == btText) {
				dm = DrawingPanel.DM_TEXT;
			}
			drawingPanel.setDrawingMode(dm);
		}
	}

	private class PanelColorButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if (btSelectedPC != null) {
				btSelectedPC.setBorder(defaultButtonBorder);
			}
			button.setBorder(selectedButtonBorder);
			btSelectedPC = button;
			drawingPanel.setBackground(button.getBackground());
		}
	}

	private class DrawingColorButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton button = (JButton) e.getSource();

			// mark previos selected button as deselected
			if (btSelectedDC != null) {
				btSelectedDC.setBorder(defaultButtonBorder);
			}

			// make clicked button as selected,
			button.setBorder(selectedButtonBorder);
			btSelectedDC = button;

			// in case drawing panel is in random color mode, fix it.
			drawingPanel.setRandomColor(false);
			btDCRandomColor.setSelected(false);

			drawingPanel.setDrawingColor(button.getBackground());

		}

	}

	private class PanelColorRdButtonsActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButtonMenuItem button = (JRadioButtonMenuItem) e.getSource();
			drawingPanel.setBackground(button.getBackground());
		}

	}

	private class DrawingColorRdButtonsActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButtonMenuItem button = (JRadioButtonMenuItem) e.getSource();
			drawingPanel.setRandomColor(false);
			btDCRandomColor.setSelected(false);

			drawingPanel.setDrawingColor(button.getBackground());
		}

	}

	private void initComponents() {

		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - harun ates
		menuBar1 = new JMenuBar();
		mFile = new JMenu();
		miNew = new JMenuItem();
		miOpenFile = new JMenuItem();
		miClose = new JMenuItem();
		miSave = new JMenuItem();
		miSaveAs = new JMenuItem();
		miPrint = new JMenuItem();
		miExit = new JMenuItem();
		mEdit = new JMenu();
		miUndo = new JMenuItem();
		miRedo = new JMenuItem();
		miCut = new JMenuItem();
		miCopy = new JMenuItem();
		miPaste = new JMenuItem();
		miDelete = new JMenuItem();
		mImage = new JMenu();
		miRectangle = new JMenuItem();
		miOval = new JMenuItem();
		miText = new JMenuItem();
		miClearAll = new JMenuItem();
		miDrawingColor = new JMenu();
		miDCRed = new JRadioButtonMenuItem();
		miDCBlue = new JRadioButtonMenuItem();
		miDCYellow = new JRadioButtonMenuItem();
		miDCGreen = new JRadioButtonMenuItem();
		miDCCyan = new JRadioButtonMenuItem();
		miDCOrange = new JRadioButtonMenuItem();
		miDCMagenta = new JRadioButtonMenuItem();
		miPanelColor = new JMenu();
		miPCCyan = new JRadioButtonMenuItem();
		miPCMagenta = new JRadioButtonMenuItem();
		miPCGreen = new JRadioButtonMenuItem();
		miPCYellow = new JRadioButtonMenuItem();
		miPCPurple = new JRadioButtonMenuItem();
		miPCRed = new JRadioButtonMenuItem();
		miPCBlue = new JRadioButtonMenuItem();
		mWindow = new JMenu();
		miScreenSize = new JMenu();
		miSsSmall = new JRadioButtonMenuItem();
		miSsmiddle = new JRadioButtonMenuItem();
		miSsLarge = new JRadioButtonMenuItem();
		mHelp = new JMenu();
		miHelpContents = new JMenuItem();
		miKeyAssist = new JMenuItem();
		miLicense = new JMenuItem();
		miAboutDrawingProject = new JMenuItem();
		DrawingColorPanel = new JPanel();
		label = new JLabel();
		btDCRed = new JButton();
		btDCBlue = new JButton();
		btDCYellow = new JButton();
		btDCGreen = new JButton();
		btDCCyan = new JButton();
		btDCOrange = new JButton();
		btDCMagenta = new JButton();
		btDCRandomColor = new JRadioButton();
		drawingPanel = new DrawingPanel();
		southPanel = new JPanel();
		btRect = new JButton();
		btOval = new JButton();
		btText = new JButton();
		btDelete = new JButton();
		backgroundColorsPanel = new JPanel();
		label2 = new JLabel();
		btPCWhite = new JButton();
		btPCMagenta = new JButton();
		btPCGreen = new JButton();
		btPCYellow = new JButton();
		btPCPurple = new JButton();
		btPCRed = new JButton();
		btPCBlue = new JButton();
		directionsPanel = new JPanel();
		label3 = new JLabel();
		btUp = new JButton();
		btdown = new JButton();
		btleft = new JButton();
		btright = new JButton();
		label4 = new JLabel();
		btORUp = new JButton();
		btORDown = new JButton();
		// ======== this ========
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("DRAWING PROJECT 1.0");
		setFocusable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				thisWindowClosing(e);
			}
		});
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(1, 1));

		// ======== menuBar1 ========
		{

			// ======== mFile ========
			{
				mFile.setText("File");
				mFile.setForeground(new Color(153, 0, 153));

				// ---- miNew ----
				miNew.setText("New");
				miNew.setIcon(UIManager.getIcon("FileChooser.newFolderIcon"));
				miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
						KeyEvent.CTRL_MASK));
				miNew.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miNewActionPerformed(e);
					}
				});
				mFile.add(miNew);

				// ---- miOpenFile ----
				miOpenFile.setText("Open File");
				miOpenFile.setIcon(UIManager
						.getIcon("FileChooser.upFolderIcon"));
				miOpenFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
						KeyEvent.CTRL_MASK));
				miOpenFile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miOpenFileActionPerformed(e);
					}
				});
				mFile.add(miOpenFile);
				mFile.addSeparator();

				// ---- miClose ----
				miClose.setText("Close");
				miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
						KeyEvent.CTRL_MASK));
				miClose.setIcon(UIManager.getIcon("InternalFrame.closeIcon"));
				miClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miCloseActionPerformed(e);
					}
				});
				mFile.add(miClose);
				mFile.addSeparator();

				// ---- miSave ----
				miSave.setText("Save");
				miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
						KeyEvent.CTRL_MASK));
				miSave.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/save.jpg")));
				miSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miSaveActionPerformed(e);
					}
				});
				mFile.add(miSave);

				// ---- miSaveAs ----
				miSaveAs.setText("Save As");
				miSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
						KeyEvent.CTRL_MASK | KeyEvent.SHIFT_MASK));
				miSaveAs.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/saveas.jpg")));
				miSaveAs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miSaveAsActionPerformed(e);
					}
				});
				mFile.add(miSaveAs);
				mFile.addSeparator();

				// ---- miPrint ----
				miPrint.setText("Print");
				miPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
						KeyEvent.CTRL_MASK));
				miPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miPrintActionPerformed(e);
					}
				});
				mFile.add(miPrint);
				mFile.addSeparator();

				// ---- miExit ----
				miExit.setText("Exit");
				miExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
						KeyEvent.ALT_MASK));
				miExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miExitActionPerformed(e);
					}
				});
				mFile.add(miExit);
			}
			menuBar1.add(mFile);

			// ======== mEdit ========
			{
				mEdit.setText("Edit");
				mEdit.setForeground(new Color(153, 0, 153));

				// ---- miUndo ----
				miUndo.setText("Undo");
				miUndo.setDisabledSelectedIcon(null);
				miUndo.setMnemonic('Z');
				miUndo.setHideActionText(true);
				miUndo.setHorizontalAlignment(SwingConstants.LEFT);
				miUndo.setHorizontalTextPosition(SwingConstants.RIGHT);
				miUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
						KeyEvent.CTRL_MASK));
				miUndo.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/undo.jpg")));
				miUndo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miUndoActionPerformed(e);
					}
				});
				mEdit.add(miUndo);

				// ---- miRedo ----
				miRedo.setText("Redo");
				miRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
						KeyEvent.CTRL_MASK));
				miRedo.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/redo.jpg")));
				mEdit.add(miRedo);
				mEdit.addSeparator();

				// ---- miCut ----
				miCut.setText("Cut");
				miCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
						KeyEvent.CTRL_MASK));
				miCut.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/cut.jpg")));
				miCut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miCutActionPerformed(e);
					}
				});
				mEdit.add(miCut);

				// ---- miCopy ----
				miCopy.setText("Copy");
				miCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
						KeyEvent.CTRL_MASK));
				miCopy.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/copy.jpg")));
				miCopy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miCopyActionPerformed(e);
					}
				});
				mEdit.add(miCopy);

				// ---- miPaste ----
				miPaste.setText("Paste");
				miPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
						KeyEvent.CTRL_MASK));
				miPaste.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/paste.jpg")));
				miPaste.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miPasteActionPerformed(e);
					}
				});
				mEdit.add(miPaste);
				mEdit.addSeparator();

				// ---- miDelete ----
				miDelete.setText("Delete");
				miDelete.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_DELETE, 0));
				miDelete.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/delete3.jpg")));
				miDelete.setRolloverIcon(new ImageIcon("C:\\delete2.jpg"));
				miDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miDeleteActionPerformed(e);
					}
				});
				mEdit.add(miDelete);
			}
			menuBar1.add(mEdit);

			// ======== mImage ========
			{
				mImage.setText("Image");
				mImage.setForeground(new Color(153, 0, 153));

				// ---- miRectangle ----
				miRectangle.setText("Rectangle");
				miRectangle.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/rect.jpg")));
				miRectangle.setRolloverIcon(null);
				miRectangle.setRolloverSelectedIcon(null);
				miRectangle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miRectangleActionPerformed(e);
					}
				});
				mImage.add(miRectangle);

				// ---- miOval ----
				miOval.setText("Oval");
				miOval.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/circle.jpg")));
				miOval.setRolloverSelectedIcon(new ImageIcon("C:\\circle2.jpg"));
				miOval.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miOvalActionPerformed(e);
					}
				});
				mImage.add(miOval);

				// ---- miText ----
				miText.setText("Text");
				miText.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/text1.jpg")));
				miText.setRolloverIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/text2.jpg")));
				miText.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miTextActionPerformed(e);
					}
				});
				mImage.add(miText);
				mImage.addSeparator();

				// ---- miClearAll ----
				miClearAll.setText("Clear All");
				miClearAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
						KeyEvent.CTRL_MASK | KeyEvent.SHIFT_MASK));
				miClearAll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miClearAllActionPerformed(e);
					}
				});
				mImage.add(miClearAll);
				mImage.addSeparator();

				// ======== miDrawingColor ========
				{
					miDrawingColor.setText("Drawing Color");

					// ---- miDCRed ----
					miDCRed.setText("Red");
					miDCRed.setBackground(new Color(255, 51, 51));
					miDCRed.setFocusPainted(true);
					miDCRed.setRolloverEnabled(true);
					miDCRed.setForeground(new Color(255, 102, 255));
					miDrawingColor.add(miDCRed);

					// ---- miDCBlue ----
					miDCBlue.setText("Blue");
					miDCBlue.setBackground(new Color(51, 51, 255));
					miDCBlue.setForeground(new Color(255, 102, 255));
					miDrawingColor.add(miDCBlue);

					// ---- miDCYellow ----
					miDCYellow.setText("Yellow");
					miDCYellow.setBackground(new Color(255, 255, 51));
					miDCYellow.setForeground(new Color(255, 102, 255));
					miDrawingColor.add(miDCYellow);

					// ---- miDCGreen ----
					miDCGreen.setText("Green");
					miDCGreen.setBackground(new Color(0, 255, 51));
					miDCGreen.setForeground(new Color(255, 102, 255));
					miDrawingColor.add(miDCGreen);

					// ---- miDCCyan ----
					miDCCyan.setText("Cyan");
					miDCCyan.setBackground(Color.cyan);
					miDCCyan.setForeground(new Color(255, 102, 255));
					miDrawingColor.add(miDCCyan);

					// ---- miDCOrange ----
					miDCOrange.setText("Orange");
					miDCOrange.setBackground(new Color(255, 204, 0));
					miDCOrange.setForeground(new Color(255, 102, 255));
					miDrawingColor.add(miDCOrange);

					// ---- miDCMagenta ----
					miDCMagenta.setText("Magenta");
					miDCMagenta.setBackground(new Color(102, 0, 102));
					miDCMagenta.setForeground(new Color(255, 102, 255));
					miDrawingColor.add(miDCMagenta);
				}
				mImage.add(miDrawingColor);

				// ======== miPanelColor ========
				{
					miPanelColor.setText("Panel Color");

					// ---- miPCCyan ----
					miPCCyan.setText("Cyan");
					miPCCyan.setBackground(new Color(153, 255, 255));
					miPCCyan.setForeground(new Color(255, 102, 255));
					miPanelColor.add(miPCCyan);

					// ---- miPCMagenta ----
					miPCMagenta.setText("Magenta");
					miPCMagenta.setBackground(new Color(255, 51, 255));
					miPCMagenta.setForeground(new Color(153, 0, 153));
					miPanelColor.add(miPCMagenta);

					// ---- miPCGreen ----
					miPCGreen.setText("Green");
					miPCGreen.setBackground(new Color(102, 255, 102));
					miPCGreen.setForeground(new Color(255, 102, 255));
					miPanelColor.add(miPCGreen);

					// ---- miPCYellow ----
					miPCYellow.setText("Yellow");
					miPCYellow.setBackground(Color.yellow);
					miPCYellow.setForeground(new Color(255, 102, 255));
					miPanelColor.add(miPCYellow);

					// ---- miPCPurple ----
					miPCPurple.setText("Purple");
					miPCPurple.setBackground(new Color(153, 0, 153));
					miPCPurple.setForeground(new Color(255, 102, 255));
					miPanelColor.add(miPCPurple);

					// ---- miPCRed ----
					miPCRed.setText("Red");
					miPCRed.setBackground(new Color(255, 51, 51));
					miPCRed.setForeground(new Color(255, 102, 255));
					miPanelColor.add(miPCRed);

					// ---- miPCBlue ----
					miPCBlue.setText("Blue");
					miPCBlue.setBackground(Color.blue);
					miPCBlue.setForeground(new Color(255, 102, 255));
					miPanelColor.add(miPCBlue);
				}
				mImage.add(miPanelColor);
			}
			menuBar1.add(mImage);

			// ======== mWindow ========
			{
				mWindow.setText("Window");
				mWindow.setForeground(new Color(153, 0, 153));

				// ======== miScreenSize ========
				{
					miScreenSize.setText("Screen Size");

					// ---- miSsSmall ----
					miSsSmall.setText("Small");
					miSsSmall.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							miSsSmallActionPerformed(e);
						}
					});
					miScreenSize.add(miSsSmall);

					// ---- miSsmiddle ----
					miSsmiddle.setText("Middle");
					miSsmiddle.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							miSsmiddleActionPerformed(e);
						}
					});
					miScreenSize.add(miSsmiddle);

					// ---- miSsLarge ----
					miSsLarge.setText("Large");
					miSsLarge.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							miSsLargeActionPerformed(e);
						}
					});
					miScreenSize.add(miSsLarge);
				}
				mWindow.add(miScreenSize);
			}
			menuBar1.add(mWindow);

			// ======== mHelp ========
			{
				mHelp.setText("Help");
				mHelp.setForeground(new Color(153, 0, 153));

				// ---- miHelpContents ----
				miHelpContents.setText("Help Contents");
				miHelpContents.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/help.jpg")));
				mHelp.add(miHelpContents);

				// ---- miKeyAssist ----
				miKeyAssist.setText("Key Assist");
				miKeyAssist.setAccelerator(KeyStroke
						.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_MASK
								| KeyEvent.SHIFT_MASK));
				miKeyAssist.setIcon(new ImageIcon(getClass().getResource(
						"/drawingprj/images/key.jpg")));
				mHelp.add(miKeyAssist);

				// ---- miLicense ----
				miLicense.setText("License");
				mHelp.add(miLicense);

				// ---- miAboutDrawingProject ----
				miAboutDrawingProject.setText("About Drawing Project");
				mHelp.add(miAboutDrawingProject);
			}
			menuBar1.add(mHelp);
		}
		setJMenuBar(menuBar1);

		// ======== DrawingColorPanel ========
		{

			// JFormDesigner evaluation mark
			DrawingColorPanel
					.setBorder(new javax.swing.border.CompoundBorder(
							new javax.swing.border.TitledBorder(
									new javax.swing.border.EmptyBorder(0, 0, 0,
											0), "JFormDesigner Evaluation",
									javax.swing.border.TitledBorder.CENTER,
									javax.swing.border.TitledBorder.BOTTOM,
									new java.awt.Font("Dialog",
											java.awt.Font.BOLD, 12),
									java.awt.Color.red), DrawingColorPanel
									.getBorder()));
			DrawingColorPanel
					.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
						public void propertyChange(
								java.beans.PropertyChangeEvent e) {
							if ("border".equals(e.getPropertyName()))
								throw new RuntimeException();
						}
					});

			DrawingColorPanel.setLayout(new FlowLayout());

			// ---- label ----
			label.setText("Drawing Color: ");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(new Color(153, 0, 153));
			DrawingColorPanel.add(label);

			// ---- btDCRed ----
			btDCRed.setText(" ");
			btDCRed.setBackground(new Color(255, 51, 51));
			btDCRed.setFocusable(false);
			btDCRed.setSelectedIcon(null);
			btDCRed.setToolTipText("Red");
			DrawingColorPanel.add(btDCRed);

			// ---- btDCBlue ----
			btDCBlue.setText(" ");
			btDCBlue.setFocusable(false);
			btDCBlue.setBackground(new Color(51, 51, 255));
			btDCBlue.setToolTipText("Blue");
			DrawingColorPanel.add(btDCBlue);

			// ---- btDCYellow ----
			btDCYellow.setText(" ");
			btDCYellow.setFocusable(false);
			btDCYellow.setBackground(new Color(255, 255, 51));
			btDCYellow.setToolTipText("Yellow");
			DrawingColorPanel.add(btDCYellow);

			// ---- btDCGreen ----
			btDCGreen.setText(" ");
			btDCGreen.setFocusable(false);
			btDCGreen.setBackground(new Color(0, 255, 51));
			btDCGreen.setToolTipText("Green");
			DrawingColorPanel.add(btDCGreen);

			// ---- btDCCyan ----
			btDCCyan.setText(" ");
			btDCCyan.setFocusable(false);
			btDCCyan.setBackground(Color.cyan);
			btDCCyan.setToolTipText("Cyan");
			DrawingColorPanel.add(btDCCyan);

			// ---- btDCOrange ----
			btDCOrange.setText(" ");
			btDCOrange.setFocusable(false);
			btDCOrange.setBackground(new Color(255, 204, 0));
			btDCOrange.setToolTipText("Orange");
			DrawingColorPanel.add(btDCOrange);

			// ---- btDCMagenta ----
			btDCMagenta.setBackground(new Color(102, 0, 102));
			btDCMagenta.setFocusable(false);
			btDCMagenta.setDoubleBuffered(true);
			btDCMagenta.setText(" ");
			btDCMagenta.setToolTipText("Magenta");
			DrawingColorPanel.add(btDCMagenta);

			// ---- btDCRandomColor ----
			btDCRandomColor.setText("Random Color");
			btDCRandomColor.setForeground(new Color(153, 0, 153));
			btDCRandomColor.setHorizontalAlignment(SwingConstants.TRAILING);
			btDCRandomColor.setRequestFocusEnabled(false);
			btDCRandomColor.setFocusable(false);
			btDCRandomColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btDCRandomColorActionPerformed(e);
				}
			});
			DrawingColorPanel.add(btDCRandomColor);
		}
		contentPane.add(DrawingColorPanel, BorderLayout.NORTH);

		// ---- drawingPanel ----
		drawingPanel.setBackground(Color.white);
		drawingPanel.setBorder(LineBorder.createGrayLineBorder());
		contentPane.add(drawingPanel, BorderLayout.CENTER);

		// ======== AltgrupPanel ========
		{
			southPanel.setBorder(new EtchedBorder());
			southPanel.setFocusable(false);
			southPanel.setLayout(new FlowLayout());

			// ---- btRect ----
			btRect.setBackground(Color.white);
			btRect.setFocusable(false);
			btRect.setIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/rect.jpg")));
			btRect.setToolTipText("Draw a Rectangle");
			btRect.setRolloverIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/rect2.jpg")));
			btRect.setSelectedIcon(null);
			btRect.setText("Rectangle");
			btRect.setVerticalTextPosition(SwingConstants.BOTTOM);
			btRect.setHorizontalTextPosition(SwingConstants.CENTER);
			btRect.setForeground(new Color(153, 0, 153));
			btRect.setActionCommand("Rectangle");
			btRect.setVerticalAlignment(SwingConstants.TOP);
			southPanel.add(btRect);

			// ---- btOval ----
			btOval.setBackground(Color.white);
			btOval.setFocusable(false);
			btOval.setIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/circle.jpg")));
			btOval.setVerticalAlignment(SwingConstants.TOP);
			btOval.setToolTipText("Draw a Circle");
			btOval.setRolloverIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/circle2.jpg")));
			btOval.setText("Oval");
			btOval.setVerticalTextPosition(SwingConstants.BOTTOM);
			btOval.setHorizontalTextPosition(SwingConstants.CENTER);
			btOval.setForeground(new Color(153, 0, 153));
			southPanel.add(btOval);

			// ---- btText ----
			btText.setText("Text");
			btText.setIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/text1.jpg")));
			btText.setBackground(Color.white);
			btText.setHorizontalTextPosition(SwingConstants.CENTER);
			btText.setVerticalTextPosition(SwingConstants.BOTTOM);
			btText.setFocusable(false);
			btText.setRolloverIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/text2.jpg")));
			btText.setForeground(new Color(153, 0, 153));
			southPanel.add(btText);

			// ---- btDelete ----
			btDelete.setBackground(Color.white);
			btDelete.setFocusable(false);
			btDelete.setIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/delete.jpg")));
			btDelete.setToolTipText("Delete this item.");
			btDelete.setRolloverIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/delete2.jpg")));
			btDelete.setText("Delete");
			btDelete.setVerticalTextPosition(SwingConstants.BOTTOM);
			btDelete.setHorizontalTextPosition(SwingConstants.CENTER);
			btDelete.setForeground(new Color(153, 0, 153));
			btDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btDeleteActionPerformed(e);
				}
			});
			southPanel.add(btDelete);
		}
		contentPane.add(southPanel, BorderLayout.SOUTH);

		// ======== PanelColorsPanel ========
		{
			backgroundColorsPanel.setBorder(new EtchedBorder());
			backgroundColorsPanel.setLayout(new GridLayout(8, 1, 20, 5));

			// ---- label2 ----
			label2.setText("Panel Colors");
			label2.setHorizontalAlignment(SwingConstants.CENTER);
			label2.setForeground(new Color(153, 0, 153));
			backgroundColorsPanel.add(label2);

			// ---- btPCWhite ----
			btPCWhite.setBackground(Color.white);
			btPCWhite.setFocusable(false);
			btPCWhite.setToolTipText("Cyan");
			backgroundColorsPanel.add(btPCWhite);

			// ---- btPCMagenta ----
			btPCMagenta.setFocusable(false);
			btPCMagenta.setBackground(new Color(255, 51, 255));
			btPCMagenta.setToolTipText("Magenta");
			backgroundColorsPanel.add(btPCMagenta);

			// ---- btPCGreen ----
			btPCGreen.setFocusable(false);
			btPCGreen.setBackground(new Color(102, 255, 102));
			btPCGreen.setToolTipText("Green");
			backgroundColorsPanel.add(btPCGreen);

			// ---- btPCYellow ----
			btPCYellow.setFocusable(false);
			btPCYellow.setBackground(Color.yellow);
			btPCYellow.setToolTipText("Yellow");
			backgroundColorsPanel.add(btPCYellow);

			// ---- btPCPurple ----
			btPCPurple.setFocusable(false);
			btPCPurple.setBackground(new Color(153, 0, 153));
			btPCPurple.setToolTipText("Purple");
			backgroundColorsPanel.add(btPCPurple);

			// ---- btPCRed ----
			btPCRed.setFocusable(false);
			btPCRed.setBackground(new Color(255, 51, 51));
			btPCRed.setToolTipText("Red");
			backgroundColorsPanel.add(btPCRed);

			// ---- btPCBlue ----
			btPCBlue.setFocusable(false);
			btPCBlue.setBackground(Color.blue);
			btPCBlue.setToolTipText("Blue");
			backgroundColorsPanel.add(btPCBlue);
		}
		contentPane.add(backgroundColorsPanel, BorderLayout.WEST);

		// ======== DirectionsPanel ========
		{
			directionsPanel.setLayout(new GridLayout(8, 1, 0, 5));

			// ---- label3 ----
			label3.setText("Directions");
			label3.setHorizontalAlignment(SwingConstants.CENTER);
			label3.setForeground(new Color(153, 0, 153));
			directionsPanel.add(label3);

			// ---- btUp ----
			btUp.setIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/upr.gif")));
			btUp.setBackground(new Color(51, 255, 0));
			btUp.setFocusable(false);
			btUp.setToolTipText("Move shape to up");
			btUp.setForeground(new Color(153, 0, 153));
			btUp.setRolloverIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/upg.gif")));
			btUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btUpActionPerformed(e);
				}
			});
			directionsPanel.add(btUp);

			// ---- btdown ----
			btdown.setFocusable(false);
			btdown.setIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/downr.gif")));
			btdown.setBackground(new Color(51, 255, 0));
			btdown.setToolTipText("Move shape to down");
			btdown.setRolloverIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/downg.gif")));
			btdown.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btdownActionPerformed(e);
				}
			});
			directionsPanel.add(btdown);

			// ---- btleft ----
			btleft.setFocusable(false);
			btleft.setIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/leftr.gif")));
			btleft.setBackground(new Color(51, 255, 0));
			btleft.setToolTipText("Move shape to left");
			btleft.setRolloverIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/leftg.gif")));
			btleft.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btleftActionPerformed(e);
				}
			});
			directionsPanel.add(btleft);

			// ---- btright ----
			btright.setFocusable(false);
			btright.setIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/rightr.gif")));
			btright.setBackground(new Color(51, 255, 0));
			btright.setToolTipText("Move shape to right");
			btright.setRolloverIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/rightg.gif")));
			btright.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btrightActionPerformed(e);
				}
			});
			directionsPanel.add(btright);

			// ---- label4 ----
			label4.setText("Order");
			label4.setHorizontalAlignment(SwingConstants.CENTER);
			label4.setForeground(new Color(153, 0, 153));
			directionsPanel.add(label4);

			// ---- btORUp ----
			btORUp.setFocusable(false);
			btORUp.setBackground(new Color(255, 255, 51));
			btORUp.setIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/plusr.gif")));
			btORUp.setToolTipText("Move shape layer up");
			btORUp.setRolloverIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/plusy.gif")));
			btORUp.setAutoscrolls(true);
			btORUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btORUpActionPerformed(e);
				}
			});
			directionsPanel.add(btORUp);

			// ---- btORDown ----
			btORDown.setFocusable(false);
			btORDown.setBackground(new Color(255, 255, 51));
			btORDown.setIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/substractionr.gif")));
			btORDown.setToolTipText("Move shape layer down");
			btORDown.setRolloverIcon(new ImageIcon(getClass().getResource(
					"/drawingprj/images/substractiony.gif")));
			btORDown.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btORDownActionPerformed(e);
				}
			});
			directionsPanel.add(btORDown);
		}
		contentPane.add(directionsPanel, BorderLayout.EAST);
		pack();
		setLocationRelativeTo(null);

		// ---- buttonGroupMiDC ----
		ButtonGroup buttonGroupMiDC = new ButtonGroup();
		buttonGroupMiDC.add(miDCRed);
		buttonGroupMiDC.add(miDCBlue);
		buttonGroupMiDC.add(miDCYellow);
		buttonGroupMiDC.add(miDCGreen);
		buttonGroupMiDC.add(miDCCyan);
		buttonGroupMiDC.add(miDCOrange);
		buttonGroupMiDC.add(miDCMagenta);

		// ---- buttonGroupMiPC ----
		ButtonGroup buttonGroupMiPC = new ButtonGroup();
		buttonGroupMiPC.add(miPCCyan);
		buttonGroupMiPC.add(miPCMagenta);
		buttonGroupMiPC.add(miPCGreen);
		buttonGroupMiPC.add(miPCYellow);
		buttonGroupMiPC.add(miPCPurple);
		buttonGroupMiPC.add(miPCRed);
		buttonGroupMiPC.add(miPCBlue);

		// ---- buttonGroupMiSS ----
		ButtonGroup buttonGroupMiSS = new ButtonGroup();
		buttonGroupMiSS.add(miSsSmall);
		buttonGroupMiSS.add(miSsmiddle);
		buttonGroupMiSS.add(miSsLarge);

		// //GEN-END:initComponents
	}
}
