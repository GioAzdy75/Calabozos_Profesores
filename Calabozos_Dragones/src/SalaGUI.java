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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Criaturas.Heroe;
import Criaturas.Criatura;

import java.util.Random;

public class SalaGUI extends JFrame implements ActionListener{
	JLabel label;
	List<Heroe>lista_heroes = new ArrayList<Heroe>();
	List<JLabel> labels_heroes = new ArrayList<JLabel>();
	List<JLabel> labels_esbirros = new ArrayList<JLabel>();
	JLabel labelProfesor = new JLabel();
	
	JPanel heroePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
	JPanel esbirroPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	JPanel jefePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	
	Arena arena;
	
	public SalaGUI(Arena arena){
		
		// Crea un JLabel y configúralo para mostrar la imagen de fondo
        //JLabel backgroundLabel = new JLabel(new ImageIcon("src/fondoMazmorra.jpg"));
        //backgroundLabel.setLayout(new BorderLayout());

		String directorioActual = System.getProperty("user.dir");
		
		this.arena = arena;
		//Panel Heroe
		
		//heroePanel.setBackground(Color.red);
		heroePanel.setBounds(10,100,400,500);
		heroePanel.setOpaque(false); // Hace que el panel sea transparente

		for (Criatura criatura : this.arena.lista_heroes) {
			JLabel label = new JLabel(criatura.getEstadisticasCriatura());
			//Logica Imagen
			ImageIcon imageHeroe = new ImageIcon("src/sprites/"+criatura.imageSrc);
			ImageIcon imagenRedimensionadaIcon = redimensionarImagen(imageHeroe);
			//
			label.setIcon(imagenRedimensionadaIcon);
			heroePanel.add(label);
			labels_heroes.add(label); // Agrega el JLabel a la lista
		}
		
		//Panel Enemigos
		
		//esbirroPanel.setBackground(Color.gray);
		esbirroPanel.setBounds(350,100,250,500);
		
		for (Criatura criatura : this.arena.lista_esbirros) {
			JLabel label = new JLabel(criatura.getEstadisticasCriatura());
			//Logica Imagen
			ImageIcon imageHeroe = new ImageIcon("src/sprites/"+criatura.imageSrc);
			ImageIcon imagenRedimensionadaIcon = redimensionarImagen(imageHeroe);
			//
			label.setIcon(imagenRedimensionadaIcon);
			esbirroPanel.add(label);
			labels_esbirros.add(label); // Agrega el JLabel a la lista
		}
		
		//Panel Jefe
		jefePanel.setBackground(Color.green);
		jefePanel.setBounds(580,50,190,100);
		labelProfesor.setText(arena.profesor.getEstadisticasCriatura());
		ImageIcon imageProfesor = new ImageIcon("src/sprites/"+arena.profesor.imageSrc);
		ImageIcon imagenRedimensionadaIcon = redimensionarImagen(imageProfesor);
		labelProfesor.setIcon(imagenRedimensionadaIcon);
		
        // Configura la posición vertical y horizontal del texto
		labelProfesor.setVerticalTextPosition(SwingConstants.BOTTOM);
		labelProfesor.setHorizontalTextPosition(SwingConstants.CENTER);
		jefePanel.add(labelProfesor);
		
        this.setResizable(false);
		this.add(jefePanel);
		//this.setContentPane(backgroundLabel);
		this.add(heroePanel);
		this.add(esbirroPanel);
		this.setLayout(null);
		this.setSize(800,650);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		if (e.getSource() == buttonAtaqueMele) {
		}
		*/
	}
	
	private ImageIcon redimensionarImagen(ImageIcon image) {
		// Obtener la imagen de ImageIcon
		Image imagenOriginal = image.getImage();

		// Redimensionar la imagen a un tamaño específico
		int nuevoAncho = 50; // Cambia esto al ancho deseado
		int nuevoAlto = 50; // Cambia esto al alto deseado
		Image imagenRedimensionada = imagenOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

		// Crear un ImageIcon a partir de la imagen redimensionada
		ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);

		return imagenRedimensionadaIcon;
	}
	
	// Método para actualizar los valores de los JLabels
    public void actualizarGUI() {
    	

        //Actualizar Heroes
        for (JLabel label : labels_heroes) {
        	heroePanel.remove(label);
        }
        labels_heroes.clear();
        for (Criatura criatura : this.arena.lista_heroes) {
			JLabel label = new JLabel(criatura.getEstadisticasCriatura());
			//Logica Imagen
			ImageIcon imageHeroe = new ImageIcon("src/sprites/"+criatura.imageSrc);
			ImageIcon imagenRedimensionadaIcon = redimensionarImagen(imageHeroe);
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
        for (Criatura criatura : this.arena.lista_esbirros) {
			JLabel label = new JLabel(criatura.getEstadisticasCriatura());
			//Logica Imagen
			ImageIcon imageHeroe = new ImageIcon("src/sprites/"+criatura.imageSrc);
			ImageIcon imagenRedimensionadaIcon = redimensionarImagen(imageHeroe);
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
    
    public void cerrarVentana() {
        dispose(); // Cierra la ventana
    }
}
