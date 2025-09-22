package com.firefly.domain.product.catalog.web.controller;

import com.firefly.domain.product.catalog.core.products.services.ProductCatalogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "CQ queries and registration for product catalog")
public class ProductCatalogController {

    private final ProductCatalogService productCatalogService;

    @Operation(summary = "Register product", description = "Define product (purpose, currency, base rules).")
    @PostMapping("/")
    public Mono<ResponseEntity<Object>> registerProduct() {
        return productCatalogService.registerProduct()
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Publish product", description = "Publish a sellable version (freeze linked configs).")
    @PostMapping("/{productId}/publish")
    public Mono<ResponseEntity<Object>> publishProduct(@PathVariable UUID productId) {
        return productCatalogService.publish(productId)
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Suspend product", description = "Temporarily suspend eligibility.")
    @PostMapping("/{productId}/suspend")
    public Mono<ResponseEntity<Object>> suspendProduct(@PathVariable UUID productId) {
        return productCatalogService.suspend(productId)
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Resume product", description = "Resume product eligibility.")
    @PostMapping("/{productId}/resume")
    public Mono<ResponseEntity<Object>> resumeProduct(@PathVariable UUID productId) {
        return productCatalogService.resume(productId)
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Retire product", description = "Retire product; existing accounts/loans remain.")
    @PostMapping("/{productId}/retire")
    public Mono<ResponseEntity<Object>> retireProduct(@PathVariable UUID productId) {
        return productCatalogService.retire(productId)
                .thenReturn(ResponseEntity.ok().build());
    }

    @Operation(summary = "Link posting rule set", description = "Link the GL mapping ruleset to the product.")
    @PostMapping("/{productId}/posting-rule-set")
    public Mono<ResponseEntity<Object>> linkPostingRuleSet(@PathVariable UUID productId) {
        return productCatalogService.linkPostingRuleSet(productId)
                .thenReturn(ResponseEntity.ok().build());
    }
}
