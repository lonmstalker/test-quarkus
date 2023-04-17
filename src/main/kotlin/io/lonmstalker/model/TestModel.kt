package io.lonmstalker.model

import io.quarkus.hibernate.reactive.panache.kotlin.PanacheCompanionBase
import io.quarkus.hibernate.reactive.panache.kotlin.PanacheEntityBase
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "test_model")
data class TestModel @JvmOverloads constructor(
    @field:Id var id: UUID? = null,

    var name: String? = null,

    @field:OneToMany(mappedBy = "testModel", targetEntity = RelatedTestModel::class)
    var relatedTestModel: List<RelatedTestModel> = listOf()
) : PanacheEntityBase {

    companion object : PanacheCompanionBase<TestModel, UUID> {
        fun findByName(name: String) = list("name", name)
    }
}