package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entitties.PurchaseEntity;
import org.example.repositories.ShoppingListRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;


    public List<PurchaseEntity> getPurchase(List<Long> ids){
        if(ids == null){
            return (List<PurchaseEntity>) shoppingListRepository.findAll();
        }else {
            return (List<PurchaseEntity>) shoppingListRepository.findAllById(ids);
        }
    }

    public PurchaseEntity updatePurchase(PurchaseEntity data) {
       return shoppingListRepository.save((PurchaseEntity) data);
    }

    public  List<PurchaseEntity> createPurchase(List<PurchaseEntity> purchaseEntities){
        return (List<PurchaseEntity>) shoppingListRepository.saveAll(purchaseEntities);
    }
    public List<PurchaseEntity> deletePurchase(List<Long> ids){
        List<PurchaseEntity> purchaseEntities = (List<PurchaseEntity>) shoppingListRepository.findAllById(ids);
        shoppingListRepository.deleteAll(purchaseEntities);
        return purchaseEntities;
    }
}
