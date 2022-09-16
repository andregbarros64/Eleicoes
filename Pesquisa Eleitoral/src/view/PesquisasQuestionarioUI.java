package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.PesquisasController;
import model.Pesquisas;
import model.PesquisasQuestionarios;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisasQuestionarioUI extends JInternalFrame {
	private JTextField txtcpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisasQuestionarioUI frame = new PesquisasQuestionarioUI();
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
	public PesquisasQuestionarioUI() {
		setTitle("Questionário de pesquisa");
		setBounds(100, 100, 326, 436);
		
		txtcpf = new JTextField();
		txtcpf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF");
		
		JLabel lblPesquisaPara = new JLabel("Pesquisa para:");
		
		JComboBox cmbpesquisa = new JComboBox();
		cmbpesquisa.setModel(new DefaultComboBoxModel(new String[] {"Selecione ...", "Presidente", "Senador", "Deputado Federal", "Deputado Estadual"}));
		
		JComboBox cmbepesquisapara = new JComboBox();
		
		JLabel lblPesquisaPara_1 = new JLabel("Pesquisa para:");
		
		JButton btgravar = new JButton("Gravar");
		btgravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PesquisasQuestionarios pesquisasQuestionarios = new PesquisasQuestionarios();
				pesquisasQuestionarios.setCpfEleitor(txtcpf.getText());
				
				try {
					new PesquisasController().salvar(null);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar");
				}
				
			}
		});
		
		JButton btcancelar = new JButton("Cancelar");
		btcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JComboBox cmbcandidato = new JComboBox();
		
		JLabel lblcandidato = new JLabel("Candidato");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cmbcandidato, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btgravar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btcancelar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblcandidato, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPesquisaPara_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbepesquisapara, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtcpf, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(cmbpesquisa, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPesquisaPara))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblPesquisaPara)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cmbpesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtcpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(lblPesquisaPara_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cmbepesquisapara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblcandidato)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbcandidato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btgravar)
						.addComponent(btcancelar))
					.addContainerGap(277, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
