package orgNasada2.gui;

import orgNasada2.PodatkovneKlase.*;
import orgNasada2.radSBazom.DBInsert;
import orgNasada2.radSBazom.DBSelect;
import orgNasada2.radSBazom.DBUpdate;
import orgNasada2.radSBazom.Utilities;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import com.jgoodies.forms.layout.FormSpecs;

@SuppressWarnings("serial")
public class EntryDialog extends JDialog {

	private final JPanel insertPanel = new JPanel();
	
	private JTextField tF1;
	private JTextField tF2;
	private JTextField tF3;
	private JTextField tF4;
	private JTextField tF5;
	private JTextField tF6;
	private JComboBox<String> cBoxChoice1;
	private JComboBox<String> cBoxChoice2;
	private JComboBox<String> cBoxChoice3;
	private JComboBox<String> cBoxChoice4;
	private Vector<RedInfo> redoviNasada;
	private static Nasad nasad;
	private JPanel buttonPane;
	private JTextField tfNewRedBrojMjesta;
	private JTextField tFBrojMjestaURedu;
	private boolean check;
	private JTextField tFieldFirst;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JFrame window;


	public EntryDialog(JFrame parentWindow, Korisnik user, int choice) {
		window = parentWindow;
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		insertPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(insertPanel, BorderLayout.CENTER);
		
		buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);	
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		/*
		 * switch choice
		 * 1 unos novog nasada
		 * 2 promjena postojeceg nasada
		 * 3 update broj mjesta u redu
		 * 4 unos novog reda
		 * 5 promijeni sadrzaj posadjenog na mjestu / u redu
		 * 6 unos nove sadnice
		 * 7 promjena sadnice
		 * 8 unos nove podloge
		 * 9 promjena podloge
		 * 10 unos nove sorte
		 * 11 promjena podloge
		 * 12 unos novog navodnjavanja
		 * 13 unos novog sredstva
		 */				
		switch (choice){
		case 1://unos novog nasada
		{	case1(user);			
		}	break;
		case 2://promjena postojeceg nasada
		{	case2(user);
		}	break;
		case 3://update broj mjesta u redu
		{	case3(user);
		}	break;
		case 4://unos novog reda
		{	case4(user);
		}	break;
		case 5://promijeni sadrzaj posadjenog na mjestu / u redu
		{	case5(user);
		}	break;
		case 6://unos nove sadnice
		{	case6(user);
		}	break;
		case 7://promjena sadnice
		{	case7(user);
		}	break;
		case 8://unos nove podloge
		{	case8(user);	
		}	break;
		case 9://promjena podloge
		{	case9(user);	
		}	break;
		case 10:// unos sorte
		{	case10(user);	
		}	break;
		case 11:// promjena sorte
		{	case11(user);
		}	break;
		case 12: //unos navodnjavanja
		{	case12(user);		
		}	break;
		case 13: //promjena navodnjavanja
		{	case13(user);	
		}	break;
		case 14:// unos sredstva
		{	case14(user);	
		}	break;
		case 15:// promjena sredstva
		{	case15(user);		
		}	break;
		
		} // switch case exit
		
