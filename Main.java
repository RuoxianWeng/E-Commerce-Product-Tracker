/*
This program keep track of all products provided by the user using a linked list. 
It prompt the user to choice list of operations that can be done on the list.
 */

package project1;

import java.util.*;

public class Main {
    public static void main (String[] args) {
        
        Scanner input = new Scanner(System.in);
        int choice = 0, id = 0;
        MyLinkedList<IDedObject> linkedList = new MyLinkedList<>(); //create an emtpy linked list
        
        do {    
            try {   //check for input mismatch exceptions 
                System.out.println("\nOperations on List\n" +
                                 "1. Make Empty\n" +
                                 "2. Find ID\n" +
                                 "3. Insert At Front\n" +
                                 "4. Delete From Front\n" +
                                 "5. Delete ID\n" +
                                 "6. Print All Records\n" +
                                 "7. Done\n");

                System.out.println("Your choice: ");
                choice = input.nextInt();   //get choice from user
                IDedObject product = new Product(); //create a product object

                switch (choice) {   //perform operation with given choice
                    case 1: //make the linked list empty
                        linkedList.makeEmpty();
                        System.out.println("The list is emptied");
                        break;

                    case 2: //print all details of the desired product ID if in the list
                        System.out.println("ID No: "); 
                        id = input.nextInt();   //get id from user
                        product = linkedList.findID(id);    //return the product or null

                        if (product == null) {  //product is not found
                            System.out.println("ID not found.");
                        }
                        else {  //print details of the product 
                            product.printID();
                        }

                        break;

                    case 3: //get product details from the user and add it to the front of the list
                        //get info from the user
                        System.out.println("Enter Product ID: ");
                        ((Product)product).setID(input.nextInt());  //downcasting
                        System.out.println("Enter Product Name: ");
                        input.nextLine();   //use to solve issue of nextInt() before nextLine()
                        ((Product)product).setProductName(input.nextLine());
                        System.out.println("Enter Supplier Name: ");
                        ((Product)product).setSupplierName(input.nextLine());

                        boolean insertion = linkedList.insertAtFront(product);  //insert the product to the list
                        
                        if (insertion == true) {    //insertion is successful
                            System.out.println("Product added");
                        }
                        else {  //product id already existed in the list
                            System.out.println("Product ID already existed.");
                        }

                        break;

                    case 4: //print the first item on the list and delete it
                        product = linkedList.deleteFromFront(); //delete the first product in the list
                        
                        if (product == null) {  //list is empty
                            System.out.println("The list is empty.");
                        }
                        else {  //deletion is successful
                            product.printID();  //print details of the product
                            System.out.println("First item deleted.");
                        }
                        break;

                    case 5: //print particular IDed item and delete it
                        System.out.println("Enter Product ID: ");
                        id = input.nextInt();   //get id from user
                        product = linkedList.delete(id);    //delete the product
                        
                        if (product == null) {  //product not found in the list
                            System.out.println("Product not in the list.");
                        }
                        else {  //deletion is successful
                            product.printID();  //print details of the product deleted
                            System.out.println("Product with ID " + id + " deleted.");
                        }
                        break;

                    case 6: //print all the records in the list
                        linkedList.printAllRecords();
                        break;

                    case 7: //do nothing
                        break;

                    default: //input outside of 1-7
                        System.out.println("Please enter a number between 1-7. Try again.");
                        break;           
                } 
            }
            catch (InputMismatchException ex) { 
                System.out.println("Invalid input. Try again.");
                input.next();  //get input again from the user
            }
        } while (choice != 7);  //stop when choice = 7
        
        System.out.println("Done.");
    }
}
