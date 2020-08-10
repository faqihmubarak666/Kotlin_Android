package com.example.ktn_ak01c01tictactoegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            play_button -> toPlayActivity()
        }
    }

    fun toPlayActivity() {
        val intent = Intent(this, PlayActivity::class.java)
        intent.putExtra(FISRT_PLAYER_ONE, input_playerOne.text.toString())
        intent.putExtra(FISRT_PLAYER_TWO, input_playerTwo.text.toString())
        startActivity(intent)
    }

}