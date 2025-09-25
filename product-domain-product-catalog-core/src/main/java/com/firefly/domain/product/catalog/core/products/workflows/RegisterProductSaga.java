package com.firefly.domain.product.catalog.core.products.workflows;

import com.firefly.common.domain.cqrs.command.CommandBus;
import com.firefly.domain.product.catalog.core.products.commands.*;
import com.firefly.transactional.annotations.Saga;
import com.firefly.transactional.annotations.SagaStep;
import com.firefly.transactional.annotations.StepEvent;
import com.firefly.transactional.core.SagaContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.firefly.domain.product.catalog.core.utils.constants.GlobalConstants.*;
import static com.firefly.domain.product.catalog.core.utils.constants.RegisterProductConstants.*;


@Saga(name = SAGA_REGISTER_PRODUCT)
@Service
public class RegisterProductSaga {

    private final CommandBus commandBus;

    @Autowired
    public RegisterProductSaga(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @SagaStep(id = STEP_REGISTER_PRODUCT_CATEGORY, compensate = COMPENSATE_REMOVE_PRODUCT_CATEGORY)
    @StepEvent(type = EVENT_PRODUCT_CATEGORY_REGISTERED)
    public Mono<UUID> registerProductCategory(RegisterProductCategoryCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd)
                .doOnNext(productCategoryId -> ctx.variables().put(CTX_PRODUCT_CATEGORY_ID, productCategoryId));
    }

    public Mono<Void> removeProductCategory(UUID productCategoryId) {
        return commandBus.send(new RemoveProductCategoryCommand(productCategoryId));
    }

