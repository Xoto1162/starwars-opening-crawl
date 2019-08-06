import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class g_n_rique_star_wars extends PApplet {



int etat = 0;
int musique = 0;
float y = 0;
int tour = 0;
float opacity1 = 255;
float opacity2 = 0;
float opacity3 = 255;
float scale = 1.2f;
PImage img;
PImage logo;
Minim minim;
AudioPlayer player;

int time = millis();

public void setup() {
   
   img = loadImage("background.jpg");
   logo = loadImage("logo.png");
   
   minim = new Minim(this);
   player = minim.loadFile("sound.mp3");
}

public void draw() {
  
  if (etat == 0) {
    
    background(0);
    textSize(30);
    
    if (millis() < time + 5500) {   
      opacity2 = opacity2 + 3;
    } else if (millis() > 8000) {
      opacity2 = opacity2 - 2.5f;
    }
   
    println(millis());
    
    fill(9, 232, 238, opacity2);
    text("Il y a bien longtemps, dans une galaxie", 20, 200);
    text("lointaine, tr\u00e8s lointaine...", 20, 240);
    
    if (millis() > time + 10000) {
     etat = 1;
    }
    
  } else if (etat == 1) {
    if (musique == 0) {
      musique = 1;
      player.play();
      textAlign(CENTER);
    }
    
     background(img);
     if (scale > 0.125f) {
       scale = scale - 0.0015f;
     }
     
     if (millis() > time + 20300) {
       opacity3 = opacity3 - 2.5f;
     }
     
     scale(scale);
     imageMode(CENTER);
     tint(255, opacity3);
     image(logo, 450 * (1/scale), 200 * (1/scale));
    
    if (millis() > time + 24500) {
      etat = 2;
    }
    
  } else if (etat == 2) {
    
    background(img);
    if (y < -200) { //-220
        opacity1 = opacity1 - 1.6f;
        fill(255, 195, 30, opacity1);
      } else {
        fill(255, 195, 30, 255);
      }
      rotateX(PI/3.3f);
      translate(0, y, 0);
    
      textSize(20);
      textSize(6);
      text("LA CHUTE DE L'EMPIRE", 450, 385);
    
      textSize(4);
      text("Les conflits sont partout ! Apr\u00e8s la\nfin de l'Empereur et la r\u00e9demption\nd'Anakin SKYWALKER, son fils Luke\nforme de nouveaux Jedi pour assurer\nla paix dans la galaxie. Sur la paisible\nlune foresti\u00e8re YAVIN IV, de jeunes\napprentis suivent la formation\nde leur ma\u00eetre", 450, 395);
      text("Mais l'Empire n'a pas donn\u00e9 son\ndernier souffle et de nombreux\npartisants convoitent le tr\u00f4ne\nde l'Empereur d\u00e9ch\u00fb. Les Grands Moffs\nencore loyaux \u00e0 leur d\u00e9funt\n pr\u00e9parent en secret une attaque\nau coeur du temple Jedi.", 450, 450);
      text("Envoy\u00e9s dans une mission p\u00e9rilleuse,\nles enfants de Han Solo et Le\u00efa se\ndirigent vers le syst\u00e8me de Kuat, l\u00e0\no\u00f9 \u00e9taient jadis b\u00e2tis les vaisseaux\nde guerre interstellaires de l'Empire.\nMais une puissance sombre se\npr\u00e9pare \u00e0 leur d\u00e9voiler son vrai visage", 450, 498);
   
      y = y - 0.052f;  //0.052
      
  }
  
}
  public void settings() {  size(900, 400, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "g_n_rique_star_wars" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
