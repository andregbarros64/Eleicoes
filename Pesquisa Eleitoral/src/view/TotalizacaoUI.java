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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollBar;

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
		setBounds(100, 100, 546, 393);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{106, 271, 115, 0, 0};
		gridBagLayout.rowHeights = new int[]{177, 110, 32, 29, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btcancelar = new JButton("Fechar");
		btcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		jTotalizacao = new JTable();
		jTotalizacao.setModel(new ConsultaPesquisaTableModel(new PesquisasQuestionariosController().listar()));
		GridBagConstraints gbc_jTotalizacao = new GridBagConstraints();
		gbc_jTotalizacao.gridheight = 2;
		gbc_jTotalizacao.fill = GridBagConstraints.BOTH;
		gbc_jTotalizacao.insets = new Insets(0, 0, 5, 5);
		gbc_jTotalizacao.gridwidth = 3;
		gbc_jTotalizacao.gridx = 0;
		gbc_jTotalizacao.gridy = 0;
		getContentPane().add(jTotalizacao, gbc_jTotalizacao);
		
		JScrollBar scrollBar = new JScrollBar();
		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
		gbc_scrollBar.gridheight = 2;
		gbc_scrollBar.insets = new Insets(0, 0, 5, 0);
		gbc_scrollBar.gridx = 3;
		gbc_scrollBar.gridy = 0;
		getContentPane().add(scrollBar, gbc_scrollBar);
		
		JButton bttotalizar = new JButton("Totalizar");
		GridBagConstraints gbc_bttotalizar = new GridBagConstraints();
		gbc_bttotalizar.anchor = GridBagConstraints.NORTHEAST;
		gbc_bttotalizar.insets = new Insets(0, 0, 0, 5);
		gbc_bttotalizar.gridx = 1;
		gbc_bttotalizar.gridy = 3;
		getContentPane().add(bttotalizar, gbc_bttotalizar);
		GridBagConstraints gbc_btcancelar = new GridBagConstraints();
		gbc_btcancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btcancelar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btcancelar.gridx = 2;
		gbc_btcancelar.gridy = 3;
		getContentPane().add(btcancelar, gbc_btcancelar);

	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
