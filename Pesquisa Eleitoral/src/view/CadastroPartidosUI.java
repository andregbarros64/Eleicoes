package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.CandidatosController;
import controller.PartidosController;
import model.Candidatos;
import model.Partidos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroPartidosUI extends JInternalFrame {
	private JTextField txtnomepartido;
	private JTextField txtpartido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPartidosUI frame = new CadastroPartidosUI();
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
	public CadastroPartidosUI() {
		setBounds(100, 100, 428, 243);
		
		txtnomepartido = new JTextField();
		txtnomepartido.setText("");
		txtnomepartido.setColumns(10);
		
		txtpartido = new JTextField();
		txtpartido.setText("");
		txtpartido.setColumns(10);
		
		JButton btcancelar = new JButton("Cancelar");
		btcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btgravar = new JButton("Gravar");
		btgravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partidos partidos = new Partidos();
				
				partidos.setNumPartido(Integer.parseInt(txtpartido.getText()));
				partidos.setNomePartido(txtnomepartido.getText());
				
				try {
					new PartidosController().salvar(partidos);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("N. Partido");
		
		JLabel lblNomeDoPartido = new JLabel("Nome do partido");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(txtpartido, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeDoPartido, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtnomepartido, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(188, Short.MAX_VALUE)
					.addComponent(btgravar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btcancelar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNomeDoPartido)
					.addGap(8)
					.addComponent(txtnomepartido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btgravar)
						.addComponent(btcancelar))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
