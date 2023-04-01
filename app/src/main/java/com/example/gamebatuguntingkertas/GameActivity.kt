package com.example.gamebatuguntingkertas

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var rockImageButton: ImageButton
    lateinit var scissorsImageButton: ImageButton
    lateinit var paperImageButton: ImageButton
    lateinit var resultImageView: ImageView

    private fun initComponents(){
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resutImageView)
    }

    private fun initListeners(){
        rockImageButton.setOnClickListener { startGame(option = "ROCK") }
        scissorsImageButton.setOnClickListener { startGame(option = "SCISSORS") }
        paperImageButton.setOnClickListener { startGame(option = "PAPER") }
    }

    private fun startGame(option: String){
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when {
            Game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.tryagain)
            Game.isWin(option, computerOption) -> resultImageView.setImageResource(R.drawable.hooray)
            else -> resultImageView.setImageResource(R.drawable.sad)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListeners()
    }

}