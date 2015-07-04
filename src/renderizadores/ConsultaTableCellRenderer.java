package renderizadores;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Nasser
 */
public class ConsultaTableCellRenderer extends DefaultTableCellRenderer {

    /**
     *      */
    private Font fontePadrao = new Font("MS Sanserif", Font.BOLD, 12);
    private Font fonte2 = new Font("Arial", Font.BOLD, 12);

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setFont(this.fontePadrao);
        setHorizontalAlignment(CENTER);
        String texto = this.getText();
        if (table.getColumnName(column).equals("TipoConsulta")){
            c.setBackground(getCorLocal(row, isSelected, texto));
        }
        
        
        c.setBackground(getCor(row, isSelected, texto));

        return c;
    }
    
    private Color getCor (int linha, boolean selecionada, String value){
        if(selecionada){
            return Color.BLUE;
        }
//        if (value.equals("Aguardando Cliente")){
//            return Color.YELLOW;
//        }
//        if (value.equals("Aberta")){
//            return Color.RED;
//        }
//        if (value.equals("Fechada")){
//            return Color.GRAY;
//        }
//        if (value.equals("Entregue")){
//            return Color.WHITE;
//        }
       
        return Color.GREEN;
    }
    
    private Color getCorLocal(int linha, boolean selecionada, String value){
//        if(selecionada){
//            return Color.YELLOW;
//        }
        if (value.equals("reconsulta")){
            return Color.YELLOW;
        }
        return null;
    
    }
    
    

}
