package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

//import com.itextpdf.text.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class rik {

	JFrame frame;
	
	
	private JTextField textField_5;
	
	private JButton btnNewButton;
	private JPasswordField passwordField;
	
	Connection con;
	PreparedStatement Pst;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rik window = new rik();
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
	public rik() {
		initialize();
		connect();
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(rik.class.getResource("/images/logoGP.png")));
		frame.setTitle("se connecter");
		frame.setBounds(0, 0, 1360,749);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textField_5 = new JTextField();
		textField_5.setBounds(595, 296, 144, 33);
		textField_5.setBackground(new Color(255, 255,204));
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		
		btnNewButton = new JButton("Se Connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = null,mot_de_passe = null;
				try {
					Pst=con.prepareStatement("select nom,mot_de_passe from admin where id= ?");
					int id = 1;
					
					Pst.setInt(1, id);
					ResultSet rs = Pst.executeQuery();
					if(rs.next()==true) {
						nom=rs.getString(1);
						mot_de_passe=rs.getString(2);
					}
					}
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(nom.equals(textField_5.getText()) && mot_de_passe.equals(passwordField.getText()) ) {
					tableau_de_bord a = new tableau_de_bord();
					a.frmTableauDeBord.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null,"nom ou mot_de passe incorrect");
					System.out.println(passwordField.getText());
					System.out.println(textField_5.getText());
					System.out.println(nom);
					System.out.println(mot_de_passe);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setBounds(595, 514, 144, 37);
		frame.getContentPane().add(btnNewButton);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(595, 369, 144, 33);
		passwordField.setBackground(new Color(255, 255,204));
		frame.getContentPane().add(passwordField);
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(rik.class.getResource("/images/last_image.png")));
		lblNewLabel.setBounds(2, 0, 1362, 710);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
	}
}
