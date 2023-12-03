/*
 *
 */

/**
 *
 * @author kmf.joseph
 * AUCSI 235
 * 1748057  
 */
public class BsTree {

    //Data 
    private Node root;
    private int size;

    //Constructors 
    public BsTree() {
        root = null;
        size = 0;
    }
    //wrapper to track location in tree

    public void insert(int idNum, String name) {
        if (size == 0) {
            root = new Node(idNum, name);
        } else {
            insert(idNum, name, root);
        }
        size = size + 1;
    }

    private void insert(int idNum, String name, Node currentLoc) {
        //Our tree already has something in it. 
        //Base case 
        if (currentLoc == null) {//found the insertion spot

        }

        //We need to find where the insertion spot is. 
        if (idNum < currentLoc.getIdNum()) {
            if (currentLoc.getleftChild() != null) {
                insert(idNum, name, currentLoc.getleftChild());
            } else { // actually insert item 
                currentLoc.setLeftChild(new Node(idNum, name));
            }
        } else if (idNum > currentLoc.getIdNum()) {
            if (currentLoc.getrightChild() != null) {
                insert(idNum, name, currentLoc.getrightChild());
            } else {//actually insert item 
                currentLoc.setrightChild(new Node(idNum, name));

            }
        } else {//equal case
            System.out.println("Should never reach here.");
            size = size - 1;
        }

    }

    public String preOrderTraversal() {
        if (size == 0) {
            return "Empty tree";
        }
        return preOrderTraversal(root);

    }

    public String preOrderTraversal(Node currentLoc) {
        //Base case 
        if (currentLoc == null) {
            return "";
        }

        //Work 
        return currentLoc.toString()
                + preOrderTraversal(currentLoc.getleftChild())
                + //go left
                preOrderTraversal(currentLoc.getrightChild());// go right

    }
        public String inOrdertraversal() {
        if (size == 0) {
            return "Empty tree";
        }
        return inOrdertraversal(root);

    }

    public String inOrdertraversal(Node currentLoc) {
        //Base case 
        if (currentLoc == null) {
            return "";
        }

        //Work 
        return 
                 inOrdertraversal(currentLoc.getleftChild())//left
                + currentLoc.toString() + //self
                inOrdertraversal(currentLoc.getrightChild());// go right

    }
    
            public String postOrdertraversal() {
        if (size == 0) {
            return "Empty tree";
        }
        return postOrdertraversal(root);

    }
      

    public String postOrdertraversal(Node currentLoc) {
        //Base case 
        if (currentLoc == null) {
            return "";
        }

        //Work 
        return 
                 postOrdertraversal(currentLoc.getleftChild())//left
                +  
                postOrdertraversal(currentLoc.getrightChild())// go right
                + currentLoc.toString();

    }
    
    public String findNameOf(int idNum){ 
        if(size == 0){
            return "NOT FOUND";
        }
        return findNameOf(idNum, root);
        
    }
    //worker
    private String findNameOf(int idNum, Node currentLoc){
        //Two base cases 
        if(currentLoc == null){
            return "NOT FOUND";
        }
        if(currentLoc.getIdNum() == idNum){
            return currentLoc.getName();
        }
        if(currentLoc.getIdNum() > idNum){
            return findNameOf(idNum, currentLoc.getleftChild());
        }
        else{
            return findNameOf(idNum, currentLoc.getrightChild());
        }
        
    }
    public int findIdNumOf(String name){
        if(size == 0){
            return -1;
        }
        return findIdNumOf(name, root);
    }
    private int findIdNumOf(String name, Node currentLoc){
        //Preorder traversal to find name
        // twobase case/ found or not found 
        if(currentLoc == null){ 
            return -1;
        }
        if(currentLoc.getName().equals(name)){
            return currentLoc.getIdNum();
        }
        
        //Work
        int leftValue; 
        leftValue = findIdNumOf(name , currentLoc.getleftChild());
            if(leftValue != -1){
                return leftValue; 
        }
            //if name was't ot left, then check right.
            return findIdNumOf(name, currentLoc.getrightChild());
    }
    
    //returns the number of nodes strictly greater than the idNum passed in, 
  //returns 0 if no idNum greater than such is found. 
public int numGreaterThan(int idNum){
    //base case
    if(size == 0){
        return 0;
    }
    return numGreaterThan(idNum, root);
}

//worker
private int numGreaterThan(int idNum, Node currentLoc){
    //base case
    if(currentLoc == null){ 
        return 0;
    }
    int numOfNodes = 0;
    //Checks if the subtrees node is greater than idNum, if true, it is 
    //likely the child nodes are also greater than the idNum passed in 
    if(currentLoc.getIdNum() > idNum ){
        numOfNodes++;
        numOfNodes += numGreaterThan(idNum, currentLoc.getleftChild());
        numOfNodes += numGreaterThan(idNum, currentLoc.getrightChild());
        
        //if statement not true, go right as going farther right means 
        //idNum is bigger
    } else { 
        numOfNodes += numGreaterThan(idNum, currentLoc.getrightChild());
    }
    return numOfNodes;
}



    @Override
    public String toString() {
        return postOrdertraversal();
    }
}
