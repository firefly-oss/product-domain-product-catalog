/*
 * Copyright 2025 Firefly Software Solutions Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.firefly.domain.product.catalog.core.products.commands;

import com.firefly.common.domain.cqrs.command.Command;
import com.firefly.common.product.sdk.model.ProductDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegisterProductCommand extends ProductDTO implements Command<UUID> {

    private List<RegisterProductFeatureCommand> features;
    private List<RegisterProductPricingCommand> pricing;
    private List<RegisterProductDocumentationCommand> documentation;
    private List<RegisterProductLifecycleCommand> lifecycle;
    private List<RegisterProductLimitCommand> limits;
    private List<RegisterProductLocalizationCommand> localizations;
    private List<RegisterProductVersionCommand> versions;
    private List<RegisterProductFeeStructureCommand> feeStructures;
    private List<RegisterProductRelationshipCommand> relationships;
    private List<RegisterProductDocumentationRequirementCommand> documentationRequirements;
    private RegisterProductCategoryCommand category;
    private RegisterProductSubtypeCommand subtype;
    private List<RegisterProductBundleCommand> bundles;
    private RegisterFeeApplicationRuleCommand feeApplicationRule;
    private RegisterFeeComponentCommand feeComponent;
    private RegisterProductBundleItemCommand bundleItem;
    private RegisterProductPricingLocalizationCommand pricingLocalization;
}