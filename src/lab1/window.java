package lab1;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import widgets.Diagram;
import widgets.ChooseRandom;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import widgets.ChooseData;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import stat.Histo;
import javax.swing.JTextArea;

public class window extends JFrame {

	private JPanel contentPane;
	private ChooseData chooseData;
	private Diagram diagram;
	/**
	 * @wbp.nonvisual location=423,289
	 */
	private final Histo histo = new Histo();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window frame = new window();
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
	public window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		diagram = new Diagram();
		diagram.setBounds(5, 5, 247, 206);
		contentPane.add(diagram);
		
		JButton button = new JButton("\u041E\u0442\u0440\u0438\u043C\u0430\u0442\u0438 \u0433\u0456\u0441\u0442\u043E\u0433\u0440\u0430\u043C\u0443");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBounds(150, 269, 155, 23);
		contentPane.add(button);
		
		chooseData = new ChooseData();
		chooseData.setBounds(150, 222, 155, 46);
		contentPane.add(chooseData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 5, 247, 206);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	
	public void onClick() {
		// TODO Auto-generated method stub
	    int a=chooseData.getInt();
	    
	    histo.init();
	    for(int i=0;i<a;i++) 
	      histo.add(Math.random());

	    histo.showRelFrec(diagram);
	    textArea.setText(histo.toString());
	}
}
