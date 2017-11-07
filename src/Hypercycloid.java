import java.awt.Color;
import java.util.Random;

public class Hypercycloid {
	Circle inner_circ, outer_circ;
	Position pen_position;
	Random r;
	
	public Hypercycloid(Circle outer, Circle inner, Position pen_position) {
		this.outer_circ = outer;
		this.inner_circ = inner;
		this.pen_position = pen_position;
		this.r = new Random(5);
	}
	
	public Double getX(Double t) {
		return ((outer_circ.radius + inner_circ.radius) * Math.cos(t) - (inner_circ.radius + pen_position.x)*Math.cos(((outer_circ.radius + inner_circ.radius)/inner_circ.radius)*t));
	}
	
	public Double getY(Double t) {
		return ((outer_circ.radius + inner_circ.radius) * Math.sin(t) - (inner_circ.radius + pen_position.x)*Math.sin(((outer_circ.radius + inner_circ.radius)/inner_circ.radius)*t));
	}
	
	public void setInnerRadius(int radius){
		this.inner_circ.radius = radius;
	}
	
	public void setOuterRadius(int radius){
		this.outer_circ.radius = radius;
	}
	
	public void setPenPos(Double pos){
		this.pen_position.x = pos;
	}
	
	public Color getColor(Double t){
		return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
}
