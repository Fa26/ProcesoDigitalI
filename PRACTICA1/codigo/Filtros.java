/**
*@author Venegas Guerrero Fatima Alejandra
*@version 1.0
*Clase principal de los Filtros
**/

import javax.swing.*;
import java.awt.Graphics;


public class Filtros{


	public void menu(){
		String[] pintar={"Azul","Verde",
						"Rojo","Gris",
						"Amarillo","Rosa",
						"AguaMarino","Gris1",
						"Gris2","Gris3","Gris4",
						"AltoConstrante","Inverso",
						"Brillo","Mosaico"};
		JFrame frame = new JFrame("R,G,B");
		String colores=(String)JOptionPane.showInputDialog(frame,
			"Elige una opcion",
			"Colores",
			JOptionPane.QUESTION_MESSAGE,
			null,
			pintar,
			pintar[0]);
		if(colores.equals("Verde")){
			Verdoza g = new Verdoza();
			g.ventanR();
		}if(colores.equals("Rojo")){
			Rojiza r = new Rojiza();
			r.ventanaRo();
		}if(colores.equals("Azul")){
			Azuloza a = new Azuloza();
			a.ventanaAz();
		}if(colores.equals("Azar")){
			//Azar az= new Azar();
			//az.ventanaR();
		}if(colores.equals("Amarillo")){
			Constante c = new Constante();
			c.ventanaAma();
		}if(colores.equals("Gris")){
			GrisU g = new GrisU();
			g.ventanaG();
		}if(colores.equals("Rosa")){
			Rosa ro= new Rosa();
			ro.ventanaPink();
		}if(colores.equals("AguaMarino")){
			AzulClaro z = new AzulClaro();
			z.ventanaLight();
		}if(colores.equals("Gris1")){
			Gris1 g1 = new Gris1();
			g1.ventanaG1();
		}if(colores.equals("Gris2")){
			Gris2 g2 = new Gris2();
			g2.ventanaG2();
		}if(colores.equals("Gris3")){
			Gris3 g3 = new Gris3();
			g3.ventanaG3();
		}if(colores.equals("AltoConstrante")){
			AltoC alc = new AltoC();
			alc.ventanaCon();
		}if(colores.equals("Inverso")){
			Inverso in = new Inverso();
			in.ventanaIn();
		}if(colores.equals("Gris4")){
			Gris4 g4 = new Gris4();
			g4.ventanaG4();
		}if(colores.equals("Brillo")){
			Brillo bi = new Brillo();
			bi.ventanaBri();
		}if(colores.equals("Mosaico")){
			Mosaicoo m = new Mosaicoo();
			m.imag();
			
		}


	}//fin del metodo menu


	public static void main(String args[]){
		Filtros f = new Filtros();
		f.menu();
	}//fin del main

}//fin de la clase Filtros