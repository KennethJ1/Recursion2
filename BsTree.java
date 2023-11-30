/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author kmf.joseph
 */
public class BsTree {
    //Data 
   private Node root;
   private int size;
   
   //Constructors 
   public BsTree(){
       root = null; 
       size = 0;
   }
   public void inster(int idNum, String name){ 
       if(size == 0){
           root = new Node(idNum , name);
       }
       size = size + 1;
   }
   public String toString(){
       String result = "BsTree with root ";
       if(root == null){
           result = result + null; 
       }
       return "BsTree with root " root.toString() + " size is  " + size;
   }
   
}
