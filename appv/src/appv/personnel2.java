package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class personnel2 {

	JFrame frmConsulterRegistres;
	private JTable table;
	Connection con;
	PreparedStatement Pst;
	ResultSet rs;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JTextField txtPprSvp;
	private JButton btnRechercher;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personnel2 window = new personnel2();
					window.frmConsulterRegistres.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public personnel2() {
		initialize();
		connect();
		table_load();
	}
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/gestionnaire_du_personnel","root","");
		}
		catch(ClassNotFoundException ex) {
			
		}
		catch(SQLException ex) {
			
		}
	}
	public void table_load() {
		try {
			Pst=con.prepareStatement("select * from personnel");
			rs= Pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void table_load1(String ppr) {
		try {
			Pst=con.prepareStatement("select * from personnel where PPR=?");
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
		frmConsulterRegistres = new JFrame();
		frmConsulterRegistres.setIconImage(Toolkit.getDefaultToolkit().getImage(personnel2.class.getResource("/images/logoGP.png")));
		frmConsulterRegistres.setTitle("Consulter registres");
		frmConsulterRegistres.setBounds(0, 0, 1400, 1000);
		frmConsulterRegistres.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsulterRegistres.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 143, 1314, 545);
		frmConsulterRegistres.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsulterRegistres.setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(26, 54, 141, 46);
		frmConsulterRegistres.getContentPane().add(btnNewButton);
		
		txtPprSvp = new JTextField();
		txtPprSvp.setToolTipText("PPR svp");
		txtPprSvp.setBounds(374, 54, 210, 46);
		frmConsulterRegistres.getContentPane().add(txtPprSvp);
		txtPprSvp.setColumns(10);
		
		btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mot;
				mot=txtPprSvp.getText();
				table_load1(mot);
			}
		});
		btnRechercher.setForeground(Color.WHITE);
		btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRechercher.setBackground(new Color(65, 105, 225));
		btnRechercher.setBounds(666, 54, 141, 46);
		frmConsulterRegistres.getContentPane().add(btnRechercher);
		
		btnNewButton_2 = new JButton("Actualiser");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBackground(new Color(65, 105, 225));
		btnNewButton_2.setBounds(889, 54, 141, 46);
		frmConsulterRegistres.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3_1_3 = new JButton("Retour");
		btnNewButton_3_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsulterRegistres.setVisible(false);
			}
		});
		
	}
}
