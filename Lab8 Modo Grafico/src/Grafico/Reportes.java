package Grafico;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Becas;
import Logica.Estudiantes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Reportes extends JFrame {
    private JTextArea textAreaBecados;
    private JTextField textFieldCedula;
    private JComboBox<String> comboBoxCarrera;
    private JComboBox<String> comboBoxSexo;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Becas becas; // Referencia a la instancia de Becas

    /**
     * Create the frame.
     */
    public Reportes(Becas becas) {
        this.becas = becas; // Asignar la instancia de Becas recibida por parámetro

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Reportes");
        lblNewLabel.setBounds(300, 10, 200, 46);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Estudiantes Becados:");
        lblNewLabel_1.setBounds(50, 70, 200, 35);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lblNewLabel_1);

        textAreaBecados = new JTextArea();
        textAreaBecados.setEditable(false);
        textAreaBecados.setBounds(50, 120, 300, 400);
        contentPane.add(textAreaBecados);

        JLabel lblNewLabel_2 = new JLabel("Buscar por Cédula:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(400, 120, 150, 20);
        contentPane.add(lblNewLabel_2);

        textFieldCedula = new JTextField();
        textFieldCedula.setBounds(550, 120, 150, 20);
        contentPane.add(textFieldCedula);
        textFieldCedula.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBuscar.setBounds(550, 160, 100, 30);
        contentPane.add(btnBuscar);

        // ComboBox para seleccionar carrera
        JLabel lblNewLabel_3 = new JLabel("Filtrar por Carrera:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_3.setBounds(400, 210, 150, 20);
        contentPane.add(lblNewLabel_3);

        comboBoxCarrera = new JComboBox<>();
        comboBoxCarrera.setModel(new DefaultComboBoxModel<>(new String[] {"", "Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
        comboBoxCarrera.setBounds(550, 210, 150, 20);
        contentPane.add(comboBoxCarrera);

        // ComboBox para seleccionar sexo
        JLabel lblNewLabel_4 = new JLabel("Filtrar por Sexo:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_4.setBounds(400, 260, 150, 20);
        contentPane.add(lblNewLabel_4);

        comboBoxSexo = new JComboBox<>();
        comboBoxSexo.setModel(new DefaultComboBoxModel<>(new String[] {"", "Masculino", "Femenino"}));
        comboBoxSexo.setBounds(550, 260, 150, 20);
        contentPane.add(comboBoxSexo);

        // Botón para aplicar filtros
        JButton btnFiltrar = new JButton("Aplicar Filtros");
        btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnFiltrar.setBounds(550, 310, 150, 30);
        contentPane.add(btnFiltrar);

        // ActionListener para el botón de búsqueda por cédula
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEstudiante();
            }
        });

        // ActionListener para el botón de aplicar filtros
        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aplicarFiltros();
            }
        });

        // Mostrar estudiantes becados al abrir la ventana de reportes
        mostrarBecados();
    }

    private void mostrarBecados() {
        ArrayList<String> estudiantesBecados = becas.obtenerEstudiantesBecados();
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiantes becados:\n");

        for (String nombre : estudiantesBecados) {
            sb.append(nombre).append("\n");
        }

        textAreaBecados.setText(sb.toString());
    }

    private void buscarEstudiante() {
        String cedula = textFieldCedula.getText().trim();
        if (!cedula.isEmpty()) {
            Estudiantes estudianteEncontrado = becas.buscarEstudiantePorCedula(cedula);
            if (estudianteEncontrado != null) {
                textAreaBecados.setText("Estudiante encontrado:\n" + estudianteEncontrado.getNombre());
            } else {
                textAreaBecados.setText("No se encontró ningún estudiante con esa cédula.");
            }
        } else {
            textAreaBecados.setText("Por favor, ingrese una cédula para buscar.");
        }
    }

    private void aplicarFiltros() {
        String carreraSeleccionada = (String) comboBoxCarrera.getSelectedItem();
        String sexoSeleccionado = (String) comboBoxSexo.getSelectedItem();

        ArrayList<String> estudiantesFiltrados = becas.obtenerEstudiantesFiltrados(carreraSeleccionada, sexoSeleccionado);
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiantes filtrados:\n");

        for (String nombre : estudiantesFiltrados) {
            sb.append(nombre).append("\n");
        }

        textAreaBecados.setText(sb.toString());
    }
    }
