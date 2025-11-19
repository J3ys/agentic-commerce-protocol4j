package org.sendel.acp.feed;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Product feed specification for OpenAI commerce.
 * Represents a single product with all supported fields from the OpenAI commerce feed schema.
 */
public class Product {

    // OpenAI Flags (Control)
    @JsonProperty("enable_search")
    private Boolean enableSearch;

    @JsonProperty("enable_checkout")
    private Boolean enableCheckout;

    // Basic Product Data
    private String id;
    private String gtin;
    private String mpn;
    private String title;
    private String description;
    private String link;

    // Item Information
    private Condition condition;

    @JsonProperty("product_category")
    private String productCategory;

    private String brand;
    private String material;
    private String dimensions;
    private String length;
    private String width;
    private String height;
    private String weight;

    @JsonProperty("age_group")
    private AgeGroup ageGroup;

    // Media
    @JsonProperty("image_link")
    private String imageLink;

    @JsonProperty("additional_image_link")
    private List<String> additionalImageLink;

    @JsonProperty("video_link")
    private String videoLink;

    @JsonProperty("model_3d_link")
    private String model3dLink;

    // Price & Promotions
    private String price;

    @JsonProperty("sale_price")
    private String salePrice;

    @JsonProperty("sale_price_effective_date")
    private String salePriceEffectiveDate;

    @JsonProperty("unit_pricing_measure")
    private String unitPricingMeasure;

    @JsonProperty("base_measure")
    private String baseMeasure;

    @JsonProperty("pricing_trend")
    private String pricingTrend;

    // Availability & Inventory
    private Availability availability;

    @JsonProperty("availability_date")
    private LocalDate availabilityDate;

    @JsonProperty("inventory_quantity")
    private Integer inventoryQuantity;

    @JsonProperty("expiration_date")
    private LocalDate expirationDate;

    @JsonProperty("pickup_method")
    private PickupMethod pickupMethod;

    @JsonProperty("pickup_sla")
    private String pickupSla;

    // Variants
    @JsonProperty("item_group_id")
    private String itemGroupId;

    @JsonProperty("item_group_title")
    private String itemGroupTitle;

    private String color;
    private String size;

    @JsonProperty("size_system")
    private String sizeSystem;

    private Gender gender;

    @JsonProperty("offer_id")
    private String offerId;

    @JsonProperty("custom_variant1_category")
    private String customVariant1Category;

    @JsonProperty("custom_variant1_option")
    private String customVariant1Option;

    @JsonProperty("custom_variant2_category")
    private String customVariant2Category;

    @JsonProperty("custom_variant2_option")
    private String customVariant2Option;

    @JsonProperty("custom_variant3_category")
    private String customVariant3Category;

    @JsonProperty("custom_variant3_option")
    private String customVariant3Option;

    // Fulfillment
    private String shipping;

    @JsonProperty("delivery_estimate")
    private LocalDate deliveryEstimate;

    // Merchant Info
    @JsonProperty("seller_name")
    private String sellerName;

    @JsonProperty("seller_url")
    private String sellerUrl;

    @JsonProperty("seller_privacy_policy")
    private String sellerPrivacyPolicy;

    @JsonProperty("seller_tos")
    private String sellerTos;

    // Returns
    @JsonProperty("return_policy")
    private String returnPolicy;

    @JsonProperty("return_window")
    private Integer returnWindow;

    // Performance Signals
    @JsonProperty("popularity_score")
    private BigDecimal popularityScore;

    @JsonProperty("return_rate")
    private BigDecimal returnRate;

    // Compliance
    private String warning;

    @JsonProperty("warning_url")
    private String warningUrl;

    @JsonProperty("age_restriction")
    private Integer ageRestriction;

    // Reviews & Q&A
    @JsonProperty("product_review_count")
    private Integer productReviewCount;

    @JsonProperty("product_review_rating")
    private BigDecimal productReviewRating;

