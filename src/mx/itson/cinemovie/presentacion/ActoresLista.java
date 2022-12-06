/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.cinemovie.presentacion;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.itson.cinemovie.entidades.Actor;

/**
 * Lista de actores
 * @author Michelle
 * @author Emmanuel
 */
public class ActoresLista extends javax.swing.JFrame {

    /**
     * Creates new form ActoresLista
     */
        

    public ActoresLista() {
        initComponents();
        // Cambiar la longitud de columna id 
        tblActores.getColumnModel().getColumn(0).setPreferredWidth(5);
        btnEditarActor.setEnabled(false);
        btnEliminarActor.setEnabled(false);
        cargarTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnAgregarActor = new javax.swing.JButton();
        btnEditarActor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblActores = new javax.swing.JTable();
        btnEliminarActor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAgregarActor.setText("Agregar Actor");
        btnAgregarActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActorActionPerformed(evt);
            }
        });

        btnEditarActor.setText("Editar Actor");
        btnEditarActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActorActionPerformed(evt);
            }
        });

        tblActores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Fecha de nacimiento", "Nacionalidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblActores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblActoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblActores);

        btnEliminarActor.setText("Eliminar Actor");
        btnEliminarActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnAgregarActor)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarActor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnEliminarActor)))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnRegresar)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarActor)
                    .addComponent(btnEditarActor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarActor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // Regresa a la clase principal
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActorActionPerformed

        // Abre el formulario para actores
        ActoresForm actores = new ActoresForm(this, true);
        actores.setVisible(true);

        cargarTable();
    }//GEN-LAST:event_btnAgregarActorActionPerformed

    private void btnEliminarActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActorActionPerformed

        // Crea una variable que almacenara la id de cada columna seleccionada
        int ids[] = tblActores.getSelectedRows();
        // Asigna la id correspondiente de los actores a cada campo que existe en ids
        for (int i=0; tblActores.getSelectedRowCount()>i; i++){
            ids[i] = Integer.parseInt(tblActores.getValueAt(tblActores.getSelectedRows()[i], 0).toString());
        }

        boolean resultado = Actor.eliminar(ids);
          
        // Mostrar un mensaje de dialogo dependiendo del valor de resultado
        if(resultado){
            JOptionPane.showMessageDialog(this, "El registro se actualizo correctamente", "Registro borrado", JOptionPane.INFORMATION_MESSAGE);
            btnEliminarActor.setEnabled(false);
            btnEditarActor.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al borrar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        this.cargarTable();
    }//GEN-LAST:event_btnEliminarActorActionPerformed

    private void btnEditarActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActorActionPerformed
        int renglon = tblActores.getSelectedRow();
        // Guarda los campos de la fila seleccionada en la tabla
        int idActor = Integer.parseInt(tblActores.getModel().getValueAt(renglon, 0).toString());
        String nombre = tblActores.getModel().getValueAt(renglon, 1).toString();
        // Captura la fecha de nacimiento reordenando los campos de la fecha haciendo uso de regex donde $3 = día $2 = mes $1 = año
        String fechaNacimiento = (tblActores.getModel().getValueAt(renglon, 2).toString()).replaceAll("(\\d+)-(\\d+)-(\\d+)", "$3/$2/$1");
        String nacionalidad = tblActores.getModel().getValueAt(renglon, 3).toString();

        ActoresForm actores = new ActoresForm(this,true);
        // Rellena los campos del formulario actores con los campos que se encontraban en la tabla
        actores.setId(idActor);
        actores.setNombre(nombre);
        actores.setFechaNacimiento(fechaNacimiento);
        actores.setNacionalidad(nacionalidad);
        actores.setVisible(true);

        cargarTable();
    }//GEN-LAST:event_btnEditarActorActionPerformed

    private void tblActoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActoresMouseClicked
        // Mientras solo sea seleccionada una fila, activar el boton de editar pelicula
        if (tblActores.getSelectedRows().length == 1){
            btnEditarActor.setEnabled(true);
        } else {
            btnEditarActor.setEnabled(false);
        }
        
        // Si no esta seleccionada ninguna fila, desactivar los botones, de lo contrario, activar el boton de eliminar pelicula
        if (tblActores.getSelectedRows().length != 0){
            btnEliminarActor.setEnabled(true);
        } else {
            btnEliminarActor.setEnabled(false);
            btnEditarActor.setEnabled(false);
        }
    }//GEN-LAST:event_tblActoresMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {   
       
    }
    
    
    /**
     * Obtenemos todos los objetos a la tabla actores.
     */
    private void cargarTable(){
      
        // Modelo de la tabla donde se cargaran los datos
        DefaultTableModel modelo = (DefaultTableModel)tblActores.getModel();
        modelo.setRowCount(0);
        
        List<Actor> actores = Actor.obtenerTodos();
        for(Actor a : actores){
           modelo.addRow(new Object[] {
               a.getId(),
               a.getNombre(),
               a.getFechaNacimiento(),
               a.getNacionalidad()
           });
       }
       }
       
    
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
            java.util.logging.Logger.getLogger(ActoresLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActoresLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActoresLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActoresLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActoresLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarActor;
    private javax.swing.JButton btnEditarActor;
    private javax.swing.JButton btnEliminarActor;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblActores;
    // End of variables declaration//GEN-END:variables

}
