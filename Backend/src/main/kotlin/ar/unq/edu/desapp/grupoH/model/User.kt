package ar.unq.edu.desapp.grupoH.model

import ar.unq.edu.desapp.grupoH.model.registerMethods.ManualRegister
import ar.unq.edu.desapp.grupoH.model.registerMethods.RegisterMethod
import java.time.LocalDate

class User(var registerMethod: ManualRegister) {

    //TODO (registerMethod deberia ser de la clase abstracta)

    var pointList: MutableList<Point> = emptyList<Point>().toMutableList()
    var username: String = this.registerMethod.username!!
    var nick: String = this.registerMethod.nick!!

    fun makeDonation(paymentMethod: PaymentMethod, amount: Int, to: Town, comment: String){
        var projectTo : CrowdfundingProject = ProjectSearcher.findProject(to)

        val newDonation = Donation(LocalDate.now(), paymentMethod, amount,to ,this.nick, comment)

        projectTo.recieveDonation(newDonation)

        pointList.add(PointsSystem.pointGenerator(this,comment,amount,to, LocalDate.now(), projectTo))
    }

    fun moreThanOneProjectParticipation(): Boolean{
        var multiProjectDonor = false
        if(pointList.isNotEmpty()){
            val firstPointProject = pointList.first().project.name
            multiProjectDonor = pointList.find { it.project.name != firstPointProject } != null
        }
        return multiProjectDonor
    }

    fun totalPointsValue(): Int{
        var pointsValue = 0

        for (p in this.pointList){
            pointsValue += p.value
        }

        return pointsValue
    }



}