/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.util.HashMap;

/**
 *
 * @author Danny
 */
public class Veld 
{
    public int x;
    public int y;
    Item item;
    public Veld Noord;
    public Veld Zuid;
    public Veld West;
    public Veld Oost;
    HashMap<Direction, Veld> veldHash;
    
    public Veld()
        {
            veldHash = new HashMap<>();
        }
    public void filHash()
    {
            veldHash.put(Direction.Up, this.Noord);
            veldHash.put(Direction.Down, this.Zuid);  
            veldHash.put(Direction.Left, this.West);  
            veldHash.put(Direction.Right, this.Oost); 
    }
    
}
