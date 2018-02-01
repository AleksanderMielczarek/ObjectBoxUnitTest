package com.github.aleksandermielczarek.objectboxunittest

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

/**
 * Created by Aleksander Mielczarek on 01.02.2018.
 */
@Entity
class Order(@Id var id: Long = 0, var name: String = "") {
    lateinit var customer: ToOne<Customer>
}
