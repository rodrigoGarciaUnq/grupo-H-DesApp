package ar.unq.edu.desapp.grupoH.model

import ar.unq.edu.desapp.grupoH.model.CrowdfundingProject
import ar.unq.edu.desapp.grupoH.model.User
import java.time.LocalDate

class Point(val user: User, val comment: String, val value: Int, val date: LocalDate, val project: CrowdfundingProject) {
}