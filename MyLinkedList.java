/*
This class create linked list and include operations to the linked list.
 */

package project1;

public class MyLinkedList<AnyType extends IDedObject> {
    
    private MyNode head;
    
    //inner class
    public class MyNode {
        private AnyType data;
        private MyNode next;
        
        public MyNode(AnyType data) {
            this.data = data;
            next = null;
        }
    }
    
    public MyLinkedList () {
        this.head = null;
    }
    
    //empties the linked list
    public void makeEmpty() {
        if (head == null) { //list is already empty
            return;
        }
        else {  
            while (head != null) {  //stop when head points to null
                head = head.next;
            }
        }
    }
    
    //find specific id in the list and return the product with that id
    //if id is not in in the list, return null
    public AnyType findID(int ID) {
        if (head == null) { //list is empty
            return null;
        }
        else {
            MyNode current = head;
            while (current != null) {   //stop when reach the end of the list
                if ((current.data).getID() == ID) { //if id matches
                    return current.data;
                }
                else {  //continue searching the list
                    current = current.next;
                }
            }
            return null;
        }
    }
    
    //insert at the front of the list and return true
    //return flase if ID already existed
    public boolean insertAtFront(AnyType x) {
        MyNode current = head;
        while (current != null) {   //list is not empty
            if ((current.data).getID() == x.getID()) {  //id matches
                return false;   //id is already in the list
            }
            current = current.next; //continue searching
        }
        
        //insert a new node in the front of the list with given id
        current = head;
        MyNode newNode = new MyNode(x);
        newNode.next = current;
        head = newNode;
        return true;
    }
    
    //delete and return the product at the front of the list
    //return null if the list is empty
    public AnyType deleteFromFront() {
        if (head == null) { //list is empty
            return null;
        }
        else {  //delete the first node and return data
            MyNode current = head;
            head = head.next;
            return current.data;
        }
    }
    
    //find and delete the product with the given id
    //return null if id is not found
    public AnyType delete(int ID) {
        if (head == null) { //list is empty
            return null;
        }
        else {
            MyNode current = head;
            MyNode after, temp;
            if ((current.data).getID() == ID) { //id is in the front of the list
                head = head.next;
                return current.data;
            }
            else {
                while (current.next != null) {
                    if (((current.next).data).getID() == ID) {  //id matches; id is in the list
                        after = (current.next).next;    //after points to the next node
                        temp = current.next;    //temp points to the node with the given id
                        current.next = after;   //current points to after
                        return temp.data;   
                    }
                    else {  //continue searching
                        current = current.next; 
                    }
                }
            }
            return null;    //id not found
        }
    } 
    
    //print all data in the list by the order they appears
    public void printAllRecords() {
        MyNode current = head;
        if (current == null) {  //list is empty
            System.out.println("List is empty");
        }
        else {  
            while (current != null) {   //print until reaching the end of the list
                (current.data).printID();
                current = current.next;
            }
        }
    }
}


