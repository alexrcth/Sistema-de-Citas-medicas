package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdministracion extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelContenido;
    private JButton btnCitas, btnPacientes, btnDoctores, btnHistoriales, btnReportes;
    private String seccionActual = "Reportes";
    
    public PanelAdministracion() {
        inicializarComponentes();
        configurarVentana();
        agregarEventos();
        mostrarSeccion("Reportes");
    }
    
    private void inicializarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(248, 250, 252));
        
        // Panel superior con título
        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new BorderLayout());
        panelHeader.setBackground(Color.WHITE);
        panelHeader.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        // Título y subtítulo
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelTitulo.setBackground(Color.WHITE);
        
        JLabel lblIcono = new JLabel("❤️");
        lblIcono.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
        panelTitulo.add(lblIcono);
        
        JLabel lblTitulo = new JLabel("Sistema de Citas Médicas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(31, 41, 55));
        panelTitulo.add(lblTitulo);
        
        JLabel lblSubtitulo = new JLabel("Panel de Administración");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(107, 114, 128));
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        panelTitulo.add(lblSubtitulo);
        
        // Panel de usuario
        JPanel panelUsuario = new JPanel();
        panelUsuario.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelUsuario.setBackground(Color.WHITE);
        
        JLabel lblUsuario = new JLabel("👤 Administrador");
        lblUsuario.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
        lblUsuario.setForeground(new Color(107, 114, 128));
        panelUsuario.add(lblUsuario);
        
        JButton btnSalir = new JButton("→ Salir");
        btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnSalir.setBackground(new Color(248, 250, 252));
        btnSalir.setForeground(new Color(31, 41, 55));
        btnSalir.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnSalir.setFocusPainted(false);
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelUsuario.add(btnSalir);
        
        panelHeader.add(panelTitulo, BorderLayout.WEST);
        panelHeader.add(panelUsuario, BorderLayout.EAST);
        
        // Panel de navegación
        JPanel panelNavegacion = new JPanel();
        panelNavegacion.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelNavegacion.setBackground(new Color(248, 250, 252));
        panelNavegacion.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        
        btnReportes = crearBotonNavegacion("📈 Reportes", "Reportes");
        btnCitas = crearBotonNavegacion("📅 Citas", "Citas");
        btnPacientes = crearBotonNavegacion("👥 Pacientes", "Pacientes");
        btnDoctores = crearBotonNavegacion("🩺 Doctores", "Doctores");
        btnHistoriales = crearBotonNavegacion("📋 Historiales", "Historiales");
        
        panelNavegacion.add(btnReportes);
        panelNavegacion.add(btnCitas);
        panelNavegacion.add(btnPacientes);
        panelNavegacion.add(btnDoctores);
        panelNavegacion.add(btnHistoriales);
        
        // Panel de contenido
        panelContenido = new JPanel();
        panelContenido.setLayout(new BorderLayout());
        panelContenido.setBackground(new Color(248, 250, 252));
        panelContenido.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
        
        // Agregar paneles al panel principal
        panelPrincipal.add(panelHeader, BorderLayout.NORTH);
        panelPrincipal.add(panelNavegacion, BorderLayout.CENTER);
        panelPrincipal.add(panelContenido, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    private JButton crearBotonNavegacion(String texto, String seccion) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
        boton.setPreferredSize(new Dimension(120, 50));
        boton.setBackground(new Color(229, 231, 235));
        boton.setForeground(Color.BLACK);
        boton.setBorder(BorderFactory.createLineBorder(new Color(229, 231, 235), 1));
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.putClientProperty("seccion", seccion);
        
        // Forzar que el botón no use el Look and Feel del sistema
        boton.setContentAreaFilled(true);
        
        
        return boton;
    }
    
    private void configurarVentana() {
        setTitle("Sistema de Citas Médicas - Panel de Administración");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    private void agregarEventos() {
        btnCitas.addActionListener(e -> mostrarSeccion("Citas"));
        btnPacientes.addActionListener(e -> mostrarSeccion("Pacientes"));
        btnDoctores.addActionListener(e -> mostrarSeccion("Doctores"));
        btnHistoriales.addActionListener(e -> mostrarSeccion("Historiales"));
        btnReportes.addActionListener(e -> mostrarSeccion("Reportes"));
    }
    
    private void mostrarSeccion(String seccion) {
        seccionActual = seccion;
        actualizarNavegacion();
        
        panelContenido.removeAll();
        
        switch (seccion) {
            case "Citas":
                panelContenido.add(crearPanelCitas(), BorderLayout.CENTER);
                break;
            case "Pacientes":
                panelContenido.add(crearPanelPacientes(), BorderLayout.CENTER);
                break;
            case "Doctores":
                panelContenido.add(crearPanelDoctores(), BorderLayout.CENTER);
                break;
            case "Historiales":
                panelContenido.add(crearPanelHistoriales(), BorderLayout.CENTER);
                break;
            case "Reportes":
                panelContenido.add(crearPanelReportesCompleto(), BorderLayout.CENTER);
                break;
        }
        
        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    private void actualizarNavegacion() {
        JButton[] botones = {btnCitas, btnPacientes, btnDoctores, btnHistoriales, btnReportes};
        
        for (JButton boton : botones) {
            String seccion = (String) boton.getClientProperty("seccion");
            
            // Forzar que el botón use nuestros colores personalizados
            boton.setContentAreaFilled(true);
            
            if (seccion.equals(seccionActual)) {
                // Botón seleccionado - color morado sólido
                boton.setBackground(new Color(150, 0, 150));
                boton.setForeground(Color.WHITE);
                boton.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
            } else {
                // Botón no seleccionado - fondo blanco
                boton.setBackground(Color.WHITE);
                boton.setForeground(new Color(150, 0, 150));
                boton.setBorder(BorderFactory.createLineBorder(new Color(229, 231, 235), 1));
            }
        }
    }
    
    private JPanel crearPanelResumen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 250, 252));
        
        // Título
        JLabel lblTitulo = new JLabel("Resumen General");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(31, 41, 55));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        panel.add(lblTitulo, BorderLayout.NORTH);
        
        // Panel de tarjetas de estadísticas
        JPanel panelTarjetas = new JPanel();
        panelTarjetas.setLayout(new GridLayout(1, 4, 25, 0));
        panelTarjetas.setBackground(new Color(248, 250, 252));
        panelTarjetas.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        
        // Tarjeta 1: Citas Hoy
        JPanel tarjeta1 = crearTarjetaConBotones("Citas Hoy", "24", "+12% vs mes anterior", new Color(0, 150, 0));
        panelTarjetas.add(tarjeta1);
        
        // Tarjeta 2: Pacientes Activos
        JPanel tarjeta2 = crearTarjetaConBotones("Pacientes Activos", "1,234", "+5% vs mes anterior", new Color(0, 100, 200));
        panelTarjetas.add(tarjeta2);
        
        // Tarjeta 3: Doctores
        JPanel tarjeta3 = crearTarjetaConBotones("Doctores", "18", "+2 vs mes anterior", new Color(150, 0, 150));
        panelTarjetas.add(tarjeta3);
        
        // Tarjeta 4: Consultas Mes
        JPanel tarjeta4 = crearTarjetaConBotones("Consultas Mes", "892", "+18% vs mes anterior", new Color(255, 140, 0));
        panelTarjetas.add(tarjeta4);
        
        panel.add(panelTarjetas, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel crearPanelReportesCompleto() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 250, 252));
        
        // Panel superior con título y botón
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBackground(new Color(248, 250, 252));
        
        JLabel lhsblTitulo = new JLabel("Resumen y Reportes");
        lhsblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lhsblTitulo.setForeground(new Color(31, 41, 55));
        panelTitulo.add(lhsblTitulo, BorderLayout.WEST);
        
        JLabel lhsblSubtitulo = new JLabel("Análisis completo y estadísticas de la clínica");
        lhsblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lhsblSubtitulo.setForeground(new Color(107, 114, 128));
        lhsblSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        panelTitulo.add(lhsblSubtitulo, BorderLayout.SOUTH);
        
        JButton lhsbtnExportarReporte = new JButton("Exportar Reporte");
        lhsbtnExportarReporte.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lhsbtnExportarReporte.setPreferredSize(new Dimension(200, 45));
        lhsbtnExportarReporte.setBackground(new Color(72, 69, 165));
        lhsbtnExportarReporte.setForeground(Color.WHITE);
        lhsbtnExportarReporte.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(72, 69, 165), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        lhsbtnExportarReporte.setFocusPainted(false);
        lhsbtnExportarReporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lhsbtnExportarReporte.setContentAreaFilled(true);
        lhsbtnExportarReporte.setOpaque(true);
        lhsbtnExportarReporte.setBorderPainted(true);
        lhsbtnExportarReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lhsbtnExportarReporte.setBackground(new Color(60, 57, 140));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lhsbtnExportarReporte.setBackground(new Color(72, 69, 165));
            }
        });
        panelTitulo.add(lhsbtnExportarReporte, BorderLayout.EAST);
        
        panel.add(panelTitulo, BorderLayout.NORTH);
        
        // Panel de contenido con scroll para mostrar todo
        JPanel panelContenidoCompleto = new JPanel();
        panelContenidoCompleto.setLayout(new BorderLayout());
        panelContenidoCompleto.setBackground(new Color(248, 250, 252));
        
        // Agregar tarjetas de estadísticas básicas (Resumen)
        JPanel lhspanelResumen = new JPanel();
        lhspanelResumen.setLayout(new GridLayout(1, 4, 25, 0));
        lhspanelResumen.setBackground(new Color(248, 250, 252));
        lhspanelResumen.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        
        // Tarjetas de Resumen
        JPanel lhstarjeta1 = crearTarjetaEstadistica("📅", "Citas Hoy", "24", "+12% vs mes anterior", new Color(0, 150, 0));
        lhspanelResumen.add(lhstarjeta1);
        
        JPanel lhstarjeta2 = crearTarjetaEstadistica("👥", "Pacientes Activos", "1,234", "+5% vs mes anterior", new Color(0, 100, 200));
        lhspanelResumen.add(lhstarjeta2);
        
        JPanel lhstarjeta3 = crearTarjetaEstadistica("🩺", "Doctores", "18", "+2 vs mes anterior", new Color(150, 0, 150));
        lhspanelResumen.add(lhstarjeta3);
        
        JPanel lhstarjeta4 = crearTarjetaEstadistica("📋", "Consultas Mes", "892", "+18% vs mes anterior", new Color(255, 140, 0));
        lhspanelResumen.add(lhstarjeta4);
        
        panelContenidoCompleto.add(lhspanelResumen, BorderLayout.NORTH);
        
        // Agregar tarjetas de reportes avanzados
        JPanel lhspanelReportes = new JPanel();
        lhspanelReportes.setLayout(new GridLayout(1, 4, 25, 0));
        lhspanelReportes.setBackground(new Color(248, 250, 252));
        lhspanelReportes.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        
        // Tarjetas de Reportes
        JPanel lhsrhstarjeta1 = crearTarjetaReporte("📈", "Total Citas", "1,234", "+12% vs período anterior", new Color(34, 197, 94));
        lhspanelReportes.add(lhsrhstarjeta1);
        
        JPanel lhsrhstarjeta2 = crearTarjetaReporte("👥", "Pacientes Únicos", "892", "+8% vs período anterior", new Color(59, 130, 246));
        lhspanelReportes.add(lhsrhstarjeta2);
        
        JPanel lhsrhstarjeta3 = crearTarjetaReporte("📊", "Tasa Completadas", "94.2%", "+2.1% vs período anterior", new Color(168, 85, 247));
        lhspanelReportes.add(lhsrhstarjeta3);
        
        JPanel lhsrhstarjeta4 = crearTarjetaReporte("🕐", "Tiempo Promedio", "32 min", "-3 min vs período anterior", new Color(245, 158, 11));
        lhspanelReportes.add(lhsrhstarjeta4);
        
        panelContenidoCompleto.add(lhspanelReportes, BorderLayout.CENTER);
        
        // Scroll para el contenido completo
        JScrollPane lhsScrollPane = new JScrollPane(panelContenidoCompleto);
        lhsScrollPane.setBorder(BorderFactory.createEmptyBorder());
        lhsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        lhsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        panel.add(lhsScrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void mostrarConfirmacionEliminar(JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(
                this,
                "⚠️ Por favor selecciona un registro de la tabla para eliminar",
                "Registro no seleccionado",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        // Obtener el nombre del paciente para mostrar en el mensaje
        String nombrePaciente = tabla.getValueAt(filaSeleccionada, 0).toString().split("\n")[0];
        
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que deseas eliminar el registro de:\n\n" + nombrePaciente + "\n\nEsta acción no se puede deshacer.",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        
        if (opcion == JOptionPane.YES_OPTION) {
            // Simular eliminación del modelo de datos
            ((DefaultTableModel) tabla.getModel()).removeRow(filaSeleccionada);
            
            JOptionPane.showMessageDialog(
                this,
                "✅ Registro de " + nombrePaciente + " eliminado exitosamente",
                "Eliminación completada",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    private void eliminarCitaSeleccionada(JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(
                this,
                "⚠️ Por favor selecciona una cita de la tabla para eliminar",
                "Cita no seleccionada",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        // Obtener información de la cita
        String paciente = tabla.getValueAt(filaSeleccionada, 0).toString().split("\n")[0];
        String fechaHora = tabla.getValueAt(filaSeleccionada, 2).toString().split("\n")[0];
        
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que deseas eliminar la cita de:\n\n" + paciente + "\nFecha: " + fechaHora + "\n\nEsta acción no se puede deshacer.",
            "Confirmar eliminación de cita",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        
        if (opcion == JOptionPane.YES_OPTION) {
            // Simular eliminación del modelo de datos
            ((DefaultTableModel) tabla.getModel()).removeRow(filaSeleccionada);
            
            JOptionPane.showMessageDialog(
                this,
                "✅ Cita de " + paciente + " eliminada exitosamente",
                "Eliminación completada",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    private void eliminarDoctorSeleccionado(JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(
                this,
                "⚠️ Por favor selecciona un doctor de la tabla para eliminar",
                "Doctor no seleccionado",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        // Obtener información del doctor
        String doctor = tabla.getValueAt(filaSeleccionada, 0).toString().split("\n")[0];
        String especialidad = tabla.getValueAt(filaSeleccionada, 1).toString();
        
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que deseas eliminar el doctor:\n\n" + doctor + "\nEspecialidad: " + especialidad + "\n\nEsta acción no se puede deshacer.",
            "Confirmar eliminación de doctor",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        
        if (opcion == JOptionPane.YES_OPTION) {
            // Simular eliminación del modelo de datos
            ((DefaultTableModel) tabla.getModel()).removeRow(filaSeleccionada);
            
            JOptionPane.showMessageDialog(
                this,
                "✅ " + doctor + " eliminado del sistema exitosamente",
                "Eliminación completada",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    private void eliminarHistorialSeleccionado(JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(
                this,
                "⚠️ Por favor selecciona un historial de la tabla para eliminar",
                "Historial no seleccionado",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        // Obtener información del historial
        String paciente = tabla.getValueAt(filaSeleccionada, 0).toString().split("\n")[0];
        String fecha = tabla.getValueAt(filaSeleccionada, 2).toString();
        
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que deseas eliminar el historial médico de:\n\n" + paciente + "\nFecha: " + fecha + "\n\nEsta acción no se puede deshacer.",
            "Confirmar eliminación de historial",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        
        if (opcion == JOptionPane.YES_OPTION) {
            // Simular eliminación del modelo de datos
            ((DefaultTableModel) tabla.getModel()).removeRow(filaSeleccionada);
            
            JOptionPane.showMessageDialog(
                this,
                "✅ Historial médico de " + paciente + " eliminado exitosamente",
                "Eliminación completada",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    private JPanel crearTarjetaConBotones(String titulo, String valor, String cambio, Color color) {
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(new BorderLayout());
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        tarjeta.setPreferredSize(new Dimension(280, 180));
        
        // Panel superior con título
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.setBackground(Color.WHITE);
        
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(new Color(31, 41, 55));
        panelSuperior.add(lblTitulo, BorderLayout.WEST);
        
        // Panel central con valor
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.setBackground(Color.WHITE);
        
        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblValor.setForeground(new Color(31, 41, 55));
        lblValor.setHorizontalAlignment(SwingConstants.LEFT);
        lblValor.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
        panelCentral.add(lblValor, BorderLayout.CENTER);
        
        // Panel inferior con cambio y botones
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBackground(Color.WHITE);
        
        JLabel lblCambio = new JLabel(cambio);
        lblCambio.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCambio.setForeground(color);
        lblCambio.setHorizontalAlignment(SwingConstants.LEFT);
        panelInferior.add(lblCambio, BorderLayout.WEST);
        
        // Botones de acción
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        panelBotones.setBackground(Color.WHITE);
        
        JButton btnEditar = new JButton("✏️");
        btnEditar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
        btnEditar.setPreferredSize(new Dimension(30, 30));
        btnEditar.setBackground(new Color(59, 130, 246));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        btnEditar.setFocusPainted(false);
        btnEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEditar.setContentAreaFilled(true);
        btnEditar.setOpaque(true);
        btnEditar.setBorderPainted(false);
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditar.setBackground(new Color(37, 99, 235));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditar.setBackground(new Color(59, 130, 246));
            }
        });
        
        JButton btnEliminar = new JButton("🗑️");
        btnEliminar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
        btnEliminar.setPreferredSize(new Dimension(30, 30));
        btnEliminar.setBackground(new Color(239, 68, 68));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminar.setContentAreaFilled(true);
        btnEliminar.setOpaque(true);
        btnEliminar.setBorderPainted(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminar.setBackground(new Color(220, 38, 38));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminar.setBackground(new Color(239, 68, 68));
            }
        });
        
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        
        panelInferior.add(panelBotones, BorderLayout.EAST);
        
        // Agregar paneles a la tarjeta
        tarjeta.add(panelSuperior, BorderLayout.NORTH);
        tarjeta.add(panelCentral, BorderLayout.CENTER);
        tarjeta.add(panelInferior, BorderLayout.SOUTH);
        
        return tarjeta;
    }
    
    private JPanel crearTarjetaEstadistica(String icono, String titulo, String valor, String cambio, Color color) {
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(new BorderLayout());
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        tarjeta.setPreferredSize(new Dimension(250, 150));
        
        // Panel superior con icono y título
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.setBackground(Color.WHITE);
        
        JLabel lblIcono = new JLabel(icono);
        lblIcono.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
        lblIcono.setHorizontalAlignment(SwingConstants.LEFT);
        panelSuperior.add(lblIcono, BorderLayout.WEST);
        
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(new Color(31, 41, 55));
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        panelSuperior.add(lblTitulo, BorderLayout.CENTER);
        
        // Panel central con valor
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.setBackground(Color.WHITE);
        
        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblValor.setForeground(new Color(31, 41, 55));
        lblValor.setHorizontalAlignment(SwingConstants.LEFT);
        lblValor.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
        panelCentral.add(lblValor, BorderLayout.CENTER);
        
        // Panel inferior con cambio
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBackground(Color.WHITE);
        
        JLabel lblCambio = new JLabel(cambio);
        lblCambio.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCambio.setForeground(color);
        lblCambio.setHorizontalAlignment(SwingConstants.LEFT);
        panelInferior.add(lblCambio, BorderLayout.CENTER);
        
        // Agregar paneles a la tarjeta
        tarjeta.add(panelSuperior, BorderLayout.NORTH);
        tarjeta.add(panelCentral, BorderLayout.CENTER);
        tarjeta.add(panelInferior, BorderLayout.SOUTH);
        
        return tarjeta;
    }
    
    private JPanel crearPanelCitas() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 250, 252));
        
        // Título y botón
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBackground(new Color(248, 250, 252));
        
        JLabel lblTitulo = new JLabel("Gestión de Citas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(31, 41, 55));
        panelTitulo.add(lblTitulo, BorderLayout.WEST);
        
        JLabel lblSubtitulo = new JLabel("Administra las citas médicas del sistema");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(107, 114, 128));
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        panelTitulo.add(lblSubtitulo, BorderLayout.SOUTH);
        
        JButton btnNuevaCita = new JButton("+ Nueva Cita");
        btnNuevaCita.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnNuevaCita.setPreferredSize(new Dimension(200, 45));
        btnNuevaCita.setBackground(new Color(72, 69, 165));
        btnNuevaCita.setForeground(Color.WHITE);
        btnNuevaCita.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(72, 69, 165), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnNuevaCita.setFocusPainted(false);
        btnNuevaCita.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNuevaCita.setContentAreaFilled(true);
        btnNuevaCita.setOpaque(true);
        btnNuevaCita.setBorderPainted(true);
        btnNuevaCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevaCita.setBackground(new Color(60, 57, 140));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevaCita.setBackground(new Color(72, 69, 165));
            }
        });
        btnNuevaCita.addActionListener(e -> new FormularioNuevaCitaModal().setVisible(true));
        panelTitulo.add(btnNuevaCita, BorderLayout.EAST);
        
        panel.add(panelTitulo, BorderLayout.NORTH);
        
        
        // Panel de tabla de citas
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(Color.WHITE);
        panelTabla.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel lblTablaTitulo = new JLabel("Lista de Citas (4)");
        lblTablaTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTablaTitulo.setForeground(new Color(31, 41, 55));
        panelTabla.add(lblTablaTitulo, BorderLayout.NORTH);
        
        JLabel lblTablaSubtitulo = new JLabel("Citas programadas en el sistema");
        lblTablaSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTablaSubtitulo.setForeground(new Color(107, 114, 128));
        lblTablaSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        panelTabla.add(lblTablaSubtitulo, BorderLayout.CENTER);
        
        // Crear tabla de citas
        String[] columnas = {"Paciente", "Doctor", "Fecha y Hora", "Tipo", "Estado", "Notas"};
        Object[][] datos = {
            {"Juan Rodríguez\n+503 7123-4567", "Dr. García\nCardiología", "vie, 9 feb 2024\n09:00 (30 min)", "Consulta General", "Confirmada", "Control rutinario"},
            {"María López\n+503 7234-5678", "Dra. Rodríguez\nPediatría", "vie, 9 feb 2024\n10:30 (45 min)", "Primera Consulta", "Pendiente", "Paciente nuevo"},
            {"Carlos Martínez\n+503 7345-6789", "Dr. Sánchez\nDermatología", "vie, 9 feb 2024\n14:00 (30 min)", "Seguimiento", "Completada", "Revisión de exámenes"},
            {"Ana Fernández\n+503 7456-7890", "Dra. López\nGinecología", "vie, 9 feb 2024\n16:30 (45 min)", "Consulta Especializada", "Cancelada", "Cancelada por el paciente"}
        };
        
        JTable tablaCitas = new JTable(datos, columnas);
        tablaCitas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tablaCitas.setRowHeight(60);
        tablaCitas.setBackground(Color.WHITE);
        tablaCitas.setForeground(new Color(31, 41, 55));
        tablaCitas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tablaCitas.getTableHeader().setBackground(new Color(248, 250, 252));
        tablaCitas.getTableHeader().setForeground(new Color(31, 41, 55));
        tablaCitas.setGridColor(new Color(229, 231, 235));
        tablaCitas.setShowGrid(true);
        
        // Ajustar ancho de columnas
        tablaCitas.getColumnModel().getColumn(0).setPreferredWidth(160);
        tablaCitas.getColumnModel().getColumn(1).setPreferredWidth(160);
        tablaCitas.getColumnModel().getColumn(2).setPreferredWidth(200);
        tablaCitas.getColumnModel().getColumn(3).setPreferredWidth(140);
        tablaCitas.getColumnModel().getColumn(4).setPreferredWidth(120);
        tablaCitas.getColumnModel().getColumn(5).setPreferredWidth(220);
        
        JScrollPane scrollTabla = new JScrollPane(tablaCitas);
        scrollTabla.setPreferredSize(new Dimension(0, 300));
        panelTabla.add(scrollTabla, BorderLayout.SOUTH);
        
        // Panel principal que contiene la tabla y los botones
        JPanel panelTablaConBotonesCitas = new JPanel();
        panelTablaConBotonesCitas.setLayout(new BorderLayout());
        panelTablaConBotonesCitas.setBackground(Color.WHITE);
        panelTablaConBotonesCitas.add(panelTabla, BorderLayout.CENTER);
        
        // Panel de botones de acción para citas
        JPanel panelBotonesAccionCitas = new JPanel();
        panelBotonesAccionCitas.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        panelBotonesAccionCitas.setBackground(Color.WHITE);
        panelBotonesAccionCitas.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        JButton btnEliminarCita = new JButton("Eliminar Cita");
        btnEliminarCita.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnEliminarCita.setPreferredSize(new Dimension(160, 45));
        btnEliminarCita.setBackground(new Color(239, 68, 68));
        btnEliminarCita.setForeground(Color.WHITE);
        btnEliminarCita.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(239, 68, 68), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnEliminarCita.setFocusPainted(false);
        btnEliminarCita.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminarCita.setContentAreaFilled(true);
        btnEliminarCita.setOpaque(true);
        btnEliminarCita.setBorderPainted(true);
        btnEliminarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarCita.setBackground(new Color(220, 38, 38));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarCita.setBackground(new Color(239, 68, 68));
            }
        });
        btnEliminarCita.addActionListener(e -> eliminarCitaSeleccionada(tablaCitas));
        
        panelBotonesAccionCitas.add(btnEliminarCita);
        panelTablaConBotonesCitas.add(panelBotonesAccionCitas, BorderLayout.SOUTH);
        
        panel.add(panelTablaConBotonesCitas, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel crearPanelPacientes() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 250, 252));
        
        // Título y botón
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBackground(new Color(248, 250, 252));
        
        JLabel lblTitulo = new JLabel("Gestión de Pacientes");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(31, 41, 55));
        panelTitulo.add(lblTitulo, BorderLayout.WEST);
        
        JLabel lblSubtitulo = new JLabel("Administra la información de los pacientes");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(107, 114, 128));
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        panelTitulo.add(lblSubtitulo, BorderLayout.SOUTH);
        
        JButton btnAgregarPaciente = new JButton("+ Agregar Paciente");
        btnAgregarPaciente.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnAgregarPaciente.setPreferredSize(new Dimension(200, 45));
        btnAgregarPaciente.setBackground(new Color(72, 69, 165));
        btnAgregarPaciente.setForeground(Color.WHITE);
        btnAgregarPaciente.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(72, 69, 165), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnAgregarPaciente.setFocusPainted(false);
        btnAgregarPaciente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAgregarPaciente.setContentAreaFilled(true);
        btnAgregarPaciente.setOpaque(true);
        btnAgregarPaciente.setBorderPainted(true);
        btnAgregarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarPaciente.setBackground(new Color(60, 57, 140));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarPaciente.setBackground(new Color(72, 69, 165));
            }
        });
        btnAgregarPaciente.addActionListener(e -> new FormularioAgregarPacienteModal().setVisible(true));
        panelTitulo.add(btnAgregarPaciente, BorderLayout.EAST);
        
        panel.add(panelTitulo, BorderLayout.NORTH);
        
        
        // Panel de tabla de pacientes
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(Color.WHITE);
        panelTabla.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel lblTablaTitulo = new JLabel("Lista de Pacientes (4)");
        lblTablaTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTablaTitulo.setForeground(new Color(31, 41, 55));
        panelTabla.add(lblTablaTitulo, BorderLayout.NORTH);
        
        JLabel lblTablaSubtitulo = new JLabel("Pacientes registrados en el sistema");
        lblTablaSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTablaSubtitulo.setForeground(new Color(107, 114, 128));
        lblTablaSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        panelTabla.add(lblTablaSubtitulo, BorderLayout.CENTER);
        
        // Crear tabla de pacientes
        String[] columnas = {"Paciente", "Contacto", "Información Médica", "Última Visita", "Próxima Cita", "Estado"};
        Object[][] datos = {
            {"María González Pérez\n34 años, Femenino", "maria.gonzalez@email.com\n+503 7123-4567\nCol. Escalón, San Salvador", "Tipo: O+\nEmergencia: Juan González - +503 7234-5678", "14/1/2024", "9/2/2024", "Activo"},
            {"Carlos Mendoza Rivera\n45 años, Masculino", "carlos.mendoza@email.com\n+503 7234-5678\nCol. San Benito, San Salvador", "Tipo: A+\nEmergencia: Ana Mendoza - +503 7345-6789", "19/1/2024", "14/2/2024", "Activo"},
            {"Ana Martínez López\n28 años, Femenino", "ana.martinez@email.com\n+503 7345-6789\nCol. Maquilishuat, San Salvador", "Tipo: B+\nEmergencia: Luis Martínez - +503 7456-7890", "24/1/2024", "No programada", "Activo"},
            {"Luis Hernández Castro\n52 años, Masculino", "luis.hernandez@email.com\n+503 7456-7890\nCol. Centroamérica, San Salvador", "Tipo: AB+\nEmergencia: Carmen Hernández - +503 7567-8901", "9/12/2023", "19/2/2024", "Inactivo"}
        };
        
        JTable tablaPacientes = new JTable(datos, columnas);
        tablaPacientes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tablaPacientes.setRowHeight(80);
        tablaPacientes.setBackground(Color.WHITE);
        tablaPacientes.setForeground(new Color(31, 41, 55));
        tablaPacientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tablaPacientes.getTableHeader().setBackground(new Color(248, 250, 252));
        tablaPacientes.getTableHeader().setForeground(new Color(31, 41, 55));
        tablaPacientes.setGridColor(new Color(229, 231, 235));
        tablaPacientes.setShowGrid(true);
        
        // Ajustar ancho de columnas
        tablaPacientes.getColumnModel().getColumn(0).setPreferredWidth(200);
        tablaPacientes.getColumnModel().getColumn(1).setPreferredWidth(280);
        tablaPacientes.getColumnModel().getColumn(2).setPreferredWidth(220);
        tablaPacientes.getColumnModel().getColumn(3).setPreferredWidth(140);
        tablaPacientes.getColumnModel().getColumn(4).setPreferredWidth(140);
        tablaPacientes.getColumnModel().getColumn(5).setPreferredWidth(120);
        
        JScrollPane scrollTabla = new JScrollPane(tablaPacientes);
        scrollTabla.setPreferredSize(new Dimension(0, 300));
        panelTabla.add(scrollTabla, BorderLayout.SOUTH);
        
        // Panel principal que contiene la tabla y los botones
        JPanel panelTablaConBotones = new JPanel();
        panelTablaConBotones.setLayout(new BorderLayout());
        panelTablaConBotones.setBackground(Color.WHITE);
        panelTablaConBotones.add(panelTabla, BorderLayout.CENTER);
        
        // Panel de botones de acción
        JPanel panelBotonesAccion = new JPanel();
        panelBotonesAccion.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        panelBotonesAccion.setBackground(Color.WHITE);
        panelBotonesAccion.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        JButton btnEliminarPaciente = new JButton("Eliminar Registro");
        btnEliminarPaciente.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnEliminarPaciente.setPreferredSize(new Dimension(180, 45));
        btnEliminarPaciente.setBackground(new Color(239, 68, 68));
        btnEliminarPaciente.setForeground(Color.WHITE);
        btnEliminarPaciente.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(239, 68, 68), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnEliminarPaciente.setFocusPainted(false);
        btnEliminarPaciente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminarPaciente.setContentAreaFilled(true);
        btnEliminarPaciente.setOpaque(true);
        btnEliminarPaciente.setBorderPainted(true);
        btnEliminarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarPaciente.setBackground(new Color(220, 38, 38));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarPaciente.setBackground(new Color(239, 68, 68));
            }
        });
        btnEliminarPaciente.addActionListener(e -> mostrarConfirmacionEliminar(tablaPacientes));
        
        panelBotonesAccion.add(btnEliminarPaciente);
        panelTablaConBotones.add(panelBotonesAccion, BorderLayout.SOUTH);
        
        panel.add(panelTablaConBotones, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel crearPanelDoctores() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 250, 252));
        
        // Título y botón
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBackground(new Color(248, 250, 252));
        
        JLabel lblTitulo = new JLabel("Gestión de Doctores");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(31, 41, 55));
        panelTitulo.add(lblTitulo, BorderLayout.WEST);
        
        JLabel lblSubtitulo = new JLabel("Administra el personal médico de la clínica");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(107, 114, 128));
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        panelTitulo.add(lblSubtitulo, BorderLayout.SOUTH);
        
        JButton btnAgregarDoctor = new JButton("+ Agregar Doctor");
        btnAgregarDoctor.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnAgregarDoctor.setPreferredSize(new Dimension(200, 45));
        btnAgregarDoctor.setBackground(new Color(72, 69, 165));
        btnAgregarDoctor.setForeground(Color.WHITE);
        btnAgregarDoctor.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(72, 69, 165), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnAgregarDoctor.setFocusPainted(false);
        btnAgregarDoctor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAgregarDoctor.setContentAreaFilled(true);
        btnAgregarDoctor.setOpaque(true);
        btnAgregarDoctor.setBorderPainted(true);
        btnAgregarDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarDoctor.setBackground(new Color(60, 57, 140));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarDoctor.setBackground(new Color(72, 69, 165));
            }
        });
        btnAgregarDoctor.addActionListener(e -> new FormularioAgregarDoctorModal().setVisible(true));
        panelTitulo.add(btnAgregarDoctor, BorderLayout.EAST);
        
        panel.add(panelTitulo, BorderLayout.NORTH);
        
        
        // Panel de tabla de doctores
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(Color.WHITE);
        panelTabla.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel lblTablaTitulo = new JLabel("Lista de Doctores (4)");
        lblTablaTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTablaTitulo.setForeground(new Color(31, 41, 55));
        panelTabla.add(lblTablaTitulo, BorderLayout.NORTH);
        
        JLabel lblTablaSubtitulo = new JLabel("Personal médico registrado en el sistema");
        lblTablaSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTablaSubtitulo.setForeground(new Color(107, 114, 128));
        lblTablaSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        panelTabla.add(lblTablaSubtitulo, BorderLayout.CENTER);
        
        // Crear tabla de doctores
        String[] columnas = {"Doctor", "Especialidad", "Contacto", "Horario", "Pacientes", "Estado"};
        Object[][] datos = {
            {"🩺 Dr. Juan Rodríguez\n15 años de experiencia", "Cardiología", "j.rodriguez@clinica.com\n+503 7123-4567", "🕐 Lun-Vie 8:00-16:00", "45 pacientes", "Activo"},
            {"🩺 Dra. María López\n12 años de experiencia", "Pediatría", "m.lopez@clinica.com\n+503 7234-5678", "🕐 Lun-Vie 9:00-17:00", "62 pacientes", "Activo"},
            {"🩺 Dr. Carlos García\n8 años de experiencia", "Medicina General", "c.garcia@clinica.com\n+503 7345-6789", "🕐 Lun-Sab 7:00-15:00", "78 pacientes", "Activo"},
            {"🩺 Dra. Ana Martínez\n20 años de experiencia", "Ginecología", "a.martinez@clinica.com\n+503 7456-7890", "🕐 Mar-Sab 10:00-18:00", "34 pacientes", "Inactivo"}
        };
        
        JTable tablaDoctores = new JTable(datos, columnas);
        tablaDoctores.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tablaDoctores.setRowHeight(80);
        tablaDoctores.setBackground(Color.WHITE);
        tablaDoctores.setForeground(new Color(31, 41, 55));
        tablaDoctores.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tablaDoctores.getTableHeader().setBackground(new Color(248, 250, 252));
        tablaDoctores.getTableHeader().setForeground(new Color(31, 41, 55));
        tablaDoctores.setGridColor(new Color(229, 231, 235));
        tablaDoctores.setShowGrid(true);
        
        // Ajustar ancho de columnas
        tablaDoctores.getColumnModel().getColumn(0).setPreferredWidth(220);
        tablaDoctores.getColumnModel().getColumn(1).setPreferredWidth(140);
        tablaDoctores.getColumnModel().getColumn(2).setPreferredWidth(220);
        tablaDoctores.getColumnModel().getColumn(3).setPreferredWidth(170);
        tablaDoctores.getColumnModel().getColumn(4).setPreferredWidth(120);
        tablaDoctores.getColumnModel().getColumn(5).setPreferredWidth(120);
        
        JScrollPane scrollTabla = new JScrollPane(tablaDoctores);
        scrollTabla.setPreferredSize(new Dimension(0, 300));
        panelTabla.add(scrollTabla, BorderLayout.SOUTH);
        
        // Panel principal que contiene la tabla y los botones
        JPanel panelTablaConBotonesDoctores = new JPanel();
        panelTablaConBotonesDoctores.setLayout(new BorderLayout());
        panelTablaConBotonesDoctores.setBackground(Color.WHITE);
        panelTablaConBotonesDoctores.add(panelTabla, BorderLayout.CENTER);
        
        // Panel de botones de acción para doctores
        JPanel panelBotonesAccionDoctores = new JPanel();
        panelBotonesAccionDoctores.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        panelBotonesAccionDoctores.setBackground(Color.WHITE);
        panelBotonesAccionDoctores.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        JButton btnEliminarDoctor = new JButton("Eliminar Doctor");
        btnEliminarDoctor.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnEliminarDoctor.setPreferredSize(new Dimension(170, 45));
        btnEliminarDoctor.setBackground(new Color(239, 68, 68));
        btnEliminarDoctor.setForeground(Color.WHITE);
        btnEliminarDoctor.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(239, 68, 68), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnEliminarDoctor.setFocusPainted(false);
        btnEliminarDoctor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminarDoctor.setContentAreaFilled(true);
        btnEliminarDoctor.setOpaque(true);
        btnEliminarDoctor.setBorderPainted(true);
        btnEliminarDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarDoctor.setBackground(new Color(220, 38, 38));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarDoctor.setBackground(new Color(239, 68, 68));
            }
        });
        btnEliminarDoctor.addActionListener(e -> eliminarDoctorSeleccionado(tablaDoctores));
        
        panelBotonesAccionDoctores.add(btnEliminarDoctor);
        panelTablaConBotonesDoctores.add(panelBotonesAccionDoctores, BorderLayout.SOUTH);
        
        panel.add(panelTablaConBotonesDoctores, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel crearPanelHistoriales() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 250, 252));
        
        // Título y botón
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBackground(new Color(248, 250, 252));
        
        JLabel lblTitulo = new JLabel("Historiales Médicos");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(31, 41, 55));
        panelTitulo.add(lblTitulo, BorderLayout.WEST);
        
        JLabel lblSubtitulo = new JLabel("Gestiona los registros médicos de los pacientes");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(107, 114, 128));
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        panelTitulo.add(lblSubtitulo, BorderLayout.SOUTH);
        
        JButton btnNuevoRegistro = new JButton("+ Nuevo Registro");
        btnNuevoRegistro.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnNuevoRegistro.setPreferredSize(new Dimension(200, 45));
        btnNuevoRegistro.setBackground(new Color(72, 69, 165));
        btnNuevoRegistro.setForeground(Color.WHITE);
        btnNuevoRegistro.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(72, 69, 165), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnNuevoRegistro.setFocusPainted(false);
        btnNuevoRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNuevoRegistro.setContentAreaFilled(true);
        btnNuevoRegistro.setOpaque(true);
        btnNuevoRegistro.setBorderPainted(true);
        btnNuevoRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoRegistro.setBackground(new Color(60, 57, 140));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoRegistro.setBackground(new Color(72, 69, 165));
            }
        });
        btnNuevoRegistro.addActionListener(e -> new FormularioNuevoRegistroModal().setVisible(true));
        panelTitulo.add(btnNuevoRegistro, BorderLayout.EAST);
        
        panel.add(panelTitulo, BorderLayout.NORTH);
        
        
        // Panel de tabla de historiales
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(Color.WHITE);
        panelTabla.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel lblTablaTitulo = new JLabel("Registros Médicos (3)");
        lblTablaTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTablaTitulo.setForeground(new Color(31, 41, 55));
        panelTabla.add(lblTablaTitulo, BorderLayout.NORTH);
        
        JLabel lblTablaSubtitulo = new JLabel("Historiales médicos de los pacientes");
        lblTablaSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblTablaSubtitulo.setForeground(new Color(107, 114, 128));
        lblTablaSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        panelTabla.add(lblTablaSubtitulo, BorderLayout.CENTER);
        
        // Crear tabla de historiales
        String[] columnas = {"Paciente", "Doctor", "Fecha", "Diagnóstico", "Tipo", "Próximo Control"};
        Object[][] datos = {
            {"👤 María González Pérez\nID: 0001", "🩺 Dr. Juan Rodríguez", "📅 9 de febrero de 2024", "Hipertensión arterial leve\nDolor de cabeza, mareos ocasionales", "Consulta General", "📅 9 de marzo de 2024"},
            {"👤 Carlos Mendoza Rivera\nID: 0002", "🩺 Dra. María López", "📅 12 de febrero de 2024", "Gripe estacional\nFiebre, tos, congestión nasal", "Primera Consulta", "📅 26 de febrero de 2024"},
            {"👤 Ana Martínez López\nID: 0003", "🩺 Dr. Carlos García", "📅 15 de febrero de 2024", "Dermatitis atópica\nErupciones en brazos y piernas", "Seguimiento", "📅 15 de marzo de 2024"}
        };
        
        JTable tablaHistoriales = new JTable(datos, columnas);
        tablaHistoriales.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tablaHistoriales.setRowHeight(80);
        tablaHistoriales.setBackground(Color.WHITE);
        tablaHistoriales.setForeground(new Color(31, 41, 55));
        tablaHistoriales.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tablaHistoriales.getTableHeader().setBackground(new Color(248, 250, 252));
        tablaHistoriales.getTableHeader().setForeground(new Color(31, 41, 55));
        tablaHistoriales.setGridColor(new Color(229, 231, 235));
        tablaHistoriales.setShowGrid(true);
        
        // Ajustar ancho de columnas
        tablaHistoriales.getColumnModel().getColumn(0).setPreferredWidth(180);
        tablaHistoriales.getColumnModel().getColumn(1).setPreferredWidth(170);
        tablaHistoriales.getColumnModel().getColumn(2).setPreferredWidth(140);
        tablaHistoriales.getColumnModel().getColumn(3).setPreferredWidth(280);
        tablaHistoriales.getColumnModel().getColumn(4).setPreferredWidth(140);
        tablaHistoriales.getColumnModel().getColumn(5).setPreferredWidth(140);
        
        JScrollPane scrollTabla = new JScrollPane(tablaHistoriales);
        scrollTabla.setPreferredSize(new Dimension(0, 300));
        panelTabla.add(scrollTabla, BorderLayout.SOUTH);
        
        // Panel principal que contiene la tabla y los botones
        JPanel panelTablaConBotonesHistoriales = new JPanel();
        panelTablaConBotonesHistoriales.setLayout(new BorderLayout());
        panelTablaConBotonesHistoriales.setBackground(Color.WHITE);
        panelTablaConBotonesHistoriales.add(panelTabla, BorderLayout.CENTER);
        
        // Panel de botones de acción para historiales
        JPanel panelBotonesAccionHistoriales = new JPanel();
        panelBotonesAccionHistoriales.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        panelBotonesAccionHistoriales.setBackground(Color.WHITE);
        panelBotonesAccionHistoriales.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        
        JButton btnEliminarHistorial = new JButton("Eliminar Registro");
        btnEliminarHistorial.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnEliminarHistorial.setPreferredSize(new Dimension(190, 45));
        btnEliminarHistorial.setBackground(new Color(239, 68, 68));
        btnEliminarHistorial.setForeground(Color.WHITE);
        btnEliminarHistorial.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(239, 68, 68), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnEliminarHistorial.setFocusPainted(false);
        btnEliminarHistorial.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminarHistorial.setContentAreaFilled(true);
        btnEliminarHistorial.setOpaque(true);
        btnEliminarHistorial.setBorderPainted(true);
        btnEliminarHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarHistorial.setBackground(new Color(220, 38, 38));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarHistorial.setBackground(new Color(239, 68, 68));
            }
        });
        btnEliminarHistorial.addActionListener(e -> eliminarHistorialSeleccionado(tablaHistoriales));
        
        panelBotonesAccionHistoriales.add(btnEliminarHistorial);
        panelTablaConBotonesHistoriales.add(panelBotonesAccionHistoriales, BorderLayout.SOUTH);
        
        panel.add(panelTablaConBotonesHistoriales, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel crearPanelReportes() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 250, 252));
        
        // Título y botón
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBackground(new Color(248, 250, 252));
        
        JLabel lblTitulo = new JLabel("Reportes y Estadísticas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(31, 41, 55));
        panelTitulo.add(lblTitulo, BorderLayout.WEST);
        
        JLabel lblSubtitulo = new JLabel("Análisis detallado del rendimiento de la clínica");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(107, 114, 128));
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        panelTitulo.add(lblSubtitulo, BorderLayout.SOUTH);
        
        
        panel.add(panelTitulo, BorderLayout.NORTH);
        
        
        // Panel de tarjetas de resumen
        JPanel panelTarjetas = new JPanel();
        panelTarjetas.setLayout(new GridLayout(1, 4, 20, 0));
        panelTarjetas.setBackground(new Color(248, 250, 252));
        panelTarjetas.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        // Tarjeta 1: Total Citas
        JPanel tarjeta1 = crearTarjetaReporte("📅", "Total Citas", "1,234", "+12% vs período anterior", new Color(34, 197, 94));
        panelTarjetas.add(tarjeta1);
        
        // Tarjeta 2: Pacientes Únicos
        JPanel tarjeta2 = crearTarjetaReporte("👥", "Pacientes Únicos", "892", "+8% vs período anterior", new Color(59, 130, 246));
        panelTarjetas.add(tarjeta2);
        
        // Tarjeta 3: Tasa Completadas
        JPanel tarjeta3 = crearTarjetaReporte("📈", "Tasa Completadas", "94.2%", "+2.1% vs período anterior", new Color(168, 85, 247));
        panelTarjetas.add(tarjeta3);
        
        // Tarjeta 4: Tiempo Promedio
        JPanel tarjeta4 = crearTarjetaReporte("🕐", "Tiempo Promedio", "32 min", "-3 min vs período anterior", new Color(245, 158, 11));
        panelTarjetas.add(tarjeta4);
        
        panel.add(panelTarjetas, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel crearTarjetaReporte(String icono, String titulo, String valor, String cambio, Color color) {
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(new BorderLayout());
        tarjeta.setBackground(Color.WHITE);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        // Icono y título
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSuperior.setBackground(Color.WHITE);
        
        JLabel lblIcono = new JLabel(icono);
        lblIcono.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
        panelSuperior.add(lblIcono);
        
        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTitulo.setForeground(new Color(31, 41, 55));
        panelSuperior.add(lblTitulo);
        
        // Valor
        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblValor.setForeground(new Color(31, 41, 55));
        lblValor.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        
        // Cambio
        JLabel lblCambio = new JLabel(cambio);
        lblCambio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblCambio.setForeground(color);
        
        tarjeta.add(panelSuperior, BorderLayout.NORTH);
        tarjeta.add(lblValor, BorderLayout.CENTER);
        tarjeta.add(lblCambio, BorderLayout.SOUTH);
        
        return tarjeta;
    }
}
