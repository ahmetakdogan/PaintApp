//package drawingprj;
//
//import java.awt.Color;
//import java.awt.ComponentOrientation;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//
//import javax.swing.ImageIcon;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
//import javax.swing.JPopupMenu;
//import javax.swing.JRadioButtonMenuItem;
//import javax.swing.KeyStroke;
//
//public class MyPopupMenu extends JPopupMenu {
//	
//	private JMenuItem pmiCut = new JMenuItem();
//	private JMenuItem pmiCopy = new JMenuItem();
//	private JMenuItem pmiPaste = new JMenuItem();
//	private JMenuItem pmiDelete = new JMenuItem();
//	private JMenuItem pmiClearAll = new JMenuItem();
//	private JMenuItem pmiUp = new JMenuItem();
//	private JMenuItem pmiDown = new JMenuItem();
//	private JMenu pmiChangeColor = new JMenu();
//	private JRadioButtonMenuItem prdmiDCRed = new JRadioButtonMenuItem();
//	private JRadioButtonMenuItem prdmiDCBlue = new JRadioButtonMenuItem();
//	private JRadioButtonMenuItem prdmiDCYellow = new JRadioButtonMenuItem();
//	private JRadioButtonMenuItem prdmiDCGreen = new JRadioButtonMenuItem();
//	private JRadioButtonMenuItem prdmiDCCyan = new JRadioButtonMenuItem();
//	private JRadioButtonMenuItem prdmiDCOrange = new JRadioButtonMenuItem();
//	private JRadioButtonMenuItem prdmiDCMagenta = new JRadioButtonMenuItem();
//	
//	public MyPopupMenu()
//	{
//		
//	}
//	// ======== popupMenu ========
//	private void initListeners() {
//		popupMenu.setAutoscrolls(true);
//		popupMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//		popupMenu.setFocusCycleRoot(true);
//		popupMenu.setEnabled(true);
//		// ---- pmiCut ----
//		pmiCut.setText("Cut");
//		pmiCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
//				KeyEvent.CTRL_MASK));
//		// pmiCut.setIcon(new ImageIcon(getClass().getResource(
//		// "/drawingprj/images/cut.jpg")));
//		pmiCut.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pmiCutActionPerformed(e);
//			}
//
//			private void pmiCutActionPerformed(ActionEvent e) {
//				cutSelectedShape();
//			}
//		});
//		popupMenu.add(pmiCut);
//		// ---- pmiCopy ----
//		pmiCopy.setText("Copy");
//		pmiCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
//				KeyEvent.CTRL_MASK));
//		pmiCopy.setIcon(new ImageIcon(getClass().getResource(
//				"/drawingprj/images/copy.jpg")));
//		pmiCopy.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pmiCopyActionPerformed(e);
//			}
//
//			private void pmiCopyActionPerformed(ActionEvent e) {
//				copySelectedShape();
//			}
//		});
//		popupMenu.add(pmiCopy);
//		// ---- pmiPaste ----
//		pmiPaste.setText("Paste");
//		pmiPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
//				KeyEvent.CTRL_MASK));
//		pmiPaste.setIcon(new ImageIcon(getClass().getResource(
//				"/drawingprj/images/paste.jpg")));
//		pmiPaste.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pmiPasteActionPerformed(e);
//			}
//
//			private void pmiPasteActionPerformed(ActionEvent e) {
//				pasteSelectedShape();
//			}
//		});
//		popupMenu.add(pmiPaste);
//		popupMenu.addSeparator();
//		// ---- pmiDelete ----
//		pmiDelete.setText("Delete");
//		pmiDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0));
//		pmiDelete.setIcon(new ImageIcon(getClass().getResource(
//				"/drawingprj/images/delete3.jpg")));
//		pmiDelete.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pmiDeleteActionPerformed(e);
//			}
//
//			private void pmiDeleteActionPerformed(ActionEvent e) {
//				deleteSelectedShape();
//			}
//		});
//		popupMenu.add(pmiDelete);
//		// ---- pmiClearAll ----
//		pmiClearAll.setText("Clear All");
//		pmiClearAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
//				KeyEvent.CTRL_MASK | KeyEvent.SHIFT_MASK));
//		pmiClearAll.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pmiClearAllActionPerformed(e);
//			}
//
//			private void pmiClearAllActionPerformed(ActionEvent e) {
//				clearAllShapes();
//			}
//		});
//		popupMenu.add(pmiClearAll);
//		popupMenu.addSeparator();
//		// ---- pmiUp ----
//		pmiUp.setText("Up");
//		pmiUp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, 0));
//		pmiUp.setIcon(new ImageIcon(getClass().getResource(
//				"/drawingprj/images/upg.gif")));
//		pmiUp.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pmiUpActionPerformed(e);
//			}
//
//			private void pmiUpActionPerformed(ActionEvent e) {
//				increaseIndexOfSelectedShape();
//			}
//		});
//		popupMenu.add(pmiUp);
//		// ---- pmiDown ----
//		pmiDown.setText("Down");
//		pmiDown.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0));
//		pmiDown.setIcon(new ImageIcon(getClass().getResource(
//				"/drawingprj/images/downg.gif")));
//		pmiDown.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pmiDownActionPerformed(e);
//			}
//
//			private void pmiDownActionPerformed(ActionEvent e) {
//				decreaseIndexOfSelectedShape();
//			}
//		});
//		add(pmiDown);
//		addSeparator();
//		// ======== pmiChangeColor ========
//		{
//			pmiChangeColor.setText("Change Color");
//			// ---- prdmiDCRed ----
//			prdmiDCRed.setText("Red");
//			prdmiDCRed.setBackground(Color.RED);
//			pmiChangeColor.add(prdmiDCRed);
//			// ---- prdmiDCBlue ----
//			prdmiDCBlue.setText("Blue");
//			prdmiDCBlue.setBackground(new Color(51, 51, 255));
//			pmiChangeColor.add(prdmiDCBlue);
//			// ---- prdmiDCYellow ----
//			prdmiDCYellow.setText("Yellow");
//			prdmiDCYellow.setBackground(new Color(255, 255, 51));
//			pmiChangeColor.add(prdmiDCYellow);
//			// ---- prdmiDCGreen ----
//			prdmiDCGreen.setText("Green");
//			prdmiDCGreen.setBackground(new Color(0, 255, 51));
//			pmiChangeColor.add(prdmiDCGreen);
//			// ---- prdmiDCCyan ----
//			prdmiDCCyan.setText("Cyan");
//			prdmiDCCyan.setBackground(Color.cyan);
//			pmiChangeColor.add(prdmiDCCyan);
//			// ---- prdmiDCOrange ----
//			prdmiDCOrange.setText("Orange");
//			prdmiDCOrange.setBackground(new Color(255, 204, 0));
//			pmiChangeColor.add(prdmiDCOrange);
//			// ---- prdmiDCMagenta ----
//			prdmiDCMagenta.setText("Magenta");
//			prdmiDCMagenta.setBackground(new Color(102, 0, 102));
//			pmiChangeColor.add(prdmiDCMagenta);
//		}
//		add(pmiChangeColor);
//	}
// }
