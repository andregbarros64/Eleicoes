package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.CandidatosController;
import model.Candidatos;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCandidatosUI extends JInternalFrame {
	private JTextField txtnomecandidato;
	private JTextField txtcidade;
	private JTextField txtnumero;
	protected String cmbuf;
	private JTextField txtUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCandidatosUI frame = new CadastroCandidatosUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroCandidatosUI() {
		setTitle("Cadastro de candidatos");
		setBounds(100, 100, 432, 358);
		
		JButton btcancelar = new JButton("Cancelar");
		btcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btgravar = new JButton("Gravar");
		btgravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Candidatos candidatos = new Candidatos();
				candidatos.setCidadeCandidato(txtnomecandidato.getText());
				candidatos.setEstadoCandidato(txtUF.getText());
				candidatos.setNumCandidato(Integer.parseInt(txtnumero.getText()));
				candidatos.setCidadeCandidato(txtcidade.getText());
				
				try {
					new CandidatosController().salvar(candidatos);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao salvar cadastro do candidato");
				}
			}
		});
		
		txtnomecandidato = new JTextField();
		txtnomecandidato.setColumns(10);
		
		txtcidade = new JTextField();
		txtcidade.setColumns(10);
		
		txtnumero = new JTextField();
		txtnumero.setColumns(10);
		
		JComboBox cmbnumpartido = new JComboBox();
		
		JLabel lblNewLabel = new JLabel("Cidade");
		
		JLabel lblUf = new JLabel("UF");
		
		JLabel lblPartido = new JLabel("Partido");
		
		JLabel lblNmero = new JLabel("Número");
		
		JLabel lblNomeDoCandidato = new JLabel("Nome do candidato");
		
		txtUF = new JTextField();
		txtUF.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btgravar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btcancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNomeDoCandidato, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtnomecandidato)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtcidade, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(cmbnumpartido, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addComponent(txtUF, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
													.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addGap(6)
														.addComponent(lblNmero, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
											.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(txtnumero, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPartido, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
										.addComponent(lblUf, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
									.addGap(156))
								.addComponent(lblNewLabel))))
					.addGap(39))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNomeDoCandidato)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtnomecandidato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtcidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUf)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtUF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNmero)
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbnumpartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtnumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblPartido))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btcancelar)
						.addComponent(btgravar))
					.addContainerGap(9, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
