/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.tarea2poo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Table;

/**
 *
 * @author vascl
 */
public class CrearVentaServicio extends javax.swing.JDialog {

    private int idFactura;
    private String codigoCliente;
    private String idOrdenTrabajo;
    private Conexion connect;
    private TableModel model;

    /**
     * Creates new form CrearVentaServicio
     */
    public CrearVentaServicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public CrearVentaServicio(java.awt.Frame parent, boolean modal, int idFactura, String codigoCliente,
            String idOrdenTrabajo, String tipo, Conexion connect) {
        super(parent, modal);
        initComponents();
        this.codigoCliente = codigoCliente;
        this.idFactura = idFactura;
        this.idOrdenTrabajo = idOrdenTrabajo;
        jLabel1.setText(tipo);
        this.connect = connect;
        llenarTabladeProductosoServicios();

        if (jLabel1.getText().equals("Venta")) {
            DefaultTableModel model2 = new DefaultTableModel();
            model2.addColumn("Codigo");
            model2.addColumn("Nombre");
            model2.addColumn("Precio");
            model2.addColumn("Cantidad");
            jTableItemsFactura.setModel(model2);
        } else if (jLabel1.getText().equals("Servicio")) {

            DefaultTableModel model2 = new DefaultTableModel();
            model2.addColumn("Id");
            model2.addColumn("Nombre");
            model2.addColumn("Precio");
            jTableItemsFactura.setModel(model2);
        }

    }

    private void llenarTabladeProductosoServicios() {

        if (jLabel1.getText().equals("Venta")) {
            try {
                Connection con = connect.getCnx();
                String query = "SELECT * FROM inventario WHERE Existencia <> 0";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Codigo");
                model.addColumn("Codigo Proveedor");
                model.addColumn("Nombre");
                model.addColumn("Precio");
                model.addColumn("Existencia");
                while (rs.next()) {
                    int CodigoProducto = rs.getInt("CodigoProducto");
                    int CodigoProveedor = rs.getInt("CodigoProveedor");
                    String NombreDeProducto = rs.getString("NombreDeProducto");
                    float PrecioVenta = rs.getFloat("PrecioVenta");
                    int Existencia = rs.getInt("Existencia");

                    model.addRow(new Object[] { CodigoProducto, CodigoProveedor, NombreDeProducto, PrecioVenta,
                            Existencia });
                }

                jTableProductos_Servicios.setModel(model);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos" + e.getMessage());
            }

        } else if (jLabel1.getText().equals("Servicio")) {
            try {

                Connection con = connect.getCnx();
                String query = "SELECT * FROM servicio WHERE Disponible > 0";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Id");
                model.addColumn("Nombre");
                model.addColumn("Precio");

                while (rs.next()) {
                    int IdServicio = rs.getInt("IdServicio");
                    String Nombre = rs.getString("Nombre");
                    float Precio = rs.getFloat("Precio");

                    model.addRow(new Object[] { IdServicio, Nombre, Precio });
                }
                jTableProductos_Servicios.setModel(model);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos" + e.getMessage());
            }

        }

    }

    public TableModel getModel() {
        return this.model = jTableItemsFactura.getModel();
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos_Servicios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonAgregar_a_Factura = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableItemsFactura = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButtonCrearFactura = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jTableProductos_Servicios);

        jLabel1.setText("jLabel1");

        jButtonAgregar_a_Factura.setText("Agregar a Factura");
        jButtonAgregar_a_Factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregar_a_FacturaActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTableItemsFactura);

        jLabel2.setText("Factura");

        jButtonCrearFactura.setText("Crear Factura");
        jButtonCrearFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearFacturaActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar de factura");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregar_a_Factura)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonCrearFactura))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAgregar_a_Factura)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButtonCrearFactura)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int fila = jTableItemsFactura.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto o servicio");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTableItemsFactura.getModel();
        model.removeRow(fila);
        jTableItemsFactura.setModel(model);
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonAgregar_a_FacturaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        int fila = jTableProductos_Servicios.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto o servicio");
            return;
        }

        if (jLabel1.getText().equals("Venta")) {
            TableModel currentModel = jTableItemsFactura.getModel();
            DefaultTableModel newModel = new DefaultTableModel();
            for (int i = 0; i < currentModel.getColumnCount(); i++) {
                newModel.addColumn(currentModel.getColumnName(i));
            }
            for (int i = 0; i < currentModel.getRowCount(); i++) {
                Object[] row = new Object[currentModel.getColumnCount()];
                for (int j = 0; j < currentModel.getColumnCount(); j++) {
                    row[j] = currentModel.getValueAt(i, j);
                }
                newModel.addRow(row);
            }

            int CodigoProducto = Integer.parseInt(jTableProductos_Servicios.getValueAt(fila, 0).toString());
            String NombreDeProducto = jTableProductos_Servicios.getValueAt(fila, 2).toString();
            float PrecioVenta = Float.parseFloat(jTableProductos_Servicios.getValueAt(fila, 3).toString());
            int Existencia = Integer.parseInt(jTableProductos_Servicios.getValueAt(fila, 4).toString());

            JDialog dialog = new JDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setTitle("Ingrese la cantidad");
            dialog.setModal(true);

            JLabel label = new JLabel("Cantidad:");
            JTextField textField = new JTextField(10);
            JButton okButton = new JButton("OK");

            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String input = textField.getText();
                    int Cantidad = Integer.parseInt(input);
                    dialog.dispose();
                }
            });

            JPanel panel = new JPanel();
            panel.add(label);
            panel.add(textField);
            panel.add(okButton);

            dialog.add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            int Cantidad = Integer.parseInt(textField.getText());
            
            if (Cantidad>Existencia) {
                JOptionPane.showMessageDialog(null, "No hay suficiente existencia");
                return;
            }
            newModel.addRow(new Object[] { CodigoProducto, NombreDeProducto, PrecioVenta, Cantidad });

            jTableItemsFactura.setModel(newModel);

        } else if (jLabel1.getText().equals("Servicio")) {

            TableModel currentModel = jTableItemsFactura.getModel();
            DefaultTableModel newModel = new DefaultTableModel();
            for (int i = 0; i < currentModel.getColumnCount(); i++) {
                newModel.addColumn(currentModel.getColumnName(i));
            }
            for (int i = 0; i < currentModel.getRowCount(); i++) {
                Object[] row = new Object[currentModel.getColumnCount()];
                for (int j = 0; j < currentModel.getColumnCount(); j++) {
                    row[j] = currentModel.getValueAt(i, j);
                }
                newModel.addRow(row);
            }

            int CodigoServicio = Integer.parseInt(jTableProductos_Servicios.getValueAt(fila, 0).toString());
            String NombreDeServicio = jTableProductos_Servicios.getValueAt(fila, 1).toString();
            float PrecioServicio = Float.parseFloat(jTableProductos_Servicios.getValueAt(fila, 2).toString());

            newModel.addRow(new Object[] { CodigoServicio, NombreDeServicio, PrecioServicio });
            jTableItemsFactura.setModel(newModel);

        }

    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButtonCrearFacturaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }// GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CrearVentaServicio.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearVentaServicio.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearVentaServicio.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearVentaServicio.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearVentaServicio dialog = new CrearVentaServicio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar_a_Factura;
    private javax.swing.JButton jButtonCrearFactura;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableItemsFactura;
    private javax.swing.JTable jTableProductos_Servicios;
    // End of variables declaration//GEN-END:variables
}
