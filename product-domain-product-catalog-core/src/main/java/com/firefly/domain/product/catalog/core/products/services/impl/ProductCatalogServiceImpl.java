package com.firefly.domain.product.catalog.core.products.services.impl;

import com.firefly.domain.product.catalog.core.products.services.ProductCatalogService;
import com.firefly.transactional.core.SagaResult;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    @Override
    public Mono<SagaResult> registerProduct() {
        return Mono.empty();
    }

    @Override
    public Mono<SagaResult> publish(UUID productId) {
        return Mono.empty();
    }

    @Override
    public Mono<SagaResult> suspend(UUID productId) {
        return Mono.empty();
    }

    @Override
    public Mono<SagaResult> resume(UUID productId) {
        return Mono.empty();
    }

    @Override
    public Mono<SagaResult> retire(UUID productId) {
        return Mono.empty();
    }

    @Override
    public Mono<SagaResult> linkPostingRuleSet(UUID productId) {
        return Mono.empty();
    }
}
