/***************************************************************************************************
 * ApplicationDialog
 * Classe che contiene metodi per la creazione di Dialog specifici per la nostra app, basati sul
 * Dialog previsto da Android Compat.
 **************************************************************************************************/

package utility

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import it.omarkiarafederico.skitracker.R

const val ALERT_ERROR = "Errore"
const val ALERT_INFO = "Informazione"
const val ALERT_QUESTION = "Domanda"

class ApplicationDialog(private val context: Context) {
    /*
    definizione del listener del dialog: questo serve per i dialoghi che richiedono l'input diretto
    dall'utente: si mette in attesa di questo e, quando egli risponde, è in grado di intercettare l'evento
    e, in base a cosa ha risposto, di attivare una certa funzione.
    */
    private lateinit var yesNoListener: YesNoDialogListener

    interface YesNoDialogListener {
        fun onYesClicked()
        fun onNoClicked()
    }

    /*
    Crea un dialog avente un titolo e un messaggio personalizzato.
    Con l'attributo autoclose è possibile decidere se la chiusura del dialog comporta la chiusura
    dell'applicazione.
     */
    fun openDialog(type:String, msg: String, activityContext: AppCompatActivity, autoclose: Boolean) {
        val builder = AlertDialog.Builder(activityContext)

        builder.setTitle(type)
        builder.setMessage(msg)
        builder.setPositiveButton("OK") { _, _ ->
            if (autoclose)
                activityContext.finish()
        }

        val dialog = builder.create()
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }

    fun openYesNoDialog(msg: String, activityContext: AppCompatActivity) {
        val builder = AlertDialog.Builder(activityContext)

        builder.setTitle(ALERT_QUESTION)
        builder.setMessage(msg)
        builder.setPositiveButton(context.getString(R.string.yes)) { dialog, _ ->
                yesNoListener.onYesClicked()
                dialog.dismiss()
            }
        builder.setNegativeButton(context.getString(R.string.no)) { dialog, _ ->
                yesNoListener.onNoClicked()
                dialog.dismiss()
            }

        val dialog = builder.create()
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }

    fun setListener(listener: YesNoDialogListener) {
        this.yesNoListener = listener
    }
}