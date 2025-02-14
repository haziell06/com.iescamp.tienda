import java.time.LocalDate;
import java.util.Objects;

public class Pedido extends  Cliente{
    public Pedido(String DNI, String nombre, String direccion, String apellidos, String telefono, String email, LocalDate fechaNacimiento, String password, boolean activo) {
        super(DNI, nombre, direccion, apellidos, telefono, email, fechaNacimiento, password, activo);
    }



    private int numeroPedido;
    private LocalDate fechaPedido;
    private String estado;
    private String direccEntrega;

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
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

    public Pedido() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pedido pedido = (Pedido) o;
        return numeroPedido == pedido.numeroPedido && Objects.equals(fechaPedido, pedido.fechaPedido) && Objects.equals(estado, pedido.estado) && Objects.equals(direccEntrega, pedido.direccEntrega);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroPedido, fechaPedido, estado, direccEntrega);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido=" + numeroPedido +
                ", fechaPedido=" + fechaPedido +
                ", estado='" + estado + '\'' +
                ", direccEntrega='" + direccEntrega + '\'' +
                '}';
    }
}
