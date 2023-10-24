package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;


public class PantallaMenu implements Screen {

	private SpaceNavigation game;
	private OrthographicCamera camera;

	public PantallaMenu(SpaceNavigation game) {
		this.game = game;
        
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1200, 800);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);

		game.getBatch().begin();
		game.getFont().draw(game.getBatch(), "Bienvenido a Space Navigation !", 140, 400);
		game.getFont().draw(game.getBatch(), "Pincha en cualquier lado o presiona cualquier tecla para comenzar ...", 100, 300);
		game.getFont().draw(game.getBatch(), "Opcion 1", 100, 200);
		game.getFont().draw(game.getBatch(), "Opcion 1", 100, 150);
		game.getFont().draw(game.getBatch(), "Opcion 1", 100, 100);
	
		game.getBatch().end();
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
			Screen ss = new PantallaMercado(game);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			game.getFont().draw(game.getBatch(), "¿Estas seguro de que quieres salir?", 80, 200);
		}

		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			Screen ss = new PantallaJuego(game,1,3,0,1,1,10);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
   
}