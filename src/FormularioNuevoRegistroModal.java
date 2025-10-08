package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioNuevoRegistroModal extends JDialog {
    private JTextField txtPaciente;
    private JTextField txtDoctor;
    private JTextField txtFechaConsulta;
    private JComboBox<String> cmbTipoConsulta;
    private JTextField txtPresionArterial;
    private JTextField txtFrecuenciaCardiaca;
    private JTextField txtTemperatura;
    private JTextField txtPeso;
    private JTextArea txtSintomas;
    private JTextArea txtDiagnostico;
    private JTextArea txtTratamiento;
    private JTextArea txtObservaciones;
    private JTextArea txtPrescripciones;
    private JTextField txtProximoControl;
    private JButton btnCrear;
    private JButton btnCancelar;
    
    public FormularioNuevoRegistroModal() {
        super((Frame) null, "Nuevo Registro Médico", true);
        inicializarComponentes();
        configurarVentana();
        agregarEventos();
    }
    
    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Panel principal con scroll
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBackground(Color.WHITE);
        
        JLabel lblTitulo = new JLabel("Nuevo Registro Médico");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(31, 41, 55));
        panelTitulo.add(lblTitulo, BorderLayout.WEST);
        
        JLabel lblSubtitulo = new JLabel("Crear un nuevo registro médico para el paciente");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(107, 114, 128));
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        panelTitulo.add(lblSubtitulo, BorderLayout.SOUTH);
        
        JButton btnCerrar = new JButton("✕");
        btnCerrar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnCerrar.setBackground(Color.WHITE);
        btnCerrar.setForeground(new Color(107, 114, 128));
        btnCerrar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btnCerrar.setFocusPainted(false);
        btnCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(e -> dispose());
        panelTitulo.add(btnCerrar, BorderLayout.EAST);
        
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        
        // Panel del formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Sección 1: Paciente y Doctor
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel lblSeccion1 = new JLabel("Paciente y Doctor");
        lblSeccion1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSeccion1.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblSeccion1, gbc);
        
        // Paciente
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        JLabel lblPaciente = new JLabel("Paciente");
        lblPaciente.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblPaciente.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblPaciente, gbc);
        
        gbc.gridx = 1;
        txtPaciente = new JTextField(20);
        txtPaciente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPaciente.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(147, 51, 234), 2),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtPaciente.setText("Nombre del paciente");
        panelFormulario.add(txtPaciente, gbc);
        
        // Doctor
        gbc.gridx = 2;
        gbc.gridy = 1;
        JLabel lblDoctor = new JLabel("Doctor");
        lblDoctor.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblDoctor.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblDoctor, gbc);
        
        gbc.gridx = 3;
        txtDoctor = new JTextField(20);
        txtDoctor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtDoctor.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtDoctor.setText("Nombre del doctor");
        panelFormulario.add(txtDoctor, gbc);
        
        // Sección 2: Fecha y Tipo de Consulta
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JLabel lblSeccion2 = new JLabel("Fecha y Tipo de Consulta");
        lblSeccion2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSeccion2.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblSeccion2, gbc);
        
        // Fecha de Consulta
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        JLabel lblFechaConsulta = new JLabel("Fecha de Consulta");
        lblFechaConsulta.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblFechaConsulta.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblFechaConsulta, gbc);
        
        gbc.gridx = 1;
        txtFechaConsulta = new JTextField(20);
        txtFechaConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtFechaConsulta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtFechaConsulta.setText("dd/mm/aaaa");
        panelFormulario.add(txtFechaConsulta, gbc);
        
        // Tipo de Consulta
        gbc.gridx = 2;
        gbc.gridy = 3;
        JLabel lblTipoConsulta = new JLabel("Tipo de Consulta");
        lblTipoConsulta.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTipoConsulta.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblTipoConsulta, gbc);
        
        gbc.gridx = 3;
        cmbTipoConsulta = new JComboBox<>(new String[]{"Seleccionar tipo", "Consulta General", "Primera Consulta", "Seguimiento", "Consulta Especializada"});
        cmbTipoConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbTipoConsulta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        panelFormulario.add(cmbTipoConsulta, gbc);
        
        // Sección 3: Signos Vitales
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        JLabel lblSeccion3 = new JLabel("Signos Vitales");
        lblSeccion3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSeccion3.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblSeccion3, gbc);
        
        // Presión Arterial
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        JLabel lblPresionArterial = new JLabel("Presión Arterial");
        lblPresionArterial.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblPresionArterial.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblPresionArterial, gbc);
        
        gbc.gridx = 1;
        txtPresionArterial = new JTextField(20);
        txtPresionArterial.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPresionArterial.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtPresionArterial.setText("120/80");
        panelFormulario.add(txtPresionArterial, gbc);
        
        // Frecuencia Cardíaca
        gbc.gridx = 2;
        gbc.gridy = 5;
        JLabel lblFrecuenciaCardiaca = new JLabel("Frecuencia Cardíaca");
        lblFrecuenciaCardiaca.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblFrecuenciaCardiaca.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblFrecuenciaCardiaca, gbc);
        
        gbc.gridx = 3;
        txtFrecuenciaCardiaca = new JTextField(20);
        txtFrecuenciaCardiaca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtFrecuenciaCardiaca.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtFrecuenciaCardiaca.setText("72 bpm");
        panelFormulario.add(txtFrecuenciaCardiaca, gbc);
        
        // Temperatura
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel lblTemperatura = new JLabel("Temperatura");
        lblTemperatura.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTemperatura.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblTemperatura, gbc);
        
        gbc.gridx = 1;
        txtTemperatura = new JTextField(20);
        txtTemperatura.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtTemperatura.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtTemperatura.setText("36.5°C");
        panelFormulario.add(txtTemperatura, gbc);
        
        // Peso
        gbc.gridx = 2;
        gbc.gridy = 6;
        JLabel lblPeso = new JLabel("Peso");
        lblPeso.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblPeso.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblPeso, gbc);
        
        gbc.gridx = 3;
        txtPeso = new JTextField(20);
        txtPeso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPeso.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtPeso.setText("70kg");
        panelFormulario.add(txtPeso, gbc);
        
        // Sección 4: Síntomas y Diagnóstico
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 4;
        JLabel lblSeccion4 = new JLabel("Síntomas y Diagnóstico");
        lblSeccion4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSeccion4.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblSeccion4, gbc);
        
        // Síntomas
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        JLabel lblSintomas = new JLabel("Síntomas");
        lblSintomas.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblSintomas.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblSintomas, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        txtSintomas = new JTextArea(3, 20);
        txtSintomas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtSintomas.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtSintomas.setText("Descripción de los síntomas presentados...");
        txtSintomas.setLineWrap(true);
        txtSintomas.setWrapStyleWord(true);
        panelFormulario.add(txtSintomas, gbc);
        
        // Diagnóstico
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblDiagnostico = new JLabel("Diagnóstico");
        lblDiagnostico.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblDiagnostico.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblDiagnostico, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        txtDiagnostico = new JTextArea(3, 20);
        txtDiagnostico.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtDiagnostico.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtDiagnostico.setText("Diagnóstico médico...");
        txtDiagnostico.setLineWrap(true);
        txtDiagnostico.setWrapStyleWord(true);
        panelFormulario.add(txtDiagnostico, gbc);
        
        // Sección 5: Tratamiento y Observaciones
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblSeccion5 = new JLabel("Tratamiento y Observaciones");
        lblSeccion5.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSeccion5.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblSeccion5, gbc);
        
        // Tratamiento
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        JLabel lblTratamiento = new JLabel("Tratamiento");
        lblTratamiento.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblTratamiento.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblTratamiento, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        txtTratamiento = new JTextArea(3, 20);
        txtTratamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtTratamiento.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtTratamiento.setText("Tratamiento prescrito...");
        txtTratamiento.setLineWrap(true);
        txtTratamiento.setWrapStyleWord(true);
        panelFormulario.add(txtTratamiento, gbc);
        
        // Observaciones
        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblObservaciones = new JLabel("Observaciones");
        lblObservaciones.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblObservaciones.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblObservaciones, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        txtObservaciones = new JTextArea(3, 20);
        txtObservaciones.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtObservaciones.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtObservaciones.setText("Observaciones adicionales...");
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setWrapStyleWord(true);
        panelFormulario.add(txtObservaciones, gbc);
        
        // Sección 6: Prescripciones
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblSeccion6 = new JLabel("Prescripciones");
        lblSeccion6.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSeccion6.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblSeccion6, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        txtPrescripciones = new JTextArea(3, 20);
        txtPrescripciones.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPrescripciones.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtPrescripciones.setText("Medicamentos y dosis prescritas...");
        txtPrescripciones.setLineWrap(true);
        txtPrescripciones.setWrapStyleWord(true);
        panelFormulario.add(txtPrescripciones, gbc);
        
        // Sección 7: Próximo Control
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lblSeccion7 = new JLabel("Próximo Control");
        lblSeccion7.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSeccion7.setForeground(new Color(31, 41, 55));
        panelFormulario.add(lblSeccion7, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.gridwidth = 2;
        txtProximoControl = new JTextField(20);
        txtProximoControl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtProximoControl.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        txtProximoControl.setText("dd/mm/aaaa");
        panelFormulario.add(txtProximoControl, gbc);
        
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        
        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.setBackground(Color.WHITE);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnCancelar.setBackground(new Color(248, 250, 252));
        btnCancelar.setForeground(new Color(31, 41, 55));
        btnCancelar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(e -> dispose());
        panelBotones.add(btnCancelar);
        
        btnCrear = new JButton("Crear Registro");
        btnCrear.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCrear.setBackground(new Color(25, 118, 210));
        btnCrear.setForeground(Color.WHITE);
        btnCrear.setBorder(BorderFactory.createLineBorder(new Color(25, 118, 210), 2));
        btnCrear.setFocusPainted(false);
        btnCrear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCrear.addActionListener(e -> crearRegistro());
        panelBotones.add(btnCrear);
        
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        
        scrollPane.setViewportView(panelPrincipal);
        add(scrollPane);
    }
    
    private void configurarVentana() {
        setSize(1000, 700); // Más ancho
        setLocationRelativeTo(null);
        setResizable(true); // Permitir redimensionar
    }
    
    private void agregarEventos() {
        // Los eventos ya están agregados en los componentes
    }
    
    private void crearRegistro() {
        String paciente = txtPaciente.getText().trim();
        String doctor = txtDoctor.getText().trim();
        String fechaConsulta = txtFechaConsulta.getText().trim();
        String tipoConsulta = (String) cmbTipoConsulta.getSelectedItem();
        String proximoControl = txtProximoControl.getText().trim();
        
        if (paciente.isEmpty() || doctor.isEmpty() || fechaConsulta.isEmpty() || 
            proximoControl.isEmpty() || tipoConsulta.equals("Seleccionar tipo")) {
            
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos obligatorios", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Registro médico creado exitosamente", 
                                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
