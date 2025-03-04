package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.RegistrationRequestDto;
import com.fomov.road_rules_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegistrationMapper {
    User toEntity(RegistrationRequestDto registrationRequestDto);

    RegistrationRequestDto toRegistrationRequestDto(User user);
}