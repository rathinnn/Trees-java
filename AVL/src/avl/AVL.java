/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;


import java.util.ArrayDeque;
/**
 *
 * @author dell
 */
public class AVL {
    
    AVLNode root;
  
    AVL()
    {
        root=null;
    }
    
    AVL(int[] Nodes)
    {
        root=new AVLNode(Nodes[0]);
        
        for(int i = 1;i<Nodes.length;i++)
        {
            insert(Nodes[i]);
        }
    }
    
    
    public void insert(int key)
    {
        if(root==null)
        {
            root=new AVLNode(key);
            
        }
        else
        {
            root=root.insert(key);
            
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
        System.out.println();
        root.inorder();
    }
    
    public void preorder()
    {
        if(root==null)
        {
            System.out.println("Empty tree");
            return;
        }
        System.out.println();
        root.preorder();
    }
    public void postorder()
    {
        if(root==null)
        {
            System.out.println("Empty tree");
            return;
        }
        System.out.println();
        root.postorder();
    }
    public void levelorder()
    {
     if(root==null)
        {
            System.out.println("Empty tree");
            return;
        }
     else
     {
         ArrayDeque<AVLNode> q = new ArrayDeque<>();
         root.levelorder(q);
     }
    }
    
    public AVLNode[] getPredecessor(AVLNode del)
    {
        AVLNode[] av = new AVLNode[2];
        AVLNode current = del.left;
        AVLNode predecessor=null;
        AVLNode parent=null;
        while(current!=null)
        {
            parent=predecessor;
            
            predecessor=current;
           
            current=current.right;
        }
        if(parent!=null)
        {
            parent.right=predecessor.left;
            
        }
        
        av[0]=predecessor;
        av[1]=parent;
        return av;
        
        
        
        
    }
    
    public boolean delete(int id)
    {
        int datatobalance;
        if(root==null)
        {
            return false;
        }
        else
        {
            AVLNode current=root;
            AVLNode parent=root;
            boolean isLeft=false;
            while(current.Data!=id)
            {
                if(current.Data>id&&current.left!=null)
                {
                    parent=current;
                    current=current.left;
                    isLeft=true;
                }
                else if(current.Data<id&&current.right!=null)
                {
                    parent=current;
                    current=current.right;
                    isLeft=false;
                }
                else
                {
                    return false;
                }
            }
            
            if(current.left==null&&current.right==null)
            {
                if(current==root)
                {
                    root=null;
                }
                else if(isLeft)
                {
                    parent.left=null;
                }
                else
                {
                    parent.right=null;
                }
                
                datatobalance = parent.Data;
            }
            else if(current.left==null||current.right==null)
            {
                if(current.left==null)
                {
                    if(current==root)
                    {
                        root=current.right;
                    }
                    else if(isLeft)
                    {
                        parent.left=current.right;
                    }
                    else
                    {
                        parent.right=current.right;
                    }
                    
                    datatobalance = parent.Data;
                }
                
                
                
                else
                {
                    if(current==root)
                    {
                        root=current.left;
                    }
                    else if(isLeft)
                    {
                        parent.left=current.left;
                    }
                    else
                    {
                        parent.right=current.left;
                    }
                    
                    datatobalance = parent.Data;
                }
                
                    
                
            }
          
          else
            {
                AVLNode[] av = getPredecessor(current);
                AVLNode predecessor = av[0];
                AVLNode preparent=av[1];
                
                
                
                if(current.left!=predecessor)
                {
                    predecessor.left=current.left;
                    
                }
                predecessor.right=current.right;
                if(current==root)
                {
                    root=predecessor;
                }
                else if(isLeft)
                {
                    parent.left=predecessor;
                }
                else 
                {
                    parent.right=predecessor;
                }
                
                if(preparent==null){
                    datatobalance=predecessor.Data;
                    
                
                }
                else{
                    datatobalance=preparent.Data;
                }
                
                
            }
            root=root.balAfterDel(datatobalance);
            
            
            return true;
        }
    }
    
  
    
        
}
