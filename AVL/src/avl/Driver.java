/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

/**
 *
 * @author dell
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AVL tr1=new AVL(new int[]{9,10,11,14,8,100});
        tr1.postorder();
        
        
        
        tr1.delete(100);
        tr1.insert(4);
        
        tr1.delete(11);
        tr1.delete(4);
        tr1.delete(14);
        

        tr1.postorder();
        tr1.preorder();
        
        
    }
        
        
    
}