    @SagaStep(id = STEP_REGISTER_PRODUCT_SUBTYPE, compensate = COMPENSATE_REMOVE_PRODUCT_SUBTYPE, dependsOn = STEP_REGISTER_PRODUCT_CATEGORY)
    @StepEvent(type = EVENT_PRODUCT_SUBTYPE_REGISTERED)
    public Mono<UUID> registerProductSubtype(RegisterProductSubtypeCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd.withProductCategoryId(ctx.getVariableAs(CTX_PRODUCT_CATEGORY_ID, UUID.class)))
                .doOnNext(productSubtypeId -> ctx.variables().put(CTX_PRODUCT_SUBTYPE_ID, productSubtypeId));
    }

    public Mono<Void> removeProductSubtype(UUID productSubtypeId, SagaContext ctx) {
        return commandBus.send(new RemoveProductSubtypeCommand(ctx.getVariableAs(CTX_PRODUCT_CATEGORY_ID, UUID.class), productSubtypeId));
    }

    @SagaStep(id = STEP_REGISTER_FEE_STRUCTURE, compensate = COMPENSATE_REMOVE_FEE_STRUCTURE)
    @StepEvent(type = EVENT_FEE_STRUCTURE_REGISTERED)
    public Mono<UUID> registerFeeStructure(RegisterFeeStructureCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd)
                .doOnNext(freeStructureId -> ctx.variables().put(CTX_FEE_STRUCTURE_ID, freeStructureId));
    }

    public Mono<Void> removeFeeStructure(UUID feeStructureId) {
        return commandBus.send(new RemoveFeeStructureCommand(feeStructureId));
    }

    @SagaStep(id = STEP_REGISTER_PRODUCT_BUNDLE, compensate = COMPENSATE_REMOVE_PRODUCT_BUNDLE)
    @StepEvent(type = EVENT_PRODUCT_BUNDLE_REGISTERED)
    public Mono<UUID> registerProductBundle(RegisterProductBundleCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd)
                .doOnNext(productBundleId -> ctx.variables().put(CTX_PRODUCT_BUNDLE_ID, productBundleId));
    }

    public Mono<Void> removeProductBundle(UUID productBundleId) {
        return commandBus.send(new RemoveProductBundleCommand(productBundleId));
    }

    @SagaStep(id = STEP_REGISTER_FEE_COMPONENT, compensate = COMPENSATE_REMOVE_FEE_COMPONENT, dependsOn = STEP_REGISTER_FEE_STRUCTURE)
    @StepEvent(type = EVENT_FEE_COMPONENT_REGISTERED)
    public Mono<UUID> registerFeeComponent(RegisterFeeComponentCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd.withFeeStructureId(ctx.getVariableAs(CTX_FEE_STRUCTURE_ID, UUID.class)))
                .doOnNext(feeComponentId -> ctx.variables().put(CTX_FEE_COMPONENT_ID, feeComponentId));
    }

    public Mono<Void> removeFeeComponent(UUID feeComponentId, SagaContext ctx) {
        return commandBus.send(new RemoveFeeComponentCommand(feeComponentId, ctx.getVariableAs(CTX_FEE_STRUCTURE_ID, UUID.class)));
    }

    @SagaStep(id = STEP_REGISTER_FEE_APPLICATION_RULE, compensate = COMPENSATE_REMOVE_FEE_APPLICATION_RULE, dependsOn = {STEP_REGISTER_FEE_COMPONENT, STEP_REGISTER_FEE_STRUCTURE})
    @StepEvent(type = EVENT_FEE_APPLICATION_RULE_REGISTERED)
    public Mono<UUID> registerFeeApplicationRule(RegisterFeeApplicationRuleCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd
                .withFeeComponentId(ctx.getVariableAs(CTX_FEE_COMPONENT_ID, UUID.class)));
    }

    public Mono<Void> removeFeeApplicationRule(UUID feeApplicationRuleId, SagaContext ctx) {
        return commandBus.send(new RemoveFeeApplicationRuleCommand(
                feeApplicationRuleId,
                ctx.getVariableAs(CTX_FEE_STRUCTURE_ID, UUID.class),
                ctx.getVariableAs(CTX_FEE_COMPONENT_ID, UUID.class)));
    }

    @SagaStep(id = STEP_REGISTER_PRODUCT, compensate = COMPENSATE_REMOVE_PRODUCT, dependsOn = {STEP_REGISTER_PRODUCT_SUBTYPE})
    @StepEvent(type = EVENT_PRODUCT_REGISTERED)
    public Mono<UUID> registerProduct(RegisterProductInfoCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd.withProductSubtypeId(ctx.getVariableAs(CTX_PRODUCT_SUBTYPE_ID, UUID.class)))
                .doOnNext(productId -> ctx.variables().put(CTX_PRODUCT_ID, productId));
    }

    public Mono<Void> removeProduct(UUID productId) {
        return commandBus.send(new RemoveProductCommand(productId));
    }

    @SagaStep(id = STEP_REGISTER_PRODUCT_FEE_STRUCTURE, compensate = COMPENSATE_REMOVE_PRODUCT_FEE_STRUCTURE, dependsOn = {STEP_REGISTER_PRODUCT, STEP_REGISTER_FEE_STRUCTURE})
    @StepEvent(type = EVENT_PRODUCT_FEE_STRUCTURE_REGISTERED)
    public Mono<UUID> registerProductFeeStructure(RegisterProductFeeStructureCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd
                        .withProductId(ctx.getVariableAs(CTX_PRODUCT_ID, UUID.class))
                        .withFeeStructureId(ctx.getVariableAs(CTX_FEE_STRUCTURE_ID, UUID.class)))
                .doOnNext(productFeeStructureId -> ctx.variables().put(CTX_PRODUCT_FEE_STRUCTURE_ID, productFeeStructureId));
    }

    public Mono<Void> removeProductFeeStructure(UUID productFeeStructureId, SagaContext ctx) {
        return commandBus.send(new RemoveProductFeeStructureCommand(ctx.getVariableAs(CTX_PRODUCT_ID, UUID.class), productFeeStructureId));
    }

}
