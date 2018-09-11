/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generator;

import processing.core.*;

/**
 *
 * @author David´s User
 */
public class TerrainGen extends PApplet{
    
    int col,fil,w,h;
    int scl=20;
    float[][] y;
    float mov;
    //PeasyCam cam;
    
    @Override
    public void setup() {
        //cam=new PeasyCam(this,500);
        w=5000;
        h=2000;
        col=w/scl;
        fil=h/scl;
        y=new float[col][fil];
        
    }
    
    @Override
    public void draw() {
        mov-=0.1;
        float xoff=0;
        for(int x=0;x<col;x++) {
            float zoff=mov;
            for(int z=0;z<fil;z++) { 
                y[x][z]=map(noise(xoff,0,zoff),0,1,-100,100);   
                zoff+=0.2;
            }
            xoff+=0.2;
        }
        background(0);
        noFill();
        stroke(255);
        
        translate(-width/2,height/2,-1000);
        rotateX(-PI/6);
        translate(-width/2,-height/2,-100);
        for(int x=0;x<col-1;x++) {
            beginShape(TRIANGLE_STRIP);
            for(int z=0;z<fil;z++) {
                vertex(x*scl,y[x][z],z*scl); 
                vertex((x+1)*scl,y[x+1][z],z*scl); 
            }
            endShape();
        }
        
    }
    
    @Override
    public void settings() {
        size(800, 800, P3D);
    }
}
