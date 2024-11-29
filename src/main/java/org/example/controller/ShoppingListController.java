package org.example.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.entitties.PurchaseEntity;
import org.example.services.ShoppingListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("db")
@Tag(name = "База с покупками")
@RequiredArgsConstructor

public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @GetMapping("purchases")
    @Operation(summary = "Получение списка покупок")
    public List<PurchaseEntity> getPurchase(@RequestParam(required = false)List<Long> ids){
        return shoppingListService.getPurchase(ids);
    }

    @PutMapping("purchases")
    @Operation(summary = "Редактирование списка покупок")
    public List<PurchaseEntity> updatePurchase(@RequestBody List<PurchaseEntity> purchaseEntities){
        return shoppingListService.createPurchase(purchaseEntities);
    }

    @PostMapping("purchases")
    @Operation(summary = "Добовление покупок")
    public List<PurchaseEntity> createPurchase(@RequestBody List<PurchaseEntity> purchaseEntities){
        return shoppingListService.createPurchase(purchaseEntities);
    }

    @DeleteMapping("purchases")
    @Operation(summary = "Удаление покупки")
    public List<PurchaseEntity> deletePurchase(@RequestBody List<Long> ids){
        return shoppingListService.deletePurchase(ids);
    }

}
