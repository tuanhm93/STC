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
    private int[][] mapX4;//Bản đồ nhỏ (Một ô vuông được chia thành 4)
    private int start;//Điểm bắt đầu ở bản đồ lớn
    private int startX;//Chỉ số hàng bắt đầu ở bản đồ nhỏ
    private int startY;//Chỉ số cột bắt đầu ở bản đồ nhỏ
    private ArrayList<Node> path;//Lưu trữ danh sách thứ tự đường đi của robot

    public CoveringPath(int[][] mapX4, int start) {
        this.mapX4 = mapX4;
        this.start = start;
        startX = (start / (mapX4[0].length / 2)) * 2;
        startY = (start % (mapX4[0].length / 2)) * 2;
        path = new ArrayList<Node>();
    }
    
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
