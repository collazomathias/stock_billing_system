package uy.com.sofka.stockbilling.models.vendedores;

public class VendedoresDTO {
    
    private String nombreVendedor;
    
    public VendedoresDTO(){}

    public VendedoresDTO(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

}
