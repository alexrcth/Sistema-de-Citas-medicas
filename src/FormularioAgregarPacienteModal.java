package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioAgregarPacienteModal extends JDialog {
    private JTextField txtNombreCompleto;
    private JTextField txtEdad;
    private JComboBox<String> cmbGenero;
    private JComboBox<String> cmbTipoSangre;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtContactoEmergencia;
    private JTextArea txtAntecedentesMedicos;
    private JButton btnCancelar;
    private JButton btnAgregar;
    
    public FormularioAgregarPacienteModal() {
        super((Frame) null, "Agregar Nuevo Paciente", true);
        
        // Configurar el componente para que responda correctamente
        setAlwaysOnTop(false);
        setModal(true);
        setFocusable(true);
        setFocusableWindowState(true);
        
        inicializarComponentes();
        configurarVentana();
        
        // Establecer focus en el primer campo después de que se inicialice
        SwingUtilities.invokeLater(() -> {
            txtNombreCompleto.requestFocusInWindow();
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
        
        JLabel lblTitulo = new JLabel("Agregar Nuevo Paciente");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(31, 41, 55));
        
        JLabel lblSubtitulo = new JLabel("Completa los datos del nuevo paciente");
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
        columnaIzquierda.setLayout(new GridLayout(5, 1, 0, 25));
        columnaIzquierda.setBackground(Color.WHITE);
        columnaIzquierda.setPreferredSize(new Dimension(350, 400));
        
        // Nombre Completo
        txtNombreCompleto = new JTextField(20);
        txtNombreCompleto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNombreCompleto.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtNombreCompleto.setEditable(true);
        txtNombreCompleto.setEnabled(true);
        txtNombreCompleto.setFocusable(true);
        txtNombreCompleto.setText(""); // Campo vacío
        txtNombreCompleto.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(() -> {
                    txtNombreCompleto.selectAll();
                });
            }
        });
        columnaIzquierda.add(crearGrupoCampo("Nombre Completo", txtNombreCompleto));
        
        // Edad
        txtEdad = new JTextField(20);
        txtEdad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEdad.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtEdad.setEditable(true);
        txtEdad.setEnabled(true);
        txtEdad.setFocusable(true);
        txtEdad.setText(""); // Campo vacío
        columnaIzquierda.add(crearGrupoCampo("Edad", txtEdad));
        
        // Género
        cmbGenero = new JComboBox<>();
        cmbGenero.addItem("Seleccionar género");
        cmbGenero.addItem("Masculino");
        cmbGenero.addItem("Femenino");
        cmbGenero.addItem("Otro");
        cmbGenero.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbGenero.setPreferredSize(new Dimension(200, 60));
        cmbGenero.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        cmbGenero.setBackground(Color.WHITE);
        columnaIzquierda.add(crearGrupoCampo("Género", cmbGenero));
        
        // Teléfono
        txtTelefono = new JTextField(20);
        txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtTelefono.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtTelefono.setEditable(true);
        txtTelefono.setEnabled(true);
        txtTelefono.setFocusable(true);
        txtTelefono.setText(""); // Campo vacío
        columnaIzquierda.add(crearGrupoCampo("Teléfono", txtTelefono));
        
        // Email
        txtEmail = new JTextField(20);
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmail.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtEmail.setEditable(true);
        txtEmail.setEnabled(true);
        txtEmail.setFocusable(true);
        txtEmail.setText(""); // Campo vacío
        columnaIzquierda.add(crearGrupoCampo("Correo Electrónico", txtEmail));
        
        // Columna derecha
        JPanel columnaDerecha = new JPanel();
        columnaDerecha.setLayout(new GridLayout(5, 1, 0, 25));
        columnaDerecha.setBackground(Color.WHITE);
        columnaDerecha.setPreferredSize(new Dimension(350, 400));
        
        // Tipo de Sangre
        cmbTipoSangre = new JComboBox<>();
        cmbTipoSangre.addItem("Seleccionar tipo");
        cmbTipoSangre.addItem("A+");
        cmbTipoSangre.addItem("A-");
        cmbTipoSangre.addItem("B+");
        cmbTipoSangre.addItem("B-");
        cmbTipoSangre.addItem("AB+");
        cmbTipoSangre.addItem("AB-");
        cmbTipoSangre.addItem("O+");
        cmbTipoSangre.addItem("O-");
        cmbTipoSangre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbTipoSangre.setPreferredSize(new Dimension(200, 60));
        cmbTipoSangre.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        cmbTipoSangre.setBackground(Color.WHITE);
        columnaDerecha.add(crearGrupoCampo("Tipo de Sangre", cmbTipoSangre));
        
        // Dirección
        txtDireccion = new JTextField(20);
        txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtDireccion.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtDireccion.setEditable(true);
        txtDireccion.setEnabled(true);
        txtDireccion.setFocusable(true);
        txtDireccion.setText(""); // Campo vacío
        columnaDerecha.add(crearGrupoCampo("Dirección", txtDireccion));
        
        // Contacto de Emergencia
        txtContactoEmergencia = new JTextField(20);
        txtContactoEmergencia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtContactoEmergencia.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtContactoEmergencia.setEditable(true);
        txtContactoEmergencia.setEnabled(true);
        txtContactoEmergencia.setFocusable(true);
        txtContactoEmergencia.setText(""); // Campo vacío
        columnaDerecha.add(crearGrupoCampo("Contacto de Emergencia", txtContactoEmergencia));
        
        // Antecedentes Médicos
        txtAntecedentesMedicos = new JTextArea(4, 20);
        txtAntecedentesMedicos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtAntecedentesMedicos.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtAntecedentesMedicos.setEditable(true);
        txtAntecedentesMedicos.setEnabled(true);
        txtAntecedentesMedicos.setFocusable(true);
        txtAntecedentesMedicos.setText(""); // Campo vacío
        txtAntecedentesMedicos.setLineWrap(true);
        txtAntecedentesMedicos.setWrapStyleWord(true);
        columnaDerecha.add(crearGrupoCampo("Antecedentes Médicos", txtAntecedentesMedicos));
        
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
        
        btnAgregar = new JButton("Agregar Paciente");
        btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnAgregar.setPreferredSize(new Dimension(180, 45));
        btnAgregar.setBackground(new Color(72, 69, 165)); // Color morado como los otros botones
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(72, 69, 165), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAgregar.setContentAreaFilled(true);
        btnAgregar.setOpaque(true);
        btnAgregar.setBorderPainted(true);
        btnAgregar.addActionListener(e -> agregarPaciente());
        panelBotones.add(btnAgregar, BorderLayout.EAST);
        
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
        setSize(900, 600); // Más ancho y más bajo
        setLocationRelativeTo(null);
        setResizable(true); // Permitir redimensionar
        
        // Configuración adicional para asegurar funcionamiento correcto
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setFocusableWindowState(true);
        pack();
    }
    
    private void agregarPaciente() {
        String nombreCompleto = txtNombreCompleto.getText().trim();
        String edad = txtEdad.getText().trim();
        String genero = (String) cmbGenero.getSelectedItem();
        String tipoSangre = (String) cmbTipoSangre.getSelectedItem();
        String email = txtEmail.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String contactoEmergencia = txtContactoEmergencia.getText().trim();
        String antecedentesMedicos = txtAntecedentesMedicos.getText().trim();
        
        // Validación básica
        if (nombreCompleto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre completo es requerido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (edad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La edad es requerida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Simulación de guardado
        String mensaje = "Registro del Paciente Completo:\n\n" +
                        "Nombre: " + nombreCompleto + "\n" +
                        "Edad: " + edad + "\n" +
                        "Género: " + genero + "\n" +
                        "Tipo de Sangre: " + tipoSangre + "\n" +
                        "Email: " + email + "\n" +
                        "Teléfono: " + telefono + "\n" +
                        "Dirección: " + direccion + "\n" +
                        "Contacto de Emergencia: " + contactoEmergencia + "\n" +
                        "Antecedentes Médicos: " + antecedentesMedicos;
        
        JOptionPane.showMessageDialog(this, mensaje, "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}