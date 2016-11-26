package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class GUI {

	private JFrame frmFileManipulator;

	private static DefaultMutableTreeNode root;
	private String filePath = null;
	private static DefaultTreeModel treeModel;
	private StringBuffer sb = new StringBuffer();
	JTextArea textPane;
	JButton btnNewButton_3;
	

	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
					GUI window = new GUI();
					window.frmFileManipulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		File fileRoot = new File("/home/ciunas");
		root = new DefaultMutableTreeNode(new FileNode(fileRoot));
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);

		tree.setShowsRootHandles(true);
		frmFileManipulator = new JFrame();
		frmFileManipulator.setTitle("FIle Manipulator");
		frmFileManipulator.setBounds(100, 100, 841, 781);
		frmFileManipulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFileManipulator.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		frmFileManipulator.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(10, 1, 0, 0));

		JTextField lblNewLabel = new JTextField("File location.");
		panel_3.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("Open File");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2.setEnabled(false);

				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(filePath));
				} catch (FileNotFoundException e2) {
					JOptionPane.showMessageDialog(frmFileManipulator, "File not found.");
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String line;
				textPane.setText("");
				try {
					while ((line = reader.readLine()) != null) {
						
						sb.append(line + "\n");
						textPane.append(line + "\n");

					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnNewButton_3.setEnabled(true);
			}
		});
		btnNewButton_2.setEnabled(false);
		
		panel_3.add(btnNewButton_2, BorderLayout.CENTER);

		JLabel lblNewLabel_3 = new JLabel("Choose how you want to  manipulate the file.", SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2);

		String[] options = { "Make Text Large", "Make Text Small", "Change Text", "Save Text", "Delete File" };
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(options);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_3 = new JButton("Press to Implement.");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp = String.valueOf(comboBox.getSelectedItem());

				if (temp.equals("Make Text Large")) {

					String temp1;
					textPane.setText("");
					textPane.append(temp1 = sb.toString().toUpperCase());
					JOptionPane.showMessageDialog(frmFileManipulator, "Text Manipulated to all Uppercase.");

					System.out.println("working");
				} else if (temp.equals("Make Text Small")) {
					String temp2;
					textPane.setText("");
					textPane.append(temp2 = sb.toString().toLowerCase());
					JOptionPane.showMessageDialog(frmFileManipulator, "Text Manipulated to all Lowercase.");

				} else if (temp.equals("Change Text")) {

				} else if (temp.equals("Save Text")) {

					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Specify a file to save");

					int userSelection = fileChooser.showSaveDialog(frmFileManipulator);

					if (userSelection == JFileChooser.APPROVE_OPTION) {
						File fileToSave = fileChooser.getSelectedFile();
						System.out.println("Save as file: " + fileToSave.getAbsolutePath());
						try {
							PrintWriter out = new PrintWriter(fileToSave.getAbsolutePath());
							out.print(textPane.getText());
							out.flush();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(frmFileManipulator,
								"File Saved to: " + fileToSave.getAbsolutePath());
					}

				} else if (temp.equals("Delete File")) {
					File file = new File(filePath);

					if (file.delete()) {
						System.out.println(file.getName() + " is deleted!");
						JOptionPane.showMessageDialog(frmFileManipulator, "File Deleted: " + file.getName());
					} else {
						System.out.println("Delete operation is failed.");
					}

				}
			}
		});
		btnNewButton_3.setEnabled(false);
		panel_2.add(btnNewButton_3, BorderLayout.EAST);
		panel_2.add(comboBox, BorderLayout.CENTER);

		JScrollPane scrollPane_1 = new JScrollPane(tree);
		scrollPane_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, null));
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setPreferredSize(new Dimension(300, 403));

		MouseAdapter ml = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
					filePath = "/home/" + selPath.toString().replaceAll("\\[", "").replaceAll("\\]", "")
							.replaceAll(",", "/").replaceAll(" ", "");
					System.out.println(filePath);
					lblNewLabel.setText(filePath);
					btnNewButton_2.setEnabled(true);
				}
			}
		};
		tree.addMouseListener(ml);

		panel_1.add(scrollPane_1, BorderLayout.WEST);

		JLabel lblChooseFileTo = new JLabel("Choose File to manipulate");
		scrollPane_1.setColumnHeaderView(lblChooseFileTo);

		JPanel panel = new JPanel();
		frmFileManipulator.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);

		textPane = new JTextArea();
		scrollPane.setViewportView(textPane);

		JLabel lblReadData = new JLabel("Read Data.", SwingConstants.CENTER);
		lblReadData.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, null));
		lblReadData.setBackground(Color.BLACK);
		scrollPane.setColumnHeaderView(lblReadData);

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_6.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("New button");
		panel_6.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_6.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("New button");
		panel_6.add(btnNewButton_1);
		CreateChildNodes ccn = new CreateChildNodes(fileRoot, root);
		new Thread(ccn).start();
	}

	public class CreateChildNodes implements Runnable {

		private DefaultMutableTreeNode root;

		private File fileRoot;
		

		public CreateChildNodes(File fileRoot, DefaultMutableTreeNode root) {
			
			 
			this.fileRoot = fileRoot;
			this.root = root;
		}

		@Override
		public void run() {
			createChildren(fileRoot, root);
		}

		private void createChildren(File fileRoot, DefaultMutableTreeNode node) {
			File[] files = fileRoot.listFiles();
			if (files == null)
				return;

			for (File file : files) {
				
				DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(new FileNode(file));
				node.add(childNode);
				
				
				if(file.isHidden()){
					//System.out.println("hidden file");
					
				}else if (file.isDirectory()) {
					createChildren(file, childNode);
					
				}
				
			}
			
		}

	}

}
