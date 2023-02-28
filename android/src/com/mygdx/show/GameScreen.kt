package com.mygdx.show

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.elements.PieceS

class GameScreen : Screen {
    private val batch = SpriteBatch()
    private val sFigure = PieceS()
    override fun show() {}

    override fun render(delta: Float) {
        batch.begin()
        sFigure.draw(batch)
        batch.end()
    }

    override fun resize(width: Int, height: Int) {}

    override fun pause() {}

    override fun resume() {}

    override fun hide() {}

    override fun dispose() {}
}