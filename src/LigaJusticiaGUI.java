import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LigaJusticiaGUI {
    private JTabbedPane tabbedPane1;
    public JPanel pGeneral;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPoder;
    private JTextField txtPago;
    private JComboBox<String> txtNivel;
    private JComboBox<String> txtMision;
    private JButton registrarButton;
    private JTable tablaRegistro;
    private JTextField txtmodCodigo;
    private JButton buscarButton;
    private JTextField txtmodNombre;
    private JTextField txtmodPoder;
    private JComboBox<String> txtmodMision;
    private JComboBox<String> txtmodNivel;
    private JTextField txtmodPago;
    private JButton confirmarCambiosButton;
    private JTable table1;
    private JButton verInformeButton;

    ListaSimple listaHeroes = new ListaSimple();

    public LigaJusticiaGUI() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Código", "Nombre", "SuperPoder", "Misión", "Nivel de Dificultad", "Pago Mensual"}, 0);
        tablaRegistro.setModel(model);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int cod = Integer.parseInt(txtCodigo.getText());
                    String nombre = txtNombre.getText();
                    String poder = txtPoder.getText();
                    String mision = txtMision.getSelectedItem().toString();
                    int nivel = Integer.parseInt(txtNivel.getSelectedItem().toString());
                    double pago = Double.parseDouble(txtPago.getText());

                    listaHeroes.agregarHeroe(new LigaJusticia(cod, nombre, poder, mision, nivel, pago), tablaRegistro);

                    txtCodigo.setText("");
                    txtNombre.setText("");
                    txtPoder.setText("");
                    txtMision.setSelectedIndex(0);
                    txtNivel.setSelectedIndex(0);
                    txtPago.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingresar un número válido para el código y el pago");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el registro: " + ex.getMessage());
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int cod = Integer.parseInt(txtmodCodigo.getText());
                    LigaJusticia hero = listaHeroes.buscarPorCodigo(cod);
                    if (hero != null) {
                        txtmodNombre.setText(hero.getNombre());
                        txtmodPoder.setText(hero.getSuperPoder());
                        txtmodMision.setSelectedItem(hero.getMision());
                        txtmodNivel.setSelectedItem(hero.getNivelDificultad());
                        txtmodPago.setText(String.valueOf(hero.getPagoMensual()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Héroe no encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });

        confirmarCambiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int cod = Integer.parseInt(txtmodCodigo.getText());
                    String nombre = txtmodNombre.getText();
                    String poder = txtmodPoder.getText();
                    String mision = txtmodMision.getSelectedItem().toString();
                    int nivel = Integer.parseInt(txtmodNivel.getSelectedItem().toString());
                    double pago = Double.parseDouble(txtmodPago.getText());

                    LigaJusticia hero = listaHeroes.buscarPorCodigo(cod);
                    if (hero != null) {
                        hero.setNombre(nombre);
                        hero.setPagoMensual(pago);
                        hero.setMision(mision);
                        hero.setNivelDificultad(nivel);
                        JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");

                        txtmodCodigo.setText("");
                        txtmodNombre.setText("");
                        txtmodPoder.setText("");
                        txtmodMision.setSelectedIndex(0);
                        txtmodNivel.setSelectedIndex(0);
                        txtmodPago.setText("");

                        listaHeroes.actualizarTabla(tablaRegistro);
                    } else {
                        JOptionPane.showMessageDialog(null, "Héroe no encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos.");
                }
            }
        });
        verInformeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = new DefaultTableModel(new Object[]{"Codigo", "Nombre", "SuperPoder", "Mision", "Nivel", "Pago Mensual", "Aporte al Fondo", "Aporte", "Impuesto", "Pago Neto"}, 0);
                table1.setModel(model);
                ListaSimple.verInforme(table1);
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Liga de la Justicia");
        frame.setContentPane(new LigaJusticiaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


