/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package battleship;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author ferna
 */
public class comments extends JTextArea {
    private boolean confirmacion;
    private ArrayList<String> Events= new ArrayList<>();
    comments(){
      setLineWrap(true);
      setWrapStyleWord(true);
      
    }
    public void printEvent(int x,int y){
        String posicion= "["+String.valueOf(x)+"],["+String.valueOf(y)+"]";
        if(confirmacion){
            Events.add("El barco enemigo ha sido dañado en las coordenadas: "+posicion);
            
        }
        else Events.add("El ataque en las coordenadas: "+posicion+" ha fallado");
        
        setText("");
      for(String element : Events){
          append(element+"\n");
      }}
    public void setConfirmacion(boolean confirmacion){
        this.confirmacion=confirmacion;
    }
}
