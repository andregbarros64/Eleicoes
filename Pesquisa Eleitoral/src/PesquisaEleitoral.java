import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class PesquisaEleitoral extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaEleitoral frame = new PesquisaEleitoral();
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
	public PesquisaEleitoral() {
		setTitle("Pesquisa Eleitoral - Presidente - 2022");
		setBounds(100, 100, 450, 527);

	}

}
