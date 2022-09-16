package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.JTextComponent;

import controller.PesquisasController;
import model.Partidos;
import model.Pesquisas;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisaUI extends JInternalFrame {
	private JTextField txtdata;
	private JTextField txtcidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaUI frame = new PesquisaUI();
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
	public PesquisaUI() {
		setTitle("Cadastro da pesquisa");
		setBounds(100, 100, 354, 379);
		
		txtdata = new JTextField();
		txtdata.setColumns(10);
		
		JComboBox cmbestados = new JComboBox();
		cmbestados.setModel(new DefaultComboBoxModel(new String[] {"Selecione a UF...", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"}));
		
		JLabel lblNewLabel = new JLabel("Data da pesquisa");
		
		JLabel lblCargo = new JLabel("Cargo");
		
		JComboBox cmbcargo = new JComboBox();
		cmbcargo.setModel(new DefaultComboBoxModel(new String[] {"Selecione o cargo...", "1 Presidente", "2 Senador", "3 Deputado Federal", "4 Deputado Estadual"}));
		
		JLabel lblEstado = new JLabel("Estado");
		
		txtcidade = new JTextField();
		txtcidade.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		
		JButton btcancelar = new JButton("Cancelar");
		btcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btgravar = new JButton("Gravar");
		btgravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pesquisas pesquisas = new Pesquisas();
				pesquisas.setCidade(txtcidade.getText());
				pesquisas.setDataPesquisa(txtdata.getText());
				//pesquisas.setId_Vaga_fk(((JTextComponent) cmbcargo).getText());
				
				try {
					new PesquisasController().salvar(pesquisas);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(txtdata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCargo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtcidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btgravar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btcancelar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addComponent(cmbcargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbestados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtdata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCidade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtcidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCargo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbcargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEstado)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbestados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btcancelar)
						.addComponent(btgravar))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
