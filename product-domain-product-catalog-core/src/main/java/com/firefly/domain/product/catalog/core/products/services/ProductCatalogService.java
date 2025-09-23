package com.firefly.domain.product.catalog.core.products.services;

import com.firefly.domain.product.catalog.core.products.commands.RegisterProductCommand;
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
     * Publish a sellable version (freeze linked configs).
     *
     * @param productId the product identifier
     * @return Mono containing the saga result
     */
    Mono<SagaResult> publish(UUID productId);

    /**
     * Temporarily suspend product eligibility.
     *
     * @param productId the product identifier
     * @return Mono containing the saga result
     */
    Mono<SagaResult> suspend(UUID productId);

    /**
     * Resume product eligibility.
     *
     * @param productId the product identifier
     * @return Mono containing the saga result
     */
    Mono<SagaResult> resume(UUID productId);

    /**
     * Retire product; existing accounts/loans remain.
     *
     * @param productId the product identifier
     * @return Mono containing the saga result
     */
    Mono<SagaResult> retire(UUID productId);

    /**
     * Link the GL mapping ruleset to the product.
     *
     * @param productId the product identifier
     * @return Mono containing the saga result
     */
    Mono<SagaResult> linkPostingRuleSet(UUID productId);
}
