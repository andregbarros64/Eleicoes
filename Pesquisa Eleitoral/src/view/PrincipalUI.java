package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
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
	public PrincipalUI() {
		setTitle("Pesquisa Eleitoral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 517);
		
		JMenuBar jbPrincipal = new JMenuBar();
		setJMenuBar(jbPrincipal);
		
		JMenu jmcadastros = new JMenu("Cadastros");
		jbPrincipal.add(jmcadastros);
		
		JMenuItem jmipartidos = new JMenuItem("Partidos");
		jmipartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPartidosUI cadPartido = new CadastroPartidosUI();
				cadPartido.setVisible(true);
				contentPane.add(cadPartido,0);
			}
		});
		
		JMenuItem mnipesquisas = new JMenuItem("Pesquisas");
		mnipesquisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisaUI cadPesquisa = new PesquisaUI();
				cadPesquisa.setVisible(true);
				contentPane.add(cadPesquisa,0);				
			}
		});
		jmcadastros.add(mnipesquisas);
		jmcadastros.add(jmipartidos);
		
		JMenuItem jmicandidatos = new JMenuItem("Candidatos");
		jmicandidatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCandidatosUI cadCandidato = new CadastroCandidatosUI();
				cadCandidato.setVisible(true);
				contentPane.add(cadCandidato,0);
			}
		});
		jmcadastros.add(jmicandidatos);
		
		JMenu jmpesquisa = new JMenu("Pesquisa");
		jbPrincipal.add(jmpesquisa);
		
		JMenuItem jmipequisa = new JMenuItem("Iniciar pesquisa");
		jmipequisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisasQuestionarioUI cadPesquisaQuestionario = new PesquisasQuestionarioUI();
				cadPesquisaQuestionario.setVisible(true);
				contentPane.add(cadPesquisaQuestionario,0);	
			}
		});
		jmpesquisa.add(jmipequisa);
		
		JMenu jmtotalizacao = new JMenu("Totalização");
		jbPrincipal.add(jmtotalizacao);
		
		JMenuItem jmitotalizacao = new JMenuItem("Relatório de totalização");
		jmitotalizacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TotalizacaoUI cadTotalizacao = new TotalizacaoUI();
				cadTotalizacao.setVisible(true);
				contentPane.add(cadTotalizacao,0);	
			}
		});
		jmtotalizacao.add(jmitotalizacao);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 805, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 457, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
