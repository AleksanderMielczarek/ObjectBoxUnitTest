package com.github.aleksandermielczarek.objectboxunittest

import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

/**
 * Created by Aleksander Mielczarek on 01.02.2018.
 */
class ObjectBoxTest {

    @JvmField
    @Rule
    val objectBoxRule = ObjectBoxRule()

    @Test
    fun shouldSaveOrder() {
        val order = Order(name = "Order")
        val customer = Customer(name = "Customer")
        order.customer.target = customer

        objectBoxRule.orderBox.put(order)

        assertTrue(objectBoxRule.orderBox.all.any { it.name == "Order" })
        assertTrue(objectBoxRule.orderBox.all.any { it.customer.target.name == "Customer" })
    }
}