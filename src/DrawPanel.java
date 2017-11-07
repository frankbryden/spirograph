import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	Hypercycloid hp;
	
	public DrawPanel(Hypercycloid hp){
		this.update(hp);
	}
	
	public void update(Hypercycloid hp){
		this.hp = hp;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
	
		for (Double t = 0.0; t < 100; t = t + 0.01) {
			Ellipse2D.Double circle = new Ellipse2D.Double(hp.getX(t) + hp.outer_circ.position.x, hp.getY(t) + hp.outer_circ.position.y, 3, 3);
			g2d.setColor(hp.getColor(t));
			g2d.fill(circle);
		}
	}
	
	
}
