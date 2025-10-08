package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioNuevaCitaModal extends JDialog {
    private JTextField txtPaciente;
    private JTextField txtFecha;
    private JComboBox<String> cmbTipoConsulta;
    private JComboBox<String> cmbDoctor;
    private JComboBox<String> cmbHora;
    private JComboBox<String> cmbDuracion;
    private JTextArea txtNotas;
    private JButton btnProgramar;
    private JButton btnCancelar;
    
    public FormularioNuevaCitaModal() {
        super((Frame) null, "Nueva Cita Médica", true);
        
        // Configurar el componente para que responda correctamente
        setModal(true);
        setFocusable(true);
        setFocusableWindowState(true);
        
        inicializarComponentes();
        configurarVentana();
        
        // Establecer focus en el primer campo después de que se inicialice
        SwingUtilities.invokeLater(() -> {
            txtPaciente.requestFocusInWindow();
        });
    }
    
    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(Color.WHITE);
        
        // Panel del contenido principal
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BorderLayout());
        panelContenido.setBackground(Color.WHITE);
        panelContenido.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        
        // Título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBackground(Color.WHITE);
        
        JLabel lblTitulo = new JLabel("Nueva Cita Médica");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(31, 41, 55));
        
        JLabel lblSubtitulo = new JLabel("Programa una nueva cita con los datos del paciente");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSubtitulo.setForeground(new Color(107, 114, 128));
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        
        panelTitulo.add(lblTitulo, BorderLayout.NORTH);
        panelTitulo.add(lblSubtitulo, BorderLayout.SOUTH);
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        
        panelContenido.add(panelTitulo, BorderLayout.NORTH);
        
        // Panel de formulario en 2 columnas
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
        panelFormulario.setBackground(Color.WHITE);
        
        // Columna izquierda
        JPanel columnaIzquierda = new JPanel();
        columnaIzquierda.setLayout(new GridLayout(4, 1, 0, 25));
        columnaIzquierda.setBackground(Color.WHITE);
        columnaIzquierda.setPreferredSize(new Dimension(350, 350));
        
        // Paciente
        txtPaciente = new JTextField(20);
        txtPaciente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPaciente.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtPaciente.setEditable(true);
        txtPaciente.setEnabled(true);
        txtPaciente.setFocusable(true);
        txtPaciente.setText(""); // Campo vacío
        columnaIzquierda.add(crearGrupoCampo("Paciente", txtPaciente));
        
        // Fecha
        txtFecha = new JTextField(20);
        txtFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtFecha.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtFecha.setEditable(true);
        txtFecha.setEnabled(true);
        txtFecha.setFocusable(true);
        txtFecha.setText(""); // Campo vacío
        columnaIzquierda.add(crearGrupoCampo("Fecha", txtFecha));
        
        // Tipo de Consulta
        cmbTipoConsulta = new JComboBox<>();
        cmbTipoConsulta.addItem("Seleccionar tipo");
        cmbTipoConsulta.addItem("Consulta General");
        cmbTipoConsulta.addItem("Consulta Especializada");
        cmbTipoConsulta.addItem("Control");
        cmbTipoConsulta.addItem("Emergencia");
        cmbTipoConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbTipoConsulta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        cmbTipoConsulta.setBackground(Color.WHITE);
        columnaIzquierda.add(crearGrupoCampo("Tipo de Consulta", cmbTipoConsulta));
        
        // Doctor
        cmbDoctor = new JComboBox<>();
        cmbDoctor.addItem("Seleccionar doctor");
        cmbDoctor.addItem("Dr. Juan Pérez");
        cmbDoctor.addItem("Dra. María González");
        cmbDoctor.addItem("Dr. Carlos López");
        cmbDoctor.addItem("Dra. Ana Martínez");
        cmbDoctor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbDoctor.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        cmbDoctor.setBackground(Color.WHITE);
        columnaIzquierda.add(crearGrupoCampo("Doctor", cmbDoctor));
        
        // Columna derecha
        JPanel columnaDerecha = new JPanel();
        columnaDerecha.setLayout(new GridLayout(4, 1, 0, 25));
        columnaDerecha.setBackground(Color.WHITE);
        columnaDerecha.setPreferredSize(new Dimension(350, 350));
        
        // Hora
        cmbHora = new JComboBox<>();
        cmbHora.addItem("Seleccionar hora");
        cmbHora.addItem("08:00 AM");
        cmbHora.addItem("08:30 AM");
        cmbHora.addItem("09:00 AM");
        cmbHora.addItem("09:30 AM");
        cmbHora.addItem("10:00 AM");
        cmbHora.addItem("10:30 AM");
        cmbHora.addItem("11:00 AM");
        cmbHora.addItem("11:30 AM");
        cmbHora.addItem("02:00 PM");
        cmbHora.addItem("02:30 PM");
        cmbHora.addItem("03:00 PM");
        cmbHora.addItem("03:30 PM");
        cmbHora.addItem("04:00 PM");
        cmbHora.addItem("04:30 PM");
        cmbHora.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbHora.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        cmbHora.setBackground(Color.WHITE);
        columnaDerecha.add(crearGrupoCampo("Hora", cmbHora));
        
        // Duración
        cmbDuracion = new JComboBox<>();
        cmbDuracion.addItem("Seleccionar duración");
        cmbDuracion.addItem("30 minutos");
        cmbDuracion.addItem("45 minutos");
        cmbDuracion.addItem("1 hora");
        cmbDuracion.addItem("1.5 horas");
        cmbDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbDuracion.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        cmbDuracion.setBackground(Color.WHITE);
        columnaDerecha.add(crearGrupoCampo("Duración", cmbDuracion));
        
        // Notas - Área de texto más grande para la columna derecha
        txtNotas = new JTextArea(6, 20);
        txtNotas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNotas.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtNotas.setEditable(true);
        txtNotas.setEnabled(true);
        txtNotas.setFocusable(true);
        txtNotas.setText(""); // Campo vacío
        txtNotas.setLineWrap(true);
        txtNotas.setWrapStyleWord(true);
        columnaDerecha.add(crearGrupoCampo("Notas/Observaciones", txtNotas));
        
        // Agregar columnas al formulario
        panelFormulario.add(columnaIzquierda);
        panelFormulario.add(columnaDerecha);
        
        panelContenido.add(panelFormulario, BorderLayout.CENTER);
        
        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BorderLayout());
        panelBotones.setBackground(Color.WHITE);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnCancelar.setPreferredSize(new Dimension(120, 45));
        btnCancelar.setBackground(Color.WHITE);
        btnCancelar.setForeground(new Color(75, 85, 99));
        btnCancelar.setBorder(BorderFactory.createLineBorder(new Color(209, 213, 219), 2));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(e -> dispose());
        panelBotones.add(btnCancelar, BorderLayout.WEST);
        
        btnProgramar = new JButton("Programar Cita");
        btnProgramar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnProgramar.setPreferredSize(new Dimension(160, 45));
        btnProgramar.setBackground(new Color(72, 69, 165));
        btnProgramar.setForeground(Color.WHITE);
        btnProgramar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(72, 69, 165), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnProgramar.setFocusPainted(false);
        btnProgramar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnProgramar.setContentAreaFilled(true);
        btnProgramar.setOpaque(true);
        btnProgramar.setBorderPainted(true);
        btnProgramar.addActionListener(e -> programarCita());
        panelBotones.add(btnProgramar, BorderLayout.EAST);
        
        panelContenido.add(panelBotones, BorderLayout.SOUTH);
        
        panelPrincipal.add(panelContenido, BorderLayout.CENTER);
        add(panelPrincipal);
    }
    
    private JPanel crearGrupoCampo(String etiqueta, JComponent componente) {
        JPanel grupo = new JPanel();
        grupo.setLayout(new BorderLayout(0, 5));
        grupo.setBackground(Color.WHITE);
        
        JLabel lbl = new JLabel(etiqueta);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbl.setForeground(new Color(31, 41, 55));
        
        grupo.add(lbl, BorderLayout.NORTH);
        grupo.add(componente, BorderLayout.CENTER);
        
        return grupo;
    }
    
    private void configurarVentana() {
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(true); // Permitir redimensionar
        
        // Configuración adicional para asegurar funcionamiento correcto
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setFocusableWindowState(true);
        pack();
    }
    
    private void programarCita() {
        String paciente = txtPaciente.getText().trim();
        String fecha = txtFecha.getText().trim();
        String tipoConsulta = (String) cmbTipoConsulta.getSelectedItem();
        String doctor = (String) cmbDoctor.getSelectedItem();
        String hora = (String) cmbHora.getSelectedItem();
        String duacion = (String) cmbDuracion.getSelectedItem();
        String notas = txtNotas.getText().trim();
        
        // Validación básica
        if (paciente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del paciente es requerido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (fecha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La fecha es requerida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Simulación de guardado
        String mensaje = "Cita Programada Exitosamente:\n\n" +
                        "Paciente: " + paciente + "\n" +
                        "Fecha: " + fecha + "\n" +
                        "Tipo de Consulta: " + tipoConsulta + "\n" +
                        "Doctor: " + doctor + "\n" +
                        "Hora: " + hora + "\n" +
                        "Duración: " + duacion + "\n" +
                        "Notas: " + notas;
        
        JOptionPane.showMessageDialog(this, mensaje, "Cita Programada", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}