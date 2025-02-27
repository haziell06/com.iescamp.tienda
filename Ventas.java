import java.util.ArrayList;

public class Ventas {
    private ArrayList<Pedido> pedidos;

    public Ventas() {
        this.pedidos = new ArrayList<>();
    }
    public Pedido buscarPorCodigo(String codigo) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigo().equalsIgnoreCase(codigo)) {
                return pedido;
            }
        }
        return null;
    }
    public ArrayList<Pedido> filtrarPorCliente(String cliente) {
        ArrayList<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().equalsIgnoreCase(cliente)) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }
    public double calcularPrecioTotal() {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total += pedido.getPrecio();
        }
        return total;
    }
}