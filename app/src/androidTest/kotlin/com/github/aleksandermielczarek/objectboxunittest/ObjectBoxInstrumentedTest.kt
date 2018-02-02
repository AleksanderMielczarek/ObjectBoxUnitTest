package com.github.aleksandermielczarek.objectboxunittest

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Aleksander Mielczarek on 02.02.2018.
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class ObjectBoxInstrumentedTest {

    @JvmField
    @Rule
    val objectBoxRule = InstrumentedObjectBoxRule()

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