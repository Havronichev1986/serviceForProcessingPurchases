package org.example.repositories;

import org.example.entitties.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<PurchaseEntity, Long> { }
