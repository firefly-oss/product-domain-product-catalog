package com.firefly.domain.product.catalog.core.utils.constants;

public class RegisterProductConstants {

    // ============================== SAGA CONFIGURATION ==============================
    public static final String SAGA_REGISTER_PRODUCT = "RegisterProductSaga";

    // ============================== STEP IDENTIFIERS ==============================
    public static final String STEP_REGISTER_PRODUCT_CATEGORY = "registerProductCategory";
    public static final String STEP_REGISTER_FEE_STRUCTURE = "registerFeeStructure";
    public static final String STEP_REGISTER_PRODUCT_BUNDLE = "registerProductBundle";
    public static final String STEP_REGISTER_FEE_COMPONENT = "registerFeeComponent";


    // ============================== COMPENSATE METHODS ==============================
    public static final String COMPENSATE_REMOVE_PRODUCT_CATEGORY = "removeProductCategory";
    public static final String COMPENSATE_REMOVE_FEE_STRUCTURE = "removeFeeStructure";
    public static final String COMPENSATE_REMOVE_PRODUCT_BUNDLE = "removeProductBundle";
    public static final String COMPENSATE_REMOVE_FEE_COMPONENT = "removeFeeComponent";

    // ============================== EVENT TYPES ==============================
    public static final String EVENT_PRODUCT_CATEGORY_REGISTERED = "productCategory.registered";
    public static final String EVENT_FEE_STRUCTURE_REGISTERED = "feeStructure.registered";
    public static final String EVENT_PRODUCT_BUNDLE_REGISTERED = "productBundle.registered";
    public static final String EVENT_FEE_COMPONENT_REGISTERED = "feeComponent.registered";


}
