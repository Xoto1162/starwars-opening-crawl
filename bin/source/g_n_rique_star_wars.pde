import ddf.minim.*;

int etat = 0;
int musique = 0;
float y = 0;
int tour = 0;
float opacity1 = 255;
float opacity2 = 0;
float opacity3 = 255;
float scale = 1.2;
PImage img;
PImage logo;
Minim minim;
AudioPlayer player;

int time = millis();

void setup() {
   size(900, 400, P3D);
   img = loadImage("background.jpg");
   logo = loadImage("logo.png");
   
   minim = new Minim(this);
   player = minim.loadFile("sound.mp3");
}

void draw() {
  
  if (etat == 0) {
    
    background(0);
    textSize(30);
    
    if (millis() < time + 5500) {   
      opacity2 = opacity2 + 3;
    } else if (millis() > 8000) {
      opacity2 = opacity2 - 2.5;
    }
   
    println(millis());
    
    fill(9, 232, 238, opacity2);
    text("Il y a bien longtemps, dans une galaxie", 20, 200);
    text("lointaine, très lointaine...", 20, 240);
    
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
     if (scale > 0.125) {
       scale = scale - 0.0015;
     }
     
     if (millis() > time + 20300) {
       opacity3 = opacity3 - 2.5;
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
        opacity1 = opacity1 - 1.6;
        fill(255, 195, 30, opacity1);
      } else {
        fill(255, 195, 30, 255);
      }
      rotateX(PI/3.3);
      translate(0, y, 0);
    
      textSize(20);
      textSize(6);
      text("LA CHUTE DE L'EMPIRE", 450, 385);
    
      textSize(4);
      text("Les conflits sont partout ! Après la\nfin de l'Empereur et la rédemption\nd'Anakin SKYWALKER, son fils Luke\nforme de nouveaux Jedi pour assurer\nla paix dans la galaxie. Sur la paisible\nlune forestière YAVIN IV, de jeunes\napprentis suivent la formation\nde leur maître", 450, 395);
      text("Mais l'Empire n'a pas donné son\ndernier souffle et de nombreux\npartisants convoitent le trône\nde l'Empereur déchû. Les Grands Moffs\nencore loyaux à leur défunt\n préparent en secret une attaque\nau coeur du temple Jedi.", 450, 450);
      text("Envoyés dans une mission périlleuse,\nles enfants de Han Solo et Leïa se\ndirigent vers le système de Kuat, là\noù étaient jadis bâtis les vaisseaux\nde guerre interstellaires de l'Empire.\nMais une puissance sombre se\nprépare à leur dévoiler son vrai visage", 450, 498);
   
      y = y - 0.052;  //0.052
      
  }
  
}