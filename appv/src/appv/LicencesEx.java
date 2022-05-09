package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LicencesEx {

	JFrame frmLicencesExceptionnelles;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	Connection conn;
	PreparedStatement Pst;
	ResultSet rs;
	private JButton btnNewButton_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LicencesEx window = new LicencesEx();
					window.frmLicencesExceptionnelles.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LicencesEx() {
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
		catch(SQLException ex) {
		}
		catch(Exception ex) {
			System.out.println(" conexion n'est pas etablie");
		}
	}
	
	private void initialize() {
		frmLicencesExceptionnelles = new JFrame();
		frmLicencesExceptionnelles.setIconImage(Toolkit.getDefaultToolkit().getImage(LicencesEx.class.getResource("/images/logoGP.png")));
		frmLicencesExceptionnelles.setTitle("Licences Exceptionnelles");
		frmLicencesExceptionnelles.setBounds(0, 0, 1360, 749);
		frmLicencesExceptionnelles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLicencesExceptionnelles.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(284, 321, 223, 36);
		frmLicencesExceptionnelles.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(284, 388, 223, 36);
		frmLicencesExceptionnelles.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(284, 462, 223, 36);
		frmLicencesExceptionnelles.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(994, 321, 223, 36);
		frmLicencesExceptionnelles.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(916, 388, 249, 38);
		frmLicencesExceptionnelles.getContentPane().add(textField_4);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(76, 567, 493, 116);
		frmLicencesExceptionnelles.getContentPane().add(textPane);
		
		btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1,t2,t3,t5,t6;
				int t4,a = 0,b;
				t1=textField.getText();
				t2=textField_1.getText();
				t3=textField_2.getText();
				t4=Integer.parseInt(textField_3.getText());
				
				t5=textField_4.getText();
				t6=textPane.getText();
				final String Date_REGEX = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
				if( t2.matches(Date_REGEX) && t5.matches(Date_REGEX)) {
					try {
						Pst=conn.prepareStatement("insert into licence_ex (PPR,date_debut,duree,solde_diminuer,date_fin,raison) values(?,?,?,?,?,?)");
						Pst.setString(1,t1);
						Pst.setString(2,t2);
						Pst.setString(3,t3);
						Pst.setInt(4,t4);
						Pst.setString(5,t5);
						Pst.setString(6,t6);
						Pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"record added!!!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "PPR non valide");
					}
					catch (Exception e2) {
						// TODO Auto-generated catch block
						//e2.printStackTrace();
						//System.out.println("Siaise inmpossible");
					}
					try {
						Pst=conn.prepareStatement("select Solde_licence_exceptionnel  from personnel where PPR = ?");
						Pst.setString(1,t1);
						ResultSet rs = Pst.executeQuery();
						if(rs.next()==true) {
							a= rs.getInt(1);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                b=a-t4;
					
					if(b>0) {
						try {
							Pst=conn.prepareStatement("update personnel set Solde_licence_exceptionnel=? where PPR=?");
							Pst.setInt(1,b);
							Pst.setString(2,t1);
							Pst.executeUpdate();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
				}
					else {
						try {
							Pst=conn.prepareStatement("update personnel set Solde_licence_exceptionnel=? where PPR=?");
							Pst.setInt(1,0);
							Pst.setString(2,t1);
							Pst.executeUpdate();
							//JOptionPane.showMessageDialog(null,"record added!!!");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
				}
				}
				else {
					JOptionPane.showMessageDialog(null,"Date error!!!");
				}
				
				
			}
		});
		
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(1139, 600, 127, 57);
		frmLicencesExceptionnelles.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Consulter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulter_Licenceexp consulterlicences = new Consulter_Licenceexp();
				consulterlicences.frmConsulterLicencesExceptionnelles.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBounds(946, 600, 127, 57);
		frmLicencesExceptionnelles.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLicencesExceptionnelles.setVisible(false);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(65, 105, 225));
		btnNewButton_2.setBounds(1177, 11, 127, 57);
		frmLicencesExceptionnelles.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LicencesEx.class.getResource("/images/LEX.png")));
		lblNewLabel.setBounds(0, 0, 1342, 699);
		frmLicencesExceptionnelles.getContentPane().add(lblNewLabel);
		
		
	}
}
