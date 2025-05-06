package com.alquilercoches.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaPago;

    private String metodoPago;

    private double importe;

    @OneToOne
    @JoinColumn(name = "alquiler_id")
    private Alquiler alquiler;
}

