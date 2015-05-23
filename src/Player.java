import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;

public class Player extends Cell {

	public Player(int theRadius, Point theLocation) {
		super(theRadius, theLocation);
	}
	
	public void moveAndDraw(Graphics2D g2d)
	{
		g2d.setColor(new Color(0,0,0,0)); //paints w/ background color to erase
		g2d.fillOval((int) super.getLocation().getX() - super.getRadius(), (int) super.getLocation().getY() - super.getRadius(), super.getRadius() * 2, super.getRadius() * 2); //erases current oval
		
		super.setLocation(super.getNewLocation());
		super.setNewLocation(super.getLocation());
		
		g2d.setColor(super.getColor());
		g2d.fillOval((int) super.getLocation().getX() - super.getRadius(), (int) super.getLocation().getY() - super.getRadius(), super.getRadius() * 2, super.getRadius() * 2); //draws new oval
		
		String name = new String("Amorba!!!");
		AffineTransform affinetransform = new AffineTransform();    
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);    
		
		if((0.2126*getColor().getRed() + 0.7152*getColor().getGreen() + 0.0722*getColor().getBlue()) < 150){
			g2d.setColor(Color.WHITE);
		}
		else{
			g2d.setColor(Color.BLACK);
		}
		Font font = new Font("Trebuchet MS", Font.PLAIN, (int) (this.getRadius()*0.4));
		int textwidth = (int)(font.getStringBounds(name, frc).getWidth());
		int textheight = (int)(font.getStringBounds(name, frc).getHeight());
		g2d.setFont(font);
		g2d.drawString(name,(int)this.getLocation().getX()-(textwidth/2),(int)this.getLocation().getY()+(textheight/4));
		
	}
}
