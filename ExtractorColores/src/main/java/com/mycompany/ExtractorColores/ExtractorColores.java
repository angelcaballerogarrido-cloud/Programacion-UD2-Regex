package com.mycompany.ExtractorColores;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractorColores extends JFrame {

    
    private JPanel panelColores;

    public ExtractorColores() {
        
        setTitle("Extractor de Colores CSS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

      
        JButton btnAbrir = new JButton("Abrir archivo CSS...");
        btnAbrir.setFont(new Font("Arial", Font.BOLD, 14));
        add(btnAbrir, BorderLayout.NORTH);

      
        panelColores = new JPanel();
        panelColores.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); // Alineados a la izquierda
        JScrollPane scroll = new JScrollPane(panelColores);
        add(scroll, BorderLayout.CENTER);

       
        btnAbrir.addActionListener(e -> abrirArchivo());
    }

    private void abrirArchivo() {
        
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            procesarCSS(archivo);
        }
    }

    private void procesarCSS(File archivo) {
        
        panelColores.removeAll();
        panelColores.repaint();

        try {
            
            String contenidoCSS = Files.readString(archivo.toPath());

          
            
            String regex = "(#[A-Fa-f0-9]{3,6})|" +             
                           "(rgb\\s*\\(\\s*\\d+\\s*,\\s*\\d+\\s*,\\s*\\d+\\s*\\))|" + // 
                           "(rgba\\s*\\(\\s*\\d+\\s*,\\s*\\d+\\s*,\\s*\\d+\\s*,\\s*[0-9.]+\\s*\\))"; 

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(contenidoCSS);

            boolean encontrado = false;
            
            while (matcher.find()) {
                encontrado = true;
                String codigoColor = matcher.group(); 
                
             
                Color colorJava = convertirTextoAColor(codigoColor);
                
                
                agregarPanelColor(codigoColor, colorJava);
            }
            
            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "No se encontraron colores en este archivo.");
            }

        
            panelColores.revalidate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage());
        }
    }

    
    private void agregarPanelColor(String texto, Color color) {
        JPanel panelItem = new JPanel(new BorderLayout());
        panelItem.setPreferredSize(new Dimension(150, 150));
        panelItem.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        
        JPanel colorBox = new JPanel();
        colorBox.setBackground(color);
        
       
        JTextField txtCodigo = new JTextField(texto);
        txtCodigo.setEditable(false);
        txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);

        panelItem.add(colorBox, BorderLayout.CENTER);
        panelItem.add(txtCodigo, BorderLayout.SOUTH);

        panelColores.add(panelItem);
    }

   
    private Color convertirTextoAColor(String texto) {
        texto = texto.toLowerCase().trim();
        
        try {
            if (texto.startsWith("#")) {
               
                return Color.decode(texto);
            } 
            else if (texto.startsWith("rgb")) {
               
                String numeros = texto.replaceAll("[a-z()\\s]", ""); 
                String[] partes = numeros.split(",");
                
                int r = Integer.parseInt(partes[0]);
                int g = Integer.parseInt(partes[1]);
                int b = Integer.parseInt(partes[2]);
                
                if (partes.length == 4) { // Es RGBA
                    float a = Float.parseFloat(partes[3]);
                    
                    return new Color(r, g, b, (int)(a * 255));
                } else {
                    return new Color(r, g, b);
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo convertir el color: " + texto);
            return Color.WHITE; 
        }
        return Color.BLACK;
    }

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> {
            new ExtractorColores().setVisible(true);
        });
    }
}