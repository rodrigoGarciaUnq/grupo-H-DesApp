package ar.unq.edu.desapp.grupoH.model

import java.time.LocalDate
import java.util.*

class Donation(val date: LocalDate?, val paymentMethod: PaymentMethod,
               val amount: Int, val to: Town, val from: String, val comment: String) {
}