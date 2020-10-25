package Assignment7;
import Assignment2.StudentListing;

import java.util.List;

import javax.lang.model.util.ElementScanner6;
import javax.swing.tree.TreeNode;


public class BinaryTree {
    TreeNode root;
    public BinaryTree(){
        root = null;
    }    
    public boolean insert (StudentListing newStudentListing){
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNodeWrapper d = new TreeNodeWrapper();
        TreeNode n = new TreeNode();
        if (n == null)
            return false;
        else {
            n.node = newStudentListing.deepCopy();
            n.ld = null;
            n.rd = null;
            if (root == null){
                root = n;
            } 
            else {
                boolean node = findNode(newStudentListing.getKey(), c, d);
                if (newStudentListing.getKey().compareTo(c.get().node.getKey())< 0)
                    c.get().ld = n;
                else
                    c.get().rd = n;
            }
            return true;
        }
    }
    public StudentListing fetch(String targetKey){
        boolean found;
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNodeWrapper d = new TreeNodeWrapper();
        found = findNode(targetKey, c, d);
        if (found == true)
            return d.get().node.deepCopy();
        else    
            return null;
    }
    public boolean delete(String targetKey){
        boolean found;
        TreeNodeWrapper c = new TreeNodeWrapper();
        TreeNodeWrapper d = new TreeNodeWrapper();
        TreeNode largest;
        TreeNode nextLargest;
        found = findNode(targetKey, c, d);
        if (found == false)
            return false;
        else
            {if (d.get().ld == null && d.get().rd == null)
            {if (c.get().ld == d.get())
                c.get().ld = null;
            else    
                c.get().rd = null;   
            }
            else if (d.get().ld == null || d.get().rd == null)
            {
                if (c.get().ld == d.get())
                {
                    if (d.get().ld != null)
                        c.get().ld = d.get().ld;
                    else    
                        c.get().ld = d.get().ld;
                } else {
                    if (d.get().ld != null)
                        c.get().rd = d.get().ld;
                    else    
                        c.get().rd = d.get().rd;
                }
            }
            else {
                nextLargest = d.get().ld;
                    largest = nextLargest.rd;
                if (largest != null){
                    while (largest.rd != null){
                        nextLargest = largest;
                        largest = largest.rd;
                    }
                    d.get().node = largest.node;
                    nextLargest.rd = d.get().rd;
                }
                else {
                    nextLargest.rd = d.get().rd;
                    if (c.get().ld == d.get())
                        c.get().ld = nextLargest;
                    else    
                        c.get().rd = nextLargest;
                }
            }
            return true;
            }
    }

public boolean update (String targetKey, StudentListing newStudentListing)
{
    if (delete(targetKey) == false)
        return false;
    else if (insert(newStudentListing) == false)
        return false;
    return true;
}
public class TreeNode
{
    private StudentListing node;
    private TreeNode ld;
    private TreeNode rd;
    public TreeNode(){}
}
private boolean findNode(String targetKey, TreeNodeWrapper parent, TreeNodeWrapper child){
    parent.set(root);
    child.set(root);
    if (root == null)
        return true;
    while (child.get() != null)
    {
        if (child.get().node.compareTo(targetKey) == 0)
            return true;
        else{
            parent.set(child.get());
            if (targetKey.compareTo(child.get().node.getKey()) < 0)
                child.set(child.get().ld);
            else    
                child.set(child.get().rd);
        }
    }
    return false;
}
public class TreeNodeWrapper
{
    TreeNode treeRef = null;
    public TreeNodeWrapper(){

    }
    public TreeNode get(){
        return treeRef;
    }
    public void set(TreeNode t ){
        treeRef = t;
    }
}
}

