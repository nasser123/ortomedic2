/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.awt.AWTKeyStroke;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Define configurações padrão das telas
 *
 * @author nasser
 */
public class ConfigTelas {

    private JFrame janela;
    private Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
    private int larg;
    private int alt;
    private JPanel panel;

    /**
     * @param janela informa a janela que está sendo configurada
     * @param larg informa a largura da tela em pixels (padrão: 1024)
     * @param alt informa a altura da tela em pixels (padrão: 680)
     */
    public ConfigTelas(JFrame janela, int larg, int alt) {
        this.janela = janela;
        this.larg = larg;
        this.alt = alt;

    }

    public ConfigTelas(JPanel jp, int larg, int alt) {
        this.larg = larg;
        this.alt = alt;
        this.panel = jp;

    }

    public ConfigTelas(JFrame jf) {
        this.larg = jf.getWidth();
        this.alt = jf.getHeight();

    }
    
    public ConfigTelas(JDialog jd){
        
    }

    public void carregaIcone(JFrame jp) {
        BufferedImage ico = null;
        try {
            ico = ImageIO.read(jp.getClass().getResource("/icones32/ortomedic.png"));
            jp.setIconImage(ico);
        } catch (IllegalArgumentException iae) {
            System.out.println("Erro ao carregar icone!");
        } catch (java.lang.NullPointerException npe) {
            System.out.println("Erro ao carregar icone!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar icone!");
        }

    }

    public void carregarConfig(JFrame jf) {
        
        //faz com que a tecla ENTER funcione conforme a tecla TAB
        HashSet conj = new HashSet(jf.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        jf.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
        

        jf.setTitle("Ortomedic");

        jf.setResizable(false);


        //Altera o icone padrão do java
        BufferedImage ico = null;
        try {
            ico = ImageIO.read(jf.getClass().getResource("/icones32/ortomedic.png"));
            jf.setIconImage(ico);
        } catch (IllegalArgumentException iae) {
            System.out.println("Erro ao carregar icone!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar icone!");
        }

    }
    
    public void carregarConfig(JPanel jp) {
        
        //faz com que a tecla ENTER funcione conforme a tecla TAB
        HashSet conj = new HashSet(jp.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        jp.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
        

    } 
    
    public void carregarConfig(JDialog jd){
     //faz com que a tecla ENTER funcione conforme a tecla TAB
        HashSet conj = new HashSet(jd.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        jd.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    
        jd.setTitle("Ortomedic");
    }
}
