/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package battleship;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author ferna
 */
public class barcos{
    private String name;
    
    private String image;
    private ArrayList<String> posicion= new ArrayList<>();
    private int hp,n_barco;
    public barcos(String name,int n_barco){
        this.name=name;
        
       setHp(name);

    }
    public void addCoordinates(String coordenada){
        posicion.add(coordenada);
    }
    public int getNumero(){
        return n_barco;
    }
    public String getName(){
        return name;
    }
    public ArrayList<String> getPosicion(){
        return posicion;
    }
    public void atacado(){
        hp--;
        
    }
    public boolean eliminado(){
        if(hp==0){
            posicion.clear();return true;
        }return false;
    }
    public void setHp(String name){
        if(name.equalsIgnoreCase("Acorazado"))
            hp=4;
        else if(name.equalsIgnoreCase("Portaaviones"))
            hp=5;
        else if(name.equalsIgnoreCase("Submarino"))
            hp=3;
        else if(name.equalsIgnoreCase("Destructor"))
            hp=2;
    }
}
