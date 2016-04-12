package br.com.sistema.modelos;



import java.awt.EventQueue;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTable;

public class ItemPicker {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                            ItemPicker window = new ItemPicker();
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
	public ItemPicker() {
            initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		table = new JTable();
		frame.getContentPane().add(table);
		
	}
}

