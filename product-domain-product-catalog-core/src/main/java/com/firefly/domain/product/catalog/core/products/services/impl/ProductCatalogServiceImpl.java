package com.firefly.domain.product.catalog.core.products.services.impl;

import com.firefly.domain.product.catalog.core.products.commands.RegisterProductCommand;
import com.firefly.domain.product.catalog.core.products.services.ProductCatalogService;
import com.firefly.domain.product.catalog.core.products.workflows.RegisterProductSaga;
import com.firefly.transactional.core.SagaResult;
import com.firefly.transactional.engine.ExpandEach;
import com.firefly.transactional.engine.SagaEngine;
import com.firefly.transactional.engine.StepInputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    private final SagaEngine engine;

    @Autowired
    public ProductCatalogServiceImpl(SagaEngine engine){
        this.engine=engine;
    }

    @Override
    public Mono<SagaResult> registerProduct(RegisterProductCommand command) {
        StepInputs inputs = StepInputs.builder()
                .forStep(RegisterProductSaga::registerProductCategory, command.getProductCategory())
                .forStep(RegisterProductSaga::registerProductSubtype, command.getProductSubtype())
                .forStep(RegisterProductSaga::registerFeeStructure, command.getFeeStructure())
                .forStep(RegisterProductSaga::registerProductBundle, command.getProductBundle())
                .forStep(RegisterProductSaga::registerFeeComponent, command.getFeeComponent())
                .forStep(RegisterProductSaga::registerFeeApplicationRule, command.getFeeApplicationRule())
                .forStep(RegisterProductSaga::registerProduct, command.getProduct())
                .forStep(RegisterProductSaga::registerProductFeeStructure, ExpandEach.of(command.getProductFeeStructures()))
                .forStep(RegisterProductSaga::registerProductBundleItems, ExpandEach.of(command.getProductBundleItems()))
                .forStep(RegisterProductSaga::registerProductPricing, command.getProductPricing())
                .forStep(RegisterProductSaga::registerProductRelationship, ExpandEach.of(command.getProductRelationships()))
                .forStep(RegisterProductSaga::registerProductDocumentation, ExpandEach.of(command.getProductDocumentation()))


                .build();

        return engine.execute(RegisterProductSaga.class, inputs);
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
