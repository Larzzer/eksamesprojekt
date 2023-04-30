package eksamesprojekt;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	public JPanel contentPane;

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
		
		
		
		//					BLUR				//
		JButton btn_Blur = new JButton("Blur");
		btn_Blur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
			}
		});
		btn_Blur.setBounds(10, 10, 85, 21);
		contentPane.add(btn_Blur);
		
		
		
		//					Lysning					//
		JButton btn_Lysning = new JButton("Lysning");
		btn_Lysning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Lysning.setBounds(10, 50, 85, 21);
		contentPane.add(btn_Lysning);
		
		
		//					Sharpen					//
		JButton btn_Sharpen = new JButton("Sharpen");
		btn_Sharpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Sharpen.setBounds(10, 90, 85, 21);
		contentPane.add(btn_Sharpen);
	
		
		
		
		
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(10, 130, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(10, 170, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(10, 250, 85, 21);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(10, 290, 85, 21);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setBounds(10, 330, 85, 21);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setBounds(10, 370, 85, 21);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setBounds(10, 410, 85, 21);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Reset");
		btnNewButton_11.setBounds(10, 450, 85, 21);
		contentPane.add(btnNewButton_11);
		
		JSlider slider = new JSlider();
		slider.setBounds(10, 210, 85, 22);
		contentPane.add(slider);
		
		
		//BilledeManipulation panel = new BilledeManipulation();
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 525);
		contentPane.add(panel);
	}
}