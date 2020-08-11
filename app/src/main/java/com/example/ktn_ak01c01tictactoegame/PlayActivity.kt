package com.example.ktn_ak01c01tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_play.*

class PlayActivity : AppCompatActivity() {
    var player = 1
        private set
    var Winner = false
        private set
    var tacToePlayer1 = mutableListOf<String>()
        private set
    var tacToePlayer2 = mutableListOf<String>()
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
    }

    fun playGame(view: View) {
        val player1Name = intent.getStringExtra(FISRT_PLAYER_ONE)
        val player2Name = intent.getStringExtra(FISRT_PLAYER_TWO)
        var cellTicTacToe = arrayOf(cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9)
        for (i in cellTicTacToe.indices) {
            if (cellTicTacToe[i].tag == view.tag && !Winner) {
                if (player == 1) {
                    cellTicTacToe[i].text = "X"
                    cellTicTacToe[i].isEnabled = false
                    player = 2
                    playersBanner.text = "$player1Name's turn"
                    tacToePlayer1.add(cellTicTacToe[i].tag.toString())
                    checkWinner(tacToePlayer1, player1Name)
                } else {
                    cellTicTacToe[i].text = "O"
                    cellTicTacToe[i].isEnabled = false
                    player = 1
                    playersBanner.text = "$player2Name's turn "
                    tacToePlayer2.add(cellTicTacToe[i].tag.toString())
                    checkWinner(tacToePlayer2, player2Name)
                }
            }
        }
    }

    fun checkWinner(Player: MutableList<String>, player: String) {
        if ((Player.contains("cell1") && Player.contains("cell2") && Player.contains("cell3")) || (Player.contains(
                "cell1"
            ) && Player.contains("cell4") && Player.contains("cell7")) || (Player.contains("cell1") && Player.contains(
                "cell5"
            ) && Player.contains("cell9"))
        ) {
            playersBanner.text = "$player winner"
            Winner = true
        } else if ((Player.contains("cell2") && Player.contains("cell5") && Player.contains("cell8")) || (Player.contains(
                "cell3"
            ) && Player.contains("cell6") && Player.contains("cell9"))
        ) {
            playersBanner.text = "$player winner"
            Winner = true
        } else if ((Player.contains("cell4") && Player.contains("cell5") && Player.contains("cell6")) || (Player.contains(
                "cell7"
            ) && Player.contains("cell8") && Player.contains("cell9"))
        ) {
            playersBanner.text = "$player winner"
            Winner = true
        } else if (Player.contains("cell3") && Player.contains("cell5") && Player.contains("cell7")) {
            playersBanner.text = "$player winner"
            Winner = true
        }
    }
}
