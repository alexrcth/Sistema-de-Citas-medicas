package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Configurar la codificación UTF-8 para emojis
        System.setProperty("file.encoding", "UTF-8");
        
        // Ejecutar la aplicación en el hilo de eventos
        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}

class SistemaCitasMedicas extends JFrame {
    private JPanel panelPrincipal;
    private JButton btnNuevaCita;
    private JButton btnConsultarCitas;
    private JButton btnSalir;
    
    public SistemaCitasMedicas() {
        inicializarComponentes();
        configurarVentana();
        agregarEventos();
    }
    
    private void inicializarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(245, 248, 250));
        
        // Panel superior con título y decoración
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBackground(new Color(25, 118, 210));
        panelTitulo.setPreferredSize(new Dimension(0, 100));
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // Título principal
        JLabel lblTitulo = new JLabel("Sistema de Citas Médicas", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);
        
        // Subtítulo
        JLabel lblSubtitulo = new JLabel("Gestión Profesional de Citas", JLabel.CENTER);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(200, 230, 255));
        panelTitulo.add(lblSubtitulo, BorderLayout.SOUTH);
        
        // Panel central con botones mejorados
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        panelBotones.setBackground(new Color(245, 248, 250));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Botón Nueva Cita con diseño mejorado
        btnNuevaCita = crearBotonEstilizado("Nueva Cita", new Color(0, 150, 0), "");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 15, 15, 15);
        panelBotones.add(btnNuevaCita, gbc);
        
        // Botón Consultar Citas con diseño mejorado
        btnConsultarCitas = crearBotonEstilizado("Consultar Citas", new Color(0, 100, 200), "");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelBotones.add(btnConsultarCitas, gbc);
        
        // Botón Salir con diseño mejorado
        btnSalir = crearBotonEstilizado("Salir", new Color(200, 0, 0), "");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelBotones.add(btnSalir, gbc);
        
        // Panel inferior con información
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(new Color(240, 240, 240));
        panelInfo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        
        JLabel lblInfo = new JLabel("© 2024 Sistema de Citas Médicas - Versión 1.0");
        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblInfo.setForeground(new Color(100, 100, 100));
        panelInfo.add(lblInfo);
        
        // Agregar paneles al panel principal
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        panelPrincipal.add(panelInfo, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    private JButton crearBotonEstilizado(String texto, Color color, String icono) {
        JButton boton = new JButton();
        boton.setText(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        boton.setPreferredSize(new Dimension(250, 80));
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Efecto hover
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(color.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(color);
            }
        });
        
        return boton;
    }
    
    private void configurarVentana() {
        setTitle("Sistema de Citas Médicas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setIconImage(createIcon());
    }
    
    private Image createIcon() {
        // Crear un icono simple para la ventana
        int size = 32;
        java.awt.image.BufferedImage icon = new java.awt.image.BufferedImage(size, size, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = icon.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Dibujar un icono de cruz médica
        g2d.setColor(new Color(25, 118, 210));
        g2d.fillRect(0, 0, size, size);
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(size/2 - 2, size/4, 4, size/2);
        g2d.fillRect(size/4, size/2 - 2, size/2, 4);
        
        g2d.dispose();
        return icon;
    }
    
    private void agregarEventos() {
        btnNuevaCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormularioNuevaCita().setVisible(true);
            }
        });
        
        btnConsultarCitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormularioConsultarCitas().setVisible(true);
            }
        });
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}