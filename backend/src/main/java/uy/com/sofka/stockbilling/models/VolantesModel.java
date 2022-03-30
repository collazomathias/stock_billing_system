package uy.com.sofka.stockbilling.models;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "volantes")
public class VolantesModel {
    
     @Id
     private String idVolantes = UUID.randomUUID().toString().substring(0, 10);
     private String idProveedor;
     private String fechaVolante;
     private List<ProductosModel> listaProductos;

     public VolantesModel(){}

     public VolantesModel(String idProveedor, String fechaVolante, List<ProductosModel> listaProductos) {
         this.idProveedor = idProveedor;
         this.fechaVolante = fechaVolante;
         this.listaProductos = listaProductos;
     }

     public String getFechaVolante() {
         return fechaVolante;
     }

     public String getIdProveedor() {
         return idProveedor;
     }

     public String getIdVolantes() {
         return idVolantes;
     }

     public List<ProductosModel> getListaProductos() {
         return listaProductos;
     }

     public void setFechaVolante(String fechaVolante) {
         this.fechaVolante = fechaVolante;
     }

     public void setIdProveedor(String idProveedor) {
         this.idProveedor = idProveedor;
     }

     public void setIdVolantes(String idVolantes) {
         this.idVolantes = idVolantes;
     }

     public void setListaProductos(List<ProductosModel> listaProductos) {
         this.listaProductos = listaProductos;
     }

}