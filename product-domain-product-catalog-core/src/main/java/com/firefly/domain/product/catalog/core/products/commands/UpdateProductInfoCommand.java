package com.firefly.domain.product.catalog.core.products.commands;

import com.firefly.common.domain.cqrs.command.Command;
import com.firefly.common.product.sdk.model.ProductDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateProductInfoCommand extends ProductDTO implements Command<UUID> {
    private UUID productId;


    public UpdateProductInfoCommand withProductId(UUID productId) {
        this.setProductId(productId);
        return this;
    }

    public UpdateProductInfoCommand withProductStatus(ProductDTO.ProductStatusEnum productStatus){
        this.setProductStatus(productStatus);
        return this;
    }
}
