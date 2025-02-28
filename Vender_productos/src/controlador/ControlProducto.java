package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.table.DefaultTableModel;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import vista.Interfaz;

public class ControlProducto implements ActionListener {

    // variables para almacenar datos del producto
    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private Double precio;

    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    Interfaz vista = new Interfaz();
    DefaultTableModel modeloDeTabla = new DefaultTableModel();

    public ControlProducto(Interfaz _vista) {
        this.vista = _vista;
        vista.setVisible(true);
        AgregarEventos();
        ListarTabla();
    }

    // agrega eventos a los botones y la tabla
    private void AgregarEventos() {
        vista.getBtnPublicar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnBorrar().addActionListener(this);
        vista.getBtnLimpiar().addActionListener(this);

        vista.getTable1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LlenarCampos(e);
            }
        });
    }

    // lista los productos en la tabla de la interfaz
    private void ListarTabla() {
        String[] titulos = new String[]{"ID", "Nombre", "Descripcion", "Categoría", "Precio"};
        modeloDeTabla = new DefaultTableModel(titulos, 0);
        List<Producto> lista = productoDAO.listar();
        for (Producto producto : lista) {
            modeloDeTabla.addRow(new Object[]{
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCategoria(),
                producto.getPrecio()
            });
        }
        vista.getTable1().setModel(modeloDeTabla);
        vista.getTable1().setPreferredSize(new Dimension(350, modeloDeTabla.getRowCount() * 16));
    }

    // llena los inputs al hacer clic en una fila de la tabla
    private void LlenarCampos(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        id = Integer.parseInt(vista.getTable1().getModel().getValueAt(target.getSelectedRow(), 0).toString());
        vista.getTextnombre().setText(vista.getTable1().getModel().getValueAt(target.getSelectedRow(), 1).toString());
        vista.getTextDescripcion().setText(vista.getTable1().getModel().getValueAt(target.getSelectedRow(), 2).toString());
        vista.getTextCategoria().setText(vista.getTable1().getModel().getValueAt(target.getSelectedRow(), 3).toString());
        vista.getTextPrecio().setText(vista.getTable1().getModel().getValueAt(target.getSelectedRow(), 4).toString());
    }

    // valida que todos los campos estén llenos
    private boolean validarDatos() {
        if (vista.getTextnombre().getText().trim().isEmpty()
                || vista.getTextDescripcion().getText().trim().isEmpty()
                || vista.getTextCategoria().getText().trim().isEmpty()
                || vista.getTextPrecio().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // carga los datos ingresados en los inputs
    private boolean cargarDatos() {
        try {
            nombre = vista.getTextnombre().getText().trim();
            descripcion = vista.getTextDescripcion().getText().trim();
            categoria = vista.getTextCategoria().getText().trim();

            String precioTexto = vista.getTextPrecio().getText().trim();

            if (precioTexto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Precio no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            precio = Double.parseDouble(precioTexto);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo Precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al cargar los datos: " + e.getMessage());
            return false;
        }
    }

    // limpia los campos de la interfaz
    private void limpiarCampos() {
        vista.getTextnombre().setText("");
        vista.getTextDescripcion().setText("");
        vista.getTextCategoria().setText("");
        vista.getTextPrecio().setText("");
        id = 0;
        nombre = "";
        descripcion = "";
        categoria = "";
        precio = 0.0;
    }

    // agrega un producto a la base de datos
    private void agregarProducto() {
        try {
            if (!validarDatos()) {
                return;
            }

            if (cargarDatos()) {
                Producto producto = new Producto(nombre, descripcion, categoria, precio);

                productoDAO.Agregar(producto);

                JOptionPane.showMessageDialog(null, "El registro se agregó exitosamente");

                limpiarCampos();
                ListarTabla();
            }
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar el registro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // actualiza un producto que existe en la base de datos
    private void actualizarProducto() {
        try {
            if (validarDatos()) {
                if (cargarDatos()) {
                    System.out.println("Actualizando registro:");
                    System.out.println("ID: " + id);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Descripcion: " + descripcion);
                    System.out.println("Categoría: " + categoria);
                    System.out.println("Precio: " + precio);

                    Producto producto = new Producto(id, nombre, descripcion, categoria, precio);

                    if (id == 0) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un producto para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    productoDAO.Actualizar(producto);

                    JOptionPane.showMessageDialog(null, "Artículo actualizado con éxito.");
                    limpiarCampos();
                }
            }
        } catch (HeadlessException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        } finally {
            ListarTabla();
        }
    }

    // borra un producto de la base de datos
    private void borrarProducto() {
        if (id == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            productoDAO.Eliminar(id);
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
            limpiarCampos();
            ListarTabla();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getBtnPublicar()) {
            agregarProducto();
        } else if (ae.getSource() == vista.getBtnActualizar()) {
            actualizarProducto();
        } else if (ae.getSource() == vista.getBtnBorrar()) {
            borrarProducto();
        } else if (ae.getSource() == vista.getBtnLimpiar()) {
            limpiarCampos();
        }
    }
}
