package src;

import javax.swing.*;
import java.awt.*;

public class FormularioAgregarDoctorModal extends JDialog {
    private JTextField txtNombreCompleto;
    private JTextField txtEspecialidad;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtHorario;
    private JButton btnCancelar;
    private JButton btnAgregar;
    
    public FormularioAgregarDoctorModal() {
        super((Frame) null, "Agregar Nuevo Doctor", true);
        
        // Configurar el componente para que responda correctamente
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
        
        JLabel lblTitulo = new JLabel("Agregar Nuevo Doctor");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(31, 41, 55));
        
        JLabel lblSubtitulo = new JLabel("Registra la información del nuevo profesional médico");
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
        columnaIzquierda.setLayout(new GridLayout(3, 1, 0, 25));
        columnaIzquierda.setBackground(Color.WHITE);
        columnaIzquierda.setPreferredSize(new Dimension(350, 250));
        
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
        columnaIzquierda.add(crearGrupoCampo("Nombre Completo", txtNombreCompleto));
        
        // Especialidad
        txtEspecialidad = new JTextField(20);
        txtEspecialidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEspecialidad.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtEspecialidad.setEditable(true);
        txtEspecialidad.setEnabled(true);
        txtEspecialidad.setFocusable(true);
        txtEspecialidad.setText(""); // Campo vacío
        columnaIzquierda.add(crearGrupoCampo("Especialidad", txtEspecialidad));
        
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
        
        // Columna derecha
        JPanel columnaDerecha = new JPanel();
        columnaDerecha.setLayout(new GridLayout(3, 1, 0, 25));
        columnaDerecha.setBackground(Color.WHITE);
        columnaDerecha.setPreferredSize(new Dimension(350, 250));
        
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
        columnaDerecha.add(crearGrupoCampo("Correo Electrónico", txtEmail));
        
        // Horario
        txtHorario = new JTextField(20);
        txtHorario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtHorario.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        txtHorario.setEditable(true);
        txtHorario.setEnabled(true);
        txtHorario.setFocusable(true);
        txtHorario.setText(""); // Campo vacío
        columnaDerecha.add(crearGrupoCampo("Horario Disponible", txtHorario));
        
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
        
        btnAgregar = new JButton("Agregar Doctor");
        btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnAgregar.setPreferredSize(new Dimension(160, 45));
        btnAgregar.setBackground(new Color(72, 69, 165));
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
        btnAgregar.addActionListener(e -> agregarDoctor());
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
        setSize(850, 500);
        setLocationRelativeTo(null);
        setResizable(true); // Permitir redimensionar
        
        // Configuración adicional para asegurar funcionamiento correcto
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setFocusableWindowState(true);
        pack();
    }
    
    private void agregarDoctor() {
        String nombreCompleto = txtNombreCompleto.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String email = txtEmail.getText().trim();
        String horario = txtHorario.getText().trim();
        
        // Validación básica
        if (nombreCompleto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre completo es requerido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La especialidad es requerida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Simulación de guardado
        String mensaje = "Doctor Registrado Exitosamente:\n\n" +
                        "Nombre: " + nombreCompleto + "\n" +
                        "Especialidad: " + especialidad + "\n" +
                        "Teléfono: " + telefono + "\n" +
                        "Email: " + email + "\n" +
                        "Horario: " + horario;
        
        JOptionPane.showMessageDialog(this, mensaje, "Doctor Agregado", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}