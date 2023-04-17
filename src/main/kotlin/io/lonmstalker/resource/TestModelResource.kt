package io.lonmstalker.resource

import io.lonmstalker.dto.TestDto
import io.lonmstalker.mapper.TestMapper
import io.lonmstalker.service.TestModelService
import io.smallrye.mutiny.Uni
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/test")
class TestModelResource(
    private val testMapper: TestMapper,
    private val testModelService: TestModelService,
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun findByName(@QueryParam("name") name: String): Uni<List<TestDto>> =
        this.testModelService
            .findByName(name)
            .map { it.map { this.testMapper.toDto(it) } }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll(): Uni<List<TestDto>> =
        this.testModelService
            .findAll()
            .map { it.map { this.testMapper.toDto(it) } }

    @POST
    @Path("/join")
    @Produces(MediaType.APPLICATION_JSON)
    fun join(ids: Collection<UUID>): Uni<List<TestDto>> =
        this.testModelService
            .findRelatedTestModel(ids)
            .map { it.map { this.testMapper.toDto(it) } }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun insert(testModel: TestDto): Uni<TestDto> =
        this.testModelService
            .save(this.testMapper.toModel(testModel))
            .map { this.testMapper.toDto(it) }
}