package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.List;
@Entity
@Table(name = "Libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Libro extends Base{

    @Column(name = "Fecha")
    private int fecha;

    @Column(name = "Genero")
    private String genero;

    @Column(name = "Paginas")
    private int paginas;

    @Column(name = "Titulo")
    private String titulo;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;
}