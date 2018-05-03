import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JLayeredPane;

public class Wypisacz extends JDialog {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the dialog.
	 */
	public Wypisacz(ArrayList<Transakcja> trans) {
		setTitle("Znalezione transakcje");
		setBounds(100, 100, 676, 563);
		setResizable(false);
		getContentPane().setLayout(null);
		DefaultTableModel transkacjitabela = new DefaultTableModel(0,7){
			public boolean isCellEditable (int row, int column)
			{
				return false;
			}
		};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 658, 515);
		getContentPane().add(scrollPane);
		String  columnname[]=new  String[]{"Data","Kwota","Waluta","Czyudana","Pesel","Nazwa banku","Konto odbiorcy"};
		transkacjitabela.setColumnIdentifiers(columnname);
		for (int i=0; i< trans.size();i++){
			transkacjitabela.addRow(new Object[]{trans.get(i).getData().toString(),String.valueOf(trans.get(i).getKwota()),trans.get(i).getWaluta(),trans.get(i).getCzyudana().toString(),trans.get(i).getPesel(),
				trans.get(i).getNazwaBank(),trans.get(i).getKontoodbiorcy()});
		}
		JTable table = new JTable();
		
		
		scrollPane.setViewportView(table);
		{
			{
				table.setModel(transkacjitabela);
				table.setPreferredScrollableViewportSize(new Dimension(658,515));
				table.setFillsViewportHeight(true);
				
			}
			
		}
	}
}
