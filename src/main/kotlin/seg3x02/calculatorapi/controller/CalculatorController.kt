package seg3x02.calculatorapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/calculator")
class CalculatorController {

    @GetMapping("/add/{a}/{b}")
    fun add(@PathVariable a: Double, @PathVariable b: Double) = a + b

    @GetMapping("/subtract/{a}/{b}")
    fun subtract(@PathVariable a: Double, @PathVariable b: Double) = a - b

    @GetMapping("/multiply/{a}/{b}")
    fun multiply(@PathVariable a: Double, @PathVariable b: Double) = a * b

    @GetMapping("/divide/{a}/{b}")
    fun divide(@PathVariable a: Double, @PathVariable b: Double): Double {
        require(b != 0.0) { "Division by zero is not allowed" }
        return a / b
    }
}
