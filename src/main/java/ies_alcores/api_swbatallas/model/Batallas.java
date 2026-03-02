package ies_alcores.api_swbatallas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Batallas {

    @Id
    private int batalla_id;
    private String nombre;
    private String ubicacion;
    private String resultado;
    private int anio_galactico;

    @ManyToOne
    private Naves naves;
}
