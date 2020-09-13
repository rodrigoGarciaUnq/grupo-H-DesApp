package ar.unq.edu.desapp.grupoH.model

import java.time.LocalDate

object PointsSystem {

    fun pointValueAccordingToAmount(amount: Int) : Int{
        var pointValue = 0
        if(amount > 1000){
            pointValue = amount
        }
        return pointValue
    }

    fun pointValueAccordingToPopulation(place: Town, amount: Int): Int{
        var pointValue = 0
        if (place.population < 2000){
            pointValue = amount * 2
        }
        return pointValue
    }

    fun pointValueAccordintToProjectsParticipations(user: User): Int{
        var pointValue = 0
        if (user.moreThanOneProjectParticipation()){
            pointValue = 500
        }
        return pointValue
    }

    fun pointGenerator(user: User, comment: String, amount: Int, place: Town,
                     date: LocalDate, project: CrowdfundingProject): Point {
        val valueTotalPoint =
                pointValueAccordingToAmount(amount) +
                        pointValueAccordingToPopulation(place, amount) +
                        pointValueAccordintToProjectsParticipations(user)

        return Point(user, comment, valueTotalPoint, date, project)

    }


}