/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mapbuilder;

/**
 *
 * @author Eric
 */
public class MapBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //If you want to run Eric's generator uncomment this
        DLAGenerator gen = new DLAGenerator(1, .4);
        GameMap map = gen.generateMap(true, 50, 50);
        DijkstraPathFinder path = new DijkstraPathFinder();
        System.out.println(path.isConnected(true, map));
        
        //If you want to run Fernando's generator uncomment this
        //SteeringDungeonGenerator gen = new SteeringDungeonGenerator();
        //GameMap map = gen.generateMap(true, 50, 50, 20);
		
	//If you want to run Marco's and Antonio's generator uncomment this
        //MazeGenerator gen = new MazeGenerator(100, 100);
        //GameMap map = gen.generateMap(true, 51,51);
        
        //prints out map into ascii
        /*
        for(int j = 0; j < map.getY(); j++){
            for(int i = 0; i < map.getX(); i++){
                System.out.print(map.getCell(i,j).asciiChar());
            }
            System.out.println();
        }*/
    }
    
}
