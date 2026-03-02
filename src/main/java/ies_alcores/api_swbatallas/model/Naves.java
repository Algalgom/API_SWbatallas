package ies_alcores.api_swbatallas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Naves {

    @Id
    private int nave_id;
    private String modelo;
    private String clase;
    private String faccion;
    private double longitud_m;
}
