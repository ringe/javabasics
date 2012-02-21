package oblig2.oppg1;
//****************************************************************** 
//Commission.java      Author: Runar
//
//Represents an employee that gets paid by the hour plus commission.
//*******************************************************************
public class Commission extends Hourly {

  double totalSales;
  double commissionRate;
  //----------------------------------------------------------------- 
  //  Sets up this commission employee using the specified information. 
  //-----------------------------------------------------------------
  public Commission(String eName, String eAddress, String ePhone,	String socSecNumber, double rate, double comm) {
    super(eName, eAddress, ePhone, socSecNumber, rate);
    commissionRate = comm;
  }
  //----------------------------------------------------------------- 
  //  Adds the specified amount of sales to this employee's
  //  total sales.
  //-----------------------------------------------------------------
  public void addSales(double sales) {
    totalSales += sales;
  }
  //----------------------------------------------------------------- 
  //  Computes and returns the pay for this commission employee.
  //-----------------------------------------------------------------
  public double pay() {
    double payment = super.pay();
    payment += totalSales * commissionRate;
    totalSales = 0;
    return payment;
  }
  //----------------------------------------------------------------- 
  //  Returns information about this commission employee as a string. 
  //-----------------------------------------------------------------
  public String toString() {
    String result = super.toString();
    result += "\nTotal Sales: " + totalSales; 
    return result;
  }
}