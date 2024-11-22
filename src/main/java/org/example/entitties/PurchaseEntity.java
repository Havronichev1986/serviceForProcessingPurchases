package org.example.entitties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")

public class PurchaseEntity {
    @Id
    private Long id;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private String value;
}
