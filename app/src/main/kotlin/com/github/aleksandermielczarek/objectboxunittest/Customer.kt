package com.github.aleksandermielczarek.objectboxunittest

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Created by Aleksander Mielczarek on 01.02.2018.
 */
@Entity
data class Customer(@Id var id: Long = 0, var name: String = "")