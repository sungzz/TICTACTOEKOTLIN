package santoni.packag.com.tictactoekotlin

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageView
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_tic_tac_toe.*
import java.lang.Exception

class  TicTacToeActivity : AppCompatActivity() {

    enum class PLAYINGPLAYER{
        FIRST_PLAYER,
        SECOND_PLAYER
    }

    enum class WINNER_OF_GAME {

        PLAYER_ONE,
        PLAYER_TWO,
        NO_ONE

    }

    // Instance Variables

    var playingPlayer: PLAYINGPLAYER? = null
    var winnerOfGame: WINNER_OF_GAME? = null

    var player1Options: ArrayList<Int> = ArrayList()
    var player2Options: ArrayList<Int> = ArrayList()
    var allDisabledImages: ArrayList<ImageButton> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)


        try {

            startService(Intent(this@TicTacToeActivity, SoundService::class.java))

        } catch (e: Exception) {
            e.printStackTrace()
        }

        playingPlayer = PLAYINGPLAYER.FIRST_PLAYER
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

    fun action(optionNumber: Int, _selectedImageButton: ImageButton) {

        var selectedImageButton = _selectedImageButton

        if (playingPlayer == PLAYINGPLAYER.FIRST_PLAYER) {

            selectedImageButton.setImageResource(R.drawable.x_letter)
            player1Options.add(optionNumber)
            selectedImageButton.isEnabled = false
            allDisabledImages.add(selectedImageButton)
            playingPlayer = PLAYINGPLAYER.SECOND_PLAYER

        }
        if (playingPlayer == PLAYINGPLAYER.SECOND_PLAYER) {

//            selectedImageButton.setImageResource(R.drawable.o_letter)
//            player2Options.add(optionNumber)
//            selectedImageButton.isEnabled = false
//            allDisabledImages.add(selectedImageButton)
//            playingPlayer = PLAYINGPLAYER.FIRST_PLAYER

            var notSelectedImageNumbers = ArrayList<Int>()

            for (imageNumber in 1..9) {

                if (!(player1Options.contains(imageNumber))){

                    if (!player2Options.contains(imageNumber)) {

                        notSelectedImageNumbers.add(imageNumber)
                    }
                }

            }

            try {

                var randomNumber = ((Math.random() * notSelectedImageNumbers.size)).toInt()
                var imageNumber = notSelectedImageNumbers[randomNumber]
                when (imageNumber) {

                    1-> selectedImageButton = imgbutton1
                    2-> selectedImageButton = imgbutton2
                    3-> selectedImageButton = imgbutton3
                    4-> selectedImageButton = imgbutton4
                    5-> selectedImageButton = imgbutton5
                    6-> selectedImageButton = imgbutton6
                    7-> selectedImageButton = imgbutton7
                    8-> selectedImageButton = imgbutton8
                    9-> selectedImageButton = imgbutton9
                }
                selectedImageButton.setImageResource(R.drawable.o_letter)
                player2Options.add(imageNumber)
                selectedImageButton.isEnabled = false
                allDisabledImages.add(selectedImageButton)
                playingPlayer = PLAYINGPLAYER.FIRST_PLAYER


            } catch (e: Exception) {

                e.printStackTrace()
            }

        }

        specifyTheWinnerOfGame()


    }

    private fun specifyTheWinnerOfGame() {

        if (player1Options.contains(1)
                && player1Options.contains(2)
                && player1Options.contains(3)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if (player2Options.contains(1)
                && player2Options.contains(2)
                && player2Options.contains(3)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if (player1Options.contains(4)
                && player1Options.contains(5)
                && player1Options.contains(6)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if (player2Options.contains(4)
                && player2Options.contains(5)
                && player2Options.contains(6)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if (player1Options.contains(7)
                && player1Options.contains(8)
                && player1Options.contains(9)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if (player2Options.contains(7)
                && player2Options.contains(8)
                && player2Options.contains(9)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if (player1Options.contains(1)
                && player1Options.contains(5)
                && player1Options.contains(9)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if (player2Options.contains(1)
                && player2Options.contains(5)
                && player2Options.contains(9)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if (player1Options.contains(1)
                && player1Options.contains(4)
                && player1Options.contains(7)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if (player2Options.contains(1)
                && player2Options.contains(4)
                && player2Options.contains(7)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if (player1Options.contains(2)
                && player1Options.contains(5)
                && player1Options.contains(8)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if (player2Options.contains(2)
                && player2Options.contains(5)
                && player2Options.contains(8)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if (player1Options.contains(3)
                && player1Options.contains(5)
                && player1Options.contains(7)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if (player2Options.contains(3)
                && player2Options.contains(5)
                && player2Options.contains(7)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if (player1Options.contains(3)
                && player1Options.contains(6)
                && player1Options.contains(9)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if (player2Options.contains(3)
                && player2Options.contains(6)
                && player2Options.contains(9)) {

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }


        if (winnerOfGame == WINNER_OF_GAME.PLAYER_ONE) {

            createAlert("Player One Wins", "Congratulations to Player 1",
                    AlertDialog.BUTTON_POSITIVE, "OK", false)
            return

        } else if (winnerOfGame == WINNER_OF_GAME.PLAYER_TWO) {

            createAlert("Player Two Wins", "Congratulations to Player 2",
                    AlertDialog.BUTTON_POSITIVE, "OK", false)
            return

        }
        checkDrawState()

    }

    private fun createAlert(title: String, message: String, whichButton: Int,
                            buttonText: String, cancelable: Boolean) {

        val alertDialog: AlertDialog = AlertDialog.Builder(this@TicTacToeActivity).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)

        alertDialog.setButton(whichButton, buttonText, {
            dialog: DialogInterface?, which: Int ->

            resetGame()

        })
        alertDialog.setCancelable(cancelable)
        alertDialog.show()

    }

    private fun resetGame() {

        player1Options.clear()
        player2Options.clear()
        allDisabledImages.clear()
        winnerOfGame = WINNER_OF_GAME.NO_ONE
        playingPlayer = PLAYINGPLAYER.FIRST_PLAYER

        imgbutton1.setImageResource(R.drawable.place_holder)
        imgbutton2.setImageResource(R.drawable.place_holder)
        imgbutton3.setImageResource(R.drawable.place_holder)
        imgbutton4.setImageResource(R.drawable.place_holder)
        imgbutton5.setImageResource(R.drawable.place_holder)
        imgbutton6.setImageResource(R.drawable.place_holder)
        imgbutton7.setImageResource(R.drawable.place_holder)
        imgbutton8.setImageResource(R.drawable.place_holder)
        imgbutton9.setImageResource(R.drawable.place_holder)

        imgbutton1.isEnabled = true
        imgbutton2.isEnabled = true
        imgbutton3.isEnabled = true
        imgbutton4.isEnabled = true
        imgbutton5.isEnabled = true
        imgbutton6.isEnabled = true
        imgbutton7.isEnabled = true
        imgbutton8.isEnabled = true
        imgbutton9.isEnabled = true

    }

    private fun checkDrawState() {

        if (allDisabledImages.size == 9 && winnerOfGame != WINNER_OF_GAME.PLAYER_ONE &&
                winnerOfGame != WINNER_OF_GAME.PLAYER_TWO) {

            createAlert("DRAW !!!", "No one won the game!",
                    AlertDialog.BUTTON_POSITIVE, "OK", false)

        }
    }
}
