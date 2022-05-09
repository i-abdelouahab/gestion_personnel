package appv;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Consulter_Licenceexp {

	JFrame frmConsulterLicencesExceptionnelles;
	
	Connection conn;
	PreparedStatement Pst;
	ResultSet rs;
	private JTable table;
	private JTextField textField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulter_Licenceexp window = new Consulter_Licenceexp();
					window.frmConsulterLicencesExceptionnelles.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Consulter_Licenceexp() {
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
		catch(SQLException ex) {
		}
		catch(Exception ex) {
			System.out.println(" conexion n'est pas etablie");
		}
	}
	public void table_load() {
		try {
			Pst=conn.prepareStatement("select * from licence_ex");
			rs= Pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void table_load1(String ppr) {
		try {
			Pst=conn.prepareStatement("select * from licence_ex where PPR=?");
			Pst.setString(1, ppr);
			rs= Pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		frmConsulterLicencesExceptionnelles = new JFrame();
		frmConsulterLicencesExceptionnelles.setIconImage(Toolkit.getDefaultToolkit().getImage(Consulter_Licenceexp.class.getResource("/images/logoGP.png")));
		frmConsulterLicencesExceptionnelles.setTitle("Consulter Licences Exceptionnelles");
		frmConsulterLicencesExceptionnelles.setBounds(0, 0, 1360, 749);
		frmConsulterLicencesExceptionnelles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsulterLicencesExceptionnelles.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsulterLicencesExceptionnelles.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(31, 132, 125, 48);
		frmConsulterLicencesExceptionnelles.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 243, 1279, 443);
		frmConsulterLicencesExceptionnelles.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setToolTipText("PPR svp");
		textField.setBounds(512, 134, 220, 48);
		frmConsulterLicencesExceptionnelles.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Rechercher");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mot = textField.getText();
				table_load1(mot);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBounds(817, 132, 125, 48);
		frmConsulterLicencesExceptionnelles.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Actualiser");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_load();
				textField.setText("");
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1_1.setBounds(1019, 132, 125, 48);
		frmConsulterLicencesExceptionnelles.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Consulter_Licenceexp.class.getResource("/images/backgCD.png")));
		lblNewLabel.setBounds(0, 0, 1342, 699);
		frmConsulterLicencesExceptionnelles.getContentPane().add(lblNewLabel);
		
		
	}

}
