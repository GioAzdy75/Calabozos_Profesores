import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Cartas.Carta;
import Criaturas.Heroe;
import Criaturas.Heroes.Arquero;
import Criaturas.Heroes.Luchador;
import Criaturas.Heroes.Mago;
import Criaturas.Criatura;

import java.util.Random;

public class SalaGUI extends JFrame implements ActionListener{
	JLabel label;
	List<Criatura>lista_heroes = new ArrayList<Criatura>();
	List<JLabel> labels_heroes = new ArrayList<JLabel>();
	List<JLabel> labels_esbirros = new ArrayList<JLabel>();
	JLabel labelProfesor = new JLabel();
	
	JPanel heroePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
	JPanel esbirroPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
	JPanel jefePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	JPanel cartaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
	
	private HashImagenesSrc hashimagenes = new HashImagenesSrc();
	List<String> listaRutaImagenes;
	
	
	Sala sala;
	List<Carta> cartas;
	
	public SalaGUI(Sala sala,List<Criatura>lista_heroes,List<Carta>cartas){
		
		// Crea un JLabel y configúralo para mostrar la imagen de fondo
        //JLabel backgroundLabel = new JLabel(new ImageIcon("src/fondoMazmorra.jpg"));
        //backgroundLabel.setLayout(new BorderLayout());
		
		this.lista_heroes = lista_heroes;
		this.sala = sala;
		this.cartas = cartas;
		this.listaRutaImagenes = hashimagenes.get(sala.getTipoSala());
		
		//Panel Heroe
		
		//heroePanel.setBackground(Color.red);
		heroePanel.setBounds(1,20,450,400);
		heroePanel.setOpaque(false); // Hace que el panel sea transparente
		Border borde = BorderFactory.createLineBorder(Color.RED, 2);
	        
	     // Aplica el borde al JPanel
		heroePanel.setBorder(borde);
		for (Criatura criatura : lista_heroes) {
			JLabel label = new JLabel(criatura.getEstadisticasCriatura());
			//Logica Imagen
			ImageIcon imageHeroe = new ImageIcon(heroeSrc(criatura));
			ImageIcon imagenRedimensionadaIcon = redimensionarImagen(imageHeroe,80,80);
			//
			label.setIcon(imagenRedimensionadaIcon);
			heroePanel.add(label);
			labels_heroes.add(label); // Agrega el JLabel a la lista
		}
		
		//Panel Enemigos
		
		//esbirroPanel.setBackground(Color.gray);
		esbirroPanel.setBounds(450,20,200,400);
		esbirroPanel.setBorder(borde);
		for (Criatura criatura : this.sala.lista_esbirros) {
			JLabel label = new JLabel(criatura.getEstadisticasCriatura());
			//Logica Imagen
			ImageIcon imageHeroe = new ImageIcon(listaRutaImagenes.get(0));
			
			ImageIcon imagenRedimensionadaIcon = redimensionarImagen(imageHeroe,50,50);
			//
			label.setIcon(imagenRedimensionadaIcon);
			esbirroPanel.add(label);
			labels_esbirros.add(label); // Agrega el JLabel a la lista
		}
		
		//Panel Jefe
		//jefePanel.setBackground(Color.green);
		jefePanel.setBounds(650,20,200,300);
		jefePanel.setBorder(borde);
		labelProfesor.setText(sala.profesor.getEstadisticasCriatura());
		ImageIcon imageProfesor = new ImageIcon(listaRutaImagenes.get(1));
		ImageIcon imagenRedimensionadaIcon = redimensionarImagen(imageProfesor,100,150);
		labelProfesor.setIcon(imagenRedimensionadaIcon);
		
        // Configura la posición vertical y horizontal del texto
		labelProfesor.setVerticalTextPosition(SwingConstants.BOTTOM);
		labelProfesor.setHorizontalTextPosition(SwingConstants.CENTER);
		jefePanel.add(labelProfesor);
		
		
		//Panel Cartas
		cartaPanel.setBounds(50,430,700,120);
		cartaPanel.setBorder(borde);
		int i = 1;
		for (Carta carta : this.cartas) {
			JLabel label = new JLabel("|"+i+"|"+carta.getNombre()+"			|");
			ImageIcon imageCarta = new ImageIcon("src/SPRITES/Carta.jpg");
			ImageIcon imagenRedimensionadaIcon1 = redimensionarImagen(imageCarta,40,40);
			label.setVerticalTextPosition(SwingConstants.BOTTOM);
			label.setHorizontalTextPosition(SwingConstants.CENTER);
			label.setIcon(imagenRedimensionadaIcon1);
			cartaPanel.add(label);
			i++;
		}
		
		//Imprimir Cartas
		
		this.add(cartaPanel);
        this.setResizable(false);
		this.add(jefePanel);
		//this.setContentPane(backgroundLabel);
		this.add(heroePanel);
		this.add(esbirroPanel);
		this.setLayout(null);
		this.setSize(900,600);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		if (e.getSource() == buttonAtaqueMele) {
		}
		*/
	}
	
