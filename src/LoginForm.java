package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel panelPrincipal;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancelar;
    
    public LoginForm() {
        inicializarComponentes();
        configurarVentana();
        agregarEventos();
    }
    
    private void inicializarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(248, 250, 252));
        
        // Panel central con el formulario
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridBagLayout());
        panelCentral.setBackground(new Color(248, 250, 252));
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Panel del formulario (tarjeta blanca)
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(229, 231, 235), 1),
            BorderFactory.createEmptyBorder(40, 40, 40, 40)
        ));
        panelFormulario.setPreferredSize(new Dimension(500, 600));
        
        GridBagConstraints gbcForm = new GridBagConstraints();
        gbcForm.insets = new Insets(10, 10, 10, 10);
        
        // Panel para título con corazón
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelTitulo.setBackground(Color.WHITE);
        
        // Icono del corazón
        JLabel lblIcono = new JLabel("❤️");
        lblIcono.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));
        panelTitulo.add(lblIcono);
        
        // Título principal
        JLabel lblTitulo = new JLabel("Sistema de Citas Médicas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(31, 41, 55));
        panelTitulo.add(lblTitulo);
        
        gbcForm.gridx = 0;
        gbcForm.gridy = 0;
        gbcForm.gridwidth = 2;
        gbcForm.anchor = GridBagConstraints.CENTER;
        panelFormulario.add(panelTitulo, gbcForm);
        
        // Subtítulo
        JLabel lblSubtitulo = new JLabel("Gestión integral para consultorios y clínicas");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(107, 114, 128));
        gbcForm.gridx = 0;
        gbcForm.gridy = 1;
        gbcForm.gridwidth = 2;
        gbcForm.anchor = GridBagConstraints.CENTER;
        panelFormulario.add(lblSubtitulo, gbcForm);
        
        // Espaciador
        gbcForm.gridx = 0;
        gbcForm.gridy = 2;
        gbcForm.gridwidth = 2;
        gbcForm.ipady = 15;
        panelFormulario.add(new JLabel(), gbcForm);
        
        // Título del formulario
        JLabel lblFormTitulo = new JLabel("Iniciar Sesión");
        lblFormTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblFormTitulo.setForeground(new Color(31, 41, 55));
        gbcForm.gridx = 0;
        gbcForm.gridy = 3;
        gbcForm.gridwidth = 2;
        gbcForm.anchor = GridBagConstraints.CENTER;
        gbcForm.ipady = 0;
        panelFormulario.add(lblFormTitulo, gbcForm);
        
        // Instrucciones
        JLabel lblInstrucciones = new JLabel("Ingresa tus credenciales para acceder al sistema");
        lblInstrucciones.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblInstrucciones.setForeground(new Color(107, 114, 128));
        gbcForm.gridx = 0;
        gbcForm.gridy = 4;
        gbcForm.gridwidth = 2;
        gbcForm.anchor = GridBagConstraints.CENTER;
        panelFormulario.add(lblInstrucciones, gbcForm);
        
        // Espaciador
        gbcForm.gridx = 0;
        gbcForm.gridy = 5;
        gbcForm.gridwidth = 2;
        gbcForm.ipady = 15;
        panelFormulario.add(new JLabel(), gbcForm);
        
        // Campo Email
        JLabel lblEmail = new JLabel("Correo Electrónico");
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblEmail.setForeground(new Color(31, 41, 55));
        gbcForm.gridx = 0;
        gbcForm.gridy = 6;
        gbcForm.gridwidth = 2;
        gbcForm.anchor = GridBagConstraints.WEST;
        gbcForm.ipady = 0;
        panelFormulario.add(lblEmail, gbcForm);
        
        txtEmail = new JTextField(20);
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtEmail.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));
        txtEmail.setBackground(Color.WHITE);
        txtEmail.setForeground(new Color(31, 41, 55));
        gbcForm.gridx = 0;
        gbcForm.gridy = 7;
        gbcForm.gridwidth = 2;
        gbcForm.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txtEmail, gbcForm);
        
        // Campo Contraseña
        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblPassword.setForeground(new Color(31, 41, 55));
        gbcForm.gridx = 0;
        gbcForm.gridy = 8;
        gbcForm.gridwidth = 2;
        gbcForm.anchor = GridBagConstraints.WEST;
        gbcForm.fill = GridBagConstraints.NONE;
        panelFormulario.add(lblPassword, gbcForm);
        
        txtPassword = new JPasswordField(20);
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));
        txtPassword.setBackground(Color.WHITE);
        txtPassword.setForeground(new Color(31, 41, 55));
        gbcForm.gridx = 0;
        gbcForm.gridy = 9;
        gbcForm.gridwidth = 2;
        gbcForm.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(txtPassword, gbcForm);
        
        // Espaciador
        gbcForm.gridx = 0;
        gbcForm.gridy = 10;
        gbcForm.gridwidth = 2;
        gbcForm.ipady = 20;
        gbcForm.fill = GridBagConstraints.NONE;
        panelFormulario.add(new JLabel(), gbcForm);
        
        // Botón de login
        btnLogin = new JButton("🛡️ Iniciar sesión");
        btnLogin.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
        btnLogin.setPreferredSize(new Dimension(0, 45));
        btnLogin.setBackground(new Color(72, 69, 165)); // Color #4845a5
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(72, 69, 165), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setContentAreaFilled(true);
        btnLogin.setOpaque(true);
        btnLogin.setBorderPainted(true);
        
        // Efecto hover
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(60, 57, 140));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(72, 69, 165));
            }
        });
        gbcForm.gridx = 0;
        gbcForm.gridy = 11;
        gbcForm.gridwidth = 2;
        gbcForm.ipady = 0;
        gbcForm.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(btnLogin, gbcForm);
        
        // Agregar el panel del formulario al panel central
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCentral.add(panelFormulario, gbc);
        
        // Agregar al panel principal
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        add(panelPrincipal);
    }
    
    private void configurarVentana() {
        setTitle("Sistema de Citas Médicas - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    private void agregarEventos() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
        
        // Permitir login con Enter
        txtPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
    }
    
    private void realizarLogin() {
        String email = txtEmail.getText().trim();
        String password = new String(txtPassword.getPassword());
        
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Simular validación de credenciales
        if (email.equals("admin@clinica.com") && password.equals("admin123")) {
            JOptionPane.showMessageDialog(this, "Login exitoso", 
                                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new PanelAdministracion().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
