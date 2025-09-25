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


@Saga(name = SAGA_REGISTER_PRODUCT_FEE_STRUCTURE)
@Service
public class RegisterProductFeeStructureSaga {

    private final CommandBus commandBus;

    @Autowired
    public RegisterProductFeeStructureSaga(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @SagaStep(id = STEP_REGISTER_PRODUCT_FEE_STRUCTURE)
    @StepEvent(type = EVENT_PRODUCT_FEE_STRUCTURE_REGISTERED)
    public Mono<UUID> registerProductFeeStructure(RegisterProductFeeStructureCommand cmd, SagaContext ctx) {
        return commandBus.send(cmd);
    }

}