	/**
	 * Metodo para redimensionar la imagen a un tamaño establecido de 50x50
	 * @param image : ImageIcon 
	 * @return ImageIcon : con el tamaño establecido
	 */
	private ImageIcon redimensionarImagen(ImageIcon image,int ancho,int largo) {
		// Obtener la imagen de ImageIcon
		Image imagenOriginal = image.getImage();

		// Redimensionar la imagen a un tamaño específico
		Image imagenRedimensionada = imagenOriginal.getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);

		// Crear un ImageIcon a partir de la imagen redimensionada
		ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);

		return imagenRedimensionadaIcon;
	}
	
	/**
	 * Actualiza los Jlabel de la interfaz grafica con las nuevas estadisticas
	 */
    public void actualizarGUI() {
        //Actualizar Heroes
        for (JLabel label : labels_heroes) {
        	heroePanel.remove(label);
        }
        labels_heroes.clear();
        for (Criatura criatura : lista_heroes) {
			JLabel label = new JLabel(criatura.getEstadisticasCriatura());
			//Logica Imagen
			ImageIcon imageHeroe = new ImageIcon(heroeSrc(criatura));
			ImageIcon imagenRedimensionadaIcon = redimensionarImagen(imageHeroe,80,80);
			//
			label.setIcon(imagenRedimensionadaIcon);
			heroePanel.add(label);
			labels_heroes.add(label); // Agrega el JLabel a la lista
		}
        
        //Actualizar Esbirros
        for (JLabel label : labels_esbirros) {
        	esbirroPanel.remove(label);
        }
        labels_esbirros.clear();
        for (Criatura criatura : this.sala.lista_esbirros) {
			JLabel label = new JLabel(criatura.getEstadisticasCriatura());
			//Logica Imagen
			ImageIcon imageHeroe = new ImageIcon(listaRutaImagenes.get(0));
			ImageIcon imagenRedimensionadaIcon = redimensionarImagen(imageHeroe,50,50);
			//
			label.setIcon(imagenRedimensionadaIcon);
			esbirroPanel.add(label);
			labels_esbirros.add(label); // Agrega el JLabel a la lista
		}
        
        heroePanel.revalidate();
        heroePanel.repaint();
        esbirroPanel.revalidate();
        esbirroPanel.repaint();
    }
    
    /**
     * Metodo para cerrar la ventana
     */
    public void cerrarVentana() {
        dispose(); // Cierra la ventana
    }

    
    private String heroeSrc(Object objeto) {
    	if (objeto instanceof Luchador) {
    		return hashimagenes.get("Heroes").get(0);
    	}
    	else if (objeto instanceof Arquero){
    		return hashimagenes.get("Heroes").get(1);
    	}
    	
    	else if (objeto instanceof Mago){
    		return hashimagenes.get("Heroes").get(2);
    	}
    	else {
    		return "";
    	}
    }
}
