package io.lonmstalker.mapper

import io.lonmstalker.dto.TestDto
import io.lonmstalker.model.TestModel
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.NullValuePropertyMappingStrategy
import java.util.UUID

@Mapper(
    componentModel = "cdi",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    imports = [UUID::class]
)
interface TestMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    fun toModel(testDto: TestDto): TestModel

    fun toDto(testModel: TestModel): TestDto
}