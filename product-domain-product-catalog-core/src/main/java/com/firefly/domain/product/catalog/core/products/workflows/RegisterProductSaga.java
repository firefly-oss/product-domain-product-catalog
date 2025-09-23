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

import static com.firefly.domain.product.catalog.core.utils.constants.GlobalConstants.CTX_FEE_STRUCTURE_ID;
import static com.firefly.domain.product.catalog.core.utils.constants.GlobalConstants.CTX_PRODUCT_CATEGORY_ID;
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

    @SagaStep(id = STEP_REGISTER_FEE_STRUCTURE, compensate = COMPENSATE_REMOVE_FEE_STRUCTURE)
    @StepEvent(type = EVENT_FEE_STRUCTURE_REGISTERED)
    public Mono<UUID> registerFeeStructure(RegisterFeeStructureCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd)
                .doOnNext(productCategoryId -> ctx.variables().put(CTX_FEE_STRUCTURE_ID, productCategoryId));
    }

    public Mono<Void> removeFeeStructure(UUID feeStructureId) {
        return commandBus.send(new RemoveFeeStructureCommand(feeStructureId));
    }

}
