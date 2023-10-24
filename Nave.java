package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public abstract class Nave {
	private int vidas;
	private float xVel;
	private float yVel;
	private boolean herido;
	private int tiempoHeridoMax;
	private Sprite spr;
	private Sound sonidoHerido;
	private Sound sonidoDisparo;
	private Texture texturaDisparo;
	private int tiempoHerido;
	private boolean destruida;
	
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	public void setxVel(float xVel) {
		this.xVel = xVel;
	}
	
	public void setyVel(float yVel) {
		this.yVel = yVel;
	}
	
	public void setHerido(boolean herido) {
		this.herido = herido;
	}
	
	public void setTiempoHeridoMax(int tiempoHeridoMax) {
		this.tiempoHeridoMax = tiempoHeridoMax;
	}
	
	public void setSpriteTexture(Texture tx) {
		this.spr = new Sprite(tx);
	}
	
	public void setSpritePosition(int x, int y){
		this.spr.setPosition(x,y);
	}
	
	public void setSpriteBounds(int a, int b, int c, int d){
		this.spr.setBounds(a,b,c,d);
	}
	
	public void setSonidoHerido(Sound sonidoHerido){
		this.sonidoHerido = sonidoHerido;
	}
	
	public void setSonidoDisparo(Sound sonidoDisparo){
		this.sonidoDisparo = sonidoDisparo;
	}
	
	public void setTexturaDisparo(Texture texturaDisparo){
		this.texturaDisparo = texturaDisparo;
	}
	
	public void setDestruida(boolean destruida){
		this.destruida = destruida;
	}
	
	public int getVidas() {
		return this.vidas;
	}
	
	public float getxVel() {
		return this.xVel;
	}
	
	public float getyVel() {
		return this.yVel;
	}
	
	public boolean getHerido() {
		return this.herido;
	}
	
	public int getTiempoHeridoMax() {
		return this.tiempoHeridoMax;
	}
	
	public Sprite getSprite() {
		return this.spr;
	}
	
    public int getX() {
    	return (int) spr.getX();
    }
    
    public int getY() {
    	return (int) spr.getY();
    }
	
	public Sound getSonidoHerido(){
		return this.sonidoHerido;
	}
	
	public Sound getSonidoDisparo(){
		return this.sonidoDisparo;
	}
	
	public boolean getDestruida(){
		return this.destruida;
	}
	
	/*public void getTexturaDisparo(Texture texturaDisparo){
		this.texturaDisparo = texturaDisparo;
	}*/
    
    public abstract void movimiento(SpriteBatch batch, PantallaJuego juego);
    
    public boolean verificarColisionNave(Ball2 b) {
    	if(!herido && b.getArea().overlaps(spr.getBoundingRectangle())){
        	// rebote
            if (xVel ==0) xVel += b.getXSpeed()/2;
            if (b.getXSpeed() ==0) b.setXSpeed(b.getXSpeed() + (int)xVel/2);
            xVel = - xVel;
            b.setXSpeed(-b.getXSpeed());
            
            if (yVel ==0) yVel += b.getySpeed()/2;
            if (b.getySpeed() ==0) b.setySpeed(b.getySpeed() + (int)yVel/2);
            yVel = - yVel;
            b.setySpeed(- b.getySpeed());
            // despegar sprites
      /*      int cont = 0;
            while (b.getArea().overlaps(spr.getBoundingRectangle()) && cont<xVel) {
               spr.setX(spr.getX()+Math.signum(xVel));
            }   */
        	//actualizar vidas y herir
            vidas--;
            herido = true;
  		    tiempoHerido=tiempoHeridoMax;
  		    sonidoHerido.play();
            if (vidas<=0) 
            return true;
        }
        return false;
    }
    
    public abstract void draw(SpriteBatch batch, PantallaJuego juego);
    
    public abstract void especial();
}
