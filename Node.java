/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kmf.joseph
 */
public class Node {
    //Data
    private int idNum; 
    private String name;
    private  Node leftChild; 
    private Node rightChild; 
    
    
    //Constructors 
    public Node(int idNum, String name, Node leftChild, Node rightChild){
        this.idNum = idNum;
        this.name = name; 
        this.leftChild = leftChild; 
        this.rightChild = rightChild;
    }
    
    public Node(int idNUm, String name){ 
        this.idNum = 0; 
        this.name = null;
    } 
    
    public Node(){
        this(0, "Unknown  Unknown", null, null);
    }
    
    //Getters 
    public int getIdNum(){
        return idNum;
    }
    public String getName(){ 
        return name; 
    }
    public Node getleftChild(){ 
        return leftChild;
    }
    public Node getrightChild(){
        return rightChild;
    }
    //setters 
    public void setIdNum(int idNum){
        this.idNum = idNum; 
    }
    
    public void setName(String name){ 
        this.name = name;
    }
    public void setLeftChild(Node leftChild){
        this.leftChild = leftChild;
    } 
    public void setrightChild(Node rightChild){
        this.rightChild = rightChild;
    } 
    
    public String toString(){ 
        return "("  + idNum + " " + name + ")";
        
    }
    

}
