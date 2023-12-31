/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tarea2poo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Dialog.ModalityType;

/**
 *
 * @author vascl
 */
public class ServicioCliente extends javax.swing.JFrame {

    private Conexion connect;

    private int CodigoCliente;

    private String NombreCliente;

    private String NumeroCliente;

    /**
     * Creates new form ServicioCliente
     */
    public ServicioCliente() {
        initComponents();
        connect = new Conexion();
        obtenerClientes();
    }

    private void obtenerClientes() {
        this.CodigoCliente = -1;
        jComboBoxCliente.setEnabled(true);
        jButtonCrearInteraccion.setEnabled(false);
        jButtonCrearVenta.setEnabled(false);
        jButtonCrearServicio.setEnabled(false);
        jButtonDetalleFactura.setEnabled(false);

        try {
            Connection conn = connect.getCnx();
            String query = "SELECT * FROM sistematecnico.cliente;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

            model.addElement("Seleccione un cliente");

            while (rs.next()) {
                int CodigoCliente_ = rs.getInt("CodigoCliente");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                model.addElement(CodigoCliente_ + ":" + nombre + " - " + telefono);
            }

            jComboBoxCliente.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving Clientes: " + e.getMessage());
        }

    }

    private void obtenerFacturas() {
        try {
            Connection conn = connect.getCnx();
            String query = "SELECT * FROM sistematecnico.facturas WHERE CodigoCliente = " + this.CodigoCliente + ";";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("IdFactura");
            model.addColumn("CodigoCliente");
            model.addColumn("IdOrdenTrabajo");

            while (rs.next()) {
                int idFactura = rs.getInt("idFactura");
                String CodigoCliente_ = rs.getString("CodigoCliente");
                String IdOrdenTrabajo = rs.getString("IdOrdenTrabajo");
                model.addRow(new Object[] { idFactura, CodigoCliente_, IdOrdenTrabajo });
            }

            jTableFacturas.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving Clientes: " + e.getMessage());
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFacturas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButtonDetalleFactura = new javax.swing.JButton();
        jButtonCrearInteraccion = new javax.swing.JButton();
        jButtonCrearVenta = new javax.swing.JButton();
        jButtonCrearServicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Atencion al Cliente");

        jLabel2.setText("Cliente");

        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });

