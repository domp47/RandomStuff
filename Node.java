//package Rental;


class Node {
    
    
    Car   item;   // the Car
    Node  prev,next;  // next node
    int x;
    
    Node ( Car c, Node n ) {
        
        item = c;
        next = n;
        
    };  // constructor
    Node(Node p,int x,Node n){
    	this.x = x;
    	next = n;
    	prev = p;
    }
    
    
}  //Node