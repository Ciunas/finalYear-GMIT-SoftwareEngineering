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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField.AbstractFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Font;

public class GUI {

	private JFrame frmFileManipulator;

	private static DefaultMutableTreeNode root;
	private String filePath = null;
	private static DefaultTreeModel treeModel;
	private StringBuffer sb = new StringBuffer();
	JTextArea textPane;
	JButton btnNewButton_3;
	

	private JTree tree;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					 UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//					 UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
//					 UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//					 UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//					 UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//					 UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//					 UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
//					 UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//					 UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					 UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//					 UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
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
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(10, 1, 0, 0));

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
				
				JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_3.add(lblNewLabel_4);
		
				JTextField lblNewLabel = new JTextField(" File location.");
				panel_3.add(lblNewLabel);
		btnNewButton_2.setEnabled(false);
		
		panel_3.add(btnNewButton_2, BorderLayout.CENTER);

		JLabel lblNewLabel_3 = new JLabel("Choose how you want to  manipulate the file.", SwingConstants.CENTER);
		lblNewLabel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2);

		String[] options = { " Make Text Large", " Make Text Small", " Change Text", " Save Text", " Delete File" };
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(options);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_3 = new JButton("Press to Implement.");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp = String.valueOf(comboBox.getSelectedItem());

				if (temp.equals(" Make Text Large")) {

					String temp1;
					textPane.setText("");
					textPane.append(temp1 = sb.toString().toUpperCase());
					JOptionPane.showMessageDialog(frmFileManipulator, "Text Manipulated to all Uppercase.");

					System.out.println("working");
				} else if (temp.equals(" Make Text Small")) {
					String temp2;
					textPane.setText("");
					textPane.append(temp2 = sb.toString().toLowerCase());
					JOptionPane.showMessageDialog(frmFileManipulator, "Text Manipulated to all Lowercase.");

				} else if (temp.equals(" Change Text")) {


					JFrame newFrame = new JFrame();
					newFrame.setBounds(200, 200, 625, 265);
					newFrame.getContentPane().setLayout(new BorderLayout(0, 0));
					newFrame.setVisible(true);

					final JRadioButton button1 = new JRadioButton("Replace");
					final JRadioButton button2 = new JRadioButton("Delete");

					final JRadioButton button2_1 = new JRadioButton("Start");
					final JRadioButton button2_2 = new JRadioButton("End");

					final JRadioButton button3_1 = new JRadioButton("Zero or More");
					final JRadioButton button3_2 = new JRadioButton("One or More");

					ButtonGroup group1 = new ButtonGroup();
					group1.add(button2_1);
					group1.add(button2_2);

					ButtonGroup group = new ButtonGroup();
					group.add(button1);
					group.add(button2);

					ButtonGroup group2 = new ButtonGroup();

					JPanel panel_1 = new JPanel();
					panel_1.setBackground(new Color(238, 238, 238));
					panel_1.setBorder(null);
					newFrame.getContentPane().add(panel_1, BorderLayout.WEST);
					panel_1.setLayout(new GridLayout(5, 1, 0, 0));

					JLabel lblNewLabel = new JLabel("Choose What you want to do", SwingConstants.CENTER);
					panel_1.add(lblNewLabel);

					JLabel lblNewLabel_2 = new JLabel("Enter text to replace", SwingConstants.CENTER);
					panel_1.add(lblNewLabel_2);

					JLabel lblNewLabel_1 = new JLabel(" Search at the end or start of a word ", SwingConstants.CENTER);
					panel_1.add(lblNewLabel_1);

					JLabel lblNewLabel_3 = new JLabel("Many instances of the word", SwingConstants.CENTER);
					panel_1.add(lblNewLabel_3);

					JButton lblRegularExpressionCreated = new JButton("View Current regular expression");
					lblRegularExpressionCreated.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							String temp = "(" + textField_1.getText() + ")";

							if (button2_1.isSelected()) {
								if (button3_1.isSelected()) {
									temp = "^" + temp + "*";
								} else if (button3_2.isSelected()) {
									temp = "^" + temp + "+";
								}
							} else if (button2_2.isSelected()) {
								if (button3_1.isSelected()) {
									temp = temp + "&" + "*";
								} else if (button3_2.isSelected()) {
									temp = temp + "&" + "+";
								}
							}
							textField.setText(temp);

						}
					});
					panel_1.add(lblRegularExpressionCreated);

					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new MatteBorder(0, 4, 0, 0, (Color) Color.LIGHT_GRAY));
					newFrame.getContentPane().add(panel_2, BorderLayout.CENTER);
					panel_2.setLayout(new GridLayout(5, 1, 0, 0));

					JPanel panel_3 = new JPanel();
					panel_2.add(panel_3);
					panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					panel_3.add(button1);
					panel_3.add(button2);

					JPanel panel_8 = new JPanel(new GridLayout(1,2));
					
					textField_1 = new JTextField();
					textField_2 = new JTextField();
					
					panel_2.add(panel_8);
					
					panel_8.add(textField_1);
					panel_8.add(textField_2);


					JPanel panel_4 = new JPanel();
					panel_2.add(panel_4);
					panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					panel_4.add(button2_1);
					panel_4.add(button2_2);

					group2.add(button3_1);
					group2.add(button3_2);

					JPanel panel_5 = new JPanel();
					panel_2.add(panel_5);
					panel_5.add(button3_1);
					panel_5.add(button3_2);

					textField = new JTextField();
					textField.setFont(new Font("Dialog", Font.PLAIN, 14));
					panel_2.add(textField);
					textField.setColumns(10);

					JPanel lblNewLabel_7 = new JPanel();
					lblNewLabel_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					newFrame.getContentPane().add(lblNewLabel_7, BorderLayout.NORTH);

					JLabel lblNewLabel_5 = new JLabel("Chose Your expression.");
					lblNewLabel_7.add(lblNewLabel_5);

					JPanel panel_6 = new JPanel();
					panel_6.setMinimumSize(new Dimension(10, 20));
					newFrame.getContentPane().add(panel_6, BorderLayout.SOUTH);
					panel_6.setLayout(new BorderLayout(0, 0));
					
					JPanel panel = new JPanel();
					newFrame.getContentPane().add(panel, BorderLayout.SOUTH);
					
					JButton btnNewButton = new JButton("Implement");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							String temp = textField_1.getText();
							System.out.println("regular expression "+ temp);
							String temp2 = null;
							
							if (button1.isSelected()) {
								temp2 = textPane.getText();
								temp2 = temp2.replaceAll(temp, textField_2.getText());

							} else if (button2.isSelected()) {
								temp2 = textPane.getText();
								temp2 = temp2.replaceAll(temp, "");

							}
							System.out.println("here");
							textPane.setText("");
							textPane.append(temp2);
							JOptionPane.showMessageDialog(frmFileManipulator, "Text Manipulated Using a regular expression.");
							newFrame.dispose();
							
						}
					});
					panel.add(btnNewButton);


				} else if (temp.equals(" Save Text")) {

					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Specify a file to save");

					int userSelection = fileChooser.showSaveDialog(frmFileManipulator);

					if (userSelection == JFileChooser.APPROVE_OPTION) {
						File fileToSave = fileChooser.getSelectedFile();
						System.out.println("Save as file: " + fileToSave.getAbsolutePath());
						try {
							PrintWriter out = new PrintWriter(fileToSave.getAbsolutePath());
							out.print("/*" + "\n  /Name: " + textField.getText() + "\n  /Date: " + textField_3.getText() + "\n  /Project: " + textField_2.getText() + "\n  /Date: " +  datePicker.getJFormattedTextField().getText() + "\n*/" + "\n"  + "\n");
							out.append(textPane.getText());
							out.flush();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(frmFileManipulator,
								"File Saved to: " + fileToSave.getAbsolutePath());
					}

				} else if (temp.equals(" Delete File")) {
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
		
		JLabel lblRepalcementTextDetails = new JLabel("Input Metadata for file", SwingConstants.CENTER);
		lblRepalcementTextDetails.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.add(lblRepalcementTextDetails);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblName = new JLabel("Name:", SwingConstants.CENTER);
		lblName.setPreferredSize(new Dimension(75, 15));
		panel_4.add(lblName, BorderLayout.WEST);
		
		textField = new JTextField();
		panel_4.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JPanel lblNewLabel_5 = new JPanel();
		panel_3.add(lblNewLabel_5);
		lblNewLabel_5.setLayout(new BorderLayout(0, 0));
		
		textField_3 = new JTextField();
		lblNewLabel_5.add(textField_3, BorderLayout.CENTER);
		textField_3.setColumns(10);
		
		JLabel lblCopyright = new JLabel("Email:", SwingConstants.CENTER);
		lblCopyright.setPreferredSize(new Dimension(75, 15));
		lblNewLabel_5.add(lblCopyright, BorderLayout.WEST);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		textField_2 = new JTextField();
		panel_8.add(textField_2, BorderLayout.CENTER);
		textField_2.setColumns(10);
		
		JLabel lblProject = new JLabel("Project:", SwingConstants.CENTER);
		lblProject.setPreferredSize(new Dimension(75, 15));
		panel_8.add(lblProject, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDate = new JLabel("Date:", SwingConstants.CENTER);
		lblDate.setPreferredSize(new Dimension(75, 15));
		panel_7.add(lblDate, BorderLayout.WEST);
		
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		datePicker.getJFormattedTextField().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		datePicker.getJFormattedTextField().setPreferredSize(new Dimension(176, 38));
		panel_7.add(datePicker);

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
		textPane.setFont(new Font("Dialog", Font.BOLD, 12));
		scrollPane.setViewportView(textPane);

		JLabel lblReadData = new JLabel("Read Data.", SwingConstants.CENTER);
		lblReadData.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, null));
		lblReadData.setBackground(Color.BLACK);
		scrollPane.setColumnHeaderView(lblReadData);

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText("");
			}
		});
		panel_6.setLayout(new BorderLayout(0, 0));
		panel_6.add(btnNewButton_1,BorderLayout.CENTER);
		
		JLabel lblFileManipulatorCreated = new JLabel("  Created by Ciunas Bennett");
		lblFileManipulatorCreated.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel_6.add(lblFileManipulatorCreated,BorderLayout.EAST);
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
	
	public class DateLabelFormatter extends AbstractFormatter {

	    private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}

}
