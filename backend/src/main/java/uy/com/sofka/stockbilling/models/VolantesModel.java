package uy.com.sofka.stockbilling.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "volantes")
public class VolantesModel {
    
     @Id
     private Long idVolantes;
     private Long idProveedor;
     private String fechaVolante;
     private List<ProductosModel> listaProductos;

     public VolantesModel(){}

     public VolantesModel(Long idProveedor, String fechaVolante, List<ProductosModel> listaProductos) {
         this.idProveedor = idProveedor;
         this.fechaVolante = fechaVolante;
         this.listaProductos = listaProductos;
     }

     public String getFechaVolante() {
         return fechaVolante;
     }

     public Long getIdProveedor() {
         return idProveedor;
     }

     public Long getIdVolantes() {
         return idVolantes;
     }

     public List<ProductosModel> getListaProductos() {
         return listaProductos;
     }

     public void setFechaVolante(String fechaVolante) {
         this.fechaVolante = fechaVolante;
     }

     public void setIdProveedor(Long idProveedor) {
         this.idProveedor = idProveedor;
     }

     public void setIdVolantes(Long idVolantes) {
         this.idVolantes = idVolantes;
     }

     public void setListaProductos(List<ProductosModel> listaProductos) {
         this.listaProductos = listaProductos;
     }

}