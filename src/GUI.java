import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_4;
	private JTextField textField_10;
	private JTextField textField_6;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	 * @throws IOException 
	 */
	public GUI() throws IOException {
		initialize();
	}
	 public static void infoBox(String infoMessage)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "Wiadomoœæ", JOptionPane.INFORMATION_MESSAGE);
	    }
	 public static String getBox(String infoMessage)
	    {
	        return JOptionPane.showInputDialog(null,infoMessage);
	    }
	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		Centrala centrala = new Centrala(); 
		if (centrala.odczyt()==false)
			infoBox("Nie uda³o siê za³adowaæ poprzedniej sesji (Brak pliku)");
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 433);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setResizable(false);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "name_91170591739072");
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Centrala", null, panel_1, null);
		panel_1.setLayout(null);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(34, 153, 97, 22);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Bank", null, panel, null);
		panel.setLayout(null);
		
			JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_1.setBounds(12, 13, 463, 355);
			panel.add(tabbedPane_1);
			
			JPanel panel_5 = new JPanel();
			tabbedPane_1.addTab("Wp³aty na karty", null, panel_5, null);
			panel_5.setLayout(null);
			
			JLabel lblPodajNumerKonta_2 = new JLabel("Podaj numer karty");
			lblPodajNumerKonta_2.setBounds(130, 13, 122, 16);
			panel_5.add(lblPodajNumerKonta_2);
			
			textField_6 = new JTextField();
			textField_6.setToolTipText("Tu wpisz numer konta");
			textField_6.setBounds(69, 42, 226, 22);
			panel_5.add(textField_6);
			textField_6.setColumns(10);
			
			JLabel lblPodajKwot = new JLabel("Podaj kwot\u0119");
			lblPodajKwot.setBounds(149, 71, 77, 16);
			panel_5.add(lblPodajKwot);
			
			textField_11 = new JTextField();
			textField_11.setToolTipText("Tu wpisz kwot\u0119.Zamiast przecinka u\u017Cyj kropki!!");
			textField_11.setBounds(130, 89, 116, 22);
			panel_5.add(textField_11);
			textField_11.setColumns(10);
			
			JButton btnWpa = new JButton("Wp\u0142a\u0107");
			btnWpa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean spr=false;
					if (textField_6.getText().isEmpty() ||textField_11.getText().isEmpty())
						infoBox("Puste pole nie mo¿na wp³aciæ");
					else {
						try {
							double i = Double.parseDouble(textField_11.getText());
							for (Bank bank:centrala.getBanki())
								for (Klient klient : bank.getKlienci())
									for (Konto konto : klient.getKonta())
										for (Karta karta : konto.getKarty()){
											if (karta.getNrKarty().equals(textField_6.getText())){
												konto.wplac(i, karta);
												infoBox("Wp³acono œrodki na kartê");
												spr=true;
												break;
										}

									}
							if (spr==false)
								infoBox("Nie znaleziono podanej karty");
						}
						catch (NumberFormatException b) { 			        	
							infoBox("Wprowadzona kwoata nie jest liczb¹");
					}
				}
				}
			});
			btnWpa.setBounds(140, 124, 97, 25);
			panel_5.add(btnWpa);
			
			
			JPanel panel_4 = new JPanel();
			tabbedPane_1.addTab("Zarz¹dzanie Kontem", null, panel_4, null);
			panel_4.setLayout(null);
			
			JLabel lblDodajKart = new JLabel("Dodaj kart\u0119");
			lblDodajKart.setBounds(32, 13, 99, 21);
			lblDodajKart.setFont(new Font( "Seref" ,Font.PLAIN ,16)); 
			panel_4.add(lblDodajKart);
			
			JLabel lblUsuKart = new JLabel("Usu\u0144 kart\u0119");
			lblUsuKart.setBounds(235, 13, 82, 21);
			lblUsuKart.setFont(new Font( "Seref" ,Font.PLAIN ,16)); 
			panel_4.add(lblUsuKart);
			
			JLabel lblPodajNumerKarty = new JLabel("Podaj numer karty");
			lblPodajNumerKarty.setBounds(32, 81, 114, 16);
			panel_4.add(lblPodajNumerKarty);
			
			textField_12 = new JTextField();
			textField_12.setBounds(32, 58, 116, 22);
			panel_4.add(textField_12);
			textField_12.setColumns(10);
			
			JLabel lblPodajNr = new JLabel("Podaj nr konta");
			lblPodajNr.setBounds(32, 40, 114, 16);
			panel_4.add(lblPodajNr);
			
			textField_13 = new JTextField();
			textField_13.setBounds(32, 98, 116, 22);
			panel_4.add(textField_13);
			textField_13.setColumns(10);
			
			JLabel lblRodzaj = new JLabel("Rodzaj");
			lblRodzaj.setBounds(32, 163, 56, 16);
			panel_4.add(lblRodzaj);
			
			JComboBox<String> comboBox_5 = new JComboBox<String>();
			comboBox_5.setBounds(32, 181, 114, 21);
			comboBox_5.addItem("Debetowa");
			comboBox_5.addItem("Bankomatowa");
			comboBox_5.addItem("Kredytowa");
			panel_4.add(comboBox_5);
			
			JButton btnDodaj_2 = new JButton("Dodaj");
			btnDodaj_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean spr= false,czyjest=false;
					if (textField_12.getText().isEmpty() || textField_13.getText().isEmpty() || textField_14.getText().isEmpty())
						infoBox("Puste pole nie mo¿na dodaæ karty");
					else {
						for (Bank bank1 : centrala.getBanki())
							for (Klient klient1 : bank1.getKlienci())
								for (Konto konto1 : klient1.getKonta()) 
									for (Karta karta : konto1.getKarty())
										if (karta.getNrKarty().equals(textField_13.getText()))
											czyjest=true;
						if (czyjest==false){
						try {
							double i = Double.parseDouble(textField_14.getText());
							for (Bank bank : centrala.getBanki())
								for (Klient klient : bank.getKlienci())
									for (Konto konto : klient.getKonta())
										if (konto.getNr().equals(textField_12.getText()))
										{
											konto.dodajKarte(new Karta(textField_13.getText(),i,klient.getPesel(),(String)comboBox_5.getSelectedItem()));
											infoBox("Dodano kartê");
											spr=true;
											break;
										}
							if (spr==false)
								infoBox("Nie znaleziono takiego konta");
							}
							catch (NumberFormatException h) {
				        	infoBox("Wprowadzone saldo nie jest liczb¹");
							}
						}
						else infoBox("Ju¿ jest karta o takim numerze");
					}		
				}
			});
			btnDodaj_2.setBounds(42, 218, 97, 25);
			panel_4.add(btnDodaj_2);
			
			JLabel lblSaldoPocztkowe = new JLabel("Saldo pocz\u0105tkowe");
			lblSaldoPocztkowe.setBounds(32, 121, 114, 16);
			panel_4.add(lblSaldoPocztkowe);
			
			textField_14 = new JTextField();
			textField_14.setToolTipText("Tu wpisz saldo. Pami\u0119taj o kropce zamiast przecinka!!");
			textField_14.setBounds(32, 140, 116, 22);
			panel_4.add(textField_14);
			textField_14.setColumns(10);
			
			JLabel lblPodajNumerKarty_1 = new JLabel("Podaj numer karty");
			lblPodajNumerKarty_1.setBounds(235, 40, 114, 16);
			panel_4.add(lblPodajNumerKarty_1);
			
			textField_15 = new JTextField();
			textField_15.setBounds(233, 58, 116, 22);
			panel_4.add(textField_15);
			textField_15.setColumns(10);
			
			JButton btnUsu_1 = new JButton("Usu\u0144");
			btnUsu_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Konto a=null;
					Karta b=null;
					boolean spr=false;
					if (textField_15.getText().isEmpty())
						infoBox("Puste pole nie mo¿na usun¹æ karty");
					else {
						for (Bank bank: centrala.getBanki())
							for (Klient klient : bank.getKlienci())
								for (Konto konto: klient.getKonta())
									for (Karta karta : konto.getKarty())
										if (karta.getNrKarty().equals(textField_15.getText())){
											spr=true;
											a=konto;
											b=karta;
										}
						
						if (spr==false)
							infoBox("Nie znaleziono takiej karty");
						else {
							a.usunKarte(b);
							infoBox("Usunieto karte");
							
						}
						
					}
					
				}
			});
			btnUsu_1.setBounds(243, 97, 97, 25);
			panel_4.add(btnUsu_1);
			
			JPanel panel_6 = new JPanel();
			tabbedPane_1.addTab("Zak³adanie/usuwanie konta", null, panel_6, null);
			panel_6.setLayout(null);
			
			JLabel lblDodajKonto = new JLabel("Dodaj konto");
			lblDodajKonto.setBounds(34, 13, 97, 27);
			lblDodajKonto.setFont(new Font( "Seref" ,Font.PLAIN ,16)); 
			panel_6.add(lblDodajKonto);
			
			JLabel lblUsuKonto = new JLabel("Usu\u0144 konto");
			lblUsuKonto.setBounds(247, 16, 126, 20);
			lblUsuKonto.setFont(new Font( "Seref" ,Font.PLAIN ,16));
			panel_6.add(lblUsuKonto);
			
			textField_5 = new JTextField();
			textField_5.setToolTipText("Tu wpisz sw\u00F3j pesel");
			textField_5.setBounds(34, 68, 116, 22);
			panel_6.add(textField_5);
			textField_5.setColumns(10);
			
			JLabel lblPodajPesel = new JLabel("Podaj Pesel");
			lblPodajPesel.setBounds(34, 51, 86, 15);
			panel_6.add(lblPodajPesel);
			
			JLabel lblWybierzBank = new JLabel("Wybierz bank");
			lblWybierzBank.setBounds(34, 133, 86, 16);
			panel_6.add(lblWybierzBank);
			
			
			panel_6.add(comboBox_1);
			JComboBox<String> comboBox_4 = new JComboBox<String>();
			comboBox_4.setBounds(34, 193, 68, 22);
			comboBox_4.addItem("PLN");
			comboBox_4.addItem("EUR");
			comboBox_4.addItem("USD");
			comboBox_4.addItem("GBP");
			comboBox_4.addItem("CZK");
			panel_6.add(comboBox_4);
			JButton btnDodaj_1 = new JButton("Dodaj");
			btnDodaj_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean spr=false;
				if (textField_5.getText().isEmpty() || textField_4.getText().isEmpty())
						infoBox("Puste pole nie mo¿na dodaæ konta");
				else {
					for (Bank bank : centrala.getBanki())
						if (bank.getNazwa().equals((String)comboBox_1.getSelectedItem()))
						{
							for (Bank bank2: centrala.getBanki()) //sprawdzam czy nie istenije ju¿ konto o takim numerze
								for (Klient klient : bank2.getKlienci())
									for (Konto konto: klient.getKonta()){
										if (konto.getNr().equals(textField_4.getText())){
												spr=true;
												break;
										}
										else {
											spr=false;
										}
									
									}
							if (spr==false){
									boolean sp=false;
									for (Klient klient : bank.getKlienci())
										if (klient.getPesel().equals(textField_5.getText()))
										{
											klient.dodajKonto(new Konto(textField_4.getText(),(String)comboBox_4.getSelectedItem()));
											infoBox("Dodano konto ");
											sp=true;
										break;
										}
								if (sp==false){
										Klient a = new Klient(textField_5.getText());
										bank.dodajKlienta(a);
										a.dodajKonto(new Konto(textField_4.getText(),(String)comboBox_4.getSelectedItem()));
										infoBox("Dodano konto");
										
								}
									
								break;
								
							}
							else {
								infoBox("Ju¿ istnieje konto o takim numerze");
								break;
							}
						}
					}
				
			
				}
			});
			btnDodaj_1.setBounds(34, 228, 97, 25);
			panel_6.add(btnDodaj_1);
			
			JLabel lblWaluta_1 = new JLabel("Waluta");
			lblWaluta_1.setBounds(34, 174, 56, 16);
			panel_6.add(lblWaluta_1);
			
	
			
			textField_4 = new JTextField();
			textField_4.setToolTipText("Tu wpisz numer konta");
			textField_4.setBounds(34, 111, 116, 22);
			panel_6.add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblPodajNumerKonta = new JLabel("Podaj numer konta");
			lblPodajNumerKonta.setBounds(34, 92, 116, 16);
			panel_6.add(lblPodajNumerKonta);
			
			textField_10 = new JTextField();
			textField_10.setBounds(247, 68, 116, 22);
			panel_6.add(textField_10);
			textField_10.setColumns(10);
			
			JLabel lblPodajNumerKonta_1 = new JLabel("Podaj numer konta");
			lblPodajNumerKonta_1.setBounds(247, 50, 116, 16);
			panel_6.add(lblPodajNumerKonta_1);
			
			JButton btnUsu = new JButton("Usu\u0144");
			btnUsu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean spr=false;
					if (textField_10.getText().isEmpty())
						infoBox("Puste pole nie mo¿na usun¹æ konta");
					else {
						for (Bank bank:centrala.getBanki())
							for (Klient klient : bank.getKlienci())
								for (Konto konto: klient.getKonta())
									if(konto.getNr().equals(textField_10.getText())){
										klient.usunKonto(konto);
										infoBox("Usuniêto konto");
										spr=true;
										break;
									}
						if (spr==false)
							infoBox("Nie znaleziono konta o takim numerze");
						
					}
					
				}
			});
			btnUsu.setBounds(247, 109, 97, 27);
			panel_6.add(btnUsu);
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Sprzeda¿", null, panel_2, null);
		panel_2.setLayout(null);
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		for (Sprzedawca sprzedawca : centrala.getSprzedawcy())
			comboBox_3.addItem(sprzedawca.Nazwa);
		comboBox_3.setBounds(135, 181, 107, 22);
		panel_2.add(comboBox_3);
		for (Bank bank:centrala.getBanki())
		{
			comboBox_1.addItem(bank.getNazwa());
		}
		JButton btnNewButton = new JButton("Dodaj bank");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().isEmpty())
					infoBox("Puste pole nie mo¿na dodaæ banku o takiej nazwie");
				else {
				boolean czy=false;
				for ( Bank i : centrala.getBanki())
					if (i.getNazwa().equals(textField.getText())){
						czy = true;
						infoBox("Ju¿ jest bank o takiej nazwie!!!");
					}	
				if (czy==false)
					{centrala.setBanki(new Bank(textField.getText())); 
				infoBox("Dodano bank "+ centrala.getbank(centrala.getBanki().size()-1).getNazwa()); 
				comboBox_1.addItem(centrala.getbank(centrala.getBanki().size()-1).getNazwa());
				}
				}
				}
		});
		btnNewButton.setBounds(51, 73, 97, 25);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setToolTipText("Tu wpisz nazw\u0119 banku");
		textField.setBounds(28, 30, 151, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblDodawanieBanku = new JLabel("Dodawanie Banku");
		lblDodawanieBanku.setBounds(25, 13, 164, 16);
		panel_1.add(lblDodawanieBanku);
		
		JLabel lblUsuwanieBanku = new JLabel("Usuwanie banku");
		lblUsuwanieBanku.setBounds(257, 13, 113, 16);
		panel_1.add(lblUsuwanieBanku);
		JButton btnUsuBank = new JButton("Usu\u0144 bank");
		
		btnUsuBank.setBounds(273, 73, 97, 25);
		panel_1.add(btnUsuBank);
		
		textField_1 = new JTextField();
		textField_1.setBounds(257, 30, 151, 30);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("Tu wpisz nazw\u0119 sprzedawcy");
		textField_7.setBounds(25, 152, 151, 30);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("Tu wpisz nazw\u0119 sprzedawcy");
		textField_8.setBounds(254, 175, 142, 30);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblDodawanieSprzedawcy = new JLabel("Dodawanie sprzedawcy");
		lblDodawanieSprzedawcy.setBounds(25, 135, 184, 16);
		panel_1.add(lblDodawanieSprzedawcy);
		
		JLabel lblUsuwanieSprzedawcy = new JLabel("Usuwanie sprzedawcy");
		lblUsuwanieSprzedawcy.setBounds(254, 158, 142, 16);
		panel_1.add(lblUsuwanieSprzedawcy);
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.addItem("Sklep");
		comboBox_2.addItem("Zak³ad us³ugowy");
		comboBox_2.addItem("Firma transportowa");
		comboBox_2.setBounds(25, 245, 134, 22);
		panel_1.add(comboBox_2);
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_7.getText().isEmpty() || textField_9.getText().isEmpty())
					infoBox("Puste pole nie mo¿na dodaæ sprzedawcy");
				boolean spr=false,spr2=false;
				for (Sprzedawca sprzedawca : centrala.getSprzedawcy()){
					if (sprzedawca.Nazwa.equals(textField_7.getText()))
						spr=true;
					if (sprzedawca.getNrKonta().equals(textField_9.getText()))
						spr2=true;
				}
				for (Bank bank:centrala.getBanki())
					for (Klient klient : bank.getKlienci())
						for (Konto konto : klient.getKonta())
							if(konto.getNr().equals(textField_9))
								spr2=true;
				if (spr==true)
					infoBox("Ju¿ jest sprzedawca o takiej nazwie");
				if (spr2==true)
					infoBox("Ju¿ jest ktoœ o takim numerze konta");
				if (spr==false && spr2==false){
					if (comboBox_2.getSelectedItem().equals("Sklep"))
						centrala.setSprzedawcy(new Sklep(textField_7.getText(),textField_9.getText()));
					if (comboBox_2.getSelectedItem().equals("Zak³ad us³ugowy"))
						centrala.setSprzedawcy(new Zakladuslugowy(textField_7.getText(),textField_9.getText()));
					if (comboBox_2.getSelectedItem().equals("Firma transportowa"))
						centrala.setSprzedawcy(new Firmatransportowa(textField_7.getText(),textField_9.getText()));
					comboBox_3.addItem(textField_7.getText());
				infoBox("Dodano sprzedawce o nazwie "+ textField_7.getText() );
				}
			}
		});
		btnDodaj.setBounds(48, 278, 97, 40);
		panel_1.add(btnDodaj);
		
		JButton btnUsun = new JButton("Usuñ");
		btnUsun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean spr=false;
				if (textField_8.getText().isEmpty())
					infoBox("Puste pole nie mo¿na usun¹æ sprzedawcy ");
				else {
					for (Sprzedawca sprzedawca: centrala.getSprzedawcy()){
							if (sprzedawca.Nazwa.equals(textField_8.getText())){
								centrala.usunsprz(sprzedawca);
								infoBox("Usuniêto sprzedawce o nazwie  " + textField_8.getText());
								spr=true;
								comboBox_3.removeItem(textField_8.getText());
								break;
							}
				}
					if (spr==false)
						infoBox("Nie znaleziono takiego sprzedawcy w bazie ");
				}
			}
		});
		btnUsun.setBounds(270, 218, 97, 40);
		panel_1.add(btnUsun);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("Tu wpisz nr konta sprzedawcy");
		textField_9.setBounds(25, 203, 151, 25);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblPodajNumerKonta_3 = new JLabel("Podaj numer konta sprzedawcy");
		lblPodajNumerKonta_3.setBounds(25, 181, 184, 16);
		panel_1.add(lblPodajNumerKonta_3);
		
		JLabel lblWybierzRodzaj = new JLabel("Wybierz rodzaj");
		lblWybierzRodzaj.setBounds(25, 229, 134, 16);
		panel_1.add(lblWybierzRodzaj);
		btnUsuBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean spr=false; 
				if (textField_1.getText().isEmpty())
					infoBox("Puste pole nie mo¿na usun¹æ banku o takiej nazwie");
				else {
					{ for (Bank bank:centrala.getBanki())
							if (bank.getNazwa().equals(textField_1.getText())){
								centrala.usunbank(bank);
								spr=true;
								infoBox("Usuniêto bank o nazwie " + textField_1.getText());
								comboBox_1.removeItem(textField_1.getText());
								break;
								
							}
				if (spr==false)
					infoBox(" Nie znaleziono banku o nazwie "+ textField_1.getText());
				}
				}
			}
		});
		
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 31, 116, 22);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Tu wpsiz kwot\u0119 u\u017Cyj kropki zamiast przecinka");
		textField_3.setBounds(126, 66, 116, 22);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(135, 121, 57, 22);
		comboBox.addItem("PLN");
		comboBox.addItem("EUR");
		comboBox.addItem("USD");
		comboBox.addItem("GBP");
		comboBox.addItem("CZK");
		
		panel_2.add(comboBox);
		
		
		JButton btnUtwrz = new JButton("Utw\u00F3rz");
		btnUtwrz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean spr = false;	
				if (textField_3.getText().isEmpty() ||textField_2.getText().isEmpty() )
					infoBox("Puste pole nie mo¿na utorzyæ transakcji");
						try {
			            for (Bank bank:centrala.getBanki()) 
			                for (Klient klient:bank.getKlienci()) 
			                    for (Konto konto:klient.getKonta()) 
			                        for (Karta karta:konto.getKarty()) 
			                            if((karta.getNrKarty()).equals(textField_2.getText()))
			                            	spr =true;
			            if (spr = true){
			            	String nrkonta = null; 
			            	for (Sprzedawca sprzedawca: centrala.getSprzedawcy())
			            		if (sprzedawca.Nazwa.equals((String)comboBox.getSelectedItem())){
			            			nrkonta = sprzedawca.getNrKonta();
			            			break;
			            		}
			            	Transakcja trans = new Transakcja (new Date(),Double.parseDouble(textField_3.getText()),textField_2.getText(), (String)comboBox.getSelectedItem(), nrkonta );
			            	String a = centrala.getBank(textField_2.getText());
			            	boolean cz=false ;
			            	for (Bank bank:centrala.getBanki())
			            		if (bank.getNazwa().equals(a))
			            		{
			            			cz = bank.autoryzacja(trans);
			            			break;
			            		}
			            	trans.setCzyudana(cz);
			            	trans.setNazwaBank(centrala.getBank(trans.getNrKarty()));
			            	trans.setPesel(centrala.getKlient(trans.getNrKarty()));
			            	centrala.dodajdoarch(trans);
			            	if (cz==true)
			            		infoBox("Transakcja przebieg³a pomyœlnie");
			            	else infoBox("Transakcja przebieg³a niepomyœlnie");
			            	}
			            else if(spr==false ) 
			            	infoBox("Nie mo¿na znaleœæ karty o podanym numerze");
			            
			            }
			         catch (NumberFormatException e) {
			        	infoBox("Wprowadzona kwota nie jest liczb¹");
			        }
			}
			
						
				
			
		});
		btnUtwrz.setBounds(126, 234, 97, 25);
		panel_2.add(btnUtwrz);
		
		JLabel lblNumerKarty = new JLabel("Numer karty");
		lblNumerKarty.setBounds(135, 13, 107, 16);
		panel_2.add(lblNumerKarty);
		
		JLabel lblKwota = new JLabel("Kwota");
		lblKwota.setBounds(136, 51, 69, 16);
		panel_2.add(lblKwota);
		
	
		
		JLabel lblWaluta = new JLabel("Waluta");
		lblWaluta.setBounds(136, 92, 56, 16);
		panel_2.add(lblWaluta);
		
		
		JLabel lblSprzedawca = new JLabel("Sprzedawca");
		lblSprzedawca.setBounds(135, 156, 87, 16);
		panel_2.add(lblSprzedawca);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Archiwum", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblSzukanie = new JLabel("Szukanie transakcji");
		lblSzukanie.setBounds(161, 0, 147, 35);
		lblSzukanie.setFont(new Font( "Seref" ,Font.PLAIN ,17));
		panel_3.add(lblSzukanie);
		
		JLabel lblPoCzymChcesz = new JLabel("Po czym chcesz wyszuka\u0107? ");
		lblPoCzymChcesz.setBounds(47, 44, 200, 16);
		panel_3.add(lblPoCzymChcesz);
		JRadioButton rdbtnWaciciel = new JRadioButton("W\u0142a\u015Bciciel");
		buttonGroup.add(rdbtnWaciciel);
		rdbtnWaciciel.setBounds(57, 69, 127, 25);
		panel_3.add(rdbtnWaciciel);
		
		JRadioButton rdbtnNumerKarty = new JRadioButton("Numer karty");
		buttonGroup.add(rdbtnNumerKarty);
		rdbtnNumerKarty.setBounds(57, 99, 127, 25);
		panel_3.add(rdbtnNumerKarty);
		
		JRadioButton rdbtnBank = new JRadioButton("Bank");
		buttonGroup.add(rdbtnBank);
		rdbtnBank.setBounds(57, 129, 127, 25);
		panel_3.add(rdbtnBank);
		
		JRadioButton rdbtnKwota = new JRadioButton("Kwota");
		buttonGroup.add(rdbtnKwota);
		rdbtnKwota.setBounds(57, 159, 127, 25);
		panel_3.add(rdbtnKwota);
		
		JRadioButton rdbtnWaluta = new JRadioButton("Waluta");
		buttonGroup.add(rdbtnWaluta);
		rdbtnWaluta.setBounds(57, 189, 127, 25);
		panel_3.add(rdbtnWaluta);

		
		JButton btnOtwrzWyszukiwanie = new JButton("Otw\u00F3rz wyszukiwanie");
		btnOtwrzWyszukiwanie.addActionListener(new ActionListener() {
			public ArrayList<Transakcja> listatrans;
			Archiwum arch = centrala.getarchiwum();
			public final String[] waluty = { "PLN", "EUR", "USD", "GBP" ,"CZK"};
			public void actionPerformed(ActionEvent e) {
				listatrans = null;
				
				if (rdbtnWaciciel.isSelected()==false && rdbtnWaluta.isSelected()==false && rdbtnKwota.isSelected()==false && rdbtnBank.isSelected()==false && rdbtnNumerKarty.isSelected()==false)
					infoBox("Brak zaznaczeñ");
				if	(rdbtnBank.isSelected()) 
				listatrans = arch.szukajBanku(getBox("Podaj nazwê banku").toString());
				if (rdbtnNumerKarty.isSelected())
					listatrans = arch.szukajNrKarty(String.valueOf(getBox("Podaj numer karty")));
				if (rdbtnWaciciel.isSelected())
					listatrans = arch.szukajKlienta(getBox("Podaj pesel w³aœciciela"));
				if (rdbtnWaluta.isSelected())
						listatrans = arch.szukajWaluta(((String) JOptionPane.showInputDialog(frame, "Wybierz walutê","Pytanko?",JOptionPane.QUESTION_MESSAGE,null,waluty,waluty[0])));
				if (rdbtnKwota.isSelected()){
					try{
						listatrans = arch.szukajKwota(Double.parseDouble(getBox("Podaj kwotê(z kropk¹ zamiast przecinka)")));
					}
					catch (NumberFormatException j) {
						infoBox("Wprowadzona kwota nie jest liczb¹");
					}
				}
				if (!listatrans.isEmpty())
					new Wypisacz(listatrans).setVisible(true);
				if(listatrans.isEmpty())
					infoBox("Nie znaleziono takich transakcji");
			}
		});
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frame, 
		            "Czy chcesz zapisaæ?", "Mo¿e zapiszemy?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		           try {
					centrala.zapis();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					infoBox("B³¹d podczas zapisu ");
				}
		           System.exit(0);  
		        }
		        else {
		        	System.exit(0);
		        }
		    }
		});
		btnOtwrzWyszukiwanie.setBounds(47, 223, 200, 25);
		panel_3.add(btnOtwrzWyszukiwanie);
		
		
	}
}
