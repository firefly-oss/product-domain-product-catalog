package com.firefly.domain.product.catalog.core.utils.constants;

public class RegisterProductConstants {

    // ============================== SAGA CONFIGURATION ==============================
    public static final String SAGA_REGISTER_PRODUCT = "RegisterProductSaga";

    // ============================== STEP IDENTIFIERS ==============================
    public static final String STEP_REGISTER_PRODUCT_CATEGORY = "registerProductCategory";
    public static final String STEP_REGISTER_PRODUCT_SUBTYPE = "registerProductSubtype";
    public static final String STEP_REGISTER_FEE_STRUCTURE = "registerFeeStructure";
    public static final String STEP_REGISTER_PRODUCT_BUNDLE = "registerProductBundle";
    public static final String STEP_REGISTER_FEE_COMPONENT = "registerFeeComponent";
    public static final String STEP_REGISTER_FEE_APPLICATION_RULE = "registerFeeApplicationRule";
    public static final String STEP_REGISTER_PRODUCT = "registerProduct";
    public static final String STEP_REGISTER_PRODUCT_FEE_STRUCTURE = "registerProductFeeStructure";
    public static final String STEP_REGISTER_PRODUCT_BUNDLE_ITEMS = "registerProductBundleItems";


    // ============================== COMPENSATE METHODS ==============================
    public static final String COMPENSATE_REMOVE_PRODUCT_CATEGORY = "removeProductCategory";
    public static final String COMPENSATE_REMOVE_PRODUCT_SUBTYPE = "removeProductSubtype";
    public static final String COMPENSATE_REMOVE_FEE_STRUCTURE = "removeFeeStructure";
    public static final String COMPENSATE_REMOVE_PRODUCT_BUNDLE = "removeProductBundle";
    public static final String COMPENSATE_REMOVE_FEE_COMPONENT = "removeFeeComponent";
    public static final String COMPENSATE_REMOVE_FEE_APPLICATION_RULE = "removeFeeApplicationRule";
    public static final String COMPENSATE_REMOVE_PRODUCT = "removeProduct";
    public static final String COMPENSATE_REMOVE_PRODUCT_FEE_STRUCTURE = "removeProductFeeStructure";
    public static final String COMPENSATE_REMOVE_PRODUCT_BUNDLE_ITEMS = "removeProductBundleItems";

    // ============================== EVENT TYPES ==============================
    public static final String EVENT_PRODUCT_CATEGORY_REGISTERED = "productCategory.registered";
    public static final String EVENT_PRODUCT_SUBTYPE_REGISTERED = "productSubtype.registered";
    public static final String EVENT_FEE_STRUCTURE_REGISTERED = "feeStructure.registered";
    public static final String EVENT_PRODUCT_BUNDLE_REGISTERED = "productBundle.registered";
    public static final String EVENT_FEE_COMPONENT_REGISTERED = "feeComponent.registered";
    public static final String EVENT_FEE_APPLICATION_RULE_REGISTERED = "feeApplicationRule.registered";
    public static final String EVENT_PRODUCT_REGISTERED = "product.registered";
    public static final String EVENT_PRODUCT_FEE_STRUCTURE_REGISTERED = "productFeeStructure.registered";
    public static final String EVENT_PRODUCT_BUNDLE_ITEMS_REGISTERED = "productBundleItems.registered";


}
