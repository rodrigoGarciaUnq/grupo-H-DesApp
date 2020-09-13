package ar.unq.edu.desapp.grupoH.modelTesting

import ar.unq.edu.desapp.grupoH.model.errors.PercentageToCompleteProjectOutOfRange
import ar.unq.edu.desapp.grupoH.model.errors.PricePerHabitantOutOfRange
import ar.unq.edu.desapp.grupoH.modelTesting.helpersAndData.ModelDataTesting
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class CrowdfundingTest {

    var data = ModelDataTesting()



    @Test
    fun projectWithInvalidPricePerHabitant(){
        try{
            data.projects.project1.changePricePerHabitant(200000)
            fail("was expected an error about price out of range")
        }catch (ex: PricePerHabitantOutOfRange){
            Assert.assertEquals("El monto por habitante excede el limite aceptado", ex.exMessage)
        }
    }

    @Test
    fun projectWithInvalidPercentageToCompleteProject(){
        try{
            data.projects.project1.changePercentageNeeded(30)
            fail("was expected an error about percentage out of range")
        }catch (ex: PercentageToCompleteProjectOutOfRange){
            Assert.assertEquals("El porcentaje requerido excede el limite aceptado", ex.exMessage)
        }
    }


}