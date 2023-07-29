package model

class Tracciamento(var id: Int, var distanza: Float, var velocita: Float, var dislivello: Int,
                   private var dataOraInizio: Long, private var dataOraFine: Long, var pistaNome: String, var pistaDifficolta: String) {
    fun getDurationString(): String {
        val seconds = this.dataOraFine - this.dataOraInizio

        val minutes = seconds / 60
        val remainingSeconds = seconds % 60

        val formattedMinutes = String.format("%02d", minutes)
        val formattedSeconds = String.format("%02d", remainingSeconds)

        return "$formattedMinutes:$formattedSeconds"
    }
}