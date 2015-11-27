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
public class SpanningTree {
    private ArrayList<Node> order;
    private int[][] map;
    private int start;
    private int rows;
    private int cols;
    private int startX;
    private int startY;
    private int spaces;
    private int obstacles;
    
    public SpanningTree(int[][] map, int start){
        this.map = map;
        this.start = start;
        order = new ArrayList();
        this.rows = map.length;
        this.cols = map[0].length;
        this.startX = start/cols;
        this.startY = start%cols;
        spaces = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                if(map[i][j] == 0){
                    spaces++;
                }
            }
        }
        obstacles = rows*cols - spaces;
    }
    
    public void DFS(Node node){
        order.add(node);
        map[node.getI()][node.getJ()] = 1;
        
        if( (node.getJ() != 0) && (map[node.getI()][node.getJ()-1] == 0) ){           
            DFS(new Node(node.getI(), node.getJ() - 1, node));
        }
        
        if( (node.getI() != 0) && (map[node.getI()-1][node.getJ()] == 0) ){
            DFS(new Node(node.getI()-1, node.getJ(), node));
        }
        
        if( (node.getJ() != cols - 1) && (map[node.getI()][node.getJ()+1] == 0) ){
            DFS(new Node(node.getI(), node.getJ() + 1, node));
        }
        
        if( (node.getI() != rows - 1) && (map[node.getI()+1][node.getJ()] == 0) ){
            DFS(new Node(node.getI()+1, node.getJ(), node));
        }
        
    }
    
    public void findSpanningTree(){
        DFS(new Node(startX, startY, null));
    }

    public ArrayList<Node> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Node> order) {
        this.order = order;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
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

    public int getSpaces() {
        return spaces;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public int getObstacles() {
        return obstacles;
    }

    public void setObstacles(int obstacles) {
        this.obstacles = obstacles;
    }

}
