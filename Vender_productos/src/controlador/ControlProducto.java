package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.table.DefaultTableModel;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import vista.Interfaz;

public class ControlProducto implements ActionListener {

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

    private void ListarTabla() {
        String[] titulos = new String[]{"ID", "Nombre", "Descripción", "Categoría", "Precio"};
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

    private void LlenarCampos(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        id = Integer.parseInt(vista.getTable1().getModel().getValueAt(target.getSelectedRow(), 0).toString());
        vista.getTextnombre().setText(vista.getTable1().getModel().getValueAt(target.getSelectedRow(), 1).toString());
        vista.getTextDescripcion().setText(vista.getTable1().getModel().getValueAt(target.getSelectedRow(), 2).toString());
        vista.getTextCategoria().setText(vista.getTable1().getModel().getValueAt(target.getSelectedRow(), 3).toString());
        vista.getTextPrecio().setText(vista.getTable1().getModel().getValueAt(target.getSelectedRow(), 4).toString());
    }

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

    private boolean cargarDatos() {
        try {
            nombre = vista.getTextnombre().getText().trim();
            descripcion = vista.getTextDescripcion().getText().trim();
            categoria = vista.getTextCategoria().getText().trim();
            precio = Double.parseDouble(vista.getTextPrecio().getText().trim());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo Precio debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

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

    private void agregarProducto() {
        if (validarDatos() && cargarDatos()) {
            Producto producto = new Producto(nombre, descripcion, categoria, precio);
            productoDAO.Agregar(producto);
            JOptionPane.showMessageDialog(null, "El producto se publicó correctamente.");
            limpiarCampos();
            ListarTabla();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getBtnPublicar()) {
            agregarProducto();
        }
    }
}
