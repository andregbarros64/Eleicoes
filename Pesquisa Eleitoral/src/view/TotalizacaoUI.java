package view;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.PesquisasQuestionariosController;
import view.tables.ConsultaPesquisaTableModel;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class TotalizacaoUI extends JInternalFrame {
	private JTable jTotalizacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalizacaoUI frame = new TotalizacaoUI();
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
	public TotalizacaoUI() {
		setTitle("Totalização da pesquisa");
		setBounds(100, 100, 596, 429);
		
		JButton bttotalizar = new JButton("Totalizar");
		
		JButton btcancelar = new JButton("Fechar");
		btcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		jTotalizacao = new JTable();
		jTotalizacao.setModel(new ConsultaPesquisaTableModel(new PesquisasQuestionariosController().listar()));
		//scrollPane.setViewportView(jTotalizacao);
		//getContentPane().setLayout(groupLayout);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(279)
					.addComponent(bttotalizar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btcancelar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(91, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(87, Short.MAX_VALUE)
					.addComponent(jTotalizacao, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(jTotalizacao, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btcancelar)
						.addComponent(bttotalizar))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}

}
