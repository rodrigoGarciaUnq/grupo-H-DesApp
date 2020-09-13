package ar.unq.edu.desapp.grupoH.modelTesting.helpersAndData

import ar.unq.edu.desapp.grupoH.model.CrowdfundingProject

class CrowdfundingProjectData {

    var townData = TownData()

    var project1 = CrowdfundingProject("project1", townData.town1)

    var project2 = CrowdfundingProject("project2", townData.town2)

    var project3 = CrowdfundingProject("project3", townData.town3)
}