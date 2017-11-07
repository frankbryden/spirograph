import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DrawFrame extends JFrame implements ChangeListener{
	Hypercycloid hp;
	JSlider inner_radius, outer_radius, pen_pos;
	DrawPanel drawPanel;
	
	public DrawFrame() {
		super();
		int width = 2048;
		int height = 1000;
		this.setSize(width, height);
		
		inner_radius = new JSlider(JSlider.HORIZONTAL, -150, width/2, height/2);
		outer_radius = new JSlider(JSlider.HORIZONTAL, -150, width/2, height/2);
		pen_pos = new JSlider(JSlider.HORIZONTAL, -150, 150, 50);
		
		inner_radius.addChangeListener(this);
		outer_radius.addChangeListener(this);
		pen_pos.addChangeListener(this);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		this.add(inner_radius);
		this.add(outer_radius);
		this.add(pen_pos);
		
		Circle inner = new Circle(20, new Position(250.0, 250.0));
		Circle outer = new Circle(80, new Position(200.0, 250.0));
		Position pen_position = new Position(100.0, 10.0);
		hp = new Hypercycloid(outer, inner, pen_position);
		
		JFrame frame = new JFrame();
		drawPanel = new DrawPanel(hp);
		this.add(drawPanel);
	}
	
	public void stateChanged(ChangeEvent e){
		JSlider source = (JSlider) e.getSource();
		if (source.equals(inner_radius)){
			changeRadiusInner(source);
		} else if (source.equals(outer_radius)){
			changeRadiusOuter(source);
		} else if (source.equals(pen_pos)){
			changePenPos(source);
		}
		drawPanel.repaint();
	}
	
	public void changeRadiusInner(JSlider source){
		hp.setInnerRadius(source.getValue());
	}
	
	public void changeRadiusOuter(JSlider source){
		hp.setOuterRadius(source.getValue());
	}
	
	public void changePenPos(JSlider source){
		hp.setPenPos(new Double(source.getValue()));
	}
	
	
}