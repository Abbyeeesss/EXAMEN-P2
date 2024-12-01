import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListaSimple {

    public static Nodo inicio;
    public int tamanio;

    public ListaSimple() {
        inicio = null;
        tamanio = 0;
    }

    ;

    boolean estavacia() {
        return inicio == null;
    }

    public void agregarHeroe(LigaJusticia hero, JTable jTable) {
        if (estavacia()) {
            inicio = new Nodo(hero);
        } else {
            if (!existeHeroe(hero.getCodigo())) {
                Nodo nuevoNodo = new Nodo(hero);
                nuevoNodo.siguiente = inicio;
                inicio = nuevoNodo;
            } else {
                JOptionPane.showMessageDialog(null, "El código ya existe. No se puede registrar.");
                return;
            }
        }
        tamanio++;
        actualizarTabla(jTable);
    }

    public boolean existeHeroe(int codigo) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.hero.getCodigo() == codigo) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void actualizarTabla(JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Nodo actual = inicio;
        while (actual != null) {
            model.addRow(new Object[]{
                    actual.hero.getCodigo(),
                    actual.hero.getNombre(),
                    actual.hero.getSuperPoder(),
                    actual.hero.getMision(),
                    actual.hero.getNivelDificultad(),
                    actual.hero.getPagoMensual()
            });
            actual = actual.siguiente;
        }
    }

    public LigaJusticia buscarPorCodigo(int codigo) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.hero.getCodigo() == codigo) {
                return actual.hero;
            }
            actual = actual.siguiente;
        }
        JOptionPane.showMessageDialog(null, "Héroe no encontrado.");
        return null;
    }

    public static void verInforme(JTable jTable){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Nodo actual = inicio;
        while(actual != null){
            model.addRow(new Object[]{actual.hero.getCodigo(),
                    actual.hero.getNombre(),
                    actual.hero.getSuperPoder(),
                    actual.hero.getMision(),
                    actual.hero.getNivelDificultad(),
                    actual.hero.getPagoMensual(),
                    actual.hero.CalcularAporteFondo(),
                    actual.hero.CalcularImpuesto(),
                    actual.hero.CalcularPagoNeto()});

            actual = actual.siguiente;
        }
    }

    public void listarHeroes(JTable table) {
        actualizarTabla(table);
    }


}