/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstt.core;

import java.util.ArrayList;

/**
 *
 * @author Tuan
 */
public class CoveringPath {

    private int[][] mapX4;
    private int start;
    private int startX;
    private int startY;
    private ArrayList<Node> path;

    public CoveringPath(int[][] mapX4, int start) {
        this.mapX4 = mapX4;
        this.start = start;
        startX = (start / (mapX4[0].length / 2)) * 2;
        startY = (start % (mapX4[0].length / 2)) * 2;
//        System.out.println(startX+" "+startY);
        path = new ArrayList<Node>();
        
    }

//    public void expand(Node node) {
//        if ((node.getI() == startX && node.getJ() == startY)) {
//            if (b) {
//                return;
//            } else {
//                b = true;
//            }
//        }
//        path.add(node);
//        if (mapX4[node.getI()][node.getJ()] == 0) {
//            if ((node.getI() % 2 == 0) && (node.getJ() % 2 == 0)) {
//
//                expand(new Node(node.getI() + 1, node.getJ(), null));
//            } else if ((node.getI() % 2 == 0) && (node.getJ() % 2 != 0)) {
//
//                expand(new Node(node.getI(), node.getJ() - 1, null));
//            } else if ((node.getI() % 2 != 0) && (node.getJ() % 2 == 0)) {
//
//                expand(new Node(node.getI(), node.getJ() + 1, null));
//            } else if ((node.getI() % 2 != 0) && (node.getJ() % 2 != 0)) {
//
//                expand(new Node(node.getI() - 1, node.getJ(), null));
//            }
//        } else if (1 == (mapX4[node.getI()][node.getJ()] & 1)) {
//
//            expand(new Node(node.getI() - 1, node.getJ(), null));
//        } else if (4 == (mapX4[node.getI()][node.getJ()] & 4)) {
//
//            expand(new Node(node.getI() + 1, node.getJ(), null));
//        } else if (8 == (mapX4[node.getI()][node.getJ()] & 8)) {
//
//            expand(new Node(node.getI(), node.getJ() + 1, null));
//        } else if (2 == (2 & mapX4[node.getI()][node.getJ()])) {
//
//            expand(new Node(node.getI(), node.getJ() - 1, null));
//        }
//    }

    public void findWay() {
        int i = startX;
        int j = startY;
        
        do {
            System.out.println(i+" "+j);
            path.add(new Node(i, j, null));
            if (mapX4[i][j] == 0) {
                if ((i % 2 == 0) && (j % 2 == 0)) {
                    i++;
                } else if ((i % 2 == 0) && (j % 2 != 0)) {
                    j--;       
                } else if ((i % 2 != 0) && (j % 2 == 0)) {
                    j++;
                } else if ((i % 2 != 0) && (j % 2 != 0)) {
                    i--;
                }
            } else if (mapX4[i][j] == 8) {
                j++;              
            } else if (mapX4[i][j] == 4) {
                i++;        
            } else if (mapX4[i][j] == 2) {
                j--;             
            } else if (mapX4[i][j] == 1) {
                i--;          
            } else if (mapX4[i][j] == 12) {
                i++;          
            }else if (mapX4[i][j] == 6) {
                j--;          
            }else if (mapX4[i][j] ==3) {
                i--;         
            }else if (mapX4[i][j] == 9) {
                j++;         
            }
        } while ((i != startX) || (j != startY));
    }

//    public void findWay(){
//      
//        
//        expand(new Node(startX, startY, null));
//    }
    public int[][] getMapX4() {
        return mapX4;
    }

    public void setMapX4(int[][] mapX4) {
        this.mapX4 = mapX4;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public void setPath(ArrayList<Node> path) {
        this.path = path;
    }

}
