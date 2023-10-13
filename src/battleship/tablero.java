/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package battleship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


    public class tablero extends JPanel {
    public JButton[][] botones;
    private String type;
    private int size,barco,n_barcos,sizeArray,x,y;
    public boolean Acorazado=false,Destructor=false,Portaaviones=false,Submarino=false,horizontal,vertical,mouseexit,turno=false,bombardeo,attack,
            confirmattack,confirmmiss,modo,ocupado,eliminado;
    public String[][] coordenada;
    private ImageIcon[] imagetype;
    private ImageIcon[] pa= new ImageIcon[5];
    private ImageIcon[] az=new ImageIcon[4];
    private ImageIcon[] sm= new ImageIcon[3];
    private ImageIcon[] dt = new ImageIcon[2];
    public static comments cm= Game_menu.cm;
    public barcos[] ship;
    public static Game_menu gamemenu= log.gamemenu;
    

    public tablero(String difficulty, boolean game_mode) {
        setLayout(new GridLayout(8, 8));
        botones = new JButton[8][8];
        coordenada= new String[8][8];
        dificultad(difficulty);
        ship=new barcos[sizeArray];
        n_barcos=0;
        

        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                botones [fila][columna] = new JButton();
                botones [fila][columna].setPreferredSize(new Dimension(50, 50));
                final int row= fila;
                final int col=columna;
              pa[0]= new ImageIcon(getClass().getResource("/barcos/pa1.jpeg"));
              pa[1]= new ImageIcon(getClass().getResource("/barcos/pa2.jpeg"));
              pa[2]= new ImageIcon(getClass().getResource("/barcos/pa3.jpeg"));
              pa[3]= new ImageIcon(getClass().getResource("/barcos/pa4.jpeg"));
              pa[4]= new ImageIcon(getClass().getResource("/barcos/pa5.jpeg"));
              az[0]= new ImageIcon(getClass().getResource("/barcos/az3.jpeg"));
              az[1]= new ImageIcon(getClass().getResource("/barcos/az2.jpeg"));
              az[2]= new ImageIcon(getClass().getResource("/barcos/az1.jpeg"));
              az[3]= new ImageIcon(getClass().getResource("/barcos/az0.jpeg"));
              sm[0]= new ImageIcon(getClass().getResource("/barcos/sub0.jpeg"));
              sm[1]= new ImageIcon(getClass().getResource("/barcos/sub1.jpeg"));
              sm[2]= new ImageIcon(getClass().getResource("/barcos/sub2.jpeg"));
              dt[0]= new ImageIcon(getClass().getResource("/barcos/dt0.jpeg"));
              dt[1]= new ImageIcon(getClass().getResource("/barcos/dt1.jpeg"));
              
                botones [fila][columna].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton sourceButton = (JButton) e.getSource();
                        
                        if(Acorazado){
                            crearBarco("Acorazado");
                            setSize(4);
                            if(horizontal){
                           if(isEmpty(row,col)){
                           setImage(row,col);}
                          
                           else if(!isEmpty(row,col))JOptionPane.showMessageDialog(null, "El barco no se puede colocar en esta casilla");
                           
       }          else if(vertical){
                    crearBarco("Acorazado");
                           if(isEmpty(row,col))
                           setImage(row,col);
                          
                           else if(!isEmpty(row,col))JOptionPane.showMessageDialog(null, "El barco no se puede colocar en esta casilla");}
                            barco--;n_barcos++;
                            
                        Acorazado=false;}
                        
                        else if(Destructor){
                            setSize(2);
                           if(horizontal){
                               crearBarco("Destructor");
                           if(isEmpty(row,col))
                           setImage(row,col);
                          
                           else if(!isEmpty(row,col)) JOptionPane.showMessageDialog(null, "El barco no se puede colocar en esta casilla");
                           
       }          else if(vertical){
                           crearBarco("Destructor");
                           if(isEmpty(row,col))
                           setImage(row,col);
                          
                           else if(!isEmpty(row,col)) JOptionPane.showMessageDialog(null, "El barco no se puede colocar en esta casilla");}
                           barco--;n_barcos++;
                           
                        Destructor=false;}
                     else if(Portaaviones){
                            setSize(5);
                           if(horizontal){
                               crearBarco("Portaaviones");
                              if(isEmpty(row,col))
                           setImage(row,col);
                          
                           else if(!isEmpty(row,col))JOptionPane.showMessageDialog(null, "El barco no se puede colocar en esta casilla");
                           
       }          else if(vertical){
                           crearBarco("Portaaviones");
                           if(isEmpty(row,col))
                           setImage(row,col);
                          
                           else if(!isEmpty(row,col)) JOptionPane.showMessageDialog(null, "El barco no se puede colocar en esta casilla");}
                       barco--;n_barcos++;
                       Portaaviones=false;}
                     else if(Submarino){
                         crearBarco("Submarino");
                            setSize(3);
                           if(horizontal){
                           if(isEmpty(row,col))
                           setImage(row,col);
                          
                           else if(!isEmpty(row,col)) JOptionPane.showMessageDialog(null, "El barco no se puede colocar en esta casilla");
                           
       }          else if(vertical){
           crearBarco("Submarino");
                           if(isEmpty(row,col))
                           setImage(row,col);
                          
                           else if(!isEmpty(row,col))JOptionPane.showMessageDialog(null, "El barco no se puede colocar en esta casilla");}
                      barco--;n_barcos++; 
                      Submarino=false;}
                        
                    if(bombardeo){attack=false;barco=1;bombardeo(row,col);}
                    else if(barco==0){
                        JOptionPane.showMessageDialog(null, "Todos los Barcos han sido colocados Turno del otro player");
                        setTurno(false);
                        
                        
                        
                        
                        
                    }else if(attack){
                       JOptionPane.showMessageDialog(null, "Ataque realizado Turno del otro player");
                        setTurno(false); 
                        bombardeo=false;
                        attack=false;
                        System.out.println(bombardeo);
                    }}
                   
                    
                });
                
                botones[fila][columna].addMouseListener(new MouseAdapter(){
                    @Override
                    
                    public void mouseEntered(MouseEvent e){
                        mouseexit=false;
                        JButton sourceButton = (JButton) e.getSource();
                        if(Acorazado){
                            setSize(4);
                            if(horizontal){
                            sizeHorizontal(row,col);}
                            else if(vertical){
                                sizeVertical(row,col);}
                           }
                        else if(Destructor){
                            setSize(2);
                           if(horizontal){
                            sizeHorizontal(row,col);}
                            else if(vertical){
                                sizeVertical(row,col);}
                        }
                        else if(Portaaviones){
                            setSize(5);
                           if(horizontal){
                            sizeHorizontal(row,col);}
                            else if(vertical){
                                sizeVertical(row,col);}
                        }
                        else if(Submarino){
                            setSize(3);
                           if(horizontal){
                            sizeHorizontal(row,col);}
                            else if(vertical){
                                sizeVertical(row,col);}
                        }
                    }
                    
                    @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color de fondo cuando el mouse sale del botón
                JButton sourceButton = (JButton) e.getSource();
                mouseexit=true;
                
                
                    if(Acorazado){
                            setSize(4);
                           if(horizontal){
                            sizeHorizontal(row,col);}
                            else if(vertical){
                                sizeVertical(row,col);}}
                    else if(Destructor){
                            setSize(2);
                           if(horizontal){
                            sizeHorizontal(row,col);}
                            else if(vertical){
                                sizeVertical(row,col);}}
                    else if(Portaaviones){
                            setSize(5);
                           if(horizontal){
                            sizeHorizontal(row,col);}
                            else if(vertical){
                                sizeVertical(row,col);}}
                    else if(Submarino){
                            setSize(3);
                           if(horizontal){
                            sizeHorizontal(row,col);}
                            else if(vertical){
                                sizeVertical(row,col);}}
                
                
                
                
                
                
                
            }
                });
             add(botones[fila][columna]); 
             
            }
    }
    }
    public void setType(String type){
        this.type=type;
        if(type.equals("Acorazado")){
                Acorazado=true;}
        else if(type.equals("Portaaviones"))
                Portaaviones=true;
        else if(type.equals("Destructor"))
                Destructor=true;
        else if(type.equals("Submarino"))
                Submarino=true;
    }
    
   public void setSize(int size){
       this.size=size;
       }
   public void setHorizontal(boolean direccion){
       horizontal=direccion;
   }
    public void setVertical(boolean direccion){
       vertical=direccion;
   }
    public void sizeHorizontal(int row,int col){
         for(int i=col;i<col+size;i++){
             
          if(col+size>8) break;
          else if(mouseexit){
                     botones[row][i].setBackground(UIManager.getColor("Button.background"));}
             
             
             
             
             else botones[row][i].setBackground(Color.green);}
         }
   
   
     public void sizeVertical(int row,int col){
         
        for(int i=row;i<row+size;i++){
            if(row+size>8){
                break;
            
            }
            else if(mouseexit){
                     botones[i][col].setBackground(UIManager.getColor("Button.background"));}
             else  { botones[i][col].setBackground(Color.green);}
                
    }
         
    }
     public void setImage(int row,int col){
         int j=0;
         if(horizontal){
             for(int i=col;i<col+size;i++){
          if(col+size>8) break;
          
           botones[row][i].setIcon(getImage()[j]);
          
          
          
          botones[row][i].setBackground(UIManager.getColor("Button.background"));
          
          setCordenada(row,i);
          j++;
         }}
             else if(vertical){
             for(int i=row;i<row+size;i++){
            if(row+size>8){
                break;}
            botones[i][col].setIcon(getImage()[j]);
            botones[i][col].setBackground(UIManager.getColor("Button.background"));
            setCordenada(col,i);
            j++;
                     } }  
     }
    public boolean changeTurn(){
        Acorazado=false;
        Destructor=false;
        Portaaviones=false;
        Submarino=false;
       
        if(barco>4)
            return true;
        else if(attack){
            return true;
        }
        return false;
    }
    public void setTurno(boolean turno){
        this.turno=turno;
    }
    public boolean getTurno(){
        return turno;
    }
    public void bombardeo(int row,int i){
        for(int j=0;j<ship.length;j++){
           if(ship[j].getPosicion().contains(coordenada[row][i])){
              confirmattack=true;ship[j].atacado();
              if(ship[j].eliminado()){
                  eliminado=true;
              }
              break;
              }
           else 
               confirmmiss=true;break;}
           
        
        if(confirmattack){
             comentar(row,i);
            
            JOptionPane.showMessageDialog(null, "El barco enemigo ha sido dañado"); 
            if(eliminado){coordenada[row][i]=null;
                JOptionPane.showMessageDialog(null, "El barco enemigo se ha destruido"); 
                if(checkBarcostab()){
                    JOptionPane.showMessageDialog(null, "Destruiste todos los barcos del enemigo!");
                endGame();}
            }
           
        }
        else if(confirmmiss) {
        comentar(row,i);
            JOptionPane.showMessageDialog(null, "El ataque ha fallado");}
        eliminado=false;
        bombardeo=false;
        confirmattack=false;
        confirmmiss=false;
        attack=true;
        
    }
    public void setCordenada(int row,int i){
        if(horizontal){
            coordenada[row][i]=String.valueOf(row)+","+String.valueOf(i);
        ship[n_barcos].addCoordinates(String.valueOf(row)+","+String.valueOf(i));}
        else if(vertical){
            coordenada[i][row]=String.valueOf(i)+","+String.valueOf(row);
        ship[n_barcos].addCoordinates(String.valueOf(i)+","+String.valueOf(row));}
    }
    public void setImagetype(String type){
        if(type.equals("Acorazado")){
                imagetype=az;}
        else if(type.equals("Portaaviones"))
                imagetype=pa;
        else if(type.equals("Destructor"))
                imagetype=dt;
        else if(type.equals("Submarino"))
                imagetype=sm;
    }
    public ImageIcon[] getImage(){
        return imagetype;
    }
    public void setBombardeo(boolean opcion){
        bombardeo=opcion;
    }
    public void comentar(int px,int py){
        if(confirmattack){
        cm.setConfirmacion(true);
        cm.printEvent(px,py);}
        else if(confirmmiss){
            cm.setConfirmacion(false);
        cm.printEvent(px,py);}
        
    }
    public boolean attackEnded(){
       return attack;
    }
    public void changecoordinates(){
        Random random= new Random();
        int randomint= random.nextInt(2);
        //Horizontal
        if(randomint==0){
           int filarandom=random.nextInt(8);
           int colrandom=random.nextInt(8);
           x=filarandom;
           y=colrandom;
        }
        //Vertical
        else if(randomint==1){
            int filarandom=random.nextInt(8);
           int colrandom=random.nextInt(8);
           x=filarandom;
           y=colrandom;
        }
    }
    public void dificultad(String dificultad){
        if(dificultad.equals("Easy")){
            barco=5;sizeArray=5;}
        if(dificultad.equals("Normal")){
            barco=4;sizeArray=4;}
        if(dificultad.equals("Expert")){
            barco=2;sizeArray=2;}
        if(dificultad.equals("GENIUS")){
            barco=1;sizeArray=1;}
    }
    public void hideImages(){
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
              botones[fila][columna].setIcon(null);
            }
        }
            
    }
    public boolean isEmpty(int row,int col){
        return true;
        
         }
    public void crearBarco(String name){
        ship[n_barcos]=new barcos(name,n_barcos);
    }
    public boolean checkBarcostab(){
        for(int i=0;i<ship.length;i++){
            if(!ship[i].getPosicion().isEmpty())
                return false;
        }return true;
    }
    public void endGame(){
       gamemenu.setVisible(true);
    }
    
    }
//Reglas del juego
//Mi perfil
//puntaje
//reportes
//optimizar procesos
    
/* public boolean isEmpty(int row,int col){
        
        
         for(int j=0;j<ship.length-(barco+1);j++){
           if(ship[j].getPosicion().contains(coordenada[row][col])){
           return false;}
         }return true;}*/

