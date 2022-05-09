package appv;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Consulter_les_conges {

	JFrame frmConsulterLesConges;
	Connection conn;
	PreparedStatement Pst;
	ResultSet rs;
	private JTable table;
	private JTextField txtPprSvp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulter_les_conges window = new Consulter_les_conges();
					window.frmConsulterLesConges.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Consulter_les_conges() {
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
			Pst=conn.prepareStatement("select * from conges ");
			rs= Pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void table_load1(String ppr) {
		try {
			Pst=conn.prepareStatement("select * from conges where PPR=?");
			Pst.setString(1, ppr);
			rs= Pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsulterLesConges = new JFrame();
		frmConsulterLesConges.setIconImage(Toolkit.getDefaultToolkit().getImage(Consulter_les_conges.class.getResource("/images/logoGP.png")));
		frmConsulterLesConges.setTitle("Consulter les conges");
		frmConsulterLesConges.setBounds(0, 0, 1360, 749);
		frmConsulterLesConges.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsulterLesConges.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 187, 1284, 497);
		frmConsulterLesConges.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsulterLesConges.setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(26, 64, 141, 46);
		frmConsulterLesConges.getContentPane().add(btnNewButton);
		
		txtPprSvp = new JTextField();
		txtPprSvp.setToolTipText("PPR svp");
		txtPprSvp.setBounds(497, 64, 246, 46);
		frmConsulterLesConges.getContentPane().add(txtPprSvp);
		txtPprSvp.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mot=txtPprSvp.getText();
				table_load1(mot);
			}
		});
		btnRechercher.setForeground(Color.WHITE);
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRechercher.setBackground(new Color(65, 105, 225));
		btnRechercher.setBounds(836, 64, 141, 46);
		frmConsulterLesConges.getContentPane().add(btnRechercher);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load();
				txtPprSvp.setText("");
			}
		});
		btnActualiser.setForeground(Color.WHITE);
		btnActualiser.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnActualiser.setBackground(new Color(65, 105, 225));
		btnActualiser.setBounds(1032, 64, 141, 46);
		frmConsulterLesConges.getContentPane().add(btnActualiser);
	}
}
