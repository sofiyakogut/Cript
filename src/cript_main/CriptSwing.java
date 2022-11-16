package cript_main;
	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import javax.swing.JFrame;


	public class CriptSwing extends JFrame implements ActionListener{
		
		JTextField textoField;
		JLabel textoLabel;
		JTextField claveField;
		JLabel claveLabel;
		
		JButton codCesar;
		JButton descodCesar;
		JButton codMonoalfabetico;
		JButton descodMonoalfabetico;
		JButton codNumeracio;
		JButton descodNumeracio;
		
		JLabel codificado;
		
		public CriptSwing() {
			
			//No se puede modificar el tamaño
			setResizable(false);
			setLocationRelativeTo(null);
		    setTitle("Encriptación - Sofiya Kogut");
		    setBounds(250,150,700,500);
		    setLayout(null);
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		    getContentPane().setBackground(Color.decode("#e0d5d5"));
		    
		    
		    //Fuente 
		    Font font = new Font("AppleGothic", Font.PLAIN, 15);
		    Font font1 = new Font("AppleGothic", Font.PLAIN, 25);
		    Font font2 = new Font("AppleGothic", Font.PLAIN, 20);
		    
		    
		    //Texto label
		    textoLabel = new JLabel("Texto");
		    textoLabel.setFont(font1);
		    textoLabel.setForeground(Color.decode("#a08f87"));
		    textoLabel.setBounds(170, 50, 250, 30);
			add(textoLabel);
			//Textfield Texto
			textoField = new JTextField();
			textoField.setBounds(170, 80, 350, 30);
			add(textoField);
		    
		    
			//Clave label
			claveLabel = new JLabel("Clave");
			claveLabel.setFont(font1);
			claveLabel.setForeground(Color.decode("#a08f87")); 
			claveLabel.setBounds(170, 130, 250, 30);
			add(claveLabel);
			//Textfield Clave
			claveField = new JTextField();
			claveField.setBounds(170, 160, 350, 30);
			add(claveField);
		    
			
			//....Cesar.....
		    codCesar = new JButton("Cod.Cesar");
	        codCesar.setBounds(30, 230, 160, 30);
	        codCesar.setForeground(Color.WHITE);
	        codCesar.setBackground(Color.decode("#a08f87"));
	        codCesar.setFont(font);
	        codCesar.setBorderPainted(false);
	        codCesar.setFocusPainted(false);
	        codCesar.addActionListener(this);
			add(codCesar);
		   
			descodCesar = new JButton("Descod.Cesar");
			descodCesar.setBounds(30, 270, 160, 30);
			descodCesar.setForeground(Color.WHITE);
			descodCesar.setBackground(Color.decode("#a08f87"));
			descodCesar.setFont(font);
			descodCesar.setBorderPainted(false);
			descodCesar.setFocusPainted(false);
			descodCesar.addActionListener(this);
		    add(descodCesar);
		    
		    
		    //.....Monoalfabetico.....
		    codMonoalfabetico = new JButton("Cod.Monoalfabetico");
		    codMonoalfabetico.setBounds(220, 230, 200, 30);
		    codMonoalfabetico.setForeground(Color.WHITE);
		    codMonoalfabetico.setBackground(Color.decode("#a08f87"));
		    codMonoalfabetico.setFont(font);
		    codMonoalfabetico.setBorderPainted(false);
		    codMonoalfabetico.setFocusPainted(false);
		    codMonoalfabetico.addActionListener(this);
			add(codMonoalfabetico);
		   
			descodMonoalfabetico = new JButton("Descod.Monoalfabetico");
			descodMonoalfabetico.setBounds(220, 270, 200, 30);
			descodMonoalfabetico.setForeground(Color.WHITE);
			descodMonoalfabetico.setBackground(Color.decode("#a08f87"));
			descodMonoalfabetico.setFont(font);
			descodMonoalfabetico.setBorderPainted(false);
			descodMonoalfabetico.setFocusPainted(false);
			descodMonoalfabetico.addActionListener(this);
		    add(descodMonoalfabetico);

		    
		    //.....Por numeración.....
		    codNumeracio = new JButton("Cod.porNumeracio");
		    codNumeracio.setBounds(450, 230, 200, 30);
		    codNumeracio.setForeground(Color.WHITE);
		    codNumeracio.setBackground(Color.decode("#a08f87"));
		    codNumeracio.setFont(font);
		    codNumeracio.setBorderPainted(false);
		    codNumeracio.setFocusPainted(false);
		    codNumeracio.addActionListener(this);
			add(codNumeracio);
		   
			
			descodNumeracio = new JButton("Descod.porNumeracio");
			descodNumeracio.setBounds(450, 270, 200, 30);
			descodNumeracio.setForeground(Color.WHITE);
			descodNumeracio.setBackground(Color.decode("#a08f87"));
			descodNumeracio.setFont(font);
			descodNumeracio.setBorderPainted(false);
			descodNumeracio.setFocusPainted(false);
			descodNumeracio.addActionListener(this);
		    add(descodNumeracio);
		    
		    
		    //.....Linea.....
		    JLabel linea2 = new JLabel("______________________________________");
			linea2.setFont(font1);
			linea2.setForeground(Color.WHITE);
			linea2.setBounds(70, 320, 600, 30);
			add(linea2);
		    
		    
		    //.....JLabel de texto codificado
		    codificado = new JLabel();
		    codificado.setFont(font2);
		    codificado.setForeground(Color.decode("#a08f87"));
		    codificado.setBounds(70, 370, 500, 40);
			add(codificado);
	        
		    setVisible(true);
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == codCesar) {
				codificado.setText("Texto codificado: " + cript_object.CriptObject.encriptarCesar(Integer.parseInt(claveField.getText()), textoField.getText()));
			} else if (e.getSource() == descodCesar) {
				codificado.setText("Texto descodificado: " + cript_object.CriptObject.desencriptarCesar(Integer.parseInt(claveField.getText()), textoField.getText()));
			} else if (e.getSource() == codMonoalfabetico) {
				codificado.setText("Texto codificado: " + cript_object.CriptObject.encriptarMonoalfabetico(claveField.getText(), textoField.getText()));
			} else if (e.getSource() == descodMonoalfabetico) {
				codificado.setText("Texto descodificado: " + cript_object.CriptObject.desencriptarMonoalfabetico(claveField.getText(), textoField.getText()));
			} else if (e.getSource() == codNumeracio) {
				codificado.setText("Texto codificado: " + cript_object.CriptObject.encriptarPorNumeracion(claveField.getText(), textoField.getText()));
			} else if (e.getSource() == descodNumeracio) {
				codificado.setText("Texto descodificado: " + cript_object.CriptObject.desencriptarPorNumeracion(claveField.getText(), textoField.getText()).replace("*", ""));
			}
			
		}
	}
