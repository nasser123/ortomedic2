package renderizadores;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import utilidades.Datas;

/**
 *
 * @author Nasser
 */
public class ConsultaColunaHoraRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel etiqueta = new JLabel();
        etiqueta.setOpaque(true);

        for (int i = 0; i < table.getColumnCount(); i++) {
            if (table.getColumnModel().getColumn(i).getHeaderValue().toString() == "Hora") {
                if (value != null) {
                    String hora = Datas.getTimeDataBase((Date) value);
                    etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    etiqueta.setText(hora);
                }

            }

        }
//        if (table.getColumn(value) == "Hora") {
//            if (value != null) {
//                String hora = Datas.getTimeDataBase((Date) value);
//                etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//                etiqueta.setText(hora);
//            }
//        }
        if (!isSelected) {
            etiqueta.setBackground(Color.WHITE);
        } else {
            etiqueta.setBackground(new Color(51, 153, 255));
            etiqueta.setForeground(Color.WHITE);
        }
        return etiqueta;
    }
}

// Exemplo de renderizacao
//
//package com.blogspot.rolandopalermo.gui;
// 
//import java.awt.Color;
//import java.awt.Component;
//import javax.swing.JLabel;
//import javax.swing.JTable;
//import javax.swing.table.TableCellRenderer;
// 
///**
// *
// * @author Rolando
// */
//public class TablaRenderizadorCliente implements TableCellRenderer {
// 
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        JLabel etiqueta = new JLabel();
//        etiqueta.setOpaque(true);
//        if (row % 2 == 0) {
//            etiqueta.setBackground(new Color(255, 255, 200));
//        } else {
//            etiqueta.setBackground(Color.white);
//        }
//        if (column == 1) {
//            String nombre = (String) value;
//            etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
//            if (nombre.startsWith("#")) { //Hombre
//                etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/blogspot/rolandopalermo/recursos/user.png"))); // NOI18N
//            } else if (nombre.startsWith("&")) { //Mujer
//                etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/blogspot/rolandopalermo/recursos/user2.png"))); // NOI18N
//            }
//            etiqueta.setText(value.toString().substring(1, nombre.length()));
//        } else {
//            etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//            etiqueta.setText(value.toString());
//        }
//        if (isSelected) {
//            etiqueta.setBackground(new Color(151, 193, 215));
//        }
//        return etiqueta;
//    }
//}
