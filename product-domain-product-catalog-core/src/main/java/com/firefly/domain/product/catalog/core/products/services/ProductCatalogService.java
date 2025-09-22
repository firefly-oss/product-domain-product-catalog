package com.firefly.domain.product.catalog.core.products.services;

import com.firefly.transactional.core.SagaResult;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProductCatalogService {

    /**
     * Define product (purpose, currency, base rules).
     *
     * @return Mono containing the saga result
     */
    Mono<SagaResult> registerProduct();

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
