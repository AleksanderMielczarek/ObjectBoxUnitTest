package com.github.aleksandermielczarek.objectboxunittest

import io.objectbox.Box
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.io.File

/**
 * Created by Aleksander Mielczarek on 01.02.2018.
 */
class ObjectBoxRule : TestRule {

    lateinit var orderBox: Box<Order>

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                val tempFile = File.createTempFile("object-store-test", "")
                tempFile.delete()
                val boxStore = MyObjectBox.builder().directory(tempFile).build()
                orderBox = boxStore.boxFor(Order::class.java)

                base.evaluate()

                boxStore.close()
                boxStore.deleteAllFiles()
            }
        }
    }
}
