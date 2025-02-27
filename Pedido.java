import java.time.LocalDate;
import java.util.Objects;

public class Pedido {

    private int numeroPedido;
    private LocalDate fechaPedido;
    private String estado;
    private String direccEntrega;
    private String codigo;
    private String cliente;
    private double precio;

    public Pedido(int numeroPedido, double precio, String cliente, String codigo, String estado, String direccEntrega, LocalDate fechaPedido) {
        this.numeroPedido = numeroPedido;
        this.precio = precio;
        this.cliente = cliente;
        this.codigo = codigo;
        this.estado = estado;
        this.direccEntrega = direccEntrega;
        this.fechaPedido = fechaPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccEntrega() {
        return direccEntrega;
    }

    public void setDireccEntrega(String direccEntrega) {
        this.direccEntrega = direccEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return numeroPedido == pedido.numeroPedido && Double.compare(precio, pedido.precio) == 0 && Objects.equals(fechaPedido, pedido.fechaPedido) && Objects.equals(estado, pedido.estado) && Objects.equals(direccEntrega, pedido.direccEntrega) && Objects.equals(codigo, pedido.codigo) && Objects.equals(cliente, pedido.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroPedido, fechaPedido, estado, direccEntrega, codigo, cliente, precio);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido=" + numeroPedido +
                ", fechaPedido=" + fechaPedido +
                ", estado='" + estado + '\'' +
                ", direccEntrega='" + direccEntrega + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cliente='" + cliente + '\'' +
                ", precio=" + precio +
                '}';
    }
}
