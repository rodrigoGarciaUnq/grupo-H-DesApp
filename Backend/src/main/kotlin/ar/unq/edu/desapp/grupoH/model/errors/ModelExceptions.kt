package ar.unq.edu.desapp.grupoH.model.errors

open class PricePerHabitantOutOfRange(val exMessage: String): Exception(exMessage)

open class PercentageToCompleteProjectOutOfRange(val exMessage: String): Exception(exMessage)

open class ProjectNotFound(val exMessage: String) : Exception(exMessage)


