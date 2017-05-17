import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Panel {
	public JFrame frame;
	public JButton allPersons,allAccounts,addAccount,deleteAccount, saving,spending,ok1,ok2,ok3,ok4,ok5,ok6,addSum,removeSum;
	public JTextField ptId,ptNume,ptMail,ptVarsta,ptSum,ptDob;
	public JPanel butoane,mainPanel;
	public JTable tabel;
	public Bank banca;
	public Serializare ser;
	public JScrollPane scroll;
	DefaultTableModel model;
	
	public Panel(){
		banca = new Bank();
		ser = new Serializare();
		frame = new JFrame();
		frame.setSize(1000, 800);
		frame.setVisible(true);
		frame.setTitle("Banca");
		frame.setLayout(new GridLayout(4,4));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		butoane = new JPanel();
		mainPanel = new JPanel();
		allAccounts = new JButton("Toate conturile");
		addAccount = new JButton("Adaugare cont");
		deleteAccount = new JButton("Stergere cont");
		saving = new JButton("Savings Account");
		spending = new JButton("Spending Account");
		addSum = new JButton("Adaugare suma");
		removeSum = new JButton("Retragere suma");
		ok1 = new JButton("OK");
		ok2 = new JButton("OK");
		ok3 = new JButton("OK");
		ok4 = new JButton("OK");
		ok5 = new JButton("OK");
		ok6 = new JButton("OK");
		ptId = new JTextField(3);
		ptNume = new JTextField(10);
		ptMail = new JTextField(10);
		ptVarsta = new JTextField(3);
		ptSum = new JTextField(10);
		ptDob = new JTextField(4);
		butoane.add(allAccounts);
		butoane.add(addAccount);
		butoane.add(deleteAccount);
		butoane.add(addSum);
		butoane.add(removeSum);
		model = new DefaultTableModel(null, new Object[] {"id", "Nume","Email","Varsta","Tip de Cont","Suma"});
		tabel = new JTable(model);
		scroll = new JScrollPane();
	
		scroll.setViewportView(tabel);
		mainPanel.add(scroll);
		frame.add(butoane);
		frame.add(mainPanel);
		inceput();
		
	}
	
	public void inceput(){
		
		allAccounts.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e7){
				mainPanel.removeAll();
				banca = ser.deserializare("Date.ser");
				model.setRowCount(0);
				for (Entry<Integer, Account> i : banca.getBazaDate().entrySet()){
					int id = i.getKey();
					Account cont = i.getValue();
					model.addRow(new Object[] {id,cont.getPersoana().getNume(),cont.getPersoana().getMail(),cont.getPersoana().getVarsta(),cont.getTip(),cont.getSum() });
				}
				
				scroll.revalidate();
				mainPanel.add(scroll);
				mainPanel.revalidate();
				
			}
			
		});
		
		addAccount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e9){
				mainPanel.removeAll();
				mainPanel.repaint();
				ptId.setText("");
				ptNume.setText("");
				ptMail.setText("");
				ptVarsta.setText("");
				ptSum.setText("");
				ptDob.setText("");
				banca = ser.deserializare("Date.ser");
				mainPanel.add(new JLabel("id"));
				mainPanel.add(ptId);
				mainPanel.add(new JLabel("Nume"));
				mainPanel.add(ptNume);
				mainPanel.add(new JLabel("Mail"));
				mainPanel.add(ptMail);
				mainPanel.add(new JLabel("Varsta"));
				mainPanel.add(ptVarsta);
				mainPanel.add(saving);
				mainPanel.add(spending);
				mainPanel.revalidate();
				saving.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent t1){
						Person p = new Person(ptNume.getText(),ptMail.getText(),Integer.parseInt(ptVarsta.getText()));
						mainPanel.removeAll();
						mainPanel.add(new JLabel("Suma"));
						mainPanel.add(ptSum);
						mainPanel.add(new JLabel("Dobanda"));
						mainPanel.add(ptDob);
						mainPanel.add(ok1);
						mainPanel.revalidate();
						mainPanel.repaint();
						ok1.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent y2){
							
								Account c = new SavingAccount(Integer.parseInt(ptId.getText()),p,Integer.parseInt(ptSum.getText()),Integer.parseInt(ptDob.getText()));
								banca.addAccount(c);
								ser.serializare(banca, "Date.ser");
								mainPanel.removeAll();
								mainPanel.revalidate();
								mainPanel.repaint();
								
							}
						});
					}
				});
				spending.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent t3){
						Person p = new Person(ptNume.getText(),ptMail.getText(),Integer.parseInt(ptVarsta.getText()));
						mainPanel.removeAll();
						mainPanel.add(new JLabel("Suma"));
						mainPanel.add(ptSum);
						mainPanel.add(ok2);
						mainPanel.revalidate();
						mainPanel.repaint();
						ok2.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent y){
								Account c = new SpendingAccount(Integer.parseInt(ptId.getText()),p,Integer.parseInt(ptSum.getText()));
								banca.addAccount(c);
								ser.serializare(banca, "Date.ser");
								mainPanel.removeAll();
								mainPanel.revalidate();
								mainPanel.repaint();
								
							}
						});
					}
				});
				
			}
		});
		
		deleteAccount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e4){
				banca = ser.deserializare("Date.ser");
				mainPanel.removeAll();
				mainPanel.revalidate();
				ptId.setText("");
				mainPanel.add(new JLabel("Numarul contului"));
				mainPanel.add(ptId);
				mainPanel.add(ok3);
				mainPanel.repaint();
				ok3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent v){
						mainPanel.removeAll();
						mainPanel.revalidate();
						Account c = banca.getAccount(Integer.parseInt(ptId.getText()));
						
						banca.deleteAccount(c);
						ser.serializare(banca, "Date.ser");
					}
				});
				}
		});
		
		addSum.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e5){
				banca = ser.deserializare("Date.ser");
				mainPanel.removeAll();
				mainPanel.revalidate();
				mainPanel.repaint();
				ptId.setText("");
				ptSum.setText("");
				mainPanel.add(new JLabel("Numarul contului"));
				mainPanel.add(ptId);
				mainPanel.add(new JLabel("Suma"));
				mainPanel.add(ptSum);
				mainPanel.add(ok4);
				
				ok4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent t5){
						
						Account cont = banca.getAccount(Integer.parseInt(ptId.getText()));
						
						cont.addSum(Integer.parseInt(ptSum.getText()));
						ser.serializare(banca, "Date.ser");
						mainPanel.removeAll();
						mainPanel.revalidate();
						mainPanel.repaint();
					}
				});
				
			}
		});
		
		
		removeSum.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e6){
				banca = ser.deserializare("Date.ser");
				ptId.setText("");
				ptSum.setText("");
				mainPanel.removeAll();
				mainPanel.revalidate();
				mainPanel.repaint();
				mainPanel.add(new JLabel("Numarul contului"));
				mainPanel.add(ptId);
				mainPanel.add(new JLabel("Suma"));
				ptSum.setText("");
				mainPanel.add(ptSum);
				mainPanel.add(ok5);
				ok5.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent t6){
						mainPanel.removeAll();
						mainPanel.revalidate();
						mainPanel.repaint();
						Account cont = banca.getAccount(Integer.parseInt(ptId.getText()));
						cont.removeSum(Integer.parseInt(ptSum.getText()));
						ser.serializare(banca, "Date.ser");
					}
				});
			}
		});
		
	}
	
}
