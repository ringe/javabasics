package oblig2.oppg4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.QuadCurve2D;

import javax.swing.JPanel;

public class EqDraw extends JPanel {
	private static final long serialVersionUID = 1L;
	private double a;
	private double b;
	private double c;

	public EqDraw() {
		a=1;b=2;c=5;
	}

	public void setA(int na) {
		a = na / 10.0;
	}
	public void setB(int nb) { 
		b = nb / 10.0;

	}
	public void setC(int nc) { 
		c = nc / 10.0; 
	}

	private double[] setPos() {
		// Topp- eller bunnpunkt av ax²+bx+c er 2ax+b=0 dvs x=-b/2a
		double x = -b/2*a;
		// y = ax² + bx + c
		double y = a*x*x + b*x + c;

		// Koordinater, skalerte
		double[] out = {0, 0, x*50, y*50, x*100, 0.0};

		return out;
	}

	protected void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		QuadCurve2D curve = new QuadCurve2D.Double();
		double[] pos = setPos();
		curve.setCurve(pos,0);
		g2.translate(200, 200);
		g2.draw(curve);
	}
}