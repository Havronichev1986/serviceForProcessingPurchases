package org.example.repositories;

import org.example.entitties.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<PurchaseEntity, Long> { }
