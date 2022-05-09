package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class avancements {

	JFrame frmGestionDesAvancements;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_20;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField;
	private JTextField textField_12;
	private JTextField textField_23;
	private JTextField textField_31;
	private JTextField textField_39;
	private JTextField textField_47;
	Connection conn;
	PreparedStatement Pst;
	ResultSet rs;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					avancements window = new avancements();
					window.frmGestionDesAvancements.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public avancements() {
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
		frmGestionDesAvancements = new JFrame();
		frmGestionDesAvancements.setIconImage(Toolkit.getDefaultToolkit().getImage(avancements.class.getResource("/images/logoGP.png")));
		frmGestionDesAvancements.setTitle("Gestion des avancements");
		frmGestionDesAvancements.setBounds(0, 0, 1360, 749);
		frmGestionDesAvancements.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesAvancements.getContentPane().setLayout(null);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(55, 466, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(210, 466, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(365, 466, 143, 44);
		frmGestionDesAvancements.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(511, 466, 158, 44);
		frmGestionDesAvancements.getContentPane().add(textField_10);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(671, 466, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(826, 466, 136, 44);
		frmGestionDesAvancements.getContentPane().add(textField_17);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(965, 466, 203, 44);
		frmGestionDesAvancements.getContentPane().add(textField_20);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(965, 514, 203, 44);
		frmGestionDesAvancements.getContentPane().add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(965, 562, 203, 44);
		frmGestionDesAvancements.getContentPane().add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(965, 611, 203, 44);
		frmGestionDesAvancements.getContentPane().add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(826, 611, 136, 44);
		frmGestionDesAvancements.getContentPane().add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(826, 562, 136, 44);
		frmGestionDesAvancements.getContentPane().add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(826, 514, 136, 44);
		frmGestionDesAvancements.getContentPane().add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(671, 514, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_30);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(671, 562, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(671, 611, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(511, 611, 158, 44);
		frmGestionDesAvancements.getContentPane().add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(511, 562, 158, 44);
		frmGestionDesAvancements.getContentPane().add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setColumns(10);
		textField_36.setBounds(511, 514, 158, 44);
		frmGestionDesAvancements.getContentPane().add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(365, 514, 143, 44);
		frmGestionDesAvancements.getContentPane().add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBounds(365, 562, 143, 44);
		frmGestionDesAvancements.getContentPane().add(textField_38);
		
		textField_40 = new JTextField();
		textField_40.setColumns(10);
		textField_40.setBounds(365, 611, 143, 44);
		frmGestionDesAvancements.getContentPane().add(textField_40);
		
		textField_41 = new JTextField();
		textField_41.setColumns(10);
		textField_41.setBounds(210, 611, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_41);
		
		textField_42 = new JTextField();
		textField_42.setColumns(10);
		textField_42.setBounds(210, 562, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_42);
		
		textField_43 = new JTextField();
		textField_43.setColumns(10);
		textField_43.setBounds(210, 514, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_43);
		
		textField_44 = new JTextField();
		textField_44.setColumns(10);
		textField_44.setBounds(55, 611, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_44);
		
		textField_45 = new JTextField();
		textField_45.setColumns(10);
		textField_45.setBounds(55, 562, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_45);
		
		textField_46 = new JTextField();
		textField_46.setColumns(10);
		textField_46.setBounds(55, 514, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_46);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(965, 416, 203, 44);
		frmGestionDesAvancements.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(826, 416, 136, 44);
		frmGestionDesAvancements.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(671, 416, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(511, 416, 158, 44);
		frmGestionDesAvancements.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(365, 416, 143, 44);
		frmGestionDesAvancements.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(210, 416, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_6);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(55, 416, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_11);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(965, 367, 203, 44);
		frmGestionDesAvancements.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(826, 367, 136, 44);
		frmGestionDesAvancements.getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(671, 367, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_15);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(511, 367, 158, 44);
		frmGestionDesAvancements.getContentPane().add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(365, 367, 143, 44);
		frmGestionDesAvancements.getContentPane().add(textField_19);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(210, 367, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(55, 367, 152, 44);
		frmGestionDesAvancements.getContentPane().add(textField_22);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String date1 = null,echelle1 = null,grade1 = null,nom1 = null,ppr1;
				ppr1=textField.getText();
				try {
					Pst=conn.prepareStatement("select Nom_Complet_Fr,grade_mise,Echelle,Grade  from personnel where PPR = ?");
					Pst.setString(1, ppr1);
					ResultSet rs = Pst.executeQuery();
					if(rs.next()==true) {
						nom1=rs.getString(1);
						date1=rs.getString(2);
						echelle1=rs.getString(3);
						grade1=rs.getString(4);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_18.setText(date1);
				textField_15.setText(echelle1);
				textField_14.setText(grade1);
				textField_13.setText(nom1);
				
			}
		});
		textField.setColumns(10);
		textField.setBounds(1173, 367, 113, 44);
		frmGestionDesAvancements.getContentPane().add(textField);
		
		textField_12 = new JTextField();
		textField_12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String date2 = null,echelle2 = null,grade2 = null,nom2 = null,ppr2;
				ppr2=textField_12.getText();
				try {
					Pst=conn.prepareStatement("select Nom_Complet_Fr,grade_mise,Echelle,Grade  from personnel where PPR = ?");
					Pst.setString(1, ppr2);
					ResultSet rs = Pst.executeQuery();
					if(rs.next()==true) {
						nom2=rs.getString(1);
						date2=rs.getString(2);
						echelle2=rs.getString(3);
						grade2=rs.getString(4);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_4.setText(date2);
				textField_3.setText(echelle2);
				textField_2.setText(grade2);
				textField_1.setText(nom2);
			}
		});
		textField_12.setColumns(10);
		textField_12.setBounds(1173, 416, 113, 44);
		frmGestionDesAvancements.getContentPane().add(textField_12);
		
		textField_23 = new JTextField();
		textField_23.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String date3 = null,echelle3 = null,grade3 = null,nom3 = null,ppr3;
				ppr3=textField_23.getText();
				try {
					Pst=conn.prepareStatement("select Nom_Complet_Fr,grade_mise,Echelle,Grade  from personnel where PPR = ?");
					Pst.setString(1, ppr3);
					ResultSet rs = Pst.executeQuery();
					if(rs.next()==true) {
						nom3=rs.getString(1);
						date3=rs.getString(2);
						echelle3=rs.getString(3);
						grade3=rs.getString(4);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_10.setText(date3);
				textField_16.setText(echelle3);
				textField_17.setText(grade3);
				textField_20.setText(nom3);
			}
		});
		textField_23.setColumns(10);
		textField_23.setBounds(1173, 466, 113, 44);
		frmGestionDesAvancements.getContentPane().add(textField_23);
		
		textField_31 = new JTextField();
		textField_31.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String date4 = null,echelle4 = null,grade4 = null,nom4 = null,ppr4;
				ppr4=textField_31.getText();
				try {
					Pst=conn.prepareStatement("select Nom_Complet_Fr,grade_mise,Echelle,Grade  from personnel where PPR = ?");
					Pst.setString(1, ppr4);
					ResultSet rs = Pst.executeQuery();
					if(rs.next()==true) {
						nom4=rs.getString(1);
						date4=rs.getString(2);
						echelle4=rs.getString(3);
						grade4=rs.getString(4);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_36.setText(date4);
				textField_30.setText(echelle4);
				textField_29.setText(grade4);
				textField_24.setText(nom4);
			}
		});
		textField_31.setColumns(10);
		textField_31.setBounds(1173, 514, 113, 44);
		frmGestionDesAvancements.getContentPane().add(textField_31);
		
		textField_39 = new JTextField();
		textField_39.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String date5 = null,echelle5 = null,grade5 = null,nom5 = null,ppr5;
				ppr5=textField_39.getText();
				try {
					Pst=conn.prepareStatement("select Nom_Complet_Fr,grade_mise,Echelle,Grade  from personnel where PPR = ?");
					Pst.setString(1, ppr5);
					ResultSet rs = Pst.executeQuery();
					if(rs.next()==true) {
						nom5=rs.getString(1);
						date5=rs.getString(2);
						echelle5=rs.getString(3);
						grade5=rs.getString(4);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_35.setText(date5);
				textField_32.setText(echelle5);
				textField_28.setText(grade5);
				textField_25.setText(nom5);
			}
		});
		textField_39.setColumns(10);
		textField_39.setBounds(1173, 562, 113, 44);
		frmGestionDesAvancements.getContentPane().add(textField_39);
		
		textField_47 = new JTextField();
		textField_47.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String date6 = null,echelle6 = null,grade6 = null,nom6 = null,ppr6;
				ppr6=textField_47.getText();
				try {
					Pst=conn.prepareStatement("select Nom_Complet_Fr,grade_mise,Echelle,Grade  from personnel where PPR = ?");
					Pst.setString(1, ppr6);
					ResultSet rs = Pst.executeQuery();
					if(rs.next()==true) {
						nom6=rs.getString(1);
						date6=rs.getString(2);
						echelle6=rs.getString(3);
						grade6=rs.getString(4);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_34.setText(date6);
				textField_33.setText(echelle6);
				textField_27.setText(grade6);
				textField_26.setText(nom6);
			}
		});
		textField_47.setColumns(10);
		textField_47.setBounds(1173, 611, 113, 44);
		frmGestionDesAvancements.getContentPane().add(textField_47);
		
		JButton btnNewButton = new JButton("Imprimer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document doc1 = new Document();
				try {
					PdfWriter.getInstance(doc1, new FileOutputStream("C:\\Users\\Ismail Abdelouahab\\Desktop\\avancements_des_grades.pdf"));
                    Image img = Image.getInstance("C:\\Users\\Ismail Abdelouahab\\Desktop\\ensate1.png");
                    
                    
					
					
					img.scaleAbsoluteWidth(540);
					img.scaleAbsoluteHeight(110);
					img.setAlignment(Image.ALIGN_CENTER);
                    doc1.open();
					doc1.add(img);
					doc1.add(new Paragraph(" "));
					doc1.add(new Paragraph(" "));
					doc1.add(new Paragraph(" "));
					doc1.add(new Paragraph(" "));
					doc1.add(new Paragraph(" "));
					doc1.add(new Paragraph(" "));
					Paragraph p1= new Paragraph(" Avancements Des Grades ", FontFactory.getFont(FontFactory.TIMES_ROMAN,20, Font.BOLD, BaseColor.RED));
					p1.setAlignment(Element.ALIGN_CENTER);
					
					Paragraph p2= new Paragraph("      situation proposee              situation actuelle ", FontFactory.getFont(FontFactory.TIMES_ROMAN,18, Font.BOLD, BaseColor.GREEN));
					p2.setAlignment(Element.ALIGN_LEFT);
					
					PdfPTable table = new PdfPTable(8);
                    table.setWidthPercentage(100);
                    PdfPCell cell;
                   /* cell= new PdfPCell (new Phrase("situation proposee",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("situation proposee",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("situation proposee",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("situation actuelle",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("situation actuelle",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("situation actuelle",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("nom",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("PPR",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);*/
                    
                    //--------------------------------------------
                    
                    cell= new PdfPCell (new Phrase("a partir de",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("Echelle",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("grade",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    cell= new PdfPCell (new Phrase("a partir de",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("Echelle",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("grade",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("complet",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase("PPR",FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    //----------------------
                    cell= new PdfPCell (new Phrase(textField_22.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_21.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_19.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_18.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_15.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_14.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_13.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    //---------------------
                    cell= new PdfPCell (new Phrase(textField_11.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_6.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_5.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_4.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_3.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_2.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_1.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_12.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                   
                    
                    //----------------------------------
                   
                    
                    
                    
                    
                    
                    cell= new PdfPCell (new Phrase(textField_7.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_8.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_9.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_10.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_16.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_17.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_20.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_23.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                  
                    
                    //----------------------------------
                    
                    cell= new PdfPCell (new Phrase(textField_46.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_43.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_37.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_36.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_30.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_29.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_24.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_31.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
//----------------------------------
                    
                    cell= new PdfPCell (new Phrase(textField_45.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_42.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_38.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_35.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_32.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_28.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_25.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_39.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
//----------------------------------
                    
                    cell= new PdfPCell (new Phrase(textField_44.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_41.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_40.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_34.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_33.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_27.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_26.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);
                    
                    cell= new PdfPCell (new Phrase(textField_47.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,11)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell.setBackgroundColor(BaseColor.GRAY);
                    table.addCell(cell);

                    
                    
					doc1.add(p1);
					doc1.add(new Paragraph(" "));
					doc1.add(new Paragraph(" "));
					doc1.add(p2);
					doc1.add(new Paragraph(" "));
					doc1.add(table);
					doc1.close();
					JOptionPane.showMessageDialog(null,"demande imprimée!!!");
					
				}catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (FileNotFoundException e1) {
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
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setIcon(new ImageIcon(avancements.class.getResource("/images/imprimer.png")));
		btnNewButton.setBounds(1143, 152, 143, 50);
		btnNewButton.setFocusable(false);
		frmGestionDesAvancements.getContentPane().add(btnNewButton);
		
		
		
		btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGestionDesAvancements.setVisible(false);
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setBounds(41, 168, 141, 46);
		frmGestionDesAvancements.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(avancements.class.getResource("/images/image2.png")));
		lblNewLabel_1.setBounds( 0, 0, 1342, 699);
		frmGestionDesAvancements.getContentPane().add(lblNewLabel_1);
	}
}
