package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class GUI {

	private JFrame frame;

	private static DefaultMutableTreeNode root;

	private static DefaultTreeModel treeModel;

	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					GUI window = new GUI();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(tree);

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(
				new CompoundBorder(new CompoundBorder(), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		panel.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_6.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("New button");
		panel_6.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_6.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("New button");
		panel_6.add(btnNewButton_1);
		 CreateChildNodes ccn = 
	                new CreateChildNodes(fileRoot, root);
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
				if (file.isDirectory()) {
					createChildren(file, childNode);
				}
			}
		}

	}

}
