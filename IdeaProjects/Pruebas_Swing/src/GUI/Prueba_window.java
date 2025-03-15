package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prueba_window extends JFrame {

	private JFrame frame;
	private JTextField hueco;
	private JTextField hueco2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Prueba_window window = new Prueba_window();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Prueba_window() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel contenedor = new JLabel("Contenedor");
		contenedor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contenedor.setBounds(149, 23, 91, 29);
		frame.getContentPane().add(contenedor);
		
		JLabel texto_1 = new JLabel("Ingrese un texto");
		texto_1.setBounds(26, 65, 81, 20);
		frame.getContentPane().add(texto_1);
		
		JLabel texto_1_1 = new JLabel("texto");
		texto_1_1.setBounds(26, 131, 81, 20);
		frame.getContentPane().add(texto_1_1);
		
		hueco = new JTextField();
		hueco.setBounds(21, 96, 86, 20);
		frame.getContentPane().add(hueco);
		hueco.setColumns(10);
		
		JButton boton = new JButton("copiar");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hueco2.setText(hueco.getText());
			}
		});
		boton.setBounds(202, 64, 89, 23);
		frame.getContentPane().add(boton);
		
		hueco2 = new JTextField();
		hueco2.setColumns(10);
		hueco2.setBounds(26, 173, 86, 20);
		frame.getContentPane().add(hueco2);
	}
}
