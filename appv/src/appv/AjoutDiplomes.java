package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AjoutDiplomes {

	JFrame frmAjouterLesDiplomes;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton_1;
	
	Connection conn;
	PreparedStatement Pst;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutDiplomes window = new AjoutDiplomes();
					window.frmAjouterLesDiplomes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AjoutDiplomes() {
		initialize();
		connect();
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
	
	private void initialize() {
		frmAjouterLesDiplomes = new JFrame();
		frmAjouterLesDiplomes.setIconImage(Toolkit.getDefaultToolkit().getImage(AjoutDiplomes.class.getResource("/images/logoGP.png")));
		frmAjouterLesDiplomes.setTitle("Ajouter les Diplomes");
		frmAjouterLesDiplomes.setBounds(0, 0, 1360, 749);
		frmAjouterLesDiplomes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAjouterLesDiplomes.getContentPane().setLayout(null);
		
		
		
		textField = new JTextField();
		textField.setBounds(980, 344, 118, 41);
		frmAjouterLesDiplomes.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(716, 344, 261, 41);
		frmAjouterLesDiplomes.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(446, 344, 266, 41);
		frmAjouterLesDiplomes.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(212, 344, 232, 41);
		frmAjouterLesDiplomes.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(AjoutDiplomes.class.getResource("/images/Webp.net-resizeimage.png")));
		btnNewButton.setBounds(958, 408, 46, 41);
		frmAjouterLesDiplomes.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Ajouter le dipolome");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mot,mot1,mot2,mot3;
				mot=textField.getText();
				mot1=textField_1.getText();
				mot2=textField_2.getText();
				mot3=textField_3.getText();
				
				try {
					Pst=conn.prepareStatement("insert into diplomes (PPR,diplome,filiere,mention) values(?,?,?,?)");
					Pst.setString(1,mot);
					Pst.setString(2,mot1);
					Pst.setString(3,mot2);
					Pst.setString(4,mot3);
					Pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"record added!!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					//System.out.println("Siaise inmpossible");
					JOptionPane.showMessageDialog(null, "PPR non valide");
				}
				catch (Exception e2) {
					// TODO Auto-generated catch block
					//e2.printStackTrace();
					//System.out.println("Siaise inmpossible");
				}
			}
		});
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBounds(1012, 568, 220, 57);
		frmAjouterLesDiplomes.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Consulter les dipolomes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsulterDiplomes fenetre = new ConsulterDiplomes();
				fenetre.frmConsulterLesDiplomes.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(65, 105, 225));
		btnNewButton_2.setBounds(544, 568, 220, 57);
		frmAjouterLesDiplomes.getContentPane().add(btnNewButton_2);
		
	
		
		btnNewButton_3 = new JButton("retour");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAjouterLesDiplomes.setVisible(false);
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBackground(new Color(65, 105, 225));
		btnNewButton_3.setBounds(44, 568, 220, 57);
		frmAjouterLesDiplomes.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(AjoutDiplomes.class.getResource("/images/backajoutdiplomes.png")));
		lblNewLabel.setBounds(0, 0, 1342, 699);
		frmAjouterLesDiplomes.getContentPane().add(lblNewLabel);
		
	}
}
