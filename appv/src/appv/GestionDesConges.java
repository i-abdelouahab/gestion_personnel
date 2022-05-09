package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class GestionDesConges {

	JFrame frmGestionDesConges;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	Connection conn;
	PreparedStatement Pst;
	ResultSet rs;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionDesConges window = new GestionDesConges();
					window.frmGestionDesConges.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionDesConges() {
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesConges = new JFrame();
		frmGestionDesConges.setIconImage(Toolkit.getDefaultToolkit().getImage(GestionDesConges.class.getResource("/images/logoGP.png")));
		frmGestionDesConges.setTitle("Gestion des conges");
		frmGestionDesConges.setBounds(0, 0, 1360, 749);
		frmGestionDesConges.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesConges.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(949, 298, 244, 36);
		frmGestionDesConges.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(949, 366, 244, 36);
		frmGestionDesConges.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(1027, 440, 166, 36);
		frmGestionDesConges.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(316, 298, 244, 36);
		frmGestionDesConges.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(316, 366, 244, 36);
		frmGestionDesConges.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(316, 440, 244, 36);
		frmGestionDesConges.getContentPane().add(textField_5);
		
		btnNewButton = new JButton("Demander");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String PPR,date_demande,date_debut,date_fin,duree,nom = null;
                PPR=textField_3.getText();
                date_demande=textField.getText();
                date_debut=textField_4.getText();
                date_fin=textField_1.getText();
                duree=textField_5.getText();
				
				try {
					Pst=conn.prepareStatement("select Nom_Complet_Fr	from personnel  where PPR = ?");
					Pst.setString(1, PPR);
					ResultSet rs = Pst.executeQuery();
					if(rs.next()==true) {
						nom=rs.getString(1);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				
				
				
				
				Document doc = new Document();
				try {
					PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\hp\\Desktop\\"+nom+".pdf"));
					Image img = Image.getInstance("C:\\Users\\hp\\Desktop\\yass.png");
					
					
					img.scaleAbsoluteWidth(540);
					img.scaleAbsoluteHeight(110);
					img.setAlignment(Image.ALIGN_CENTER);
					
					doc.open();
					
					doc.add(img);
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					//Font f=new Font(FontFamily.TIMES_ROMAN,20.0f,Font.BOLD,BaseColor.BLACK);
					//Paragraph p1=new Paragraph("                                 nom        :    el ghziri            ",f);
					//Paragraph p2=new Paragraph("                                 prenom     :    yassin            ",f);
				
					
					//doc.add(p1);
					//doc.add(p2);
					Paragraph p1= new Paragraph(" Demande du conge ", FontFactory.getFont(FontFactory.TIMES_ROMAN,20, Font.BOLD, BaseColor.RED));
					p1.setAlignment(Element.ALIGN_CENTER);
					
					Paragraph p2= new Paragraph("                   "+"PPR                             :"+"       "+PPR, FontFactory.getFont(FontFactory.TIMES_ROMAN,16, Font.BOLD, BaseColor.BLACK));
					p2.setAlignment(Element.ALIGN_LEFT);
					Paragraph p3= new Paragraph("                   "+"nom et prenom                             :"+"       "+nom, FontFactory.getFont(FontFactory.TIMES_ROMAN,16, Font.BOLD, BaseColor.BLACK));
					p3.setAlignment(Element.ALIGN_LEFT);
					Paragraph p4= new Paragraph("                   "+"date de demande                 :"+"       "+date_demande, FontFactory.getFont(FontFactory.TIMES_ROMAN,16, Font.BOLD, BaseColor.BLACK));
					p4.setAlignment(Element.ALIGN_LEFT);
					Paragraph p5= new Paragraph("                   "+"date de debut                   :"+"       "+date_debut, FontFactory.getFont(FontFactory.TIMES_ROMAN,16, Font.BOLD, BaseColor.BLACK));
					p5.setAlignment(Element.ALIGN_LEFT);
					Paragraph p6= new Paragraph("                   "+"date de fin                     :"+"       "+date_fin, FontFactory.getFont(FontFactory.TIMES_ROMAN,16, Font.BOLD, BaseColor.BLACK));
					p6.setAlignment(Element.ALIGN_LEFT);
					
					
					doc.add(p1);
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(p2);
					doc.add(new Paragraph(" "));
					doc.add(p3);
					doc.add(new Paragraph(" "));
					doc.add(p4);
					doc.add(new Paragraph(" "));
					doc.add(p5);
					doc.add(new Paragraph(" "));
					doc.add(p6);
					doc.add(new Paragraph(" "));
					
					doc.close();
					JOptionPane.showMessageDialog(null,"demande de congés créee!!!");
					
					//Desktop.getDesktop().open( new File("C:\\Users\\hp\\Desktop\\yass.pdf"));
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_1.setText("");
				textField.setText("");
				textField_2.setText("");
                
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(1052, 586, 141, 46);
		frmGestionDesConges.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ppr,date_demande,date_debut,date_fin,duree;
				int solde_a_diminuer,a=0,b;
				ppr=textField_3.getText();
				date_demande=textField.getText();
				date_debut=textField_4.getText();
				date_fin=textField_1.getText();
				duree=textField_5.getText();
				solde_a_diminuer=Integer.parseInt(textField_2.getText());
				final String Date_REGEX = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
				if(date_demande.matches(Date_REGEX)&& date_debut.matches(Date_REGEX) && date_fin.matches(Date_REGEX)) {
					try {
						Pst=conn.prepareStatement("insert into conges (PPR,date_demande,date_debut,date_fin,duree,solde_a_diminuer) values(?,?,?,?,?,?)");
						Pst.setString(1,ppr);
						Pst.setString(2,date_demande);
						Pst.setString(3,date_debut);
						Pst.setString(4,date_fin);
						Pst.setString(5,duree);
						Pst.setInt(6,solde_a_diminuer);
						Pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Record added!!!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "PPR non valide");
					}
					try {
						
						Pst=conn.prepareStatement("select Solde_du_conge  from personnel where PPR = ?");
						Pst.setString(1,ppr);
						ResultSet rs = Pst.executeQuery();
						if(rs.next()==true) {
							a= rs.getInt(1);
						}
						
						 
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					b=a-solde_a_diminuer;
					
					if(b>0) {
						try {
							Pst=conn.prepareStatement("update personnel set Solde_du_conge=? where PPR=?");
							Pst.setInt(1,b);
							Pst.setString(2,ppr);
							Pst.executeUpdate();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {
						try {
							Pst=conn.prepareStatement("update personnel set Solde_du_conge=? where PPR=?");
							Pst.setInt(1,0);
							Pst.setString(2,ppr);
							Pst.executeUpdate();
							
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
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBounds(105, 586, 141, 46);
		frmGestionDesConges.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Consulter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulter_les_conges fenetre = new Consulter_les_conges();
				fenetre.frmConsulterLesConges.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(new Color(65, 105, 225));
		btnNewButton_2.setBounds(582, 586, 141, 46);
		frmGestionDesConges.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Retour");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGestionDesConges.setVisible(false);
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBackground(new Color(65, 105, 225));
		btnNewButton_3.setBounds(1172, 22, 141, 46);
		frmGestionDesConges.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GestionDesConges.class.getResource("/images/image4.png")));
		lblNewLabel.setBounds(0, 0, 1342, 699);
		frmGestionDesConges.getContentPane().add(lblNewLabel);
		
	}

}
