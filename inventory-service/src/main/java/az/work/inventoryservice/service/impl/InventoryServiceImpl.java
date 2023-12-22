package az.work.inventoryservice.service.impl;

import az.work.inventoryservice.dto.InventoryResponse;
import az.work.inventoryservice.repository.InventoryRepo;
import az.work.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepo inventoryRepo;
    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepo.findBySkuCodeIn(skuCode)
                .stream().map(inventory ->
                    InventoryResponse.builder().
                            skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()).toList();
    }
}
