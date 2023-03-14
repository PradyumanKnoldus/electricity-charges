import org.scalatest.funsuite.AnyFunSuite

class ElectricityChargesTests extends AnyFunSuite {

  // Unit Test Cases
  test("ElectricityCharges calculateBill method should calculate the bill correctly") {

    // Test Case when Unit Consumed is less than 250
    val TestCase1 = ElectricityCharges(1, "User1", "Connaught Place", 100, 200)
    assert(TestCase1.calculateBill() == 619.5)

    // Test Case when Unit Consumed is between 250 and 450
    val TestCase2 = ElectricityCharges(2, "User2", "Gole Market", 400, 700)
    assert(TestCase2.calculateBill() == 1947)

    // Test Case to check if Unit Consumed is more than 450
    val TestCase3 = ElectricityCharges(3, "User3", "Mandir Marg", 5062, 5904)
    assert(TestCase3.calculateBill() == 7073.51)

    // Test Case when no Unit Consumed
    val TestCase4 = ElectricityCharges(4, "User4", "Connaught Place", 900, 900)
    assert(TestCase4.calculateBill() == 0)

    // Negative test case
    assertThrows[IllegalArgumentException] {
      ElectricityCharges(5, "User5", "Peshwa Road", 200, 100)
    }

    assertThrows[IllegalArgumentException] {
      ElectricityCharges(6, "User6", "Peshwa Road", -100, 0)
    }

  }
}

