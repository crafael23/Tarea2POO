
package com.mycompany.tarea2poo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gl_admin
 */
public class AdicionEdicion extends javax.swing.JFrame {

    Conexion connect;
    
    public AdicionEdicion() {
        initComponents();
        connect = new Conexion();
    }
    
    public void mostrarOrdenDeTrabajo(){
       try{
            Connection conn = connect.getCnx();
            String sql = "Select * from ordendetrabajo";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("IdOrdenTrabajo");
            model.addColumn("CodigoEmpleado");
            model.addColumn("Observaciones");
            
            while(rs.next()){
                int IdOrdenTrabajo = rs.getInt("IdOrdenTrabajo");
                int CodigoEmpleado = rs.getInt("CodigoEmpleado");
                String Observaciones = rs.getString("Observaciones");
                model.addRow(new Object[]{IdOrdenTrabajo, CodigoEmpleado, Observaciones});
            }
            Consulta.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro retrievin cliente: " + e.getMessage());
        }
    }
    
    public void mostrarClientes(){
        try{
            Connection conn = connect.getCnx();
            String sql = "Select * from cliente";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("CodigoCliente");
            model.addColumn("Nombre");
            model.addColumn("Telefono");
            
            while(rs.next()){
                int CodCliente = rs.getInt("CodigoCliente");
                String NombreCliente = rs.getString("Nombre");
                String Telefono = rs.getString("Telefono");
                model.addRow(new Object[]{CodCliente, NombreCliente, Telefono});
            }
            Consulta.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro retrievin cliente: " + e.getMessage());
        }
    }
    
    public void mostrarDetalleFactura(){
        try{
            Connection conn = connect.getCnx();
            String sql = "Select * from detallefactura";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id");
            model.addColumn("IdFactura");
            model.addColumn("CodigoProducto");
            model.addColumn("Cantidad");
            model.addColumn("IdServicio");
            
            while(rs.next()){
                int Id = rs.getInt("Id");
                int IdFactura = rs.getInt("IdFactura");
                int CodProducto = rs.getInt("CodigoProducto");
                int Cantidad = rs.getInt("Cantidad");
                int CodServicio = rs.getInt("IdServicio");
                model.addRow(new Object[]{Id, IdFactura, CodProducto, Cantidad, CodServicio});
            }
            Consulta.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro retrievin detallefactura: " + e.getMessage());
        }
    }
    
    public void mostrarInventario(){
        try{
            Connection conn = connect.getCnx();
            String sql = "Select * from inventario";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("CodigoProducto");
            model.addColumn("NombreDeProducto");
            model.addColumn("CodigoProveedor");
            model.addColumn("PrecioVenta");
            model.addColumn("Existencia");
            
            while(rs.next()){
                int CodProdcuto = rs.getInt("CodigoProducto");
                String Producto = rs.getString("NombreDeproducto");
                int CodProveedor = rs.getInt("CodigoProveedor");
                int PrecioVenta = rs.getInt("PrecioVenta");
                int Existencia = rs.getInt("Existencia");
                model.addRow(new Object[]{CodProdcuto, Producto, CodProveedor, PrecioVenta, Existencia});
            }
            Consulta.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro retrievin inventario: " + e.getMessage());
        }
    }
    
    public void mostrarServicio(){
        try{
            Connection conn = connect.getCnx();
            String sql = "Select * from servicio";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("idServicio");
            model.addColumn("Nombre");
            model.addColumn("Precio");
                        
            while(rs.next()){
                int IdServicio = rs.getInt("idServicio");
                String Nombre = rs.getString("Nombre");
                int Precio = rs.getInt("Precio");

                model.addRow(new Object[]{IdServicio, Nombre, Precio});
            }
            Consulta.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro retrievin servicio: " + e.getMessage());
        }
    }
    
    public void mostrarFactura(){
        try{
            Connection conn = connect.getCnx();
            String sql = "Select * from facturas";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("idFactura");
            model.addColumn("CodigoCliente");
            model.addColumn("IdOrdenTrabajo");
                       
            while(rs.next()){
                int idFactura = rs.getInt("idFactura");
                int CodigoCliente = rs.getInt("CodigoCliente");
                int IdOrdenTrabajo = rs.getInt("IdOrdenTrabajo");
                
                model.addRow(new Object[]{idFactura, CodigoCliente, IdOrdenTrabajo});
            }
            Consulta.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro retrievin facturas: " + e.getMessage());
        }
    }
    
