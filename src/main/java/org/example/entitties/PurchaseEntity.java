package org.example.entitties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "purchases")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PurchaseEntity {
    @Id
    @SequenceGenerator(name = "generator_pers", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_pers")
    private Long id;

    @Column(name = "name")
    @Schema(example = "Арбуз")
    private String name;

    @Column(name = "value")
    @Schema(example = "100")
    private String value;
}
