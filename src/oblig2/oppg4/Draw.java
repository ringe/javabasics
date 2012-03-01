package oblig2.oppg4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;

public class Draw {

	private JFrame frmDrawgraph;
	private EqDraw panel;
	private JLabel lblB;
	private JLabel lblC;
	private JLabel lblA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Draw window = new Draw();
					window.frmDrawgraph.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Draw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDrawgraph = new JFrame();
		frmDrawgraph.setTitle("DrawGraph");
		frmDrawgraph.setBounds(100, 100, 450, 500);
		frmDrawgraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDrawgraph.getContentPane().setLayout(new MigLayout("", "[grow][][]", "[][grow,top][bottom]"));
		
		lblA = new JLabel("a = 1");
		frmDrawgraph.getContentPane().add(lblA, "cell 0 0");
		
		lblB = new JLabel("b = 2");
		frmDrawgraph.getContentPane().add(lblB, "cell 1 0");
		
		lblC = new JLabel("c = 5");
		frmDrawgraph.getContentPane().add(lblC, "cell 2 0");
		
		panel = new EqDraw();
		frmDrawgraph.getContentPane().add(panel, "cell 0 1 3 1,grow");
		
		JSlider a = new JSlider(-20, 20, 0);
		a.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider)e.getSource();
				panel.setA(s.getValue());
				lblA.setText("a = " + s.getValue()/10.0);
				panel.repaint();
			}
    		
    	});
		frmDrawgraph.getContentPane().add(a, "cell 0 2");
		
		JSlider b = new JSlider(-20, 20, 0);
		b.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider)e.getSource();
				panel.setB(s.getValue());
				lblB.setText("b = " + s.getValue()/10.0);
				panel.repaint();
			}
    		
    	});
		frmDrawgraph.getContentPane().add(b, "cell 1 2");
		
		JSlider c = new JSlider(-20, 20, 0);
		c.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider)e.getSource();
				panel.setC(s.getValue());
				lblC.setText("c = " + s.getValue()/10.0);
				panel.repaint();
			}
    		
    	});
		frmDrawgraph.getContentPane().add(c, "cell 2 2");
	}

}
