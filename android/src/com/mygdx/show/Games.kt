package com.mygdx.show

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen

public class Games : ApplicationAdapter() {
    private lateinit var screen: Screen

    override fun create() {
        screen = GameScreen()
    }

    override fun render() {
        screen.render(Gdx.graphics.deltaTime)
    }
}
