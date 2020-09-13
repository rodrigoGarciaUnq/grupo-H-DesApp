package ar.unq.edu.desapp.grupoH.modelTesting

import ar.unq.edu.desapp.grupoH.model.PaymentMethod
import ar.unq.edu.desapp.grupoH.model.errors.ProjectNotFound
import ar.unq.edu.desapp.grupoH.modelTesting.helpersAndData.ModelDataTesting
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail


class UserTest {

    var data = ModelDataTesting()

    @Test
    fun makeDonnationTest(){
        data.users.user1
                .makeDonation(PaymentMethod.DebitCard,1500,data.towns.town1,"Donacion de 1500$")

        Assert.assertEquals(4500, data.users.user1.pointList.first().value)
    }

    @Test
    fun makeDonnationToInexistentTownProjectTest(){
        try{
        data.users.user1
                .makeDonation(PaymentMethod.DebitCard,20,data.towns.town4,"Donacion de 20$")
            fail("was expected an error about project not found")
        }catch (ex: ProjectNotFound){
            Assert.assertEquals("Aun no existe un proyecto para la localidad indicada", ex.exMessage)
        }
    }

    @Test
    fun totalPointsValueTest(){
        data.users.user1
                .makeDonation(PaymentMethod.DebitCard,1500,data.towns.town1,"Donacion de 1500$")

        data.users.user1
                .makeDonation(PaymentMethod.DebitCard,500,data.towns.town1,"Donacion de 1500$")

        Assert.assertEquals(5500, data.users.user1.totalPointsValue())
    }

    @Test
    fun moreThanOneProjectParticipationTest(){
        Assert.assertEquals(false, data.users.user1.moreThanOneProjectParticipation())

        data.users.user1
                .makeDonation(PaymentMethod.DebitCard,1500,data.towns.town1,"Donacion de 1500$")

        Assert.assertEquals(false, data.users.user1.moreThanOneProjectParticipation())

        data.users.user1
                .makeDonation(PaymentMethod.DebitCard,1500,data.towns.town2,"Donacion de 1500$")

        data.users.user1
                .makeDonation(PaymentMethod.DebitCard,1500,data.towns.town3,"Donacion de 1500$")

        Assert.assertTrue(data.users.user1.moreThanOneProjectParticipation())
    }




}