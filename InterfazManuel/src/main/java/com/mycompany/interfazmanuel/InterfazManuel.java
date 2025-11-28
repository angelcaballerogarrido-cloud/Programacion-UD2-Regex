package com.mycompany.InterfazManuel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterfazManuel {

    public static void main(String[] args) {
        initComponents();
    }

    // Método basado en la estructura de la imagen 1
    private static void initComponents() {
        // 1. Configuración del Frame
        JFrame frame = new JFrame("Login - Expresiones Regulares");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Panel principal y Layout
        JPanel panel = new JPanel();
        // Usamos GridLayout para organizar filas ordenadas (simple y efectivo)
        panel.setLayout(new GridLayout(6, 2, 10, 10)); 

        // 3. Componentes de la Interfaz
        JLabel lblEmail = new JLabel("Correo Electrónico:");
        JTextField txtEmail = new JTextField();

        JLabel lblUrl = new JLabel("URL (con puerto):");
        JTextField txtUrl = new JTextField();

        JLabel lblUser = new JLabel("Usuario (MAYUS/Simbolos/Nums):");
        JTextField txtUser = new JTextField();

        JLabel lblPass = new JLabel("Contraseña (minúscula inicial):");
        // Usamos JTextField normal para ver lo que escribimos al probar regex
        JTextField txtPass = new JTextField(); 

        JButton btnLogin = new JButton("Validar / Entrar");
        JLabel lblResultado = new JLabel(""); // Para mostrar mensajes

        // 4. Añadir componentes al panel
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblUrl);
        panel.add(txtUrl);
        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPass);
        panel.add(txtPass);
        panel.add(btnLogin);
        panel.add(lblResultado);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String errores = "";

             
                String regexEmail = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]+$";
                Pattern patternEmail = Pattern.compile(regexEmail);
                Matcher matcherEmail = patternEmail.matcher(txtEmail.getText());

                if (!matcherEmail.matches()) { // [cite: 88, 100]
                    errores += "Error: Email inválido (formato: x@x.x). \n";
                }

                
                String regexUrl = "^(https://.+:\\d+|(\\d{1,3}\\.){3}\\d{1,3}:\\d+)$";
                Pattern patternUrl = Pattern.compile(regexUrl);
                Matcher matcherUrl = patternUrl.matcher(txtUrl.getText());

                if (!matcherUrl.matches()) {
                    errores += "Error: URL debe ser https://...:puerto o IP:puerto. \n";
                } else {
                    //  Si no es https, comentar (advertir) pero dejar pasar
                    if (!txtUrl.getText().startsWith("https")) {
                        JOptionPane.showMessageDialog(frame, "Aviso: La URL no es segura (HTTPS), pero se permite.");
                    }
                }

               
                String regexUser = "^[A-Z\\W][A-Z0-9\\W]*$"; 
                Pattern patternUser = Pattern.compile(regexUser);
                Matcher matcherUser = patternUser.matcher(txtUser.getText());

                if (!matcherUser.matches()) {
                    errores += "Error: Usuario inválido (Solo MAYUS/Símbolos/Num, no empezar por num). \n";
                }

                
                String regexPass = "^[a-z][a-zA-Z0-9]*$";
                Pattern patternPass = Pattern.compile(regexPass);
                Matcher matcherPass = patternPass.matcher(txtPass.getText());

                if (!matcherPass.matches()) {
                    errores += "Error: Pass inválida (Debe empezar minúscula, sin símbolos). \n";
                }
                if (errores.isEmpty()) {
                    lblResultado.setForeground(Color.BLUE);
                    lblResultado.setText("¡Login Correcto!");
                    JOptionPane.showMessageDialog(frame, "Datos enviados correctamente.");
                } else {
                    lblResultado.setForeground(Color.RED);
                    lblResultado.setText("Hay errores (ver consola/popup)");
                    JOptionPane.showMessageDialog(frame, errores);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true); //
    }
}