    public void mostrarEmpleado(){
        try{
            Connection conn = connect.getCnx();
            String sql = "Select * from empleado";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("CodigoEmpleado");
            model.addColumn("Nombre");
            model.addColumn("Cargo");
            model.addColumn("Telefono");
                        
            while(rs.next()){
                int CodEmpleado = rs.getInt("CodigoEmpleado");
                String Nombre = rs.getString("Nombre");
                String Cargo = rs.getString("Cargo");
                String Telefono = rs.getString("Telefono");
                model.addRow(new Object[]{CodEmpleado, Nombre, Cargo, Telefono});
            }
            Consulta.setModel(model);            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro retrievin empleado: " + e.getMessage());
        }
    }
    public void mostrarProveedor(){
        try{
            Connection conn = connect.getCnx();
            String sql = "Select * from proveedor";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("CodigoProveedor");
            model.addColumn("Nombre");
            
            while(rs.next()){
                int CodProveedor = rs.getInt("CodigoProveedor");
                String Nombre = rs.getString("Nombre");
                model.addRow(new Object[]{CodProveedor, Nombre});
            }
            Consulta.setModel(model);                      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro retrievin proveedor: " + e.getMessage());
        }
    }
    
    public void seleccion(){
        String seleccion = jComboBox1.getSelectedItem().toString();
        switch (seleccion) {
            case "Orden de Trabajo":
                mostrarOrdenDeTrabajo();
                break;
            case "Cliente":
                mostrarClientes();
                break;
            case "Detalle Factura":
                mostrarDetalleFactura();
                break;
            case "Factura":
                mostrarFactura();
                break;
            case "Inventario":
                mostrarInventario();
                break;
            case "Proveedor":        
                mostrarProveedor();
                break;
            case "Empleado":
                mostrarEmpleado();                
                break;
            case "Servicio":
                mostrarServicio();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ocurrio un problema.");
                break;
        }
        
    }
   public void eliminar(){
        try{
            Connection conn = connect.getCnx();
            String sql;
            Statement stm;
            ResultSet rs;
            String seleccion = jComboBox1.getSelectedItem().toString();
            int fila = Consulta.getSelectedRow();
            String valor = Consulta.getValueAt(fila, 0).toString();            
        switch (seleccion) {
            case "Orden de Trabajo":                
                sql = "Delete from ordendetrabajo where IdOrdenTrabajo = '" + valor + "'";
                stm = conn.prepareStatement(sql);
                stm.executeUpdate(sql);
                mostrarOrdenDeTrabajo();            
                break;
            case "Cliente":
                break;
            case "Detalle Factura":
                sql = "Delete from detallefactura where id = '" + valor + "'";
                stm = conn.prepareStatement(sql);
                stm.executeUpdate(sql);
                mostrarOrdenDeTrabajo();
                break;
            case "Factura":
                sql = "Delete from facturas where idFactura = '" + valor + "'";
                stm = conn.prepareStatement(sql);
                stm.executeUpdate(sql);
                mostrarOrdenDeTrabajo();
                break;
            case "Inventario":
                sql = "Delete from inventario where CodigoProducto = '" + valor + "'";
                stm = conn.prepareStatement(sql);
                stm.executeUpdate(sql);
                mostrarOrdenDeTrabajo();
                break;
            case "Proveedor":        
                sql = "Delete from probeedor where CodigoProveedor = '" + valor + "'";
                stm = conn.prepareStatement(sql);
                stm.executeUpdate(sql);
                mostrarOrdenDeTrabajo();
                break;
            case "Empleado":
                sql = "Delete from empleado where CodigoEmpleado = '" + valor + "'";
                stm = conn.prepareStatement(sql);
                stm.executeUpdate(sql);
                mostrarOrdenDeTrabajo();                
                break;
            case "Servicio":
                
                break;
            default:
                break;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error SQL: " + e.getMessage());
        }
    
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Consulta = new javax.swing.JTable();
        ButtonAgregar = new javax.swing.JButton();
        ButtonEditar = new javax.swing.JButton();
        ButtonEliminar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Consulta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Consulta);

        ButtonAgregar.setText("Agregar");

        ButtonEditar.setText("Modificar");

        ButtonEliminar.setText("Eliminar");
        ButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEliminarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Opcion", "Orden de Trabajo", "Cliente", "Detalle Factura", "Factura", "Inventario", "Proveedor", "Servicio", "Empleado", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(ButtonAgregar)
                        .addGap(49, 49, 49)
                        .addComponent(ButtonEditar)
                        .addGap(39, 39, 39)
                        .addComponent(ButtonEliminar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAgregar)
                    .addComponent(ButtonEliminar)
                    .addComponent(ButtonEditar))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_ButtonEliminarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        seleccion();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdicionEdicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionEdicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionEdicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionEdicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionEdicion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAgregar;
    private javax.swing.JButton ButtonEditar;
    private javax.swing.JButton ButtonEliminar;
    private javax.swing.JTable Consulta;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
