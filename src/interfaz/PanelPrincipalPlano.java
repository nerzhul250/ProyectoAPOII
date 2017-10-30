package interfaz;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import mundo.Funcion;
import mundo.MathyGen;
import mundo.Punto;

public class PanelPrincipalPlano extends JPanel{
	private PanelPlanoxy ppxy;
	private PanelObjetoDibujable pod;
	public PanelPrincipalPlano(InterfazMathy in, MathyGen mundo){
		setLayout(new BorderLayout());
		ppxy=new PanelPlanoxy(in);
		pod=new PanelObjetoDibujable(in);
		
		add(pod,BorderLayout.WEST);
		add(ppxy,BorderLayout.EAST);
	}
	
	public void agregarFuncion(Funcion fun) {
		pod.agregarFuncion(fun);
	}
	public void agregarPunto(Punto punto) {
		pod.agregarPunto(punto);
	}
	public void refrescarPlano() {
		ppxy.repaint();;
	}
}
