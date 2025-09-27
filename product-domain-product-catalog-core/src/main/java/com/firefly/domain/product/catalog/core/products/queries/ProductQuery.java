package com.firefly.domain.product.catalog.core.products.queries;

import com.firefly.common.domain.cqrs.query.Query;
import com.firefly.common.product.sdk.model.ProductDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductQuery extends ProductDTO implements Query<ProductDTO> {
    private UUID productId;

    public ProductQuery withProductId(UUID productId) {
        this.setProductId(productId);
        return this;
    }
}