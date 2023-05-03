package eksamesprojekt;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSlider;


public class GUI extends JFrame {

	public JPanel contentPane;
	 private BilledeManipulation imagePanel;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BilledeManipulation imagePanel = new BilledeManipulation();
	    imagePanel.setBounds(105, 10, 677, 493); // set the bounds of the panel to fit the frame
	    contentPane.add(imagePanel); // add the panel to the contentPane
		
		
		//					BLUR				//
		JButton btn_Blur = new JButton("Blur");
		btn_Blur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagePanel.Blur(); // apply the Blur function
			    
			}
		});
		btn_Blur.setBounds(10, 10, 85, 21);
		contentPane.add(btn_Blur);
		
		
		
		//					Lysning					//
		JButton btn_Lysning = new JButton("Lysning");
		btn_Lysning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagePanel.Lysning(); // apply the Lysning function
			}
		});
		btn_Lysning.setBounds(10, 50, 85, 21);
		contentPane.add(btn_Lysning);
		
		
		//					Sharpen					//
		JButton btn_Sharpen = new JButton("Sharpen");
		btn_Sharpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagePanel.Lysning(); // apply the Sharpen function
			}
		});
		btn_Sharpen.setBounds(10, 90, 85, 21);
		contentPane.add(btn_Sharpen);
	
		
		
		JButton Grey_scale = new JButton("GreyScale");
		Grey_scale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagePanel.Grayscale();
			}
		});
		Grey_scale.setBounds(10, 130, 85, 21);
		contentPane.add(Grey_scale);
		
		JButton RedScale = new JButton("RedScale");
		RedScale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagePanel.RedScale();
			}
		});
		RedScale.setBounds(10, 170, 85, 21);
		contentPane.add(RedScale);
		

		JButton GreenScale = new JButton("GreenScale");
		GreenScale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagePanel.GreenScale();
			}
		});
		GreenScale.setBounds(10, 250, 85, 21);
		contentPane.add(GreenScale);
		
		
		
		JButton BlueScale = new JButton("BlueScale");
		BlueScale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagePanel.BlueScale();
			}
		});
		BlueScale.setBounds(10, 290, 85, 21);
		contentPane.add(BlueScale);
		
		
		
		
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setBounds(10, 330, 85, 21);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setBounds(10, 370, 85, 21);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setBounds(10, 410, 85, 21);
		contentPane.add(btnNewButton_10);
		
		JButton Reset = new JButton("Reset");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagePanel.Reset();
			}
		});
		Reset.setBounds(10, 450, 85, 21);
		
		contentPane.add(Reset);
		
		JSlider slider = new JSlider();
		slider.setBounds(10, 210, 85, 22);
		contentPane.add(slider);
		
		
		BilledeManipulation panel = new BilledeManipulation();
		//float[][] output = panel.ApplyMatrix([], BilledeManipulation.Blur);
		// JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 525);
		contentPane.add(panel);
	}
}