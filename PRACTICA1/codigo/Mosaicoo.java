
/**
*@version 1.0
*/

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;


public class Mosaicoo {



       public int entero(){

            JFrame frame = new JFrame("Introduce numero para los pixeles");
            String name=JOptionPane.showInputDialog(frame,
            "Ingresa un numero para los pixeles: ");
            int e=Integer.parseInt(name);
        return e;

        }


        public void mosaico(BufferedImage imagen, int b, int h) {
                final int X = imagen.getWidth();
                final int Y = imagen.getHeight();

                BufferedImage nueva_Imagen = new BufferedImage(X, Y, BufferedImage.TYPE_INT_RGB);

                int t=(X / b) + ((X % b == 0) ? 0 : 1);
                int r=(Y / h) + ((Y % h == 0) ? 0 : 1);

                int area=b * h;
                int area_YReducida=b * (Y % h);
                int area_XReducida=h * (X % b);
                int area_XYReducida=(X % b) * (Y % h);

                int [][] rojos=new int[t][r];
                int [][] verdes=new int[t][r];
                int [][] azules=new int[t][r];

                int rgb_Pixel;

                for(int i=0, o=0; i<X; i++) {
                        if(i % b == 0 && i>0) { o++; }

                        for(int j=0, p=0; j<Y; j++) {

                                if (j % h == 0 && j>0) { p++; }
                                rgb_Pixel = imagen.getRGB(i, j);

                                rojos[o][p] = rojos[o][p] + ((rgb_Pixel >> 16) & 0xFF);
                                verdes[o][p] = verdes[o][p] + ((rgb_Pixel >> 8) & 0xFF);
                                azules[o][p] = azules[o][p] + (rgb_Pixel & 0xFF);

                                if (i % b == b-1 && j % h == h-1) {
                                        rojos[o][p] = rojos[o][p] / area;
                                        verdes[o][p] = verdes[o][p] / area;
                                        azules[o][p] = azules[o][p] / area;
                                } else if (i % b == b-1 && j == Y-1) {
                                        rojos[o][p] = rojos[o][p] / area_YReducida;
                                        verdes[o][p] = verdes[o][p] / area_YReducida;
                                        azules[o][p] = azules[o][p] / area_YReducida;
                                } else if (j % h == h-1 && i == X-1) {
                                        rojos[o][p] = rojos[o][p] / area_XReducida;
                                        verdes[o][p] = verdes[o][p] / area_XReducida;
                                        azules[o][p] = azules[o][p] / area_XReducida;
                                } else if (i == X-1 && j == Y-1) {
                                        rojos[o][p] = rojos[o][p] / area_XYReducida;
                                        verdes[o][p] = verdes[o][p] / area_XYReducida;
                                        azules[o][p] = azules[o][p] / area_XYReducida;
                                }
                        }
                }

                for(int i=0, o=0; i < X; i++){
                        if (i % b == 0 && i>0) o++;
                        for(int j=0, p=0; j<Y; j++) {
                                if(j % h == 0 && j>0) p++;
                                nueva_Imagen.setRGB(i, j, (rojos[o][p] << 16) | (verdes[o][p] << 8) | azules[o][p]);
                        }
                }

                try {
         
                		ImageIO.write(nueva_Imagen, "JPG", new File("mosaico.jpg"));
                } catch (IOException ie) {
                        System.err.println("I/O Error");
                        ie.printStackTrace(System.err);
                }
                  
                final ImageIcon icon = new ImageIcon(nueva_Imagen);
                JOptionPane.showMessageDialog(null,null,"Mosaico",
                    JOptionPane.PLAIN_MESSAGE,icon);
                 ventanaM();

             
              

        }

        public void imag(){
             int n = entero();
                try {
                        BufferedImage imagen = ImageIO.read(new File("Imagen7.jpg"));
                        new Mosaicoo().mosaico(imagen, n, n);
                        System.exit(0);

                } catch(Exception e) {
                        System.err.println("I/O Error");
                        e.printStackTrace(System.err);
                }


        }

        public void ventanaM(){
           int res = JOptionPane.showConfirmDialog(null,"Quieres probar otro Filtro?","Filtro",
         JOptionPane.INFORMATION_MESSAGE);
            if(res==JOptionPane.YES_OPTION){
               Filtros fe = new Filtros();
               fe.menu();
               
            }else{
               JOptionPane.showMessageDialog(null,"HASTA LUEGO!!! ");
               System.exit(0);

            }

        }

        public static void main(String[] args) {

        }

}