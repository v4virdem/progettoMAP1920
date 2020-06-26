package sleepGame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

/**
 * Gestisce l'apertura della cassaforte
 * «Boundary»
 */
public class SafeBox extends JFrame {

	private JTextField txtPassword;
	private JPanel contentPane;

	public SafeBox() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 340, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(148, 22, 159, 35);
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setToolTipText("");
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);

		JButton btn1 = new JButton("1");
		btn1.setHorizontalAlignment(SwingConstants.LEADING);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtPassword.setText(txtPassword.getText() + "1");
			}
		});
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn1.setBounds(21, 67, 63, 41);
		contentPane.add(btn1);

		JButton btn_2 = new JButton("2");
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtPassword.setText(txtPassword.getText() + "2");
			}
		});
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_2.setHorizontalAlignment(SwingConstants.LEADING);
		btn_2.setBounds(123, 67, 64, 41);
		contentPane.add(btn_2);

		JButton btn_3 = new JButton("3");
		btn_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setText(txtPassword.getText() + "3");

			}
		});
		btn_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_3.setHorizontalAlignment(SwingConstants.LEADING);
		btn_3.setBounds(224, 67, 63, 41);
		contentPane.add(btn_3);

		JButton btn_4 = new JButton("4");
		btn_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setText(txtPassword.getText() + "4");

			}
		});
		btn_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_4.setHorizontalAlignment(SwingConstants.LEADING);
		btn_4.setBounds(21, 127, 63, 41);
		contentPane.add(btn_4);

		JButton btn_5 = new JButton("5");
		btn_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setText(txtPassword.getText() + "5");

			}
		});
		btn_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_5.setHorizontalAlignment(SwingConstants.LEADING);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_5.setBounds(123, 127, 64, 41);
		contentPane.add(btn_5);

		JButton btn_6 = new JButton("6");
		btn_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setText(txtPassword.getText() + "6");

			}
		});
		btn_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_6.setHorizontalAlignment(SwingConstants.LEADING);
		btn_6.setBounds(224, 127, 63, 41);
		contentPane.add(btn_6);

		JButton btn_7 = new JButton("7");
		btn_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setText(txtPassword.getText() + "7");

			}
		});
		btn_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_7.setHorizontalAlignment(SwingConstants.LEADING);
		btn_7.setBounds(21, 178, 63, 41);
		contentPane.add(btn_7);

		JButton btn_8 = new JButton("8");
		btn_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setText(txtPassword.getText() + "8");

			}
		});
		btn_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_8.setHorizontalAlignment(SwingConstants.LEADING);
		btn_8.setBounds(123, 178, 64, 41);
		contentPane.add(btn_8);

		JButton btn_9 = new JButton("9");
		btn_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setText(txtPassword.getText() + "9");

			}
		});
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_9.setHorizontalAlignment(SwingConstants.LEADING);
		btn_9.setBounds(224, 178, 63, 41);
		contentPane.add(btn_9);

		JLabel lblNewLabel = new JLabel("PASSWORD* : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 22, 103, 35);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("* la password è di almeno 5 caratteri");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(21, 229, 266, 13);
		contentPane.add(lblNewLabel_1);

	}

	public String getTxtPassword() {
		return this.txtPassword.getText();
	}
}
