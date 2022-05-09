package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ordre_de_mission {

	JFrame frmOrderDeMission;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	
	Connection conn;
	PreparedStatement Pst;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ordre_de_mission window = new ordre_de_mission();
					window.frmOrderDeMission.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ordre_de_mission() {
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
		frmOrderDeMission = new JFrame();
		frmOrderDeMission.setIconImage(Toolkit.getDefaultToolkit().getImage(ordre_de_mission.class.getResource("/images/logoGP.png")));
		frmOrderDeMission.setTitle("Ordre de mission");
		frmOrderDeMission.setBounds(0, 0, 1360, 749);
		frmOrderDeMission.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOrderDeMission.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(917, 258, 235, 35);
		frmOrderDeMission.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(917, 326, 235, 35);
		frmOrderDeMission.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(285, 258, 235, 35);
		frmOrderDeMission.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(285, 326, 235, 35);
		frmOrderDeMission.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(285, 398, 235, 35);
		frmOrderDeMission.getContentPane().add(textField_4);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(78, 506, 492, 148);
		frmOrderDeMission.getContentPane().add(textPane);
		
		btnNewButton = new JButton("Consulter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulter_ordre_de_mission fenetre = new Consulter_ordre_de_mission();
				fenetre.frmConsulterOrdreDe.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(1116, 471, 169, 46);
		frmOrderDeMission.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Ordre au Maroc");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String PPR,date_demande,date_debut,date_fin,duree,nom = null;
	                PPR=textField_2.getText();
	                date_demande=textField.getText();
	                date_debut=textField_3.getText();
	                date_fin=textField_1.getText();
	                duree=textField_4.getText();
					
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
						PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Ismail Abdelouahab\\Desktop\\"+nom+"_mission.pdf"));
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
						Paragraph p1= new Paragraph(" Demande d'une ordre de mission ", FontFactory.getFont(FontFactory.TIMES_ROMAN,20, Font.BOLD, BaseColor.RED));
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
						JOptionPane.showMessageDialog(null,"demande créer!!!");
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
					
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBounds(1116, 608, 169, 46);
		frmOrderDeMission.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Enregistrer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mot,mot1,mot2,mot3,mot5;
				int mot4;
				mot=textField.getText();
				mot1=textField_1.getText();
				mot2=textField_2.getText();
				mot3=textField_3.getText();
				mot4=Integer.parseInt(textField_4.getText());
				mot5=textPane.getText();
				final String Date_REGEX = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
				if(mot3.matches(Date_REGEX)&& mot.matches(Date_REGEX) && mot1.matches(Date_REGEX)) {
					try {
						Pst=conn.prepareStatement("insert into ordre_de_mission (PPR,date_debut,duree,date_demande,date_fin,description) values(?,?,?,?,?,?)");
						Pst.setString(1,mot2);
						Pst.setString(2,mot3);
						Pst.setInt(3,mot4);
						Pst.setString(4,mot);
						Pst.setString(5,mot1);
						Pst.setString(6,mot5);
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textPane.setText("");
						Pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Record ADddded!!!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "PPR non valide");
					}
					catch (Exception e2) {
						// TODO Auto-generated catch block
						//e2.printStackTrace();
						//System.out.println("Siaise inmpossible");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Date error!!!");
				}

				
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(new Color(65, 105, 225));
		btnNewButton_2.setBounds(888, 471, 169, 46);
		frmOrderDeMission.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Ordre \u00E0 l'\u00E9tranger");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String PPR,date_demande,date_debut,date_fin,duree,nom = null;
	                PPR=textField_2.getText();
	                date_demande=textField.getText();
	                date_debut=textField_3.getText();
	                date_fin=textField_1.getText();
	                duree=textField_4.getText();
					
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
						PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Ismail Abdelouahab\\Desktop\\"+nom+"_mission_etrange.pdf"));
						Image img = Image.getInstance("C:\\Users\\Ismail Abdelouahab\\Desktop\\images.JPG");
						
						
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
						Paragraph p1= new Paragraph(" Demande d'une ordre de mission a l'etranger ", FontFactory.getFont(FontFactory.TIMES_ROMAN,20, Font.BOLD, BaseColor.RED));
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
						JOptionPane.showMessageDialog(null,"demande créer!!!");
						
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
					
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBackground(new Color(65, 105, 225));
		btnNewButton_3.setBounds(888, 608, 169, 46);
		frmOrderDeMission.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Retour");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOrderDeMission.setVisible(false);
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setBackground(new Color(65, 105, 225));
		btnNewButton_4.setBounds(1165, 22, 169, 46);
		frmOrderDeMission.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ordre_de_mission.class.getResource("/images/image3.png")));
		lblNewLabel.setBounds(0, 0, 1342, 699);
		frmOrderDeMission.getContentPane().add(lblNewLabel);
	}
}
