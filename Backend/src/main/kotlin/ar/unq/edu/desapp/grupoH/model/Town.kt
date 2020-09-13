package ar.unq.edu.desapp.grupoH.model

import ar.unq.edu.desapp.grupoH.model.states.ConnectionState

class Town(val id: Int, val name: String, val province: String, val population: Int) {

    var connectionState: ConnectionState = ConnectionState.Disconnected
    var donorList: MutableList<String> = emptyList<String>().toMutableList()

    fun setConnectedState() {
        this.connectionState = ConnectionState.Connected
    }

    fun addDonor(userNick: String){ // Es anonima la donacion.
        this.donorList.add(userNick)
    }

    fun changeStateToConnecting(){
        this.connectionState = ConnectionState.Connecting
    }

}