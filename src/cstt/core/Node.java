/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstt.core;

/**
 *
 * @author Tuan
 */
public class Node {
    private int i;//Chỉ số hàng
    private int j;//Chỉ số cột
    private Node parent;//Nút cha đi tới nó

    public Node(int i, int j, Node parent) {
        this.i = i;
        this.j = j;
        this.parent = parent;
    }
    
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public String toString(){
        String str = "";
        str += "Current:("+i+","+j+")";
        if(parent == null){
            str += " Parent: ROOT";
        }else{
            str += " Parent:("+parent.getI()+","+parent.getJ()+")";
        } 
        return str;
    }
}
