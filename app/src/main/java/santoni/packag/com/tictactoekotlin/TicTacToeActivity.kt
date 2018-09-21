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
        var randomNumber = (Math.random() * 9 + 1).toInt()

        when (randomNumber) {

            1 -> tableLayout.setBackgroundColor(Color.YELLOW)
            2 -> tableLayout.setBackgroundColor(Color.DKGRAY)
            3 -> tableLayout.setBackgroundColor(Color.GREEN)
            4 -> tableLayout.setBackgroundColor(Color.LTGRAY)
            5 -> tableLayout.setBackgroundColor(Color.CYAN)
            6 -> tableLayout.setBackgroundColor(Color.MAGENTA)
            7 -> tableLayout.setBackgroundColor(Color.RED)
            8 -> tableLayout.setBackgroundColor(Color.BLUE)
            9 -> tableLayout.setBackgroundColor(Color.WHITE)
        }

        var optionNumber = 0

        when (selectedImageButton.id) {

            R.id.imgbutton1 -> optionNumber = 1
            R.id.imgbutton2 -> optionNumber = 2
            R.id.imgbutton3 -> optionNumber = 3
            R.id.imgbutton4 -> optionNumber = 4
            R.id.imgbutton5 -> optionNumber = 5
            R.id.imgbutton6 -> optionNumber = 6
            R.id.imgbutton7 -> optionNumber = 7
            R.id.imgbutton8 -> optionNumber = 8
            R.id.imgbutton9 -> optionNumber = 9

        }

        action(optionNumber, selectedImageButton)
    }

    fun action(optionNumber: Int, selectedImageButton: ImageButton) {




    }
}
