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
public class AVLNode {
    int Data;
    AVLNode left;
    AVLNode right;
    AVLNode parent;
    int balancefactor;

    
    
    AVLNode(int data){
        Data=data;
        left=null;
        right=null;
        parent=null;
        balancefactor=0;
        
    }
    
    public boolean search(int data){
        if(Data==data){
            return true;
        }
        else{
            if(data<Data && left!=null){
                return left.search(data);
            }
            else if(data>Data&&right!=null){
                return right.search(data);
            }
            else{
                return false;
            }
        }
    }
    
    public void inorder(){
        if(left!=null){
            left.preorder();
        }
        System.out.println(Data);
        if(right!=null){
            right.preorder();
        }
    }
    public void preorder(){
        System.out.print(Data+" ");
        if(left!=null){
            left.preorder();
        }
        
        if(right!=null){
            right.preorder();
        }
    }
    public void postorder(){
        
        if(left!=null){
            left.postorder();
        }
        
        if(right!=null){
            right.postorder();
        }
        System.out.print(Data+" ");
    }
 
    
    public void levelorder(ArrayDeque<AVLNode> que){
        System.out.println(Data);
        if(left!=null){
            
            que.add(left);
            
        }
        if(right!=null){
            que.add(right);
        }
        
        if(!que.isEmpty()){
            que.poll().levelorder(que);
        }
        
        
        
    }
    
    public AVLNode rotateWithLeft(){
        AVLNode rleft=this.left;
        left=rleft.right;
        left.parent=this;
        rleft.right=this;
        this.parent=rleft;
        rleft.parent=null;
        return rleft;
        
    }
    
    public AVLNode rotateWithRight(){
        AVLNode rright=this.right;
        right=rright.left;
        right.parent=this;
        rright.left=this;
        this.parent=rright;
        rright.parent=null;
        return rright;
        
    }
    
    public int height(){
        if(left==null&&right==null){
            return 0;
        }
        else if(left!=null&&right==null){
            return left.height()+1;
            
            
        }
        else if(left==null&&right!=null){
            return right.height()+1;
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
    
    public int computeBalance(){
        if(left==null && right==null){
            return 0;
        }
        else if(left==null && right!=null){
            return -1*(right.height()+1);
        }
        else if(left!=null && right==null){
            return left.height()+1;
        }
        else{
            
            return left.height()-right.height();
            
        }
        
    } 
    
    public AVLNode insert(int data){
        if(data<Data){
            if(left==null){
                left=new AVLNode(data);
                left.parent=this;
                
            }
            else{
                left=left.insert(data);
                left.parent=this;
            }              
                      
        }
        
        else{
            if(right==null){
                right= new AVLNode(data);
                right.parent=this;
            }
            else{
                right=right.insert(data);
                right.parent=this;
            }
            
            
        }
        balancefactor=computeBalance();
        switch(balancefactor){
            case 2 -> { 
                if(left.balancefactor>=0){
                    return rotateWithLeft();
                }
                else{
                    left=left.rotateWithRight();
                    return rotateWithLeft();
                }
            }
            case -2 -> {
                if(right.balancefactor<=0){
                    
                    
                    
                    return rotateWithRight();
                    
                }
                else{
                    right=right.rotateWithLeft();
                    return rotateWithRight();
                }
            }

                
        }
        return this;
               
    }
    
    public AVLNode balAfterDel(int data){
        if(data<Data){
            
                left=left.balAfterDel(data);
                          
                      
        }
        
        else if(data>Data){
            
                right=right.balAfterDel(data);
            
            
            
        }
        
        balancefactor=computeBalance();
        switch(balancefactor){
            case 2 -> { 
                
                left.balancefactor=left.computeBalance();
                if(left.balancefactor>=0){
                    
                    return rotateWithLeft();
                }
                else{
                    left=left.rotateWithRight();
                    return rotateWithLeft();
                }
            }
            case -2 -> {
                right.balancefactor=right.computeBalance();
                if(right.balancefactor<=0){
                    
                    
                    
                    return rotateWithRight();
                    
                }
                else{
                    right=right.rotateWithLeft();
                    return rotateWithRight();
                }
            }

                
        }
        return this;
        
        
        
    }
    
    public AVLNode getPredecessor(){
        AVLNode current = left;
        AVLNode predecessor=null;
        
        while(current!=null){
            
            predecessor=current;
            current=current.right;
            
        }
        
        return predecessor;
    }
    
    public AVLNode delRec(int todel){
        AVLNode predecessor=this;
        if(todel<Data && left!=null){
            left=left.delRec(todel);
            left.parent=this;
        }
        else if(todel>Data && right!=null){
            right=right.delRec(todel);
            right.parent=this;
        }
        else if(todel==Data){
            
            if(left==null&&right==null){
                return null;
            }
            
            else if(left==null||right==null){
                if(left==null){
                    return right;
                }
                else{
                    return left;
                }
            }
            
            else{
                predecessor = getPredecessor();
                left=left.delRec(predecessor.Data);
                predecessor.left=left;
                predecessor.right=right;
                right.parent=predecessor;
                left.parent=predecessor; 
                predecessor.parent=null;
                
            }
            
        }
        else{
            System.out.println("Not Found");
            return this;
        }
        
        predecessor.balancefactor=predecessor.computeBalance();
        switch(predecessor.balancefactor){
            case 2 -> { 
                
                left.balancefactor=left.computeBalance();
                if(left.balancefactor>=0){
                    
                    return predecessor.rotateWithLeft();
                }
                else{
                    predecessor.left=predecessor.left.rotateWithRight();
                    
                    return predecessor.rotateWithLeft();
                }
            }
            case -2 -> {
                predecessor.right.balancefactor=predecessor.right.computeBalance();
                if(right.balancefactor<=0){
                    
                    
                    
                    return predecessor.rotateWithRight();
                    
                }
                else{
                    predecessor.right=predecessor.right.rotateWithLeft();
                    
                    return predecessor.rotateWithRight();
                }
            }

                
        }
        
        return predecessor;
        
    }
    
    
    
    
    
}
