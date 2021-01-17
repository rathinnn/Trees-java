/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

 

public class BSTNode {

    int data;
    
   
    BSTNode left;
    BSTNode right;
    BSTNode parent;
    
    
    BSTNode(int data)
    {
        
        this.data=data;
        left=null;
        right=null;
        parent=null;
    }
    
    
    public void inorder()
    {
        if(this==null)
        {
            return;
        }
        if(left!=null){
        left.inorder();
        }
        System.out.print(data+" ");
        if(right!=null){
        right.inorder();
        }
    }
    
    
    public void preorder()
    {
        if(this==null)
        {
            return;
        }
        
        System.out.print(data+" ");
       if(left!=null){
        left.preorder();
        }
        
        if(right!=null){
        right.preorder();
        }
    }
    
    public void postorder()
    {
        if(this==null)
        {
            return;
        }
        
        if(left!=null){
        left.postorder();
        }
        
        if(right!=null){
        right.postorder();
        }
        
        System.out.print(data+" ");
        
        
    }
    public void insert(int key)
    {
        

        if(data<key)
        {
            if(right==null)
            {
                right=new BSTNode(key);
                right.parent=this;
                return;
            }
            else
            {
                right.insert(key);
                return;
            }
        }
        else
                {
                   if(left==null) 
                   {
                       left=new BSTNode(key);
                       left.parent=this;
                       return;
                   }
                   else
                   {
                       left.insert(key);
                       return;
                   }
                }
    }
    
    public boolean search(int key)
    {
        
        if(data==key)
        {
            return true;
        }
        else if(data<key&&right!=null)
        {
            return right.search(key);
        }
        else if(data>key&&left!=null)
        {
            return left.search(key);
            
        }
        else
        {
            return false;
        }
    }
    
    
    
    
    public int height()
    {
    if(left==null&right==null)
    {
        return 0;
        
    }
    else if(left==null&&right!=null)
    {
        return right.height()+1;
    }
    else if(left!=null&&right==null)
    {
        return left.height()+1;
    }
    else {
        int l = left.height();
        int r = right.height();
        if(l>r)
        {
            return l+1;
        }
        else
        {
            return r+1;
        }
    }
    
    }
    
    
    
    
    
    
    
    

    
    
}


    
    
