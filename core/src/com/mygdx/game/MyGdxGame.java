package com.mygdx.game;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.block;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture texture;
	ArrayList<Sprite> sSprite = new ArrayList<Sprite>();
	Random rand;
	private Stage stage;
	long t1;
	int y =0;

	@Override
	public void create () {
		stage = new Stage();
		batch = new SpriteBatch();
		t1 = System.currentTimeMillis();
		batch.begin();
		randomElement();
		drawGrid();
		drawElement();
		batch.end();
	}

	@Override
	public void render () {
		long t2 = System.currentTimeMillis();
		if(t2 - t1 >= 1000){
			t1 = System.currentTimeMillis();
			y+=120;
		}
		if(y>=1910){
			randomElement();
		}
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		drawElement();
		drawGrid();
		batch.end();
	}

	private void drawElement(){
		for (Sprite spr:
		sSprite) {
			spr.setPosition(360, 1910 - y);
			spr.setSize(400, 300);
			spr.draw(batch);
		}
	}

	private void randomElement(){
		y=0;
		rand = new Random();
		int x = rand.nextInt(7)+1;
		switch (x){
			case 1:{
				img = new Texture(Gdx.files.internal("images/i.png"));
				break;
			}
			case 2:{
				img = new Texture(Gdx.files.internal("images/o.png"));
				break;
			}
			case 3:{
				img = new Texture(Gdx.files.internal("images/s.png"));
				break;
			}
			case 4:{
				img = new Texture(Gdx.files.internal("images/z.png"));
				break;
			}
			case 5:{
				img = new Texture(Gdx.files.internal("images/l.png"));
				break;
			}
			case 6:{
				img = new Texture(Gdx.files.internal("images/j.png"));
				break;
			}
			case 7:{
				img = new Texture(Gdx.files.internal("images/t.png"));
				break;
			}
		}
		sSprite.add(new Sprite(img));
	}

	private void drawGrid() {
		texture = new Texture(Gdx.files.internal("images/grid.png"));
//		sSprite = new Sprite(texture);
//		sSprite.setSize(120, 120);
//		for(int i = 0; i < 10; i++)
//			for(int j = 0; j < 20; j++){
//				sSprite.setPosition(50+i*100, 200+j*100);
//				sSprite.draw(batch);
//			}
	}
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		texture.dispose();
	}
}
