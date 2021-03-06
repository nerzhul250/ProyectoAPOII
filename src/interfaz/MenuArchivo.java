package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuArchivo extends JMenu implements ActionListener{	
	/**
	 * Constante de guardar
	 */
	public final static String GUARDAR="GUARDAR";
	/**
	 * Constante de buscar region
	 */
	public final static String BUSCAR_REGION="BRA";
	/**
	 * Item buscar region
	 */
	private JMenuItem buscarRegion;

	/***
	 * Item de guardar
	 */
	private JMenuItem meitGuardar;
	/**
	 * ventana principal
	 */

	private InterfazMathy principal;
	
	/**
	 * Construye el menu de archivo
	 * @param ventana
	 */
	public MenuArchivo(InterfazMathy ventana) {
		super("Archivo");
		
		principal = ventana;
		
		meitGuardar  = new JMenuItem("Guardar estado");		
		meitGuardar.addActionListener(this);
		meitGuardar.setActionCommand(GUARDAR);
		
		buscarRegion  = new JMenuItem("Buscar regi�n");		
		buscarRegion.addActionListener(this);
		buscarRegion.setActionCommand(BUSCAR_REGION);

		add(meitGuardar);
		add(buscarRegion);
	}
	/**
	 * ACTIONPERFORMED, guarda en resumen
	 */
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(GUARDAR)){
			principal.guardarArchivo();;
		}else if(comando.equals(BUSCAR_REGION)){
			principal.buscarRegion();
		}
	}
}
