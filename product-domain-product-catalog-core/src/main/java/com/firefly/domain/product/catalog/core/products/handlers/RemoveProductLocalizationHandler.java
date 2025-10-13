package com.firefly.domain.product.catalog.core.products.handlers;

import com.firefly.common.cqrs.annotations.CommandHandlerComponent;
import com.firefly.common.cqrs.command.CommandHandler;
import com.firefly.common.product.sdk.api.ProductLocalizationApi;
import com.firefly.domain.product.catalog.core.products.commands.RemoveProductLocalizationCommand;
import reactor.core.publisher.Mono;

@CommandHandlerComponent
public class RemoveProductLocalizationHandler extends CommandHandler<RemoveProductLocalizationCommand, Void> {

    private final ProductLocalizationApi productLocalizationApi;

    public RemoveProductLocalizationHandler(ProductLocalizationApi productLocalizationApi) {
        this.productLocalizationApi = productLocalizationApi;
    }

    @Override
    protected Mono<Void> doHandle(RemoveProductLocalizationCommand cmd) {
        return productLocalizationApi.deleteProductLocalization(cmd.productId(), cmd.productLocalizationId()).then();
    }
}