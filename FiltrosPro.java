import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;



public class FiltrosPro {
    
    private BufferedImage imgTmp;
    private ArrayList<String> imgs;
    
    public FiltrosPro(){
        imgs = new ArrayList<String>();
        
}



    public void fotomosaico(BufferedImage img){
        cargaImagenes();
        Color c;        
        int ancho = 10;
        int ancho2 = 15;
        String tabla = "<!DOCTYPE html><html><body><table  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >";
        for( int x = 0; x < img.getWidth(); x += ancho ){
            tabla += "<tr>";
            for( int y = 0; y < img.getHeight(); y += ancho2 ){
                c = calculaPromedioRGB(subMatriz(img, x, y, ancho, ancho2));
                int distanciaLineal = (65535 * c.getRed()) + (256 * c.getGreen()) + c.getBlue();
                String foto = buscaDiferenciaLineal(distanciaLineal);
                tabla += "<td  style=\"width: 10px;height:15px\" ><img src=\"imagenes/"+foto+"\" style=\"width: 10px;height:15px\" ></td>";

            }
            tabla += "</tr>";
        }
        tabla += "</table></body></html>";
        
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter("fotomosaico.html");
            pw = new PrintWriter(fichero);
            pw.println(tabla);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        JOptionPane.showMessageDialog(null, "Se generó el archivo fotomosaico.html exitosamente ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }
    public String buscaDiferenciaLineal(int distancia){
        double delta = Double.MAX_VALUE;
        String i = "";
        for (String img : imgs) {
            String[] temp = img.substring(0, img.indexOf(".jpg")).split("-");
            int d = (65535 * Integer.parseInt(temp[0])) + (256 * Integer.parseInt(temp[1])) + Integer.parseInt(temp[2]);
            if(Math.abs(d-distancia) < delta){
                delta = Math.abs(d-distancia);
                i = img;
            }
        }
        return i;   
    }
    private void cargaImagenes(){
        File dir = new File("imagenes");
        if(dir == null){
            return ;
        }
        String[] ficheros = dir.list();
        if(ficheros == null){
            return ;
        }
        for (String fichero : ficheros) {
            if (fichero.endsWith(".jpg")) {
                imgs.add(fichero);
            }
        }
}


  private Color calculaPromedioRGB(int[][] matrix){
        Color c;      
        double r = 0;
        double g = 0;
        double b = 0;
        for( int x = 0; x < matrix.length; x++ ){
            for( int y = 0; y < matrix[0].length; y++){
                c = new Color(matrix[x][y]);
                r += c.getRed();
                g += c.getGreen();
                b += c.getBlue();
            }
        }
        
        r = r / (matrix.length*matrix[0].length);
        g = g / (matrix.length*matrix[0].length);
        b = b / (matrix.length*matrix[0].length);
        
        return new Color((int)r,(int)g,(int)b);
}

 private int[][] subMatriz(BufferedImage matrix,int x, int y, int w, int h){
        
        if(matrix.getWidth()-(x+w) < 0){
            w = w + (matrix.getWidth()-(x+w));
        }
        if(matrix.getHeight()-(y+h) < 0){
            h = h + (matrix.getHeight()-(y+h));    
        }
        
        int[][] subregion = new int[w][h];
                
        
        for(int i = 0; i < w ; i++) {
            for(int j = 0; j < h; j++) {
                subregion[i][j] = matrix.getRGB(x+i,y+j);
            }
        }
        
        return subregion;
}



}