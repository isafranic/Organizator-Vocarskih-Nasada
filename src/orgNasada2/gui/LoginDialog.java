package orgNasada2.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	private final JPanel cPLogin = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblErrorMessage;
	private static final Logger logger = Logger.getLogger(DBSelect.class);
	
	
	public LoginDialog(JFrame parentWindow) {
		setBounds(100, 100, 450, 200);
		setModalityType(DEFAULT_MODALITY_TYPE);
		getContentPane().setLayout(new BorderLayout());
		cPLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(cPLogin, BorderLayout.CENTER);
		cPLogin.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),}));
		{
			JLabel lblKorisnickoIme = new JLabel("  Korisnicko Ime:");
			lblKorisnickoIme.setPreferredSize(new Dimension(100,15));
			cPLogin.add(lblKorisnickoIme, "2, 2, center, center");
		}
		{
			textField = new JTextField();
			cPLogin.add(textField, "3, 2, fill, center");
			textField.setColumns(10);
		}
		{
			JLabel lblLozinka = new JLabel("Lozinka:");
			cPLogin.add(lblLozinka, "2, 3, center, center");
		}
		{
			passwordField = new JPasswordField();
			cPLogin.add(passwordField, "3, 3, fill, center");
		}
		{
			lblErrorMessage = new JLabel("    ");
			lblErrorMessage.setPreferredSize(new Dimension(120,10));
			cPLogin.add(lblErrorMessage, "2, 4, 2, 1, fill, fill");
		}
		{
			JPanel bPLoginConfirm = new JPanel();
			getContentPane().add(bPLoginConfirm, BorderLayout.SOUTH);
			bPLoginConfirm.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("Login");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						logger.info("Login attempt");
						String msg = GuiController.loginUser(textField.getText(), passwordField.getPassword());
						if(msg=="1") setVisible(false);
						else lblErrorMessage.setText("Doslo je do pogreske, molim pokusajte ponovno!");
						}
				});
				okButton.setActionCommand("Login");
				bPLoginConfirm.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Register");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						logger.info("Register switch");
						RegisterDialog register = new RegisterDialog(parentWindow);
						setVisible(false);
						register.setVisible(true);
						dispose();
					}
				});
				cancelButton.setActionCommand("Register");
				bPLoginConfirm.add(cancelButton);
			}
		}
	}
}