        jTableFacturas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {

                }));
        jScrollPane1.setViewportView(jTableFacturas);

        jLabel3.setText("Facturas Asociadas");

        jButtonDetalleFactura.setText("Detalle de Fatura");
        jButtonDetalleFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetalleFacturaActionPerformed(evt);
            }
        });

        jButtonCrearInteraccion.setText("Crear Interaccion");
        jButtonCrearInteraccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearInteraccionActionPerformed(evt);
            }
        });

        jButtonCrearVenta.setText("Crear Venta");
        jButtonCrearVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearVentaActionPerformed(evt);
            }
        });

        jButtonCrearServicio.setText("Crear Servicio");
        jButtonCrearServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 54, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(jLabel3)
                                        .addComponent(jButtonDetalleFactura)
                                        .addComponent(jButtonCrearInteraccion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonCrearVenta)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonCrearServicio))
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDetalleFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCrearInteraccion, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonCrearVenta)
                                        .addComponent(jButtonCrearServicio))
                                .addContainerGap(48, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearServicioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonCrearServicioActionPerformed
        int fila = jTableFacturas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una factura");
            return;
        }

        int idFactura_ = (int) jTableFacturas.getValueAt(fila, 0);
        String codigoCliente_ = (String) jTableFacturas.getValueAt(fila, 1);
        String idOrdenTrabajo_ = (String) jTableFacturas.getValueAt(fila, 2);

        CrearVentaServicio dialog = new CrearVentaServicio(this, true, idFactura_, codigoCliente_, idOrdenTrabajo_,
                "Servicio", this.connect);
        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
        dialog.setVisible(true);

        TableModel DataParaFactura = dialog.getModel();

        if (DataParaFactura.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se ha creado el servicio");
            return;
        }

        int idServicio;

        Connection conn = connect.getCnx();

        for (int i = 0; i < DataParaFactura.getRowCount(); i++) {
            idServicio = (int) DataParaFactura.getValueAt(i, 0);
            String query = "INSERT INTO detallefactura (IdFactura, CodigoProducto, Cantidad, IdServicio) VALUES (?, NULL , NULL , ?)";
            try {
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setInt(1, idFactura_);
                pst.setInt(2, idServicio);
                pst.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ErrorSQL " + e.getMessage());
            }
        }

    }// GEN-LAST:event_jButtonCrearServicioActionPerformed

    private void jButtonCrearInteraccionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonCrearInteraccionActionPerformed

        /*Connection conn = connect.getCnx();

        try {
            int idOrdenTrabajo = 0;
            Statement stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO OrdendeTrabajo (CodigoEmpleado, Observaciones) VALUES (7, 'Prueba');");

            ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                idOrdenTrabajo = rs.getInt(1);
            }
            stm.executeUpdate("INSERT INTO Facturas (CodigoCliente, IdOrdenTrabajo) VALUES (" + this.CodigoCliente + ","
                    + idOrdenTrabajo + ")");
            obtenerFacturas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ErrorSQL " + e.getMessage());
        }*/
        
        OrdenTrabajoDialog ot = new OrdenTrabajoDialog(this,true, this.CodigoCliente);
        ot.setVisible(true);
        
        this.obtenerFacturas();

    }// GEN-LAST:event_jButtonCrearInteraccionActionPerformed

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxClienteActionPerformed
        String Texto = jComboBoxCliente.getSelectedItem().toString();

        if ("Seleccione un cliente".equals(Texto)) {
            this.CodigoCliente = -1;
            return;
        }

        String[] partes1 = Texto.split(":");

        int id = Integer.parseInt(partes1[0]);

        String[] partes2 = partes1[1].split("-");

        String nombre = partes2[0].trim();

        String telefono = partes2[1].trim();

        this.CodigoCliente = id;
        this.NombreCliente = nombre;
        this.NumeroCliente = telefono;

        jComboBoxCliente.setEnabled(false);
        jButtonCrearInteraccion.setEnabled(true);
        jButtonCrearVenta.setEnabled(true);
        jButtonCrearServicio.setEnabled(true);
        jButtonDetalleFactura.setEnabled(true);

        obtenerFacturas();

    }// GEN-LAST:event_jComboBoxClienteActionPerformed

    private void jButtonDetalleFacturaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonDetalleFacturaActionPerformed
        int fila = jTableFacturas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una factura");
            return;
        }

        int idFactura_ = (int) jTableFacturas.getValueAt(fila, 0);
        DetalleFactura detalleFactura = new DetalleFactura(idFactura_, this.CodigoCliente);
        detalleFactura.setVisible(true);

    }// GEN-LAST:event_jButtonDetalleFacturaActionPerformed

    private void jButtonCrearVentaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonCrearVentaActionPerformed

        int fila = jTableFacturas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una factura");
            return;
        }

        int idFactura_ = (int) jTableFacturas.getValueAt(fila, 0);
        String codigoCliente_ = (String) jTableFacturas.getValueAt(fila, 1);
        String idOrdenTrabajo_ = (String) jTableFacturas.getValueAt(fila, 2);

        CrearVentaServicio dialog = new CrearVentaServicio(this, true, idFactura_, codigoCliente_, idOrdenTrabajo_,
                "Venta", this.connect);
        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
        dialog.setVisible(true);

        TableModel DataParaFactura = dialog.getModel();

        if (DataParaFactura.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se creo la factura");
            return;
        }

        Connection conn = connect.getCnx();

        int codigoProducto, cantidad;

        for (int i = 0; i < DataParaFactura.getRowCount(); i++) {
            codigoProducto = (int) DataParaFactura.getValueAt(i, 0);
            cantidad = (int) DataParaFactura.getValueAt(i, 3);
            String query = "INSERT INTO detallefactura (IdFactura, CodigoProducto, Cantidad, IdServicio) VALUES (?, ?, ?, NULL)";

            try {
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, idFactura_);
                preparedStmt.setInt(2, codigoProducto);
                preparedStmt.setInt(3, cantidad);
                preparedStmt.executeUpdate();

                query = "UPDATE inventario SET Existencia = Existencia - ? WHERE CodigoProducto = ?";
                preparedStmt = conn.prepareStatement(query);

                preparedStmt.setInt(1, cantidad);
                preparedStmt.setInt(2, codigoProducto);

                preparedStmt.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ErrorSQL " + e.getMessage());
            }

        }

    }// GEN-LAST:event_jButtonCrearVentaActionPerformed

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
            java.util.logging.Logger.getLogger(ServicioCliente.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicioCliente.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicioCliente.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicioCliente.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicioCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrearInteraccion;
    private javax.swing.JButton jButtonCrearServicio;
    private javax.swing.JButton jButtonCrearVenta;
    private javax.swing.JButton jButtonDetalleFactura;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFacturas;
    // End of variables declaration//GEN-END:variables
}
