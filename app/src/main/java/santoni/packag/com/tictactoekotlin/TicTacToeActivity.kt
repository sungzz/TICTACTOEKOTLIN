package santoni.packag.com.tictactoekotlin

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageView
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_tic_tac_toe.*

class TicTacToeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)
    }

    fun imageButtonTap(view: View){

        val selectedImageButton: ImageButton = view as ImageButton

        when (selectedImageButton.id) {

            R.id.imgbutton1 -> tableLayout.setBackgroundColor(Color.YELLOW)
        }


    }

}
