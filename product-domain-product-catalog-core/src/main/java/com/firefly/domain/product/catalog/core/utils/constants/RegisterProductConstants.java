package com.firefly.domain.product.catalog.core.utils.constants;

public class RegisterProductConstants {

    // ============================== SAGA CONFIGURATION ==============================
    public static final String SAGA_REGISTER_PRODUCT = "RegisterProductSaga";

    // ============================== STEP IDENTIFIERS ==============================
    public static final String STEP_REGISTER_PRODUCT_CATEGORY = "registerProductCategory";


    // ============================== COMPENSATE METHODS ==============================
    public static final String COMPENSATE_REMOVE_PRODUCT_CATEGORY = "removeProductCategory";

    // ============================== EVENT TYPES ==============================
    public static final String EVENT_PRODUCT_CATEGORY_REGISTERED = "productCategory.registered";


}
