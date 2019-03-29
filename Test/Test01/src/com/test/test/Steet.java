package com.test.test;

/**
 * 商品
 * 品种、材质、规格、钢厂、仓库、件重、件数、价格
 */
public class Steet {

    /**
     * 品种
     */
    private String varieties;

    /**
     * 材质
     */
    private String material;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 钢厂
     */
    private String steelworks;

    /**
     * 仓库
     */
    private String warehouse;

    /**
     * 件重
     */
    private double weight;

    /**
     * 件数
     */
    private Integer number;

    /**
     * 价格
     */
    private double price;

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getSteelworks() {
        return steelworks;
    }

    public void setSteelworks(String steelworks) {
        this.steelworks = steelworks;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
