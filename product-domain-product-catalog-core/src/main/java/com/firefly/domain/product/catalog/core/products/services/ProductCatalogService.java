package com.firefly.domain.product.catalog.core.products.services;

import com.firefly.domain.product.catalog.core.products.commands.RegisterProductCommand;
import com.firefly.domain.product.catalog.core.products.commands.RegisterProductFeeStructureCommand;
import com.firefly.domain.product.catalog.core.products.commands.UpdateProductInfoCommand;
import com.firefly.transactional.core.SagaResult;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProductCatalogService {


    /**
     * Registers a new product with its associated features, pricing, lifecycle, and other configurations.
     *
     * @param command the command containing the product details and related configurations
     * @return a Mono containing the result of the saga process
     */
    Mono<SagaResult> registerProduct(RegisterProductCommand command);


    /**
     * Updates an existing product's information, including its attributes, features, or configurations.
     *
     * @param command the command containing the updated product information and associated configurations
     * @return a Mono containing the result of the saga process, representing the outcome of the update operation
     */
    Mono<SagaResult> updateProduct(UpdateProductInfoCommand command);

    /**
     * Links a general ledger (GL) posting rule set to a product.
     *
     * @param command the command containing the product ID and the fee structure ID to be linked
     * @return a Mono containing the result of the saga process, representing the outcome of the operation
     */
    Mono<SagaResult> linkPostingRuleSet(RegisterProductFeeStructureCommand command);
}
