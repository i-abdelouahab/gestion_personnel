package appv;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class tableau_de_bord {

   JFrame frmTableauDeBord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tableau_de_bord window = new tableau_de_bord();
					window.frmTableauDeBord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tableau_de_bord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTableauDeBord = new JFrame();
		frmTableauDeBord.setTitle("Tableau de Bord");
		frmTableauDeBord.setIconImage(Toolkit.getDefaultToolkit().getImage(tableau_de_bord.class.getResource("/images/logoGP.png")));
		frmTableauDeBord.setBounds(0, 0, 1360, 749);
		frmTableauDeBord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTableauDeBord.getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTableauDeBord.setVisible(false);
				rik b =new rik();
				b.frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setIcon(new ImageIcon(tableau_de_bord.class.getResource("/images/border3.png")));
		btnNewButton.setBounds(1122, 0, 222, 144);
		btnNewButton.setFocusable(false);
		frmTableauDeBord.getContentPane().add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(tableau_de_bord.class.getResource("/images/gest_reg2.png")));
		lblNewLabel_1.setBounds(64, 345, 244, 136);
		frmTableauDeBord.getContentPane().add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(tableau_de_bord.class.getResource("/images/lastdip.png")));
		lblNewLabel_1_1.setBounds(359, 347, 242, 134);
		frmTableauDeBord.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(tableau_de_bord.class.getResource("/images/dip_fin.png")));
		lblNewLabel_1_2.setBounds(656, 347, 238, 134);
		frmTableauDeBord.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(tableau_de_bord.class.getResource("/images/conge2.png")));
		lblNewLabel_1_3.setBounds(949, 345, 242, 136);
		frmTableauDeBord.getContentPane().add(lblNewLabel_1_3);
		
		
		
		JButton btnNewButton_1 = new JButton("ajout des diplomes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjoutDiplomes a=new AjoutDiplomes();
				a.frmAjouterLesDiplomes.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(359, 479, 242, 43);
		frmTableauDeBord.getContentPane().add(btnNewButton_1);
		
		
		
		JButton btnNewButton_1_1 = new JButton("Gestion des Registres");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personnel c = new personnel();
				c.frmGestionDePersonnel.setVisible(true);
			}
		});
		btnNewButton_1_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(64, 479, 244, 43);
		frmTableauDeBord.getContentPane().add(btnNewButton_1_1);
		
		
		JButton btnNewButton_1_2 = new JButton("Gestion des Avancements");
		btnNewButton_1_2.setBackground(new Color(192, 192, 192));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avancements b = new avancements();
				b.frmGestionDesAvancements.setVisible(true);
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_2.setBounds(656, 479, 238, 43);
		frmTableauDeBord.getContentPane().add(btnNewButton_1_2);
		
		String[] conge = {"congés","ordre de mission","Licence Exceptionnel","Absence Non Justifier"};
		
		
		
		JComboBox comboBox = new JComboBox(conge);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("congés")) {
					GestionDesConges a =new GestionDesConges();
					a.frmGestionDesConges.setVisible(true);
				}
				else if(comboBox.getSelectedItem().toString().equals("ordre de mission")) {
					ordre_de_mission b =new ordre_de_mission();
					b.frmOrderDeMission.setVisible(true);
				}
				else if(comboBox.getSelectedItem().toString().equals("Licence Exceptionnel")) {
					LicencesEx c =new LicencesEx();
					c.frmLicencesExceptionnelles.setVisible(true);
				}
				else if(comboBox.getSelectedItem().toString().equals("Absence Non Justifier")) {
					absences_NJ d =new absences_NJ();
					d.frmAbcencesNonJustifiees.setVisible(true);
				}
			}
		});
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setBounds(949, 478, 242, 44);
		frmTableauDeBord.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(224, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(tableau_de_bord.class.getResource("/images/bord2.png")));
		lblNewLabel.setBounds(2, 0, 1342, 699);
		frmTableauDeBord.getContentPane().add(lblNewLabel);
		
		
		
	}
}
