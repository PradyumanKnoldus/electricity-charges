case class ElectricityCharges ( accountNumber: Int ,
                                accountUsername: String ,
                                address: String,
                                previousUnit: Int,
                                currentUnit: Int ,
                                gstCharges: Double = 0.18 ) {

  if (previousUnit < 0 || currentUnit < 0 || currentUnit < previousUnit) throw new IllegalArgumentException("Invalid Unit Values")

  // To Calculate total Electricity Bill Amount
  def calculateBill(): Double = {

    val totalUnitsConsumed: Int = currentUnit - previousUnit

    val billAmount: Double = {
      if (totalUnitsConsumed <= 250) totalUnitsConsumed * 5.25
      else if (totalUnitsConsumed <= 450) 250 * 5.25 + (totalUnitsConsumed - 250) * 6.75
      else 250 * 5.25 + 200 * 6.75 + (totalUnitsConsumed - 450) * 8.50
    }

    val GstAmount: Double = billAmount * gstCharges

    val totalCharges: Double = billAmount + GstAmount

    totalCharges
  }
}

