/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author dell
 */
public class main {
    
    public static void main(String[] args){
    BST tr1=new BST(new int[]{50,20,10,60});
    
    System.out.println("Preorder Before Rotation");
    tr1.preorderTraversal();  
    
    tr1.Rotation();
    
    System.out.println();
    System.out.println("Preorder After Rotation");
    tr1.preorderTraversal();  
    
    System.out.println();
    System.out.println("Height of Root Node");
    System.out.println(tr1.Height_of_root_node());
    
    
        
    }
    
}
