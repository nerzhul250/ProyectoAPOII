package mundo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Region implements Dibujable,Comparable,Serializable {
	
	/**
	 * El area de la region
	 */
	private double area;
	/**
	 * El color de la region
	 */
	private Color color;
	/**
	 * Los puntos que definen a la region
	 */
	private ArrayList<Punto>frontera;
	/**
	 * Construye una nueva region
	 * @param fr la lista de puntos que definen a la region
	 * @param color
	 */
	public Region(ArrayList<Punto> fr,Color color){
		frontera=fr;
		double sum=0;
		for (int i = 2; i < frontera.size(); i++) {
			double ux=frontera.get(0).getX()-frontera.get(i).getX();
			double uy=frontera.get(0).getY()-frontera.get(i).getY();
			double vx=frontera.get(0).getX()-frontera.get(i-1).getX();
			double vy=frontera.get(0).getY()-frontera.get(i-1).getY();
			sum+=ux*vy-vx*uy;
		}
		sum=sum/2;
		area=Math.abs(sum);
		this.color=color;
	}
	/**
	 * Dibuja la region en el plano XY
	 */
	public void dibujarse(Graphics2D g2d, double alcance, double traslY,
			double traslX, int ancho) {
		g2d.setColor(getColor());
		int n=frontera.size();
		int[] w=new int[n];
		int[] h=new int[n];
		for (int i = 0; i < frontera.size(); i++) {
			w[i]=(int) ((frontera.get(i).getX()+alcance-traslX)*(MathyGen.ANCHOPLANO)/(2*alcance));
			h[i]=(int) ((alcance+traslY-frontera.get(i).getY())*(MathyGen.LARGOPLANO)/(2*alcance));
		}
		g2d.fillPolygon(w,h,n);
	}
	/**
	 * Compara dos regiones por su area
	 */
	public int compareTo(Object o) {
		Region r=(Region)o;
		double dif=area-r.getArea();
		if(dif!=0){
			dif=(dif<0)?-1:1;
		}
		return (int)dif;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String area(){
		DecimalFormat df=new DecimalFormat("0.00");
		return df.format(area);
	}
	@Override
	public String toString() {
		DecimalFormat df=new DecimalFormat("0.00");
		return "Region con area: "+df.format(area);
	}
} 