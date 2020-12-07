package com.ebm.domain;

public class KVACurrentValue {
    private Integer id;
    private String revenuePerEmployee;
    private String productCostRatio;
    private String employeeSatisfaction;
    private String customerSatisfaction;
    private String customerUsageIndex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRevenuePerEmployee() {
        return revenuePerEmployee;
    }

    public void setRevenuePerEmployee(String revenuePerEmployee) {
        this.revenuePerEmployee = revenuePerEmployee;
    }

    public String getProductCostRatio() {
        return productCostRatio;
    }

    public void setProductCostRatio(String productCostRatio) {
        this.productCostRatio = productCostRatio;
    }

    public String getEmployeeSatisfaction() {
        return employeeSatisfaction;
    }

    public void setEmployeeSatisfaction(String employeeSatisfaction) {
        this.employeeSatisfaction = employeeSatisfaction;
    }

    public String getCustomerSatisfaction() {
        return customerSatisfaction;
    }

    public void setCustomerSatisfaction(String customerSatisfaction) {
        this.customerSatisfaction = customerSatisfaction;
    }

    public String getCustomerUsageIndex() {
        return customerUsageIndex;
    }

    public void setCustomerUsageIndex(String customerUsageIndex) {
        this.customerUsageIndex = customerUsageIndex;
    }
}
