import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

class Paleta {
    public int y;
    public int alto;
    
    public Paleta(int y, int alto) {
        this.y = y;
        this.alto = alto;
    }
}

class Pelota {
    public int x;
    public int y;
    public int veloX;
    public int veloY;
   
    public Pelota(int x, int y, int veloX, int veloY) {
        this.x = x;
        this.y = y;
        this.veloX = veloX;
        this.veloY = veloY;
    }
}
 
public class Pong extends JFrame implements KeyListener {
  
    private int windowWidth = 800;
    private int windowHeight = 600;
    private Pelota pelota;
    private Paleta paleta;
    
    private int key=0;
    private long goal;
    private long tiempoDemora=8;
    
    private int Buenas;
    private int Malas;
      
   
    public static void main(String[] args) {
        new Pong();
    }
   
    public Pong() {
        // Configuración de la ventana del juego
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(windowWidth, windowHeight);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setVisible(true);
       
        this.createBufferStrategy(2);
        
        this.addKeyListener(this);
       
        inicializoObjetos();
       
        while(true) {
            pelota();
            sleep();
        }
    }
       
    private void inicializoObjetos() {
        // Inicialización de la pelota y la paleta
        pelota = new Pelota(windowWidth/2, windowHeight/2, 5, -5);
        paleta = new Paleta(windowHeight/2, 80);
    }
   
    private void pelota() {
        // Movimiento de la pelota
        pelota.x = pelota.x + pelota.veloX;
        pelota.y = pelota.y + pelota.veloY;
       
        chequearColision();
        
        // Cambiar dirección si la pelota alcanza los bordes laterales
        if(pelota.x <= 0 || pelota.x >= windowWidth-40){
            pelota.veloX = -pelota.veloX;
            Malas++;
        }
        
        // Cambiar dirección si la pelota alcanza los bordes superior o inferior
        if(pelota.y <= 20 || pelota.y >= (windowHeight - 40))
            pelota.veloY = -pelota.veloY;

        dibujoPantalla();
    }   
    
    private void chequearColision(){
        // Verificar colisión con las paletas
        if ((pelota.x <= 75 && pelota.x >= 60) && pelota.y > paleta.y && pelota.y < paleta.y + paleta.alto)
        {
            if (pelota.veloX < 0)
                Buenas++;
            
            pelota.veloX = -pelota.veloX;
        }
        
        if ((pelota.x >= 695 && pelota.x <= 710) && pelota.y > paleta.y && pelota.y < paleta.y + paleta.alto)
        {
            if (pelota.veloX > 0)
                Buenas++;
            
            pelota.veloX = -pelota.veloX;
        }
    }
   
    private void dibujoPantalla() {
        // Dibujar el fondo, la pelota y las paletas
        BufferStrategy bf = this.getBufferStrategy();
        Graphics g = null;
       
        try {
            g = bf.getDrawGraphics();
                
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, windowWidth, windowHeight);
            
            muestroPuntos(g);
            dibujoPelota(g);
            dibujoPaletas(g);
            
        } finally {
            g.dispose();
        }
        bf.show();
             
        Toolkit.getDefaultToolkit().sync();
    }
   
    private void dibujoPelota(Graphics g) {
        // Dibujar la pelota
        g.setColor(Color.CYAN);
        g.fillOval(pelota.x, pelota.y, 20, 20);
    }
    
    private void dibujoPaletas(Graphics g) {
        // Dibujar las paletas
        switch (key){
            case KeyEvent.VK_UP:
                if (paleta.y > 23)
                    paleta.y = paleta.y - 6;
                break;
            case KeyEvent.VK_DOWN:
                if (paleta.y < windowHeight - 78)
                    paleta.y = paleta.y + 6;
                break;
            case KeyEvent.VK_E:
                System.exit(0);
        }
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(75, paleta.y, 15, paleta.alto);
        g.fillRect(710, paleta.y, 15, paleta.alto);
    }
    
    private void muestroPuntos(Graphics g){
        // Mostrar los puntos en la pantalla
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Buenas: " + Buenas, 20, 50);
            
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Malas: " + Malas, 20, 70);
    }
    
    private void sleep(){
        // Hacer una pausa para controlar la velocidad del juego
        goal = (System.currentTimeMillis() + tiempoDemora);
        while(System.currentTimeMillis() < goal) {
        
        }
    }
        
    @Override
    public void keyPressed(KeyEvent e){
        // Capturar las teclas presionadas por el usuario
        key=e.getKeyCode();
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        // Método no utilizado en este programa
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        // Método no utilizado en este programa
    }
}

