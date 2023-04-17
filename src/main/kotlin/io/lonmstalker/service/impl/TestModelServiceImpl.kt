package io.lonmstalker.service.impl

import io.lonmstalker.model.TestModel
import io.lonmstalker.repository.RelatedTestModelRepository
import io.lonmstalker.service.TestModelService
import io.smallrye.mutiny.Uni
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TestModelServiceImpl(
    private val relatedTestModelRepository: RelatedTestModelRepository
) : TestModelService {

    override fun findAll(): Uni<List<TestModel>> = TestModel.listAll()

    override fun findByName(name: String): Uni<List<TestModel>> = TestModel.findByName(name)

    override fun save(testModel: TestModel): Uni<TestModel> =
        testModel
            .persistAndFlush<TestModel>()
            .replaceWith(testModel)

    override fun findRelatedTestModel(relatedIds: Collection<UUID>): Uni<List<TestModel>> =
        TestModel
            .list(
                "SELECT t FROM TestModel t JOIN FETCH RelatedTestModel r WHERE r.id IN (:relatedIds)",
                mapOf("relatedIds" to relatedIds)
            )
}