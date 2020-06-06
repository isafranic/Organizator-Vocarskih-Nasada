package orgNasada2.gui;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTabbedPane;

import orgNasada2.PodatkovneKlase.Korisnik;
import orgNasada2.gui.controller.GuiController;
import orgNasada2.radSBazom.DBConst;
import orgNasada2.radSBazom.DBSelect;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import javax.swing.JTable;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GuiVisual {

	private static final Logger logger = Logger.getLogger(GuiVisual.class);
	private JFrame frame;
	private static JTable nasadInfoTable;
	private static JTable prikazRedovaTable;
	private static JTable prikazPosadjenogURedu;
	private static JTable tableKarence;
	private static JTable tableSredstva;
	private static JTable tablePosadeno;
	private static JTable tableSorta;
	private static JTable tableNavodnjavanje;
	private static JTable tablePodloga;
	private static Korisnik user;
	static JComboBox<String> choiceNasadPrikaz;
	static JComboBox<String> cBoxNoviNasadRed;
	static JComboBox<String> cBoxUniEditUtjeciNa;
	static JComboBox<String> cBoxUniEditID;
	static JComboBox<String> cBoxVocnjakTretiraj;
	static JComboBox<String> cBoxSredstvoTretiraj;
	private JTextField tFRedZaPrikaz;
	private JTextField tFVockaZaPrikaz;
	private JTextField tFSortTret;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		logger.info("Pokrenuo sam aplikaciju");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiVisual window = new GuiVisual();
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
	public GuiVisual() {
			LoginDialog login = new LoginDialog(frame);
			login.setVisible(true);
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(Korisnik user) {

		frame = new JFrame();
		frame.setBounds(50, 50,1100, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPlaceholder = new JPanel();
		frame.getContentPane().add(mainPlaceholder);
		mainPlaceholder.setLayout(new BorderLayout(0, 0));		

		mainPlaceholder.add(picturePHL(), BorderLayout.WEST);
		mainPlaceholder.add(picturePHR(), BorderLayout.EAST);

		JTabbedPane mainPrikazPane = new JTabbedPane(JTabbedPane.TOP);
		mainPlaceholder.add(mainPrikazPane, BorderLayout.CENTER);

		// Prikaz liste nasada, informacije o nasadu te sadrzaj reda
		mainPrikazPane.addTab("Prikaz Nasada", null, createNasad(), null);
		// Prikaz Sadnica, Sorti i Podloga
		mainPrikazPane.addTab("Sadnice", null, createSadniceINavodnjavanje(), null);
		// Prikaz Karenci i Sredstva
		mainPrikazPane.addTab("Tretiranje", null, createTretiranje(), null);

	}

	public static void setUser(Korisnik korisnik)
	{
		user = new Korisnik(korisnik);
	}
	
	private JPanel picturePHR() {
		BackgroundPanel pnl_PicPlaceHolderR = new BackgroundPanel(1);
		pnl_PicPlaceHolderR.setPreferredSize(new Dimension(75, 500));
		return pnl_PicPlaceHolderR;
	}

	private JPanel picturePHL() {
		BackgroundPanel pnl_PicPlaceHolderL = new BackgroundPanel(2);
		pnl_PicPlaceHolderL.setPreferredSize(new Dimension(75, 500));
		return pnl_PicPlaceHolderL;
	}

	private JPanel createTretiranje()
	{
		JPanel tBTretiranje = new JPanel();
		tBTretiranje.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),}));
		
		JScrollPane tBTretSPKarence = new JScrollPane();
		tBTretiranje.add(tBTretSPKarence, "1, 1, 10, 4, fill, fill");
		
		tableKarence = new JTable();
		tBTretSPKarence.setViewportView(tableKarence);
		tableKarence.setModel(DBSelect.getSveKarence());
		
		JScrollPane tBTretSPSredstva = new JScrollPane();
		tBTretiranje.add(tBTretSPSredstva, "1, 5, 10, 4, fill, fill");
		
		tableSredstva = new JTable();
		tBTretSPSredstva.setViewportView(tableSredstva);
		tableSredstva.setModel(DBSelect.getSredstva());
		
		JPanel tbTretEditing = new JPanel();
		tBTretiranje.add(tbTretEditing, "1, 9, 10, 2, fill, fill");
		tbTretEditing.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("70dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("70dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("70dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("70dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("70dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("70dlu"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		
		JLabel lblSredstvoTretiraj = new JLabel("Sredstvo:");
		tbTretEditing.add(lblSredstvoTretiraj, "2, 2, right, center");
		
		cBoxSredstvoTretiraj = new JComboBox<String>();
		tbTretEditing.add(cBoxSredstvoTretiraj, "4, 2, fill, center");
		cBoxSredstvoTretiraj.addItem("-");
		
		cBoxVocnjakTretiraj = new JComboBox<String>();
		
		for(String s : DBSelect.getSvaSredstvaNames()) cBoxSredstvoTretiraj.addItem(s);
		for(String imena : DBSelect.getImenaNasadaKorisnika(user.getKorisnickoIme()))
			cBoxVocnjakTretiraj.addItem(imena);
		
		JLabel lblSortTretiranje = new JLabel("Ime: ");
		tbTretEditing.add(lblSortTretiranje, "8, 2, right, default");
		
		tFSortTret = new JTextField();
		tbTretEditing.add(tFSortTret, "10, 2, fill, center");
		tFSortTret.setColumns(10);
		
		JComboBox<String> cBoxUtjeciNa = new JComboBox<String>();
		tbTretEditing.add(cBoxUtjeciNa, "12, 2, fill, center");
		cBoxUtjeciNa.addItem("Sredstvo");
		cBoxUtjeciNa.addItem("Karencu");
		
		JLabel lblVocnjakTretiraj = new JLabel("Vocnjak:");
		tbTretEditing.add(lblVocnjakTretiraj, "2, 4, right, center");
		
		JButton btnUrediSredstvo = new JButton("Uredi Sredstvo");
		btnUrediSredstvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tableSredstva.getSelectionModel().isSelectionEmpty())
				{
					EntryDialog ins = new EntryDialog(frame, user, 15);
					ins.setVisible(true);
				}
			}
		});
		
		JButton btwNewSredstvo = new JButton("Novo Sredstvo");
		btwNewSredstvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntryDialog ins = new EntryDialog(frame, user, 14);
				ins.setVisible(true);
			}
		});
		
		JButton btnTretirajVocnjak = new JButton("Tretiraj");
		btnTretirajVocnjak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiController.tretirajVocnjakSaSredstvom(cBoxSredstvoTretiraj.getSelectedItem().toString(), cBoxVocnjakTretiraj.getSelectedItem().toString());
			}
		});
		
		
		tbTretEditing.add(cBoxVocnjakTretiraj, "4, 4, fill, center");
		cBoxVocnjakTretiraj.addItem("-");
		tbTretEditing.add(btnTretirajVocnjak, "6, 4, fill, center");
		tbTretEditing.add(btwNewSredstvo, "8, 4, fill, center");
		tbTretEditing.add(btnUrediSredstvo, "10, 4, fill, center");
		
		JButton btnSort = new JButton("Filtriraj");
		tbTretEditing.add(btnSort, "12, 4, fill, center");
		
		return tBTretiranje;
	}
	
	private JPanel createNasad() {
		// Prikaz liste nasada, informacije o nasadu te sadrzaj reda
		JPanel tabNasad = new JPanel();
		tabNasad.setLayout(new BorderLayout(0, 0));

		JPanel tbNsdHeader = new JPanel();
		tbNsdHeader.setPreferredSize(new Dimension(650, 30));
		tabNasad.add(tbNsdHeader, BorderLayout.NORTH);
		tbNsdHeader.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		JLabel lblDDLNasad = new JLabel("Odaberite Nasad za prikaz:");
		tbNsdHeader.add(lblDDLNasad);

		choiceNasadPrikaz = new JComboBox<String>();
		choiceNasadPrikaz.setPreferredSize(new Dimension(200, 20));
		tbNsdHeader.add(choiceNasadPrikaz);
		choiceNasadPrikaz.addItem("Odaberite Nasad");		
		for(String imena : DBSelect.getImenaNasadaKorisnika(user.getKorisnickoIme()))
		choiceNasadPrikaz.addItem(imena);
	
		choiceNasadPrikaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!choiceNasadPrikaz.getSelectedItem().toString().equals("Odaberite Nasad"))
				{
				nasadInfoTable.setModel(DBSelect.getNasadKorisnika(user.getKorisnickoIme(), choiceNasadPrikaz.getSelectedItem().toString()));
				prikazRedovaTable.setModel(DBSelect.getSadrzajReda(Integer.parseInt(nasadInfoTable.getValueAt(0, 0).toString()), DBConst.emptyString, DBConst.emptyString));
				prikazPosadjenogURedu.setModel(DBSelect.getPosadenoByName(""));
				}
			}
		});

		JPanel tbNsdCenter = new JPanel();
		tabNasad.add(tbNsdCenter, BorderLayout.CENTER);
		tbNsdCenter.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("35dlu"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),}));

		JScrollPane sPaneNasadInfo = new JScrollPane();
		tbNsdCenter.add(sPaneNasadInfo, "1, 1, 6, 1, fill, fill");

		nasadInfoTable = new JTable(DBSelect.getNasadKorisnika(user.getKorisnickoIme(), ""));
		nasadInfoTable.setColumnSelectionAllowed(true);
		nasadInfoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		nasadInfoTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e)
				{
					if(!prikazRedovaTable.getSelectionModel().isSelectionEmpty() ) prikazRedovaTable.getSelectionModel().clearSelection();
					if(!prikazPosadjenogURedu.getSelectionModel().isSelectionEmpty() ) prikazPosadjenogURedu.getSelectionModel().clearSelection();
				}
		});
		sPaneNasadInfo.setViewportView(nasadInfoTable);
		
		JPanel nasadEditPanel = new JPanel();
		tbNsdCenter.add(nasadEditPanel, "1, 2, 2, 5, fill, fill");
		nasadEditPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("85dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("85dlu"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
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
				
		JLabel lblVockaPrikaz = new JLabel("Vocka za prikaz:");
		nasadEditPanel.add(lblVockaPrikaz, "2, 2, right, center");
		
		tFVockaZaPrikaz = new JTextField();
		nasadEditPanel.add(tFVockaZaPrikaz, "4, 2, fill, center");
		tFVockaZaPrikaz.setColumns(10);
				
		JLabel lblRedZaPrikaz = new JLabel("Red za prikaz:");
		nasadEditPanel.add(lblRedZaPrikaz, "2, 4, right, center");
				
		JButton btnPromijeni = new JButton("Promijeni Tablicu");
		btnPromijeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						/*
						 * switch choice
						 * 1 unos novog nasada
						 * 2 promjena postojeceg nasada *
						 * 3 update broj mjesta u redu
						 * 4 unos novog reda
						 * 5 promijeni sadrzaj posadjenog na mjestu / u redu *
						 */	
			if(!nasadInfoTable.getSelectionModel().isSelectionEmpty() ) {
					EntryDialog ins = new EntryDialog(frame, user, 2);
					ins.setVisible(true);
				}
			if(!prikazRedovaTable.getSelectionModel().isSelectionEmpty() ) {
					EntryDialog ins = new EntryDialog(frame, user, 5);
					ins.setVisible(true);
				}
			}
			});
			
			tFRedZaPrikaz = new JTextField();
			nasadEditPanel.add(tFRedZaPrikaz, "4, 4, fill, center");
			tFRedZaPrikaz.setColumns(6);
			nasadEditPanel.add(btnPromijeni, "2, 6, fill, center");
				
			JButton btnNoviNasad = new JButton("Dodaj novi");
			btnNoviNasad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						/*
						 * switch choice
						 * 1 unos novog nasada *
						 * 2 promjena postojeceg nasada *
						 * 3 update broj mjesta u redu
						 * 4 unos novog reda *
						 * 5 promijeni sadrzaj posadjenog na mjestu / u redu *
						 */	
			if(cBoxNoviNasadRed.getSelectedItem().toString().equals("Nasad"))
						{
							EntryDialog ins = new EntryDialog(frame, user, 1);
							ins.setVisible(true);
						}
			if(cBoxNoviNasadRed.getSelectedItem().toString().equals("Red"))
						{
							EntryDialog ins = new EntryDialog(frame, user, 4);
							ins.setVisible(true);
						}
			
			choiceNasadPrikaz.removeAllItems();
			choiceNasadPrikaz.addItem("Odaberite Nasad");
			for(String imena : DBSelect.getImenaNasadaKorisnika(user.getKorisnickoIme()))
				choiceNasadPrikaz.addItem(imena);
					}
			});
			
			JButton btnPrikaziTrazeno = new JButton("Prikazi");
			btnPrikaziTrazeno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					prikazRedovaTable.setModel(DBSelect.getSadrzajReda(Integer.parseInt(nasadInfoTable.getValueAt(0, 0).toString()),
					tFVockaZaPrikaz.getText(),
					tFRedZaPrikaz.getText()
					));				
				}
				});
			
			btnPrikaziTrazeno.setText("Prikazi");
			nasadEditPanel.add(btnPrikaziTrazeno, "4, 6, fill, center");
			nasadEditPanel.add(btnNoviNasad, "2, 8, fill, center");
		
		cBoxNoviNasadRed = new JComboBox<String>();
		cBoxNoviNasadRed.addItem("Nasad");
		cBoxNoviNasadRed.addItem("Red");
		nasadEditPanel.add(cBoxNoviNasadRed, "4, 8, fill, center");
		JPanel prikazRedovaPanel = new JPanel();
		tbNsdCenter.add(prikazRedovaPanel, "4, 2, 3, 5, fill, fill");
		prikazRedovaPanel.setLayout(new BorderLayout(0, 0));
		
		
		JScrollPane sPanePrikazRedova = new JScrollPane();
		prikazRedovaPanel.add(sPanePrikazRedova, BorderLayout.WEST);

		prikazRedovaTable = new JTable(DBSelect.getSadrzajReda(0, DBConst.emptyString, DBConst.emptyString));
		prikazRedovaTable.setAutoCreateRowSorter(true);
		prikazRedovaTable.setColumnSelectionAllowed(true);
		prikazRedovaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		prikazRedovaTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e)
				{
				if(!nasadInfoTable.getSelectionModel().isSelectionEmpty()) nasadInfoTable.getSelectionModel().clearSelection();
				if(!prikazPosadjenogURedu.getSelectionModel().isSelectionEmpty()) prikazPosadjenogURedu.getSelectionModel().clearSelection();
				
				if(prikazRedovaTable.getSelectedRow()!=-1 & prikazRedovaTable.getSelectedColumn()!=-1)
					{
						String selectedPosadeno = prikazRedovaTable.getValueAt(prikazRedovaTable.getSelectedRow(), 2).toString();
						prikazPosadjenogURedu.setModel(DBSelect.getPosadenoByName(selectedPosadeno));
					}
				}
			});		

		sPanePrikazRedova.setViewportView(prikazRedovaTable);

		JPanel tbNsdFooter = new JPanel();
		tbNsdFooter.setPreferredSize(new Dimension(650, 50));
		tabNasad.add(tbNsdFooter, BorderLayout.SOUTH);
		tbNsdFooter.setLayout(new BorderLayout(0, 0));
		
		JScrollPane sPanePosadenoSelected = new JScrollPane();
		tbNsdFooter.add(sPanePosadenoSelected);

		prikazPosadjenogURedu = new JTable(DBSelect.getPosadenoByName(""));
		prikazPosadjenogURedu.setAutoCreateRowSorter(true);
		prikazPosadjenogURedu.setColumnSelectionAllowed(true);
		prikazPosadjenogURedu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		prikazPosadjenogURedu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e)
			{
			if(!nasadInfoTable.getSelectionModel().isSelectionEmpty()) nasadInfoTable.getSelectionModel().clearSelection();
			if(!prikazRedovaTable.getSelectionModel().isSelectionEmpty()) prikazRedovaTable.getSelectionModel().clearSelection();
			}
		});
		
		sPanePosadenoSelected.setViewportView(prikazPosadjenogURedu);

		return tabNasad;
	}
	
	public static Vector<String> basicInfoPosadjenoSelected()
	{
		Vector<String> tempVec = new Vector<String>();
		int row = prikazRedovaTable.getSelectedRow();
		tempVec.add(choiceNasadPrikaz.getSelectedItem().toString());
		if(prikazRedovaTable.getValueAt(row, 0)== null) return null;
		else tempVec.add(prikazRedovaTable.getValueAt(row, 0).toString());
		if(prikazRedovaTable.getValueAt(row, 1)==null) return null;
		else tempVec.add(prikazRedovaTable.getValueAt(row, 1).toString());
		if(prikazRedovaTable.getValueAt(row, 2)==null) return null;
		else tempVec.add(prikazRedovaTable.getValueAt(row, 2).toString());
		if(prikazRedovaTable.getValueAt(row, 3)==null) return null;
		else tempVec.add(prikazRedovaTable.getValueAt(row, 3).toString());
		return tempVec;
	}
	
	public static String getNasadNazivFromTable()
	{
		return nasadInfoTable.getValueAt(0, 2).toString();
	}
	
	private JPanel createSadniceINavodnjavanje() {
		JPanel sadniceINavodnjavanje = new JPanel();
		sadniceINavodnjavanje.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("default:grow"), ColumnSpec.decode("default:grow"),
						ColumnSpec.decode("default:grow"), ColumnSpec.decode("default:grow"),
						ColumnSpec.decode("default:grow"), ColumnSpec.decode("default:grow"),
						ColumnSpec.decode("default:grow"), ColumnSpec.decode("default:grow"),
						ColumnSpec.decode("default:grow"), ColumnSpec.decode("default:grow"), },
				new RowSpec[] { RowSpec.decode("default:grow"), RowSpec.decode("default:grow"),
						RowSpec.decode("default:grow"), RowSpec.decode("default:grow"), RowSpec.decode("default:grow"),
						RowSpec.decode("default:grow"), RowSpec.decode("default:grow"), RowSpec.decode("default:grow"),
						RowSpec.decode("default:grow"), RowSpec.decode("default:grow"), }));

		JPanel pSadnica = new JPanel();
		sadniceINavodnjavanje.add(pSadnica, "1, 1, 6, 5, fill, fill");
		pSadnica.setBackground(Color.RED);
		pSadnica.setLayout(new BorderLayout(0, 0));

		JScrollPane scrPaneSadnica = new JScrollPane();
		pSadnica.add(scrPaneSadnica, BorderLayout.CENTER);

		tablePosadeno = new JTable(DBSelect.getPosadeno());
		tablePosadeno.setAutoCreateRowSorter(true);
		tablePosadeno.setColumnSelectionAllowed(true);
		tablePosadeno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePosadeno.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e)
				{
					if(!tableSorta.getSelectionModel().isSelectionEmpty()) tableSorta.getSelectionModel().clearSelection();
					if(!tableNavodnjavanje.getSelectionModel().isSelectionEmpty()) tableNavodnjavanje.getSelectionModel().clearSelection();
					if(!tablePodloga.getSelectionModel().isSelectionEmpty()) tablePodloga.getSelectionModel().clearSelection();
					if(!tablePosadeno.getSelectionModel().isSelectionEmpty())
					{
						cBoxUniEditUtjeciNa.setSelectedItem("Sadnice");
						cBoxUniEditID.setSelectedItem(tablePosadeno.getValueAt(tablePosadeno.getSelectedRow(), 0).toString());
					}
					
				}
			});
		scrPaneSadnica.setViewportView(tablePosadeno);

		JPanel pSorta = new JPanel();
		sadniceINavodnjavanje.add(pSorta, "7, 1, 4, 5, fill, fill");
		pSorta.setLayout(new BorderLayout(0, 0));

		JScrollPane scrPaneSorta = new JScrollPane();
		pSorta.add(scrPaneSorta, BorderLayout.CENTER);

		tableSorta = new JTable(DBSelect.getSorte());
		tableSorta.setAutoCreateRowSorter(true);
		tableSorta.setColumnSelectionAllowed(true);
		tableSorta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSorta.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e)
				{
				if(!tablePosadeno.getSelectionModel().isSelectionEmpty()) tablePosadeno.getSelectionModel().clearSelection();
				if(!tableNavodnjavanje.getSelectionModel().isSelectionEmpty()) tableNavodnjavanje.getSelectionModel().clearSelection();
				if(!tablePodloga.getSelectionModel().isSelectionEmpty()) tablePodloga.getSelectionModel().clearSelection();
				if(!tableSorta.getSelectionModel().isSelectionEmpty())
				{
					cBoxUniEditUtjeciNa.setSelectedItem("Sorte");
					cBoxUniEditID.setSelectedItem(tableSorta.getValueAt(tableSorta.getSelectedRow(), 0).toString());
				}
				}
			});
		scrPaneSorta.setViewportView(tableSorta);
		
		JPanel pNavodnjavanje = new JPanel();
		sadniceINavodnjavanje.add(pNavodnjavanje, "1, 6, 6, 3, fill, fill");
		pNavodnjavanje.setLayout(new BorderLayout(0, 0));

		JScrollPane scrPaneNavodnjavanje = new JScrollPane();
		pNavodnjavanje.add(scrPaneNavodnjavanje, BorderLayout.CENTER);

		tableNavodnjavanje = new JTable(DBSelect.getNavodnjavanje());
		tableNavodnjavanje.setAutoCreateRowSorter(true);
		tableNavodnjavanje.setColumnSelectionAllowed(true);
		tableNavodnjavanje.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableNavodnjavanje.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e)
				{
				if(!tablePosadeno.getSelectionModel().isSelectionEmpty()) tablePosadeno.getSelectionModel().clearSelection();
				if(!tableSorta.getSelectionModel().isSelectionEmpty()) tableSorta.getSelectionModel().clearSelection();
				if(!tablePodloga.getSelectionModel().isSelectionEmpty()) tablePodloga.getSelectionModel().clearSelection();
				if(!tableNavodnjavanje.getSelectionModel().isSelectionEmpty())
				{
					cBoxUniEditUtjeciNa.setSelectedItem("Navodnjavanje");
					cBoxUniEditID.setSelectedItem(tableNavodnjavanje.getValueAt(tableNavodnjavanje.getSelectedRow(), 0).toString());
				}
				}
			});
		scrPaneNavodnjavanje.setViewportView(tableNavodnjavanje);
	
		JPanel pPodloga = new JPanel();
		sadniceINavodnjavanje.add(pPodloga, "7, 6, 4, 3, fill, fill");
		pPodloga.setLayout(new BorderLayout(0, 0));
		
		JScrollPane sPanePodloga = new JScrollPane();
		pPodloga.add(sPanePodloga, BorderLayout.CENTER);
		
		tablePodloga = new JTable(DBSelect.getPodloge());
		tablePodloga.setAutoCreateRowSorter(true);
		tablePodloga.setColumnSelectionAllowed(true);
		tablePodloga.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePodloga.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e)
				{
				if(!tablePosadeno.getSelectionModel().isSelectionEmpty()) tablePosadeno.getSelectionModel().clearSelection();
				if(!tableSorta.getSelectionModel().isSelectionEmpty()) tableSorta.getSelectionModel().clearSelection();
				if(!tableNavodnjavanje.getSelectionModel().isSelectionEmpty()) tableNavodnjavanje.getSelectionModel().clearSelection();
				if(!tablePodloga.getSelectionModel().isSelectionEmpty())
				{
					cBoxUniEditUtjeciNa.setSelectedItem("Podloge");
					cBoxUniEditID.setSelectedItem(tablePodloga.getValueAt(tablePodloga.getSelectedRow(), 0).toString());
				}
				}
			});
		sPanePodloga.setViewportView(tablePodloga);			
		
		JPanel pUniversalEdit = new JPanel();
		sadniceINavodnjavanje.add(pUniversalEdit, "1, 9, 10, 2, fill, fill");
		pUniversalEdit.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("4dlu:grow"),
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("75dlu"),
				ColumnSpec.decode("4dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("4dlu:grow"),
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				RowSpec.decode("4dlu:grow"),}));
		JButton btnUniEditInsert = new JButton("Dodaj");
		btnUniEditInsert.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switch(cBoxUniEditUtjeciNa.getSelectedItem().toString())
						{
							case ("Sadnice"):
							{
								EntryDialog ins = new EntryDialog(frame, user, 6);
								ins.setVisible(true);			
							}break;
							case ("Sorte"):
							{
								EntryDialog ins = new EntryDialog(frame, user, 10);
								ins.setVisible(true);
							}break;
							case ("Podloge"):
							{
								EntryDialog ins = new EntryDialog(frame, user, 8);
								ins.setVisible(true);
							}break;
							case ("Navodnjavanje"):
							{
								EntryDialog ins = new EntryDialog(frame, user, 12);
								ins.setVisible(true);
							}break;	
						}
					}
				});
		
		cBoxUniEditUtjeciNa = new JComboBox<String>();		
		cBoxUniEditUtjeciNa.addItem("---");
		
		cBoxUniEditUtjeciNa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cBoxUniEditUtjeciNa.getSelectedItem().toString())
				{
				case ("Sadnice"):
					{
						cBoxUniEditID.removeAllItems();
						cBoxUniEditID.addItem("---");
						for(Integer i : DBSelect.getAllIDSadnice()) cBoxUniEditID.addItem(String.valueOf(i));						
					}break;
					case ("Sorte"):
					{
						cBoxUniEditID.removeAllItems();
						cBoxUniEditID.addItem("---");
						for(Integer i : DBSelect.getAllIDSorte()) cBoxUniEditID.addItem(String.valueOf(i));
					}break;
					case ("Podloge"):
					{
						cBoxUniEditID.removeAllItems();
						cBoxUniEditID.addItem("---");
						for(Integer i : DBSelect.getAllIDPodloge()) cBoxUniEditID.addItem(String.valueOf(i));
					}break;
					case ("Navodnjavanje"):
					{
						cBoxUniEditID.removeAllItems();
						cBoxUniEditID.addItem("---");
						for(Integer i : DBSelect.getAllIDNavodnjavanje()) cBoxUniEditID.addItem(String.valueOf(i));
					}break;	
				}
			}
		});
		
		JLabel lblUniEditUtjeciNa = new JLabel("Utjecaj na:");
		pUniversalEdit.add(lblUniEditUtjeciNa, "2, 2, right, center");
		pUniversalEdit.add(cBoxUniEditUtjeciNa, "4, 2, fill, center");
		cBoxUniEditUtjeciNa.addItem("Sadnice");
		cBoxUniEditUtjeciNa.addItem("Sorte");
		cBoxUniEditUtjeciNa.addItem("Podloge");
		cBoxUniEditUtjeciNa.addItem("Navodnjavanje");
		
		pUniversalEdit.add(btnUniEditInsert, "6, 2, fill, center");
		
		JLabel lblUniEditPodIdBrojem = new JLabel("Pod ID brojem:");
		pUniversalEdit.add(lblUniEditPodIdBrojem, "2, 4, right, center");
		
		cBoxUniEditID = new JComboBox<String>();
		cBoxUniEditID.addItem("---");
		pUniversalEdit.add(cBoxUniEditID, "4, 4, fill, center");
		
		JButton btnUniEditUpdate = new JButton("Promijeni");
		btnUniEditUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cBoxUniEditUtjeciNa.getSelectedItem().toString())
				{
					case ("Sadnice"):
					{
						EntryDialog ins = new EntryDialog(frame, user, 7);
						ins.setVisible(true);			
					}break;
					case ("Sorte"):
					{
						EntryDialog ins = new EntryDialog(frame, user, 11);
						ins.setVisible(true);	
					}break;
					case ("Podloge"):
					{
						EntryDialog ins = new EntryDialog(frame, user, 9);
						ins.setVisible(true);	
					}break;
					case ("Navodnjavanje"):
					{
						EntryDialog ins = new EntryDialog(frame, user, 13);
						ins.setVisible(true);	
					}break;	
				}
			}
		});
		pUniversalEdit.add(btnUniEditUpdate, "6, 4, fill, center");
		
		JButton btnUniEditDelete = new JButton("Obrisi");
		pUniversalEdit.add(btnUniEditDelete, "8, 4");
		
		return sadniceINavodnjavanje;
	}
	
	public static int getSelectedVockaID()
	{
		return Integer.valueOf(tablePosadeno.getValueAt(tablePosadeno.getSelectedRow(), 0).toString()).intValue();
	}
	public static int getSelectedSortaID()
	{
		return Integer.valueOf(tableSorta.getValueAt(tableSorta.getSelectedRow(), 0).toString()).intValue();
	}
	public static int getSelectedPodlogaID()
	{
		return Integer.valueOf(tablePodloga.getValueAt(tablePodloga.getSelectedRow(), 0).toString()).intValue();
	}
	public static int getSelectedNavodnjavanjeID()
	{
		return Integer.valueOf(tableNavodnjavanje.getValueAt(tableNavodnjavanje.getSelectedRow(), 0).toString()).intValue();
	}
	public static int getSelectedSredstvoID()
	{
		return Integer.valueOf(tableSredstva.getValueAt(tableSredstva.getSelectedRow(), 0).toString()).intValue();
	}

}
