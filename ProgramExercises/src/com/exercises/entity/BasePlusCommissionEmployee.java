package com.exercises.entity;

public class BasePlusCommissionEmployee {
    private String employeeID;
    private String firstName;
    private String lastName;
    private Double baseSalary;
    private Double grossSales;
    private Double commissionRate;

    private BasePlusCommissionEmployee(String employeeID, String firstName, String lastName, Double baseSalary) {
        this();
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
    }

    private BasePlusCommissionEmployee() {
        baseSalary = 200D;
        grossSales = 1D;
        commissionRate = 0.1D;
    }

    public BasePlusCommissionEmployee createValidInstance(String employeeID, String firstName, String lastName, Double baseSalary){
        if(validateStringNullOrEmpty("Employee ID", employeeID)
                && validateStringNullOrEmpty("First Name", firstName)
                && validateStringNullOrEmpty("Last Name", lastName)
                && validateBaseSalary(baseSalary)){
            return new BasePlusCommissionEmployee(employeeID,firstName,lastName, baseSalary);
        }
        System.out.println("Instance of BasePlusCommissionEmployee was not created due to the errors shown above ");
        return null;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setGrossSales(Double grossSales) {
        if(validateNullOrZero("Gross Sales", grossSales)) {
            this.grossSales = grossSales;
        }
    }

    public Double getGrossSales() {
        return grossSales;
    }

    public void setCommissionRate(Double commissionRate) {
        if(validateNullOrZero("Commission Rate", commissionRate) && validateRangeComissionRate(commissionRate)){
            this.commissionRate = commissionRate;
        }
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public double earnings(){
        return ((commissionRate * grossSales) / 100D) + baseSalary;
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{" +
                "employeeID='" + employeeID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", baseSalary=" + baseSalary +
                ", grossSales=" + grossSales +
                ", commissionRate=" + commissionRate +
                '}';
    }

    private boolean validateStringNullOrEmpty(String propertyName, String value){
        if(value == null || value.trim() == ""){
            System.out.println("The " + propertyName + " entenred must be valid");
            return false;
        }
        return true;
    }

    private boolean validateRangeComissionRate(Double commissionRate) {
        if(commissionRate < 0.1D || commissionRate >= 1D) {
            System.out.println("The Commission Rate must be equal or greater than 0.1% and egual or less than 1.0%");
            return false;
        }
        return true;
    }

    private boolean validateBaseSalary(Double baseSalary){
        if(baseSalary == null || baseSalary <= 200D){
            System.out.println("The Base Salary must be equal or greater than US$ 200.00 dollars");
            return false;
        }
        return true;
    }

    private boolean validateNullOrZero(String propertyName, Double value) {
        if(grossSales == null || grossSales > 0D){
            System.out.println("The " + propertyName + " entenred must be greater than 0");
            return false;
        }
        return true;
    }
}
