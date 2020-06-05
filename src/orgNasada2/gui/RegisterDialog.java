package orgNasada2.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import orgNasada2.gui.controller.GuiController;
import orgNasada2.radSBazom.DBSelect;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterDialog extends JDialog {

	private static final long serialVersionUID = 2L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tFieldUsername;
	private JTextField tFieldImeIPrezime;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblRegisterError;
	private static final Logger logger = Logger.getLogger(DBSelect.class);

	public RegisterDialog(JFrame parentWindow) {
		setBounds(100, 100, 450, 300);
		setModalityType(DEFAULT_MODALITY_TYPE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("50dlu:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu:grow"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
			JLabel lblUsername = new JLabel("  Korisnicko Ime ");
			contentPanel.add(lblUsername, "2, 2, right, center");
		
			tFieldUsername = new JTextField();
			contentPanel.add(tFieldUsername, "4, 2, fill, center");
			tFieldUsername.setColumns(5);
		
			JLabel lblUsernameError = new JLabel("     ");
			lblUsernameError.setForeground(Color.RED);
			contentPanel.add(lblUsernameError, "6, 2");
		
			JLabel lblImeIPrezime = new JLabel("  Ime i Prezime");
			contentPanel.add(lblImeIPrezime, "2, 4, right, center");
		
			tFieldImeIPrezime = new JTextField();
			contentPanel.add(tFieldImeIPrezime, "4, 4, fill, default");
			tFieldImeIPrezime.setColumns(5);
		
			JLabel lblImeIPrezimeError = new JLabel("     ");
			lblImeIPrezimeError.setForeground(Color.RED);
			contentPanel.add(lblImeIPrezimeError, "6, 4");
		
			JLabel lblPass = new JLabel("  Lozinka:");
			contentPanel.add(lblPass, "2, 6, right, center");
		
			passwordField = new JPasswordField();
			contentPanel.add(passwordField, "4, 6, fill, default");
		
			JLabel lblPassConfirm = new JLabel("  Potvrdi Lozinku:");
			contentPanel.add(lblPassConfirm, "2, 8, right, center");
	
			passwordField_1 = new JPasswordField();
			contentPanel.add(passwordField_1, "4, 8, fill, default");
		
			JLabel lblPassError = new JLabel("     ");
			lblPassError.setForeground(Color.RED);
			contentPanel.add(lblPassError, "6, 8");
		
			lblRegisterError = new JLabel("");
			lblRegisterError.setForeground(Color.RED);
			contentPanel.add(lblRegisterError, "2, 10, 5, 1, center, center");
		
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
				JButton RegisterButton = new JButton("Register");
				RegisterButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean state = GuiController.registerUser(tFieldUsername.getText(), tFieldImeIPrezime.getText(), String.valueOf(passwordField.getPassword()),String.valueOf(passwordField_1.getPassword()));
						if(state) 
						{
							LoginDialog login = new LoginDialog(parentWindow);
							setVisible(false);
							login.setVisible(true);
						}
					}
				});
				RegisterButton.setActionCommand("Register");
				buttonPane.add(RegisterButton);
				getRootPane().setDefaultButton(RegisterButton);
			
				JButton cancelButton = new JButton("Login");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						logger.info("Login switch");
						LoginDialog login = new LoginDialog(parentWindow);
						setVisible(false);
						login.setVisible(true);
						dispose();
					}
				});
				cancelButton.setActionCommand("Login");
				buttonPane.add(cancelButton);
			}
		
	}

