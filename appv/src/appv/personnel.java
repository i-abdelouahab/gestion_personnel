package appv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class personnel {

	 JFrame frmGestionDePersonnel;
	private JTextField search;
	private JTextField PPRV;
	private JTextField NOM;
	private JTextField DATE_NAISS;
	private JTextField SEXE;
	private JTextField Cin;
	private JTextField ADRESSE;
	private JTextField GRADE;
	private JTextField NBR_ABSENCE;
	private JTextField NATIONAL;
	private JTextField Lieu_naissance;
	private JTextField N_TELEPHONE;
	private JTextField NBR_ENFANTS;
	private JTextField SITUATION_FAMILIAL;
	private JTextField RECRUT_ENSA;
	private JTextField EMAIL_INST;
	private JTextField DATE_RECRUTEMENT;
	private JTextField ECHELLE;
	private JTextField SOLDE_CONGE;
	private JTextField SOLDE_LICENCEEXP;
	private JTextField GRADE_DATE;
	private JTextField TYPE_EMPLOYE;
	Connection con;
	PreparedStatement Pst;
	ResultSet rs;
	private JTextField status_Travail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personnel window = new personnel();
					window.frmGestionDePersonnel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public personnel() {
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
		frmGestionDePersonnel = new JFrame();
		frmGestionDePersonnel.setIconImage(Toolkit.getDefaultToolkit().getImage(personnel.class.getResource("/images/logoGP.png")));
		frmGestionDePersonnel.setTitle("Gestion de Personnel");
		frmGestionDePersonnel.setBounds(0, 0, 1400, 1000);
		frmGestionDePersonnel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDePersonnel.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "                                                                                                                          ", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 132, 1350, 562);
		panel.setBackground(new Color(255, 255, 255));
		frmGestionDePersonnel.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLesInformationsPersonnel = new JLabel("les informations personnel");
		lblLesInformationsPersonnel.setBackground(new Color(255, 248, 220));
		lblLesInformationsPersonnel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLesInformationsPersonnel.setForeground(new Color(0, 128, 128));
		lblLesInformationsPersonnel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLesInformationsPersonnel.setBounds(27, -11, 347, 38);
		panel.add(lblLesInformationsPersonnel);
		
		JLabel lblNewLabel_1_1 = new JLabel("PPR");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(27, 55, 141, 38);
		panel.add(lblNewLabel_1_1);
		
		PPRV = new JTextField();
		PPRV.setBounds(169, 61, 153, 32);
		panel.add(PPRV);
		PPRV.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("SEXE");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(27, 143, 141, 38);
		panel.add(lblNewLabel_1_2);
		
		JLabel Ppr = new JLabel("CIN");
		Ppr.setFont(new Font("Tahoma", Font.BOLD, 16));
		Ppr.setBounds(27, 240, 141, 38);
		panel.add(Ppr);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nom Complet");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(339, 56, 132, 38);
		panel.add(lblNewLabel_2_1);
		
		NOM = new JTextField();
		NOM.setColumns(10);
		NOM.setBounds(474, 61, 153, 32);
		panel.add(NOM);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date de Naissance");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(637, 55, 191, 38);
		panel.add(lblNewLabel_3_1);
		
		DATE_NAISS = new JTextField();
		DATE_NAISS.setColumns(10);
		DATE_NAISS.setBounds(838, 61, 153, 32);
		panel.add(DATE_NAISS);
		
		JLabel lblNewLabel_1_4 = new JLabel("Adresse");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(27, 339, 141, 38);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Grade");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(27, 423, 141, 38);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Nombre absence");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(27, 513, 141, 38);
		panel.add(lblNewLabel_1_6);
		
		SEXE = new JTextField();
		SEXE.setColumns(10);
		SEXE.setBounds(170, 148, 153, 32);
		panel.add(SEXE);
		
		Cin = new JTextField();
		Cin.setColumns(10);
		Cin.setBounds(170, 245, 153, 32);
		panel.add(Cin);
		
		ADRESSE = new JTextField();
		ADRESSE.setColumns(10);
		ADRESSE.setBounds(170, 344, 153, 32);
		panel.add(ADRESSE);
		
		GRADE = new JTextField();
		GRADE.setColumns(10);
		GRADE.setBounds(169, 428, 153, 32);
		panel.add(GRADE);
		
		NBR_ABSENCE = new JTextField();
		NBR_ABSENCE.setColumns(10);
		NBR_ABSENCE.setBounds(169, 518, 153, 32);
		panel.add(NBR_ABSENCE);
		
		NATIONAL = new JTextField();
		NATIONAL.setColumns(10);
		NATIONAL.setBounds(1150, 61, 164, 32);
		panel.add(NATIONAL);
		
		JLabel lblNewLabel_4_1 = new JLabel("Nationalite");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(1001, 55, 146, 38);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Lieu de naissance");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(339, 143, 132, 38);
		panel.add(lblNewLabel_2_2);
		
		Lieu_naissance = new JTextField();
		Lieu_naissance.setColumns(10);
		Lieu_naissance.setBounds(474, 149, 153, 32);
		panel.add(Lieu_naissance);
		
		JLabel lblNewLabel_2_3 = new JLabel("N_telephone");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_3.setBounds(339, 240, 132, 38);
		panel.add(lblNewLabel_2_3);
		
		N_TELEPHONE = new JTextField();
		N_TELEPHONE.setColumns(10);
		N_TELEPHONE.setBounds(474, 246, 153, 32);
		panel.add(N_TELEPHONE);
		
		JLabel lblNewLabel_3_2 = new JLabel("Nombre des enfants");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(637, 143, 191, 38);
		panel.add(lblNewLabel_3_2);
		
		NBR_ENFANTS = new JTextField();
		NBR_ENFANTS.setColumns(10);
		NBR_ENFANTS.setBounds(838, 149, 153, 32);
		panel.add(NBR_ENFANTS);
		
		JLabel lblNewLabel_4_2 = new JLabel("Situation familial");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4_2.setBounds(1001, 143, 146, 38);
		panel.add(lblNewLabel_4_2);
		
		SITUATION_FAMILIAL = new JTextField();
		SITUATION_FAMILIAL.setColumns(10);
		SITUATION_FAMILIAL.setBounds(1150, 148, 164, 32);
		panel.add(SITUATION_FAMILIAL);
		
		JLabel lblNewLabel_3_3 = new JLabel("Recrutemnt a L'Ensa");
		lblNewLabel_3_3.setToolTipText("Date Recrutement a l'Ensa");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_3.setBounds(637, 240, 191, 38);
		panel.add(lblNewLabel_3_3);
		
		RECRUT_ENSA = new JTextField();
		RECRUT_ENSA.setColumns(10);
		RECRUT_ENSA.setBounds(838, 246, 153, 32);
		panel.add(RECRUT_ENSA);
		
		JLabel lblNewLabel_2_4 = new JLabel("Email inst");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_4.setBounds(340, 339, 124, 38);
		panel.add(lblNewLabel_2_4);
		
		EMAIL_INST = new JTextField();
		EMAIL_INST.setColumns(10);
		EMAIL_INST.setBounds(474, 345, 153, 32);
		panel.add(EMAIL_INST);
		
		JLabel lblNewLabel_2_5 = new JLabel("Echelle");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_5.setBounds(340, 423, 124, 38);
		panel.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_3_4 = new JLabel("Date Recrutement");
		lblNewLabel_3_4.setToolTipText("Date Recrutement a l'Ensa");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_4.setBounds(637, 339, 191, 38);
		panel.add(lblNewLabel_3_4);
		
		DATE_RECRUTEMENT = new JTextField();
		DATE_RECRUTEMENT.setColumns(10);
		DATE_RECRUTEMENT.setBounds(838, 345, 153, 32);
		panel.add(DATE_RECRUTEMENT);
		
		ECHELLE = new JTextField();
		ECHELLE.setColumns(10);
		ECHELLE.setBounds(474, 428, 153, 32);
		panel.add(ECHELLE);
		
		JLabel lblNewLabel_2_6 = new JLabel("Solde conge");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_6.setBounds(339, 513, 125, 38);
		panel.add(lblNewLabel_2_6);
		
		SOLDE_CONGE = new JTextField();
		SOLDE_CONGE.setColumns(10);
		SOLDE_CONGE.setBounds(474, 518, 153, 32);
		panel.add(SOLDE_CONGE);
		
		JLabel lblNewLabel_3_6 = new JLabel("Solde licences_exp");
		lblNewLabel_3_6.setToolTipText("Date Recrutement a l'Ensa");
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_6.setBounds(637, 513, 191, 38);
		panel.add(lblNewLabel_3_6);
		
		SOLDE_LICENCEEXP = new JTextField();
		SOLDE_LICENCEEXP.setColumns(10);
		SOLDE_LICENCEEXP.setBounds(838, 518, 153, 32);
		panel.add(SOLDE_LICENCEEXP);
		
		JLabel lblNewLabel_3_5 = new JLabel("Derniere grade_date");
		lblNewLabel_3_5.setToolTipText("Date Recrutement a l'Ensa");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_5.setBounds(637, 423, 191, 38);
		panel.add(lblNewLabel_3_5);
		
		GRADE_DATE = new JTextField();
		GRADE_DATE.setColumns(10);
		GRADE_DATE.setBounds(838, 428, 153, 32);
		panel.add(GRADE_DATE);
		
		JLabel lblNewLabel_4_3 = new JLabel("Type Employe");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4_3.setBounds(1001, 240, 146, 38);
		panel.add(lblNewLabel_4_3);
		
		TYPE_EMPLOYE = new JTextField();
		TYPE_EMPLOYE.setColumns(10);
		TYPE_EMPLOYE.setBounds(1150, 245, 164, 32);
		panel.add(TYPE_EMPLOYE);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("status de travail");
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4_3_1.setBounds(1001, 339, 146, 38);
		panel.add(lblNewLabel_4_3_1);
		
		status_Travail = new JTextField();
		status_Travail.setColumns(10);
		status_Travail.setBounds(1150, 345, 164, 32);
		panel.add(status_Travail);
		
		JLabel lblNewLabel = new JLabel("Recherche par PPR :");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(976, 11, 264, 38);
		frmGestionDePersonnel.getContentPane().add(lblNewLabel);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int nbr_enf,absences,solde_conge,Solde_licence;
				String ppr,cin,adresse,date_naissance,lieu_naissance,Nationalite,Nom,sexe,situ_familial,recrutement_ensa,recrutement,grade_mise,echelle,email,grade,N_telephone,status,type_employe;
				String id=search.getText();
				try {
					Pst=con.prepareStatement("select PPR,CIN,Adresse,Date_de_naissance,Lieu_de_naissance,Nationalite,Nom_Complet_Fr,Nombre_Des_enfants,Sexe,Situation_familial,recrutement_ensa,recrutement,grade_mise,Echelle,Email,Grade,	N_telephone,Nombre_absence,Solde_du_conge,Solde_licence_exceptionnel,Status_de_travail,Type_employe	 from personnel where PPR = ?");
					Pst.setString(1, id);
					ResultSet rs = Pst.executeQuery();
					if(rs.next()==true) {
						 ppr =rs.getString(1);
						 cin=rs.getString(2);
						 adresse = rs.getString(3);
						 date_naissance= rs.getString(4);
						 lieu_naissance = rs.getString(5);
						 Nationalite = rs.getString(6);
						 Nom = rs.getString(7);
						 nbr_enf= rs.getInt(8);
						 sexe = rs.getString(9);
						 situ_familial= rs.getString(10);
						 recrutement_ensa= rs.getString(11);
						 recrutement= rs.getString(12);
						 grade_mise= rs.getString(13);
						 echelle= rs.getString(14);
						 email= rs.getString(15);
						 grade= rs.getString(16);
						 N_telephone= rs.getString(17);
					     absences= rs.getInt(18);
						 solde_conge= rs.getInt(19);
						 Solde_licence= rs.getInt(20);
						 status= rs.getString(21);
						 type_employe= rs.getString(22);
						PPRV.setText(ppr);
						Cin.setText(cin);
						ADRESSE.setText(adresse);
						DATE_NAISS.setText(date_naissance);
						Lieu_naissance.setText(lieu_naissance);
						NATIONAL.setText(Nationalite);
						NOM.setText(Nom);
						NBR_ENFANTS.setText(String.valueOf(nbr_enf));
						SEXE.setText(sexe);
						SITUATION_FAMILIAL.setText(situ_familial);
						RECRUT_ENSA.setText(recrutement_ensa);
						DATE_RECRUTEMENT.setText(recrutement);
						GRADE_DATE.setText(grade_mise);
						ECHELLE.setText(echelle);
						EMAIL_INST.setText(email);
						GRADE.setText(grade);
						N_TELEPHONE.setText(N_telephone);
						NBR_ABSENCE.setText(String.valueOf(absences));
						SOLDE_CONGE.setText(String.valueOf(solde_conge));
						SOLDE_LICENCEEXP.setText(String.valueOf(Solde_licence));
						status_Travail.setText(status);
						TYPE_EMPLOYE.setText(type_employe);
							
					}
					else {
						PPRV.setText("");
						Cin.setText("");
						ADRESSE.setText("");
						DATE_NAISS.setText("");
						Lieu_naissance.setText("");
						NATIONAL.setText("");
						NOM.setText("");
						NBR_ENFANTS.setText("");
						SEXE.setText("");
						SITUATION_FAMILIAL.setText("");
						RECRUT_ENSA.setText("");
						DATE_RECRUTEMENT.setText("");
						GRADE_DATE.setText("");
						ECHELLE.setText("");
						EMAIL_INST.setText("");
						GRADE.setText("");
						N_TELEPHONE.setText("");
						NBR_ABSENCE.setText("");
						SOLDE_CONGE.setText("");
						SOLDE_LICENCEEXP.setText("");
						status_Travail.setText("");
						TYPE_EMPLOYE.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		search.setBounds(976, 63, 235, 30);
		frmGestionDePersonnel.getContentPane().add(search);
		search.setColumns(10);
		
		JButton btnNewButton_3_1 = new JButton("Modifier");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ppr,cin,adresse,date_naissance,lieu_naissance,Nationalite,Nom,sexe,situ_familial,recrutement_ensa,recrutement,grade_mise,echelle,email,grade,N_telephone,status,type_employe;
				int nbr_enf,absences,solde_conge,Solde_licence;
				ppr=PPRV.getText();
				cin=Cin.getText();
				adresse=ADRESSE.getText();
				date_naissance=DATE_NAISS.getText();
				lieu_naissance=Lieu_naissance.getText();
				Nationalite=NATIONAL.getText();
				Nom=NOM.getText();
				nbr_enf= Integer.parseInt(NBR_ENFANTS.getText());
				sexe=SEXE.getText();
				situ_familial=SITUATION_FAMILIAL.getText();
				recrutement_ensa=RECRUT_ENSA.getText();
				recrutement=DATE_RECRUTEMENT.getText();
				grade_mise=GRADE_DATE.getText();
				echelle=ECHELLE.getText();
				email=EMAIL_INST.getText();
				grade=GRADE.getText();
				N_telephone=N_TELEPHONE.getText();
				absences=Integer.parseInt(NBR_ABSENCE.getText());
				solde_conge=Integer.parseInt(SOLDE_CONGE.getText());
				Solde_licence=Integer.parseInt(SOLDE_LICENCEEXP.getText());
				status=status_Travail.getText();
				type_employe=TYPE_EMPLOYE.getText();
				
				ppr=search.getText();
				//final String Date_REGEX = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
				//if(date_naissance.matches(Date_REGEX) && recrutement_ensa.matches(Date_REGEX) && recrutement.matches(Date_REGEX) && grade.matches(Date_REGEX) ) {
				final String Date_REGEX = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
				if(date_naissance.matches(Date_REGEX) && recrutement_ensa.matches(Date_REGEX) && recrutement.matches(Date_REGEX) && grade_mise.matches(Date_REGEX) ) {
					try {
						Pst=con.prepareStatement("update personnel set CIN=?,Adresse=?,Date_de_naissance=?,Lieu_de_naissance=?,Nationalite=?,Nom_Complet_Fr=?,Nombre_Des_enfants=?,Sexe=?,Situation_familial=?,recrutement_ensa =?,recrutement=?,grade_mise=?,Echelle=?,Email=?,Grade=?,N_telephone=?,Nombre_absence=?,Solde_du_conge=?,Solde_licence_exceptionnel=?,Status_de_travail=?,Type_employe=? where PPR=?");
						Pst.setString(1, cin);
						Pst.setString(2, adresse);
						Pst.setString(3, date_naissance);
						Pst.setString(4,lieu_naissance);
						Pst.setString(5,Nationalite);
						Pst.setString(6,Nom);
						Pst.setInt(7,nbr_enf);
						Pst.setString(8, sexe );
						Pst.setString(9,situ_familial);
						Pst.setString(10,  recrutement_ensa);
						Pst.setString(11,  recrutement);
						Pst.setString(12,  grade_mise);
						Pst.setString(13,  echelle);
						Pst.setString(14,  email);
						Pst.setString(15,  grade);
						Pst.setString(16,  N_telephone);
						Pst.setInt(17,absences);
						Pst.setInt(18,solde_conge);
						Pst.setInt(19,Solde_licence);
						Pst.setString(20,  status);
						Pst.setString(21,  type_employe);
						Pst.setString(22,  ppr);
						Pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Record updated!!!");
						
						
						/*search.setText("");
						PPRV.setText("");
						Cin.setText("");
						ADRESSE.setText("");
						DATE_NAISS.setText("");
						Lieu_naissance.setText("");
						NATIONAL.setText("");
						NOM.setText("");
						NBR_ENFANTS.setText("");
						SEXE.setText("");
						SITUATION_FAMILIAL.setText("");
						RECRUT_ENSA.setText("");
						DATE_RECRUTEMENT.setText("");
						GRADE_DATE.setText("");
						ECHELLE.setText("");
						EMAIL_INST.setText("");
						GRADE.setText("");
						N_TELEPHONE.setText("");
						NBR_ABSENCE.setText("");
						SOLDE_CONGE.setText("");
						SOLDE_LICENCEEXP.setText("");
						status_Travail.setText("");
						TYPE_EMPLOYE.setText("");*/
							
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				//}
				//else {
					//JOptionPane.showMessageDialog(null,"Date error!!!");
				//}

				 }
				else {
					JOptionPane.showMessageDialog(null,"Date error!!!");
				}
			
			}
		});
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3_1.setBackground(Color.BLUE);
		btnNewButton_3_1.setBounds(431, 55, 157, 38);
		frmGestionDePersonnel.getContentPane().add(btnNewButton_3_1);
		
		JButton Ajouter = new JButton("Ajouter");
		Ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CIN,Adresse,Lieu_Naissance,Nationalite,Nom,Sexe,Situation_Familial,Echelle,Email,Grade,N_Telephone,Status_De_Travail,Type_employe;
				String PPR;
				int Nombres_enfants,Nombre_absence,Solde_conge,Solde_licence_exp;
				String Date_Naissance,Recrutement_Ensa,Recrutement_Date ,Grade_Update ;
				PPR = PPRV.getText() ;
				Nombres_enfants = Integer.parseInt(NBR_ENFANTS.getText()) ;
				Nombre_absence = Integer.parseInt(NBR_ABSENCE.getText()) ;
				Solde_conge = Integer.parseInt(SOLDE_CONGE.getText()) ;
				Solde_licence_exp =Integer.parseInt(SOLDE_LICENCEEXP.getText()) ;
	
					Date_Naissance= DATE_NAISS.getText();
					Recrutement_Ensa=RECRUT_ENSA.getText() ;
					Recrutement_Date=DATE_RECRUTEMENT.getText() ;
				    Grade_Update= GRADE_DATE.getText() ;
				    
				    
				
				
				CIN =Cin.getText();
				Adresse =ADRESSE.getText();
				Lieu_Naissance =Lieu_naissance.getText();
				Nationalite =NATIONAL.getText();
				Nom =NOM.getText();
				Sexe =SEXE.getText();
				Situation_Familial =SITUATION_FAMILIAL.getText();
				Echelle=ECHELLE.getText();
				Email=EMAIL_INST.getText();
				Grade=GRADE.getText();
				N_Telephone=N_TELEPHONE.getText();
				Status_De_Travail=status_Travail.getText();
				Type_employe=TYPE_EMPLOYE .getText();
				
				final String Date_REGEX = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
				if(Date_Naissance.matches(Date_REGEX) && Recrutement_Ensa.matches(Date_REGEX) && Recrutement_Date.matches(Date_REGEX) && Grade_Update.matches(Date_REGEX) ) {
					try {
						Pst=con.prepareStatement("insert into personnel(PPR,CIN,Adresse,Date_de_naissance,Lieu_de_naissance,Nationalite,Nom_Complet_Fr,Nombre_Des_enfants,Sexe,Situation_familial) values(?,?,?,?,?,?,?,?,?,?)");
						Pst.setString(1, PPR);
						Pst.setString(2, CIN);
						Pst.setString(3, Adresse);
						Pst.setString(4,Date_Naissance);
						Pst.setString(5,Lieu_Naissance);
						Pst.setString(6,Nationalite);
						Pst.setString(7,Nom);
						Pst.setInt(8, Nombres_enfants );
						Pst.setString(9,Sexe);
						Pst.setString(10,Situation_Familial);
						//Pst.setString(10,  Recrutement_Ensa);
						//Pst.setString(11, Recrutement_Date);
						/*Pst.setString(13, Grade_Update);
						Pst.setString(14, Echelle);
						Pst.setString(15, Email);
						Pst.setString(16, Grade);
						Pst.setString(17, N_Telephone);
						Pst.setString(18, Nombre_absence);
						Pst.setString(19, Solde_conge);
						Pst.setString(20, Solde_licence_exp);
						Pst.setString(21, Status_De_Travail);
						Pst.setString(22, Type_employe);*/
						
						Pst.executeUpdate();
						
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
					
					try {
						Pst=con.prepareStatement("update personnel set recrutement_ensa=?,recrutement=?,grade_mise=?,Echelle=?,Email=?,Grade=?,N_telephone=?,Nombre_absence=?,Solde_du_conge=?,Solde_licence_exceptionnel=?,Status_de_travail=?,Type_employe=? where PPR=?");
						Pst.setString(1,  Recrutement_Ensa);
						Pst.setString(2, Recrutement_Date);
						Pst.setString(3, Grade_Update);
						Pst.setString(4, Echelle);
						Pst.setString(5, Email);
						Pst.setString(6, Grade);
						Pst.setString(7, N_Telephone);
						Pst.setInt(8, Nombre_absence);
						Pst.setInt(9, Solde_conge);
						Pst.setInt(10, Solde_licence_exp);
						Pst.setString(11, Status_De_Travail);
						Pst.setString(12, Type_employe);
						Pst.setString(13, PPR);
						Pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Record ADddded!!!");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
			    }
					else {
						JOptionPane.showMessageDialog(null,"Date error!!!");
					}
				
					
					/*txt_Name.setText("");
					txt_Edition.setText("");
					txt_Price.setText("");
					txt_Name.requestFocus();*/
						
				
			}
		});
		Ajouter.setForeground(Color.WHITE);
		Ajouter.setFont(new Font("Tahoma", Font.BOLD, 20));
		Ajouter.setBackground(Color.BLUE);
		Ajouter.setBounds(264, 55, 157, 38);
		frmGestionDePersonnel.getContentPane().add(Ajouter);
		
		JButton btnNewButton_3_1_2 = new JButton("Retirer");
		btnNewButton_3_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String ppr1;
				ppr1=search.getText();
				try {
					Pst=con.prepareStatement("delete from personnel where PPR =?");
					Pst.setString(1, ppr1);
					Pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Record deleted!!!");
					search.setText("");
					PPRV.setText("");
					Cin.setText("");
					ADRESSE.setText("");
					DATE_NAISS.setText("");
					Lieu_naissance.setText("");
					NATIONAL.setText("");
					NOM.setText("");
					NBR_ENFANTS.setText("");
					SEXE.setText("");
					SITUATION_FAMILIAL.setText("");
					RECRUT_ENSA.setText("");
					DATE_RECRUTEMENT.setText("");
					GRADE_DATE.setText("");
					ECHELLE.setText("");
					EMAIL_INST.setText("");
					GRADE.setText("");
					N_TELEPHONE.setText("");
					NBR_ABSENCE.setText("");
					SOLDE_CONGE.setText("");
					SOLDE_LICENCEEXP.setText("");
					status_Travail.setText("");
					TYPE_EMPLOYE.setText("");
	
						
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3_1_2.setForeground(Color.WHITE);
		btnNewButton_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3_1_2.setBackground(Color.BLUE);
		btnNewButton_3_1_2.setBounds(606, 55, 157, 38);
		frmGestionDePersonnel.getContentPane().add(btnNewButton_3_1_2);
		
		JButton btnNewButton_3_1_3 = new JButton("Consulter");
		btnNewButton_3_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personnel2 p=new personnel2();
				p.frmConsulterRegistres.setVisible(true);
				
				
			}
		});
		btnNewButton_3_1_3.setForeground(Color.WHITE);
		btnNewButton_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3_1_3.setBackground(Color.BLUE);
		btnNewButton_3_1_3.setBounds(784, 55, 157, 38);
		frmGestionDePersonnel.getContentPane().add(btnNewButton_3_1_3);
		
		
		JButton retour = new JButton("retour");
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGestionDePersonnel.setVisible(false);
			}
		});
		retour.setForeground(Color.WHITE);
		retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		retour.setBackground(Color.BLUE);
		retour.setBounds(97, 55, 157, 38);
		frmGestionDePersonnel.getContentPane().add(retour);
		
		JLabel lblNewLabel55 = new JLabel("");
		lblNewLabel55.setBackground(new Color(224, 255, 255));
		lblNewLabel55.setIcon(new ImageIcon(personnel.class.getResource("/images/img18.png")));
		lblNewLabel55.setBounds(2, 0, 1342, 699);
		frmGestionDePersonnel.getContentPane().add(lblNewLabel55);
	}
}
