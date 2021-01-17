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
public class BST
{
    
    BSTNode root;
    
    BST()
    {
        root=null;
    }
    
    BST(int[] Nodes)
    {
        root=new BSTNode(Nodes[0]);
        
        
        for(int i = 1;i<Nodes.length;i++)
        {
            root.insert(Nodes[i]);
        }
        
    }
    
    
    public void insert_BST(int key)
    {
        if(root==null)
        {
            root=new BSTNode(key);
            
            
        }
        else
        {
            root.insert(key);
            
            
        }
    }
    
    public boolean search(int key)
    {
        if (root==null)
        {
            return false;
        }
        else
        {
            return root.search(key);
        }
    }
    
    public void inorder()
    {
        if(root==null)
        {
            System.out.println("Empty tree");
            return;
        }
        root.inorder();
    }
    
    public void preorderTraversal()
    {
        if(root==null)
        {
            System.out.println("Empty tree");
            return;
        }
        root.preorder();
    }
    
    public void postorder()
    {
        if(root==null)
        {
            System.out.println("Empty tree");
            return;
        }
        root.postorder();
    }
    
    public int Height_of_root_node()
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            return root.height();
        }
    }
    
    public void Rotation(){
        if(root!=null){
            BSTNode temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
    }
    
    
    
    
    
    
    
    
    
    
}