    @JsonProperty("store_review_count")
    private Integer storeReviewCount;

    @JsonProperty("store_review_rating")
    private BigDecimal storeReviewRating;

    @JsonProperty("q_and_a")
    private String qAndA;

    @JsonProperty("raw_review_data")
    private String rawReviewData;

    // Related Products
    @JsonProperty("related_product_id")
    private List<String> relatedProductId;

    @JsonProperty("relationship_type")
    private RelationshipType relationshipType;

    // Geo Tagging
    @JsonProperty("geo_price")
    private String geoPrice;

    @JsonProperty("geo_availability")
    private String geoAvailability;

    // Constructors
    public Product() {
    }

    // OpenAI Flags (Control)
    public Boolean getEnableSearch() {
        return enableSearch;
    }

    public void setEnableSearch(Boolean enableSearch) {
        this.enableSearch = enableSearch;
    }

    public Boolean getEnableCheckout() {
        return enableCheckout;
    }

    public void setEnableCheckout(Boolean enableCheckout) {
        this.enableCheckout = enableCheckout;
    }

    // Basic Product Data
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getMpn() {
        return mpn;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    // Item Information
    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    // Media
    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public List<String> getAdditionalImageLink() {
        return additionalImageLink;
    }

    public void setAdditionalImageLink(List<String> additionalImageLink) {
        this.additionalImageLink = additionalImageLink;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getModel3dLink() {
        return model3dLink;
    }

    public void setModel3dLink(String model3dLink) {
        this.model3dLink = model3dLink;
    }

    // Price & Promotions
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getSalePriceEffectiveDate() {
        return salePriceEffectiveDate;
    }

    public void setSalePriceEffectiveDate(String salePriceEffectiveDate) {
        this.salePriceEffectiveDate = salePriceEffectiveDate;
    }

    public String getUnitPricingMeasure() {
        return unitPricingMeasure;
    }

    public void setUnitPricingMeasure(String unitPricingMeasure) {
        this.unitPricingMeasure = unitPricingMeasure;
    }

    public String getBaseMeasure() {
        return baseMeasure;
    }

    public void setBaseMeasure(String baseMeasure) {
        this.baseMeasure = baseMeasure;
    }

    public String getPricingTrend() {
        return pricingTrend;
    }

    public void setPricingTrend(String pricingTrend) {
        this.pricingTrend = pricingTrend;
    }

    // Availability & Inventory
    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public LocalDate getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(LocalDate availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public PickupMethod getPickupMethod() {
        return pickupMethod;
    }

    public void setPickupMethod(PickupMethod pickupMethod) {
        this.pickupMethod = pickupMethod;
    }

    public String getPickupSla() {
        return pickupSla;
    }

    public void setPickupSla(String pickupSla) {
        this.pickupSla = pickupSla;
    }

    // Variants
    public String getItemGroupId() {
        return itemGroupId;
    }

    public void setItemGroupId(String itemGroupId) {
        this.itemGroupId = itemGroupId;
    }

    public String getItemGroupTitle() {
        return itemGroupTitle;
    }

    public void setItemGroupTitle(String itemGroupTitle) {
        this.itemGroupTitle = itemGroupTitle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeSystem() {
        return sizeSystem;
    }

    public void setSizeSystem(String sizeSystem) {
        this.sizeSystem = sizeSystem;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getCustomVariant1Category() {
        return customVariant1Category;
    }

    public void setCustomVariant1Category(String customVariant1Category) {
        this.customVariant1Category = customVariant1Category;
    }

    public String getCustomVariant1Option() {
        return customVariant1Option;
    }

    public void setCustomVariant1Option(String customVariant1Option) {
        this.customVariant1Option = customVariant1Option;
    }

    public String getCustomVariant2Category() {
        return customVariant2Category;
    }

    public void setCustomVariant2Category(String customVariant2Category) {
        this.customVariant2Category = customVariant2Category;
    }

    public String getCustomVariant2Option() {
        return customVariant2Option;
    }

    public void setCustomVariant2Option(String customVariant2Option) {
        this.customVariant2Option = customVariant2Option;
    }

    public String getCustomVariant3Category() {
        return customVariant3Category;
    }

    public void setCustomVariant3Category(String customVariant3Category) {
        this.customVariant3Category = customVariant3Category;
    }

    public String getCustomVariant3Option() {
        return customVariant3Option;
    }

    public void setCustomVariant3Option(String customVariant3Option) {
        this.customVariant3Option = customVariant3Option;
    }

    // Fulfillment
    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public LocalDate getDeliveryEstimate() {
        return deliveryEstimate;
    }

    public void setDeliveryEstimate(LocalDate deliveryEstimate) {
        this.deliveryEstimate = deliveryEstimate;
    }

    // Merchant Info
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerUrl() {
        return sellerUrl;
    }

    public void setSellerUrl(String sellerUrl) {
        this.sellerUrl = sellerUrl;
    }

    public String getSellerPrivacyPolicy() {
        return sellerPrivacyPolicy;
    }

    public void setSellerPrivacyPolicy(String sellerPrivacyPolicy) {
        this.sellerPrivacyPolicy = sellerPrivacyPolicy;
    }

    public String getSellerTos() {
        return sellerTos;
    }

    public void setSellerTos(String sellerTos) {
        this.sellerTos = sellerTos;
    }

    // Returns
    public String getReturnPolicy() {
        return returnPolicy;
    }

    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    public Integer getReturnWindow() {
        return returnWindow;
    }

    public void setReturnWindow(Integer returnWindow) {
        this.returnWindow = returnWindow;
    }

    // Performance Signals
    public BigDecimal getPopularityScore() {
        return popularityScore;
    }

    public void setPopularityScore(BigDecimal popularityScore) {
        this.popularityScore = popularityScore;
    }

    public BigDecimal getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(BigDecimal returnRate) {
        this.returnRate = returnRate;
    }

    // Compliance
    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getWarningUrl() {
        return warningUrl;
    }

    public void setWarningUrl(String warningUrl) {
        this.warningUrl = warningUrl;
    }

    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    // Reviews & Q&A
    public Integer getProductReviewCount() {
        return productReviewCount;
    }

    public void setProductReviewCount(Integer productReviewCount) {
        this.productReviewCount = productReviewCount;
    }

    public BigDecimal getProductReviewRating() {
        return productReviewRating;
    }

    public void setProductReviewRating(BigDecimal productReviewRating) {
        this.productReviewRating = productReviewRating;
    }

    public Integer getStoreReviewCount() {
        return storeReviewCount;
    }

    public void setStoreReviewCount(Integer storeReviewCount) {
        this.storeReviewCount = storeReviewCount;
    }

    public BigDecimal getStoreReviewRating() {
        return storeReviewRating;
    }

    public void setStoreReviewRating(BigDecimal storeReviewRating) {
        this.storeReviewRating = storeReviewRating;
    }

    public String getqAndA() {
        return qAndA;
    }

    public void setqAndA(String qAndA) {
        this.qAndA = qAndA;
    }

    public String getRawReviewData() {
        return rawReviewData;
    }

    public void setRawReviewData(String rawReviewData) {
        this.rawReviewData = rawReviewData;
    }

    // Related Products
    public List<String> getRelatedProductId() {
        return relatedProductId;
    }

    public void setRelatedProductId(List<String> relatedProductId) {
        this.relatedProductId = relatedProductId;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

    // Geo Tagging
    public String getGeoPrice() {
        return geoPrice;
    }

    public void setGeoPrice(String geoPrice) {
        this.geoPrice = geoPrice;
    }

    public String getGeoAvailability() {
        return geoAvailability;
    }

    public void setGeoAvailability(String geoAvailability) {
        this.geoAvailability = geoAvailability;
    }
}
