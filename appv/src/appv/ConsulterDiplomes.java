package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class ConsulterDiplomes {

	JFrame frmConsulterLesDiplomes;
	private JTable table;
	
	Connection conn;
	PreparedStatement Pst;
	ResultSet rs;
	private JTextField txtPprSvp;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsulterDiplomes window = new ConsulterDiplomes();
					window.frmConsulterLesDiplomes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConsulterDiplomes() {
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
			Pst=conn.prepareStatement("select * from diplomes");
			rs= Pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void table_load1(String ppr) {
		try {
			Pst=conn.prepareStatement("select * from diplomes where PPR=?");
			Pst.setString(1, ppr);
			rs= Pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		frmConsulterLesDiplomes = new JFrame();
		frmConsulterLesDiplomes.setIconImage(Toolkit.getDefaultToolkit().getImage(ConsulterDiplomes.class.getResource("/images/logoGP.png")));
		frmConsulterLesDiplomes.setTitle("Consulter les diplomes");
		frmConsulterLesDiplomes.setBounds(0, 0, 1360, 749);
		frmConsulterLesDiplomes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsulterLesDiplomes.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsulterLesDiplomes.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(26, 73, 141, 46);
		frmConsulterLesDiplomes.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 197, 1284, 487);
		frmConsulterLesDiplomes.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtPprSvp = new JTextField();
		txtPprSvp.setToolTipText("PPR svp");
		txtPprSvp.setBounds(452, 75, 235, 46);
		frmConsulterLesDiplomes.getContentPane().add(txtPprSvp);
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
		btnRechercher.setBounds(816, 73, 141, 46);
		frmConsulterLesDiplomes.getContentPane().add(btnRechercher);
		
		JButton btnNewButton_1_1 = new JButton("Actualiser");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load();
				txtPprSvp.setText("");
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1_1.setBounds(1037, 73, 141, 46);
		frmConsulterLesDiplomes.getContentPane().add(btnNewButton_1_1);
		
		
		
	}
}
