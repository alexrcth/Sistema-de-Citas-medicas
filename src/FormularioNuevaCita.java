package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormularioNuevaCita extends JFrame {
    private JPanel panelPrincipal;
    private JTextField txtNombrePaciente;
    private JTextField txtApellidoPaciente;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JComboBox<String> cmbEspecialidad;
    private JComboBox<String> cmbMedico;
    private JSpinner spnFecha;
    private JSpinner spnHora;
    private JTextArea txtObservaciones;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JButton btnLimpiar;
    
    public FormularioNuevaCita() {
        inicializarComponentes();
        configurarVentana();
        agregarEventos();
    }
    
    private void inicializarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(245, 248, 250));
        
        // Panel superior con título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(25, 118, 210));
        panelTitulo.setPreferredSize(new Dimension(0, 60));
        
        JLabel lblTitulo = new JLabel("Nueva Cita Médica");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        
        // Panel central con formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        panelFormulario.setBackground(new Color(245, 248, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);
        
        // Información del Paciente
        JLabel lblSeccionPaciente = new JLabel("Información del Paciente");
        lblSeccionPaciente.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSeccionPaciente.setForeground(new Color(25, 118, 210));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 10, 10, 10);
        panelFormulario.add(lblSeccionPaciente, gbc);
        
        // Nombre del paciente
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblNombre.setForeground(new Color(50, 50, 50));
        panelFormulario.add(lblNombre, gbc);
        
        txtNombrePaciente = new JTextField(20);
        txtNombrePaciente.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtNombrePaciente.setBackground(Color.WHITE);
        txtNombrePaciente.setForeground(new Color(50, 50, 50));
        gbc.gridx = 1;
        panelFormulario.add(txtNombrePaciente, gbc);
        
        // Apellido del paciente
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblApellido.setForeground(new Color(50, 50, 50));
        panelFormulario.add(lblApellido, gbc);
        
        txtApellidoPaciente = new JTextField(20);
        txtApellidoPaciente.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtApellidoPaciente.setBackground(Color.WHITE);
        txtApellidoPaciente.setForeground(new Color(50, 50, 50));
        gbc.gridx = 1;
        panelFormulario.add(txtApellidoPaciente, gbc);
        
        // Teléfono
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTelefono.setForeground(new Color(50, 50, 50));
        panelFormulario.add(lblTelefono, gbc);
        
        txtTelefono = new JTextField(20);
        txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtTelefono.setBackground(Color.WHITE);
        txtTelefono.setForeground(new Color(50, 50, 50));
        gbc.gridx = 1;
        panelFormulario.add(txtTelefono, gbc);
        
        // Email
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblEmail.setForeground(new Color(50, 50, 50));
        panelFormulario.add(lblEmail, gbc);
        
        txtEmail = new JTextField(20);
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtEmail.setBackground(Color.WHITE);
        txtEmail.setForeground(new Color(50, 50, 50));
        gbc.gridx = 1;
        panelFormulario.add(txtEmail, gbc);
        
        // Información de la Cita
        JLabel lblSeccionCita = new JLabel("Información de la Cita");
        lblSeccionCita.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSeccionCita.setForeground(new Color(25, 118, 210));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 10, 10, 10);
        panelFormulario.add(lblSeccionCita, gbc);
        
        // Especialidad
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblEspecialidad.setForeground(new Color(50, 50, 50));
        panelFormulario.add(lblEspecialidad, gbc);
        
        String[] especialidades = {"Seleccionar...", "Medicina General", "Cardiología", "Dermatología", 
                                 "Ginecología", "Pediatría", "Neurología", "Oftalmología", 
                                 "Ortopedia", "Psiquiatría", "Urología"};
        cmbEspecialidad = new JComboBox<>(especialidades);
        cmbEspecialidad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cmbEspecialidad.setBackground(Color.WHITE);
        cmbEspecialidad.setForeground(new Color(50, 50, 50));
        gbc.gridx = 1;
        panelFormulario.add(cmbEspecialidad, gbc);
        
        // Médico
        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel lblMedico = new JLabel("Médico:");
        lblMedico.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblMedico.setForeground(new Color(50, 50, 50));
        panelFormulario.add(lblMedico, gbc);
        
        String[] medicos = {"Seleccionar...", "Dr. García", "Dra. López", "Dr. Martínez", 
                           "Dra. Rodríguez", "Dr. Sánchez", "Dra. Fernández"};
        cmbMedico = new JComboBox<>(medicos);
        cmbMedico.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cmbMedico.setBackground(Color.WHITE);
        cmbMedico.setForeground(new Color(50, 50, 50));
        gbc.gridx = 1;
        panelFormulario.add(cmbMedico, gbc);
        
        // Fecha
        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblFecha.setForeground(new Color(50, 50, 50));
        panelFormulario.add(lblFecha, gbc);
        
        spnFecha = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editorFecha = new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy");
        spnFecha.setEditor(editorFecha);
        spnFecha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        spnFecha.setBackground(Color.WHITE);
        spnFecha.setForeground(new Color(50, 50, 50));
        gbc.gridx = 1;
        panelFormulario.add(spnFecha, gbc);
        
        // Hora
        gbc.gridx = 0;
        gbc.gridy = 9;
        JLabel lblHora = new JLabel("Hora:");
        lblHora.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblHora.setForeground(new Color(50, 50, 50));
        panelFormulario.add(lblHora, gbc);
        
        spnHora = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editorHora = new JSpinner.DateEditor(spnHora, "HH:mm");
        spnHora.setEditor(editorHora);
        spnHora.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        spnHora.setBackground(Color.WHITE);
        spnHora.setForeground(new Color(50, 50, 50));
        gbc.gridx = 1;
        panelFormulario.add(spnHora, gbc);
        
        // Observaciones
        gbc.gridx = 0;
        gbc.gridy = 10;
        JLabel lblObservaciones = new JLabel("Observaciones:");
        lblObservaciones.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblObservaciones.setForeground(new Color(50, 50, 50));
        panelFormulario.add(lblObservaciones, gbc);
        
        txtObservaciones = new JTextArea(4, 20);
        txtObservaciones.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtObservaciones.setBackground(Color.WHITE);
        txtObservaciones.setForeground(new Color(50, 50, 50));
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones);
        gbc.gridx = 1;
        panelFormulario.add(scrollObservaciones, gbc);
        
        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelBotones.setBackground(new Color(245, 248, 250));
        
        btnGuardar = new JButton("Guardar Cita");
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnGuardar.setPreferredSize(new Dimension(120, 35));
        btnGuardar.setBackground(new Color(0, 150, 0));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLimpiar.setPreferredSize(new Dimension(120, 35));
        btnLimpiar.setBackground(new Color(255, 140, 0));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setFocusPainted(false);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCancelar.setPreferredSize(new Dimension(120, 35));
        btnCancelar.setBackground(new Color(200, 0, 0));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnCancelar);
        
        // Agregar paneles al panel principal
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    private void configurarVentana() {
        setTitle("Nueva Cita Médica");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void agregarEventos() {
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCita();
            }
        });
        
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void guardarCita() {
        // Validar campos obligatorios
        if (txtNombrePaciente.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el nombre del paciente", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            txtNombrePaciente.requestFocus();
            return;
        }
        
        if (txtApellidoPaciente.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el apellido del paciente", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            txtApellidoPaciente.requestFocus();
            return;
        }
        
        if (cmbEspecialidad.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una especialidad", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            cmbEspecialidad.requestFocus();
            return;
        }
        
        if (cmbMedico.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un médico", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            cmbMedico.requestFocus();
            return;
        }
        
        // Simular guardado de cita
        String mensaje = "Cita guardada exitosamente:\n\n" +
                        "Paciente: " + txtNombrePaciente.getText() + " " + txtApellidoPaciente.getText() + "\n" +
                        "Especialidad: " + cmbEspecialidad.getSelectedItem() + "\n" +
                        "Médico: " + cmbMedico.getSelectedItem() + "\n" +
                        "Fecha: " + new SimpleDateFormat("dd/MM/yyyy").format(spnFecha.getValue()) + "\n" +
                        "Hora: " + new SimpleDateFormat("HH:mm").format(spnHora.getValue());
        
        JOptionPane.showMessageDialog(this, mensaje, "Cita Guardada", JOptionPane.INFORMATION_MESSAGE);
        limpiarFormulario();
    }
    
    private void limpiarFormulario() {
        txtNombrePaciente.setText("");
        txtApellidoPaciente.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        cmbEspecialidad.setSelectedIndex(0);
        cmbMedico.setSelectedIndex(0);
        spnFecha.setValue(new Date());
        spnHora.setValue(new Date());
        txtObservaciones.setText("");
    }
}
