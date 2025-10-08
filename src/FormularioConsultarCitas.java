package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormularioConsultarCitas extends JFrame {
    private JPanel panelPrincipal;
    private JTable tablaCitas;
    private DefaultTableModel modelo;
    private JTextField txtBuscar;
    private JComboBox<String> cmbFiltro;
    private JButton btnBuscar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JButton btnCerrar;
    
    public FormularioConsultarCitas() {
        inicializarComponentes();
        configurarVentana();
        agregarEventos();
        cargarDatosEjemplo();
    }
    
    private void inicializarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(245, 248, 250));
        
        // Panel superior con título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(25, 118, 210));
        panelTitulo.setPreferredSize(new Dimension(0, 60));
        
        JLabel lblTitulo = new JLabel("Consultar Citas Médicas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        
        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBusqueda.setBackground(new Color(245, 248, 250));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Búsqueda y Filtros"));
        
        JLabel lblFiltro = new JLabel("Filtrar por:");
        lblFiltro.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblFiltro.setForeground(new Color(50, 50, 50));
        panelBusqueda.add(lblFiltro);
        
        String[] filtros = {"Todos", "Paciente", "Médico", "Especialidad", "Fecha"};
        cmbFiltro = new JComboBox<>(filtros);
        cmbFiltro.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cmbFiltro.setBackground(Color.WHITE);
        cmbFiltro.setForeground(new Color(50, 50, 50));
        panelBusqueda.add(cmbFiltro);
        
        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblBuscar.setForeground(new Color(50, 50, 50));
        panelBusqueda.add(lblBuscar);
        
        txtBuscar = new JTextField(20);
        txtBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtBuscar.setBackground(Color.WHITE);
        txtBuscar.setForeground(new Color(50, 50, 50));
        panelBusqueda.add(txtBuscar);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnBuscar.setPreferredSize(new Dimension(80, 25));
        btnBuscar.setBackground(new Color(0, 100, 200));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        panelBusqueda.add(btnBuscar);
        
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnActualizar.setPreferredSize(new Dimension(80, 25));
        btnActualizar.setBackground(new Color(0, 150, 0));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFocusPainted(false);
        panelBusqueda.add(btnActualizar);
        
        // Tabla de citas
        String[] columnas = {"ID", "Paciente", "Médico", "Especialidad", "Fecha", "Hora", "Teléfono", "Estado"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
        };
        
        tablaCitas = new JTable(modelo);
        tablaCitas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tablaCitas.setRowHeight(25);
        tablaCitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaCitas.setBackground(Color.WHITE);
        tablaCitas.setForeground(new Color(50, 50, 50));
        tablaCitas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tablaCitas.getTableHeader().setBackground(new Color(25, 118, 210));
        tablaCitas.getTableHeader().setForeground(Color.WHITE);
        
        // Ajustar ancho de columnas
        tablaCitas.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID
        tablaCitas.getColumnModel().getColumn(1).setPreferredWidth(150); // Paciente
        tablaCitas.getColumnModel().getColumn(2).setPreferredWidth(120); // Médico
        tablaCitas.getColumnModel().getColumn(3).setPreferredWidth(120); // Especialidad
        tablaCitas.getColumnModel().getColumn(4).setPreferredWidth(100); // Fecha
        tablaCitas.getColumnModel().getColumn(5).setPreferredWidth(80);  // Hora
        tablaCitas.getColumnModel().getColumn(6).setPreferredWidth(120); // Teléfono
        tablaCitas.getColumnModel().getColumn(7).setPreferredWidth(100); // Estado
        
        JScrollPane scrollTabla = new JScrollPane(tablaCitas);
        scrollTabla.setPreferredSize(new Dimension(800, 300));
        
        // Panel de botones de acción
        JPanel panelAcciones = new JPanel();
        panelAcciones.setLayout(new FlowLayout());
        panelAcciones.setBackground(new Color(245, 248, 250));
        
        btnModificar = new JButton("Modificar Cita");
        btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnModificar.setPreferredSize(new Dimension(140, 35));
        btnModificar.setBackground(new Color(255, 140, 0));
        btnModificar.setForeground(Color.WHITE);
        btnModificar.setFocusPainted(false);
        
        btnEliminar = new JButton("Eliminar Cita");
        btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnEliminar.setPreferredSize(new Dimension(140, 35));
        btnEliminar.setBackground(new Color(200, 0, 0));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCerrar.setPreferredSize(new Dimension(100, 35));
        btnCerrar.setBackground(new Color(100, 100, 100));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        
        panelAcciones.add(btnModificar);
        panelAcciones.add(btnEliminar);
        panelAcciones.add(btnCerrar);
        
        // Agregar paneles al panel principal
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelBusqueda, BorderLayout.CENTER);
        panelPrincipal.add(scrollTabla, BorderLayout.CENTER);
        panelPrincipal.add(panelAcciones, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    private void configurarVentana() {
        setTitle("Consultar Citas Médicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    private void agregarEventos() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCitas();
            }
        });
        
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatosEjemplo();
            }
        });
        
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarCita();
            }
        });
        
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCita();
            }
        });
        
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        // Permitir búsqueda al presionar Enter
        txtBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCitas();
            }
        });
    }
    
    private void cargarDatosEjemplo() {
        // Limpiar tabla
        modelo.setRowCount(0);
        
        // Agregar datos de ejemplo
        modelo.addRow(new Object[]{"001", "Juan Pérez", "Dr. García", "Medicina General", "15/12/2024", "09:00", "555-1234", "Programada"});
        modelo.addRow(new Object[]{"002", "María López", "Dra. Rodríguez", "Cardiología", "16/12/2024", "10:30", "555-5678", "Programada"});
        modelo.addRow(new Object[]{"003", "Carlos Martínez", "Dr. Sánchez", "Dermatología", "17/12/2024", "14:00", "555-9012", "Completada"});
        modelo.addRow(new Object[]{"004", "Ana Fernández", "Dra. López", "Ginecología", "18/12/2024", "11:15", "555-3456", "Programada"});
        modelo.addRow(new Object[]{"005", "Luis González", "Dr. Martínez", "Pediatría", "19/12/2024", "16:30", "555-7890", "Cancelada"});
    }
    
    private void buscarCitas() {
        String filtro = (String) cmbFiltro.getSelectedItem();
        String busqueda = txtBuscar.getText().trim().toLowerCase();
        
        if (busqueda.isEmpty()) {
            cargarDatosEjemplo();
            return;
        }
        
        // Limpiar tabla
        modelo.setRowCount(0);
        
        // Datos de ejemplo para búsqueda
        String[][] datosEjemplo = {
            {"001", "Juan Pérez", "Dr. García", "Medicina General", "15/12/2024", "09:00", "555-1234", "Programada"},
            {"002", "María López", "Dra. Rodríguez", "Cardiología", "16/12/2024", "10:30", "555-5678", "Programada"},
            {"003", "Carlos Martínez", "Dr. Sánchez", "Dermatología", "17/12/2024", "14:00", "555-9012", "Completada"},
            {"004", "Ana Fernández", "Dra. López", "Ginecología", "18/12/2024", "11:15", "555-3456", "Programada"},
            {"005", "Luis González", "Dr. Martínez", "Pediatría", "19/12/2024", "16:30", "555-7890", "Cancelada"}
        };
        
        // Filtrar datos según el criterio seleccionado
        for (String[] fila : datosEjemplo) {
            boolean coincide = false;
            
            switch (filtro) {
                case "Paciente":
                    coincide = fila[1].toLowerCase().contains(busqueda);
                    break;
                case "Médico":
                    coincide = fila[2].toLowerCase().contains(busqueda);
                    break;
                case "Especialidad":
                    coincide = fila[3].toLowerCase().contains(busqueda);
                    break;
                case "Fecha":
                    coincide = fila[4].contains(busqueda);
                    break;
                case "Todos":
                    coincide = fila[1].toLowerCase().contains(busqueda) ||
                              fila[2].toLowerCase().contains(busqueda) ||
                              fila[3].toLowerCase().contains(busqueda) ||
                              fila[4].contains(busqueda);
                    break;
            }
            
            if (coincide) {
                modelo.addRow(fila);
            }
        }
    }
    
    private void modificarCita() {
        int filaSeleccionada = tablaCitas.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una cita para modificar", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String idCita = (String) modelo.getValueAt(filaSeleccionada, 0);
        String paciente = (String) modelo.getValueAt(filaSeleccionada, 1);
        
        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Desea modificar la cita de " + paciente + " (ID: " + idCita + ")?", 
            "Confirmar Modificación", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            // Aquí se abriría el formulario de modificación
            JOptionPane.showMessageDialog(this, "Funcionalidad de modificación en desarrollo", 
                                        "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void eliminarCita() {
        int filaSeleccionada = tablaCitas.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una cita para eliminar", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String idCita = (String) modelo.getValueAt(filaSeleccionada, 0);
        String paciente = (String) modelo.getValueAt(filaSeleccionada, 1);
        
        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea eliminar la cita de " + paciente + " (ID: " + idCita + ")?", 
            "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            modelo.removeRow(filaSeleccionada);
            JOptionPane.showMessageDialog(this, "Cita eliminada exitosamente", 
                                        "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
