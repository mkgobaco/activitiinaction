package org.bpmnwithactiviti.chapter9.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.bpmnwithactiviti.chapter7.data.dao.CustomerDAO;
import org.bpmnwithactiviti.chapter7.data.model.Customer;


@WebService
public class AddressService {
  
  private CustomerDAO customerDAO;
  
  @WebResult(name="address")
  public String findCustomerAddress(@WebParam(name="customerName") String customerName) {
    System.out.println("finding customer by customerName " + customerName);
    Customer customer = customerDAO.getCustomerByNameOrContactPerson(customerName, null);
    System.out.println("returning customer " + customer.getCustomerAddress());
    return customer.getCustomerAddress();
  }
  
  @WebMethod(exclude=true)
  public void setCustomerDAO(CustomerDAO customerDAO) {
    this.customerDAO = customerDAO;
  }

}