		//reusable cancel Button
	JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
	
	
	cancelButton.setActionCommand("Cancel");
	buttonPane.add(cancelButton);
				
	}// Insert Dialog End
	
	private void case1(Korisnik user)
	{
		/*
		 * Text Field tF
		 * 1 - Naziv 
		 * 2 - Lokacija
		 * 3 - Povrsina
		 * 4 - Broj Redova
		 * 5 - Arkod ID
		 */
		/*
		 * Check Box
		 * cBoxChoice1 - Navodnjavanje
		 */
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
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
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Unos novog nasada (1)");
		JLabel lblNaziv = new JLabel("Naziv:");
		insertPanel.add(lblNaziv, "2, 1, right, center");
		tF1 = new JTextField();
		insertPanel.add(tF1, "3, 1, fill, default");
		tF1.setColumns(10);
		
		JLabel lblArkodID = new JLabel("Arkod ID: ");
		insertPanel.add(lblArkodID, "2, 2, right, center");
		tF5 = new JTextField();
		insertPanel.add(tF5, "3, 2, fill, default");
		tF5.setColumns(10);
	
		JLabel lblLokacija = new JLabel("Lokacija:");
		insertPanel.add(lblLokacija, "2, 3, right, center");
		tF2 = new JTextField();
		insertPanel.add(tF2, "3, 3, fill, default");
		tF2.setColumns(10);
	
		JLabel lblPovrsina = new JLabel("Povrsina:");
		insertPanel.add(lblPovrsina, "2, 4, right, center");
		tF3 = new JTextField();
		insertPanel.add(tF3, "3, 4, fill, default");
		tF3.setColumns(10);
	
		JLabel lblBrojRedova = new JLabel("Broj redova:");
		insertPanel.add(lblBrojRedova, "2, 5, right, center");
		tF4 = new JTextField();
		insertPanel.add(tF4, "3, 5, fill, default");
		tF4.setColumns(10);
	
		JLabel lblNavodnjavanje = new JLabel("Navodnjavanje:");
		insertPanel.add(lblNavodnjavanje, "2, 6, right, center");
		cBoxChoice1 = new JComboBox<String>();
		for(String s : DBSelect.getNavodnjavanjeVec()) cBoxChoice1.addItem(s);
		insertPanel.add(cBoxChoice1, "3, 6, fill, default");
	
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int navId = DBSelect.getNavodnjavanjeID(cBoxChoice1.getSelectedItem().toString());
					if(DBInsert.unesiNasad(user.getId(),tF5.getText(), tF1.getText(), tF3.getText(),
							tF2.getText(), navId, 1, tF4.getText()) > 0)
						{
						Utilities.popuniNasadDefault(DBSelect.getNasadKorisnikaPod(user.getId(), tF1.getText()), window);
						dispose();
						setVisible(false);
						}
				}
			});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

	}

	private void case2(Korisnik user)
	{
		/*
		 * Text Field - tF 
		 * tF1 - Lokacija
		 * tF2 - Povrsina
		 * tF3 - Broj Redova
		 */
		/*
		 * Check Box - cBoxChoice
		 * cBoxChoice1 - Nasad
		 * cBoxChoice2 - Navodnjavanje
		 */
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
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
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		cBoxChoice1 = new JComboBox<String>();
		cBoxChoice2 = new JComboBox<String>();
		setTitle("Promjena Postojeceg Nasada");			
		for(String s : DBSelect.getImenaNasadaKorisnika(user.getKorisnickoIme())) cBoxChoice1.addItem(s);
		
		for(String s : DBSelect.getNavodnjavanjeVec()) cBoxChoice2.addItem(s);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		insertPanel.add(lblNaziv, "2, 2, right, center");
		cBoxChoice1.setSelectedItem(GuiVisual.getNasadNazivFromTable());
		nasad = new Nasad(
				DBSelect.getNasadKorisnikaPod(user.getId(), cBoxChoice1.getSelectedItem().toString())
				);
		cBoxChoice1.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent e) 
				{
				if(check)
				{
				nasad = new Nasad(DBSelect.getNasadKorisnikaPod(user.getId(), cBoxChoice1.getSelectedItem().toString()));
				tF1.setText(nasad.getLokacija());
				tF2.setText(String.valueOf(nasad.getPovrsina()));
				tF3.setText(String.valueOf(nasad.getBrojRedova()));
				cBoxChoice2.setSelectedItem(DBSelect.getNavodnjavanjeNaziv(nasad.getNavodnjavanjeID()));
				}
				else check=true;
				}
			});
		insertPanel.add(cBoxChoice1, "4, 2, fill, default");
				
		lblNewLabel = new JLabel("Arkod ID:");
		insertPanel.add(lblNewLabel, "2, 4, right, default");
				tF5 = new JTextField();			
				tF5.setColumns(10);
				tF5.setText(nasad.getArkodID());
				insertPanel.add(tF5, "4, 4, fill, default");
				
				JLabel lblLokacija = new JLabel("Lokacija:");
				insertPanel.add(lblLokacija, "2, 6, right, center");
				tF1 = new JTextField();
				tF1.setColumns(10);
				tF1.setText(nasad.getLokacija());		
				insertPanel.add(tF1, "4, 6, fill, default");
				
				JLabel lblPovrsina = new JLabel("Povrsina:");
				insertPanel.add(lblPovrsina, "2, 8, right, center");			
				tF2 = new JTextField();
				insertPanel.add(tF2, "4, 8, fill, default");
				tF2.setText(String.valueOf(nasad.getPovrsina()));
				tF2.setColumns(10);
			
				JLabel lblBrojRedova = new JLabel("Broj redova:");
				insertPanel.add(lblBrojRedova, "2, 10, right, center");
			tF3 = new JTextField();
			insertPanel.add(tF3, "4, 10, fill, default");
			tF3.setColumns(10);
			tF3.setText(String.valueOf(nasad.getBrojRedova()));
		
			JLabel lblNavodnjavanje = new JLabel("Navodnjavanje:");
			insertPanel.add(lblNavodnjavanje, "2, 12, right, center");
		insertPanel.add(cBoxChoice2, "4, 12, fill, default");
		cBoxChoice2.setSelectedItem(DBSelect.getNavodnjavanjeNaziv(nasad.getNavodnjavanjeID()));
	
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int navId = DBSelect.getNavodnjavanjeID(cBoxChoice2.getSelectedItem().toString());
					if(DBUpdate.updateNasad(nasad.getIdNasad(),tF5.getText(), user.getId(), 
							cBoxChoice1.getSelectedItem().toString(), Integer.valueOf(tF2.getText()).intValue(),
							tF1.getText(), navId, 1, Integer.valueOf(tF3.getText()).intValue())) setVisible(false);
				}
			});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
				
	}

	private void case3(Korisnik user)
	{
		/*
		 * Check Box - cBoxChoice
		 * 1 - Broj Reda
		 * 2 - Nasad
		 */
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
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
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("4dlu:grow"),}));
		
		JLabel lblNasad = new JLabel("Nasad: ");
		insertPanel.add(lblNasad, "2, 2, right, center");
		for(String s : DBSelect.getImenaNasadaKorisnika(user.getKorisnickoIme())) cBoxChoice2.addItem(s);
		cBoxChoice2 = new JComboBox<String>();
		cBoxChoice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nasad = new Nasad(DBSelect.getNasadKorisnikaPod(user.getId(), cBoxChoice2.getSelectedItem().toString()));
				cBoxChoice1.removeAll();
				for(int i=1; i<nasad.getBrojRedova()+1; i++) cBoxChoice1.addItem(String.valueOf(i));
			}
		});
		insertPanel.add(cBoxChoice2, "4, 2, fill, default");
		
		JLabel lblRedBroj = new JLabel("Red broj: ");
		insertPanel.add(lblRedBroj, "2, 4, right, default");
		
		
		JButton btnUnesiBrojMjestaURedu = new JButton("Unesi broj mjesta (3)");
		btnUnesiBrojMjestaURedu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBUpdate.updateRed(nasad.getIdNasad(),
						Integer.valueOf(cBoxChoice1.getSelectedItem().toString()),
						Integer.valueOf(tFBrojMjestaURedu.getText()));
			}
		});
		
		cBoxChoice1 = new JComboBox<String>();
		
		insertPanel.add(cBoxChoice1, "4, 4, fill, default");
		
		JLabel lblBrojMjestaURedu = new JLabel("Broj mjesta u redu: ");
		insertPanel.add(lblBrojMjestaURedu, "2, 6, right, default");
		
		tFBrojMjestaURedu = new JTextField();
		insertPanel.add(tFBrojMjestaURedu, "4, 6, fill, center");
		tFBrojMjestaURedu.setColumns(10);
		buttonPane.add(btnUnesiBrojMjestaURedu, "2, 8, 3, 1, center, center");
		
	
	}
	
	private void case4(Korisnik user)
	{
		/*
		 * Check Box - cBoxChoice
		 * 1 - Nasad
		 */
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Unos reda (4)");
		JLabel lblDodajRedWhereInfo = new JLabel("Dodavanje reda:");
		insertPanel.add(lblDodajRedWhereInfo, "2, 2, right, center");
		for(String s: DBSelect.getImenaNasadaKorisnika(user.getKorisnickoIme())) cBoxChoice1.addItem(s);
		
		cBoxChoice1 = new JComboBox<String>();
		insertPanel.add(cBoxChoice1, "4, 2, fill, default");
		
		JLabel lblDodajRedBrojMjesta = new JLabel("Broj mjesta u redu:");
		insertPanel.add(lblDodajRedBrojMjesta, "2, 4, right, center");
		
		tfNewRedBrojMjesta = new JTextField();
		insertPanel.add(tfNewRedBrojMjesta, "4, 4, fill, center");
		tfNewRedBrojMjesta.setColumns(10);
		
		JButton btnCommitNewRed = new JButton("Unesi Red");
		btnCommitNewRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idNasad = DBSelect.getIdNasada(user, cBoxChoice1.getSelectedItem().toString());
				DBInsert.unesiRed(idNasad,
				DBSelect.getBrojRedovaUNasadu(idNasad),
				Integer.valueOf(tfNewRedBrojMjesta.getText()));
				
				DBUpdate.updateNasadIncBrojRedova(idNasad, user.getId());
			}
		});
		buttonPane.add(btnCommitNewRed);
	}

	private void case5(Korisnik user)
	{
		/*
		 * Check Box - cBoxChoice
		 * 1 - Nasad
		 * 2 - Red
		 * 3 - Sadno Mjesto
		 * 4 - Sadnica
		 */
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
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
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Unesi sadrzaj Reda (5)");
		redoviNasada = new Vector<RedInfo>();
		Vector<String> chosenParentWindow = new Vector<String>();
		for(String s : GuiVisual.basicInfoPosadjenoSelected()) { chosenParentWindow.add(s); }
		
		JLabel lblPosadiNasad = new JLabel("Nasad:");
		insertPanel.add(lblPosadiNasad, "2, 2, right, center");
		for(String s : DBSelect.getImenaNasadaKorisnika(user.getKorisnickoIme())) cBoxChoice1.addItem(s);
		if(!chosenParentWindow.isEmpty()) cBoxChoice1.setSelectedItem(chosenParentWindow.elementAt(0));
		
		cBoxChoice1 =  new JComboBox<String>();
		cBoxChoice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redoviNasada.clear();
				for(RedInfo rI : DBSelect.getRedoviInfo(DBSelect.getIdNasada(user,
						cBoxChoice1.getSelectedItem().toString()))) redoviNasada.add(rI);
			}
		});
		insertPanel.add(cBoxChoice1, "4, 2, fill, default");
		for(RedInfo rI : redoviNasada)
		{
			cBoxChoice2.addItem(String.valueOf(rI.getBrojReda()));
		}
		if(!chosenParentWindow.isEmpty()) cBoxChoice2.setSelectedItem(chosenParentWindow.elementAt(1));
		for(RedInfo rI : redoviNasada)
			{
			if(rI.getBrojReda() == Integer.valueOf(cBoxChoice2.getSelectedItem().toString()))
				{
					for(int i=1; i<rI.getBrojSadnihMjesta()+1; i++) cBoxChoice3.addItem(String.valueOf(i));
				}
			}
		if(!chosenParentWindow.isEmpty()) cBoxChoice3.setSelectedItem(chosenParentWindow.elementAt(2));
		
		
		JLabel lblPosadiRed = new JLabel("Red:");
		insertPanel.add(lblPosadiRed, "2, 4, right, center");
		for(String s : DBSelect.getImenaSadnica()) cBoxChoice4.addItem(s);
		if(!chosenParentWindow.isEmpty())  cBoxChoice4.setSelectedItem(chosenParentWindow.elementAt(3));
		
		
		cBoxChoice2 =  new JComboBox<String>();
		cBoxChoice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cBoxChoice3.removeAll();
				for(RedInfo rI : redoviNasada)
				{
					if(cBoxChoice2.getSelectedItem().toString().contentEquals(String.valueOf(rI.getBrojReda())))
							{
								for(int i=1; i<rI.getBrojSadnihMjesta()+1; i++) cBoxChoice3.addItem(String.valueOf(i));
							}
				}
			}
		});
		insertPanel.add(cBoxChoice2, "4, 4, fill, default");
		
		JCheckBox chkBoxPopuniRed = new JCheckBox("Popuni cijeli red");
		insertPanel.add(chkBoxPopuniRed, "4, 6");
		
		JLabel lblSadnoMjesto = new JLabel("Broj sadnog mjesta:");
		insertPanel.add(lblSadnoMjesto, "2, 8, right, center");
		
		cBoxChoice3 = new JComboBox<String>();
		insertPanel.add(cBoxChoice3, "4, 8, fill, default");
		
		JLabel lblSadnica = new JLabel("Sadnica:");
		insertPanel.add(lblSadnica, "2, 10, right, center");
		
		
		cBoxChoice4 =  new JComboBox<String>();
		insertPanel.add(cBoxChoice4, "4, 10, fill, default");
		
		JButton btnPosadiVocku = new JButton("Posadi");
		btnPosadiVocku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
					for(RedInfo rI : redoviNasada)
					{
						if(cBoxChoice2.getSelectedItem().toString().equals(String.valueOf(rI.getBrojReda())) )
							{
							if(chkBoxPopuniRed.isSelected()) DBUpdate.updateCijeliSadrzajReda(
								rI.getIdReda(),	DBSelect.getPosaðenoID(cBoxChoice4.getSelectedItem().toString()), LocalDate.now());
							else DBUpdate.updateSadrzajReda(
								rI.getIdReda(), Integer.valueOf(cBoxChoice3.getSelectedItem().toString()),
								DBSelect.getPosaðenoID(cBoxChoice4.getSelectedItem().toString()), LocalDate.now());
							dispose();
							}						
					}				
			}
		});			
		buttonPane.add(btnPosadiVocku);
	}
	
	private void case6(Korisnik user)
	{
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Unos nove vocke (6)");
		
		JLabel lblFirst = new JLabel("Sorta: ");
		insertPanel.add(lblFirst, "2, 2, right, default");
		for(String s : DBSelect.getSorteVS()) cBoxChoice1.addItem(s);
		
		cBoxChoice1 = new JComboBox<String>();
		insertPanel.add(cBoxChoice1, "4, 2, fill, default");
		for(String s : DBSelect.getPodlogeVS()) cBoxChoice1.addItem(s);
		
		JLabel lblSecond = new JLabel("Podloga ");
		insertPanel.add(lblSecond, "2, 4, right, default");
		
		cBoxChoice2 = new JComboBox<String>();
		insertPanel.add(cBoxChoice2, "4, 4, fill, default");
		
		JLabel lblThird = new JLabel("Naziv ");
		insertPanel.add(lblThird, "2, 6, right, default");
		
		tFieldFirst = new JTextField();
		insertPanel.add(tFieldFirst, "4, 6, fill, default");
		tFieldFirst.setColumns(10);
		
		
		JButton btnCommit = new JButton("Unesi");
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBInsert.unesiPosaðeno(DBSelect.getSorteID(cBoxChoice1.getSelectedItem().toString()),
						DBSelect.getPodlogeID(cBoxChoice2.getSelectedItem().toString()),
						tFieldFirst.getText());
			}
		});
		buttonPane.add(btnCommit);
		
	}
	
	private void case7(Korisnik user)
	{
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Promjena postojece vocke (7)");
		
		PosaðenoInfo posaðeno = new PosaðenoInfo(DBSelect.getPosaðenoByID(GuiVisual.getSelectedVockaID()));
		
		JLabel lblFirst = new JLabel("Sorta: ");
		insertPanel.add(lblFirst, "2, 2, right, default");
		for(String s : DBSelect.getSorteVS()) cBoxChoice1.addItem(s);
		for(String s : DBSelect.getPodlogeVS()) cBoxChoice2.addItem(s);
		
		cBoxChoice1 = new JComboBox<String>();
		cBoxChoice1.setSelectedItem(posaðeno.getSorta());
		insertPanel.add(cBoxChoice1, "4, 2, fill, default");
		
		JLabel lblSecond = new JLabel("Podloga ");
		insertPanel.add(lblSecond, "2, 4, right, default");
		
		cBoxChoice2 = new JComboBox<String>();
		cBoxChoice2.setSelectedItem(posaðeno.getPodloga());
		insertPanel.add(cBoxChoice2, "4, 4, fill, default");
		
		JLabel lblThird = new JLabel("Naziv ");
		insertPanel.add(lblThird, "2, 6, right, default");
		
		tFieldFirst = new JTextField();
		insertPanel.add(tFieldFirst, "4, 6, fill, default");
		tFieldFirst.setColumns(10);
		tFieldFirst.setText(posaðeno.getNazivPosaðeno());
		
		JButton btnCommit = new JButton("Unesi");
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBUpdate.updatePosaðeno(
						posaðeno.getIdPosaðeno(), tFieldFirst.getText(), 
						DBSelect.getSorteID(cBoxChoice1.getSelectedItem().toString()),
								DBSelect.getPodlogeID(cBoxChoice2.getSelectedItem().toString())
								);
			}
		});
		buttonPane.add(btnCommit);
	}
	
	private void case8(Korisnik user)
	{
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Unos nove podloge: (8)");
		JLabel lblNaziv = new JLabel("Naziv: ");
		insertPanel.add(lblNaziv, "2, 2, right, default");
		
		tF1 = new JTextField();
		insertPanel.add(tF1, "4, 2, fill, default");
		tF1.setColumns(10);
		
		JLabel lblBujnost = new JLabel("Bujnost: ");
		insertPanel.add(lblBujnost, "2, 4, right, default");
		
		tF2 = new JTextField();
		insertPanel.add(tF2, "4, 4, fill, default");
		tF2.setColumns(10);

		btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBInsert.unesiPodloge(tF1.getText(), tF2.getText());
				dispose();
			}
		});
		buttonPane.add(btnNewButton);
	}
	
	private void case9(Korisnik user)
	{
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Promjena podloge: (9)");
		
		Podloga podloga = new Podloga(DBSelect.getPodlogeById(GuiVisual.getSelectedPodlogaID()));
		
		JLabel lblNaziv = new JLabel("Naziv: ");
		insertPanel.add(lblNaziv, "2, 2, right, default");
		
		tF1 = new JTextField();
		insertPanel.add(tF1, "4, 2, fill, default");
		tF1.setColumns(10);
		tF1.setText(podloga.getNazivPodloge());
		
		JLabel lblBujnost = new JLabel("Bujnost: ");
		insertPanel.add(lblBujnost, "2, 4, right, default");
		
		tF2 = new JTextField();
		insertPanel.add(tF2, "4, 4, fill, default");
		tF2.setColumns(10);
		tF2.setText(podloga.getBujnostPodloge());

		btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBUpdate.updatePodloga(podloga.getIdPodloge(), tF1.getText(), tF2.getText());
				dispose();
			}
		});
		buttonPane.add(btnNewButton);
	}
	
	private void case10(Korisnik user)
	{		
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Unos nove sorte: (10)");
		JLabel lblNaziv = new JLabel("Naziv: ");
		insertPanel.add(lblNaziv, "2, 2, right, default");
		
		tF1 = new JTextField();
		insertPanel.add(tF1, "4, 2, fill, default");
		tF1.setColumns(10);

		JLabel lblBujnost = new JLabel("Vrsta: ");
		insertPanel.add(lblBujnost, "2, 4, right, default");
		
		tF2 = new JTextField();
		insertPanel.add(tF2, "4, 4, fill, default");
		tF2.setColumns(10);

		btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBInsert.unesiSorte(tF1.getText(), tF2.getText());
				dispose();
			}
		});
		buttonPane.add(btnNewButton);
	}
	
	private void case11(Korisnik user)
	{
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Promjena sorte: (11)");
		
		Sorta sorta = new Sorta( DBSelect.getSorteById( GuiVisual.getSelectedSortaID() ));
		
		JLabel lblNaziv = new JLabel("Naziv: ");
		insertPanel.add(lblNaziv, "2, 2, right, default");
		
		tF1 = new JTextField();
		insertPanel.add(tF1, "4, 2, fill, default");
		tF1.setColumns(10);
		tF1.setText(sorta.getImeSorte());
		
		JLabel lblBujnost = new JLabel("Bujnost: ");
		insertPanel.add(lblBujnost, "2, 4, right, default");
		
		tF2 = new JTextField();
		insertPanel.add(tF2, "4, 4, fill, default");
		tF2.setColumns(10);
		tF2.setText(sorta.getVrstaSorte());

		btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBUpdate.updateSorta(sorta.getIdSorta(), tF1.getText(), tF2.getText());
				dispose();
			}
		});
		buttonPane.add(btnNewButton);
	}
	
	private void case12(Korisnik user)
	{
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Unos navodnjavanja: (12)");
		
		JLabel lblNaziv = new JLabel("Naziv: ");
		insertPanel.add(lblNaziv, "2, 2, right, default");
		
		tF1 = new JTextField();
		insertPanel.add(tF1, "4, 2, fill, default");
		tF1.setColumns(10);

		btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBInsert.unesiNavodnjavanje(tF1.getText());
				dispose();
			}
		});
		buttonPane.add(btnNewButton);
	}
	
	private void case13(Korisnik user)
	{
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("Promjena navodnjavanja: (13)");
		
		Navodnjavanje nav = new Navodnjavanje(DBSelect.getNavodnjavanje(GuiVisual.getSelectedNavodnjavanjeID()));
		JLabel lblNaziv = new JLabel("Naziv: ");
		insertPanel.add(lblNaziv, "2, 2, right, default");
		
		tF1 = new JTextField();
		insertPanel.add(tF1, "4, 2, fill, default");
		tF1.setColumns(10);
		tF1.setText(nav.getNazivNavodnjavanja());

		btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBUpdate.updateNavodnjavanje(nav.getIdNavodnjavanje(), tF1.getText());
				dispose();
			}
		});
		buttonPane.add(btnNewButton);
	}
	
	private void case14(Korisnik user)
	{
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
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
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("insert sredstvo (14)");
		
		JLabel lblNaziv = new JLabel("Naziv:");
		insertPanel.add(lblNaziv, "2, 2, right, center");
		
		tF1 = new JTextField();
		insertPanel.add(tF1, "4, 2, fill, default");
		tF1.setColumns(10);
		
		JLabel lblTip = new JLabel("Tip tretiranja:");
		insertPanel.add(lblTip, "2, 4, right, center");
		
		tF2 = new JTextField();
		insertPanel.add(tF2, "4, 4, fill, default");
		tF2.setColumns(10);
		
		JLabel lblAktTvar = new JLabel("Aktivna Tvar:");
		insertPanel.add(lblAktTvar, "2, 6, right, center");
		
		tF3 = new JTextField();
		insertPanel.add(tF3, "4, 6, fill, default");
		tF3.setColumns(10);
		
		JLabel lblSvrha = new JLabel("Svrha:");
		insertPanel.add(lblSvrha, "2, 8, right, default");
		
		tF4 = new JTextField();
		insertPanel.add(tF4, "4, 8, fill, default");
		tF4.setColumns(10);
		
		JLabel lblKarencaRad = new JLabel("Radna karenca:");
		insertPanel.add(lblKarencaRad, "2, 10, right, default");
		
		tF5 = new JTextField();
		insertPanel.add(tF5, "4, 10, fill, default");
		tF5.setColumns(10);
		
		JLabel lblKarencaKon = new JLabel("Konzumna karenca:");
		insertPanel.add(lblKarencaKon, "2, 12, right, default");
		
		tF6 = new JTextField();
		insertPanel.add(tF6, "4, 12, fill, default");
		tF6.setColumns(10);
		
		btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBInsert.unesiSredstvo(tF1.getText(), tF2.getText(), tF3.getText(),
						tF4.getText(), tF5.getText(), tF6.getText());
				dispose();
			}
		});
		buttonPane.add(btnNewButton);
	}

	private void case15(Korisnik user)
	{
		insertPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu:grow"),
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
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		setTitle("promjeni sredstvo (15)");
		
		Sredstvo sredstvo = new Sredstvo(DBSelect.getSredstvo(GuiVisual.getSelectedSredstvoID()));
		
		JLabel lblNaziv = new JLabel("Naziv:");
		insertPanel.add(lblNaziv, "2, 2, right, center");
		
		tF1 = new JTextField();
		insertPanel.add(tF1, "4, 2, fill, default");
		tF1.setColumns(10);
		tF1.setText(sredstvo.getNaziv());
		
		JLabel lblTip = new JLabel("Tip tretiranja:");
		insertPanel.add(lblTip, "2, 4, right, center");
		
		tF2 = new JTextField();
		insertPanel.add(tF2, "4, 4, fill, default");
		tF2.setColumns(10);
		tF2.setText(sredstvo.getTipTretiranja());
		
		JLabel lblAktTvar = new JLabel("Aktivna Tvar:");
		insertPanel.add(lblAktTvar, "2, 6, right, center");
		
		tF3 = new JTextField();
		insertPanel.add(tF3, "4, 6, fill, default");
		tF3.setColumns(10);
		tF3.setText(sredstvo.getAktivnaTvar());
		
		JLabel lblSvrha = new JLabel("Svrha:");
		insertPanel.add(lblSvrha, "2, 8, right, default");
		
		tF4 = new JTextField();
		insertPanel.add(tF4, "4, 8, fill, default");
		tF4.setColumns(10);
		tF4.setText(sredstvo.getSvrhaSredstva());
		JLabel lblKarencaRad = new JLabel("Radna karenca:");
		insertPanel.add(lblKarencaRad, "2, 10, right, default");
		
		tF5 = new JTextField();
		insertPanel.add(tF5, "4, 10, fill, default");
		tF5.setColumns(10);
		tF5.setText("" + sredstvo.getTrajanjeRadneKarenceDani());
		JLabel lblKarencaKon = new JLabel("Konzumna karenca:");
		insertPanel.add(lblKarencaKon, "2, 12, right, default");
		
		tF6 = new JTextField();
		insertPanel.add(tF6, "4, 12, fill, default");
		tF6.setColumns(10);
		tF6.setText("" + sredstvo.getTrajanjeKonzumneKarenceDani());
		
		btnNewButton = new JButton("Unesi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBUpdate.updateSredstvo(sredstvo.getIdSredstva(), tF1.getText(),
						tF2.getText(), tF3.getText(),
						tF4.getText(), tF5.getText(),
						tF6.getText());
				dispose();
			}
		});
		buttonPane.add(btnNewButton);
	}
}// class end

