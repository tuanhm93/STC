/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstt.ultilities;

import cstt.core.Node;
import java.util.ArrayList;

/**
 *
 * @author Tuan
 */
public class Ultilities {
    public static boolean isInteger(String str) {
        boolean b = true;
        try {
            int i = Integer.parseInt(str);
            if(i == 0)
                b =  false;
        } catch (NumberFormatException nfe) {
            b =  false;
        }
        return b;
    }
    
    public static int[][] subdivide(int[][] map, ArrayList<Node> order){
        int[][] mapX4 = null;
        int rows = map.length;
        int cols = map[0].length;
        mapX4 = new int[rows*2][cols*2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(map[i][j] == 1){
                    boolean top = false;
                    boolean left = false;
                    boolean right = false;
                    boolean bottom = false;
                    if((i!=0)&&(map[i-1][j]!=2)){
                        Node currentNode = null;
                        Node aboveNode = null;
                        for (int k = 0; k < order.size(); k++) {
                            if((order.get(k).getI() == i)&&(order.get(k).getJ() == j)){
                                currentNode = order.get(k);
                            }else if((order.get(k).getI() == i-1)&&(order.get(k).getJ() == j)){
                                aboveNode = order.get(k);
                            }
                            if((currentNode != null) && (aboveNode != null)){
                                break;
                            }
                        }
                        if((currentNode.getParent() == aboveNode) || (currentNode == aboveNode.getParent())){
                            top = true;
                        }
                    }
                    if((j!=cols-1)&&(map[i][j+1]!=2)){
                        Node currentNode = null;
                        Node rightNode = null;
                        for (int k = 0; k < order.size(); k++) {
                            if((order.get(k).getI() == i)&&(order.get(k).getJ() == j)){
                                currentNode = order.get(k);
                            }else if((order.get(k).getI() == i)&&(order.get(k).getJ() == j+1)){
                                rightNode = order.get(k);
                            }
                            if((currentNode != null) && (rightNode != null)){
                                break;
                            }
                        }
                        if((currentNode.getParent() == rightNode) || (currentNode == rightNode.getParent())){
                            right = true;
                        }
                    }
                    if((i!=rows-1)&&(map[i+1][j]!=2)){
                        Node currentNode = null;
                        Node bottomNode = null;
                        for (int k = 0; k < order.size(); k++) {
                            if((order.get(k).getI() == i)&&(order.get(k).getJ() == j)){
                                currentNode = order.get(k);
                            }else if((order.get(k).getI() == i+1)&&(order.get(k).getJ() == j)){
                                bottomNode = order.get(k);
                            }
                            if((currentNode != null) && (bottomNode != null)){
                                break;
                            }
                        }
                        if((currentNode.getParent() == bottomNode) || (currentNode == bottomNode.getParent())){
                            bottom = true;
                        }
                    }

                    if((j!=0)&&(map[i][j-1]!=2)){
                        Node currentNode = null;
                        Node leftNode = null;
                        for (int k = 0; k < order.size(); k++) {
                            if((order.get(k).getI() == i)&&(order.get(k).getJ() == j)){
                                currentNode = order.get(k);
                            }else if((order.get(k).getI() == i)&&(order.get(k).getJ() == j-1)){
                                leftNode = order.get(k);
                            }
                            if((currentNode != null) && (leftNode != null)){
                                break;
                            }
                        }
                        if((currentNode.getParent() == leftNode) || (currentNode == leftNode.getParent())){
                            left = true;
                        }
                    }
                    if(top){
                        mapX4[i*2][j*2] = mapX4[i*2][j*2]|4;
                        mapX4[i*2][j*2+1] = mapX4[i*2][j*2+1]|1;                 
                    }

                    if(right){
                        mapX4[i*2][j*2+1] = mapX4[i*2][j*2+1]|2;
                        mapX4[i*2+1][j*2+1] = mapX4[i*2+1][j*2+1]|8;
                    }

                    if(bottom){
                        mapX4[i*2+1][j*2] = mapX4[i*2+1][j*2]|4;
                        mapX4[i*2+1][j*2+1] = mapX4[i*2+1][j*2+1]|1;
                    }

                    if(left){
                        mapX4[i*2][j*2] = mapX4[i*2][j*2]|2;
                        mapX4[i*2+1][j*2] = mapX4[i*2+1][j*2]|8;
                    }
                }else{
                    mapX4[i*2][j*2] = -1;
                    mapX4[i*2][j*2+1] = -1;
                    mapX4[i*2+1][j*2] = -1;
                    mapX4[i*2+1][j*2+1] = -1;
                }
            }
        }
        return mapX4;
    }
    
}
