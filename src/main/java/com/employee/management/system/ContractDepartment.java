package com.employee.management.system;


/**
 * The ContractDepartment interface represents the contract details of an employee.
 * It provides methods for accessing and updating the entry date, contract duration, and notice period.
 */

public interface ContractDepartment {
    
    String getEntryDate();
    void setEntryDate(String entryDate);
    
    int getContractDuration();
    void setContractDuration(int contractDuration);
    
    int getNoticePeriod();
    void setNoticePeriod(int noticePeriod);
}
