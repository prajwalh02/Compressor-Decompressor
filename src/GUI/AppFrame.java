package GUI;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;             //ActionListener, ActionEvent
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;

import comp_decomp.compressor;
// import comp_decomp.decompressor;

public class AppFrame extends JFrame implements ActionListener {
    
    JButton compressButton;
    JButton decompressButton;
    public Image backgroundImage;

    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("File Compressor-Decompressor App");
        setLayout(null);

        // Load the background image in the constructor
        backgroundImage = new ImageIcon(getClass().getResource("/images/"+"background2.jpg")).getImage();

        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(40, 200, 200, 50);
        compressButton.setFont(new FontUIResource("Times New Roman", 15, 15));
        compressButton.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));
        compressButton.addActionListener(this);


        decompressButton = new JButton("Select File to Decompress");
        decompressButton.setBounds(300, 200, 200, 50);
        decompressButton.setFont(new FontUIResource("Times New Roman", 15, 15));
        decompressButton.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.red));        
        decompressButton.addActionListener(this);


        // add both the buttons on JFrame
        this.add(compressButton);                      
        this.add(decompressButton);
        this.setSize(600, 500);
        this.getContentPane().setBackground(Color.cyan);
        // this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton) {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    compressor.method(file);
                    JOptionPane.showMessageDialog(this, "File compressed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error compressing file: " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if(e.getSource() == decompressButton) {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    compressor.method(file);
                    JOptionPane.showMessageDialog(this, "File decompressed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error decompressing file: " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
    
}
