package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Consulter_absences_Nj {

	JFrame frmConsulterAbsencesNon;
	private JTable table;

	Connection conn;
	PreparedStatement Pst;
	ResultSet rs;
	private JTextField textField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulter_absences_Nj window = new Consulter_absences_Nj();
					window.frmConsulterAbsencesNon.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Consulter_absences_Nj() {
		initialize();
		connect();
		table_load();
	}
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionnaire_du_personnel","root","");
		}
		catch(ClassNotFoundException ex) {
			
		}
		catch(SQLException ex1) {
		}
		catch(Exception ex2) {
			System.out.println(" conexion n'est pas etablie");
		}
	}
	
	public void table_load() {
		try {
			Pst=conn.prepareStatement("select * from absences_nj");
			rs= Pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void table_load1(String ppr) {
		try {
			Pst=conn.prepareStatement("select * from absences_nj where PPR=?");
			Pst.setString(1, ppr);
			rs= Pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		frmConsulterAbsencesNon = new JFrame();
		frmConsulterAbsencesNon.setIconImage(Toolkit.getDefaultToolkit().getImage(Consulter_absences_Nj.class.getResource("/images/logoGP.png")));
		frmConsulterAbsencesNon.setTitle("Consulter Absences non justifiees");
		frmConsulterAbsencesNon.setBounds(0, 0, 1360, 749);
		frmConsulterAbsencesNon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsulterAbsencesNon.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsulterAbsencesNon.setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(60, 58, 141, 46);
		frmConsulterAbsencesNon.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 174, 1240, 488);
		frmConsulterAbsencesNon.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setToolTipText("PPR svp");
		textField.setBounds(544, 60, 249, 46);
		frmConsulterAbsencesNon.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mot=textField.getText();
				table_load1(mot);
			}
		});
		btnRechercher.setForeground(Color.WHITE);
		btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRechercher.setBackground(new Color(65, 105, 225));
		btnRechercher.setBounds(915, 58, 141, 46);
		frmConsulterAbsencesNon.getContentPane().add(btnRechercher);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load();
				textField.setText("");
			}
		});
		btnActualiser.setForeground(Color.WHITE);
		btnActualiser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActualiser.setBackground(new Color(65, 105, 225));
		btnActualiser.setBounds(1099, 58, 141, 46);
		frmConsulterAbsencesNon.getContentPane().add(btnActualiser);
	}

}
