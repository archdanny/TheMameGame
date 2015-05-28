/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

/**
 *
 * @author Danny
 */
public interface Beweeg {

    public void move(Direction d);
    
    public enum Direction
    {
        Up, Down, Left, Right
    }
   
}
