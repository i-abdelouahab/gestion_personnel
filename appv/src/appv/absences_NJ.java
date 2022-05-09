package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class absences_NJ {

	JFrame frmAbcencesNonJustifiees;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	Connection conn;
	PreparedStatement Pst;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					absences_NJ window = new absences_NJ();
					window.frmAbcencesNonJustifiees.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public absences_NJ() {
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
		frmAbcencesNonJustifiees = new JFrame();
		frmAbcencesNonJustifiees.setIconImage(Toolkit.getDefaultToolkit().getImage(absences_NJ.class.getResource("/images/logoGP.png")));
		frmAbcencesNonJustifiees.setTitle("Absences non justifiees");
		frmAbcencesNonJustifiees.setBounds(0, 0, 1360, 749);
		frmAbcencesNonJustifiees.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAbcencesNonJustifiees.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(917, 361, 235, 36);
		frmAbcencesNonJustifiees.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(917, 429, 235, 36);
		frmAbcencesNonJustifiees.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(285, 361, 235, 36);
		frmAbcencesNonJustifiees.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(285, 429, 235, 36);
		frmAbcencesNonJustifiees.getContentPane().add(textField_3);
		
		btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ajouter Abcences non Just
				String mot,mot1,mot3;
				int mot2;
				mot2=Integer.parseInt(textField.getText());
				mot3=textField_1.getText();
				mot=textField_2.getText();
				mot1=textField_3.getText();
				final String Date_REGEX = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
				if( mot1.matches(Date_REGEX) && mot3.matches(Date_REGEX)) {
					try {
						Pst=conn.prepareStatement("insert into absences_nj (PPR,date_debut,duree,date_fin) values(?,?,?,?)");
						Pst.setString(1,mot);
						Pst.setString(2,mot1);
						Pst.setInt(3,mot2);
						Pst.setString(4,mot3);
						Pst.executeUpdate();
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						JOptionPane.showMessageDialog(null,"record added!!!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "PPR non valide");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Date error!!!");
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(1012, 588, 141, 46);
		btnNewButton.setFocusable(false);
		frmAbcencesNonJustifiees.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Consulter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulter_absences_Nj fenetre = new Consulter_absences_Nj();
				fenetre.frmConsulterAbsencesNon.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBounds(542, 588, 141, 46);
		btnNewButton_1.setFocusable(false);
		frmAbcencesNonJustifiees.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAbcencesNonJustifiees.setVisible(false);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(65, 105, 225));
		btnNewButton_2.setBounds(73, 592, 141, 46);
		btnNewButton_2.setFocusable(false);
		frmAbcencesNonJustifiees.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(absences_NJ.class.getResource("/images/absence_NJ.png")));
		lblNewLabel.setBounds(0, 0, 1342, 699);
		frmAbcencesNonJustifiees.getContentPane().add(lblNewLabel);
	}

}
