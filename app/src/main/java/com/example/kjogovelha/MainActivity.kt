package com.example.kjogovelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val playerOne = arrayListOf<Int>()
    val playerTwo = arrayListOf<Int>()
    var currentPlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun play(position: Int, btnSelected: Button) {

        if (currentPlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.color.colorPlayer1)
            playerOne.add(position)
            currentPlayer = 2
        } else {
            btnSelected.text = "0"
            btnSelected.setBackgroundResource(R.color.colorPlayer2)
            playerTwo.add(position)
            currentPlayer = 1
        }

        btnSelected.isClickable = false

        checkResult()
    }

    fun btnPosition(view: View) = when(view.id) {
        R.id.btn1Button -> play(1, view as Button)
        R.id.btn2Button -> play(2, view as Button)
        R.id.btn3Button -> play(3, view as Button)
        R.id.btn4Button -> play(4, view as Button)
        R.id.btn5Button -> play(5, view as Button)
        R.id.btn6Button -> play(6, view as Button)
        R.id.btn7Button -> play(7, view as Button)
        R.id.btn8Button -> play(8, view as Button)
        R.id.btn9Button -> play(9, view as Button)
        else -> play(0, view as Button)
    }

    fun checkResult() {
        val row1 = listOf(1, 2, 3)
        val row2 = listOf(4, 5, 6)
        val row3 = listOf(7, 8, 9)

        val column1 = listOf(1, 4, 7)
        val column2 = listOf(2, 5, 8)
        val column3 = listOf(3, 6, 9)

        val diagonal = listOf(1, 5, 9)
        val diagona2 = listOf(3, 5, 7)

        var winner = -1

        if (playerOne.containsAll(row1) || playerOne.containsAll(row2) || playerOne.containsAll(row3) ||
            playerOne.containsAll(column1) || playerOne.containsAll(column2) || playerOne.containsAll(column3) ||
            playerOne.containsAll(diagonal) || playerOne.containsAll(diagona2)) {

            winner = 1
        }

        if (playerTwo.containsAll(row1) || playerTwo.containsAll(row2) || playerTwo.containsAll(row3) ||
            playerTwo.containsAll(column1) || playerTwo.containsAll(column2) || playerTwo.containsAll(column3) ||
            playerTwo.containsAll(diagonal) || playerTwo.containsAll(diagona2)) {

            winner = 2
        }

        when (winner) {
            1 -> Toast.makeText(this, "Parabéns! Jogador 1 VENCEU!", Toast.LENGTH_LONG).show()
            2 -> Toast.makeText(this, "Parabéns! Jogador 2 VENCEU!", Toast.LENGTH_LONG).show()
        }
    }

    fun restart(view: View){
        playerOne.clear()
        playerTwo.clear()
        setContentView(R.layout.activity_main)
    }
}
