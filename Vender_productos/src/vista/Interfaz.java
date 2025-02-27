
package vista;

import Controlador.ControlProducto;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Interfaz extends javax.swing.JFrame {

    public Interfaz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextCategoria = new javax.swing.JTextField();
        Textnombre = new javax.swing.JTextField();
        TextDescripcion = new javax.swing.JTextField();
        TextPrecio = new javax.swing.JTextField();
        BtnLimpiar = new javax.swing.JButton();
        BtnPublicar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnBorrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setText("LISTA DE PRODUCTOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 200, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 153, 255));
        jLabel2.setText("Categoria:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 153, 255));
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 153, 255));
        jLabel4.setText("Descripción:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 153, 255));
        jLabel5.setText("Precio:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        getContentPane().add(TextCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 280, -1));
        getContentPane().add(Textnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 280, -1));
        getContentPane().add(TextDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 280, -1));
        getContentPane().add(TextPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 280, -1));

        BtnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnLimpiar.setForeground(new java.awt.Color(102, 153, 255));
        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 130, -1));

        BtnPublicar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnPublicar.setForeground(new java.awt.Color(102, 153, 255));
        BtnPublicar.setText("Publicar");
        BtnPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPublicarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnPublicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 130, -1));

        BtnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnActualizar.setForeground(new java.awt.Color(102, 153, 255));
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 130, -1));

        BtnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnBorrar.setForeground(new java.awt.Color(102, 153, 255));
        BtnBorrar.setText("Borrar");
        BtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 130, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 153, 255));
        jLabel6.setText("VENTA DE PRODUCTOS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 210, 20));

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 690, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void BtnPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPublicarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPublicarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBorrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        Interfaz vista = new Interfaz();
        ControlProducto controlador = new ControlProducto(vista);

        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnBorrar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnPublicar;
    private javax.swing.JTable Table1;
    private javax.swing.JTextField TextCategoria;
    private javax.swing.JTextField TextDescripcion;
    private javax.swing.JTextField TextPrecio;
    private javax.swing.JTextField Textnombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnActualizar() {
        return BtnActualizar;
    }

    public JButton getBtnBorrar() {
        return BtnBorrar;
    }

    public JButton getBtnLimpiar() {
        return BtnLimpiar;
    }

    public JButton getBtnPublicar() {
        return BtnPublicar;
    }

    public JTable getTable1() {
        return Table1;
    }

    public JTextField getTextCategoria() {
        return TextCategoria;
    }

    public JTextField getTextDescripcion() {
        return TextDescripcion;
    }

    public JTextField getTextPrecio() {
        return TextPrecio;
    }

    public JTextField getTextnombre() {
        return Textnombre;
    }

}
