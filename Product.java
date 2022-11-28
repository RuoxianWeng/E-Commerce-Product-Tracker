/*
The Product class contains the id, product name, and supplier name of a product
 */

package project1;

public class Product implements IDedObject {
    
    private int productID;
    private String productName;
    private String supplierName;
    
    public Product() {
        productID = 0;
        productName = "";
        supplierName = "";
    }
    
    //prints all the variable values
    public void printID() {
        System.out.println("Product ID: " + this.productID);
        System.out.println("Product Name: " + this.productName);
        System.out.println("Supplier Name: " + this.supplierName);
        System.out.println();
    }
    
    //return productID
    public int getID() {
        return this.productID;
    }
    
    //set productID
    public void setID(int productID) {
        this.productID = productID;
    }
    
    //set productName
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    //set supplierName
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
