/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tarea2poo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vascl
 */
public class DetalleFactura extends javax.swing.JFrame {
    private int IdFactura;
    private int CodigoCliente;
    private double isv = 0.15;
    Conexion con;

    /**
     * Creates new form DetalleFactura
     */
    public DetalleFactura() {
        initComponents();
    }

    public DetalleFactura(int IdFactura_, int CodigoCliente_) {
        this.IdFactura = IdFactura_;
        this.CodigoCliente = CodigoCliente_;
        this.con = new Conexion();
        initComponents();
        DefaultTableModel modelProductos = new DefaultTableModel();
        modelProductos.addColumn("Codigo");
        modelProductos.addColumn("Nombre");
        modelProductos.addColumn("Cantidad");
        modelProductos.addColumn("Precio");

        jTableProductos.setModel(modelProductos);

        DefaultTableModel modelServicios = new DefaultTableModel();
        modelServicios.addColumn("IdServicio");
        modelServicios.addColumn("Nombre");
        modelServicios.addColumn("Precio");
        jTableServicios.setModel(modelServicios);
        llenardatos();
    }

    private void llenardatos() {

        try {
            int nombrecliente;
            Connection conn = con.getCnx();
            String sql = "SELECT * FROM facturas WHERE idFactura=" + this.IdFactura;
            String sql2 = "SELECT * FROM detallefactura WHERE IdFactura=" + this.IdFactura;
            String sql3 = "SELECT * FROM cliente WHERE CodigoCliente=" + this.CodigoCliente;

            Statement stm = conn.createStatement();
            Statement stm2 = conn.createStatement();
            Statement stm3 = conn.createStatement();

            ResultSet rsFactura = stm.executeQuery(sql);
            ResultSet rsCliente = stm3.executeQuery(sql3);
            ResultSet rsDetalleFactura = stm2.executeQuery(sql2);

            while (rsFactura.next()) {
                jTextIdCliente.setText(String.valueOf(rsFactura.getInt("CodigoCliente")));
                jTextIdFactura.setText(String.valueOf(rsFactura.getInt("idFactura")));
            }

            while (rsCliente.next()) {
                jTextNombreCliente.setText(rsCliente.getString("Nombre"));
            }

            TableModel currentModelServicio = jTableServicios.getModel();
            DefaultTableModel newModelServicio = new DefaultTableModel();

            for (int i = 0; i < currentModelServicio.getColumnCount(); i++) {
                newModelServicio.addColumn(currentModelServicio.getColumnName(i));
            }

            for (int i = 0; i < currentModelServicio.getRowCount(); i++) {
                Object[] row = new Object[currentModelServicio.getColumnCount()];
                for (int j = 0; j < currentModelServicio.getColumnCount(); j++) {
                    row[j] = currentModelServicio.getValueAt(i, j);
                }
                newModelServicio.addRow(row);
            }

            TableModel currentModelProducto = jTableServicios.getModel();
            DefaultTableModel newModelProducto = new DefaultTableModel();

            for (int i = 0; i < currentModelProducto.getColumnCount(); i++) {
                newModelProducto.addColumn(currentModelProducto.getColumnName(i));
            }

            for (int i = 0; i < currentModelProducto.getRowCount(); i++) {
                Object[] row = new Object[currentModelProducto.getColumnCount()];
                for (int j = 0; j < currentModelProducto.getColumnCount(); j++) {
                    row[j] = currentModelProducto.getValueAt(i, j);
                }
                newModelProducto.addRow(row);
            }

            double subtotal = 0;

            while (rsDetalleFactura.next()) {

                int Id = rsDetalleFactura.getInt("Id");
                int IdFactura = rsDetalleFactura.getInt("IdFactura");
                int CodigoProducto = rsDetalleFactura.getInt("CodigoProducto");
                int Cantidad = rsDetalleFactura.getInt("Cantidad");
                int IdServicio = rsDetalleFactura.getInt("IdServicio");

                if (CodigoProducto == 0) {
                    String sql4 = "SELECT * FROM servicio WHERE IdServicio=" + IdServicio;
                    Statement stm4 = conn.createStatement();
                    ResultSet rsServicio = stm4.executeQuery(sql4);

                    while (rsServicio.next()) {
                        
                        newModelServicio.addRow(new Object[] { rsServicio.getInt("IdServicio"),
                                rsServicio.getString("Nombre"), rsServicio.getDouble("Precio") });
                        subtotal = subtotal + rsServicio.getDouble("Precio");
                    }

                } else {
                    System.out.println("Es un producto");
                    String sql5 = "SELECT * FROM inventario WHERE CodigoProducto=" + CodigoProducto;
                    Statement stm5 = conn.createStatement();
                    ResultSet rsProducto = stm5.executeQuery(sql5);

                    while (rsProducto.next()) {
                        
                        newModelProducto.addRow(new Object[] { rsProducto.getInt("CodigoProducto"),
                                rsProducto.getString("NombreDeProducto"), Cantidad,
                                rsProducto.getDouble("PrecioVenta") });

                        subtotal = subtotal + ((rsProducto.getDouble("PrecioVenta") * Cantidad));
                    }

                }

                
            }
            double total= subtotal + (subtotal * isv);
            jTextFieldTotal.setText(String.valueOf(total));
            jTextFieldSubTotal.setText(String.valueOf(subtotal));
            jTableServicios.setModel(newModelServicio);
            jTableProductos.setModel(newModelProducto);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al obtener datso de la base de datos :" + e.getMessage() + "\n" + e.getSQLState());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextIdFactura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextNombreCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextIdCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableServicios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldSubTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Detalles de Factura");
        jLabel2.setText("Id de Factura:");

        jTextIdFactura.setEditable(false);
        jTextIdFactura.setText("Placeholder");

        jLabel3.setText("Nombre de Cliente:");

        jTextNombreCliente.setEditable(false);
        jTextNombreCliente.setText("Placeholder");
        jTextNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Id Cliente:");

        jTextIdCliente.setEditable(false);
        jTextIdCliente.setText("Placeholder");
        jTextIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdClienteActionPerformed(evt);
            }
        });

        jTableServicios.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {

                }));
        jTableServicios.setEnabled(false);
        jScrollPane1.setViewportView(jTableServicios);

        jLabel5.setText("Productos en la Factura");

        jLabel6.setText("Servicios en la factura");

        jTableProductos.setEnabled(false);
        jScrollPane2.setViewportView(jTableProductos);

        jLabel7.setText("Subtotal");

        jTextFieldSubTotal.setEditable(false);
        jTextFieldSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSubTotalActionPerformed(evt);
            }
        });

        jLabel8.setText("ISV");

        jTextField5.setEditable(false);
        jTextField5.setText("15%");

        jLabel9.setText("Total");

        jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Cerrar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 223,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(12, 12, 12)
                                                .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(15, 15, 15)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextNombreCliente,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(3, 3, 3)
                                                .addComponent(jTextFieldSubTotal,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5))
                                .addContainerGap(50, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextFieldSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton1)
                                .addContainerGap(45, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextNombreClienteActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextNombreClienteActionPerformed

    private void jTextIdClienteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextIdClienteActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextIdClienteActionPerformed

    private void jTextFieldSubTotalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldSubTotalActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldSubTotalActionPerformed

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldTotalActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldTotalActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jToggleButton1ActionPerformed
        this.dispose();
    }// GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTable jTableServicios;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldSubTotal;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextIdCliente;
    private javax.swing.JTextField jTextIdFactura;
    private javax.swing.JTextField jTextNombreCliente;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
